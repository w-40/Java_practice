package Swing学习.列表框;


import javax.swing.*;
import java.awt.*;

public class ListCellRendererTest {

    private JFrame mainWin = new JFrame("好友列表");

    private String[] friends = {
            "李清照",
            "苏格拉底",
            "李白",
            "弄玉",
            "虎头"
    };

    //定义一个JList对象
    JList friendsList = new JList(friends);

    public void init() {
        //设置JList使用ImageCellRenderer作为列表项绘制器
        friendsList.setCellRenderer(new ImageCellRenderer());

        mainWin.add(new JScrollPane(friendsList));
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }


    public static void main(String[] args) {
        new ListCellRendererTest().init();
    }

    class ImageCellRenderer extends JPanel implements ListCellRenderer {


        private ImageIcon icon;
        private String name;
        //定义绘制单元格的背景色
        private Color background;
        //定义绘制单元格的前景色
        private Color foreground;


        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

           // icon = new ImageIcon(ImagePathUtil.getRealPath("9\\" + value + ".gif"));
            name = value.toString();
            background = isSelected ? list.getSelectionBackground() : list.getBackground();
            foreground = isSelected ? list.getSelectionForeground() : list.getForeground();

            //返回当前JPanel对象，作为列表项绘制器
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            int width = icon.getImage().getWidth(null);
            int height = icon.getImage().getHeight(null);

            //填充背景矩形
            g.setColor(background);
            g.fillRect(0,0,getWidth(),getHeight());

            g.setColor(foreground);
            //绘制好友头像
            g.drawImage(icon.getImage(),getWidth()/2-width/2,10,null);

            //绘制好友昵称
            g.setFont(new Font("SansSerif",Font.BOLD,18));
            g.drawString(name,getWidth()/2-name.length()*10,height+30);
        }


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60,80);
        }
    }
}
