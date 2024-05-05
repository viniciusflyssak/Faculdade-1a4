Algoritmo "MediaCondicional"
//  
//  
// Descrição   : Calcula a média de duas notas de um aluno e informa se ele foi
// aprovado ou reprovado
// Autor(a)    : Rúbia
// Data atual  : 29/09/2021
Var
// Seção de Declarações das variáveis 
  Nota1, Nota2, Media: real

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
  //Entrada de dados
  Escreva("Informe a primeira nota: ")
  Leia(Nota1)
  Escreva("Informe a segunda nota: ")
  Leia(Nota2)
  
  //Processamento de dados
  Media <- (Nota1 + Nota2)/2  //aceita := para atribuição também

  //Saída de dados
  Escreva("A média aritmética das notas do aluno é: ", Media)

  Se Media >= 7 entao  //Se a condição for verdadeira, vai executar a instrução abaixo
    escreva(" - Aprovado")
  Senao // Se a condição for falsa, vai executar a instrução abaixo
    escreva(" - Reprovado")
  Fimse

Fimalgoritmo