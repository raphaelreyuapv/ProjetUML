package data;

import org.lwjgl.input.Keyboard;

public class Game {

    private CaseGrille grid;
    private Personnage joueur;

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
        joueur.Update();
        joueur.Draw();


            if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()){
                grid.SaveGrille("sauvegarde");
                System.out.println("Saved");
            }
    }

}
