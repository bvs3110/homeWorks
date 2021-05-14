package com.ifmo.jjd.hw23;

public class SomeThing {
    private Message message;
    private int[] arr;

    public SomeThing(Message message, int[] arr) {
        this.message = message;
        this.arr = arr;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
