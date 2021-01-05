package data;

import UI.UI;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class MainMenu {

    private Texture bg;
    private UI menuUI;
    public MainMenu(){
        bg = Boot.LoadTexture("mainmenu.png");
        menuUI = new UI();
        menuUI.addButton("Play",Boot.LoadTexture("play.png"),Boot.width/2 - 128,(int) (Boot.height * 0.45f));
    }

    public void updateButtons(){
        if(Mouse.isButtonDown(0)) {
            System.out.println("click");
            if (menuUI.isButtonClicked("Play")){
                System.out.println("Bouton");
                StateManager.setState(StateManager.GameState.GAME);
            }
        }
    }

    public void update(){
        Boot.DrawQuadTex(bg,0,0,2048,1024);
        menuUI.draw();
        updateButtons();
    }

}
