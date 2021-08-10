package Swing学习.表格;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class TableModelTest {
    JFrame jf = new JFrame("数据表管理工具");

    JScrollPane scrollPane;
    ResultSetTableModel model;

    //用于装载数据表的JComboBox
    JComboBox<String> tableNames = new JComboBox<>();
    JTextArea changeMsg = new JTextArea(4, 80);

    ResultSet rs;

    Connection conn;
    Statement stmt;

    public void init() {
        //为JComboBox添加监听事件，当用户选择某个数据表时，触发该方法
        tableNames.addActionListener(e -> {

            try {
                //如果装载JTable的JScrollPane不为空
                if (scrollPane != null) {
                    //从主窗口中删除表格
                    jf.remove(scrollPane);
                }

                //从JComboBox中取出用户视图管理的数据表的表名
                String tableName = (String) tableNames.getSelectedItem();

                //如果结果集不为空，则关闭结果集
                if (rs != null) {
                    rs.close();
                }

                String query = "select * from " + tableName;
                //查询用户选择的数据表
                rs = stmt.executeQuery(query);
                //使用查询到的ResultSet创建TableModel对象
                model = new ResultSetTableModel(rs);

                //为TableModel添加监听器，监听用户的修改
                model.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        int row = e.getFirstRow();
                        int column = e.getColumn();
                        changeMsg.append("修改的列：" + column + ",修改的行：" + row + ",修改后的值：" + model.getValueAt(row, column)+".\n");
                    }
                });

                //使用TableModel创建JTable
                JTable table = new JTable(model);

                scrollPane = new JScrollPane(table);
                jf.add(scrollPane);
                jf.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });

        JPanel p = new JPanel();
        p.add(tableNames);
        jf.add(p, BorderLayout.NORTH);
        jf.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);


        //--------------数据库相关操作--------------------
        try {
            //获取数据库连接
            conn = getConn();
            //获取数据库的metaData对象
            DatabaseMetaData metaData = conn.getMetaData();


            //游标可以上下移动，可以使用结果集更新数据库中的表
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


            //查询数据库中的全部表
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});

            //将全部表添加到JCombox中
            while(tables.next()){
                tableNames.addItem(tables.getString(3));
            }
            tables.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //为JFrame添加窗口事件
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e1) {

                    }
                }
            }
        });

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new TableModelTest().init();
    }


    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }


    class ResultSetTableModel extends AbstractTableModel {


        private ResultSet rs;
        private ResultSetMetaData rsmd;

        //构造方法，初始化rs和rsmd两个属性
        public ResultSetTableModel(ResultSet aResultSet) {
            this.rs = aResultSet;
            try {
                rsmd = rs.getMetaData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //重写getColumnName方法，为表格设置列名
        @Override
        public String getColumnName(int column) {
            //column是表格列的标号，从0开始，而rsmd获取列时，标号从1开始，所以要column+1
            try {
                return rsmd.getColumnName(column + 1);
            } catch (SQLException e) {
                e.printStackTrace();
                return "";
            }
        }

        //重写getValueAt()方法，用于设置该表格指定单元格的值
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            try {
                //把游标移动到指定行,swing表格中行号从0开始，但是游标中行号从1开始，所以要修正
                rs.absolute(rowIndex+1);
                return rs.getObject(columnIndex + 1);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }

        //重写getRowCount()方法，用于设置该TableModel的行数
        @Override
        public int getRowCount() {
            try {
                rs.last();
                return rs.getRow();
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }

        }

        //重写getColumnCount()方法，用于设置表格的列数
        @Override
        public int getColumnCount() {
            try {
                return rsmd.getColumnCount();
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
        }

        //重写isEditable()方法，让每个单元格可编辑


        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        //重写setValueAt()方法，当用户编辑单元格时，会触发该方法


        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            try {
                //把游标定位到对应的行数
                rs.absolute(rowIndex+1);
                //修改对应单元格的值
                rs.updateObject(columnIndex + 1, aValue);
                //提交修改
                rs.updateRow();
                //触发单元格的修改事件
                fireTableCellUpdated(rowIndex, columnIndex);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
