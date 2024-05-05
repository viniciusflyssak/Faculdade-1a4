package com.utfpr.factorysobremesas;

public class SobremesaFactoryConcreto extends SobremesaFactory{
    
    @Override
    public Sobremesa createSobremesa(String marca){
        return switch(marca){
            case "PUDIM"-> new Pudim();
            case "SORVETE"-> new Sorvete();
            case "BOLO"-> new Bolo();
            default->null;
        };
    }
    
}
