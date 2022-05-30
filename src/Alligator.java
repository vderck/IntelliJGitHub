public class Alligator extends Animal {
    //비열함
    public int viciousness = 10;

    //꼬리로 때린다
    public int whipWithTail() {
        return strength + viciousness *4;
    }

    //반사한다
    public int reflect(int element) {
        return element * 2;
    }

}
