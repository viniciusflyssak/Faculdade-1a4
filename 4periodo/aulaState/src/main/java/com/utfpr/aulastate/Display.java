/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulastate;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vinic
 */
public class Display {
    private Player player;
    private static JTextField textField = new JTextField();
    
    public Display(Player player){
        this.player = player;
    }
    
    public void init (){
        JFrame frame = new JFrame("Teste de Toca fita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        context.add(textField);
        context.add(buttons);
        
        JButton play = new JButton("Play");
        play.addActionListener(e -> textField.setText(player.getState().onPlay()));
        
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));
        
        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(player.getState().onNext()));
        
        JButton previous = new JButton("Prev.");
        previous.addActionListener(e -> textField.setText(player.getState().onPrevious()));
        
        frame.setVisible(true);
        frame.setSize(300,100);
        
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(previous);        
    }
}
