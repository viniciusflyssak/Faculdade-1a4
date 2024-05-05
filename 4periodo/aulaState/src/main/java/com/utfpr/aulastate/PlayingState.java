/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulastate;

/**
 *
 * @author vinic
 */
public class PlayingState extends State{
     public PlayingState(Player player){
         super(player);
     }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stoping the music...";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Pause...";
    }

    @Override
    public String onNext() {
       return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
