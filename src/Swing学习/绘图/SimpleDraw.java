package Swing学习.绘图;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDraw {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private Frame frame = new Frame("This Test Draw");

    Button btnRect = new Button("绘制矩形");
    Button btnOval = new Button("绘制椭圆");

    //定义一个变量，记录当前要绘制椭圆还是矩形
    private String shape = "";

    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //绘制不同的图形
            if (shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.BLACK);
                g.drawRect(100,100,150,100);
            }else if (shape.equals(OVAL_SHAPE)){
                //绘制椭圆
                g.setColor(Color.RED);
                g.drawOval(100,100,150,100);
            }
        }
    }

    //创建自定义画布对象
    MyCanvas drawArea = new MyCanvas();

    public void init(){
        btnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改标记的值为rect
                shape = RECT_SHAPE;
                drawArea.repaint();
            }
        });
        btnOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改标记的值为oval
                shape = OVAL_SHAPE;
                drawArea.repaint();
            }
        });

        //创建Panel，承载按钮
        Panel p = new Panel();
        p.add(btnRect);
        p.add(btnOval);

        frame.add(p,BorderLayout.SOUTH);

        //drawArea的大小需要设置
        drawArea.setPreferredSize(new Dimension(300,300));
        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }
}
