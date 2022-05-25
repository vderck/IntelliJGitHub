import javax.swing.*;
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

        // 패널 구성
        JPanel gameOpeningMenu = new JPanel();
        JPanel animalStatus = new JPanel();
        JPanel enemyStatus = new JPanel();
        JPanel teammateList = new JPanel();
        JPanel catSkillList = new JPanel();
        JPanel dogSkillList = new JPanel();
        JPanel monkeySkillList = new JPanel();
        JPanel aligatorSkillList = new JPanel();

        // 아군 기본상태 표시
        JLabel StrengthText = new JLabel("Strength: 5");
        JLabel healthPointText = new JLabel("HealthPoint: 200");
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
        JLabel enemyHealthPointText = new JLabel("HealthPoint: 1000");

        enemyStatus.add(enemyStrengthText);
        enemyStatus.add(enemyHealthPointText);

        add(enemyStatus);

        // 전투 진행창
        JTextArea battleProgress = new JTextArea(" 전투 진행 상황을 표시합니다.\n 캐릭터를 선택해주세요" );
        JScrollPane battleProgressScroll = new JScrollPane(battleProgress);
        battleProgress.setCaretPosition(battleProgress.getDocument().getLength()); // 맨아래로 스크롤
        add(battleProgressScroll);

        //오프닝 메뉴
        JButton startButton = new JButton("시작하기");
        JButton gameDescriptionButton = new JButton("설명듣기");

        startButton.setPreferredSize(new Dimension(120,60));
        gameDescriptionButton.setPreferredSize(new Dimension(120,60));

        gameOpeningMenu.add(startButton);
        gameOpeningMenu.add(gameDescriptionButton);
        add(gameOpeningMenu);

        //오프닝 메뉴 설명하기 창
        JTextArea gameDescriptionText = new JTextArea(" 베어헌트는 주어진 4마리의 동물로 \n 곰을 사냥하는 턴제 RPG 게임입니다. \n 사용할 수 있는 각각의 동물은 \n 고양이,개,원숭이,악어가 있으며, \n 각자마다 독특한 고유 스킬을 보유하고 있습니다. \n 4마리의 동물이 전멸하기전에 곰을 사냥시, \n 게임에 승리합니다. \n 모든 조작은 마우스 클릭으로 이루어집니다. \n 시작하기 버튼을 눌러주세요.");

        add(gameDescriptionText);
        //오프닝 아이콘
        ImageIcon openingIcon = new ImageIcon("images/pixel_opening.png");
        Image openingImage = openingIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        openingIcon.setImage(openingImage);

        JLabel openingLabel = new JLabel();
        openingLabel.setIcon(openingIcon);
        add(openingLabel);

        //캐릭터 아이콘
        ImageIcon catIcon = new ImageIcon("images/pixel_cat.png");                                              // 고양이 아이콘
        Image catImage = catIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);                 // 이미지 크기 조정  ImageIcon → Image 변경  이후 다시 Image → ImageIcon 변경
        catIcon.setImage(catImage);

        JLabel catIconLabel = new JLabel();
        catIconLabel.setIcon(catIcon);
        add(catIconLabel);

        ImageIcon dogIcon = new ImageIcon("images/pixel_dog.png");                                              // 강아지 아이콘
        Image dogImage = dogIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);

        JLabel dogIconLabel = new JLabel();
        dogIconLabel.setIcon(dogIcon);
        add(dogIconLabel);

        ImageIcon monkeyIcon = new ImageIcon("images/pixel_monkey.png");                                        // 원숭이 아이콘
        Image monkeyImage = monkeyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        monkeyIcon.setImage(monkeyImage);

        JLabel monkeyIconLabel = new JLabel();
        monkeyIconLabel.setIcon(monkeyIcon);
        add(monkeyIconLabel);

        ImageIcon aligatorIcon = new ImageIcon("images/pixel_aligator.png");                                    // 악어 아이콘
        Image aligatorImage = aligatorIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        aligatorIcon.setImage(aligatorImage);

        JLabel aligatorIconLabel = new JLabel();
        aligatorIconLabel.setIcon(aligatorIcon);
        add(aligatorIconLabel);

        ImageIcon bearIcon = new ImageIcon("images/pixel_bear.png");                                            // 곰 아이콘
        Image bearImage = bearIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        bearIcon.setImage(bearImage);

        JLabel bearIconLabel = new JLabel();
        bearIconLabel.setIcon(bearIcon);
        add(bearIconLabel);

        catIconLabel.setVisible(false);
        dogIconLabel.setVisible(false);
        monkeyIconLabel.setVisible(false);
        aligatorIconLabel.setVisible(false);

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
        JButton monkeySpecialAttack = new JButton("열매 던진다");
        JButton monkeyUltimateAttack = new JButton("전체 회복");
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

        // 게임 시작하기
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openingLabel.setVisible(false);
                gameOpeningMenu.setVisible(false);
                gameDescriptionText.setVisible(false);

                animalStatus.setVisible(true);
                enemyStatus.setVisible(true);
                battleProgressScroll.setVisible(true);
                teammateList.setVisible(true);
            }
        });

        // 게임 설명듣기
        gameDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameDescriptionText.setVisible(true);
            }
        });

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

                catIconLabel.setVisible(true);
                dogIconLabel.setVisible(false);
                monkeyIconLabel.setVisible(false);
                aligatorIconLabel.setVisible(false);

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

                    catIconLabel.setVisible(false);
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

                    catIconLabel.setVisible(false);
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

                catIconLabel.setVisible(false);
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

                catIconLabel.setVisible(false);
                dogIconLabel.setVisible(true);
                monkeyIconLabel.setVisible(false);
                aligatorIconLabel.setVisible(false);

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

                    dogIconLabel.setVisible(false);
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

                    dogIconLabel.setVisible(false);
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

                    dogIconLabel.setVisible(false);
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

                dogIconLabel.setVisible(false);
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

                catIconLabel.setVisible(false);
                dogIconLabel.setVisible(false);
                monkeyIconLabel.setVisible(true);
                aligatorIconLabel.setVisible(false);

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

                    monkeyIconLabel.setVisible(false);
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

                    monkeyIconLabel.setVisible(false);
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
                battleProgress.append("\n 팀 전체 회복을 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyUltimateAttack.setBackground(Color.black);

                int teamHPIncrease = monkeyObject.recoverTeamHP();
                battleProgress.append("\n 회복의 효과로 팀원 hp가 "+ teamHPIncrease +"씩 증가합니다.");  // 추후 재 검증 하기

                catObject.healthPoint += teamHPIncrease;
                dogObject.healthPoint += teamHPIncrease;
                monkeyObject.healthPoint += teamHPIncrease;
                aligatorObject.healthPoint += teamHPIncrease;

                battleProgress.append("\n 곰이 베어너클을 시전합니다! \n " + bearObject.bearKnuckle()+"의 데미지로 공격합니다.");
                battleProgress.append("\n 원숭이 캐릭터가 " + bearObject.bearKnuckle() +"의 데미지를 받습니다.");
                monkeyObject.setHealthPoint(monkeyObject.healthPoint - bearObject.bearKnuckle());

                healthPointText.setText("HealthPoint :"+ monkeyObject.healthPoint);

                if (monkeyObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
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

                monkeyIconLabel.setVisible(false);
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

                catIconLabel.setVisible(false);
                dogIconLabel.setVisible(false);
                monkeyIconLabel.setVisible(false);
                aligatorIconLabel.setVisible(true);

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

                    aligatorIconLabel.setVisible(false);
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

                    aligatorIconLabel.setVisible(false);
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
                battleProgress.append("\n 곰이 베어너클을 시전합니다! \n " + bearObject.bearKnuckle()+"의 데미지로 공격합니다. \n 반사하기로 인해 데미지를 반사합니다.");
                bearObject.setHealthPoint(bearObject.healthPoint - bearObject.bearKnuckle());
                enemyHealthPointText.setText("HealthPoint :"+ bearObject.getHealthPoint());
                battleProgress.append("\n 곰이 " + bearObject.bearKnuckle() +"의 데미지를 받습니다.");

                if (aligatorObject.getHealthPoint() <= 0){
                    battleProgress.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligatorIconLabel.setVisible(false);
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

                aligatorIconLabel.setVisible(false);
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

        //폰트
        Font notoSansBoldFourteen = new Font("Noto Sans KR", Font.BOLD,14);
        Font notoSansBoldTwenty = new Font("Noto Sans KR", Font.BOLD,20);

        startButton.setFont(notoSansBoldTwenty);
        gameDescriptionButton.setFont(notoSansBoldTwenty);
        gameDescriptionText.setFont(notoSansBoldTwenty);

        StrengthText.setFont(notoSansBoldFourteen);
        healthPointText.setFont(notoSansBoldFourteen);
        agilityText.setFont(notoSansBoldFourteen);
        defenseText.setFont(notoSansBoldFourteen);
        wisdomText.setFont(notoSansBoldFourteen);
        viciousnessText.setFont(notoSansBoldFourteen);

        enemyStrengthText.setFont(notoSansBoldFourteen);
        enemyHealthPointText.setFont(notoSansBoldFourteen);

        cat.setFont(notoSansBoldFourteen);
        dog.setFont(notoSansBoldFourteen);
        monkey.setFont(notoSansBoldFourteen);
        aligator.setFont(notoSansBoldFourteen);

        catBasicAttack.setFont(notoSansBoldFourteen);
        catSpecialAttack.setFont(notoSansBoldFourteen);
        catUltimateAttack.setFont(notoSansBoldFourteen);
        catWithDraw.setFont(notoSansBoldFourteen);
        dogBasicAttack.setFont(notoSansBoldFourteen);
        dogSpecialAttack.setFont(notoSansBoldFourteen);
        dogUltimateAttack.setFont(notoSansBoldFourteen);
        dogWithDraw.setFont(notoSansBoldFourteen);
        monkeyBasicAttack.setFont(notoSansBoldFourteen);
        monkeySpecialAttack.setFont(notoSansBoldFourteen);
        monkeyUltimateAttack.setFont(notoSansBoldFourteen);
        monkeyWithDraw.setFont(notoSansBoldFourteen);
        aligatorBasicAttack.setFont(notoSansBoldFourteen);
        aligatorSpecialAttack.setFont(notoSansBoldFourteen);
        aligatorUltimateAttack.setFont(notoSansBoldFourteen);
        aligatorWithDraw.setFont(notoSansBoldFourteen);

        // 버튼 UI
        gameOpeningMenu.setBackground(Color.white);                                                                     //버튼 밖 프레임 채색 목적

        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        gameDescriptionButton.setForeground(Color.white);
        gameDescriptionButton.setBackground(Color.black);

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
        gameOpeningMenu.setLayout(new FlowLayout(FlowLayout.LEFT, 20,10));
        animalStatus.setLayout(new BoxLayout(animalStatus,BoxLayout.Y_AXIS));
        enemyStatus.setLayout(new BoxLayout(enemyStatus,BoxLayout.Y_AXIS));
        teammateList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        catSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        dogSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        monkeySkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        aligatorSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        // 컴포넌트 배치
        setLayout(null);   // 반드시 배치전에 null로 지정
        gameOpeningMenu.setBounds(150,220,300,80);
        gameDescriptionText.setBounds(70,350, 450,260);
        catIconLabel.setBounds(-60,100,200,200);
        dogIconLabel.setBounds(-20,120,250,200);
        monkeyIconLabel.setBounds(-30,120,200,200);
        aligatorIconLabel.setBounds(0,60,300,300);
        bearIconLabel.setBounds(360,-110,600,600);
        animalStatus.setBounds(25,320,140,100);
        enemyStatus.setBounds(440,20,200,40);
        teammateList.setBounds(0,500,600,100);
        catSkillList.setBounds(0,600,600,100);
        dogSkillList.setBounds(0,600,600,100);
        monkeySkillList.setBounds(0,600,600,100);
        aligatorSkillList.setBounds(0,600,600,100);
        battleProgressScroll.setBounds(300,310,260,120);
        openingLabel.setBounds(0,0,600,800);

        // 초기 UI 설정
        gameDescriptionText.setVisible(false);
        animalStatus.setVisible(false);
        enemyStatus.setVisible(false);
        battleProgressScroll.setVisible(false);
        teammateList.setVisible(false);

        catSkillList.setVisible(false);
        dogSkillList.setVisible(false);
        monkeySkillList.setVisible(false);
        aligatorSkillList.setVisible(false);
        // 기본 UI 설정
        setSize(600,800);
        setTitle("베어 헌트");
        setVisible(true); // setVisible 함수가 화면설정 이전으로 가게되면 화면 구성이전의 화면들은 보여지지 않음

        // Exit시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public static void main(String[] args) {
        MainDisplay mainDisplay = new MainDisplay();
        mainDisplay.mainFrame();


    }
}
