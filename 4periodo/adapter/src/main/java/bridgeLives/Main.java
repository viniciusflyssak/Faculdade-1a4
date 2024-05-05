/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class Main {
  public static void main(String[] args){
      startLive(new Youtube());
      startLive(new Facebook());
      startLive(new TwitchTV());
      startLive(new Instagram());
  }  
  
  public static void startLive(IPlatform platform){
      System.out.println("...Aguarde");
      Live live = new Live(platform);
      live.broadcasting();
      live.result();
      
      System.out.println("Transmissão avançada...Aguarde");
      AdvancedLive adLive = new AdvancedLive(platform);
      adLive.broadcasting();
      adLive.result();
      adLive.comments();
      adLive.subtitles();
      
      System.out.println("Validando gravação...");
      RecordLives recordLives = new RecordLives(platform);
      recordLives.gravar();
  }
}
