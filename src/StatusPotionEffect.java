import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class StatusPotionEffect extends JComponent{

    ImageIcon statusPotionIcon = new ImageIcon("images/pixel_statusPotion.png");

    JLabel statusPotionLabel = new JLabel(scaleImage());
    int threadCount = 40;

    //이펙트 랜덤 범위 (X,Y 좌표)
    public void EffectComponent() {
        int randomX = (int) Math.floor((Math.random()*120)+1);                                                          // 1~120 사이의 수
        int randomY = (int) Math.floor((Math.random()*160)+1);                                                          // 1~160 사이의 수

        add(statusPotionLabel);

        statusPotionLabel.setVisible(true);
        statusPotionLabel.setBounds(randomX,randomY,200,200);
    }

    //이미지 크기 조정
    public ImageIcon scaleImage() {
        Image statusPotionImage = statusPotionIcon.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        statusPotionIcon.setImage(statusPotionImage);
        return statusPotionIcon;
    }

    //이펙트 사용
    public void useEffect() {
        java.util.Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(threadCount > 0){
                    scaleImage();
                    EffectComponent();
                    threadCount--;
                } else{
                    statusPotionLabel.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);
    }
}
