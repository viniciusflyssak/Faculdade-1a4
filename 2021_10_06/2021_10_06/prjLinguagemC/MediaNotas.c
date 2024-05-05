/* Fazer um programa para solicitar duas notas de um aluno
  e realizar o cálculo da média simples entre as notas
  para então apresentar o resultado para o aluno */

#include <stdio.h> //Biblioteca de funções - contém as funções scanf() e printf()
#include <stdlib.h>

//Exemplo de programa para cálculo de média de duas notas

int main() //função principal - única
{ //marca o início do bloco de instruções, neste caso, início do algoritmo
    //Declaração de variáveis
    float nota1, nota2, media;

    //Entrada de dados
    printf("Informe a primeira nota: "); //Instrução
    scanf("%f", &nota1); //Instrução
    printf("Informe a segunda nota: "); //Instrução
    scanf("%f", &nota2); //Instrução

    //Processamento dos dados
    media = (nota1 + nota2) / 2; // Instrução

    //Saída dos dados
    printf("\nMedia: %.2f", media); // Instrução

    return 0; // Instrução
} //marca o fim do bloco de instruções
