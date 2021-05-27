package exam02;

import static exam02.LoadMap.loadMap;

public class StartGame {
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        Game game = new Game();
        game.setGameState(loadMap(game.getGame()));
        mainMenu.addItem(new MenuItem("Выход") {
            @Override
            public void run() {
                mainMenu.setExit(true);
            }
        });
        mainMenu.addItem(new MenuItem("Начать игру") {
            @Override
            public void run() {
                game.startGame();
            }
        });
        mainMenu.addItem(new MenuItem("Сохранить игру") {
            @Override
            public void run() {
                game.saveGame();
            }
        });
        mainMenu.addItem(new MenuItem("Загрузить игру") {
            @Override
            public void run() {
                game.loadGame();
            }
        });
        mainMenu.run();
    }
}
