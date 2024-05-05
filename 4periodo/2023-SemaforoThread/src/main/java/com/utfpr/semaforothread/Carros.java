/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.semaforothread;

/**
 *
 * @author vinic
 */
public class Carros {

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    private int placa;
    private int ano;
    private String modelo;

    public Carros(int placa, int ano, String modelo) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
    }

    public Carros() {
    }
}
