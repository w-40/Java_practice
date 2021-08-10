package Swing学习.Swing.特殊容器用法;
//可以放置标签页
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneTest {
    JFrame jf = new JFrame("测试JTabbedPane");



    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP,JTabbedPane.WRAP_TAB_LAYOUT);

    public void init(){


        //设置jf大小
        jf.setBounds(400,400,400,400);
        //设置jf大小不能变化
        jf.setResizable(false);


      //  ImageIcon icon = new ImageIcon(ImagePathUtil.getRealPath("3\\open.gif"));
        //添加标签
        tabbedPane.addTab("用户管理",null,new JList<String>(new String[]{"用户一","用户二","用户三"}));
        tabbedPane.addTab("商品管理",new JList<String>(new String[]{"商品一","商品二","商品三"}));
        tabbedPane.addTab("订单管理",null,new JList<String>(new String[]{"订单一","订单二","订单三"}));

        //设置第二个标签默认选中
        tabbedPane.setSelectedIndex(1);
        //设置第一个标签不能用
        tabbedPane.setEnabledAt(0,false);

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                JOptionPane.showMessageDialog(jf,"选中了第"+(selectedIndex+1)+"个标签");
            }
        });


        jf.add(tabbedPane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }


    public static void main(String[] args) {
        new JTabbedPaneTest().init();
    }
}

