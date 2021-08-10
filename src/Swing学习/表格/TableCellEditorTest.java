package Swing学习.表格;

//import cn.itcast.swing.util.ImagePathUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;

public class TableCellEditorTest {
    JFrame jf = new JFrame("使用单元格编辑器");

    JTable table;

    //定义二维数组作为表格数据

    Object[][] tableData = {

 //           new Object[]{"李清照",29,"女",new ImageIcon(ImagePathUtil.getRealPath("11\\3.gif")),new ImageIcon(ImagePathUtil.getRealPath("11\\3.gif")),true},
  //          new Object[]{"苏格拉底",56,"男",new ImageIcon(ImagePathUtil.getRealPath("11\\1.gif")),new ImageIcon(ImagePathUtil.getRealPath("11\\1.gif")),false},
  //         new Object[]{"李白",35,"男",new ImageIcon(ImagePathUtil.getRealPath("11\\4.gif")),new ImageIcon(ImagePathUtil.getRealPath("11\\4.gif")),true},
  //          new Object[]{"弄玉",18,"女",new ImageIcon(ImagePathUtil.getRealPath("11\\2.gif")),new ImageIcon(ImagePathUtil.getRealPath("11\\2.gif")),true},
   //         new Object[]{"虎头",2,"男",new ImageIcon(ImagePathUtil.getRealPath("11\\5.gif")),new ImageIcon(ImagePathUtil.getRealPath("11\\5.gif")),false},

    };

    //定义一个一维数组，作为列标题
    String[] columnTitle = {"姓名","年龄","性别","主头像","次头像","是否中国人"};


    public void init(){
        ExtendedTableModel model = new ExtendedTableModel(columnTitle,tableData);

        table  =  new JTable(model);

        table.setRowSelectionAllowed(false);
        table.setRowHeight(40);

        //为表格指定默认的编辑器
        table.setDefaultEditor(ImageIcon.class,new ImageCellEditor());

        //获取第5列
        TableColumn column = table.getColumnModel().getColumn(4);
        //创建JComboBox对象，并添加多个图标列表项
        JComboBox<ImageIcon> editCombo = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
        //    editCombo.addItem(new ImageIcon(ImagePathUtil.getRealPath("11\\"+i+".gif")));
        }

        //设置第5列使用基于JComboBox的DefaultCellEditor
        column.setCellEditor(new DefaultCellEditor(editCombo));

        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    public static void main(String[] args) {
        new TableCellEditorTest().init();
    }


    //自定义ExtendedTableModel对象
    class ExtendedTableModel extends DefaultTableModel {

        //重新提供一个构造器，该构造器的实现委托给DefaultTableModel父类
        public  ExtendedTableModel(String[] columnNames,Object[][] cells){
            super(cells,columnNames);
        }

        //重写getColumnClass方法，根据每列第一个值，返回其真实的数据类型

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0,columnIndex).getClass();
        }
    }

    //扩展DefaultCellEditor来实现TableCellEditor
    class ImageCellEditor extends DefaultCellEditor{

        //定义文件选择器
        private JFileChooser fDialog = new JFileChooser();
        //定义文本域
        private JTextField field = new JPasswordField(15);
        //定义按钮
        private JButton button = new JButton("...");


        public ImageCellEditor() {
            //因为DefaultCellEditor没有无参构造器
            //所以这里显示调用父类有参数的构造器
            super(new JTextField());
            initEditor();
        }

        private void initEditor() {
            //禁止编辑
            field.setEnabled(false);
            //为按钮添加监听器，当用户单击按钮时，
            //系统将出现一个文件选择器让用户选择图标文件
            button.addActionListener(e->{
            //    fDialog.setCurrentDirectory(new File(ImagePathUtil.getRealPath("11")));
                int result = fDialog.showOpenDialog(null);

                if (result==JFileChooser.CANCEL_OPTION){
                    //用户点击了取消
                    super.cancelCellEditing();
                    return;
                }else{
                    //用户点击了确定按钮
         //           field.setText(ImagePathUtil.getRealPath("11\\"+fDialog.getSelectedFile().getName()));
                    button.getParent().transferFocus();
                }
            });

            //为文件选择器安装文件过滤器
            fDialog.addChoosableFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()){
                        return true;
                    }

                    String extension = Utils.getExtension(f);
                    if (extension!=null){
                        if (extension.equals(Utils.tiff)
                                || extension.equals(Utils.tif)
                                || extension.equals(Utils.gif)
                                || extension.equals(Utils.jpeg)
                                || extension.equals(Utils.jpg)
                                || extension.equals(Utils.png)

                        ){
                            return true;
                        }else {
                            return false;
                        }
                    }

                    return false;
                }

                @Override
                public String getDescription() {
                    return "有效的图片文件";
                }
            });

            fDialog.setAcceptAllFileFilterUsed(false);
        }

        //重写getTableCellEditorComponent方法，绘制单元格组件


        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.button.setPreferredSize(new Dimension(20,20));
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            field.setText(value.toString());
            panel.add(this.field,BorderLayout.CENTER);
            panel.add(this.button,BorderLayout.EAST);

            return panel;
        }

        //重写getCellEditorValue方法，填充单元格的内容
        @Override
        public Object getCellEditorValue() {
            return new ImageIcon(field.getText());
        }


    }

}
class Utils{
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";

    public static String getExtension(File f){
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i>0 && i<s.length()-1){
            ext=s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}