package data;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class CaseGrille {

    public static Case[][] map;
    public int xstartingpoint,ystartingpoint;

    public CaseGrille(){
        int rng;
        boolean maison=false,universite=false,fastfood=false,bar=false,bibliotheque=false;
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
                    case 7:
                        if(!bibliotheque){
                            map[i][j] = new Bibliotheque(i * 64, j * 64, 64, 64);
                            bibliotheque=true;
                        }else{
                            map[i][j]=new Eau(i * 64, j * 64, 64, 64);
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

    public CaseGrille(String savename){
        String data = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(savename));
            data = br.readLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        map = new Case[20][15];
        for (int i = 0;i < map.length; i++){
            for (int j = 0;j<map[i].length;j++){
                switch (data.substring(i*15+j,i*15+j+1)){
                    case "0":
                        map[i][j] = new Route(i*64,j*64,64,64);
                        break;
                    case "1":
                        map[i][j] = new Universite(i*64,j*64,64,64);
                        break;
                    case "2":
                        map[i][j] = new Maison(i*64,j*64,64,64);
                        this.xstartingpoint=i;
                        this.ystartingpoint=j;
                        break;
                    case "3":
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;
                    case "4":
                        map[i][j] = new Eau(i*64,j*64,64,64);
                        break;
                    case "5":
                        map[i][j] = new FastFood(i*64,j*64,64,64);
                        break;
                    case "6":
                        map[i][j] = new Grise(i*64,j*64,64,64);
                        break;
                    case "7":
                        map[i][j] = new Bar(i*64,j*64,64,64);
                        break;
                    case "8":
                        map[i][j] = new Foret(i*64,j*64,64,64);
                    default:
                        //this should never happen but who knows
                        map[i][j] = new Trottoir(i*64,j*64,64,64);
                        break;


                }
            }

        }
    }
    /*
    0=Route;
    1=Universite
    2=Maison
    3=Trottoir
    4=Eau
    5=Fastfood
    6=Grise
    7=Bar
    8=Foret

     */

    public void SaveGrille(String savename){
        String data = "";
        for (int i= 0; i < 20;i++){
            for (int j = 0;j<15;j++){
                data+= getIDFromCase(map[i][j]);
            }
        }
        try {
            File file = new File(savename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(data);
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    0=Route;
    1=Universite
    2=Maison
    3=Trottoir
    4=Eau
    5=Fastfood
    6=Grise
    7=Bar
    8=Foret

     */
    public String getIDFromCase(Case c){
        if(c instanceof Route){
            return "0";
        }else if(c instanceof Universite){
            return "1";
        }
        else if(c instanceof Maison){
            return "2";
        }
        else if(c instanceof Trottoir){
            return "3";
        }
        else if(c instanceof Eau){
            return "4";
        }
        else if(c instanceof FastFood){
            return "5";
        }
        else if(c instanceof Grise){
            return "6";
        }
        else if (c instanceof Bar){
            return "7";
        }
        else if (c instanceof Foret){
            return "8";
        }
    return "0";

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
