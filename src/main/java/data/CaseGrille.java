package data;

import java.util.concurrent.ThreadLocalRandom;

public class CaseGrille {

    public static Case[][] map;
    public int xstartingpoint,ystartingpoint;

    public CaseGrille(){
        int rng;
        boolean maison=false,universite=false,fastfood=false,bar=false;
        map = new Case[20][15];
        for (int i = 0;i < map.length; i++){
            for(int j = 0;j < map[i].length;j++){
                rng= ThreadLocalRandom.current().nextInt(0,10+1);
                switch(rng){
                    case 0:
                        map[i][j] = new Route(i*64,j*64,64,64);
                        break;
                    case 1:
                        if(!universite) {
                            map[i][j] = new Universite(i * 64, j * 64, 64, 64);
                            universite=true;
                        }else {
                            map[i][j] = new Trottoir(i*64,j*64,64,64);
                        }
                        break;
                    case 2:
                        if(!maison) {
                            map[i][j] = new Maison(i * 64, j * 64, 64, 64);
                            xstartingpoint = i;
                            ystartingpoint = j;
                            maison=true;
                        }else {
                            map[i][j] = new Route(i*64,j*64,64,64);
                        }
                        break;
                    case 3:
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;
                    case 4:
                        map[i][j] = new Eau(i*64,j*64,64,64);
                        break;
                    case 5:
                        if(!fastfood) {
                            map[i][j] = new FastFood(i * 64, j * 64, 64, 64);
                            fastfood=true;
                        }else{
                            map[i][j]=new Grise(i * 64, j * 64, 64, 64);
                        }
                        break;
                    case 6:
                        if(!bar){
                            map[i][j] = new Bar(i * 64, j * 64, 64, 64);
                            bar=true;
                        }else{
                            map[i][j]=new Foret(i * 64, j * 64, 64, 64);
                        }
                        break;
                    default:
                        //this should never happen but who knows
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;
                }
                }
            }
        }

    public  static Case getCase(float x,float y){
        return map[(int) x][(int) y];
    }

    public CaseGrille(int[][] loadmap){
        map = new Case[20][15];
        for (int i = 0;i < map.length; i++){
            for (int j = 0;j<map[i].length;j++){
                switch (loadmap[i][j]){
                    case 0:
                        map[i][j] = new Route(i*64,j*64,64,64);
                        break;
                    case 1:
                        map[i][j] = new Universite(i*64,j*64,64,64);
                        break;
                    case 2:
                        map[i][j] = new Maison(i*64,j*64,64,64);
                        break;
                    case 3:
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;
                    default:
                        //this should never happen but who knows
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;


                }
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
