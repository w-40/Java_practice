package Swing学习.绘图;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndSaveImage {

    private Frame frame = new Frame("图片查看器");

    private BufferedImage image;

    private class MyCanvas  extends Canvas{

        @Override
        public void paint(Graphics g) {
            if (image!=null){
                g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
            }
        }
    }

    private MyCanvas imageComponent = new MyCanvas();

    public void init() throws Exception{

        //设置菜单项
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("文件");
        MenuItem openItem = new MenuItem("打开");
        MenuItem saveItem = new MenuItem("另存为");

        openItem.addActionListener(e -> {
            //弹出对话框，选择本地图片
            FileDialog oDialog = new FileDialog(frame);
            oDialog.setVisible(true);
            //读取用户选择的图片
            String dir = oDialog.getDirectory();
            String file = oDialog.getFile();
            try {
                image = ImageIO.read(new File(dir,file));

                imageComponent.repaint();

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });


        saveItem.addActionListener(e -> {
            //弹出对话框，另存为
            FileDialog sDialog = new FileDialog(frame,"保存图片",FileDialog.SAVE);
            sDialog.setVisible(true);
            String dir = sDialog.getDirectory();
            String file = sDialog.getFile();

            try {
                ImageIO.write(image,"JPEG",new File(dir,file));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        mb.add(menu);
        menu.add(openItem);
        menu.add(saveItem);

        frame.setMenuBar(mb);
        frame.add(imageComponent);

        frame.setBounds(200,200,800,600);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }



    public static void main(String[] args) throws Exception {
        new ReadAndSaveImage().init();
    }
}
