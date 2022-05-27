public class Dog extends Animal{

    //방어력
    public int defense = 5;

    //물어뜯는다
    public int bite(){
        return strength*3;
    }

    //방어한다
    public int defend() {
        return strength*2;
    }
}
