package com.one.component;

import com.one.domain.ResultInfo;
import com.one.listener.ActionDoneListener;
import com.one.net.FailListener;
import com.one.net.GetUtils;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.ScreenUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class UpdateBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    private String id;
    private ActionDoneListener listener;
    private Map<String,Object> map;

    private JTextField nameField;
    private JTextField stockField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea descArea;


    public UpdateBookDialog(JFrame jf, String title, boolean isModel,ActionDoneListener listener, String id) {
        super(jf, title, isModel);
        this.listener = listener;
        this.id = id;
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
        stockField = new JTextField(15);

        stockBox.add(stockLabel);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //组装图书作者
        Box authorBox = Box.createHorizontalBox();
        JLabel authorLabel = new JLabel("图书作者：");
        authorField = new JTextField(15);

        authorBox.add(authorLabel);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //组装图书价格
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLabel = new JLabel("图书价格：");
        priceField = new JTextField(15);

        priceBox.add(priceLabel);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);

        //组装图书简介
        Box descBox = Box.createHorizontalBox();
        JLabel descLabel = new JLabel("图书简介：");
        descArea = new JTextArea(3,15);

        descBox.add(descLabel);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(new JScrollPane(descArea));

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton updateBtn = new JButton("修改");

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户修改后在输入框中输入的内容
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
                params.put("id",map.get("id").toString());
                //访问后台接口
                PostUtils.postWithParams("http://localhost:8080/book/updateBook", params, new SuccessListener() {
                    @Override
                    public void success(String result) {
                        ResultInfo info = JsonUtils.parseResult(result);
                        if (info.isFlag()){
                            //修改成功
                            JOptionPane.showMessageDialog(jf,"修改成功");
                            dispose();
                            listener.done(null);
                        }else{
                            //修改失败
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

        //TODO 处理修改的行为



        btnBox.add(updateBtn);

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
        //回显数据
        requestData();
    }
    //请求数据
    public void requestData(){
        GetUtils.get("http://localhost:8080/book/findBookById?id=" + id, new SuccessListener() {
            @Override
            public void success(String result) {
                ResultInfo info = JsonUtils.parseResult(result);
                map = (Map<String, Object>) info.getData();
                nameField.setText(map.get("name").toString());
                stockField.setText(map.get("stock").toString());
                authorField.setText(map.get("author").toString());
                priceField.setText(map.get("price").toString());
                descArea.setText(map.get("description").toString());
            }
        }, new FailListener() {
            @Override
            public void fail() {

            }
        });
    }

}
