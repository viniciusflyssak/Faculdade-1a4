/* Exemplo de uso da biblioteca math.h
  Programa que separa a parte inteira e decimal de um valor em R$
*/

#include <stdio.h> //Biblioteca de fun��es - cont�m as fun��es scanf() e printf()
#include <stdlib.h>
#include <math.h>

int main() //fun��o principal - �nica
{ //marca o in�cio do bloco de instru��es, neste caso, in�cio do algoritmo

    //declara��o de vari�veis
    double num;
    int parteInt, parteDecInt;

    //entrada de dados
    printf("Informe o valor do troco: R$ ");
    scanf("%lf", &num);

    //processamento de dados
    parteInt = (int) num;
    parteDecInt = round((num - (int)num) * 100);

    //sa�da de dados
    printf("\nO valor informado eh %d reais e %d centavos.\n", parteInt, parteDecInt);

    return 0; // Instru��o
} //marca o fim do bloco de instru��es

