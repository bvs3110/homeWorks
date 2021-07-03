package exam03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;


public class ServerT extends Thread{
    ServerSocket serverSocket = null;
    Socket socket = null;
    ArrayList<ServerClient> clients;
    Messages messages;


    public ServerT(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            Messages messages = new Messages();
            this.start();
        } catch (IOException ioException) {
            System.out.println("ServerSocketError");
            ioException.printStackTrace();
        }


    }

    public void run(){

            while(true){
                try {
                    socket = serverSocket.accept();
                    ServerClient client = new ServerClient(socket, messages);
                    clients.add(client);
                    client.start();
                    System.out.println("Connected " + String.valueOf(clients.size()));
                }catch (Exception e){
                    System.out.println("ClientConnectError");
                    e.printStackTrace();
                }
            }

    }
}
