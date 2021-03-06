package data;

import java.util.concurrent.TimeUnit;

public class StateManager {

    public static enum GameState{
        MAINMENU,GAME,CHARSELECT
    }

    public static GameState gameState = GameState.MAINMENU;
    public static MainMenu mainMenu;
    public static Game game;
    public static Charselect charSelect;
    public static String selected;
    public static String loadgame=null;
    public static boolean died=false;

    public static void update(){
        switch(gameState){
            case MAINMENU:
                if (mainMenu == null){
                    mainMenu = new MainMenu(died);
                }
                mainMenu.update();
                break;
            case GAME:
                if (game == null){
                    game = new Game(loadgame,selected);
                }
                game.update();
                break;
            case CHARSELECT:
                if (charSelect == null){
                    charSelect = new Charselect();
                }
                charSelect.update();
                break;
            default:
                //this should never happen yada yada
                if (game == null){
                    game = new Game(null,"Hippie");
                }
                game.update();
                break;
        }
    }

    public static void reset(){
        game = null;
        charSelect = null;
        mainMenu = null;
        gameState = GameState.MAINMENU;
    }
    public static void setSelected(String sel){
        selected = sel;
    }

    public static void setLoadGame(String sel){
        loadgame = sel;
    }

    public static void setDied(boolean sel){
        died=sel;
    }

    public static void setState(GameState newState){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        gameState = newState;
    }
}
