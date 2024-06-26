--VIEW 1
CREATE OR REPLACE VIEW V_PEDIDOS AS (SELECT IP.ID_PEDIDO, IP.ID_PIZZA, IP.ID_PRODUTO, IP.QUANTIDADE, SA.DESCRICAO AS DESCRICAO_SABOR,  
									CASE WHEN TP.TAMANHO IS NULL 
										THEN 'Item sem tamanho' 
										ELSE TP.TAMANHO 
									END AS TAMANHO, 
									PE.VALOR_TOTAL AS VALOR_TOTAL_PEDIDO, 
									AD.DESCRICAO AS DESCRICAO_ADICIONAL, AD.VALOR AS VALOR_ADICIONAL
									FROM ITENS_PEDIDOS IP
									LEFT JOIN PIZZAS PI ON PI.ID_PIZZA = IP.ID_PIZZA
									LEFT JOIN TAMANHO_PIZZA TP ON TP.ID_TAMANHO = PI.ID_TAMANHO
									LEFT JOIN SABORES_PIZZAS SP ON SP.ID_PIZZA = IP.ID_PIZZA
									LEFT JOIN SABORES SA ON SA.ID_SABOR = SP.ID_SABOR
									LEFT JOIN ADICIONAIS_ITEM AI ON AI.ID_ITEM_PEDIDO = IP.ID_ITEM_PEDIDO
									LEFT JOIN ADICIONAIS AD ON AD.ID_ADICIONAL = AI.ID_ADICIONAL
									INNER JOIN PEDIDOS PE ON PE.ID_PEDIDO = IP.ID_PEDIDO
									ORDER BY ID_PEDIDO, ID_PIZZA);
									
--VIEW 2									
CREATE OR REPLACE VIEW V_CARDAPIO AS (SELECT SA.DESCRICAO AS SABOR, IG.DESCRICAO AS INGREDIENTES  FROM SABORES SA
									 INNER JOIN INGREDIENTES_SABOR IGS ON IGS.ID_SABOR = SA.ID_SABOR
									 INNER JOIN INGREDIENTES IG ON IG.ID_INGREDIENTE = IGS.ID_INGREDIENTE
									 ORDER BY SABOR);

--FUNCTION 1
CREATE OR REPLACE FUNCTION CADASTRO_CLIENTE(P_NOME_CLIENTE VARCHAR, P_BAIRRO VARCHAR, P_RUA VARCHAR, P_COMPLEMENTO VARCHAR, P_NRO_CASA INT, P_ID_CIDADE INT) RETURNS VARCHAR AS $CADASTRO_CLIENTE$
DECLARE 
	VRESULTADO VARCHAR;
BEGIN
	INSERT INTO CLIENTES (NOME_CLIENTE, BAIRRO, RUA, COMPLEMENTO, NRO_CASA, ID_CIDADE) VALUES (P_NOME_CLIENTE, P_BAIRRO, P_RUA, P_COMPLEMENTO, P_NRO_CASA, P_ID_CIDADE);	
	SELECT 
	CASE WHEN COUNT(ID_CLIENTE) < 1 
		THEN 'FALHOU' 
		ELSE 'SUCESSO' 
	END AS RESULTADO INTO VRESULTADO
	FROM CLIENTES WHERE NOME_CLIENTE = P_NOME_CLIENTE AND BAIRRO = P_BAIRRO AND RUA = P_RUA AND COMPLEMENTO = P_COMPLEMENTO AND NRO_CASA = P_NRO_CASA AND ID_CIDADE = P_ID_CIDADE;
	RETURN VRESULTADO;
EXCEPTION
	WHEN OTHERS THEN
	RETURN 'ERRO';
END;
$CADASTRO_CLIENTE$ LANGUAGE plpgsql;

--FUNCTION 2
CREATE OR REPLACE FUNCTION INSERT_INGREDIENTES_SABOR(P_ID_SABOR INT, P_ID_INGREDIENTE INT) RETURNS VARCHAR AS $INSERT_INGREDIENTES_SABOR$
DECLARE 
	VRESULTADO VARCHAR;
	VQUANTIDADE INT;
	VJA_CADASTRADO BOOLEAN;
