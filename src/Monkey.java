public class Monkey extends Animal {
    public int wisdom = 5;

    public int getWisdom() {
        return wisdom;
    }

    public void setAgility(int agility){
        this.wisdom = wisdom;
    }

    public int throwFruit(){
        int throwFruit = 10 + strength;
        return throwFruit;
    }

    public String invalidate() {
        String invalidate = "공격을 무효화합니다.";
        return invalidate;
    }
}
