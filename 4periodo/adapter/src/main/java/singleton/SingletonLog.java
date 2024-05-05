/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author vinic
 */
public class SingletonLog {
    private int contador = 0;
    private static SingletonLog instancia;
    
    private SingletonLog(){
        this.setContador(this.getContador() + 1);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    //Retorna a instância da única classe singleton
    public static SingletonLog getInstance(){
        if (instancia == null){
            instancia = new SingletonLog();
        }
        return instancia;
    }
    
    //Faz o log de eventos
    public void doLog(String descricaoEvento){
        var caminho = System.getProperty("user.dir") +
                "/src/main/java/singleton/Operacoes.log";
        var cal = Calendar.getInstance();
        var texto = cal.getTime() + "ms:" +
                cal.get(Calendar.MILLISECOND)+"."+
                descricaoEvento+"\n";
        try {
            FileWriter fw = new FileWriter(caminho, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            fw.close();
            System.out.println("Número de instâncias (SingletonLog)"
                    + this.getContador());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
           
             
    }
}
