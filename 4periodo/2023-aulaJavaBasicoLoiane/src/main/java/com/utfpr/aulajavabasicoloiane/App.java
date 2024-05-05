/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulajavabasicoloiane;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        MinhaThreadSoma t1 = new MinhaThreadSoma("#1", array);
        MinhaThreadSoma t2 = new MinhaThreadSoma("#2", array);
    }
}
