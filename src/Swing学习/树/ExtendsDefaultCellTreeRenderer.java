package Swing学习.树;

//import cn.itcast.swing.util.ImagePathUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ExtendsDefaultCellTreeRenderer {

    JFrame jf = new JFrame("根据结点类型定义图标");

    JTree tree;

    //定义几个初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeData(DBObjectType.ROOT,"数据库导航"));
    DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeData(DBObjectType.DATABASE,"公司工资数据库"));
    DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(new NodeData(DBObjectType.DATABASE,"公司客户数据库"));
    DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE,"员工表"));
    DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE,"考勤表"));
    DefaultMutableTreeNode concat = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE,"联系方式表"));
    DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeData(DBObjectType.INDEX,"员工ID"));
    DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN,"姓名"));
    DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN,"性别"));

    public void init(){
        //通过结点的add方法，建立结点的父子关系

        root.add(salaryDb);
        root.add(customerDb);

        salaryDb.add(employee);
        salaryDb.add(attend);

        customerDb.add(concat);

        concat.add(id);
        concat.add(name);
        concat.add(gender);

        tree = new JTree(root);

        tree.setCellRenderer(new MyRenderer());

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);

        //设置使用windows外观风格
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //更新JTree的UI外观
        SwingUtilities.updateComponentTreeUI(tree);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new ExtendsDefaultCellTreeRenderer().init();
    }

    class MyRenderer extends DefaultTreeCellRenderer{
        //初始化5个图标
    //    ImageIcon rootIcon = new ImageIcon(ImagePathUtil.getRealPath("10\\root.gif"));
    //    ImageIcon databaseIcon = new ImageIcon(ImagePathUtil.getRealPath("10\\database.gif"));
    //    ImageIcon tableIcon = new ImageIcon(ImagePathUtil.getRealPath("10\\table.gif"));
    //    ImageIcon columnIcon = new ImageIcon(ImagePathUtil.getRealPath("10\\column.gif"));
    //    ImageIcon indexIcon = new ImageIcon(ImagePathUtil.getRealPath("10\\index.gif"));

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //执行父类默认的绘制结点操作
            super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
            DefaultMutableTreeNode  node = (DefaultMutableTreeNode) value;

            NodeData data = (NodeData) node.getUserObject();
            //根据结点数据中的nodeType决定结点的图标
            ImageIcon icon = null;
            switch (data.nodeType){
                case DBObjectType.ROOT:
                //    icon = rootIcon;
                    break;
                case DBObjectType.DATABASE:
              //      icon = databaseIcon;
                    break;
                case DBObjectType.TABLE:
                //    icon = tableIcon;
                    break;
                case DBObjectType.COLUMN:
                //    icon = columnIcon;
                    break;
                case DBObjectType.INDEX:
               //     icon = indexIcon;
                    break;
            }

            //改变图标
            this.setIcon(icon);

            return this;
        }
    }


    //定义一个NodeData类，用于封装结点数据
    class NodeData{
        public int nodeType;
        public String nodeData;

        public NodeData(int nodeType, String nodeData) {
            this.nodeType = nodeType;
            this.nodeData = nodeData;
        }

        @Override
        public String toString() {
            return this.nodeData;
        }
    }

    //定义一个接口，该接口里包含数据库对象类型的常量
    interface  DBObjectType{
        int ROOT=0;
        int DATABASE=1;
        int TABLE=2;
        int COLUMN=3;
        int INDEX=4;
    }

}
