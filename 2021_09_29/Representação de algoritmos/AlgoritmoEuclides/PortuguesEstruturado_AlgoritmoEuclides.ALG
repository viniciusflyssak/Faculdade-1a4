Algoritmo "AlgoritmoEuclides"
//  
//  
// Descrição   : Encontra o Máximo Divisor Comum (MDC) de dois números inteiros
// Autor(a)    : Rúbia
// Data atual  : 29/09/2021
Var
// Seção de Declarações das variáveis 
  Num1, Num2, Resto : inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
  //Entrada de dados
  Escreva("Informe dois números inteiros: ")
  Leia(Num1)
  Leia(Num2)
  
  //Processamento de dados
  Resto <- Num1 % Num2  //% é o operador que calcula o resto da divisão
  
  Enquanto Resto <> 0 faca
    Num1 <- Num2
    Num2 <- Resto
    Resto <- Num1 % Num2
  Fimenquanto

  Escreva("O Máximo Divisor Comum (MDC) dos números informados é: ", Num2)

Fimalgoritmo