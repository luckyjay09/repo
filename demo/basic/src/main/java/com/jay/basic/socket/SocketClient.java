package com.jay.basic.socket;

import org.omg.CORBA.WrongTransaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello socket!");
            writer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
