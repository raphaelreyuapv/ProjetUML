package data;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import java.util.concurrent.ThreadLocalRandom;


public class Personnage {

    // Attributs

    String pseudo;
    int degree; //nb de diplomes
    int chance; //bonus pour le prochain diplome
    float life;
    float hydratation;
    float hunger;
    float moral;
    boolean swimsuit;
    int arrest;
    boolean drivingLicence;
    Texture texture;
    Case position;
    private int width,height,health;
    private float speed,x,y;
    private boolean init = true;
    String event="";
    // Constructeurs

    public Personnage(Texture tex,Case caseDepart,int width,int height,float speed) {
        this.texture = tex;
        this.x = caseDepart.positionX;
        this.y = caseDepart.positionY;
        this.position = data.CaseGrille.getCase(caseDepart.positionX/64,caseDepart.positionY/64);
        this.speed=speed;
        this.width = width;
        this.height = height;
        this.degree = 0;
        this.swimsuit = false;
        this.arrest = 0;
        this.drivingLicence = false;

        if(ThreadLocalRandom.current().nextInt(1, 101) <= 50){
            this.drivingLicence = true;
            event = ("Permis obtenu");
        }

        if(ThreadLocalRandom.current().nextInt(1, 101) <= 50){
            this.swimsuit = true;
            event = ("Swimsuit obtenu");
        }

    }

    public Personnage(String pseudo) {
        this.degree = 0;
        this.swimsuit = false;
        this.arrest = 0;
        this.drivingLicence = false;
        this.pseudo = pseudo;
    }

    public void Draw(){
        Boot.DrawQuadTex(texture,x,y,width,height);
    }

