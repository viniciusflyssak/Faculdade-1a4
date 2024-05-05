/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulaadapter;

/**
 *
 * @author vinic
 */
public class Adaptador extends TomadaDeTresPinos{
    private static PlugleDoisPinos p2;

    public Adaptador(PlugleDoisPinos p2) {
        this.p2 = p2;
    }
        
    public void conectadoAoPlugueTresPinos(){
        p2.ligarNaTomadaDeDoisPinos();
    }
}
