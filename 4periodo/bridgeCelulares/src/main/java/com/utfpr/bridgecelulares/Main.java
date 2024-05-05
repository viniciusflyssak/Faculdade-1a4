package com.utfpr.bridgecelulares;

public class Main {    
    public static void main(String[] args) {
      tiraFoto(new Samsung());
      tiraFoto(new Xiaomi()); 
    }    
    
    public static void tiraFoto(IDispositivo dispositivo){
      Foto foto = new Foto(dispositivo);
      foto.tirarFotoFrontal();
      foto.tirarFotoTraseira();    
  }
}
