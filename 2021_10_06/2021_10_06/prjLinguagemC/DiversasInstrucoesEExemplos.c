/* Exemplos diversos de instru��es e uso de fun��es na linguagem C */

#include <stdio.h> //Biblioteca de fun��es - cont�m as fun��es scanf() e printf()
#include <stdlib.h>

//Declara��o de constante
#define CIDADE "Pato Branco"

int main() //fun��o principal - �nica
{ //marca o in�cio do bloco de instru��es, neste caso, in�cio do algoritmo

    /*Exemplo de precis�o em float e double - tipos de dados para valores num�ricos com casas
    decimais*/
    float pi = 3.1415926535897932;
    //real de precis�o dupla - aprox. 15 casas decimais
    double piDouble = 3.1415926535897932;
    //A precis�o das casas decimais se perde ap�s aprox. 6 casas
    printf("Valor de pi %.16f\n", pi);
    //A precis�o das casas decimais se perde ap�s aprox. 15 casas
    printf("Valor de pi mais preciso %.16lf\n", piDouble);

    //Para saber o tamanho de um tipo de dado em seu computador
    //Quantidade de mem�ria necess�ria para seu armazenamento
    printf("\nTamanho do tipo int: %d bytes \n", sizeof(int));
    printf("Tamanho do tipo char: %d bytes \n", sizeof(char));
    printf("Tamanho do tipo float: %d bytes \n", sizeof(float));
    printf("Tamanho do tipo double: %d bytes \n", sizeof(double));

    //Modelador de tipo (type cast/ casting)
    int num = 10;
    float resultado;
    //Sem o modelador - a Linguagem C faz uma divis�o inteira entre 10 e 7.
    //O resultado � um inteiro convertido para float
    resultado = num / 7;
    printf("\nResultado: %f", resultado);

    //Com o modelador - num � transformada em float (10.0) e dividido por 7 (inteiro)
    //O resultado � float porque um dos divisores � do tipo float
    resultado = (float) num / 7;
    printf("\nResultado: %f\n", resultado);


    //Exemplo de uso de uma constante do tipo texto
    printf("\nConstante Cidade: %s", CIDADE);

    //Exemplos de entrada e sa�da de valores
    int idade;
    char letra;
    int dia, mes, ano;

    //Entrada de um inteiro
    printf("\n\nDigite sua idade: ");
    scanf("%d", &idade);

    //Entrada de texto
    printf("Digite a primeira letra do seu nome: ");
    scanf(" %c", &letra);

    //Entrada de inteiros para compor uma data
    printf("Digite sua data de nascimento no formato dd/mm/aaaa: ");
    scanf("%d/%d/%d", &dia, &mes, &ano);

    //Exemplo de sa�da de inteiros:
    printf("\nA idade digitada foi: %d\n", idade);
    printf("%5d \n", idade); //exibe "   15"
    printf("%05d \n", idade); //exibe "00015"
    printf("%-5d \n", idade); //exibe "15   "

    //Exemplo de sa�da de caracteres:
    printf("A letra informada foi %c \n", letra);
    printf("%5c \n", letra); //exibe "    a"
    printf("%-5c \n", letra); //exibe "a    "

    //Exemplo de sa�da de data
    printf("A data digitada foi: %02d/%02d/%04d\n", dia, mes, ano);


    //Exemplo de sa�da de n�meros reais (float)
    float numR;
    printf("\nInforme um numero real: ");
    scanf("%f", &numR);
    printf("O valor informado com 2 casas decimais eh: %.2f", numR);
    printf("\nO valor informado com 5 casas decimais eh: %.5f", numR);
    printf("\nO valor informado com 9 inteiros e 5 casas decimais eh: %9.5f", numR);
    printf("\nO valor informado com 9 inteiros e 1 casa decimal eh: %9.1f", numR);


    //Exemplo de sa�da de n�meros reais (double)
    float numD;
    printf("\n\nInforme um numero real longo: ");
    scanf("%f", &numD);
    printf("O valor informado com 2 casas decimais eh: %.2lf", numD);
    printf("\nO valor informado com 5 casas decimais eh: %.5lf", numD);
    printf("\nO valor informado com 9 inteiros e 5 casas decimais eh: %9.5lf", numD);
    printf("\nO valor informado com 9 inteiros e 1 casa decimal eh: %9.1lf", numD);

    //Exemplo de sa�da em decimal, hexadecimal, octal e caractere
    //Impress�o de um caracter (letra A) de diferentes formas
    printf("\n\n Impressao do caracter A maiusculo em decimal (65), hexadecimal, octal e caractere");
    printf("\n%d", 65); // A mai�sculo tem o valor 65 na tabela ASCII
    printf("\n%x", 65);
    printf("\n%o", 65);
    printf("\n%c", 65);

    //Exemplo de sa�da de um caracter em decimal, hexadecimal, octal e caractere
    printf("\n\n Impress�ao do caracter a min�sculo em decimal, hexadecimal, octal e caractere ('a')");
    printf("\n%d", 'a');
    printf("\n%x", 'a');
    printf("\n%o", 'a');
    printf("\n%c", 'a');

    //Operadores aritm�ticos - resto da divis�o
    int resto;
    resto = num % 2; //operador de resto � o %
    printf("\n\nO resto da divisao de %d por 2 eh: %d", num, resto);
    resto = num % 10; //operador de resto � o %
    printf("\nO resto da divisao de %d por 10 eh: %d", num, resto);

    //Operadores de incremento e decremento
    int x = 10, y;
    y = x++; //O operador primeiro atribui o valor 10 para y, para depois incrementar o x em 1
    printf("\n\nO valor de x ap�s x++ eh: %d\n", x);
    printf("\n\nO valor de y incrementando x usando x++ eh: %d\n", y);
    x = 10;
    y = ++x;//O operador primeiro incrementa o x em 1 para depois atribuir o valor 11 para y
    printf("\n\nO valor de y incrementando x usando ++x eh: %d\n", y);

    return 0; // Instru��o
} //marca o fim do bloco de instru��es

