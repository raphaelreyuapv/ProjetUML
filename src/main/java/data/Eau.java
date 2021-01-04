package data;

public class Eau extends Case {

    public Eau(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("eau.png");
    }

}
