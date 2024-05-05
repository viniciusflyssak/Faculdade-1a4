/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulaadapter;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) {
        PlugleDoisPinos p2 = new PlugleDoisPinos();
        Adaptador a = new Adaptador(p2);
        a.conectadoAoPlugueDeTresPinos();   
    }
}
