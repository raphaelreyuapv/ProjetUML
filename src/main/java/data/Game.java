package data;

public class Game {

    private CaseGrille grid;
    private Personnage joueur;

    public Game(int[][] map){
        if(map==null){
            grid = new CaseGrille();
            joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));
        }else {
            grid = new CaseGrille(map);
        }

    }

    public void update(){
        grid.Draw();
        joueur.Update();
        joueur.Draw();
    }
}
