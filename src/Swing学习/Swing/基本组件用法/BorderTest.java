package Swing学习.Swing.基本组件用法;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BorderTest {

    JFrame jf  = new JFrame("测试边框");

    public void init(){
        //设置Jframe为网格布局
        jf.setLayout(new GridLayout(2,4));

        //创建凸起的斜边框，分别设置四条边的颜色
        Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
        jf.add(getPanelWithBorder(bb,"BevelBorder"));


        //创建LineBorder
        Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getPanelWithBorder(lb,"LineBorder"));

        //创建EmptyBorder，会在组件的四周留白
        Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
        jf.add(getPanelWithBorder(eb,"EmptyBorder"));

        //创建EtchedBorder，
        Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getPanelWithBorder(etb,"EtchedBorder"));

        //创建TitledBorder,为原有的Border添加标题
        TitledBorder tb = new TitledBorder(lb,"测试标题",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
        jf.add(getPanelWithBorder(tb,"TitledBorder"));

        //直接创建MatteBorder，它是EmptyBorder的子类，EmptyBorder是留白，而MatteBorder可以给留空的区域填充颜色
        MatteBorder mb = new MatteBorder(20,5,10,30,Color.GREEN);
        jf.add(getPanelWithBorder(mb,"MatteBorder"));

        //直接创创建CompoundBorder，将两个边框组合成新边框
        CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED,8),tb);
        jf.add(getPanelWithBorder(cb,"CompoundBorder"));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }
    public JPanel getPanelWithBorder(Border border,String borderName){
        JPanel jPanel = new JPanel();

        jPanel.add(new JLabel(borderName));

        //为panel设置边框
        jPanel.setBorder(border);

        return jPanel;
    }
    public static void main(String[] args) {
        new BorderTest().init();
    }
}
