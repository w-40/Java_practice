package Swing学习.树;

//import cn.itcast.swing.util.ImagePathUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ChangeAllCellRender {

    JFrame jf = new JFrame("改变所有结点外观");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    public void init(){
        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        //创建一个DefaultTreeCellRenderer对象
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        //设置非选定结点的背景颜色
        cellRenderer.setBackgroundNonSelectionColor(new Color(220,220,220));
        //设置选中结点的背景色
        cellRenderer.setBackgroundSelectionColor(new Color(140,140,140));
        //设置选中状态下结点的边框颜色
        cellRenderer.setBorderSelectionColor(Color.BLACK);
        //设置处于折叠状态下非叶子结点的图标
    //    cellRenderer.setClosedIcon(new ImageIcon(ImagePathUtil.getRealPath("10\\close.gif")));
        //设置结点文本的字体
        cellRenderer.setFont(new Font("SansSerif",Font.BOLD,16));
        //设置叶子结点图标
  //      cellRenderer.setLeafIcon(new ImageIcon(ImagePathUtil.getRealPath("10\\leaf.png")));
        //设置处于展开状态下非叶子结点图标跑
 //       cellRenderer.setOpenIcon(new ImageIcon(ImagePathUtil.getRealPath("10\\open.gif")));
        //设置绘制非选中状态下结点文本颜色
        cellRenderer.setTextNonSelectionColor(new Color(255,0,0));
        //设置选中状态下结点的文本颜色
        cellRenderer.setTextSelectionColor(new Color(0,0,255));

        tree.setCellRenderer(cellRenderer);

        tree.setShowsRootHandles(true);

        tree.setRootVisible(true);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }


    public static void main(String[] args) {
        new ChangeAllCellRender().init();
    }

}
