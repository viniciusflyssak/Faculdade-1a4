/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade2;

/**
 *
 * @author vinic
 */
public class ApiInventario implements IApi{
    @Override
    public Servico getServico(){
        ServicoInventario servico =  new ServicoInventario();
        return servico;
    }
}
