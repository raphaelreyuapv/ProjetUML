package data;

public class Hippie extends Personnage{

    public Hippie(){
        super();
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
       /* if(a instanceof Batiment){
            this.life -= 0.5;
            this.hydratation -= 0.5;
            this.hunger-= 0.5;
            this.moral -= 0.5;
        }

        else {
            this.life -= 2;
            this.hydratation -= 2;
            this.hunger -= 2;
        }*/
    }
}
