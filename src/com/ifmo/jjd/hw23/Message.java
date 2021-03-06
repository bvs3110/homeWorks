package com.ifmo.jjd.hw23;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    private String sender;
    private LocalDateTime sent;
    public int suv;
    protected String blabla = "car";

    public Message(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent() {
        this.sent = LocalDateTime.now();
    }

    @Override
    public int compareTo(Message o) {
        return sent.compareTo(o.sent);
    }
}


