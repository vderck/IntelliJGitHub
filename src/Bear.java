public class Bear {
    public int strength = 12;
    public int healthPoint = 1000;

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
