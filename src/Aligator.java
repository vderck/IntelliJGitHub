public class Aligator extends Animal {
    public int visciousness = 10;

    public int getAgility() {
        return visciousness;
    }

    public void setAgility(int visciousness){
        this.visciousness = visciousness;
    }

    public int whipWithTail() {
        int whipWithTail = strength + 10;
        return whipWithTail;
    }

    public String reflect() {
        String reflect = "적의 공격을 반사합니다!";
        return reflect;
    }


}
