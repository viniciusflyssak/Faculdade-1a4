/* Exemplo de uso da biblioteca math.h
  Programa para extra��o de d�gitos de um n�mero
*/

#include <stdio.h> //Biblioteca de fun��es - cont�m as fun��es scanf() e printf()
#include <stdlib.h>

int main() //fun��o principal - �nica
{ //marca o in�cio do bloco de instru��es, neste caso, in�cio do algoritmo

    int num, digito1, digito2, digito3;
    printf("Informe um numero inteiro de 3 digitos: ");
    scanf("%d", &num);

    digito1 = (num / 100);
    digito2 = (num % 100) / 10;
    digito3 = (num % 100) % 10;

    printf("\nDigitos do numero informado: %d, %d, %d", digito1, digito2, digito3);

    return 0; // Instru��o
} //marca o fim do bloco de instru��es

