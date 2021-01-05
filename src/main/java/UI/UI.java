package UI;

import data.Boot;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;

public class UI {

    private ArrayList<Button> buttonList;

    public UI(){
        buttonList = new ArrayList<Button>();
    }

    public void addButton(String name, Texture texture, int x, int y){
        buttonList.add(new Button(name,texture,x,y));
    }

    public boolean isButtonClicked(String buttonName){
        Button b = getButton(buttonName);
        float mouseY = Boot.height - Mouse.getY() - 1;
        if (Mouse.getX() > b.x && Mouse.getX() < b.x + b.width &&
         mouseY > b.y && mouseY < b.y + b.height){
            return true;
        }
        return false;
    }

    public Button getButton(String buttonName){
        for (Button b: buttonList){
            if(b.name.equals(buttonName)){
                return b;
            }
        }
        return null;
    }

    public void draw(){
        for(Button b: buttonList){
            Boot.DrawQuadTex(b.tex,b.x,b.y,b.width,b.height);
        }
    }
}
