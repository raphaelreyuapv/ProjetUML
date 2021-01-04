package data;

public class Bar extends Case{

    public Bar(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("bar.png");
    }
}
