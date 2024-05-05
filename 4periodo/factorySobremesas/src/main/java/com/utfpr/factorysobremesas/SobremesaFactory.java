package com.utfpr.factorysobremesas;

public abstract class SobremesaFactory {
    protected abstract Sobremesa createSobremesa(String tipo);
    
    public Sobremesa calcularPreco(String tipo){
        Sobremesa sobremesa = createSobremesa(tipo);
        return sobremesa;
    }    
}
