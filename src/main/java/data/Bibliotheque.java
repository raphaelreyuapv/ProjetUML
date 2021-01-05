package data;

public class Bibliotheque extends Batiment {
    public Bibliotheque(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("bibliotheque.png");

    }
}
