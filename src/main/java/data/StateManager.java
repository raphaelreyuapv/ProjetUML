package data;

public class StateManager {

    public static enum GameState{
        MAINMENU,GAME
    }

    public static GameState gameState = GameState.MAINMENU;
    public static MainMenu mainMenu;
    public static Game game;

    public static void update(){
        switch(gameState){
            case MAINMENU:
                if (mainMenu == null){
                    mainMenu = new MainMenu();
                }
                mainMenu.update();
                break;
            case GAME:
                if (game == null){
                    game = new Game(null);
                }
                game.update();
                break;
            default:
                //this should never happen yada yada
                if (game == null){
                    game = new Game(null);
                }
                game.update();
                break;
        }
    }

    public static void setState(GameState newState){
        gameState = newState;
    }
}
