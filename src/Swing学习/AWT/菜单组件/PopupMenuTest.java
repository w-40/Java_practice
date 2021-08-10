package Swing学习.AWT.菜单组件;

import java.awt.*;
import java.awt.event.*;

public class PopupMenuTest {
    private Frame frame = new Frame("这里测试PopupMenu");

    //创建文本域
    TextArea ta = new TextArea("我爱中华",6,40);

    //创建Panel容器
    Panel p = new Panel();

    //创建PopMenu
    PopupMenu popupMenu = new PopupMenu();

    //创建菜单项
    MenuItem comment = new MenuItem("注释");
    MenuItem cancelcomment = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");

    public void init(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String actionCommand = e.getActionCommand();
               ta.append("您点击了：" + actionCommand + "\n");
            }
        };

        comment.addActionListener(listener);
        cancelcomment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);

        popupMenu.add(comment);
        popupMenu.add(cancelcomment);
        popupMenu.add(copy);
        popupMenu.add(save);

        p.add(popupMenu);

        //设置Panel的大小
        p.setPreferredSize(new Dimension(400,300));

        //给Panel注册鼠标事件，监听用户释放鼠标的动作
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flag = e.isPopupTrigger();
                if (flag){
                    popupMenu.show(p,e.getX(),e.getY());
                }
            }

        });
        //放置ta和p
        frame.add(ta);
        frame.add(p,BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new PopupMenuTest().init();
    }
}
