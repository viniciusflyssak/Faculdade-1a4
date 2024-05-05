Algoritmo "Divisao"
//  
//  
// Descrição   : Realiza a divisão de dois números, caso o segundo número seja
// diferente de zero
// aprovado ou reprovado
// Autor(a)    : Rúbia
// Data atual  : 29/09/2021
Var
// Seção de Declarações das variáveis 
  Num1, Num2, Divisao: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
  //Entrada de dados
  Escreva("Informe dois números: ")
  Leia(Num1)
  Leia(Num2)
  
  //Processamento de dados
  Se Num2 = 0 entao
    //Saída de dados
    escreva("Não é possível realizar divisão por zero")
  Senao
    Divisao <- Num1 / Num2  //aceita := para atribuição também
    //Saída de dados
    Escreva("A divisão do primeiro número pelo segundo é: ", Divisao)
  Fimse
  
Fimalgoritmo