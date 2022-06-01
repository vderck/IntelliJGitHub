import javax.swing.*;
import java.awt.*;

public class MonkeyHealthBar implements Runnable{
    int monkeyCurrentHealth = 100;
    JProgressBar monkeyHealthBar = new JProgressBar();

    public MonkeyHealthBar() {
        monkeyHealthBar.setBackground(Color.orange);
        monkeyHealthBar.setBounds(20,100,150,30);
    }

    public void CurrentHealth(int monkeyCurrentHealth){
        this.monkeyCurrentHealth = monkeyCurrentHealth;
    }

    @Override
    public void run() {
        while (monkeyCurrentHealth >0){
            try{
                int monkeyHealthBarLength =(int) (monkeyCurrentHealth *1.5);
                monkeyHealthBar.setBounds(20,100,monkeyHealthBarLength,30);
                Thread.sleep(1000);
//                System.out.println("이거 안뜨면 멈추는거임");                                                             // 메인에서 기권할시, while문이 계속 실행되기는 함....흠
            } catch (Exception e){
                e.printStackTrace();
            }
            if(monkeyCurrentHealth <0) {
                monkeyHealthBar.setVisible(false);
            }
        }
    }
}
