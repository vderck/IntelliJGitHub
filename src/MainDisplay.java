import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainDisplay extends JFrame {


    public  void mainFrame() {
        // 클래스 객체
        Cat catObject = new Cat();
        Dog dogObject = new Dog();
        Monkey monkeyObject = new Monkey();
        Aligator aligatorObject = new Aligator();

        // 패널 구성
        JPanel animalStatus = new JPanel();
        JPanel enemyStatus = new JPanel();
        JPanel teammateList = new JPanel();
        JPanel behaviorList = new JPanel();

        // 아군 기본상태 표시
        JLabel attackText = new JLabel("Attack: 5");
        JLabel healthPointText = new JLabel("HealthPoint: 20");
        JLabel agilityText = new JLabel("Agility: 0");
        JLabel defenseText = new JLabel("Defense: 0");
        JLabel widsomText = new JLabel("Wisdom: 0");
        JLabel viciousnessText = new JLabel("Viciousness: 0");

        animalStatus.add(attackText);
        animalStatus.add(healthPointText);
        animalStatus.add(agilityText);
        animalStatus.add(defenseText);
        animalStatus.add(widsomText);
        animalStatus.add(viciousnessText);

        add(animalStatus);

        //적군 기본 상태 표시
        JLabel enemyAttackText = new JLabel("Attack: 12");
        JLabel enemyHealthPointText = new JLabel("HealthPoint: 100");

        enemyStatus.add(enemyAttackText);
        enemyStatus.add(enemyHealthPointText);

        add(enemyStatus);

        // 캐릭터 리스트
        JButton cat = new JButton("고양이");
        JButton dog = new JButton("강아지");
        JButton monkey = new JButton("원숭이");
        JButton aligator = new JButton("악어");

        cat.setPreferredSize(new Dimension(120,60));
        dog.setPreferredSize(new Dimension(120,60));
        monkey.setPreferredSize(new Dimension(120,60));
        aligator.setPreferredSize(new Dimension(120,60));

        teammateList.add(cat);
        teammateList.add(dog);
        teammateList.add(monkey);
        teammateList.add(aligator);

        add(teammateList);

        // 행동 리스트
        JButton basicAttack = new JButton("일반 공격");
        JButton specialAttack = new JButton("특수 공격");
        JButton ultimateAttack = new JButton("필살기");
        JButton withDraw = new JButton("기권한다");

        basicAttack.setPreferredSize(new Dimension(120,60));
        specialAttack.setPreferredSize(new Dimension(120,60));
        ultimateAttack.setPreferredSize(new Dimension(120, 60));
        withDraw.setPreferredSize(new Dimension(120,60));

        behaviorList.add(basicAttack);
        behaviorList.add(specialAttack);
        behaviorList.add(ultimateAttack);
        behaviorList.add(withDraw);

        add(behaviorList);

        // 턴 넘기기
        JButton passTurn = new JButton("턴을 넘긴다");
        
       
        
        // 캐릭터 선택 → 고양이 선택
        cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setBackground(Color.gray);
                cat.setForeground(Color.white);
                dog.setBackground(Color.black);
                dog.setForeground(Color.white);
                monkey.setBackground(Color.black);
                monkey.setForeground(Color.white);
                aligator.setBackground(Color.black);
                aligator.setForeground(Color.white);

                basicAttack.setText("공격한다");
                specialAttack.setText("할퀸다");
                ultimateAttack.setText("회피한다");
                withDraw.setText("기권한다");

                int attack = catObject.attack;
                attackText.setText("Attack " + attack);

                int healthPoint = catObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int agility = catObject.agility;
                agilityText.setText("Agility "+ agility);

                agilityText.setVisible(true);
                defenseText.setVisible(false);
                widsomText.setVisible(false);
                viciousnessText.setVisible(false);
            }
        });

        // 캐릭터 선택 → 강아지 선택
        dog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setBackground(Color.black);
                cat.setForeground(Color.white);
                dog.setBackground(Color.gray);
                dog.setForeground(Color.white);
                monkey.setBackground(Color.black);
                monkey.setForeground(Color.white);
                aligator.setBackground(Color.black);
                aligator.setForeground(Color.white);

                basicAttack.setText("공격한다");
                specialAttack.setText("물어뜯는다");
                ultimateAttack.setText("방어한다");
                withDraw.setText("기권한다");

                int attack = dogObject.attack;
                attackText.setText("Attack " + attack);

                int healthPoint = dogObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int defense = dogObject.defense;
                defenseText.setText("Defense "+ defense);

                agilityText.setVisible(false);
                defenseText.setVisible(true);
                widsomText.setVisible(false);
                viciousnessText.setVisible(false);
            }
        });

        // 캐릭터 선택 → 원숭이 선택
        monkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setBackground(Color.black);
                cat.setForeground(Color.white);
                dog.setBackground(Color.black);
                dog.setForeground(Color.white);
                monkey.setBackground(Color.gray);
                monkey.setForeground(Color.white);
                aligator.setBackground(Color.black);
                aligator.setForeground(Color.white);

                basicAttack.setText("공격한다");
                specialAttack.setText("열매를 던진다");
                ultimateAttack.setText("무효화한다");
                withDraw.setText("기권한다");

                int attack = monkeyObject.attack;
                attackText.setText("Attack " + attack);

                int healthPoint = monkeyObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int wisdom = monkeyObject.wisdom;
                widsomText.setText("Wisdom "+ wisdom);

                defenseText.setVisible(false);
                agilityText.setVisible(false);
                widsomText.setVisible(true);
                viciousnessText.setVisible(false);
            }
        });

        // 캐릭터 선택 → 악어 선택
        aligator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setBackground(Color.black);
                cat.setForeground(Color.white);
                dog.setBackground(Color.black);
                dog.setForeground(Color.white);
                monkey.setBackground(Color.black);
                monkey.setForeground(Color.white);
                aligator.setBackground(Color.gray);
                aligator.setForeground(Color.white);

                basicAttack.setText("공격한다");
                specialAttack.setText("꼬리로 친다");
                ultimateAttack.setText("반사한다");
                withDraw.setText("기권한다");

                int attack = aligatorObject.attack;
                attackText.setText("Attack " + attack);

                int healthPoint = aligatorObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int visciousness = aligatorObject.visciousness;
                viciousnessText.setText("Visciousness "+ visciousness);

                defenseText.setVisible(false);
                agilityText.setVisible(false);
                widsomText.setVisible(false);
                viciousnessText.setVisible(true);
            }
        });

        add(passTurn);
        // UI 레이아웃
        animalStatus.setLayout(new BoxLayout(animalStatus,BoxLayout.Y_AXIS));
        enemyStatus.setLayout(new BoxLayout(enemyStatus,BoxLayout.Y_AXIS));
        teammateList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        behaviorList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        // 컴포넌트 배치
        setLayout(null);   // 반드시 배치전에 null로 지정
        animalStatus.setBounds(10,300,200,200);
        enemyStatus.setBounds(480,20,200,200);
        teammateList.setBounds(0,500,600,100);
        behaviorList.setBounds(0,600,600,100);
        passTurn.setBounds(180,720,220,60);

        // 폰트
        Font NotoSans = new Font("Noto Sans KR", Font.PLAIN,12);

        // 기본 UI 설정
        setSize(600,1000);
        setTitle("곰 사냥하기");
        setVisible(true); // setVisible 함수가 화면설정 이전으로 가게되면 화면 구성이전의 화면들은 보여지지 않음

        // Exit시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public static void main(String[] args) {
        MainDisplay mainDisplay = new MainDisplay();
        mainDisplay.mainFrame();


    }
}