BEGIN
	SELECT COUNT(ID_INGREDIENTES_SABOR) INTO VQUANTIDADE FROM INGREDIENTES_SABOR WHERE ID_SABOR = P_ID_SABOR;
	IF (VQUANTIDADE < 5) THEN
		SELECT 
		CASE WHEN COUNT(ID_INGREDIENTES_SABOR) < 1
			THEN FALSE 
			ELSE TRUE   
		END AS RESULTADO INTO VJA_CADASTRADO
		FROM INGREDIENTES_SABOR IGS WHERE ID_SABOR = P_ID_SABOR AND ID_INGREDIENTE = P_ID_INGREDIENTE;
		IF (VJA_CADASTRADO) THEN
			RETURN 'Ingrediente já cadastrado!';
		ELSE
			INSERT INTO INGREDIENTES_SABOR(ID_SABOR, ID_INGREDIENTE) VALUES (P_ID_SABOR, P_ID_INGREDIENTE);
			SELECT 
			CASE WHEN COUNT(ID_INGREDIENTES_SABOR) < 1
				THEN 'FALHOU' 
				ELSE 'SUCESSO' 
			END AS RESULTADO INTO VRESULTADO
			FROM INGREDIENTES_SABOR IGS WHERE ID_SABOR = P_ID_SABOR AND ID_INGREDIENTE = P_ID_INGREDIENTE;
			RETURN VRESULTADO;
		END IF;
	ELSE
		RETURN 'Um sabor não pode possuir mais que 5 ingredientes!';
	END IF;
EXCEPTION
	WHEN OTHERS THEN
	RETURN 'ERRO';
END;
$INSERT_INGREDIENTES_SABOR$ LANGUAGE plpgsql;

--TRIGGER 1
CREATE OR REPLACE FUNCTION VALIDA_FUNCIONARIO() RETURNS TRIGGER AS $VALIDA_FUNCIONARIO$
DECLARE
	VEXISTE BOOLEAN;
	VPROX_COD FUNCIONARIOS.ID_FUNCIONARIO%TYPE;
BEGIN
	SELECT MAX(ID_FUNCIONARIO) INTO VPROX_COD FROM FUNCIONARIOS;	
	IF (NEW.SALARIO <= 5000) THEN	
		SELECT
		CASE WHEN COUNT(ID_FUNCIONARIO) > 0 
			THEN TRUE 
			ELSE FALSE 
		END AS RESULTADO INTO VEXISTE
		FROM FUNCIONARIOS WHERE NOME = NEW.NOME AND ID_PROFISSAO = NEW.ID_PROFISSAO AND BAIRRO = NEW.BAIRRO AND RUA = NEW.RUA AND COMPLEMENTO = NEW.COMPLEMENTO AND NRO_CASA = NEW.NRO_CASA AND ID_CIDADE = NEW.ID_CIDADE AND SALARIO = NEW.SALARIO;
		IF (VEXISTE) AND (NEW.ID_FUNCIONARIO > VPROX_COD) THEN
			RAISE EXCEPTION 'Funcionário já cadastrado!';
		ELSE 
			RAISE NOTICE 'SUCESSO!';
			RETURN NEW;
		END IF;
	ELSE 
		RAISE EXCEPTION 'Funcionário não pode possuir salário superior a 5000 reais!';
	END IF;
END;
$VALIDA_FUNCIONARIO$ LANGUAGE plpgsql;

CREATE TRIGGER TG_VALIDA_FUNCIONARIO
BEFORE INSERT OR UPDATE ON FUNCIONARIOS
FOR EACH ROW EXECUTE PROCEDURE VALIDA_FUNCIONARIO();

