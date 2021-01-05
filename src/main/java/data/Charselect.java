package data;

import UI.UI;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class Charselect{

    private Texture bg;
    private UI menuUI;
    private boolean oneclick=false;//variable boolean pour ne pas prendre des inputs de souris sur plus de 1 frame
    public Charselect(){
        bg = Boot.LoadTexture("mainmenu.png");
        menuUI = new UI();
        menuUI.addButton("Hippie",Boot.LoadTexture("hippie_sel.png"),Boot.width/2 - 300,(int) (Boot.height * 0.45f));
        menuUI.addButton("Standard",Boot.LoadTexture("standard_sel.png"),Boot.width/2 - 128,(int) (Boot.height * 0.45f));
        menuUI.addButton("Presse",Boot.LoadTexture("presse_sel.png"),Boot.width/2 + 40,(int) (Boot.height * 0.45f));
    }

    public void updateButtons(){
        if(Mouse.isButtonDown(0) && oneclick) {
            System.out.println("click.");
            if (menuUI.isButtonClicked("Hippie")){
                StateManager.setSelected("Hippie");
                StateManager.setState(StateManager.GameState.GAME);
            }else if(menuUI.isButtonClicked("Standard")){
                StateManager.setSelected("Standard");
                StateManager.setState(StateManager.GameState.GAME);
            }else if(menuUI.isButtonClicked("Presse")){
                StateManager.setSelected("Presse");
                StateManager.setState(StateManager.GameState.GAME);
            }
        }
        oneclick = Mouse.isButtonDown(0);
    }

    public void update(){
        Boot.DrawQuadTex(bg,0,0,2048,1024);
        menuUI.draw();
        updateButtons();
    }

}