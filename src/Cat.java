public class Cat extends Animal{

    //민첩
    public int agility = 5;

    //할퀸다
    public int claw(){
        return strength + agility*4;
    }

    //회피한다
    public boolean avoid(){
        return Math.random() < 0.5;
    }
}
