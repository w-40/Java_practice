package Swing学习.表格;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class SortTable {

    JFrame jf = new JFrame("可按照列排序的表格");

    //定义二维数组作为表格数据

    Object[][] tableData = {

            new Object[]{"李清照",29,"女"},
            new Object[]{"苏格拉底",56,"男"},
            new Object[]{"李白",35,"男"},
            new Object[]{"弄玉",18,"女"},
            new Object[]{"虎头",2,"男"},

    };

    //定义一个一维数组，作为列标题
    Object[] columnTitle = {"姓名","年龄","性别"};

    JTable table = new JTable(tableData,columnTitle);

    //将原表格里面的TableModel封装成SortTableModel对象
    SortTableModel sorterModel = new SortTableModel(table.getModel());

    public void init(){
        //使用包装后的SortTableModel对象作为JTable的model对象
        table.setModel(sorterModel);

        //为每一列的列头增加鼠标监听器
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果单击次数小于2，则返回，不是双击
                if (e.getClickCount()<2){
                    return;
                }

                //找出鼠标双击事件所在列的索引
                int tableColumn = table.columnAtPoint(e.getPoint());

                //将JTable中的列索引，转换成对应的TableModel中的列索引
                int modelColumn = table.convertColumnIndexToModel(tableColumn);

                //根据指定列进行排序
                sorterModel.sort(modelColumn);
            }
        });

        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    public static void main(String[] args) {
        new SortTable().init();
    }


    //自定义SortTableModel，增强原有的TableModel

    class SortTableModel extends AbstractTableModel{

        private TableModel model;
        private int sortColumn;
        private Row[] rows;

        public SortTableModel(TableModel model){
            this.model = model;
            rows = new Row[model.getRowCount()];
            //将原TableModel中的每行记录的索引用Row数组保存起来
            for (int i = 0; i < rows.length; i++) {
                rows[i] = new Row(i);
            }

        }

        //实现根据指定列进行排序
        public void sort(int c){
            sortColumn = c;
            Arrays.sort(rows);
            //触发数据改变的事件
            fireTableDataChanged();
        }

        //下面3个方法需要访问model中的数据，所以涉及本model中数据和被封装model数据中的索引转换，程序使用rows完成这种转换

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return model.getValueAt(rows[rowIndex].index,columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return isCellEditable(rows[rowIndex].index,columnIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            model.setValueAt(aValue,rows[rowIndex].index,columnIndex);
        }

        //下面方法的实现把该model的方法委托给原封装的model来实现


        @Override
        public int getRowCount() {

            return model.getRowCount();
        }

        @Override
        public int getColumnCount() {
            return model.getColumnCount();
        }


        @Override
        public String getColumnName(int column) {
            return model.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return model.getColumnClass(columnIndex);
        }

        private class Row implements Comparable<Row>{
            //该index保存着被封装Model里每行记录的索引
            public int index;

            public Row(int index) {
                this.index = index;
            }

            //实现两行之间大小的比较
            @Override
            public int compareTo(Row o) {
                Object a = model.getValueAt(index, sortColumn);
                Object b = model.getValueAt(o.index, sortColumn);

                if (a instanceof Comparable){
                    return ((Comparable) a).compareTo(b);
                }else{
                    return a.toString().compareTo(b.toString());
                }
            }
        }
    }

}
