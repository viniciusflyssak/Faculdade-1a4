/* Exemplo de uso da biblioteca math.h
  Programa para extração de dígitos de um número
*/

#include <stdio.h> //Biblioteca de funções - contém as funções scanf() e printf()
#include <stdlib.h>

int main() //função principal - única
{ //marca o início do bloco de instruções, neste caso, início do algoritmo

    int num, digito1, digito2, digito3;
    printf("Informe um numero inteiro de 3 digitos: ");
    scanf("%d", &num);

    digito1 = (num / 100);
    digito2 = (num % 100) / 10;
    digito3 = (num % 100) % 10;

    printf("\nDigitos do numero informado: %d, %d, %d", digito1, digito2, digito3);

    return 0; // Instrução
} //marca o fim do bloco de instruções

