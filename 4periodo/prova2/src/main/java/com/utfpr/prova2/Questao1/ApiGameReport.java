/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao1;

/**
 *
 * @author vinic
 */
public class ApiGameReport implements IApi{
    @Override
    public GameResponsibilities getResponsabilitie(){
        GameResponsibilitiesGameReport responsabilitie =  new GameResponsibilitiesGameReport();
        return responsabilitie;
    }
}
