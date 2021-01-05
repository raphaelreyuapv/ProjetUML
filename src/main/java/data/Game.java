package data;

import org.lwjgl.input.Keyboard;

public class Game {

    private CaseGrille grid;
    private Personnage joueur;

    public Game(String map){
        if(map==null){
            grid = new CaseGrille();
            joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));
        }else {
            grid = new CaseGrille(map);
            joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));
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
