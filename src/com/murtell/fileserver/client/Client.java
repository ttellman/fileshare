package com.murtell.fileserver.client;

import com.murtell.fileserver.interfaces.Commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Tim on 12/30/2015.
 */
public class Client implements Commands {

    private int port;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String downloadDirectory = "downloadedfiles";

    public Client(){
        try {
            connect("localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String connect(String ipAdress) throws IOException {
        //ipAdress = "127.0.0.1";
        port = 3000;
        String developerName = " ";

        socket = new Socket(ipAdress, port);
        System.out.println("IP Address: " + ipAdress + " " + "port " + port);

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        System.out.println("Connected waiting for name....");

        return developerName;
    }

    public static void main(String[] args) {
        new Client();
    }

    }

