import javax.swing.*;
import java.awt.*;

public class CatHealthBar implements Runnable {

    int catCurrentHealth = 100;
    JProgressBar catHealthBar = new JProgressBar();

    public CatHealthBar() {
        catHealthBar.setBackground(Color.green);
        catHealthBar.setBounds(20,100,150,30);
    }

    public void CurrentHealth(int catCurrentHealth){
        this.catCurrentHealth = catCurrentHealth;
    }

    @Override
    public void run() {

        while (catCurrentHealth >0){
            try{
                int catHealthBarLength =(int) (catCurrentHealth*1.5);
                catHealthBar.setBounds(20,100,catHealthBarLength,30);
                Thread.sleep(1000);
//                System.out.println("이거 안뜨면 멈추는거임");                                                             // 메인에서 기권할시, while문이 계속 실행되기는 함....흠
            } catch (Exception e){
                e.printStackTrace();
            }
            if(catCurrentHealth <0) {
                catHealthBar.setVisible(false);
            }

        }
    }
}
