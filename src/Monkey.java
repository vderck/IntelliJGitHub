import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monkey extends Animal {
    //지능
    public int wisdom = 5;

    JButton wisdomPortionBtn = new JButton("지혜의 약");
    JButton healingPortionBtn = new JButton("체력 포션");

    //열매를 던진다
    public int throwFruit(){
        return  10 + wisdom*4;
    }

    //아군 전체 체력 증가
    public int recoverTeamHP() {
        int randomNumber = (int) Math.floor(Math.random()*5)+1;  //1~5까지 랜덤수
        return 10 * randomNumber;
    }

    //민첩의 약을 사용한다
    public void useWisdomPortion(){
        activateBtnUI();
        wisdomPortionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wisdom += 5;
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
        wisdomPortionBtn.setPreferredSize(new Dimension(120,60));
        healingPortionBtn.setPreferredSize(new Dimension(120,60));

        wisdomPortionBtn.setFont(mapleStoryBoldTwenty);
        healingPortionBtn.setFont(mapleStoryBoldTwenty);
        wisdomPortionBtn.setForeground(Color.white);
        wisdomPortionBtn.setBackground(Color.black);
        healingPortionBtn.setForeground(Color.white);
        healingPortionBtn.setBackground(Color.black);
    }

    //폰트
    Font mapleStoryBoldTwenty = new Font("메이플스토리 Bold",Font.BOLD,20);
}
