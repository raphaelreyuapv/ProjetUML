package data;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import static org.lwjgl.opengl.GL11.*;
public class Boot {
    static public int  width = 1280;
    static public int height = 960;

    public Boot() {
        Display.setTitle("Projet_UML");
        try {
            Display.setDisplayMode(new DisplayMode(1280, 960));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,1280,960,0,1,-1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
        Texture t = LoadTexture("desert.png");
        //CaseGrille grid = new CaseGrille();
        //Hippie joueur = new Hippie(grid.getCase(grid.xstartingpoint,grid.ystartingpoint));
        //Game game = new Game(null);
        while (!Display.isCloseRequested()) {
            Clock.update();
            StateManager.update();
            //DrawQuadTex(t,0,0,64,64);
            Display.update();
            Display.sync(60);

        }

        Display.destroy();

    }

    public static void DrawQuad(float x,float y,float width,float height){
        glBegin(GL_QUADS);
        glVertex2f(x,y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y+height);
        glVertex2f(x,y+height);
        glEnd();
    }

    public static void DrawQuadTex(Texture tex,float x,float y,float width,float height){
        tex.bind();
        glTranslatef(x,y,0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(width, 0);
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glEnd();
        glLoadIdentity();
    }

    public static Texture LoadTexture(String path){
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture("PNG", in);
        } catch (IOException e){
            e.printStackTrace();
        }
        return tex;
    }

    public static void main(String[] args) {
        new Boot();
    }

}
