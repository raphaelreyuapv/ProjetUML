package data;

import UI.UI;
import org.lwjgl.input.Keyboard;

public class Game {

    private CaseGrille grid;
    private Personnage joueur;
    private UI gameUI = new UI();
    private String PlayerEvent = "";

    public Game(String map,String perso){
        if(map==null){
            grid = new CaseGrille();
        }else {
            grid = new CaseGrille(map);
        }
        switch(perso){
            case "Hippie":joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));break;
            case "Standard":joueur = new Standard(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));break;
            case "Presse":joueur = new Presse(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));break;
            default:joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));break;
        }

    }



    public void update(){
        grid.Draw();
        gameUI.drawText(0,0,"Vie: "+joueur.getLife());
        gameUI.drawText(0,20,"Faim: "+joueur.getHunger());
        gameUI.drawText(0,40,"Soif: "+joueur.getHydratation());
        gameUI.drawText(0,60,"Moral: "+joueur.getMoral());
        gameUI.drawText(0,80,"Diplomes: "+joueur.getDegree());
        gameUI.drawText(0,100,"Arrestation: "+joueur.getArrest());
        gameUI.drawText(0,120,"Maillot: "+joueur.isSwimsuit());
        gameUI.drawText(0,140,"Permis: "+joueur.isDrivingLicence());
        PlayerEvent = joueur.getEvent();
        if(PlayerEvent != ""){
            gameUI.drawText(0,160,PlayerEvent);
        }
        joueur.Update();
        joueur.Draw();


            if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()){
                grid.SaveGrille("sauvegarde");
                System.out.println("Saved");
            }
        if(joueur.alive() == false){
            StateManager.setDied(true);
            StateManager.reset();

        }
    }

}
