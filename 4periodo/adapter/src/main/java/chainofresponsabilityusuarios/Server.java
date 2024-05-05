/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chainofresponsabilityusuarios;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vinic
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private MiddleWare middleware;
    
    public void setMiddleWare(MiddleWare middleware){
        this.middleware = middleware;
    }
    
    public boolean login(String email, String password){
        if (middleware.check(email, password)){
            System.out.println("Usuário autenticado com sucesso!");
            return true;
        }
        return false;
    }
    
    public void registerUser(String email, String password){
        users.put(email, password);
    }
    
    public boolean hasEmail(String email){
        return users.containsKey(email);
    }
    
    public boolean isValidPassword(String email, String password){
        return users.get(email).equals(password);
    }
}
