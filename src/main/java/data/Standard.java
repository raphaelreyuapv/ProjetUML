package data;

public class Standard extends Personnage{


    public Standard(){
        super();
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
        this.life -= 1;
        this.hydratation -= 1;
        this.hunger-= 1;
        this.moral -= 1;


    }

}
