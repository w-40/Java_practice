package Swing学习.树;

//import cn.itcast.swing.util.ImagePathUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class CustomerTreeNode {

    JFrame jf = new JFrame("定制树的结点");

    JTree tree;

    //定义几个初始结点

    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suge = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎头");

    public void init() {

        friends.add(qingzhao);
        friends.add(suge);
        friends.add(libai);
        friends.add(nongyu);
        friends.add(hutou);

        tree = new JTree(friends);

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);


        tree.setCellRenderer(new ImageCellRenderer());



        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new CustomerTreeNode().init();
    }


    class ImageCellRenderer extends JPanel implements TreeCellRenderer {

        private ImageIcon icon;
        private String name;
        //定义绘制单元格时的背景色
        private Color background;
        //定义绘制单元格时的前景色
        private Color foreground;


        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
          //  icon = new ImageIcon(ImagePathUtil.getRealPath("10\\" + value + ".gif"));

            name = value.toString();

            background = hasFocus ? new Color(140, 200, 235) : new Color(255, 255, 255);
            foreground = hasFocus ? new Color(255,255,3) : new Color(0,0,0);
            //返回当前JPanel作为结点
            return this;
        }

        //重写paintComponent改变JPanel的外观

        @Override
        protected void paintComponent(Graphics g) {
            int imageWidth = icon.getImage().getWidth(null);
            int imageHeight = icon.getImage().getHeight(null);
            g.setColor(background);
            g.fillRect(0,0,getWidth(),getHeight());

            g.setColor(foreground);
            //绘制好友图标
            g.drawImage(icon.getImage(),getWidth()/2-imageWidth/2,10,null);

            //绘制好友姓名
            g.setFont(new Font("SansSerif",Font.BOLD,18));

            g.drawString(name,getWidth()/2-name.length()*10,imageHeight+30);

        }


        //设置当前组件结点最佳大小
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80,80);
        }
    }
}
