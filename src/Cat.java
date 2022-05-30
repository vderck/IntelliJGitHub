import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cat extends Animal{
    //민첩
    public int agility = 5;
    int fourMultiples = 4;

    // 아이템
    JButton agilityPortionBtn = new JButton("민첩의 약");
    JButton healingPortionBtn = new JButton("체력 포션");


    //할퀸다
    public int claw(){
        return strength + agility*fourMultiples;
    }

    //회피한다
    public boolean avoid(){
        return Math.random() < 0.5;
    }

    //민첩의 약을 사용한다
    public void useAgilityPortion(){
        activateBtnUI();
        agilityPortionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agility += 5;
            }
        });
    }

    //체력 포션을 사용한다.
    public void useHealingPortion(){
        activateBtnUI();
        healingPortionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                healthPoint += 30;
            }
        });
    }

    public void activateBtnUI(){
        agilityPortionBtn.setPreferredSize(new Dimension(120,60));
        healingPortionBtn.setPreferredSize(new Dimension(120,60));

        agilityPortionBtn.setFont(notoSansBoldFourteen);
        healingPortionBtn.setFont(notoSansBoldFourteen);
        agilityPortionBtn.setForeground(Color.white);
        agilityPortionBtn.setBackground(Color.black);
        healingPortionBtn.setForeground(Color.white);
        healingPortionBtn.setBackground(Color.black);
    }

    //폰트
    Font notoSansBoldFourteen = new Font("Noto Sans KR", Font.BOLD,14);
}
