package data;

public class Foret extends Case {

    public Foret(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("foret.png");
    }

}
