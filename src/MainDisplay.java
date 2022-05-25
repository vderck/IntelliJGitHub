import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MainDisplay extends JFrame {


    public  void mainFrame() {
        // 클래스 객체
        Cat catObject = new Cat();
        Dog dogObject = new Dog();
        Monkey monkeyObject = new Monkey();
        Aligator aligatorObject = new Aligator();
        Bear bearObject = new Bear();

        // 조건식 객체
        ExteriorCondition exteriorCondition = new ExteriorCondition();

        // 패널 구성
        JPanel animalStatus = new JPanel();
        JPanel enemyStatus = new JPanel();
        JPanel teammateList = new JPanel();
        JPanel catSkillList = new JPanel();
        JPanel dogSkillList = new JPanel();
        JPanel monkeySkillList = new JPanel();
        JPanel aligatorSkillList = new JPanel();

        // 아군 기본상태 표시
        JLabel StrengthText = new JLabel("Strength: 5");
        JLabel healthPointText = new JLabel("HealthPoint: 20");
        JLabel agilityText = new JLabel("Agility: 0");
        JLabel defenseText = new JLabel("Defense: 0");
        JLabel wisdomText = new JLabel("Wisdom: 0");
        JLabel viciousnessText = new JLabel("Viciousness: 0");

        animalStatus.add(StrengthText);
        animalStatus.add(healthPointText);
        animalStatus.add(agilityText);
        animalStatus.add(defenseText);
        animalStatus.add(wisdomText);
        animalStatus.add(viciousnessText);

        add(animalStatus);

        //적군 기본 상태 표시
        JLabel enemyStrengthText = new JLabel("Strength: 12");
        JLabel enemyHealthPointText = new JLabel("HealthPoint: 100");

        enemyStatus.add(enemyStrengthText);
        enemyStatus.add(enemyHealthPointText);

        add(enemyStatus);

        // 전투 진행창
        JTextArea battleProgress = new JTextArea(" 전투 진행 상황을 표시합니다.\n 캐릭터를 선택해주세요" );
        JScrollPane battleProgressScroll = new JScrollPane(battleProgress);
        battleProgress.setCaretPosition(battleProgress.getDocument().getLength()); // 맨아래로 스크롤
        add(battleProgressScroll);


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
        JButton catBasicAttack = new JButton("공격한다");
        JButton catSpecialAttack = new JButton("할퀸다");
        JButton catUltimateAttack = new JButton("회피한다");
        JButton catWithDraw = new JButton("기권한다");

        JButton dogBasicAttack = new JButton("공격한다");
        JButton dogSpecialAttack = new JButton("물어뜯는다");
        JButton dogUltimateAttack = new JButton("방어한다");
        JButton dogWithDraw = new JButton("기권한다");

        JButton monkeyBasicAttack = new JButton("공격한다");
        JButton monkeySpecialAttack = new JButton("열매를 던진다");
        JButton monkeyUltimateAttack = new JButton("무효화한다");
        JButton monkeyWithDraw = new JButton("기권한다");

        JButton aligatorBasicAttack = new JButton("일반 공격");
        JButton aligatorSpecialAttack = new JButton("꼬리로 친다");
        JButton aligatorUltimateAttack = new JButton("반사한다");
        JButton aligatorWithDraw = new JButton("기권한다");

        catBasicAttack.setPreferredSize(new Dimension(120,60));
        catSpecialAttack.setPreferredSize(new Dimension(120,60));
        catUltimateAttack.setPreferredSize(new Dimension(120, 60));
        catWithDraw.setPreferredSize(new Dimension(120,60));

        dogBasicAttack.setPreferredSize(new Dimension(120,60));
        dogSpecialAttack.setPreferredSize(new Dimension(120,60));
        dogUltimateAttack.setPreferredSize(new Dimension(120, 60));
        dogWithDraw.setPreferredSize(new Dimension(120,60));

        monkeyBasicAttack.setPreferredSize(new Dimension(120,60));
        monkeySpecialAttack.setPreferredSize(new Dimension(120,60));
        monkeyUltimateAttack.setPreferredSize(new Dimension(120, 60));
        monkeyWithDraw.setPreferredSize(new Dimension(120,60));

        aligatorBasicAttack.setPreferredSize(new Dimension(120,60));
        aligatorSpecialAttack.setPreferredSize(new Dimension(120,60));
        aligatorUltimateAttack.setPreferredSize(new Dimension(120, 60));
        aligatorWithDraw.setPreferredSize(new Dimension(120,60));

        catSkillList.add(catBasicAttack);
        catSkillList.add(catSpecialAttack);
        catSkillList.add(catUltimateAttack);
        catSkillList.add(catWithDraw);

        dogSkillList.add(dogBasicAttack);
        dogSkillList.add(dogSpecialAttack);
        dogSkillList.add(dogUltimateAttack);
        dogSkillList.add(dogWithDraw);

        monkeySkillList.add(monkeyBasicAttack);
        monkeySkillList.add(monkeySpecialAttack);
        monkeySkillList.add(monkeyUltimateAttack);
        monkeySkillList.add(monkeyWithDraw);

        aligatorSkillList.add(aligatorBasicAttack);
        aligatorSkillList.add(aligatorSpecialAttack);
        aligatorSkillList.add(aligatorUltimateAttack);
        aligatorSkillList.add(aligatorWithDraw);

        add(catSkillList);
        add(dogSkillList);
        add(monkeySkillList);
        add(aligatorSkillList);

        catSkillList.setVisible(false);
        dogSkillList.setVisible(false);
        monkeySkillList.setVisible(false);
        aligatorSkillList.setVisible(false);

        // 턴 넘기기
        JButton passTurn = new JButton("턴을 넘긴다");

        // 캐릭터 선택 → 고양이 선택
        cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setForeground(Color.white);
                cat.setBackground(Color.gray);
                dog.setForeground(Color.white);
                dog.setBackground(Color.black);
                monkey.setForeground(Color.white);
                monkey.setBackground(Color.black);
                aligator.setForeground(Color.white);
                aligator.setBackground(Color.black);

                int strength = catObject.strength;
                StrengthText.setText("Strength " + strength);

                int healthPoint = catObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int agility = catObject.agility;
                agilityText.setText("Agility "+ agility);

                catSkillList.setVisible(true);
                dogSkillList.setVisible(false);
                monkeySkillList.setVisible(false);
                aligatorSkillList.setVisible(false);

                agilityText.setVisible(true);
                defenseText.setVisible(false);
                wisdomText.setVisible(false);
                viciousnessText.setVisible(false);

                String characterChoice ="\n 고양이를 선택하셨습니다.\n 스킬을 선택해주세요.";
                battleProgress.append(characterChoice);
                
            }
        });

        // 고양이 스킬 리스트
        // 일반 공격
        catBasicAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                catBasicAttack.setBackground(Color.gray);
                battleProgress.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ catObject.strength+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-catObject.strength);
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catBasicAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                catObject.setHealthPoint(catObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ catObject.healthPoint);

                if (catObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    cat.setVisible(false);
                    catSkillList.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 특수 공격
        catSpecialAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                catSpecialAttack.setBackground(Color.gray);
                battleProgress.append("\n 할퀴기를 시전합니다!" + "\n 곰에게 "+ catObject.claw()+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-catObject.claw());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catSpecialAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                catObject.setHealthPoint(catObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ catObject.healthPoint);

                if (catObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    cat.setVisible(false);
                    catSkillList.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 필살기
        catUltimateAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                catUltimateAttack.setBackground(Color.gray);
                battleProgress.append("\n 회피하기를 시전합니다!" +"\n 곰이 필살기로 공격하려합니다." + "\n 곰의 모든 공격을 회피했습니다!");
                catObject.setHealthPoint(catObject.healthPoint);
                healthPointText.setText("HealthPoint :"+ catObject.healthPoint);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catUltimateAttack.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 기권하기
        catWithDraw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                catWithDraw.setBackground(Color.gray);
                battleProgress.append("\n 소중한 고양이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                cat.setVisible(false);
                catSkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catWithDraw.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        // 캐릭터 선택 → 강아지 선택
        dog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setForeground(Color.white);
                cat.setBackground(Color.black);
                dog.setForeground(Color.white);
                dog.setBackground(Color.gray);
                monkey.setForeground(Color.white);
                monkey.setBackground(Color.black);
                aligator.setForeground(Color.white);
                aligator.setBackground(Color.black);

                int strength = dogObject.strength;
                StrengthText.setText("Strength " + strength);

                int healthPoint = dogObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int defense = dogObject.defense;
                defenseText.setText("Defense "+ defense);

                catSkillList.setVisible(false);
                dogSkillList.setVisible(true);
                monkeySkillList.setVisible(false);
                aligatorSkillList.setVisible(false);

                agilityText.setVisible(false);
                defenseText.setVisible(true);
                wisdomText.setVisible(false);
                viciousnessText.setVisible(false);

                String characterChoice ="\n 강아지를 선택하셨습니다.\n 스킬을 선택해주세요.";
                battleProgress.append(characterChoice);
                
            }
        });

        // 강아지 스킬리스트
        // 일반 공격
        dogBasicAttack.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dogBasicAttack.setBackground(Color.gray);
                battleProgress.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ dogObject.strength+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-dogObject.strength);
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogBasicAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                dogObject.setHealthPoint(dogObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ dogObject.healthPoint);

                if (dogObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dog.setVisible(false);
                    dogSkillList.setVisible(false);

                }

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 특수공격
        dogSpecialAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dogSpecialAttack.setBackground(Color.gray);
                battleProgress.append("\n 물어뜯기를 시전합니다!" + "\n 곰에게 "+ dogObject.bite()+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-dogObject.bite());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogSpecialAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                dogObject.setHealthPoint(dogObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ dogObject.healthPoint);

                if (dogObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dog.setVisible(false);
                    dogSkillList.setVisible(false);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 필살기
        dogUltimateAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dogUltimateAttack.setBackground(Color.gray);
                battleProgress.append("\n 방어하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogUltimateAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 베어너클을 시전합니다! \n" + bearObject.bearKnuckle()+"의 데미지로 공격합니다.");
                dogObject.setHealthPoint(dogObject.healthPoint - bearObject.bearKnuckle() + dogObject.defense);
                healthPointText.setText("HealthPoint :"+ dogObject.healthPoint);
                battleProgress.append("\n 방어하기로 인해 " + dogObject.defense+"의 데미지를 경감합니다.");
                battleProgress.append("\n 오직 " + (bearObject.bearKnuckle()-dogObject.defense) +"의 데미지를 받습니다.");

                if (dogObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dog.setVisible(false);
                    dogSkillList.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //기권하기
        dogWithDraw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dogWithDraw.setBackground(Color.gray);
                battleProgress.append("\n 소중한 강아지를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                dog.setVisible(false);
                dogSkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogWithDraw.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 캐릭터 선택 → 원숭이 선택
        monkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setForeground(Color.white);
                cat.setBackground(Color.black);
                dog.setForeground(Color.white);
                dog.setBackground(Color.black);
                monkey.setForeground(Color.white);
                monkey.setBackground(Color.gray);
                aligator.setForeground(Color.white);
                aligator.setBackground(Color.black);

                int strength = monkeyObject.strength;
                StrengthText.setText("Strength " + strength);

                int healthPoint = monkeyObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int wisdom = monkeyObject.wisdom;
                wisdomText.setText("Wisdom "+ wisdom);

                catSkillList.setVisible(false);
                dogSkillList.setVisible(false);
                monkeySkillList.setVisible(true);
                aligatorSkillList.setVisible(false);

                defenseText.setVisible(false);
                agilityText.setVisible(false);
                wisdomText.setVisible(true);
                viciousnessText.setVisible(false);

                String characterChoice ="\n 원숭이를 선택하셨습니다.\n 스킬을 선택해주세요.";
                battleProgress.append(characterChoice);
            }
        });

        // 원숭이 스킬 리스트
        // 일반 공격
        monkeyBasicAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                monkeyBasicAttack.setBackground(Color.gray);
                battleProgress.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ monkeyObject.strength+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-monkeyObject.strength);
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyBasicAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                monkeyObject.setHealthPoint(monkeyObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ monkeyObject.healthPoint);

                if (monkeyObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkey.setVisible(false);
                    monkeySkillList.setVisible(false);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });



        // 특수공격
        monkeySpecialAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                monkeySpecialAttack.setBackground(Color.gray);
                battleProgress.append("\n 열매를 던집니다!" + "\n 곰에게 "+ monkeyObject.throwFruit()+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-monkeyObject.throwFruit());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeySpecialAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                monkeyObject.setHealthPoint(monkeyObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ monkeyObject.healthPoint);

                if (monkeyObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkey.setVisible(false);
                    monkeySkillList.setVisible(false);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 필살기
        monkeyUltimateAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                monkeyUltimateAttack.setBackground(Color.gray);
                battleProgress.append("\n 무효화를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyUltimateAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 베어너클을 시전합니다! \n " + bearObject.bearKnuckle()+"의 데미지로 공격합니다.");
                battleProgress.append("\n 무효화 효과로 인해 데미지를 받지않습니다!");

                if (monkeyObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkey.setVisible(false);
                    monkeySkillList.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //기권하기
        monkeyWithDraw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                monkeyWithDraw.setBackground(Color.gray);
                battleProgress.append("\n 소중한 원숭이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                monkey.setVisible(false);
                monkeySkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyWithDraw.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 캐릭터 선택 → 악어 선택
        aligator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cat.setForeground(Color.white);
                cat.setBackground(Color.black);
                dog.setForeground(Color.white);
                dog.setBackground(Color.black);
                monkey.setForeground(Color.white);
                monkey.setBackground(Color.black);
                aligator.setForeground(Color.white);
                aligator.setBackground(Color.gray);

                int strength = aligatorObject.strength;
                StrengthText.setText("Strength " + strength);

                int healthPoint = aligatorObject.healthPoint;
                healthPointText.setText("HeathPoint " + healthPoint);

                int visciousness = aligatorObject.visciousness;
                viciousnessText.setText("Visciousness "+ visciousness);

                catSkillList.setVisible(false);
                dogSkillList.setVisible(false);
                monkeySkillList.setVisible(false);
                aligatorSkillList.setVisible(true);

                defenseText.setVisible(false);
                agilityText.setVisible(false);
                wisdomText.setVisible(false);
                viciousnessText.setVisible(true);

                String characterChoice ="\n 악어를 선택하셨습니다.\n 스킬을 선택해주세요.";
                battleProgress.append(characterChoice);
            }
        });

        // 악어 스킬 리스트
        // 일반 공격
        aligatorBasicAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aligatorBasicAttack.setBackground(Color.gray);
                battleProgress.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ aligatorObject.strength+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-aligatorObject.strength);
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorBasicAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                aligatorObject.setHealthPoint(aligatorObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ aligatorObject.healthPoint);

                if (aligatorObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligator.setVisible(false);
                    aligatorSkillList.setVisible(false);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 특수공격
        aligatorSpecialAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aligatorSpecialAttack.setBackground(Color.gray);
                battleProgress.append("\n 꼬리로 후려칩니다!" + "\n 곰에게 "+ aligatorObject.whipWithTail()+"의 데미지를 입힙니다.");
                bearObject.setHealthPoint(bearObject.healthPoint-aligatorObject.whipWithTail());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorSpecialAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 반격합니다! " + bearObject.strength +"의 데미지를 입었습니다.");
                aligatorObject.setHealthPoint(aligatorObject.healthPoint - bearObject.strength);
                healthPointText.setText("HealthPoint :"+ aligatorObject.healthPoint);

                if (aligatorObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligator.setVisible(false);
                    aligatorSkillList.setVisible(false);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 필살기
        aligatorUltimateAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aligatorUltimateAttack.setBackground(Color.gray);
                battleProgress.append("\n 반사하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorUltimateAttack.setBackground(Color.black);
                battleProgress.append("\n 곰이 베어너클을 시전합니다! \n" + bearObject.bearKnuckle()+"의 데미지로 공격합니다. \n 반사하기로 인해 데미지를 반사합니다.");
                bearObject.setHealthPoint(bearObject.healthPoint - bearObject.bearKnuckle());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
                battleProgress.append("\n 곰이 " + bearObject.bearKnuckle() +"의 데미지를 받습니다.");

                if (aligatorObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligator.setVisible(false);
                    aligatorSkillList.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //기권하기
        aligatorWithDraw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                aligatorWithDraw.setBackground(Color.gray);
                battleProgress.append("\n 소중한 악어를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                aligator.setVisible(false);
                aligatorSkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorWithDraw.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 버튼 UI
        cat.setForeground(Color.white);
        cat.setBackground(Color.black);
        dog.setForeground(Color.white);
        dog.setBackground(Color.black);
        monkey.setForeground(Color.white);
        monkey.setBackground(Color.black);
        aligator.setForeground(Color.white);
        aligator.setBackground(Color.black);

        catBasicAttack.setForeground(Color.white);
        catBasicAttack.setBackground(Color.black);
        catSpecialAttack.setForeground(Color.white);
        catSpecialAttack.setBackground(Color.black);
        catUltimateAttack.setForeground(Color.white);
        catUltimateAttack.setBackground(Color.black);
        catWithDraw.setForeground(Color.white);
        catWithDraw.setBackground(Color.black);

        dogBasicAttack.setForeground(Color.white);
        dogBasicAttack.setBackground(Color.black);
        dogSpecialAttack.setForeground(Color.white);
        dogSpecialAttack.setBackground(Color.black);
        dogUltimateAttack.setForeground(Color.white);
        dogUltimateAttack.setBackground(Color.black);
        dogWithDraw.setForeground(Color.white);
        dogWithDraw.setBackground(Color.black);

        monkeyBasicAttack.setForeground(Color.white);
        monkeyBasicAttack.setBackground(Color.black);
        monkeySpecialAttack.setForeground(Color.white);
        monkeySpecialAttack.setBackground(Color.black);
        monkeyUltimateAttack.setForeground(Color.white);
        monkeyUltimateAttack.setBackground(Color.black);
        monkeyWithDraw.setForeground(Color.white);
        monkeyWithDraw.setBackground(Color.black);

        aligatorBasicAttack.setForeground(Color.white);
        aligatorBasicAttack.setBackground(Color.black);
        aligatorSpecialAttack.setForeground(Color.white);
        aligatorSpecialAttack.setBackground(Color.black);
        aligatorUltimateAttack.setForeground(Color.white);
        aligatorUltimateAttack.setBackground(Color.black);
        aligatorWithDraw.setForeground(Color.white);
        aligatorWithDraw.setBackground(Color.black);

        // 레이아웃
        animalStatus.setLayout(new BoxLayout(animalStatus,BoxLayout.Y_AXIS));
        enemyStatus.setLayout(new BoxLayout(enemyStatus,BoxLayout.Y_AXIS));
        teammateList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        catSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        dogSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        monkeySkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        aligatorSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        // 컴포넌트 배치
        setLayout(null);   // 반드시 배치전에 null로 지정
        animalStatus.setBounds(25,320,200,150);
        enemyStatus.setBounds(480,20,200,150);
        teammateList.setBounds(0,500,600,100);
        catSkillList.setBounds(0,600,600,100);
        dogSkillList.setBounds(0,600,600,100);
        monkeySkillList.setBounds(0,600,600,100);
        aligatorSkillList.setBounds(0,600,600,100);
        passTurn.setBounds(180,720,220,60);
        battleProgressScroll.setBounds(300,310,260,120);

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
