package Swing学习.绘图;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.Timer;

public class PinBall {
    //创建窗口对象
    private Frame frame = new Frame("弹球游戏");
    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;

    //球拍的高度和宽度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;
    //小球的大小
    private final int BALL_SIZE = 16;

    //定义变量，记录小球的坐标
    private int ballX = 120;
    private int ballY = 20;

    //定义变量，记录小球在x和y方向上分别移动的速度
    private int speedY = 10;
    private int speedX = 5;

    //定义变量，记录球拍的坐标
    private int racketX = 120;
    private final int reacetY = 340;

    //定义变量，标识当前游戏是否已结束
    private boolean isOver = false;

    //声明一个定时器
    private Timer timer;

    //自定义一个类，继承canvas，充当画布
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //在这里绘制内容

            if (isOver) {
                //游戏结束
                g.setColor(Color.BLUE);

                g.setFont(new Font("Times", Font.BOLD, 30));

                g.drawString("游戏结束", 50, 200);

            } else {
                //游戏中

                //绘制小球
                g.setColor(Color.RED);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

                //绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(racketX, reacetY, RACKET_WIDTH, RACKET_HEIGHT);

            }


        }
    }

    MyCanvas drawArea = new MyCanvas();

    public void init() {
        //组装视图，游戏逻辑的控制

        //完成球拍坐标的变化
        KeyListener listener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取当前按下的键
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    //<- 应该向左移动
                    if (racketX > 0) {
                        racketX -= 10;
                    }

                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    //-> 应该向右移动
                    if (racketX < (TABLE_WIDTH - RACKET_WIDTH)) {
                        racketX += 10;
                    }

                }
            }
        };

        //给Frame和drawArea注册监听器
        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);

        //小球坐标的控制

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据边界范围，修正速度
                if (ballX <= 0 || ballX >= (TABLE_WIDTH - BALL_SIZE)) {
                    speedX = -speedX;
                }
                if (ballY <= 0 || (ballY > reacetY - BALL_SIZE && ballX > racketX && ballX < racketX + RACKET_WIDTH)) {
                    speedY = -speedY;
                }
                if (ballY > reacetY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                    //小球超出球拍范围，游戏结束

                    //停止定时器
                    timer.stop();
                    //修改游戏是否结束的标记
                    isOver = true;
                    //重绘界面
                    drawArea.repaint();
                }

                //更新小球坐标，重绘界面
                ballX += speedX;
                ballY += speedY;

                //重绘界面
                drawArea.repaint();
            }
        };

        timer = new Timer(100, task);
        timer.start();

        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(drawArea);

        frame.pack();
        //设置WindowListener，监听用户点击X的动作，如果点击X，则关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PinBall().init();
    }
}
