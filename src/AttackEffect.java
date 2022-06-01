import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class AttackEffect extends JComponent {

    JButton enemyAttackEffectBtn = new JButton();
    JButton animalDamageEffectBtn = new JButton();


    int effectTimeCountOne = 40;
    int effectTimeCountTwo = 40;
    int effectTimeCountThree = 40;
    int effectTimeCountFour = 40;
    int effectTimeCountFive = 40;
    int effectTimeCountSix = 40;
    int effectTimeCountSeven = 40;
    int effectTimeCountEight = 40;
    int effectTimeCountNine = 40;
    int effectTimeCountTen = 40;
    int effectTimeCountEleven = 40;
    int effectTimeCountTwelve = 40;
    int effectTimeCountThirteen = 40;
    int effectTimeCountFourteen = 40;
    int effectTimeCountFifteen = 40;
    int effectTimeCountSixteen = 40;
    int effectTimeCountSeventeen = 40;
    int effectTimeCountEighteen = 40;

    int effectTimeCountExtra = 100;

    public void launchEffect() {
       enemyAttackEffectBtn.setVisible(true);
       launchEffectComponentOne();
       launchEffectComponentTwo();
       launchEffectComponentThree();
       launchEffectComponentFour();
       launchEffectComponentFive();
       launchEffectComponentSix();
       launchEffectComponentSeven();
       launchEffectComponentEight();
       launchEffectComponentNine();
       launchEffectComponentTen();
       launchEffectComponentEleven();
       launchEffectComponentTwelve();
       launchEffectComponentThirteen();
       launchEffectComponentFourteen();
       launchEffectComponentFifteen();
       launchEffectComponentSixteen();
       launchEffectComponentSeventeen();
       launchEffectComponentEighteen();
    }

    public void launchEffectComponentOne() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountOne > 0){
                    effectTimeCountOne--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(400,200);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountOne == 0){
                    effectTimeCountOne = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentTwo() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountTwo > 0){
                    effectTimeCountTwo--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(390,210);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountTwo == 0){
                    effectTimeCountTwo = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentThree() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountThree > 0){
                    effectTimeCountThree--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(380,220);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountThree == 0){
                    effectTimeCountThree = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행

    }

    public void launchEffectComponentFour() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountFour > 0){
                    effectTimeCountFour--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(370,230);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountFour == 0){
                    effectTimeCountFour = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentFive() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountFive > 0){
                    effectTimeCountFive--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(360,240);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountFive == 0){
                    effectTimeCountFive = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentSix() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountSix > 0){
                    effectTimeCountSix--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(20,20);
                    enemyAttackEffectBtn.setLocation(350,250);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountSix == 0){
                    effectTimeCountSix = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentSeven() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountSeven > 0){
                    effectTimeCountSeven--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(440,200);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountSeven == 0){
                    effectTimeCountSeven = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentEight() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountEight > 0){
                    effectTimeCountEight--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(430,210);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountEight == 0){
                    effectTimeCountEight = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentNine() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountNine > 0){
                    effectTimeCountNine--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(420,220);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountNine == 0){
                    effectTimeCountNine = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentTen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountTen > 0){
                    effectTimeCountTen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(410,230);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountTen == 0){
                    effectTimeCountTen = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentEleven() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountEleven > 0){
                    effectTimeCountEleven--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(400,240);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountEleven == 0){
                    effectTimeCountEleven = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentTwelve() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountTwelve > 0){
                    effectTimeCountTwelve--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(30,30);
                    enemyAttackEffectBtn.setLocation(390,250);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountTwelve == 0){
                    effectTimeCountTwelve = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentThirteen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountThirteen > 0){
                    effectTimeCountThirteen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(480,200);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountThirteen == 0){
                    effectTimeCountThirteen = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentFourteen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountFourteen > 0){
                    effectTimeCountFourteen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(470,210);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountFourteen == 0){
                    effectTimeCountFourteen = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentFifteen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountFifteen > 0){
                    effectTimeCountFifteen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(460,220);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountFifteen == 0){
                    effectTimeCountFifteen = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentSixteen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountSixteen > 0){
                    effectTimeCountSixteen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(450,230);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountSixteen == 0){
                    effectTimeCountSixteen = 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentSeventeen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountSeventeen > 0){
                    effectTimeCountSeventeen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(470,240);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountSeventeen == 0){
                    effectTimeCountSeventeen= 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }

    public void launchEffectComponentEighteen() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountEighteen > 0){
                    effectTimeCountEighteen--;
                    enemyAttackEffectBtn.setBackground(Color.red);
                    enemyAttackEffectBtn.setSize(40,40);
                    enemyAttackEffectBtn.setLocation(480,250);
                    add(enemyAttackEffectBtn);

                } else if (effectTimeCountEighteen == 0){
                    effectTimeCountEighteen= 40;
                    enemyAttackEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }


    public void launchEffectExtra(){
        animalDamageEffectBtn.setVisible(true);
        launchEffectExtraComponentIntegration();
    }

    public void launchEffectExtraComponentIntegration() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(effectTimeCountExtra > 0){
                    int randomWidthAndHeight = (int) (Math.random()*21)+20;                                             // 20~40 사이 정수
                    int randomLocationRangeX = (int) (Math.random()*121)+30;                                             // 30~150 사이 정수
                    int randomLocationRangeY = (int) (Math.random()*121)+160;                                             // 160~280 사이 정수

                    effectTimeCountExtra--;
                    animalDamageEffectBtn.setBackground(Color.orange);
                    animalDamageEffectBtn.setSize(randomWidthAndHeight,randomWidthAndHeight);
                    animalDamageEffectBtn.setLocation(randomLocationRangeX,randomLocationRangeY);
                    add(animalDamageEffectBtn);

                } else if (effectTimeCountExtra == 0){
                    effectTimeCountExtra = 100;
                    animalDamageEffectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,50); // 태스크 발동, 0ms 즉발 실행, 50ms 매구간 실행
    }






}
