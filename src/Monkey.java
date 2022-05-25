public class Monkey extends Animal {
    public int wisdom = 5;

    public int throwFruit(){
        int throwFruit = 10 + strength;
        return throwFruit;
    }

    //아군 전체 체력 증가
    public int recoverTeamHP() {
        int randomNumber = (int) Math.floor(Math.random()*5)+1;  //1~5까지 랜덤수
        int recoverTeamHP = 10 * randomNumber;
        return recoverTeamHP;
    }
}
