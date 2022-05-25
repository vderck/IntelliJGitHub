public class Cat extends Animal{

    int strength = 6;
    public int agility = 5;

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility){
        this.agility = agility;
    }

    public int claw(){
        int claw = strength+4;
        return claw;
    }

    public String avoid(){
        String avoid = "곰의 공격을 회피합니다.";
        return avoid;
    }

}
