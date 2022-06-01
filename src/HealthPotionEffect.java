import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class HealthPotionEffect extends JComponent{
    ImageIcon healthPotionIcon = new ImageIcon("images/pixel_healthPotion.png");

    JLabel healPotionLabel = new JLabel(scaleImage());
    int threadCount = 40;

    //이펙트 랜덤 범위 (X,Y 좌표)
    public void EffectComponent() {
        int randomX = (int) Math.floor((Math.random()*120)+1);                                                          // 1~120 사이의 수
        int randomY = (int) Math.floor((Math.random()*130)+1);                                                          // 1~130 사이의 수

        add(healPotionLabel);

        healPotionLabel.setVisible(true);
        healPotionLabel.setBounds(randomX,randomY,200,200);
    }

    //이미지 크기 조정
    public ImageIcon scaleImage() {
        int randomWidthAndHeight = (int) Math.floor((Math.random()*21)+20);                                             // 20~40 사이의 수

        Image healImage = healthPotionIcon.getImage().getScaledInstance(randomWidthAndHeight,randomWidthAndHeight,Image.SCALE_DEFAULT);
        healthPotionIcon.setImage(healImage);
        return healthPotionIcon;
    }

    //이펙트 사용
    public void useEffect() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(threadCount > 0){
                    scaleImage();
                    EffectComponent();
                    threadCount--;
                } else{
                    healPotionLabel.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);
    }
}
