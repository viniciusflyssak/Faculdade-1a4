package com.utfpr.adaptersobremesas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String opcao = "";
        Scanner scanner = new Scanner(System.in);
        while (!"SAIR".equals(opcao.toUpperCase())){
            System.out.println("Escolha uma sobremesa: ");
            System.out.println("Bolo, Pudim ou sorvete ");
            opcao = scanner.nextLine();
            try {
                System.out.println("");
                SobremesaFactory fabrica = new SobremesaFactoryConcreto();
                System.out.println(opcao.toUpperCase());
                Sobremesa s = fabrica.createSobremesa(opcao.toUpperCase());
                System.out.println(s.getValor());    
                SobremesaAdapter sobremesaAdapter = new SobremesaAdapter(s);
                System.out.println("Valor pelo adapter: " + sobremesaAdapter.getPreco());
                System.out.println("");
            } catch (Exception e) {
                if (!"SAIR".equals(opcao.toUpperCase())){
                    System.err.println("Opção inválida!");
                }
            }                        
        }
    }
}
