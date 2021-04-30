package com.ifmo.jjd.hw19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Server {
    private int port;
    private Connection connection;
    private int clientsCount = 0;

    public Server(int port) {
        this.port = port;
    }

    public void start(){
        SimpleMessage helpMessage = new SimpleMessage("CommandServer", "/help - узнать список доступных команд\n" +
                "/count - узнать количество клиентов, которые подключались к серверу\n" +
                "/ping - узнать время за которое сообщение доходит до сервера и возвращается обратно\n" +
                "/exit - выйти из программы");
        SimpleMessage wrongMessage = new SimpleMessage("CommandServer", "Неправильная комманда введите /help для справки");
        SimpleMessage goodByMessage = new SimpleMessage("CommandServer", "До новых встреч");
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started");
            while (true) {
                Socket newClient = serverSocket.accept();
                connection = new Connection(newClient);
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                if(message == null) break;
                if(message.getText() == null) break;
                switch (message.getText().toLowerCase()){
                    case "/help":
                        connection.sendMessage(helpMessage);
                        break;
                    case "/count":
                        SimpleMessage countMessage = new SimpleMessage("CommandServer", "С момента старта сервера обслужено " + clientsCount + " соединений");
                        connection.sendMessage(countMessage);
                        break;
                    case "/ping":
                        Long servTime = ChronoUnit.MILLIS.between(message.getDateTime(), LocalDateTime.now());
                        SimpleMessage pingMessage = new SimpleMessage("CommandServer", "Время обслуживания запроса " + servTime.toString() + " мс");
                        connection.sendMessage(pingMessage);
                        break;
                    case "/exit":
                        connection.sendMessage(goodByMessage);
                        break;
                    default:
                        connection.sendMessage(wrongMessage);
                        break;
                }
                clientsCount ++;
            }
        } catch (IOException e) {
            System.out.println("Server error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message read fail");
            e.printStackTrace();
        }
    }
}