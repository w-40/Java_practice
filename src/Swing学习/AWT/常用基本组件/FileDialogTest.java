package Swing学习.AWT.常用基本组件;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogTest {
    public static void main(String[] args) {

        Frame frame = new Frame("这里测试FileDialog");

        //1.创建两个FileDialog对象
        FileDialog f1 = new FileDialog(frame, "选择要打开的文件", FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame, "选择要保存的路径", FileDialog.SAVE);
        //2.创建两个按钮
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");
        //3.给这两个按钮设置点击后的行为，获取打开或者保存的文件名
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);//代码会阻塞到这里

                //获取选择的路径及文件
                String directory = f1.getDirectory();
                String file = f1.getFile();
                System.out.println("打开的文件路径为" + directory);
                System.out.println("打开的文件名称为" + file);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);
                String directory = f2.getDirectory();
                String file = f2.getFile();
                System.out.println("打开的文件路径为" + directory);
                System.out.println("打开的文件名称为" + file);
            }
        });
        //4.把按钮添加到frame中
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);

    }
}