    public void Update(){
        if(init){
            init = false;//premiere init de la clock doit etre skip parceque c'est le jeu vien de se lancer et notre perso n'a pas a bouger
        }else {
            Case tempo;
            while(Keyboard.next() && alive()) {
                if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState() && position.positionX/64+1<20){


                    tempo = data.CaseGrille.getCase(position.positionX/64+1,position.positionY/64);

                    if ( (!(tempo instanceof Grise) && !(tempo instanceof Eau)) || ((tempo instanceof Eau) && swimsuit)) {
                        x += 64;
                        movement(tempo);
                    }

                }
                else if (Keyboard.getEventKey() == Keyboard.KEY_UP && Keyboard.getEventKeyState() && position.positionY/64-1>=0){

                    tempo = data.CaseGrille.getCase(position.positionX/64,position.positionY/64-1);

                    if ( (!(tempo instanceof Grise) && !(tempo instanceof Eau)) || ((tempo instanceof Eau) && swimsuit)) {
                        y -= 64;
                        movement(tempo);
                    }

                }
                else if (Keyboard.getEventKey() == Keyboard.KEY_DOWN && Keyboard.getEventKeyState() && position.positionY/64+1<15){
                    tempo = data.CaseGrille.getCase(position.positionX/64,position.positionY/64+1);

                    if ( (!(tempo instanceof Grise) && !(tempo instanceof Eau)) || ((tempo instanceof Eau) && swimsuit)) {
                        y += 64;
                        movement(tempo);
                    }
                }
                else if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState() && position.positionX/64-1>=0){
                    tempo = data.CaseGrille.getCase(position.positionX/64-1,position.positionY/64);

                    if ( (!(tempo instanceof Grise) && !(tempo instanceof Eau)) || ((tempo instanceof Eau) && swimsuit)) {
                        x -= 64;
                        movement(tempo);
                    }
                }
            }

        }
    }

    // get and set

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getDegree() {
        return degree;
    }

    public String getEvent(){
        return event;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public float getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public float getHydratation() {
        return hydratation;
    }

    public void setHydratation(int hydratation) {
        this.hydratation = hydratation;
    }

    public float getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public float getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public boolean isSwimsuit() {
        return swimsuit;
    }

    public void setSwimsuit(boolean swimsuit) {
        this.swimsuit = swimsuit;
    }

    public int getArrest() {
        return arrest;
    }

    public void setArrest(int arrest) {
        this.arrest = arrest;
    }

    public boolean isDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(boolean drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    // methodes

    public Boolean alive() { //verifie que le personnage à toutes ses jauges supérieures à 0
        boolean vivant = true;

        if (this.life <= 0 || this.hunger <= 0 || this.hydratation <= 0 || this.moral <= 0 || this.arrest >= 3) {
            vivant = false;
            System.out.println("Fin de la partie votre personnage est décédé, vous avez obtenu " + this.degree + " diplomes.");
            MainMenu.nbDiplomeEnd = degree;

        }
        return vivant;
    }

    public void verifAttributs(){ //permet que les jauges ne dépassent pas 0 ou 100
        if(moral > 100){
            moral = 100;
        }
        if(hydratation > 100){
            hydratation = 100;
        }
        if(hunger > 100){
            hunger = 100;
        }
        if(moral < 0){
            moral = 0;
        }
        if(hydratation < 0){
            hydratation = 0;
        }
        if(hunger < 0){
            hunger = 0;
        }
        if(life < 0){
            life = 0;
        }
        if(life > 100){
            life = 100;
        }

    }

    public void movement(Case a) { // case a = case sur laquelle le personnage se déplace

        this.position = a;

        // gestion des pieges
        int accidentRoll;
        int piegeRoll;
        int livreGL;
        int obtentionDiplome;
        int enonceExam;
        event = "";

        if ((a instanceof Deplacement) || (a instanceof Foret)) {
            accidentRoll = ThreadLocalRandom.current().nextInt(1, 101);//genere une valeure aléatoire entre 1 et 100
            if (a instanceof Foret && accidentRoll <= 10) { // == 10%
                life -= 10;
                event = ("Maladie vie -10");
            } else if ((a instanceof Deplacement) && (accidentRoll <= 5)) {
                piegeRoll = ThreadLocalRandom.current().nextInt(1, 4);
                if (a instanceof Route) {
                    if (piegeRoll == 1) { // Feu rouge
                        life -= 1;
                        event = ("Feu Rouge vie-1");
                    } else if (piegeRoll == 2 && drivingLicence) { // Police
                        moral -= 1;
                        arrest += 1;
                        event = ("Police moral-1");
                    } else if (piegeRoll == 3) { // Nid de poule
                        hydratation -= 2;
                        hunger -= 2;
                        event = ("Nid de poule soif-2 faim-2");
                    }
                } else if (a instanceof Trottoir) {
                    if (piegeRoll == 1) { // Banane
                        life -= 3;
                        event = ("Banane vie -3");
                    } else if (piegeRoll == 2) { // Poussette
                        moral -= 2;
                        event = ("Poussette moral-2");
                    } else if (piegeRoll == 3) { // Déjection canine
                        hunger -= 1;
                        event = ("Caca chien faim-1");
                    }
                }
            }
        }

        ///////////
        if (a instanceof Batiment) {
            if (a instanceof Maison) {
                moral += 10;
                hunger += 10;
                hydratation += 10;
                event = ("maison +10 partout");
                if(ThreadLocalRandom.current().nextInt(1, 101) <= 50){
                    this.swimsuit = true;
                    event = ("Swimsuit obtenu");
                }
            } else if (a instanceof Bibliotheque) {
                livreGL = ThreadLocalRandom.current().nextInt(1, 101);
                moral += 20;
                event = ("bibliotheque +20 moral");
                if (livreGL <= 5) {
                    chance += 10;
                    event = ("vous avez lu un livre de GL, chance de diplome +10%");
                }
            } else if (a instanceof FastFood) {
                hunger += 25;
                hydratation += 10;
                moral += 10;
                life -= 5;
                event = ("FastFood faim +25 soif +10 moral +10 vie -5");
            } else if (a instanceof Universite) {
                obtentionDiplome = ThreadLocalRandom.current().nextInt(1, 101);
                if (obtentionDiplome <= 30 + chance) {
                    degree += 1;
                    chance = 0;
                    moral += 5;
                    event = ("Vous avez obtenu un diplome !!");
                }
            } else if (a instanceof Bar) {
                hydratation += 25;
                moral += 10;
                life -= 3;
                event = ("Bar soif +25 moral +10 vie -3");
                enonceExam = ThreadLocalRandom.current().nextInt(1, 101);
                if (enonceExam <= 5) {
                    chance += 5;
                    event = ("Vous avez trouve l'enonce de l'examen, chance de diplome +5%");
                }
            }
        }
    }
}