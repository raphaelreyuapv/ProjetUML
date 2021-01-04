package data;

public class Grise extends Case {

    public Grise(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("grise.png");
    }

}
