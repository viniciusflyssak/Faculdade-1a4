package com.utfpr.singletonsobremesas;

public abstract class SobremesaFactory {
    protected abstract Sobremesa createSobremesa(String tipo);
    
    public Sobremesa calcularPreco(String tipo){
        Sobremesa sobremesa = createSobremesa(tipo);
        return sobremesa;
    }    
}
