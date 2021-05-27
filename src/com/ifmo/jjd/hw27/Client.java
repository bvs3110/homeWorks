package com.ifmo.jjd.hw27;

import java.util.concurrent.ArrayBlockingQueue;

public class Client implements Runnable{
    private ArrayBlockingQueue<Order> clientGarson;
    private ArrayBlockingQueue<Order> cheefClient;

    public Client(ArrayBlockingQueue<Order> clientGarson, ArrayBlockingQueue<Order> cheefClient) {
        this.clientGarson = clientGarson;
        this.cheefClient = cheefClient;
    }

    @Override
    public void run() {
        Order order = new Order();
        try {
            clientGarson.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(cheefClient.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
