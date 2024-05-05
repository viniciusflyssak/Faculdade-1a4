/* Exemplo de uso da biblioteca math.h
  Programa que separa a parte inteira e decimal de um valor em R$
*/

#include <stdio.h> //Biblioteca de funções - contém as funções scanf() e printf()
#include <stdlib.h>
#include <math.h>

int main() //função principal - única
{ //marca o início do bloco de instruções, neste caso, início do algoritmo

    //declaração de variáveis
    double num;
    int parteInt, parteDecInt;

    //entrada de dados
    printf("Informe o valor do troco: R$ ");
    scanf("%lf", &num);

    //processamento de dados
    parteInt = (int) num;
    parteDecInt = round((num - (int)num) * 100);

    //saída de dados
    printf("\nO valor informado eh %d reais e %d centavos.\n", parteInt, parteDecInt);

    return 0; // Instrução
} //marca o fim do bloco de instruções

