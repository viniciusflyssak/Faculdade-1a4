Algoritmo "Divisao"
//  
//  
// Descri��o   : Realiza a divis�o de dois n�meros, caso o segundo n�mero seja
// diferente de zero
// aprovado ou reprovado
// Autor(a)    : R�bia
// Data atual  : 29/09/2021
Var
// Se��o de Declara��es das vari�veis 
  Num1, Num2, Divisao: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
  //Entrada de dados
  Escreva("Informe dois n�meros: ")
  Leia(Num1)
  Leia(Num2)
  
  //Processamento de dados
  Se Num2 = 0 entao
    //Sa�da de dados
    escreva("N�o � poss�vel realizar divis�o por zero")
  Senao
    Divisao <- Num1 / Num2  //aceita := para atribui��o tamb�m
    //Sa�da de dados
    Escreva("A divis�o do primeiro n�mero pelo segundo �: ", Divisao)
  Fimse
  
Fimalgoritmo