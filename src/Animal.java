public class Animal {

    // 공격력
    public int strength = 10;

    //체력
    public int healthPoint = 100;

    public int getHealthPoint(){
        return healthPoint;
    }

    public  void setHealthPoint(int healthPoint){
        this.healthPoint = healthPoint;
    }

    //공격한다
    public int attack(){
        return strength;
    }
}



