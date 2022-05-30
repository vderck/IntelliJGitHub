import javax.swing.*;
import java.awt.*;

public class HealEffect extends JComponent {

    int randomX = (int) Math.floor((Math.random()*120)+1);                                                              //1~120사이의 수
    int randomY = (int) Math.floor((Math.random()*160)+1);                                                              //1~200사이의 수

    int randomWidthAndHeight = (int) Math.floor((Math.random()*21)+20);                                                    //20~40사이의 수
    public void HealEffect() {
        ImageIcon healIcon = new ImageIcon("images/pixel_heal.png");
        Image healImage = healIcon.getImage().getScaledInstance(randomWidthAndHeight,randomWidthAndHeight,Image.SCALE_DEFAULT);
        healIcon.setImage(healImage);

        JLabel healLabel = new JLabel();
        healLabel.setIcon(healIcon);
        add(healLabel);

        healLabel.setBounds(randomX,randomY,200,200);
    }

}
