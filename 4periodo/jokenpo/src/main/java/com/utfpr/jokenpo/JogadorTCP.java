package com.utfpr.jokenpo;

import com.utfpr.jokenpo.classes.Jogador;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JogadorTCP {

    public static void enviar(Jogador jogador) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 8081);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(jogador);
        socket.close();
    }

    public static Jogador enviarComRetorno(Jogador jogador) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 8081);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(jogador);
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Jogador retorno = (Jogador) input.readObject();
        socket.close();
        return retorno;
    }
    
}
