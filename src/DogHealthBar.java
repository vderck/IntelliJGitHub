import javax.swing.*;
import java.awt.*;

public class DogHealthBar implements Runnable {

    int dogCurrentHealth = 100;
    JProgressBar dogHealthBar = new JProgressBar();

    public DogHealthBar() {
        dogHealthBar.setBackground(Color.magenta);
        dogHealthBar.setBounds(20,100,150,30);
    }

    public void CurrentHealth(int dogCurrentHealth){
        this.dogCurrentHealth = dogCurrentHealth;
    }

    @Override
    public void run() {
        while (dogCurrentHealth >0){
            try{
                int dogHealthBarLength =(int) (dogCurrentHealth *1.5);
                dogHealthBar.setBounds(20,100,dogHealthBarLength,30);
                Thread.sleep(1000);
//                System.out.println("이거 안뜨면 멈추는거임");                                                             // 메인에서 기권할시, while문이 계속 실행되기는 함....흠
            } catch (Exception e){
                e.printStackTrace();
            }
            if(dogCurrentHealth <0) {
                dogHealthBar.setVisible(false);
            }
        }
    }
}
