package com.murtell.fileserver.server;

import com.murtell.fileserver.interfaces.Commands;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Tim on 12/30/2015.
 */
public class Server implements Commands {

    private ServerSocket serverSocket;
    private String shareDirectoryPath = "SharedFiles";
    private File sharedDirectory = new File(shareDirectoryPath);
    private boolean running = true;

    public Server() {
        getListOfFiles();
        for(File x : getListOfFiles()){
            System.out.println(x.toString());
        }
        serverRun();
    }

    private File[] getListOfFiles() {

        File[] sharedFiles = sharedDirectory.listFiles();

        return sharedFiles;
    }


    //start server open socket initialize client handler
    public void serverRun () {
        int port = 3000;
        //open Server Socket

        try {
            serverSocket = new ServerSocket(port);
            while (running){
                System.out.println("Server is started and waiting for a connection on port number " + port);

                Socket socket = serverSocket.accept();
                ServerClientHandler serverClientHandler = new ServerClientHandler(socket);
                //TODO remove this
                System.out.println(socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //close and exit loop.
            try{
                serverSocket.close();
                System.out.println("Closing socket");
                System.exit(0);
            }catch (IOException e){
                System.out.println("Error closing socket");
                e.printStackTrace();

            }


        }


    }

    public static void main(String[] args) {
       Server s = new Server();

    }
}
