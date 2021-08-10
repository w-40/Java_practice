package Swing学习.树;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class SelectJTree {
    JFrame jf = new JFrame("监听树的选择事件");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    JTextArea eventTxt = new JTextArea(5, 20);

    public void init() {

        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        //添加监听器
        tree.addTreeSelectionListener(e -> {
            if (e.getOldLeadSelectionPath()!=null){
                eventTxt.append("原选中结点的路径："+e.getOldLeadSelectionPath().toString()+"\n");
            }

            eventTxt.append("新选中结点的路径："+e.getNewLeadSelectionPath().toString()+"\n");
        });

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(tree));
        box.add(new JScrollPane(eventTxt));

        jf.add(box);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectJTree().init();
    }
}
