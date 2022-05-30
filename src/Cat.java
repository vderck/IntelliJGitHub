public class Cat extends Animal{

    //민첩
    public int agility = 5;
    int fourMultiples = 4;

    //할퀸다
    public int claw(){
        int damage = strength + agility*fourMultiples;
        return damage;
    }

    //회피한다
    public boolean avoid(){
        return Math.random() < 0.5;
    }
}
