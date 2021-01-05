package data;

import UI.UI;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import java.awt.*;
import java.io.File;

public class MainMenu {

    static int nbDiplomeEnd;

    private Texture bg;
    private UI menuUI;
    private boolean fromgameover=false;
    private boolean oneclick;//variable boolean pour empecher de recuperer des inputs sur plus de 1 frame
    public MainMenu(boolean fgo){
        fromgameover=fgo;
        bg = Boot.LoadTexture("mainmenu.png");
        menuUI = new UI();
        menuUI.addButton("Play",Boot.LoadTexture("play.png"),Boot.width/2 - 128,(int) (Boot.height * 0.45f));
        menuUI.addButton("Load",Boot.LoadTexture("load.png"),Boot.width/2 - 128,(int) (Boot.height * 0.55f));
    }

    public void updateButtons(){
        if(Mouse.isButtonDown(0) && !oneclick) {
            if (menuUI.isButtonClicked("Play")){
                StateManager.setState(StateManager.GameState.CHARSELECT);
            }else if(menuUI.isButtonClicked("Load")){
                FileDialog dialog = new FileDialog((Frame)null, "Choisir un fichier de sauvegarde");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String file = dialog.getFile();
                StateManager.setLoadGame(file);
                StateManager.setState(StateManager.GameState.CHARSELECT);

            }
        }
        oneclick=Mouse.isButtonDown(0);
    }

    public void update(){
        Boot.DrawQuadTex(bg,0,0,2048,1024);
        menuUI.draw();
        if(fromgameover==true){
            menuUI.drawText(0,0,"Vous etez mort avec " + nbDiplomeEnd + " diplome(s), pas de chance...");
        }
        updateButtons();
    }

}
