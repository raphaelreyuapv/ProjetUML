package data;

import org.newdawn.slick.opengl.Texture;

public class Case {

    public float positionX,positionY,largeur,hauteur;
    public Texture texture;


    public Case(float x, float y, float width, float height){
        positionX=x;
        positionY=y;
        largeur=width;
        hauteur=height;
        texture = Boot.LoadTexture("desert.png");
    }

    public void Draw(){
        Boot.DrawQuadTex(texture,positionX,positionY,largeur,hauteur);
    }


}
