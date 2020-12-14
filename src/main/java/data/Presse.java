package data;

public class Presse extends Personnage{

    public Presse(){
        super();
        this.life = 100;
        this.hydratation = 75;
        this.hunger = 75;
        this.moral = 50;
    }

    public Presse(String pseudo){
        super(pseudo);
        this.life = 100;
        this.hydratation = 75;
        this.hunger = 75;
        this.moral = 50;
    }

    // methodes

    public void movement(Case a){
        super.movement(a);
        if(a instanceof Batiment){
            this.life -= 1;
            this.hydratation -= 1;
            this.hunger-= 1;
            this.moral -= 1;
        }

        else {
            this.moral -= 2;
        }
    }
}
