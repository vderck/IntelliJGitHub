public class Animal {
    public int strength = 7;
    public int healthPoint = 200;

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

    // 밑에 부분 전부 사용 할 것
    public int attack(){
        return strength;
    }

    void die(){
        if (healthPoint <= 0){
            String deathComment = "현재 전투중인 동물이 사망하였습니다.";
        }
    }

    void withDraw(){
            String withDrawComment = "현재 전투에서 도망칩니다.";
    }
}



