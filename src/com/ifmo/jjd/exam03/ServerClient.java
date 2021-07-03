package exam03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerClient extends Thread{
    Socket serverClient;
    Messages messages;
    ServerClient(Socket inSocket,Messages messages){
        serverClient = inSocket;
        this.messages = messages;
    }
    public void run(){
        try{
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage="", serverMessage="";
            while(!clientMessage.equals("bye")){
                clientMessage=inStream.readUTF();
                messages.AddMessage(clientMessage);
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
