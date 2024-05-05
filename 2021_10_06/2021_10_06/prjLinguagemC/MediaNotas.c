/* Fazer um programa para solicitar duas notas de um aluno
  e realizar o c�lculo da m�dia simples entre as notas
  para ent�o apresentar o resultado para o aluno */

#include <stdio.h> //Biblioteca de fun��es - cont�m as fun��es scanf() e printf()
#include <stdlib.h>

//Exemplo de programa para c�lculo de m�dia de duas notas

int main() //fun��o principal - �nica
{ //marca o in�cio do bloco de instru��es, neste caso, in�cio do algoritmo
    //Declara��o de vari�veis
    float nota1, nota2, media;

    //Entrada de dados
    printf("Informe a primeira nota: "); //Instru��o
    scanf("%f", &nota1); //Instru��o
    printf("Informe a segunda nota: "); //Instru��o
    scanf("%f", &nota2); //Instru��o

    //Processamento dos dados
    media = (nota1 + nota2) / 2; // Instru��o

    //Sa�da dos dados
    printf("\nMedia: %.2f", media); // Instru��o

    return 0; // Instru��o
} //marca o fim do bloco de instru��es
