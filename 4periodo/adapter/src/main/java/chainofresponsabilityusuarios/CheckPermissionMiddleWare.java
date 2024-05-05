/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chainofresponsabilityusuarios;

/**
 *
 * @author vinic
 */
public class CheckPermissionMiddleWare extends MiddleWare{
    @Override
    public boolean check(String email, String password) {
        if (email.equals("master@hcode.com.br")){
            System.out.println("Bem vindo administrador!");
            return true;
        }
        System.out.println("Bem vindo");
        return checkNext(email, password);
    }
       
}
