package exam02;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private final HashMap<String, Point> gamePoints = new HashMap<>();
    private String gameState;

    public HashMap<String, Point> getGame() {
        return gamePoints;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = true;
        int userChoice;
        while(exitFlag) {
            System.out.println(gamePoints.get(gameState).getMainText());
            System.out.println(gamePoints.get(gameState).getFirstText());
            System.out.println(gamePoints.get(gameState).getSecondText());
            System.out.println("0. Вернуться в меню");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 0:
                    exitFlag = false;
                    break;
                case 1:
                    gameState = gamePoints.get(gameState).getFirstChoice();
                    break;
                case 2:
                    gameState = gamePoints.get(gameState).getSecondChoice();
                    break;
                default:
                    System.out.println("Не верный выбор!");
                    break;
            }
            if(gameState.equals("Exit")) exitFlag = false;
        }
    }
    public void saveGame(){
        try(FileWriter writer = new FileWriter("game.save", false))
        {
            String text = "Hello Gold!";
            writer.write(gameState);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        } catch (IOException e) {
            System.out.println("Запись не удалась.");
        }
    }
    public void loadGame(){
        try(BufferedReader reader = new BufferedReader(new FileReader("game.save")))
        {
            gameState = reader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Нет сохраненных игр.");
        } catch (IOException e) {
            System.out.println("Запись не удалась.");
        }
    }
}
