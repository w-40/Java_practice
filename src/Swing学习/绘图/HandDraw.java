package Swing学习.绘图;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class HandDraw {

    //定义画图区的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //定义变量，保存上一次鼠标拖动时，鼠标的坐标
    private int preX = -1;
    private int preY = -1;

    //定义一个右键菜单，用于设置画笔的颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem("蓝色");

    //定义一个BufferedImage对象
    private BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
    //获取BufferedImage对象关联的画笔
    private Graphics g = image.getGraphics();

    //定义窗口对象
    private Frame frame = new Frame("简单手绘程序");

    //定义画布对象
    private Canvas drawArea =  new Canvas(){
        @Override
        public void paint(Graphics g) {
            //把位图image绘制到0,0坐标点
            g.drawImage(image,0,0,null);
        }
    };

    //定义一个Color对象，用来保存用户设置的画笔颜色,默认为黑色
    private Color forceColor = Color.BLACK;

    public void init(){
        //定义颜色菜单项单击监听器
        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command){
                    case "红色":
                        forceColor=Color.RED;
                        break;
                    case "绿色":
                        forceColor = Color.GREEN;
                        break;
                    case "蓝色":
                        forceColor = Color.BLUE;
                        break;
                }
            }
        };

        //为三个菜单项添加点击事件
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        //把菜单项添加到右键菜单中
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        //把右键菜单添加到绘图区域drawArea
        drawArea.add(colorMenu);

        //将iamge图片背景设置为白色
        g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);

        //设置绘图区域drawArea的大小
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));

        //绘图区域drawArea设置鼠标移动监听器
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            //用于绘制图像
            @Override
            public void mouseDragged(MouseEvent e) {//按下鼠标键并拖动会触发
                //如果上次鼠标的坐标在绘图区域，才开始绘图
                if (preX>0 && preY>0){
                    //设置当前选中的画笔颜色
                    g.setColor(forceColor);
                    //绘制线条，需要有两组坐标，一组是上一次鼠标拖动鼠标时的坐标，一组是现在鼠标的坐标
                    g.drawLine(preX,preY,e.getX(),e.getY());
                }

                //更新preX和preY
                preX = e.getX();
                preY = e.getY();

                //重新绘制drawArea组件
                drawArea.repaint();

            }
        });

        drawArea.addMouseListener(new MouseAdapter() {

            //用于弹出右键菜单
            @Override
            public void mouseReleased(MouseEvent e) {//松开鼠标键会触发
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger){
                    //把colorMenu显示到drawArea画图区域，并跟随鼠标显示
                    colorMenu.show(drawArea,e.getX(),e.getY());
                }

                //当鼠标松开时，把preX和preY重置为-1
                preX = -1;
                preY = -1;

            }
        });

        //把drawArea添加到frame中
        frame.add(drawArea);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new HandDraw().init();
    }
}