import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;


public class MainDisplay extends JFrame {


    public  void mainFrame() {
        // 클래스 객체
        Cat cat = new Cat();
        Dog dog = new Dog();
        Monkey monkey = new Monkey();
        Aligator aligator = new Aligator();
        Bear bear = new Bear();
        LifeCount lifeCount = new LifeCount();
        TimerCondition timerCondition = new TimerCondition();

        // 패널 구성
        JPanel gameOpeningMenu = new JPanel();
        JPanel animalStatus = new JPanel();
        JPanel enemyStatus = new JPanel();
        JPanel animalList = new JPanel();
        JPanel catSkillList = new JPanel();
        JPanel dogSkillList = new JPanel();
        JPanel monkeySkillList = new JPanel();
        JPanel aligatorSkillList = new JPanel();

        //오프닝 메뉴
        JButton startButton = new JButton("시작하기");
        JButton gameDescriptionButton = new JButton("설명듣기");

        startButton.setPreferredSize(new Dimension(120,60));
        gameDescriptionButton.setPreferredSize(new Dimension(120,60));

        gameOpeningMenu.add(startButton);
        gameOpeningMenu.add(gameDescriptionButton);
        add(gameOpeningMenu);

        //오프닝 메뉴 설명하기 창
        JTextArea gameDescriptionText = new JTextArea("""
                베어헌트는 주어진 4마리의 동물로
                곰을 사냥하는 턴제 RPG 게임입니다.
                사용할 수 있는 각각의 동물은
                고양이,개,원숭이,악어가 있으며,
                각 캐릭터마다 독특한 고유 스킬을 보유하고 있습니다.
                4마리의 동물이 전멸하기전에 곰을 사냥시,
                게임에 승리합니다.
                더 높은 점수로 배틀에 승리해보세요!
                모든 조작은 마우스 클릭으로 이루어집니다.
                시작하기 버튼을 눌러주세요.""".indent(1));

        add(gameDescriptionText);

        // 전투 과정 디스플레이 (텍스트 형식)
        JTextArea battleTextDipslay = new JTextArea(" 전투 진행 상황을 표시합니다.\n 캐릭터를 선택해주세요" );
        JScrollPane battleTextDisplayPane = new JScrollPane(battleTextDipslay);
        battleTextDipslay.setCaretPosition(battleTextDipslay.getDocument().getLength()); // 맨아래로 스크롤
        add(battleTextDisplayPane);

        //라이프 아이콘
        ImageIcon lifeIcon = new ImageIcon("images/pixel_heart.png");
        Image lifeImage = lifeIcon.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        lifeIcon.setImage(lifeImage);

        JLabel lifeLabelOne = new JLabel();                                                                             // 첫번째 목슴
        lifeLabelOne.setIcon(lifeIcon);
        add(lifeLabelOne);

        JLabel lifeLabelTwo = new JLabel();                                                                             // 두번째 목슴
        lifeLabelTwo.setIcon(lifeIcon);
        add(lifeLabelTwo);

        JLabel lifeLabelThree = new JLabel();                                                                           // 세번째 목슴
        lifeLabelThree.setIcon(lifeIcon);
        add(lifeLabelThree);

        JLabel lifeLabelFour = new JLabel();                                                                            // 네번째 목슴
        lifeLabelFour.setIcon(lifeIcon);
        add(lifeLabelFour);

        // 아군 기본상태 표시
        JLabel strengthDisplay = new JLabel("Strength: 10");
        JLabel healthPointDisplay = new JLabel("HealthPoint: 100");
        JLabel agilityDisplay = new JLabel("");
        JLabel defenseDisplay = new JLabel("");
        JLabel wisdomDisplay = new JLabel("");
        JLabel viciousnessDisplay = new JLabel("");

        animalStatus.add(strengthDisplay);
        animalStatus.add(healthPointDisplay);
        animalStatus.add(agilityDisplay);
        animalStatus.add(defenseDisplay);
        animalStatus.add(wisdomDisplay);
        animalStatus.add(viciousnessDisplay);

        add(animalStatus);

        //적군 기본 상태 표시
        JLabel enemyStrengthDisplay = new JLabel("Strength: 12");
        JLabel enemyHealthPointDisplay = new JLabel("HealthPoint: 1000");

        enemyStatus.add(enemyStrengthDisplay);
        enemyStatus.add(enemyHealthPointDisplay);

        add(enemyStatus);

        //공격 이펙트
        AttackEffect attackEffect = new AttackEffect();                                                                 //실행시 attackEffect.launchEffect() 로 실행
        add(attackEffect);
        //엔딩 점수
        JLabel lastScore = new JLabel("");
        add(lastScore);

        //오프닝 아이콘
        ImageIcon openingIcon = new ImageIcon("images/pixel_opening.png");
        Image openingImage = openingIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        openingIcon.setImage(openingImage);

        JLabel openingLabel = new JLabel();
        openingLabel.setIcon(openingIcon);
        add(openingLabel);

        //승리 아이콘
        ImageIcon gameVictoryIcon = new ImageIcon("images/pixel_victory.png");
        Image gameVictoryImage = gameVictoryIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        gameVictoryIcon.setImage(gameVictoryImage);

        JLabel gameVictoryEnding = new JLabel();
        gameVictoryEnding.setIcon(gameVictoryIcon);
        add(gameVictoryEnding);

        //패배 아이콘
        ImageIcon gameoverIcon = new ImageIcon("images/pixel_gameover.png");
        Image gameoverImage = gameoverIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        gameoverIcon.setImage(gameoverImage);

        JLabel gameoverEnding = new JLabel();
        gameoverEnding.setIcon(gameoverIcon);
        add(gameoverEnding);

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
        JButton catBtn = new JButton("고양이");
        JButton dogBtn = new JButton("강아지");
        JButton monkeyBtn = new JButton("원숭이");
        JButton aligatorBtn = new JButton("악어");

        catBtn.setPreferredSize(new Dimension(120,60));
        dogBtn.setPreferredSize(new Dimension(120,60));
        monkeyBtn.setPreferredSize(new Dimension(120,60));
        aligatorBtn.setPreferredSize(new Dimension(120,60));

        animalList.add(catBtn);
        animalList.add(dogBtn);
        animalList.add(monkeyBtn);
        animalList.add(aligatorBtn);

        add(animalList);

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

        //전투 시간 타이머
        JLabel battleTime = new JLabel("120 초");

        add(battleTime);
        //전투 통합 프레임
        DrawRectangleFrame drawRectangleFrame = new DrawRectangleFrame();

        add(drawRectangleFrame);
        // 게임 시작하기
        startButton.addActionListener(e -> {
            timerCondition.setInitialTime(120);

            openingLabel.setVisible(false);
            gameOpeningMenu.setVisible(false);
            gameDescriptionText.setVisible(false);

            lifeLabelOne.setVisible(true);
            lifeLabelTwo.setVisible(true);
            lifeLabelThree.setVisible(true);
            lifeLabelFour.setVisible(true);

            animalStatus.setVisible(true);
            enemyStatus.setVisible(true);
            battleTextDisplayPane.setVisible(true);
            animalList.setVisible(true);
        });

        // 게임 설명듣기
        gameDescriptionButton.addActionListener(e -> gameDescriptionText.setVisible(true));

        // 캐릭터 선택 → 고양이 선택
        catBtn.addActionListener(e -> {
            catBtn.setForeground(Color.white);
            catBtn.setBackground(Color.gray);
            dogBtn.setForeground(Color.white);
            dogBtn.setBackground(Color.black);
            monkeyBtn.setForeground(Color.white);
            monkeyBtn.setBackground(Color.black);
            aligatorBtn.setForeground(Color.white);
            aligatorBtn.setBackground(Color.black);

            int strength = cat.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = cat.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int agility = cat.agility;
            agilityDisplay.setText("Agility "+ agility);

            catIconLabel.setVisible(true);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(false);
            aligatorIconLabel.setVisible(false);

            catSkillList.setVisible(true);
            dogSkillList.setVisible(false);
            monkeySkillList.setVisible(false);
            aligatorSkillList.setVisible(false);

            agilityDisplay.setVisible(true);
            defenseDisplay.setVisible(false);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 고양이를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleTextDipslay.append(characterChoice);

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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ cat.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-cat.attack());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catBasicAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                cat.setHealthPoint(cat.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ cat.healthPoint);

                if (cat.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    catIconLabel.setVisible(false);
                    catBtn.setVisible(false);
                    catSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 할퀴기를 시전합니다!" + "\n 곰에게 "+ cat.claw()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-cat.claw());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catSpecialAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                cat.setHealthPoint(cat.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ cat.healthPoint);

                if (cat.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    catIconLabel.setVisible(false);
                    catBtn.setVisible(false);
                    catSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("""
                        회피하기를 시전합니다!
                        곰이 필살기로 공격하려합니다.""".indent(1));
                if (cat.avoid()){
                    battleTextDipslay.append("\n 곰의 공격을 회피했습니다!");
                    cat.setHealthPoint(cat.healthPoint);
                    healthPointDisplay.setText("HealthPoint :"+ cat.healthPoint);
                } else {
                    battleTextDipslay.append("\n 회피에 실패했습니다.");
                    battleTextDipslay.append("\n " + bear.bearKnuckle() +"의 데미지를 입었습니다.");
                    cat.setHealthPoint(cat.healthPoint - bear.bearKnuckle());
                    healthPointDisplay.setText("HealthPoint :"+ cat.healthPoint);

                    if (cat.getHealthPoint() <= 0){
                        battleTextDipslay.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                        catIconLabel.setVisible(false);
                        catBtn.setVisible(false);
                        catSkillList.setVisible(false);

                        lifeCount.setLifeNum(lifeCount.lifeNum-1);
                        int animalLife = lifeCount.getLifeNum();

                        switch (animalLife) {
                            case 0 -> lifeLabelOne.setVisible(false);
                            case 1 -> lifeLabelTwo.setVisible(false);
                            case 2 -> lifeLabelThree.setVisible(false);
                            case 3 -> lifeLabelFour.setVisible(false);
                            default -> {
                            }
                        }
                    }
                }


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
                battleTextDipslay.append("\n 소중한 고양이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                catIconLabel.setVisible(false);
                catBtn.setVisible(false);
                catSkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catWithDraw.setBackground(Color.black);

                lifeCount.setLifeNum(lifeCount.lifeNum-1);
                int animalLife = lifeCount.getLifeNum();

                switch (animalLife) {
                    case 0 -> lifeLabelOne.setVisible(false);
                    case 1 -> lifeLabelTwo.setVisible(false);
                    case 2 -> lifeLabelThree.setVisible(false);
                    case 3 -> lifeLabelFour.setVisible(false);
                    default -> {
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        // 캐릭터 선택 → 강아지 선택
        dogBtn.addActionListener(e -> {
            catBtn.setForeground(Color.white);
            catBtn.setBackground(Color.black);
            dogBtn.setForeground(Color.white);
            dogBtn.setBackground(Color.gray);
            monkeyBtn.setForeground(Color.white);
            monkeyBtn.setBackground(Color.black);
            aligatorBtn.setForeground(Color.white);
            aligatorBtn.setBackground(Color.black);

            int strength = dog.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = dog.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int defense = dog.defense;
            defenseDisplay.setText("Defense "+ defense);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(true);
            monkeyIconLabel.setVisible(false);
            aligatorIconLabel.setVisible(false);

            catSkillList.setVisible(false);
            dogSkillList.setVisible(true);
            monkeySkillList.setVisible(false);
            aligatorSkillList.setVisible(false);

            agilityDisplay.setVisible(false);
            defenseDisplay.setVisible(true);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 강아지를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleTextDipslay.append(characterChoice);

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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ dog.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-dog.attack());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogBasicAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                dog.setHealthPoint(dog.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ dog.healthPoint);

                if (dog.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 물어뜯기를 시전합니다!" + "\n 곰에게 "+ dog.bite()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-dog.bite());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogSpecialAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                dog.setHealthPoint(dog.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ dog.healthPoint);

                if (dog.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 방어하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogUltimateAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다.");
                dog.setHealthPoint(dog.healthPoint - bear.bearKnuckle() + dog.defend());
                healthPointDisplay.setText("HealthPoint :"+ dog.healthPoint);
                battleTextDipslay.append("\n 방어하기로 인해 " + dog.defend()+"의 데미지를 경감합니다.");
                battleTextDipslay.append("\n 오직 " + (bear.bearKnuckle()-dog.defend()) +"의 데미지를 받습니다.");

                if (dog.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 소중한 강아지를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                dogIconLabel.setVisible(false);
                dogBtn.setVisible(false);
                dogSkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogWithDraw.setBackground(Color.black);

                lifeCount.setLifeNum(lifeCount.lifeNum-1);
                int animalLife = lifeCount.getLifeNum();

                switch (animalLife) {
                    case 0 -> lifeLabelOne.setVisible(false);
                    case 1 -> lifeLabelTwo.setVisible(false);
                    case 2 -> lifeLabelThree.setVisible(false);
                    case 3 -> lifeLabelFour.setVisible(false);
                    default -> {
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 캐릭터 선택 → 원숭이 선택
        monkeyBtn.addActionListener(e -> {
            catBtn.setForeground(Color.white);
            catBtn.setBackground(Color.black);
            dogBtn.setForeground(Color.white);
            dogBtn.setBackground(Color.black);
            monkeyBtn.setForeground(Color.white);
            monkeyBtn.setBackground(Color.gray);
            aligatorBtn.setForeground(Color.white);
            aligatorBtn.setBackground(Color.black);

            int strength = monkey.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = monkey.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int wisdom = monkey.wisdom;
            wisdomDisplay.setText("Wisdom "+ wisdom);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(true);
            aligatorIconLabel.setVisible(false);

            catSkillList.setVisible(false);
            dogSkillList.setVisible(false);
            monkeySkillList.setVisible(true);
            aligatorSkillList.setVisible(false);

            defenseDisplay.setVisible(false);
            agilityDisplay.setVisible(false);
            wisdomDisplay.setVisible(true);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 원숭이를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleTextDipslay.append(characterChoice);
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ monkey.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-monkey.attack());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyBasicAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ monkey.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 열매를 던집니다!" + "\n 곰에게 "+ monkey.throwFruit()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-monkey.throwFruit());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeySpecialAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ monkey.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 팀 전체 회복을 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyUltimateAttack.setBackground(Color.black);

                int teamHPIncrease = monkey.recoverTeamHP();
                battleTextDipslay.append("\n 회복의 효과로 팀원 hp가 "+ teamHPIncrease +"씩 증가합니다.");  // 추후 재 검증 하기

                cat.healthPoint += teamHPIncrease;
                dog.healthPoint += teamHPIncrease;
                monkey.healthPoint += teamHPIncrease;
                aligator.healthPoint += teamHPIncrease;

                battleTextDipslay.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다.");
                battleTextDipslay.append("\n 원숭이 캐릭터가 " + bear.bearKnuckle() +"의 데미지를 받습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.bearKnuckle());

                healthPointDisplay.setText("HealthPoint :"+ monkey.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 소중한 원숭이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                monkeyIconLabel.setVisible(false);
                monkeyBtn.setVisible(false);
                monkeySkillList.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyWithDraw.setBackground(Color.black);

                lifeCount.setLifeNum(lifeCount.lifeNum-1);
                int animalLife = lifeCount.getLifeNum();

                switch (animalLife) {
                    case 0 -> lifeLabelOne.setVisible(false);
                    case 1 -> lifeLabelTwo.setVisible(false);
                    case 2 -> lifeLabelThree.setVisible(false);
                    case 3 -> lifeLabelFour.setVisible(false);
                    default -> {
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 캐릭터 선택 → 악어 선택
        aligatorBtn.addActionListener(e -> {
            catBtn.setForeground(Color.white);
            catBtn.setBackground(Color.black);
            dogBtn.setForeground(Color.white);
            dogBtn.setBackground(Color.black);
            monkeyBtn.setForeground(Color.white);
            monkeyBtn.setBackground(Color.black);
            aligatorBtn.setForeground(Color.white);
            aligatorBtn.setBackground(Color.gray);

            int strength = aligator.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = aligator.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int visciousness = aligator.visciousness;
            viciousnessDisplay.setText("Visciousness "+ visciousness);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(false);
            aligatorIconLabel.setVisible(true);

            catSkillList.setVisible(false);
            dogSkillList.setVisible(false);
            monkeySkillList.setVisible(false);
            aligatorSkillList.setVisible(true);

            defenseDisplay.setVisible(false);
            agilityDisplay.setVisible(false);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(true);

            String characterChoice ="\n 악어를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleTextDipslay.append(characterChoice);
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ aligator.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-aligator.attack());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorBasicAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                aligator.setHealthPoint(aligator.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ aligator.healthPoint);

                if (aligator.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligatorIconLabel.setVisible(false);
                    aligatorBtn.setVisible(false);
                    aligatorSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 꼬리로 후려칩니다!" + "\n 곰에게 "+ aligator.whipWithTail()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-aligator.whipWithTail());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorSpecialAttack.setBackground(Color.black);
                battleTextDipslay.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                aligator.setHealthPoint(aligator.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint :"+ aligator.healthPoint);

                if (aligator.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligatorIconLabel.setVisible(false);
                    aligatorBtn.setVisible(false);
                    aligatorSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 반사하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                aligatorUltimateAttack.setBackground(Color.black);
                attackEffect.launchEffect();
                battleTextDipslay.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다. \n 반사하기로 인해 데미지를 반사합니다.");
                bear.setHealthPoint(bear.healthPoint - bear.bearKnuckle());
                enemyHealthPointDisplay.setText("HealthPoint :"+ bear.getHealthPoint());
                battleTextDipslay.append("\n 곰이 " + bear.bearKnuckle() +"의 데미지를 받습니다.");

                if (aligator.getHealthPoint() <= 0){
                    battleTextDipslay.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    aligatorIconLabel.setVisible(false);
                    aligatorBtn.setVisible(false);
                    aligatorSkillList.setVisible(false);

                    lifeCount.setLifeNum(lifeCount.lifeNum-1);
                    int animalLife = lifeCount.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
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
                battleTextDipslay.append("\n 소중한 악어를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                aligatorIconLabel.setVisible(false);
                aligatorBtn.setVisible(false);
                aligatorSkillList.setVisible(false);

                lifeCount.setLifeNum(lifeCount.lifeNum-1);
                int animalLife = lifeCount.getLifeNum();

                switch (animalLife) {
                    case 0 -> lifeLabelOne.setVisible(false);
                    case 1 -> lifeLabelTwo.setVisible(false);
                    case 2 -> lifeLabelThree.setVisible(false);
                    case 3 -> lifeLabelFour.setVisible(false);
                    default -> {
                    }
                }
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

        //시간 제한 타이머
        Timer limitTimer = new Timer();

        final int[] timePassed = {timerCondition.getInitialTime()};
        TimerTask limitTimerTask = new TimerTask() {
            @Override
            public void run() {
                timePassed[0]--;
                battleTime.setText(timePassed[0] +" 초");

                if (timePassed[0] <= 0){
                    int lastScoreSum = cat.healthPoint + dog.healthPoint+ monkey.healthPoint+ aligator.healthPoint;
                    lastScore.setText("당신의 최종점수는 "+ lastScoreSum + "입니다.");

                    lifeLabelOne.setVisible(false);
                    lifeLabelTwo.setVisible(false);
                    lifeLabelThree.setVisible(false);
                    lifeLabelFour.setVisible(false);

                    animalList.setVisible(false);
                    catSkillList.setVisible(false);
                    dogSkillList.setVisible(false);
                    monkeySkillList.setVisible(false);
                    aligatorSkillList.setVisible(false);

                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleTextDisplayPane.setVisible(false);
                    gameoverEnding.setVisible(true);

                    limitTimer.cancel();
                }
            }
        };

        limitTimer.schedule(limitTimerTask,2000,1000);

        //엔딩 타이머
        Timer endingTimer = new Timer();
        TimerTask endingTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(lifeCount.lifeNum == 0){
                    int lastScoreSum = cat.healthPoint + dog.healthPoint+ monkey.healthPoint+ aligator.healthPoint;
                    lastScore.setText("당신의 최종점수는 "+ lastScoreSum + "입니다.");
                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleTextDisplayPane.setVisible(false);
                    gameoverEnding.setVisible(true);
                    endingTimer.cancel();
                } else if (bear.getHealthPoint() <= 0){
                    int lastScoreSum = cat.healthPoint + dog.healthPoint+ monkey.healthPoint+ aligator.healthPoint;
                    lastScore.setText("당신의 최종점수는 "+ lastScoreSum + "입니다.");

                    lifeLabelOne.setVisible(false);
                    lifeLabelTwo.setVisible(false);
                    lifeLabelThree.setVisible(false);
                    lifeLabelFour.setVisible(false);

                    animalList.setVisible(false);
                    catSkillList.setVisible(false);
                    dogSkillList.setVisible(false);
                    monkeySkillList.setVisible(false);
                    aligatorSkillList.setVisible(false);

                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleTextDisplayPane.setVisible(false);
                    gameVictoryEnding.setVisible(true);
                    endingTimer.cancel();
                }
            }
        };
        endingTimer.schedule(endingTimerTask,0,1000); // 태스크발동, 0ms 즉시 실행, 1000ms 매구간 실행

        //폰트
        Font basicFontFourTeen = new Font("맑은 고딕", Font.BOLD,14);
        Font notoSansBoldFourteen = new Font("Noto Sans KR", Font.BOLD,14);
        Font notoSansBoldTwenty = new Font("Noto Sans KR", Font.BOLD,20);

        startButton.setFont(notoSansBoldTwenty);
        gameDescriptionButton.setFont(notoSansBoldTwenty);
        gameDescriptionText.setFont(notoSansBoldTwenty);
        battleTime.setFont(basicFontFourTeen);
        lastScore.setFont(notoSansBoldTwenty);

        strengthDisplay.setFont(notoSansBoldFourteen);
        healthPointDisplay.setFont(notoSansBoldFourteen);
        agilityDisplay.setFont(notoSansBoldFourteen);
        defenseDisplay.setFont(notoSansBoldFourteen);
        wisdomDisplay.setFont(notoSansBoldFourteen);
        viciousnessDisplay.setFont(notoSansBoldFourteen);

        enemyStrengthDisplay.setFont(notoSansBoldFourteen);
        enemyHealthPointDisplay.setFont(notoSansBoldFourteen);

        catBtn.setFont(notoSansBoldFourteen);
        dogBtn.setFont(notoSansBoldFourteen);
        monkeyBtn.setFont(notoSansBoldFourteen);
        aligatorBtn.setFont(notoSansBoldFourteen);

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

        // UI 컬러
        gameOpeningMenu.setBackground(Color.white);                                                                     //버튼 밖 프레임 채색 목적
        lastScore.setForeground(Color.white);

        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        gameDescriptionButton.setForeground(Color.white);
        gameDescriptionButton.setBackground(Color.black);

        catBtn.setForeground(Color.white);
        catBtn.setBackground(Color.black);
        dogBtn.setForeground(Color.white);
        dogBtn.setBackground(Color.black);
        monkeyBtn.setForeground(Color.white);
        monkeyBtn.setBackground(Color.black);
        aligatorBtn.setForeground(Color.white);
        aligatorBtn.setBackground(Color.black);

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
        animalList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        catSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        dogSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        monkeySkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        aligatorSkillList.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        // 컴포넌트 배치
        setLayout(null);   // 반드시 배치전에 null 지정
        gameOpeningMenu.setBounds(150,220,300,80);
        gameDescriptionText.setBounds(70,350, 450,260);
        gameoverEnding.setBounds(0,0,600,800);
        gameVictoryEnding.setBounds(0,0,600,800);
        drawRectangleFrame.setBounds(0,0,600,800);
        battleTime.setBounds(300,-10,100,100);
        lastScore.setBounds(165,200,600,200);
        attackEffect.setBounds(200,-20,800,600);
        lifeLabelOne.setBounds(25,380,30,30);
        lifeLabelTwo.setBounds(45,380,30,30);
        lifeLabelThree.setBounds(65,380,30,30);
        lifeLabelFour.setBounds(85,380,30,30);
        catIconLabel.setBounds(-60,100,200,200);
        dogIconLabel.setBounds(-20,120,250,200);
        monkeyIconLabel.setBounds(-30,120,200,200);
        aligatorIconLabel.setBounds(0,60,300,300);
        bearIconLabel.setBounds(360,-110,600,600);
        animalStatus.setBounds(25,320,140,100);
        enemyStatus.setBounds(440,20,130,40);
        animalList.setBounds(0,500,600,100);
        catSkillList.setBounds(0,600,600,100);
        dogSkillList.setBounds(0,600,600,100);
        monkeySkillList.setBounds(0,600,600,100);
        aligatorSkillList.setBounds(0,600,600,100);
        battleTextDisplayPane.setBounds(300,310,260,120);
        openingLabel.setBounds(0,0,600,800);

        // 초기 UI 설정
        gameVictoryEnding.setVisible(false);
        gameoverEnding.setVisible(false);
        gameDescriptionText.setVisible(false);
        animalStatus.setVisible(false);
        lifeLabelOne.setVisible(false);
        lifeLabelTwo.setVisible(false);
        lifeLabelThree.setVisible(false);
        lifeLabelFour.setVisible(false);
        enemyStatus.setVisible(false);
        battleTextDisplayPane.setVisible(false);
        animalList.setVisible(false);
        catSkillList.setVisible(false);
        dogSkillList.setVisible(false);
        monkeySkillList.setVisible(false);
        aligatorSkillList.setVisible(false);

        // 기본 UI 설정
        setSize(600,800);
        setTitle("베어 헌트");
        setVisible(true); // setVisible 함수가 화면설정 이전으로 가게되면 화면 구성이전의 화면들은 보여지지 않음

        // Exit 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        MainDisplay mainDisplay = new MainDisplay();
        mainDisplay.mainFrame();


    }
}