--TRIGGER 2
--TABELA PARA LOGS
CREATE TABLE LOG_ENTREGAS(REGISTRO_ANTIGO TEXT NOT NULL, REGISTRO_NOVO TEXT NOT NULL, USUARIO VARCHAR (30) NOT NULL, DATA_HORA TIMESTAMP NOT NULL, OPERACAO CHAR(1) NOT NULL);

CREATE OR REPLACE FUNCTION LOG_ALTERACAO_ENTREGA() RETURNS TRIGGER AS $LOG_ALTERACAO_ENTREGA$
DECLARE 
	VREGISTROOLD TEXT;
	VREGISTRONEW TEXT;
BEGIN
	IF (NEW.ID_ENTREGA IS NOT NULL AND OLD.ID_ENTREGA IS NOT NULL) THEN
		VREGISTROOLD = OLD.ID_ENTREGA ||','|| OLD.ID_PEDIDO || ',' || OLD.ID_FUNCIONARIO ||','|| OLD.TAXA_MOTOBOY || ',' || OLD.DATA_ENTREGA || ',' || OLD.ID_FORMA_PGTO;
		VREGISTRONEW = NEW.ID_ENTREGA ||','|| NEW.ID_PEDIDO || ',' || NEW.ID_FUNCIONARIO ||','|| NEW.TAXA_MOTOBOY || ',' || NEW.DATA_ENTREGA || ',' || NEW.ID_FORMA_PGTO;
		INSERT INTO LOG_ENTREGAS(REGISTRO_ANTIGO, REGISTRO_NOVO, USUARIO, OPERACAO, DATA_HORA) VALUES (VREGISTROOLD, VREGISTRONEW, CURRENT_USER, 'U', CURRENT_TIMESTAMP);
		RAISE NOTICE 'LOG DE UPDATE GRAVADO.';
		RETURN NEW;
	END IF;
	IF (NEW.ID_ENTREGA IS NOT NULL AND OLD.ID_ENTREGA ISNULL) THEN 
		VREGISTROOLD = '-';
		VREGISTRONEW = NEW.ID_ENTREGA ||','|| NEW.ID_PEDIDO || ',' || NEW.ID_FUNCIONARIO ||','|| NEW.TAXA_MOTOBOY || ',' || NEW.DATA_ENTREGA || ',' || NEW.ID_FORMA_PGTO;
		INSERT INTO LOG_ENTREGAS(REGISTRO_ANTIGO, REGISTRO_NOVO, USUARIO, OPERACAO, DATA_HORA) VALUES (VREGISTROOLD, VREGISTRONEW, CURRENT_USER, 'U', CURRENT_TIMESTAMP);
		RAISE NOTICE 'LOG DE INSERT GRAVADO.';
		RETURN NEW;
	END IF;
	--VERIFICA SE FOI FEITA ALGUMA DELEÇÃO
	IF (NEW.ID_ENTREGA ISNULL AND OLD.ID_ENTREGA IS NOT NULL) THEN --TG_OP = 'DELETE'
		VREGISTROOLD = OLD.ID_ENTREGA ||','|| OLD.ID_PEDIDO || ',' || OLD.ID_FUNCIONARIO ||','|| OLD.TAXA_MOTOBOY || ',' || OLD.DATA_ENTREGA || ',' || OLD.ID_FORMA_PGTO;
		VREGISTRONEW = '-';
		INSERT INTO LOG_ENTREGAS(REGISTRO_ANTIGO, REGISTRO_NOVO, USUARIO, OPERACAO, DATA_HORA) VALUES (VREGISTROOLD, VREGISTRONEW, CURRENT_USER, 'U', CURRENT_TIMESTAMP);
		RAISE NOTICE 'LOG DE DELETE GRAVADO';
		RETURN OLD;
	END IF;
END;
$LOG_ALTERACAO_ENTREGA$ LANGUAGE plpgsql;

CREATE TRIGGER TG_LOG_ALTERACAO_ENTREGA BEFORE INSERT OR UPDATE OR DELETE ON ENTREGAS
FOR EACH ROW EXECUTE PROCEDURE LOG_ALTERACAO_ENTREGA();



