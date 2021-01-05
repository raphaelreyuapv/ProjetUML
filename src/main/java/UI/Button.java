package UI;

import org.newdawn.slick.opengl.Texture;

public class Button {


    public String name;
    public Texture tex;
    public int x,y,width,height;

    public Button(String name,Texture texture,int x,int y){
        this.name = name;
        this.tex=texture;
        this.x=x;
        this.y=y;
        this.width=tex.getImageWidth();
        this.height=tex.getImageHeight();
    }

}
