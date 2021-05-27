package exam02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private final ArrayList<MenuItem> items = new ArrayList<>();
    private boolean isExit = false;

    public void addItem(MenuItem menuItem){
        items.add(menuItem);
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(!isExit){
            System.out.println("Сделайте выбор:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(" [" + i + "] " + items.get(i).getItemText());
            }
            items.get(scanner.nextInt()).run();
        }
    }
}
