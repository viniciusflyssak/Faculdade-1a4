/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao1;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String[] args) {
        ApiViniciusFlyssak apiViniciusFlyssak = new ApiViniciusFlyssak();
        GameResponsibilities gameEngine = apiViniciusFlyssak.getGameResponsibilities(ApiViniciusFlyssak.GAMEENGINE);
        System.out.println("GameEngine: " + gameEngine.getDescricao());
        GameResponsibilities gameReport = apiViniciusFlyssak.getGameResponsibilities(ApiViniciusFlyssak.GAMEREPORT);
        System.out.println("GameReport: " + gameReport.getDescricao());
        GameResponsibilities gameWallet = apiViniciusFlyssak.getGameResponsibilities(ApiViniciusFlyssak.GAMEWALLET);
        System.out.println("GameWallet: " + gameWallet.getDescricao());
        GameResponsibilities gameUsers = apiViniciusFlyssak.getGameResponsibilities(ApiViniciusFlyssak.GAMEUSERS);
        System.out.println("GameUsers: " + gameUsers.getDescricao());
    }

}
