package com.murtell.fileserver.server;

import com.murtell.fileserver.interfaces.Commands;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Tim on 12/30/2015.
 */
public class ServerClientHandler implements Commands, Runnable {

    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private boolean running = false;
    private Server server;


    public ServerClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        //initialize streams
        inputStream = socket.getInputStream();
        //System.out.println("Stream started");
        outputStream = socket.getOutputStream();

        System.out.println("New Client connected to server on Address "
                + socket.getInetAddress().getHostAddress()
                + " with the hostname of  "
                + socket.getInetAddress().getHostName());
        //TODO add client connection to ArrayList

        Thread thread = new Thread();
        thread.start();

    }

    private String sendDevName() {

        String devName = "Tim Tellman";
        return devName;
    }

    @Override
    public void run() {
        System.out.println("Running ");
    }
}
