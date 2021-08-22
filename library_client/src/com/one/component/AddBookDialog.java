package com.one.component;

import com.one.domain.ResultInfo;
import com.one.listener.ActionDoneListener;
import com.one.net.FailListener;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.ScreenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;

    private ActionDoneListener listener;

    public AddBookDialog(JFrame jf, String title, boolean isModel, ActionDoneListener listener) {
        super(jf, title, isModel);
        this.listener = listener;
        //组装视图
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        Box vBox = Box.createVerticalBox();

        //组装图书名称
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("图书名称：");
        JTextField nameField = new JTextField(15);

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        //组装图书库存
        Box stockBox = Box.createHorizontalBox();
        JLabel stockLabel = new JLabel("图书库存：");
        JTextField stockField = new JTextField(15);

        stockBox.add(stockLabel);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //组装图书作者
        Box authorBox = Box.createHorizontalBox();
        JLabel authorLabel = new JLabel("图书作者：");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLabel);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //组装图书价格
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLabel = new JLabel("图书价格：");
        JTextField priceField = new JTextField(15);

        priceBox.add(priceLabel);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);

        //组装图书简介
        Box descBox = Box.createHorizontalBox();
        JLabel descLabel = new JLabel("图书简介：");
        JTextArea descArea = new JTextArea(3,15);

        descBox.add(descLabel);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(descArea);

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户录入
                String name = nameField.getText().trim();
                String stock = stockField.getText().trim();
                String author = authorField.getText().trim();
                String price = priceField.getText().trim();
                String desc = descArea.getText().trim();

                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("description",desc);
                params.put("author",author);
                params.put("price",price);
                params.put("stock",stock);

                //访问后台接口
                PostUtils.postWithParams("http://localhost:8080/book/addBook", params, new SuccessListener() {
                    @Override
                    public void success(String result) {
                        ResultInfo info = JsonUtils.parseResult(result);
                        if (info.isFlag()){
                            //添加成功
                            JOptionPane.showMessageDialog(jf,"添加成功");
                            dispose();
                            listener.done(null);
                        }else {
                            JOptionPane.showMessageDialog(jf,info.getMessage());
                        }
                    }
                }, new FailListener() {
                    @Override
                    public void fail() {
                        JOptionPane.showMessageDialog(jf,"网络异常，请稍后重试");
                    }
                });
            }
        });


        btnBox.add(addBtn);

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(stockBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

        //为了左右有间距，在vBox外层封装一个水平的Box，添加间隔
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));

        this.add(hBox);
    }

}
