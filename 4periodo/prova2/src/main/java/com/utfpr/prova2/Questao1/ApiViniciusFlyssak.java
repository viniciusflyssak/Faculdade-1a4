/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao1;

/**
 *
 * @author vinic
 */
public class ApiViniciusFlyssak {

    public static final int GAMEENGINE = 0;
    public static final int GAMEREPORT = 1;
    public static final int GAMEWALLET = 3;
    public static final int GAMEUSERS = 4;

    public GameResponsibilities getGameResponsibilities(int tipo) {
        switch (tipo) {
            case GAMEENGINE:
                IApi apiGameEngine = new ApiGameEngine();
                return apiGameEngine.getResponsabilitie();

            case GAMEREPORT:
                IApi apiGameReport = new ApiGameReport();
                return apiGameReport.getResponsabilitie();
            case GAMEWALLET:
                IApi apiGameWallet = new ApiGameWallet();
                return apiGameWallet.getResponsabilitie();

            case GAMEUSERS:
                IApi apiGameUsers = new ApiGameUsers();
                return apiGameUsers.getResponsabilitie();
            default:
                return null;

        }
    }
}
