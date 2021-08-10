package Swing学习.树;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditTree {

    JFrame jf ;
    JTree tree;

    //JTree关联的数据模型对象
    DefaultTreeModel model;

    //定义几个初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    //定义需要被拖动的TreePath
    TreePath movePath;

    //定义按钮，完成操作
    JButton addSiblingBtn = new JButton("添加兄弟结点");
    JButton addChildBtn = new JButton("添加子结点");
    JButton deleteBtn = new JButton("删除结点");
    JButton editBtn = new JButton("编辑当前结点");

    public void init(){

        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        jf = new JFrame("可编辑结点的树");
        tree = new JTree(root);

        //获取JTree关联的数据模型TreeModel对象
        model = (DefaultTreeModel) tree.getModel();

        //设置JTree可编辑
        tree.setEditable(true);

        //创建鼠标事件监听器
        MouseListener ml = new MouseAdapter() {

            //按下鼠标时，获得被拖动的结点
            @Override
            public void mousePressed(MouseEvent e) {
                //如果需要唯一确定某个结点，则必须通过TreePath来获取
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp!=null){
                    movePath = tp;
                }
            }

            //松开树表示，确定即将被拖入到的父结点
            @Override
            public void mouseReleased(MouseEvent e) {

                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp!=null && movePath!=null){
                    //阻止向子结点拖动
                    if (movePath.isDescendant(tp) && movePath!=tp){
                        JOptionPane.showMessageDialog(jf,"目标结点是被移动结点的子结点，无法移动！","非法移动",JOptionPane.WARNING_MESSAGE);
                    }
                    //不是向子结点移动，并且鼠标按下和松开也不是同一个结点

                    if (movePath!=tp){
                        //add方法内部，先将该结点从原父结点删除，然后再把该结点添加到新结点中
                        DefaultMutableTreeNode tartParentNode = (DefaultMutableTreeNode) tp.getLastPathComponent();
                        DefaultMutableTreeNode moveNode = (DefaultMutableTreeNode) movePath.getLastPathComponent();
                        tartParentNode.add(moveNode);

                        movePath=null;
                        tree.updateUI();
                    }
                }
            }
        };

        //为JTree添加鼠标监听器
        tree.addMouseListener(ml);

        JPanel panel = new JPanel();

        addSiblingBtn.addActionListener(e -> {
            //获取选中结点
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            //如果结点为空，则直接返回
            if (selectedNode==null){
                return;
            }

            //获取该选中结点的父结点
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();

            //如果父结点为空，则直接返回
            if (parent==null){
                return;
            }

            //创建一个新结点
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

            //获取选中结点的索引
            int selectedIndex = parent.getIndex(selectedNode);

            //在选中位置插入新结点
            model.insertNodeInto(newNode,parent,selectedIndex);

            //----------显示新结点---------------
            //获取从根结点到新结点的所有结点
            TreeNode[] pathToRoot = model.getPathToRoot(newNode);

            //使用指定的结点数组创建TreePath
            TreePath treePath = new TreePath(pathToRoot);

            //显示指定的treePath
            tree.scrollPathToVisible(treePath);


        });

        panel.add(addSiblingBtn);

        addChildBtn.addActionListener(e -> {
            //获取选中结点
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectedNode==null){
                return ;
            }

            //创建新结点
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

            //model.insertNodeInto(newNode,selectedNode,selectedNode.getChildCount());使用TreeModel的方法添加，不需要手动刷新UI
            selectedNode.add(newNode);//使用TreeNode的方法添加，需要手动刷新UI

            //显示新结点

            TreeNode[] pathToRoot = model.getPathToRoot(newNode);
            TreePath treePath = new TreePath(pathToRoot);
            tree.scrollPathToVisible(treePath);

            //手动刷新UI
            tree.updateUI();

        });

        panel.add(addChildBtn);

        deleteBtn.addActionListener(e -> {

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectedNode!=null && selectedNode.getParent()!=null){
                model.removeNodeFromParent(selectedNode);
            }

        });

        panel.add(deleteBtn);

        //实现编辑结点的监听器
        editBtn.addActionListener(e -> {

            TreePath selectionPath = tree.getSelectionPath();

            if (selectionPath!=null){
                //编辑选中结点
                tree.startEditingAtPath(selectionPath);
            }

        });

        panel.add(editBtn);

        jf.add(new JScrollPane(tree));
        jf.add(panel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new EditTree().init();
    }
}
