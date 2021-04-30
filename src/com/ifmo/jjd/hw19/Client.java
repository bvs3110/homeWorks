package com.ifmo.jjd.hw19;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private  int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Enter Your Name:");
        String userName = scanner.nextLine();
        String text;
        while (true) {
            System.out.println("Enter your message");
            text = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(userName, text));
            if ("/exit".equals(text)) break;
        }
    }

    private void  sendAndPrintMessage(SimpleMessage message){
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            System.out.println("Ответ сервера:\n" + fromServer.getText());
        } catch (IOException e) {
            System.out.println("Send - receive error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message Error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}