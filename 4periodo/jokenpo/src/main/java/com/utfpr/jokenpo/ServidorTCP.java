package com.utfpr.jokenpo;

import com.utfpr.jokenpo.classes.Jogador;
import com.utfpr.jokenpo.classes.ServerThread;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorTCP {

    public static ArrayList<ArrayList<Jogador>> jogadores = new ArrayList<ArrayList<Jogador>>(); //Array que contém todos os jogadores
    public static int jogadas = 0;
    public static ServerSocket server;
    public static Socket socket;

    public static void calcularPontos(int sala) throws IOException {
        for (int i = 0; i < jogadores.get(sala).size(); i++) {  // Primeiro for, o que irá definir o jogador a ser comparado
            for (int j = 0; j < jogadores.get(sala).size(); j++) { //j é  o contador do segundo for
                if (jogadores.get(sala).get(i).getJogada() != jogadores.get(sala).get(j).getJogada()) { //se for empate, ninguém pontua
                    if (((jogadores.get(sala).get(i).getJogada() == 'P') && (jogadores.get(sala).get(j).getJogada() == 'R'))
                            || //valida se jogador ganhou de outro participante
                            ((jogadores.get(sala).get(i).getJogada() == 'R') && (jogadores.get(sala).get(j).getJogada() == 'T'))
                            || ((jogadores.get(sala).get(i).getJogada() == 'T') && (jogadores.get(sala).get(j).getJogada() == 'P'))) {
                        jogadores.get(sala).get(i).setPontuacao(jogadores.get(sala).get(i).getPontuacao() + 1);
//                        jogadores.get(sala).get(i).setJogada(' ');
                    }
                }
            }
            System.out.println("Pontuação do jogador " + jogadores.get(sala).get(i).getNome() + " é de " + jogadores.get(sala).get(i).getPontuacao() + " pontos");
        }
    }

    public static void adicionarJogador(Jogador jogador) throws IOException {
        jogador.setAdd(false);
        if (jogador.getSala() == -1) {
            jogadores.add(new ArrayList<>());
            jogador.setSala(jogadores.size() - 1);
        }
        jogadores.get(jogador.getSala()).add(jogador); //Cadastra jogador
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(jogador);
        System.out.println("Jogador " + jogador.getNome() + " adicionado com sucesso a sala " + jogador.getSala());
    }

    public static void removerJogador(Jogador jogador) {
        jogadores.get(jogador.getSala()).removeIf(j -> (j.getNome().equals(jogador.getNome())));
        System.out.println("Jogador " + jogador.getNome() + " saiu da sala " + jogador.getSala());
    }

    public static void marcaJogada(Jogador jogador, ServerThread thread) throws IOException {
        jogadas = 0;
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        if (jogadores.get(jogador.getSala()).size() <= 3) {
            jogador.setMsg("Quantidade insuficiente de jogadores para continuar!");            
            saida.writeObject(jogador);
            return;
        } else {
            jogador.setMsg("");
        }
        jogadores.get(jogador.getSala()).stream().filter(jogadorFind -> (jogadorFind.getNome().equals(jogador.getNome()))).forEachOrdered(jogadorFind -> {
            jogadorFind.setJogada(jogador.getJogada());
        });
        System.out.println("Jogador " + jogador.getNome() + " executou a jogada " + jogador.getJogada());
        jogadores.get(jogador.getSala()).forEach((jogadorTemp) -> {
            if (jogadorTemp.getJogada() != ' ') {
                jogadas = jogadas + 1;
            }

        });
        while (jogadas < jogadores.get(jogador.getSala()).size()) {
            try {
                if (jogadores.get(jogador.getSala()).size() <= 3) {
                    jogador.setMsg("Quantidade insuficiente de jogadores para continuar!");
                    saida.writeObject(jogador);
                    return;
                } else {
                    jogador.setMsg("");
                }
                thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jogadores.get(jogador.getSala()).size() <= 3) {
            jogador.setMsg("Quantidade insuficiente de jogadores para continuar!");
            saida.writeObject(jogador);
            return;
        } else {
            jogador.setMsg("");
        }
        try {
            calcularPontos(jogador.getSala());
            
            jogadores.get(jogador.getSala()).stream().filter(jogadorFind -> (jogadorFind.getNome().equals(jogador.getNome()))).forEachOrdered(jogadorFind -> {
                try {
                    Jogador j = jogadorFind;
                    j.setJogada(' ');
                    saida.writeObject(j);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        jogadores.add(new ArrayList<Jogador>());
        server = new ServerSocket(8081);
        while (true) {
            socket = server.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }

    }

}
