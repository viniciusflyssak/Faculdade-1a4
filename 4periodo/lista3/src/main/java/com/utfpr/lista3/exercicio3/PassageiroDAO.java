/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio3;

//Classe que conectaria ao bd para validar o vip
public class PassageiroDAO {
    public static SubjectProxy getVipPassageiro(String id) {
        System.out.println("select vip from passageiro where id="+id);
        return new RealSubject(id, id);
    }
}
