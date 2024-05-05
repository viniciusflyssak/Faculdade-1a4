/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chainofresponsabilityusuarios;

/**
 *
 * @author vinic
 */
public abstract class MiddleWare {
    public MiddleWare next;
    
    public MiddleWare linkWith(MiddleWare next){
        this.next = next;
        return next;
    }
    
    public abstract boolean check(String email, String password);
    
    protected boolean checkNext(String email, String password){
        if(next == null){
            return true;
        }
        return next.check(email, password);
    }
}
