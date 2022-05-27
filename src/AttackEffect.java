import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class AttackEffect extends JComponent {

    JButton effectBtn = new JButton();

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



    public void launchEffect() {
       effectBtn.setVisible(true);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(200,200);
                    add(effectBtn);

                } else if (effectTimeCountOne == 0){
                    effectTimeCountOne = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(190,210);
                    add(effectBtn);

                } else if (effectTimeCountTwo == 0){
                    effectTimeCountTwo = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(180,220);
                    add(effectBtn);

                } else if (effectTimeCountThree == 0){
                    effectTimeCountThree = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(170,230);
                    add(effectBtn);

                } else if (effectTimeCountFour == 0){
                    effectTimeCountFour = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(160,240);
                    add(effectBtn);

                } else if (effectTimeCountFive == 0){
                    effectTimeCountFive = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(20,20);
                    effectBtn.setLocation(150,250);
                    add(effectBtn);

                } else if (effectTimeCountSix == 0){
                    effectTimeCountSix = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(240,200);
                    add(effectBtn);

                } else if (effectTimeCountSeven == 0){
                    effectTimeCountSeven = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(230,210);
                    add(effectBtn);

                } else if (effectTimeCountEight == 0){
                    effectTimeCountEight = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(220,220);
                    add(effectBtn);

                } else if (effectTimeCountNine == 0){
                    effectTimeCountNine = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(210,230);
                    add(effectBtn);

                } else if (effectTimeCountTen == 0){
                    effectTimeCountTen = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(200,240);
                    add(effectBtn);

                } else if (effectTimeCountEleven == 0){
                    effectTimeCountEleven = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(30,30);
                    effectBtn.setLocation(190,250);
                    add(effectBtn);

                } else if (effectTimeCountTwelve == 0){
                    effectTimeCountTwelve = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(280,200);
                    add(effectBtn);

                } else if (effectTimeCountThirteen == 0){
                    effectTimeCountThirteen = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(270,210);
                    add(effectBtn);

                } else if (effectTimeCountFourteen == 0){
                    effectTimeCountFourteen = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(260,220);
                    add(effectBtn);

                } else if (effectTimeCountFifteen == 0){
                    effectTimeCountFifteen = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(250,230);
                    add(effectBtn);

                } else if (effectTimeCountSix == 0){
                    effectTimeCountSixteen = 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(270,240);
                    add(effectBtn);

                } else if (effectTimeCountSeventeen == 0){
                    effectTimeCountSeventeen= 40;
                    effectBtn.setVisible(false);
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
                    effectBtn.setBackground(Color.red);
                    effectBtn.setSize(40,40);
                    effectBtn.setLocation(280,250);
                    add(effectBtn);

                } else if (effectTimeCountEighteen == 0){
                    effectTimeCountEighteen= 40;
                    effectBtn.setVisible(false);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,200); // 태스크 발동, 0ms 즉시 실행, 200ms 매구간 실행
    }






}
