package data;

public class Standard extends Personnage{


    public Standard(Case caseDep){
        super(Boot.LoadTexture("hipster.png"),caseDep,64,64,2);
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

        verifAttributs();
        System.out.println("vie:" + this.life + "; faim: " + hunger + " ;soif:" + hydratation + " ;moral:" + moral);

        if(!alive()){
            System.out.println("Fin de la partie votre personnage est décédé, vous avez obtenu " + degree + " diplomes.");
            //INSERER ECRAN DE FIN
        }
    }

}
