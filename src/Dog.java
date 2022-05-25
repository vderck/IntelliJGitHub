public class Dog extends Animal{

    int strength = 8;
    public int defense = 5;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int bite(){
        int bite = strength+4;
        return bite;
    }
}
