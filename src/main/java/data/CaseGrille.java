package data;

public class CaseGrille {

    public Case[][] map;

    public CaseGrille(){
        map = new Case[20][15];
        for (int i = 0;i < map.length; i++){
            for(int j = 0;j < map[i].length;j++){
                map[i][j] = new Case(i * 64,j * 64,64,64);
            }
        }
    }

    public void Draw(){
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                Case t = map[i][j];
                Boot.DrawQuadTex(t.texture,t.positionX,t.positionY,t.largeur,t.hauteur);
            }
        }
    }
}
