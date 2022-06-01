import javax.swing.*;
import java.awt.*;

public class AlligatorHealthBar implements Runnable{
    int alligatorCurrentHealth = 100;
    JProgressBar alligatorHealthBar = new JProgressBar();

    public AlligatorHealthBar() {
        alligatorHealthBar.setBackground(Color.cyan);
        alligatorHealthBar.setBounds(20,100,150,30);
    }

    public void CurrentHealth(int alligatorCurrentHealth){
        this.alligatorCurrentHealth = alligatorCurrentHealth;
    }

    @Override
    public void run() {
        while (alligatorCurrentHealth >0){
            try{
                int alligatorHealthBarLength =(int) (alligatorCurrentHealth *1.5);
                alligatorHealthBar.setBounds(20,100,alligatorHealthBarLength,30);
                Thread.sleep(1000);
//                System.out.println("이거 안뜨면 멈추는거임");                                                             // 메인에서 기권할시, while문이 계속 실행되기는 함....흠
            } catch (Exception e){
                e.printStackTrace();
            }
            if(alligatorCurrentHealth <0) {
                alligatorHealthBar.setVisible(false);
            }
        }
    }
}
