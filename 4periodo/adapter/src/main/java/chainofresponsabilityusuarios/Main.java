/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chainofresponsabilityusuarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vinic
 */
public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;
 
    public static void init(){
        server = new Server();
        server.registerUser("master@hcode.com.br", "654321");
        server.registerUser("user@hcode.com.br", "123456");

        MiddleWare middleWare = new CheckUserMiddleWare(server);
        middleWare.linkWith(new CheckPermissionMiddleWare());
        server.setMiddleWare(middleWare);
    }
    public static void main(String[] args) throws IOException {
        init();
        boolean done;
        
        do {
            System.out.println("Digite o e-mail: ");
            String email = reader.readLine();            
            System.out.println("Digite a senha: ");
            String senha = reader.readLine();
            done = server.login(email, senha);
            
        }while(!done);
        
    }

}
