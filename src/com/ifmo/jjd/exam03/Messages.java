package exam03;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Messages implements Runnable{
    private ArrayBlockingQueue<String> messages;

    public Messages() {
        this.messages= new ArrayBlockingQueue<String>(1000);
    }

    public void AddMessage(String message){
        try {
            this.messages.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(Thread.currentThread().getName() + " Элемент получен " + messages.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
