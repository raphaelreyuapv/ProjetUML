package data;

import java.util.concurrent.ThreadLocalRandom;

public class Standard extends Personnage{


    public Standard(Case caseDep){
        super(Boot.LoadTexture("standard.png"),caseDep,64,64,2);
        this.life = 75;
        this.hydratation = 75;
        this.hunger = 75;
        this.moral = 75;
    }

    public Standard(String pseudo){
        super(pseudo);
        this.life = 75;
        this.hydratation = 75;
        this.hunger = 75;
        this.moral = 75;
    }

    // methodes

    public void movement(Case a){
        super.movement(a);

        if(a instanceof Route && !drivingLicence){
            this.hydratation -= 5;
            this.hunger-= 5;

            if(ThreadLocalRandom.current().nextInt(1, 201) <= 1) { //chance d accident
                this.life = 0;
            }
        }

        else if(a instanceof Route && drivingLicence){
            this.moral -= 2;

            if(ThreadLocalRandom.current().nextInt(1, 101) <= 2) { //chance d accident
                this.life = 0;
            }
        }
        else {
            this.life -= 1;
            this.hydratation -= 1;
            this.hunger -= 1;
            this.moral -= 1;
        }
        verifAttributs();
        System.out.println("vie:" + this.life + "; faim: " + hunger + " ;soif:" + hydratation + " ;moral:" + moral);

        alive();
    }

}
