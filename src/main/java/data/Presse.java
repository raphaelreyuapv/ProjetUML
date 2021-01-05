package data;

public class Presse extends Personnage{

    public Presse(Case caseDep){
        super(Boot.LoadTexture("hipster.png"),caseDep,64,64,2);
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
        if(a instanceof Batiment && precedentePosition instanceof Deplacement){
            this.life -= 1;
            this.hydratation -= 1;
            this.hunger-= 1;
            this.moral -= 1;
            System.out.println("je passe dun trottoir a un batiment");
        }

        else if(a instanceof Deplacement && precedentePosition instanceof Batiment){
            this.moral -= 2;
            System.out.println("je passe dun batiment a un trottoir");

        }
        else {
            this.moral -= 2;
        }

        verifAttributs();
        System.out.println("vie:" + this.life + "; faim: " + hunger + " ;soif:" + hydratation + " ;moral:" + moral);

        if(!alive()){
            System.out.println("Fin de la partie votre personnage est décédé, vous avez obtenu " + degree + " diplomes.");
            //INSERER ECRAN DE FIN
        }

    }
}
