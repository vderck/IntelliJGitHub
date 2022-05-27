public class Bear {

    //공격력
    public int strength = 30;

    //체력
    public int healthPoint = 1000;

    public int getHealthPoint(){
        return healthPoint;
    }

    public  void setHealthPoint(int healthPoint){
        this.healthPoint = healthPoint;
    }

    //베어너클(필살기)을 시전한다.
    public int bearKnuckle(){
        int ultimateAttack = strength + 8;
        return ultimateAttack;
    }
}
