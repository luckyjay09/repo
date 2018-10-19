package com.jay.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.SortedSet;

/**
 * server                 server
 * 创建serversocket       创建socket连接
 * bind ip+port          connect ip+port
 * listen监听端口
 * accept()   <---------   send()
 * receive()
 * 关闭                      关闭
 */
public class SockerServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8888); //启动服务
            Socket socket = serverSocket.accept(); //等待接收请求
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
