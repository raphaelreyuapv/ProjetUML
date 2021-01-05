package data;

public class Universite extends Batiment{

    public Universite(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("universite.png");
    }
}
