/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.abstractfactoryrestaurante;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        IRestaurante restaurante = new Brasileiro();
        IPratoFeito pf = restaurante.criaPratoFeito();
        ISobremesa sobremesa = restaurante.criaSobremesa();
        
        pf.exibirInfoPratoFeito();
        sobremesa.exibirInfoSobremesa();
        
        restaurante = new Argentino();
        pf = restaurante.criaPratoFeito();
        sobremesa = restaurante.criaSobremesa();;
        
        pf.exibirInfoPratoFeito();
        sobremesa.exibirInfoSobremesa();
    }
}
