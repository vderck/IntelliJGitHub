public class Bear {
    public int strength = 12;
    public int healthPoint = 100;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getHealthPoint(){
        return healthPoint;
    }

    public  void setHealthPoint(int healthPoint){
        this.healthPoint = healthPoint;
    }

    public int bearKnuckle(){
        int ultimateAttack = strength + 8;
        return ultimateAttack;
    }
}
