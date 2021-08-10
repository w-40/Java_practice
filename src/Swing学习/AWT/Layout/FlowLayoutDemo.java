package Swing学习.AWT.Layout;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试FlowLayout");
        //1.通过SetLayout方法设置容器的布局管理器
 //       frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));//左对齐，水平，垂直间距20
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));//居中对齐，水平，垂直间距20
        //2.添加多个按钮到frame中
        for (int i = 1; i <= 100; i++) {
            frame.add(new Button("按钮" + i));
        }
        //3.设置最佳大小，pack方法
        frame.pack();
        frame.setVisible(true);

    }
}
