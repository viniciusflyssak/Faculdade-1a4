package com.utfpr.jokenpo.classes;

import static com.utfpr.jokenpo.ServidorTCP.adicionarJogador;
import static com.utfpr.jokenpo.ServidorTCP.marcaJogada;
import static com.utfpr.jokenpo.ServidorTCP.removerJogador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {            
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Jogador jogador = (Jogador) input.readObject();
            if (jogador.isAdd()) {
                adicionarJogador(jogador);
            } else if (jogador.isRemove()) {
                removerJogador(jogador);
            } else {
                marcaJogada(jogador, this);
            }
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
