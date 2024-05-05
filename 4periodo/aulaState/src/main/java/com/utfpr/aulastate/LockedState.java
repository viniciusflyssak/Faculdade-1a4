/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulastate;

/**
 *
 * @author vinic
 */
public class LockedState extends State{
    public LockedState(Player player){
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if(player.isPlaying()){
            player.changeState(new ReadyState(player));
            return "Stoping the music...";        
        }else{
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new PlayingState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
    
    
}
