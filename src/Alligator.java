import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alligator extends Animal {
    //비열함
    public int viciousness = 10;

    JButton viciousnessPortionBtn = new JButton("비열함의 약");
    JButton healingPortionBtn = new JButton("체력 포션");
    //꼬리로 때린다
    public int whipWithTail() {
        return strength + viciousness *4;
    }

    //반사한다
    public int reflect(int element) {
        return element * 2;
    }

    public void useViciousnessPortion(){
        activateBtnUI();
        viciousnessPortionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viciousness += 5;
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
        viciousnessPortionBtn.setPreferredSize(new Dimension(120,60));
        healingPortionBtn.setPreferredSize(new Dimension(120,60));

        viciousnessPortionBtn.setFont(notoSansBoldFourteen);
        healingPortionBtn.setFont(notoSansBoldFourteen);
        viciousnessPortionBtn.setForeground(Color.white);
        viciousnessPortionBtn.setBackground(Color.black);
        healingPortionBtn.setForeground(Color.white);
        healingPortionBtn.setBackground(Color.black);
    }

    //폰트
    Font notoSansBoldFourteen = new Font("Noto Sans KR", Font.BOLD,14);

}
