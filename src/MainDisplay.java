import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;


public class MainDisplay extends JFrame{

    public void mainFrame() {
        // 클래스 객체
        GameScore gameScore = new GameScore();
        Life life = new Life();
        Time time = new Time();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Monkey monkey = new Monkey();
        Alligator aligator = new Alligator();
        Bear bear = new Bear();

        // 패널 구성
        JPanel gameIntroBtn = new JPanel();
        JPanel animalStatus = new JPanel();
        JPanel enemyStatus = new JPanel();
        JPanel characters = new JPanel();
        JPanel catSkill = new JPanel();
        JPanel dogSkill = new JPanel();
        JPanel monkeySkill = new JPanel();
        JPanel alligatorSkill = new JPanel();

        //오프닝 메뉴
        JButton startButton = new JButton("시작하기");
        JButton gameDescriptionButton = new JButton("설명듣기");

        startButton.setPreferredSize(new Dimension(120,60));
        gameDescriptionButton.setPreferredSize(new Dimension(120,60));

        gameIntroBtn.add(startButton);
        gameIntroBtn.add(gameDescriptionButton);
        add(gameIntroBtn);

        //오프닝 메뉴 설명하기 창
        JTextArea gameDescriptionText = new JTextArea("""
                베어헌트는 주어진 4마리의 동물로
                곰을 사냥하는 턴제 RPG 게임입니다.
                사용할 수 있는 각각의 동물은
                고양이,개,원숭이,악어가 있으며,
                각 캐릭터마다 독특한 고유 스킬을
                보유하고 있습니다.
                4마리의 동물이 전멸하기전에 곰을 사냥시,
                게임에 승리합니다.
                더 높은 점수로 배틀에 승리해보세요!
                모든 조작은 마우스 클릭으로 이루어집니다.
                시작하기 버튼을 눌러주세요.""".indent(1));

        add(gameDescriptionText);

        // 전투 설명창
        JTextArea battleDescription = new JTextArea(" 전투 진행 상황을 표시합니다.\n 캐릭터를 선택해주세요" );
        battleDescription.setCaretPosition(battleDescription.getDocument().getLength());                                // 전투 설명창 스크롤 추가
        JScrollPane battleDescriptionScroll = new JScrollPane(battleDescription);
        add(battleDescriptionScroll);

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
        JLabel strengthDisplay = new JLabel("Strength 10");
        JLabel healthPointDisplay = new JLabel("HealthPoint 100");
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
        JLabel enemyStrengthDisplay = new JLabel("Strength 12");
        JLabel enemyHealthPointDisplay = new JLabel("HealthPoint 1000");

        enemyStatus.add(enemyStrengthDisplay);
        enemyStatus.add(enemyHealthPointDisplay);

        add(enemyStatus);

        //아군 체력바
        CatHealthBar catHealthBar = new CatHealthBar();
        add(catHealthBar.catHealthBar);

        Thread catHealthBarThread = new Thread(catHealthBar);
        catHealthBarThread.start();                                                                                     // 각 캐릭터 사망시 반드시 쓰레드를 멈출것 !

        DogHealthBar dogHealthBar = new DogHealthBar();
        add(dogHealthBar.dogHealthBar);

        Thread dogHealthBarThread = new Thread(dogHealthBar);
        dogHealthBarThread.start();

        MonkeyHealthBar monkeyHealthBar = new MonkeyHealthBar();
        add(monkeyHealthBar.monkeyHealthBar);

        Thread monkeyHealthBarThread = new Thread(monkeyHealthBar);
        monkeyHealthBarThread.start();

        AlligatorHealthBar alligatorHealthBar = new AlligatorHealthBar();
        add(alligatorHealthBar.alligatorHealthBar);

        Thread alligatorHealthBarThread = new Thread(alligatorHealthBar);
        alligatorHealthBarThread.start();

        //적군 체력바
        BearHealthBar bearHealthBar = new BearHealthBar();
        add(bearHealthBar.bearHealthBar);

        Thread bearHealthbarThread = new Thread(bearHealthBar);
        bearHealthbarThread.start();
        

        //공격 이펙트
        AttackEffect attackEffect = new AttackEffect();                                                                 //실행시 attackEffect.launchEffect() 로 실행
        add(attackEffect);

        //헬스 포션 이펙트
        HealthPotionEffect healthPotionEffect = new HealthPotionEffect();
        add(healthPotionEffect);

        //능력치 포션 이펙트
        StatusPotionEffect statusPotionEffect = new StatusPotionEffect();
        add(statusPotionEffect);

        //게임 점수
        JLabel totalScore = new JLabel("Score: 0");
        add(totalScore);

        //엔딩 점수
        JLabel lastScore = new JLabel("");
        add(lastScore);

        //오프닝 아이콘
        ImageIcon openingIcon = new ImageIcon("images/pixel_opening.png");
        Image openingImage = openingIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        openingIcon.setImage(openingImage);

        JLabel openingScreen = new JLabel();
        openingScreen.setIcon(openingIcon);
        add(openingScreen);

        //승리 아이콘
        ImageIcon gameVictoryIcon = new ImageIcon("images/pixel_victory.png");
        Image gameVictoryImage = gameVictoryIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        gameVictoryIcon.setImage(gameVictoryImage);

        JLabel gameVictoryScreen = new JLabel();
        gameVictoryScreen.setIcon(gameVictoryIcon);
        add(gameVictoryScreen);

        //패배 아이콘
        ImageIcon gameOverIcon = new ImageIcon("images/pixel_gameover.png");
        Image gameOverImage = gameOverIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        gameOverIcon.setImage(gameOverImage);

        JLabel gameOverScreen = new JLabel();
        gameOverScreen.setIcon(gameOverIcon);
        add(gameOverScreen);

        //캐릭터 아이콘
        ImageIcon catIcon = new ImageIcon("images/emoticon_cat.png");                                              // 고양이 아이콘
        Image catImage = catIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);                 // 이미지 크기 조정  ImageIcon → Image 변경  이후 다시 Image → ImageIcon 변경
        catIcon.setImage(catImage);

