package com.utfpr.singletonsobremesas;

public class Sobremesa {
    protected double valor;
    private static int numInstancias = 0;
    private int cont;
    private static Sobremesa instancia;  

    public Sobremesa(){
        cont = ++ numInstancias;
        System.out.println("Criada nova sobremesa: " + cont);
    }
    
    public double getValor() {
        return valor;
    }
    
}
