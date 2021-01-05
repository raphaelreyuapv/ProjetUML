package data;

public class FastFood extends Batiment{

    public FastFood(float x, float y, float width, float height){
        super(x, y,width,height);
        texture = Boot.LoadTexture("fastfood.png");
    }
}