        JLabel catIconLabel = new JLabel();
        catIconLabel.setIcon(catIcon);
        add(catIconLabel);

        ImageIcon dogIcon = new ImageIcon("images/emoticon_dog.png");                                              // 강아지 아이콘
        Image dogImage = dogIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        dogIcon.setImage(dogImage);

        JLabel dogIconLabel = new JLabel();
        dogIconLabel.setIcon(dogIcon);
        add(dogIconLabel);

        ImageIcon monkeyIcon = new ImageIcon("images/emoticon_monkey.png");                                        // 원숭이 아이콘
        Image monkeyImage = monkeyIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        monkeyIcon.setImage(monkeyImage);

        JLabel monkeyIconLabel = new JLabel();
        monkeyIconLabel.setIcon(monkeyIcon);
        add(monkeyIconLabel);

        ImageIcon alligatorIcon = new ImageIcon("images/emoticon_alligator.png");                                    // 악어 아이콘
        Image alligatorImage = alligatorIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        alligatorIcon.setImage(alligatorImage);

        JLabel alligatorIconLabel = new JLabel();
        alligatorIconLabel.setIcon(alligatorIcon);
        add(alligatorIconLabel);

        ImageIcon bearIcon = new ImageIcon("images/emoticon_bear.png");                                            // 곰 아이콘
        Image bearImage = bearIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        bearIcon.setImage(bearImage);

        JLabel bearIconLabel = new JLabel();
        bearIconLabel.setIcon(bearIcon);
        add(bearIconLabel);

        catIconLabel.setVisible(false);
        dogIconLabel.setVisible(false);
        monkeyIconLabel.setVisible(false);
        alligatorIconLabel.setVisible(false);

        // 캐릭터 리스트
        JButton catBtn = new JButton("고양이");
        JButton dogBtn = new JButton("강아지");
        JButton monkeyBtn = new JButton("원숭이");
        JButton alligatorBtn = new JButton("악어");

        catBtn.setPreferredSize(new Dimension(120,60));
        dogBtn.setPreferredSize(new Dimension(120,60));
        monkeyBtn.setPreferredSize(new Dimension(120,60));
        alligatorBtn.setPreferredSize(new Dimension(120,60));

        characters.add(catBtn);
        characters.add(dogBtn);
        characters.add(monkeyBtn);
        characters.add(alligatorBtn);

        add(characters);

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
        JButton monkeySpecialAttack = new JButton("열매 투척");
        JButton monkeyUltimateAttack = new JButton("전체 회복");
        JButton monkeyWithDraw = new JButton("기권한다");

        JButton alligatorBasicAttack = new JButton("일반 공격");
        JButton alligatorSpecialAttack = new JButton("꼬리후리기");
        JButton alligatorUltimateAttack = new JButton("반사한다");
        JButton alligatorWithDraw = new JButton("기권한다");

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

        alligatorBasicAttack.setPreferredSize(new Dimension(120,60));
        alligatorSpecialAttack.setPreferredSize(new Dimension(120,60));
        alligatorUltimateAttack.setPreferredSize(new Dimension(120, 60));
        alligatorWithDraw.setPreferredSize(new Dimension(120,60));

        catSkill.add(catBasicAttack);
        catSkill.add(catSpecialAttack);
        catSkill.add(catUltimateAttack);
        catSkill.add(catWithDraw);

        dogSkill.add(dogBasicAttack);
        dogSkill.add(dogSpecialAttack);
        dogSkill.add(dogUltimateAttack);
        dogSkill.add(dogWithDraw);

        monkeySkill.add(monkeyBasicAttack);
        monkeySkill.add(monkeySpecialAttack);
        monkeySkill.add(monkeyUltimateAttack);
        monkeySkill.add(monkeyWithDraw);

        alligatorSkill.add(alligatorBasicAttack);
        alligatorSkill.add(alligatorSpecialAttack);
        alligatorSkill.add(alligatorUltimateAttack);
        alligatorSkill.add(alligatorWithDraw);

        add(catSkill);
        add(dogSkill);
        add(monkeySkill);
        add(alligatorSkill);

        //아이템 모음
        //민첩 강화 포션 사용 - 고양이
        add(cat.agilityPortionBtn);
        cat.useAgilityPortion();
        cat.agilityPortionBtn.setBounds(20,700,120,40);

        //포션 사용 - 고양이
        add(cat.healingPortionBtn);
        cat.useHealingPortion();
        cat.healingPortionBtn.setBounds(160,700,120,40);

        //방어력 강화 포션 사용 - 강아지
        add(dog.defensePortionBtn);
        dog.useDefensePortion();
        dog.defensePortionBtn.setBounds(20,700,120,40);

        //체력 포션 사용 - 강아지
        add(dog.healingPortionBtn);
        dog.useHealingPortion();
        dog.healingPortionBtn.setBounds(160,700,120,40);

        //지혜 강화 포션 사용 - 원숭이
        add(monkey.wisdomPortionBtn);
        monkey.useWisdomPortion();
        monkey.wisdomPortionBtn.setBounds(20,700,120,40);

        //체력 포션 사용 - 원숭이
        add(monkey.healingPortionBtn);
        monkey.useHealingPortion();
        monkey.healingPortionBtn.setBounds(160,700,120,40);

        //비열함 강화 포션 사용 - 악어
        add(aligator.viciousnessPortionBtn);
        aligator.useViciousnessPortion();
        aligator.viciousnessPortionBtn.setBounds(20,700,120,40);

        //체력 포션 사용 - 악어
        add(aligator.healingPortionBtn);
        aligator.useHealingPortion();
        aligator.healingPortionBtn.setBounds(160,700,120,40);

        //전투 시간 타이머
        JLabel battleTime = new JLabel("360 초");

