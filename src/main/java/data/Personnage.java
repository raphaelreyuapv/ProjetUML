package data;

public class Personnage {

    // Attributs

    String pseudo;
    int degree;
    int chance;
    int life;
    int hydratation;
    int hunger;
    int moral;
    boolean swimsuit;
    int arrest;
    boolean drivingLicence;
    Case position;

    // Constructeurs

    public Personnage(){
        this.degree = 0;
        this.swimsuit = false;
        this.arrest = 0;
        this.drivingLicence = false;
    }

    public Personnage(String pseudo){
        this.degree = 0;
        this.swimsuit = false;
        this.arrest = 0;
        this.drivingLicence = false;
        this.pseudo = pseudo;
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

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getHydratation() {
        return hydratation;
    }

    public void setHydratation(int hydratation) {
        this.hydratation = hydratation;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getMoral() {
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

    public Boolean alive(){
        boolean vivant = true;

        if(this.life <= 0 || this.hunger <= 0 || this.hydratation <= 0 || this.moral <= 0 || this.arrest >= 3){
            vivant = false;
        }
        return vivant;
    }

    public void movement(Case a){
        this.position = a;
    }

}
