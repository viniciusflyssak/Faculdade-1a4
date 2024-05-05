Algoritmo "CalculadoraSalario"
// Descrição   : Define o novo valor do salário de um funcionário, calculando
// seu acréscimo.
// Autor(a)    : Vinicius Flyssak
// Data atual  : 04/10/2021

Var
  Salario: Real;
   
Inicio

  Escreva("Informe o salário: ")
  Leia(Salario)
  Se Salario > 500 entao
    Salario := Salario + (Salario * 0.10)
  Senao
    Salario := Salario + (Salario * 0.20)
  FimSe
  Escreva("Seu novo salário é ", Salario, " reais.")

Fimalgoritmo