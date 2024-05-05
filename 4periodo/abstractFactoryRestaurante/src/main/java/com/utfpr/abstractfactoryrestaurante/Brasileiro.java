/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.abstractfactoryrestaurante;

/**
 *
 * @author vinic
 */
public class Brasileiro implements IRestaurante{

    @Override
    public IPratoFeito criaPratoFeito() {
        return new PratoFeitoBrasileiro();
    }

    @Override
    public ISobremesa criaSobremesa() {
        return new SobremesaBrasileira();
    }
    
}
