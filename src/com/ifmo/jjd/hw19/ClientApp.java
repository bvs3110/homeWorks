package com.ifmo.jjd.hw19;

public class ClientApp {
    public static void main(String[] args) {
        new Client("localhost", 8675).start();
    }
}
