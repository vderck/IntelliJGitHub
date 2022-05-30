import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dog extends Animal{

    //방어력
    public int defense = 5;

    JButton defensePortionBtn = new JButton("방어의 약");
    JButton healingPortionBtn = new JButton("체력 포션");
    //물어뜯는다
    public int bite(){
        return strength*3;
    }

    //방어한다
    public int defend() {
        return defense;
    }

    //방어의 약을 사용한다
    public void useDefensePortion(){
        activateBtnUI();
        defensePortionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defense += 5;
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
        defensePortionBtn.setPreferredSize(new Dimension(120,60));
        healingPortionBtn.setPreferredSize(new Dimension(120,60));

        defensePortionBtn.setFont(notoSansBoldFourteen);
        healingPortionBtn.setFont(notoSansBoldFourteen);
        defensePortionBtn.setForeground(Color.white);
        defensePortionBtn.setBackground(Color.black);
        healingPortionBtn.setForeground(Color.white);
        healingPortionBtn.setBackground(Color.black);
    }

    //폰트
    Font notoSansBoldFourteen = new Font("Noto Sans KR", Font.BOLD,14);
}
