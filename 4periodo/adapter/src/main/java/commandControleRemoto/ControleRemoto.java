/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandControleRemoto;

/**
 *
 * @author vinic
 */
public class ControleRemoto {

    private static final int BOTOES = 3;
    private final ICommand[] onCommands;
    private final ICommand[] offCommands;
    private ICommand undoCommand;

    public ControleRemoto() {
        onCommands = new ICommand[BOTOES];
        offCommands = new ICommand[BOTOES];
        for (int i = 0; i < BOTOES; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int botao, ICommand onCommand, ICommand offCommand) {
        onCommands[botao] = onCommand;
        offCommands[botao] = offCommand;
    }

    public void ligar(int botao) {
        onCommands[botao].execute();
        undoCommand = onCommands[botao];
    }

    public void desligar(int botao) {
        offCommands[botao].execute();
        undoCommand = offCommands[botao];
    }
    
    public void undo(){
        undoCommand.undo();
    }
    
    @Override
    public String toString(){
        StringBuilder stringB = new StringBuilder();
        stringB.append("\n------Controle Remoto------\n");
        for(int i = 0; i < onCommands.length; i++){
            stringB.append("[botao");
            stringB.append(i);
            stringB.append("]");
            stringB.append(onCommands[i].getClass().getName());
            stringB.append("\t");
            stringB.append(offCommands[i].getClass().getName());
            stringB.append("\n");
        }
        return stringB.toString();
    }
}
