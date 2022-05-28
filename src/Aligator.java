public class Aligator extends Animal {
    //비열함
    public int visciousness = 10;

    //꼬리로 때린다
    public int whipWithTail() {
        return strength + visciousness*4;
    }

    //반사한다
    public int reflect(int element) {
        return element * 2;
    }

}
