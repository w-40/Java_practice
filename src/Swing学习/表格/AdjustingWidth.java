package Swing学习.表格;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class AdjustingWidth {

    JFrame jf = new JFrame("调整表格宽度");

    JMenuBar menuBar = new JMenuBar();

    JMenu adjustModeMenu = new JMenu("调整方式");
    JMenu selectUnitMenu = new JMenu("选择单元");
    JMenu selectModeMenu = new JMenu("选择方式");

    //定义5个单选框按钮，用以控制表格的宽度调整方式
    JRadioButtonMenuItem[] adjustModeItem = new JRadioButtonMenuItem[5];

    //定义3个单选框按钮，用以控制表格的选择方式
    JRadioButtonMenuItem[] selectModeItem = new JRadioButtonMenuItem[3];

    //定义复选菜单项，控制选择单元
    JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("选择行");
    JCheckBoxMenuItem columnItem = new JCheckBoxMenuItem("选择列");
    JCheckBoxMenuItem cellItem = new JCheckBoxMenuItem("选择单元格");

    //定义按钮组，实现单选
    ButtonGroup adjustBg = new ButtonGroup();
    ButtonGroup selectBg = new ButtonGroup();

    //定义一个int类型的数组，用于保存表格所有的宽度调整方式

    int[] adjustModes = {
            JTable.AUTO_RESIZE_OFF,
            JTable.AUTO_RESIZE_NEXT_COLUMN,
            JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS,
            JTable.AUTO_RESIZE_LAST_COLUMN,
            JTable.AUTO_RESIZE_ALL_COLUMNS
    };


    //定义一个int乐行数组，用于保存表格所有的选择方式
    int[] selectModes = {
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION,
            ListSelectionModel.SINGLE_INTERVAL_SELECTION,
            ListSelectionModel.SINGLE_SELECTION
    };

    //声明JTable
    JTable table;

    //定义一个二维数组，作为表格行数据
    Object[][] tableData = {

            new Object[]{"李清照",29,"女"},
            new Object[]{"苏格拉底",56,"男"},
            new Object[]{"李白",35,"男"},
            new Object[]{"弄玉",18,"女"},
            new Object[]{"虎头",2,"男"},

    };

    //定义一个一维数组，作为列标题
    Object[] columnTitle = {"姓名","年龄","性别"};


    public void init(){

        //创建JTable对象
        table  = new JTable(tableData,columnTitle);


        //-----------------为窗口安装设置表格调整方式的菜单--------------------
        adjustModeItem[0] = new JRadioButtonMenuItem("只调整表格");
        adjustModeItem[1] = new JRadioButtonMenuItem("只调整下一列");
        adjustModeItem[2] = new JRadioButtonMenuItem("平均调整余下列");
        adjustModeItem[3] = new JRadioButtonMenuItem("只调整最后一列");
        adjustModeItem[4] = new JRadioButtonMenuItem("平均调整所有列");

        menuBar.add(adjustModeMenu);

        for (int i = 0; i < adjustModeItem.length; i++) {
            //默认选中第三个菜单项，即对应表格默认的宽度调整方式
            if (i==2){
                adjustModeItem[i].setSelected(true);
            }
            adjustBg.add(adjustModeItem[i]);
            adjustModeMenu.add(adjustModeItem[i]);

            //为菜单项设置事件监听器
            int index = i;
            adjustModeItem[i].addActionListener(e -> {
                if (adjustModeItem[index].isSelected()){
                    table.setAutoResizeMode(adjustModes[index]);
                }
            });
        }

        //---------------为窗口安装设置表格选择方式的菜单-------------------
        selectModeItem[0] = new JRadioButtonMenuItem("无限制");
        selectModeItem[1] = new JRadioButtonMenuItem("单独的连续区");
        selectModeItem[2] = new JRadioButtonMenuItem("单选");

        menuBar.add(selectModeMenu);

        for (int i = 0; i < selectModeItem.length; i++) {

            //默认选中第一个菜单项，即表格的默认选择方式
            if (i==0){
                selectModeItem[i].setSelected(true);
            }

            selectBg.add(selectModeItem[i]);
            selectModeMenu.add(selectModeItem[i]);


            int index = i;

            selectModeItem[i].addActionListener(e -> {

                if (selectModeItem[index].isSelected()){
                    table.getSelectionModel().setSelectionMode(selectModes[index]);
                }

            });

        }

        //---------------为窗口添加选择单元菜单----------------------
        menuBar.add(selectUnitMenu);
        rowsItem.setSelected(table.getRowSelectionAllowed());
        columnItem.setSelected(table.getColumnSelectionAllowed());
        cellItem.setSelected(table.getCellSelectionEnabled());

        rowsItem.addActionListener(e -> {
            //清除表格的选中状态
            table.clearSelection();
            //如果该菜单项处于选中状态，设置表格的选择单元是行
            table.setRowSelectionAllowed(rowsItem.isSelected());
            //如果选择行、选择列同时被选中，其实质是选择单元格
            table.setCellSelectionEnabled(table.getCellSelectionEnabled());

        });

        selectUnitMenu.add(rowsItem);

        columnItem.addActionListener(e -> {
            //清除表格的选中状态
            table.clearSelection();

            //如果该菜单项处于选中状态，设置表格的选择单元是列
            table.setColumnSelectionAllowed(columnItem.isSelected());
            ///如果选择行、选择列同时被选中，其实质是选择单元格
            table.setCellSelectionEnabled(table.getCellSelectionEnabled());
        });

        selectUnitMenu.add(columnItem);

        cellItem.addActionListener(e -> {
            //清除表格的选中状态
            table.clearSelection();

            //如果该菜单项处于选中状态，设置表格的选择单元是单元格
            table.setCellSelectionEnabled(cellItem.isSelected());
            ///该选项的改变会同时影响选择行、选择列两个菜单
            table.setRowSelectionAllowed(table.getRowSelectionAllowed());
            table.setColumnSelectionAllowed(table.getColumnSelectionAllowed());

        });

        selectUnitMenu.add(cellItem);

        jf.setJMenuBar(menuBar);

        //分别获取表格的三个表格列，并设置三列的最小宽、最佳宽度和最大宽度
        TableColumn nameColumn = table.getColumn(columnTitle[0]);
        nameColumn.setMinWidth(40);
        TableColumn ageColumn = table.getColumn(columnTitle[1]);
        ageColumn.setPreferredWidth(50);
        TableColumn genderColumn = table.getColumn(columnTitle[2]);
        genderColumn.setMaxWidth(50);

        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new AdjustingWidth().init();
    }

}
