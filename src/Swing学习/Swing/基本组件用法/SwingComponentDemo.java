package Swing学习.Swing.基本组件用法;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class SwingComponentDemo {


    JFrame f = new JFrame("测试swing基本组件");

    //定义一个按钮，并为其指定图标
    Icon okIcon = new ImageIcon();
    JButton ok = new JButton("确定",okIcon);

    //定义一个单选按钮，初始处于选中的状态
    JRadioButton male = new JRadioButton("男",true);
    //定义一个单选按钮，初始处于选中状态
    JRadioButton female = new JRadioButton("女",false);

    //定义一个ButtonGroup，把male和female组合起来，实现单选
    ButtonGroup bg  = new ButtonGroup();

    //定义一个复选框，初始处于没有选中状态
    JCheckBox married = new JCheckBox("是否已婚？",false);

    //定义一个数组存储颜色
    String[] colors = { "红色", "绿色 " , "蓝色 " };

    //定义一个下拉选择框，展示颜色
    JComboBox<String> colorChooser = new JComboBox<String>(colors);

    //定一个列表框，展示颜色
    JList<String> colorList = new JList<String>(colors);

    //定义一个8行20列的多行文本域
    JTextArea ta = new JTextArea(8,20);

    //定义一个40列的单行文本域
    JTextField name = new JTextField(40);

    //定义菜单条
    JMenuBar mb = new JMenuBar();

    //定义菜单
    JMenu file = new JMenu("文件");
    JMenu edit = new JMenu("编辑");

    //创建菜单项，并指定图标
    JMenuItem newItem = new JMenuItem("新建");
    JMenuItem saveItem = new JMenuItem("保存");
    JMenuItem exitItem = new JMenuItem("退出");

    JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
    JMenuItem copyItem = new JMenuItem("复制");
    JMenuItem pasteItem = new JMenuItem("粘贴");

    //定义二级菜单，将来会添加到编辑中
    JMenu format = new JMenu("格式");
    JMenuItem commentItem = new JMenuItem("注释");
    JMenuItem cancelItem = new JMenuItem("取消注释");

    //定义一个右键菜单，用于设置程序的外观风格
    JPopupMenu pop = new JPopupMenu();

    //定义一个ButtongGroup对象，用于组合风格按钮，形成单选
    ButtonGroup flavorGroup = new ButtonGroup();

    //定义五个单选按钮菜单项，用于设置程序风格
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格",true);
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格",true);
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格",true);
    JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows 经典风格",true);
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格",true);



    //初始化界面
    public void init(){

        //------------------------组合主区域------------------------
        //创建一个装载文本框和按钮的JPanel
        JPanel bottom = new JPanel();
        bottom.add(name);
        bottom.add(ok);

        f.add(bottom, BorderLayout.SOUTH);

        //创建一个装载下拉选择框、三个JChekBox的JPanel
        JPanel checkPanel = new JPanel();
        checkPanel.add(colorChooser);
        bg.add(male);
        bg.add(female);

        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        //创建一个垂直排列的Box，装载checkPanel和多行文本域
        Box topLeft = Box.createVerticalBox();

        //使用JScrollPane作为普通组件的JViewPort
        JScrollPane taJsp = new JScrollPane(ta);
        topLeft.add(taJsp);
        topLeft.add(checkPanel);

        //创建一个水平排列的Box，装载topLeft和colorList
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        //将top Box 添加到窗口的中间
        f.add(top);

        //---------------------------组合菜单条----------------------------------------------
        //为newItem添加快捷键 ctrl+N
        newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("用户点击了“新建”菜单\n");
            }
        });


        //为file添加菜单项
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        //为edit添加菜单项
        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        //为commentItem添加提示信息
        commentItem.setToolTipText("将程序代码注释起来");

        //为format菜单添加菜单项
        format.add(commentItem);
        format.add(cancelItem);

        //给edit添加一个分隔符
        edit.addSeparator();

        //把format添加到edit中形成二级菜单
        edit.add(format);

        //把edit file 添加到菜单条中
        mb.add(file);
        mb.add(edit);

        //把菜单条设置给窗口
        f.setJMenuBar(mb);

        //------------------------组合右键菜单-----------------------------

        flavorGroup.add(metalItem);
        flavorGroup.add(nimbusItem);
        flavorGroup.add(windowsItem);
        flavorGroup.add(classicItem);
        flavorGroup.add(motifItem);

        //给5个风格菜单创建事件监听器
        ActionListener flavorLister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                try {
                    changeFlavor(command);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };

        //为5个风格菜单项注册监听器
        metalItem.addActionListener(flavorLister);
        nimbusItem.addActionListener(flavorLister);
        windowsItem.addActionListener(flavorLister);
        classicItem.addActionListener(flavorLister);
        motifItem.addActionListener(flavorLister);

        pop.add(metalItem);
        pop.add(nimbusItem);
        pop.add(windowsItem);
        pop.add(classicItem);
        pop.add(motifItem);

        //调用ta组件的setComponentPopupMenu即可设置右键菜单，无需使用事件
        ta.setComponentPopupMenu(pop);

        // 设置关闭窗口时推出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置jFrame最佳大小并可见
        f.pack();
        f.setVisible(true);


    }

    //定义一个方法，用于改变界面风格
    private void changeFlavor(String command) throws Exception{
        switch (command){
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        //更新f窗口内顶级容器以及所有组件的UI
        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        //更新mb菜单条及每部所有组件UI
        SwingUtilities.updateComponentTreeUI(mb);
        //更新右键菜单及内部所有菜单项的UI
        SwingUtilities.updateComponentTreeUI(pop);
    }


    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }

}

