package data;

public class Maison extends Batiment{
    public Maison(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("maison.png");
    }
}
