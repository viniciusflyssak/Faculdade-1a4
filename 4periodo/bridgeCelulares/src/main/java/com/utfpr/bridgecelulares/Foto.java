package com.utfpr.bridgecelulares;

public class Foto implements ICamera{
    protected IDispositivo dispositivo;
    
    @Override
    public void tirarFotoFrontal() {
        dispositivo.configuraCelular();
        System.out.println("Foto capturada via câmera frontal");
        System.out.println("");
    } 
    
    @Override
    public void tirarFotoTraseira() {
        dispositivo.configuraCelular();
        System.out.println("Foto capturada via câmera traseira");
        System.out.println("");
    }
    
    public Foto(IDispositivo dispositivo){
        this.dispositivo = dispositivo;
    }    
}
