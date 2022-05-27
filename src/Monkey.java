public class Monkey extends Animal {
    //지능
    public int wisdom = 5;

    //열매를 던진다
    public int throwFruit(){
        return  10 + wisdom*4;
    }

    //아군 전체 체력 증가
    public int recoverTeamHP() {
        int randomNumber = (int) Math.floor(Math.random()*5)+1;  //1~5까지 랜덤수
        return 10 * randomNumber;
    }
}
