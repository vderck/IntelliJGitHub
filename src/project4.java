import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class project4 extends JFrame { //상속으로 인한 코드의 가독성

    public void timerMethod(){

        // 패널 및 버튼 생성
        JPanel jPanel = new JPanel();
        JButton jbutton = new JButton("타이머 설정");
        JTextField jTextField = new JTextField("숫자로 (초)입력");
        JLabel jLabel = new JLabel("시간 표시");

        // 화면 설정
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jbutton);
        add(jPanel);

        // 버튼 컬러
        jbutton.setForeground(Color.white);
        jbutton.setBackground(new Color(0,0,0,255));

        // 폰트
        Font NotoSans = new Font("Noto Sans KR", Font.PLAIN,12);
        jbutton.setFont(NotoSans);
        jTextField.setFont(NotoSans);
        jLabel.setFont(NotoSans);

        // 입출력과 타이머 기능
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataStr = jTextField.getText();
                // System.out.println(dataStr); // 현재 입력이 들어오고 있음
                final int[] dataInt = {Integer.parseInt(dataStr)}; //

                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if(dataInt[0] == 0){
                            jLabel.setText("남은 시간 0 초");
                            timer.cancel();
                        } else{
                            int dataIntCount = dataInt[0];// innerclass 변수는 needs to be final 혹은 effectively final → dataInt[0] 변경     라인29,35,39,40 int dataInt → final int[] 변경 by 인텔리제이 내부기능                                                                                       From the inner class you can't assign value to a local variable (itself) declared somewhere in the enclosing class, but you can change state (call methods, setters, ...) of the referenced object (if the variable points to some object and not to a primitive type). And array is object.
                            dataInt[0]--;
                            // System.out.println(dataIntCount); // 현재 출력이 되고 있음
                            String dataStrCount = String.valueOf(dataIntCount);
                            jLabel.setText("남은 시간 " +dataStrCount+"초");
                        }
                    }
                };
                timer.schedule(timerTask,0,1000); // 태스크발동, 0ms 즉시 실행, 1000ms 매구간 실행
            }
        });

        // 기본 UI 설정
        setSize(500,500);
        setTitle("GUI Timer");
        setVisible(true); // setVisible 함수가 화면설정 이전으로 가게되면 화면 구성이전의 화면들은 보여지지 않음
        setLayout(null);

        // 컴포넌트 배치
        jPanel.setBounds(200,150,100,100);

        // Exit시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        project4 timerVar = new project4();
        timerVar.timerMethod();

    }
}
