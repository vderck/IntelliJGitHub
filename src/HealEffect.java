import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class HealEffect extends JComponent{
    ImageIcon healIcon = new ImageIcon("images/pixel_heal.png");

    JLabel healLabel = new JLabel(scaleImage());
    int threadCount = 40;

    public void HealComponent() {
        int randomX = (int) Math.floor((Math.random()*120)+1);                                                          // 1~120 사이의 수
        int randomY = (int) Math.floor((Math.random()*160)+1);                                                          // 1~160 사이의 수

        add(healLabel);

        healLabel.setVisible(true);
        healLabel.setBounds(randomX,randomY,200,200);
    }
    public ImageIcon scaleImage() {
        int randomWidthAndHeight = (int) Math.floor((Math.random()*21)+20);                                             // 20~40 사이의 수

        Image healImage = healIcon.getImage().getScaledInstance(randomWidthAndHeight,randomWidthAndHeight,Image.SCALE_DEFAULT);
        healIcon.setImage(healImage);
        return healIcon;
    }

    public void HealEffect() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(threadCount > 0){
                    HealComponent();
                    threadCount--;
                } else{
                    healLabel.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);
    }
}