        add(battleTime);
        //전투 통합 프레임
        RectangleFrame rectangleFrame = new RectangleFrame();

        add(rectangleFrame);
        //메인 화면 백그라운드
        ImageIcon mainBackgroundIcon = new ImageIcon("images/pixel_mainBackground.png");
        Image mainBackgroundImage = mainBackgroundIcon.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        mainBackgroundIcon.setImage(mainBackgroundImage);

        JLabel mainBackgroundScreen = new JLabel();
        mainBackgroundScreen.setIcon(mainBackgroundIcon);
        add(mainBackgroundScreen);

        mainBackgroundScreen.setBounds(0,0,600,800);

        // 게임 시작하기
        startButton.addActionListener(e -> {
            time.setInitialTime(180);

            openingScreen.setVisible(false);
            gameIntroBtn.setVisible(false);
            gameDescriptionText.setVisible(false);
            totalScore.setVisible(true);

            lifeLabelOne.setVisible(true);
            lifeLabelTwo.setVisible(true);
            lifeLabelThree.setVisible(true);
            lifeLabelFour.setVisible(true);

            bearHealthBar.bearHealthBar.setVisible(true);
            animalStatus.setVisible(true);
            enemyStatus.setVisible(true);
            battleDescriptionScroll.setVisible(true);
            characters.setVisible(true);
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
            alligatorBtn.setForeground(Color.white);
            alligatorBtn.setBackground(Color.black);

            int strength = cat.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = cat.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int agility = cat.agility;
            agilityDisplay.setText("Agility "+ agility);

            catIconLabel.setVisible(true);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(false);
            alligatorIconLabel.setVisible(false);

            catHealthBar.catHealthBar.setVisible(true);
            dogHealthBar.dogHealthBar.setVisible(false);
            monkeyHealthBar.monkeyHealthBar.setVisible(false);
            alligatorHealthBar.alligatorHealthBar.setVisible(false);

            cat.agilityPortionBtn.setVisible(true);
            cat.healingPortionBtn.setVisible(true);
            dog.defensePortionBtn.setVisible(false);
            dog.healingPortionBtn.setVisible(false);
            monkey.wisdomPortionBtn.setVisible(false);
            monkey.healingPortionBtn.setVisible(false);
            aligator.viciousnessPortionBtn.setVisible(false);
            aligator.healingPortionBtn.setVisible(false);

            catSkill.setVisible(true);
            dogSkill.setVisible(false);
            monkeySkill.setVisible(false);
            alligatorSkill.setVisible(false);

            agilityDisplay.setVisible(true);
            defenseDisplay.setVisible(false);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 고양이를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleDescription.append(characterChoice);

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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ cat.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-cat.attack());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catBasicAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                cat.setHealthPoint(cat.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ cat.healthPoint);
                catHealthBar.CurrentHealth(cat.healthPoint);

                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (cat.getHealthPoint() <= 0){
                    battleDescription.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    catIconLabel.setVisible(false);
                    catBtn.setVisible(false);
                    catSkill.setVisible(false);

                    cat.agilityPortionBtn.setVisible(false);
                    cat.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }
                gameScore.addScore(cat.attack());
                totalScore.setText("Score: "+gameScore.score);
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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 할퀴기를 시전합니다!" + "\n 곰에게 "+ cat.claw()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-cat.claw());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catSpecialAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                cat.setHealthPoint(cat.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ cat.healthPoint);
                catHealthBar.CurrentHealth(cat.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (cat.getHealthPoint() <= 0){
                    battleDescription.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    catIconLabel.setVisible(false);
                    catBtn.setVisible(false);
                    catSkill.setVisible(false);

                    cat.agilityPortionBtn.setVisible(false);
                    cat.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }
                gameScore.addScore(cat.claw());
                totalScore.setText("Score: "+gameScore.score);
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
                battleDescription.append("""
                        회피하기를 시전합니다!
                        곰이 필살기로 공격하려합니다.""".indent(1));
                if (cat.avoid()){
                    battleDescription.append("\n 곰의 공격을 회피했습니다!");
                    cat.setHealthPoint(cat.healthPoint);
                    healthPointDisplay.setText("HealthPoint "+ cat.healthPoint);
                } else {
                    battleDescription.append("\n 회피에 실패했습니다.");
                    battleDescription.append("\n " + bear.bearKnuckle() +"의 데미지를 입었습니다.");
                    attackEffect.launchEffectExtra();
                    cat.setHealthPoint(cat.healthPoint - bear.bearKnuckle());
                    healthPointDisplay.setText("HealthPoint "+ cat.healthPoint);
                    catHealthBar.CurrentHealth(cat.healthPoint);

                    if (cat.getHealthPoint() <= 0){
                        battleDescription.append("\n 야아아아옹~~! \n 고양이 캐릭터가 장렬하게 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                        catIconLabel.setVisible(false);
                        catBtn.setVisible(false);
                        catSkill.setVisible(false);

                        cat.agilityPortionBtn.setVisible(false);
                        cat.healingPortionBtn.setVisible(false);

                        life.setLifeNum(life.lifeNum-1);
                        int animalLife = life.getLifeNum();

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
                battleDescription.append("\n 소중한 고양이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                catHealthBar.catHealthBar.setVisible(false);
                catIconLabel.setVisible(false);
                catBtn.setVisible(false);
                catSkill.setVisible(false);

                cat.agilityPortionBtn.setVisible(false);
                cat.healingPortionBtn.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                catWithDraw.setBackground(Color.black);

                life.setLifeNum(life.lifeNum-1);
                int animalLife = life.getLifeNum();

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
            alligatorBtn.setForeground(Color.white);
            alligatorBtn.setBackground(Color.black);

            int strength = dog.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = dog.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int defense = dog.defense;
            defenseDisplay.setText("Defense "+ defense);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(true);
            monkeyIconLabel.setVisible(false);
            alligatorIconLabel.setVisible(false);

            catSkill.setVisible(false);
            dogSkill.setVisible(true);
            monkeySkill.setVisible(false);
            alligatorSkill.setVisible(false);

            catHealthBar.catHealthBar.setVisible(false);
            dogHealthBar.dogHealthBar.setVisible(true);
            monkeyHealthBar.monkeyHealthBar.setVisible(false);
            alligatorHealthBar.alligatorHealthBar.setVisible(false);

            cat.agilityPortionBtn.setVisible(false);
            cat.healingPortionBtn.setVisible(false);
            dog.defensePortionBtn.setVisible(true);
            dog.healingPortionBtn.setVisible(true);
            monkey.wisdomPortionBtn.setVisible(false);
            monkey.healingPortionBtn.setVisible(false);
            aligator.viciousnessPortionBtn.setVisible(false);
            aligator.healingPortionBtn.setVisible(false);

            agilityDisplay.setVisible(false);
            defenseDisplay.setVisible(true);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 강아지를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleDescription.append(characterChoice);

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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ dog.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-dog.attack());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogBasicAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                dog.setHealthPoint(dog.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ dog.healthPoint);
                dogHealthBar.CurrentHealth(dog.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (dog.getHealthPoint() <= 0){
                    battleDescription.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkill.setVisible(false);

                    dog.defensePortionBtn.setVisible(false);
                    dog.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }

                gameScore.addScore(dog.attack());
                totalScore.setText("Score: "+gameScore.score);
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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 물어뜯기를 시전합니다!" + "\n 곰에게 "+ dog.bite()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-dog.bite());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogSpecialAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                dog.setHealthPoint(dog.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ dog.healthPoint);
                dogHealthBar.CurrentHealth(dog.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (dog.getHealthPoint() <= 0){
                    battleDescription.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkill.setVisible(false);

                    dog.defensePortionBtn.setVisible(false);
                    dog.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }

                gameScore.addScore(dog.bite());
                totalScore.setText("Score: "+gameScore.score);
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
                battleDescription.append("\n 방어하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogUltimateAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다.");
                attackEffect.launchEffectExtra();
                dog.setHealthPoint(dog.healthPoint - bear.bearKnuckle() + dog.defend());
                healthPointDisplay.setText("HealthPoint "+ dog.healthPoint);
                battleDescription.append("\n 방어하기로 인해 " + dog.defend()+"의 데미지를 경감합니다.");
                battleDescription.append("\n 오직 " + (bear.bearKnuckle()-dog.defend()) +"의 데미지를 받습니다.");
                dogHealthBar.CurrentHealth(dog.healthPoint);

                if (dog.getHealthPoint() <= 0){
                    battleDescription.append("\n 깨개갱 깨개갱~~! \n 강아지 캐릭터가 비참히 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    dogIconLabel.setVisible(false);
                    dogBtn.setVisible(false);
                    dogSkill.setVisible(false);

                    dog.defensePortionBtn.setVisible(false);
                    dog.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

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
                battleDescription.append("\n 소중한 강아지를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                dogHealthBar.dogHealthBar.setVisible(false);
                dogIconLabel.setVisible(false);
                dogBtn.setVisible(false);
                dogSkill.setVisible(false);

                dog.defensePortionBtn.setVisible(false);
                dog.healingPortionBtn.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dogWithDraw.setBackground(Color.black);

                life.setLifeNum(life.lifeNum-1);
                int animalLife = life.getLifeNum();

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
            alligatorBtn.setForeground(Color.white);
            alligatorBtn.setBackground(Color.black);

            int strength = monkey.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = monkey.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int wisdom = monkey.wisdom;
            wisdomDisplay.setText("Wisdom "+ wisdom);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(true);
            alligatorIconLabel.setVisible(false);

            catSkill.setVisible(false);
            dogSkill.setVisible(false);
            monkeySkill.setVisible(true);
            alligatorSkill.setVisible(false);

            catHealthBar.catHealthBar.setVisible(false);
            dogHealthBar.dogHealthBar.setVisible(false);
            monkeyHealthBar.monkeyHealthBar.setVisible(true);
            alligatorHealthBar.alligatorHealthBar.setVisible(false);

            cat.agilityPortionBtn.setVisible(false);
            cat.healingPortionBtn.setVisible(false);
            dog.defensePortionBtn.setVisible(false);
            dog.healingPortionBtn.setVisible(false);
            monkey.wisdomPortionBtn.setVisible(true);
            monkey.healingPortionBtn.setVisible(true);
            aligator.viciousnessPortionBtn.setVisible(false);
            aligator.healingPortionBtn.setVisible(false);

            defenseDisplay.setVisible(false);
            agilityDisplay.setVisible(false);
            wisdomDisplay.setVisible(true);
            viciousnessDisplay.setVisible(false);

            String characterChoice ="\n 원숭이를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleDescription.append(characterChoice);
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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ monkey.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-monkey.attack());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyBasicAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ monkey.healthPoint);
                monkeyHealthBar.CurrentHealth(monkey.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleDescription.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkill.setVisible(false);

                    monkey.wisdomPortionBtn.setVisible(false);
                    monkey.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }
                gameScore.addScore(monkey.attack());
                totalScore.setText("Score: "+gameScore.score);
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
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 열매를 던집니다!" + "\n 곰에게 "+ monkey.throwFruit()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-monkey.throwFruit());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeySpecialAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ monkey.healthPoint);
                monkeyHealthBar.CurrentHealth(monkey.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleDescription.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkill.setVisible(false);

                    monkey.wisdomPortionBtn.setVisible(false);
                    monkey.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }

                gameScore.addScore(monkey.throwFruit());
                totalScore.setText("Score: "+gameScore.score);
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
                battleDescription.append("\n 팀 전체 회복을 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyUltimateAttack.setBackground(Color.black);

                int teamHPIncrease = monkey.recoverTeamHP();
                battleDescription.append("\n 회복의 효과로 팀원 hp가 "+ teamHPIncrease +"씩 증가합니다.");  // 추후 재 검증 하기

                cat.healthPoint += teamHPIncrease;
                dog.healthPoint += teamHPIncrease;
                monkey.healthPoint += teamHPIncrease;
                aligator.healthPoint += teamHPIncrease;

                battleDescription.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다.");
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 원숭이 캐릭터가 " + bear.bearKnuckle() +"의 데미지를 받습니다.");
                monkey.setHealthPoint(monkey.healthPoint - bear.bearKnuckle());

                healthPointDisplay.setText("HealthPoint "+ monkey.healthPoint);
                catHealthBar.CurrentHealth(cat.healthPoint);
                dogHealthBar.CurrentHealth(dog.healthPoint);
                monkeyHealthBar.CurrentHealth(monkey.healthPoint);
                alligatorHealthBar.CurrentHealth(aligator.healthPoint);

                if (monkey.getHealthPoint() <= 0){
                    battleDescription.append("\n 원수...우웅.... \n 원숭이 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    monkeyIconLabel.setVisible(false);
                    monkeyBtn.setVisible(false);
                    monkeySkill.setVisible(false);

                    monkey.wisdomPortionBtn.setVisible(false);
                    monkey.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

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
                battleDescription.append("\n 소중한 원숭이를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                monkeyHealthBar.monkeyHealthBar.setVisible(false);
                monkeyIconLabel.setVisible(false);
                monkeyBtn.setVisible(false);
                monkeySkill.setVisible(false);

                monkey.wisdomPortionBtn.setVisible(false);
                monkey.healingPortionBtn.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                monkeyWithDraw.setBackground(Color.black);

                life.setLifeNum(life.lifeNum-1);
                int animalLife = life.getLifeNum();

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
        alligatorBtn.addActionListener(e -> {
            catBtn.setForeground(Color.white);
            catBtn.setBackground(Color.black);
            dogBtn.setForeground(Color.white);
            dogBtn.setBackground(Color.black);
            monkeyBtn.setForeground(Color.white);
            monkeyBtn.setBackground(Color.black);
            alligatorBtn.setForeground(Color.white);
            alligatorBtn.setBackground(Color.gray);

            int strength = aligator.strength;
            strengthDisplay.setText("Strength " + strength);

            int healthPoint = aligator.healthPoint;
            healthPointDisplay.setText("HeathPoint " + healthPoint);

            int viciousness = aligator.viciousness;
            viciousnessDisplay.setText("Viciousness "+ viciousness);

            catIconLabel.setVisible(false);
            dogIconLabel.setVisible(false);
            monkeyIconLabel.setVisible(false);
            alligatorIconLabel.setVisible(true);

            catSkill.setVisible(false);
            dogSkill.setVisible(false);
            monkeySkill.setVisible(false);
            alligatorSkill.setVisible(true);

            catHealthBar.catHealthBar.setVisible(false);
            dogHealthBar.dogHealthBar.setVisible(false);
            monkeyHealthBar.monkeyHealthBar.setVisible(false);
            alligatorHealthBar.alligatorHealthBar.setVisible(true);

            cat.agilityPortionBtn.setVisible(false);
            cat.healingPortionBtn.setVisible(false);
            dog.defensePortionBtn.setVisible(false);
            dog.healingPortionBtn.setVisible(false);
            monkey.wisdomPortionBtn.setVisible(false);
            monkey.healingPortionBtn.setVisible(false);
            aligator.viciousnessPortionBtn.setVisible(true);
            aligator.healingPortionBtn.setVisible(true);

            defenseDisplay.setVisible(false);
            agilityDisplay.setVisible(false);
            wisdomDisplay.setVisible(false);
            viciousnessDisplay.setVisible(true);

            String characterChoice ="\n 악어를 선택하셨습니다.\n 스킬을 선택해주세요.";
            battleDescription.append(characterChoice);
        });

        // 악어 스킬 리스트
        // 일반 공격
        alligatorBasicAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                alligatorBasicAttack.setBackground(Color.gray);
                attackEffect.launchEffect();
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 일반 공격을 시전합니다!" + "\n 곰에게 "+ aligator.attack()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-aligator.attack());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                alligatorBasicAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                aligator.setHealthPoint(aligator.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ aligator.healthPoint);
                alligatorHealthBar.CurrentHealth(aligator.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (aligator.getHealthPoint() <= 0){
                    battleDescription.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    alligatorIconLabel.setVisible(false);
                    alligatorBtn.setVisible(false);
                    alligatorSkill.setVisible(false);

                    aligator.viciousnessPortionBtn.setVisible(false);
                    aligator.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }
                gameScore.addScore(aligator.attack());
                totalScore.setText("Score: "+gameScore.score);
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 특수공격
        alligatorSpecialAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                alligatorSpecialAttack.setBackground(Color.gray);
                attackEffect.launchEffect();
                attackEffect.launchEffectExtra();
                battleDescription.append("\n 꼬리로 후려칩니다!" + "\n 곰에게 "+ aligator.whipWithTail()+"의 데미지를 입힙니다.");
                bear.setHealthPoint(bear.healthPoint-aligator.whipWithTail());
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                alligatorSpecialAttack.setBackground(Color.black);
                battleDescription.append("\n 곰이 반격합니다! " + bear.strength +"의 데미지를 입었습니다.");
                aligator.setHealthPoint(aligator.healthPoint - bear.strength);
                healthPointDisplay.setText("HealthPoint "+ aligator.healthPoint);
                alligatorHealthBar.CurrentHealth(aligator.healthPoint);
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (aligator.getHealthPoint() <= 0){
                    battleDescription.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    alligatorIconLabel.setVisible(false);
                    alligatorBtn.setVisible(false);
                    alligatorSkill.setVisible(false);

                    aligator.viciousnessPortionBtn.setVisible(false);
                    aligator.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }
                gameScore.addScore(aligator.whipWithTail());
                totalScore.setText("Score: "+gameScore.score);
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // 필살기
        alligatorUltimateAttack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                alligatorUltimateAttack.setBackground(Color.gray);
                battleDescription.append("\n 반사하기를 시전합니다!");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                alligatorUltimateAttack.setBackground(Color.black);
                attackEffect.launchEffect();
                battleDescription.append("\n 곰이 베어너클을 시전합니다! \n " + bear.bearKnuckle()+"의 데미지로 공격합니다. \n 반사하기로 인해 2배 데미지를 반사합니다.");
                bear.setHealthPoint(bear.healthPoint - aligator.reflect(bear.bearKnuckle()));
                enemyHealthPointDisplay.setText("HealthPoint "+ bear.getHealthPoint());
                battleDescription.append("\n 곰이 " + aligator.reflect(bear.bearKnuckle()) +"의 데미지를 받습니다.");
                bearHealthBar.CurrentHealth(bear.healthPoint);

                if (aligator.getHealthPoint() <= 0){
                    battleDescription.append("\n 아..악...어...~~! \n 악어 캐릭터가 사망했습니다! \n 다른 캐릭터를 골라주세요.");

                    alligatorIconLabel.setVisible(false);
                    alligatorBtn.setVisible(false);
                    alligatorSkill.setVisible(false);

                    aligator.viciousnessPortionBtn.setVisible(false);
                    aligator.healingPortionBtn.setVisible(false);

                    life.setLifeNum(life.lifeNum-1);
                    int animalLife = life.getLifeNum();

                    switch (animalLife) {
                        case 0 -> lifeLabelOne.setVisible(false);
                        case 1 -> lifeLabelTwo.setVisible(false);
                        case 2 -> lifeLabelThree.setVisible(false);
                        case 3 -> lifeLabelFour.setVisible(false);
                        default -> {
                        }
                    }
                }

                gameScore.addScore(aligator.reflect(bear.bearKnuckle()));
                totalScore.setText("Score: "+gameScore.score);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //기권하기
        alligatorWithDraw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                alligatorWithDraw.setBackground(Color.gray);
                battleDescription.append("\n 소중한 악어를 위해 기권합니다. \n 다른 캐릭터를 골라주세요.");

                alligatorHealthBar.alligatorHealthBar.setVisible(false);

                alligatorIconLabel.setVisible(false);
                alligatorBtn.setVisible(false);
                alligatorSkill.setVisible(false);

                aligator.viciousnessPortionBtn.setVisible(false);
                aligator.healingPortionBtn.setVisible(false);

                life.setLifeNum(life.lifeNum-1);
                int animalLife = life.getLifeNum();

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
                alligatorWithDraw.setBackground(Color.black);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //고양이 아이템 리스트
        //민첩의 약 
        cat.agilityPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusPotionEffect.threadCount = 20;
                statusPotionEffect.useEffect();
                battleDescription.append("\n 민첩의 약을 사용합니다! \n 민첩이 5 증가합니다.");
                agilityDisplay.setText("Agility "+ cat.agility);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //체력 포션
        cat.healingPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                healthPotionEffect.threadCount = 20;
                healthPotionEffect.useEffect();
                battleDescription.append("\n 체력 포션을 사용합니다! \n 체력이 30 증가합니다.");
                healthPointDisplay.setText("HealthPoint "+ cat.healthPoint);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //강아지 아이템 리스트
        //방어의 약
        dog.defensePortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusPotionEffect.threadCount = 20;
                statusPotionEffect.useEffect();
                battleDescription.append("\n 방어의 약을 사용합니다! \n 방어력이 5 증가합니다.");
                defenseDisplay.setText("Defense "+ dog.defense);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //체력 포션
        dog.healingPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                healthPotionEffect.threadCount = 20;
                healthPotionEffect.useEffect();
                battleDescription.append("\n 체력 포션을 사용합니다! \n 체력이 30 증가합니다.");
                healthPointDisplay.setText("HealthPoint "+ dog.healthPoint);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //원숭이 아이템 리스트
        //지혜의 약
        monkey.wisdomPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusPotionEffect.threadCount = 20;
                statusPotionEffect.useEffect();
                battleDescription.append("\n 지혜의 약을 사용합니다! \n 지혜력이 5 증가합니다.");
                wisdomDisplay.setText("Wisdom "+ monkey.wisdom);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //체력 포션
        monkey.healingPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                healthPotionEffect.threadCount = 20;
                healthPotionEffect.useEffect();
                battleDescription.append("\n 체력 포션을 사용합니다! \n 체력이 30 증가합니다.");
                healthPointDisplay.setText("HealthPoint "+monkey.healthPoint);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //악어 아이템 리스트
        //비열함의 약
        aligator.viciousnessPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusPotionEffect.threadCount = 20;
                statusPotionEffect.useEffect();
                battleDescription.append("\n 비열함의 약을 사용합니다! \n 비열함이 5 증가합니다.");
                viciousnessDisplay.setText("Viciousness "+ aligator.viciousness);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        aligator.healingPortionBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                healthPotionEffect.threadCount = 20;
                healthPotionEffect.useEffect();
                battleDescription.append("\n 체력 포션을 사용합니다! \n 체력이 30 증가합니다.");
                healthPointDisplay.setText("HealthPoint "+aligator.healthPoint);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

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

        final int[] timePassed = {time.getInitialTime()};
        TimerTask limitTimerTask = new TimerTask() {
            @Override
            public void run() {
                timePassed[0]--;
                battleTime.setText(timePassed[0] +" 초");

                if (timePassed[0] <= 0){
                    lastScore.setText("당신의 최종점수는 "+ gameScore.score + "입니다.");

                    totalScore.setVisible(false);

                    lifeLabelOne.setVisible(false);
                    lifeLabelTwo.setVisible(false);
                    lifeLabelThree.setVisible(false);
                    lifeLabelFour.setVisible(false);

                    characters.setVisible(false);
                    catSkill.setVisible(false);
                    dogSkill.setVisible(false);
                    monkeySkill.setVisible(false);
                    alligatorSkill.setVisible(false);

                    catHealthBar.catHealthBar.setVisible(false);
                    dogHealthBar.dogHealthBar.setVisible(false);
                    monkeyHealthBar.monkeyHealthBar.setVisible(false);
                    alligatorHealthBar.alligatorHealthBar.setVisible(false);
                    bearHealthBar.bearHealthBar.setVisible(false);

                    cat.healingPortionBtn.setVisible(false);
                    cat.agilityPortionBtn.setVisible(false);
                    dog.defensePortionBtn.setVisible(false);
                    dog.healingPortionBtn.setVisible(false);
                    monkey.wisdomPortionBtn.setVisible(false);
                    monkey.healingPortionBtn.setVisible(false);
                    aligator.viciousnessPortionBtn.setVisible(false);
                    aligator.healingPortionBtn.setVisible(false);

                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleDescriptionScroll.setVisible(false);
                    gameOverScreen.setVisible(true);

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
                if(life.lifeNum == 0){
                    lastScore.setText("당신의 최종점수는 "+ gameScore.score + "입니다.");

                    totalScore.setVisible(false);

                    catHealthBar.catHealthBar.setVisible(false);
                    dogHealthBar.dogHealthBar.setVisible(false);
                    monkeyHealthBar.monkeyHealthBar.setVisible(false);
                    alligatorHealthBar.alligatorHealthBar.setVisible(false);
                    bearHealthBar.bearHealthBar.setVisible(false);

                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleDescriptionScroll.setVisible(false);
                    gameOverScreen.setVisible(true);
                    endingTimer.cancel();
                } else if (bear.getHealthPoint() <= 0){
                    lastScore.setText("당신의 최종점수는 "+ gameScore.score + "입니다.");

                    totalScore.setVisible(false);

                    lifeLabelOne.setVisible(false);
                    lifeLabelTwo.setVisible(false);
                    lifeLabelThree.setVisible(false);
                    lifeLabelFour.setVisible(false);

                    characters.setVisible(false);
                    catSkill.setVisible(false);
                    dogSkill.setVisible(false);
                    monkeySkill.setVisible(false);
                    alligatorSkill.setVisible(false);

                    catHealthBar.catHealthBar.setVisible(false);
                    dogHealthBar.dogHealthBar.setVisible(false);
                    monkeyHealthBar.monkeyHealthBar.setVisible(false);
                    alligatorHealthBar.alligatorHealthBar.setVisible(false);

                    cat.healingPortionBtn.setVisible(false);
                    cat.agilityPortionBtn.setVisible(false);
                    dog.defensePortionBtn.setVisible(false);
                    dog.healingPortionBtn.setVisible(false);
                    monkey.wisdomPortionBtn.setVisible(false);
                    monkey.healingPortionBtn.setVisible(false);
                    aligator.viciousnessPortionBtn.setVisible(false);
                    aligator.healingPortionBtn.setVisible(false);

                    animalStatus.setVisible(false);
                    enemyStatus.setVisible(false);
                    bearIconLabel.setVisible(false);
                    battleDescriptionScroll.setVisible(false);
                    gameVictoryScreen.setVisible(true);
                    endingTimer.cancel();
                }
            }
        };
        endingTimer.schedule(endingTimerTask,0,1000); // 태스크발동, 0ms 즉시 실행, 1000ms 매구간 실행

        //폰트
        Font mapleStoryLightSixteen = new Font("메이플스토리 Light",Font.PLAIN,16);
        Font mapleStoryLightTwenty = new Font("메이플스토리 Light",Font.PLAIN,20);
        Font mapleStoryBoldTwenty = new Font("메이플스토리 Bold",Font.BOLD,20);
        Font mapleStoryBoldTwentyFour = new Font("메이플스토리 Bold",Font.BOLD,24);

        startButton.setFont(mapleStoryBoldTwentyFour);
        gameDescriptionButton.setFont(mapleStoryBoldTwentyFour);
        gameDescriptionText.setFont(mapleStoryLightTwenty);
        battleDescription.setFont(mapleStoryLightTwenty);
        battleTime.setFont(mapleStoryBoldTwenty);
        totalScore.setFont(mapleStoryBoldTwentyFour);
        lastScore.setFont(mapleStoryBoldTwentyFour);

        strengthDisplay.setFont(mapleStoryLightSixteen);
        healthPointDisplay.setFont(mapleStoryLightSixteen);
        agilityDisplay.setFont(mapleStoryLightSixteen);
        defenseDisplay.setFont(mapleStoryLightSixteen);
        wisdomDisplay.setFont(mapleStoryLightSixteen);
        viciousnessDisplay.setFont(mapleStoryLightSixteen);

        enemyStrengthDisplay.setFont(mapleStoryLightSixteen);
        enemyHealthPointDisplay.setFont(mapleStoryLightSixteen);

        catBtn.setFont(mapleStoryBoldTwenty);
        dogBtn.setFont(mapleStoryBoldTwenty);
        monkeyBtn.setFont(mapleStoryBoldTwenty);
        alligatorBtn.setFont(mapleStoryBoldTwenty);

        catBasicAttack.setFont(mapleStoryBoldTwenty);
        catSpecialAttack.setFont(mapleStoryBoldTwenty);
        catUltimateAttack.setFont(mapleStoryBoldTwenty);
        catWithDraw.setFont(mapleStoryBoldTwenty);
        dogBasicAttack.setFont(mapleStoryBoldTwenty);
        dogSpecialAttack.setFont(mapleStoryBoldTwenty);
        dogUltimateAttack.setFont(mapleStoryBoldTwenty);
        dogWithDraw.setFont(mapleStoryBoldTwenty);
        monkeyBasicAttack.setFont(mapleStoryBoldTwenty);
        monkeySpecialAttack.setFont(mapleStoryBoldTwenty);
        monkeyUltimateAttack.setFont(mapleStoryBoldTwenty);
        monkeyWithDraw.setFont(mapleStoryBoldTwenty);
        alligatorBasicAttack.setFont(mapleStoryBoldTwenty);
        alligatorSpecialAttack.setFont(mapleStoryBoldTwenty);
        alligatorUltimateAttack.setFont(mapleStoryBoldTwenty);
        alligatorWithDraw.setFont(mapleStoryBoldTwenty);

        // UI 컬러
        gameIntroBtn.setBackground(Color.white);                                                                        //버튼 밖 프레임 채색 목적
        lastScore.setForeground(Color.white);
        rectangleFrame.setBackground(new Color(0,0,0,0));

        animalStatus.setOpaque(false);
        enemyStatus.setOpaque(false);

        characters.setBackground(new Color(0,0,0,0));
        catSkill.setBackground(new Color(0,0,0,0));
        dogSkill.setBackground(new Color(0,0,0,0));
        monkeySkill.setBackground(new Color(0,0,0,0));
        alligatorSkill.setBackground(new Color(0,0,0,0));

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
        alligatorBtn.setForeground(Color.white);
        alligatorBtn.setBackground(Color.black);

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

        alligatorBasicAttack.setForeground(Color.white);
        alligatorBasicAttack.setBackground(Color.black);
        alligatorSpecialAttack.setForeground(Color.white);
        alligatorSpecialAttack.setBackground(Color.black);
        alligatorUltimateAttack.setForeground(Color.white);
        alligatorUltimateAttack.setBackground(Color.black);
        alligatorWithDraw.setForeground(Color.white);
        alligatorWithDraw.setBackground(Color.black);

        // 레이아웃
        gameIntroBtn.setLayout(new FlowLayout(FlowLayout.LEFT, 20,10));
        animalStatus.setLayout(new BoxLayout(animalStatus,BoxLayout.Y_AXIS));
        enemyStatus.setLayout(new BoxLayout(enemyStatus,BoxLayout.Y_AXIS));
        characters.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        catSkill.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        dogSkill.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        monkeySkill.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        alligatorSkill.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        // 컴포넌트 배치
        setLayout(null);   // 반드시 배치전에 null 지정
        gameIntroBtn.setBounds(150,220,300,80);
        gameDescriptionText.setBounds(70,350, 450,260);
        gameOverScreen.setBounds(0,0,600,800);
        gameVictoryScreen.setBounds(0,0,600,800);
        rectangleFrame.setBounds(0,0,600,800);
        battleTime.setBounds(60,-20,100,100);
        totalScore.setBounds(240,-170,400,400);
        lastScore.setBounds(165,200,600,200);
        attackEffect.setBounds(0,-20,800,600);
        healthPotionEffect.setBounds(-60,20,300,300);
        statusPotionEffect.setBounds(-60,20,400,400);
        lifeLabelOne.setBounds(25,380,30,30);
        lifeLabelTwo.setBounds(45,380,30,30);
        lifeLabelThree.setBounds(65,380,30,30);
        lifeLabelFour.setBounds(85,380,30,30);
        catIconLabel.setBounds(20,120,200,200);
        dogIconLabel.setBounds(20,120,250,200);
        monkeyIconLabel.setBounds(20,120,200,200);
        alligatorIconLabel.setBounds(20,60,300,300);
        bearIconLabel.setBounds(360,-110,600,600);
        animalStatus.setBounds(25,320,140,100);
        enemyStatus.setBounds(420,20,150,40);
        characters.setBounds(0,500,600,100);
        catSkill.setBounds(0,600,600,100);
        dogSkill.setBounds(0,600,600,100);
        monkeySkill.setBounds(0,600,600,100);
        alligatorSkill.setBounds(0,600,600,100);
        battleDescriptionScroll.setBounds(160,305,400,140);
        openingScreen.setBounds(0,0,600,800);

        // 초기 UI 설정
        gameVictoryScreen.setVisible(false);
        gameOverScreen.setVisible(false);
        gameDescriptionText.setVisible(false);
        totalScore.setVisible(false);
        animalStatus.setVisible(false);
        enemyStatus.setVisible(false);
        lifeLabelOne.setVisible(false);
        lifeLabelTwo.setVisible(false);
        lifeLabelThree.setVisible(false);
        lifeLabelFour.setVisible(false);
        battleDescriptionScroll.setVisible(false);
        characters.setVisible(false);
        catSkill.setVisible(false);
        dogSkill.setVisible(false);
        monkeySkill.setVisible(false);
        alligatorSkill.setVisible(false);
        catHealthBar.catHealthBar.setVisible(false);
        dogHealthBar.dogHealthBar.setVisible(false);
        monkeyHealthBar.monkeyHealthBar.setVisible(false);
        alligatorHealthBar.alligatorHealthBar.setVisible(false);
        bearHealthBar.bearHealthBar.setVisible(false);
        cat.agilityPortionBtn.setVisible(false);
        cat.healingPortionBtn.setVisible(false);
        dog.defensePortionBtn.setVisible(false);
        dog.healingPortionBtn.setVisible(false);
        monkey.wisdomPortionBtn.setVisible(false);
        monkey.healingPortionBtn.setVisible(false);
        aligator.viciousnessPortionBtn.setVisible(false);
        aligator.healingPortionBtn.setVisible(false);
        // 기본 UI 설정
        setSize(600,800);
        setTitle("베어 헌트");
        setVisible(true); // setVisible 함수가 화면설정 이전으로 가게되면 화면 구성이전의 화면들은 보여지지 않음

        System.identityHashCode(cat.getHealthPoint());

        // Exit 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainDisplay mainDisplay = new MainDisplay();
        mainDisplay.mainFrame();
    }

}




