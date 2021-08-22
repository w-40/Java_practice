package com.one.ui;

import com.one.component.BackGroundPanel;
import com.one.domain.ResultInfo;
import com.one.net.FailListener;
import com.one.net.ImageRequestUtils;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegisterInterface {
    JFrame jf = new JFrame("注册");

    final int WIDTH = 500;
    final int HEIGHT = 400;

    //组装视图
    public void init() throws IOException {
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));
        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("regist.jpg"))));
        bgPanel.setBounds(0, 0, WIDTH, HEIGHT);

        Box vBox = Box.createVerticalBox();

        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("用户名：");
        JTextField uField = new JTextField(15);

        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        //组装密码
        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("密    码：");
        JTextField pField = new JTextField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pField);

        //组装手机号
        Box tBox = Box.createHorizontalBox();
        JLabel tLabel = new JLabel("手机号：");
        JTextField tField = new JTextField(15);

        tBox.add(tLabel);
        tBox.add(Box.createHorizontalStrut(20));
        tBox.add(tField);

        //组装性别
        Box gBox = Box.createHorizontalBox();
        JLabel gLabel = new JLabel("性    别：");
        JRadioButton maleBtn = new JRadioButton("男", true);
        JRadioButton femaleBtn = new JRadioButton("女", false);

        //实现单选的效果
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleBtn);
        bg.add(femaleBtn);

        gBox.add(gLabel);
        gBox.add(Box.createHorizontalStrut(20));
        gBox.add(maleBtn);
        gBox.add(femaleBtn);
        gBox.add(Box.createHorizontalStrut(120));

        //组装验证码
        Box cBox = Box.createHorizontalBox();
        JLabel cLabel = new JLabel("验证码：");
        JTextField cField = new JTextField(4);
        JLabel cImg = new JLabel(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
        //给某个组件设置提示信息
        cImg.setToolTipText("点击刷新");
        cImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cImg.setIcon(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
                cImg.updateUI();
            }
        });

        cBox.add(cLabel);
        cBox.add(Box.createHorizontalStrut(20));
        cBox.add(cField);
        cBox.add(cImg);

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton registBtn = new JButton("注册");
        JButton backBtn = new JButton("返回登录界面");

        registBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的信息
                String username = uField.getText().trim();
                String password = pField.getText().trim();
                String phone =  tField.getText().trim();
                String gender = bg.isSelected(maleBtn.getModel())? maleBtn.getText():femaleBtn.getText();
                String checkCode = cField.getText().trim();

                Map<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                params.put("phone",phone);
                params.put("gender",gender);
                params.put("checkCode",checkCode);
                //访问后台接口
                PostUtils.postWithParams("http://47.105.41.58:8080/book_system/user/register", params, new SuccessListener() {
                    @Override
                    public void success(String result) {
                        ResultInfo info = JsonUtils.parseResult(result);
                        if (info.isFlag()){
                            //注册成功
                            JOptionPane.showMessageDialog(jf,"注册成功，即将返回登录页面");
                            try {
                                new MainInterface().init();
                                jf.dispose();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            //注册失败
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

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回到登录页面即可
                try {
                    new MainInterface().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnBox.add(registBtn);
        btnBox.add(Box.createHorizontalStrut(80));
        btnBox.add(backBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(tBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(gBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(cBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnBox);

        bgPanel.add(vBox);

        jf.add(bgPanel);

        jf.setVisible(true);
    }
    public static void main(String[] args){
        try {
            new RegisterInterface().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}