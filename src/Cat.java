public class Cat extends Animal{

    int attack = 6;
    public int agility = 5;

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility){
        this.agility = agility;
    }

    void claw(){
        attack = 10;
        bear.healthPoint = bear.healthPoint - attack;
    }

    void avoid(){
        String avoidComment = "곰의 공격을 회피합니다.";
    }

}
