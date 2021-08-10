package Swing学习.AWT.常用基本组件;

import javax.swing.*;
import java.awt.*;

public class BasicComponentDemo {
    Frame frame = new Frame("这里测试基本组件");
    TextArea ta = new TextArea(5,20);
    Choice colorChooser = new Choice();
    CheckboxGroup chg = new CheckboxGroup();
    Checkbox male = new Checkbox("男",chg,true);
    Checkbox female = new Checkbox("女",chg,false);

    Checkbox isMarried = new Checkbox("是否已婚？");
    TextField tf = new TextField(50);
    Button ok = new Button("确认");

    List colorList = new List(6,true);//默认单选，加上true是多选



    public void init(){
        //组装界面

        //组装底部
        Box bBox = Box.createHorizontalBox();
        bBox.add(tf);
        bBox.add(ok);
        frame.add(bBox,BorderLayout.SOUTH);

        //组装选择部分
        colorChooser.add("红色");
        colorChooser.add("蓝色");
        colorChooser.add("绿色");
        Box cBox = Box.createHorizontalBox();
        cBox.add(colorChooser);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarried);

        //组装文本域
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(cBox);

        //组装顶部左边和列表框
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        frame.add(top);

        //设置frame为最佳大小，并且可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BasicComponentDemo().init();
    }
}
