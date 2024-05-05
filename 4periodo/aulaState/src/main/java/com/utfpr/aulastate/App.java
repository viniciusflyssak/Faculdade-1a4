/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulastate;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) {
        Player player = new Player();
        Display display = new Display(player);
        display.init();
    }
}
