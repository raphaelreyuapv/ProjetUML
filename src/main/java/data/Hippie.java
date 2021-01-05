package data;

import java.util.concurrent.ThreadLocalRandom;

public class Hippie extends Personnage{

    public Hippie(Case caseDep){
        super(Boot.LoadTexture("hippie.png"),caseDep,64,64,15);
        this.life = 75;
        this.hydratation = 50;
        this.hunger = 50;
        this.moral = 100;
    }
    public Hippie(String pseudo){
        super(pseudo);
        this.life = 75;
        this.hydratation = 50;
        this.hunger = 50;
        this.moral = 100;
    }

    // methodes

    public void movement(Case a){
        super.movement(a);

       if(a instanceof Route){
           this.hydratation -= 5;
           this.hunger-= 5;

           if(ThreadLocalRandom.current().nextInt(1, 201) <= 1) { //chance d accident
                this.life = 0;
           }
       }
       else if(a instanceof Batiment){
            this.life -= 0.5;
            this.hydratation -= 0.5;
            this.hunger-= 0.5;
            this.moral -= 0.5;
           //System.out.println("je passe dun trottoir a un batiment");
        }

        else {
            this.life -= 2;
            this.hydratation -= 2;
            this.hunger -= 2;
           //System.out.println("else");
        }
        verifAttributs();
        System.out.println("vie:" + this.life + "; faim: " + hunger + " ;soif:" + hydratation + " ;moral:" + moral);

        alive();


    }
}
