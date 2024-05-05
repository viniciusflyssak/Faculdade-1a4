/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandControleRemoto;

/**
 *
 * @author vinic
 */
public interface ICommand {
    public void execute();
    public void undo(); //Opcional    
}
