import javax.swing.*;
import java.awt.*;

public class BearHealthBar implements Runnable{
    int bearCurrentHealth = 1000;
    JProgressBar bearHealthBar = new JProgressBar();

    public BearHealthBar() {
        bearHealthBar.setBackground(Color.green);
        bearHealthBar.setBounds(360,60,150,30);
    }

    public void CurrentHealth(int bearCurrentHealth){
        this.bearCurrentHealth = bearCurrentHealth;
    }
    @Override
    public void run() {

        while (bearCurrentHealth >0){
            try{
                int bearHealthBarLength = bearCurrentHealth/5;
                bearHealthBar.setBounds(360,60,bearHealthBarLength,30);
                Thread.sleep(1000);
//                System.out.println("이거 안뜨면 멈추는거임");                                                             // 메인에서 기권할시, while문이 계속 실행되기는 함....흠
            } catch (Exception e){
                e.printStackTrace();
            }
            if(bearCurrentHealth <0) {
                bearHealthBar.setVisible(false);
            }
        }

    }
}
