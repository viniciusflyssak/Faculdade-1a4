/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chainofresponsabilityusuarios;

/**
 *
 * @author vinic
 */
public class CheckUserMiddleWare extends MiddleWare{
    private Server server;
    
    public CheckUserMiddleWare(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)){
            System.out.println("Email inválido!");
            return false;
        }
        
        if (!server.isValidPassword(email, password)){
            System.out.println("Email ou senha inválidos");
            return false;
        }
        return checkNext(email, password);
    }
    
    
}
