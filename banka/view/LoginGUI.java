package com.banka.view;

import javax.swing.*;
import com.banka.helper.helper;
import com.banka.helper.config;
import com.banka.model.users;
import com.banka.model.kullanıcı;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_tc;
    private JTextField fld_last_name;
    private JButton btn_login;
    private JButton btn_cıkıs;


    public LoginGUI(){
        add(wrapper);
        setSize(400,500);
        setLocation(helper.screenCenterLoc("x",getSize()),helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (helper.isFieldEmpty(fld_tc)||helper.isFieldEmpty(fld_last_name)){
                    helper.showMsg("fill");
                }else{
                    users u = users.entry((Integer.parseInt(fld_tc.getText())),fld_last_name.getText());
                    if (u == null){
                        helper.showMsg("Hatalı Tc veya Soyisim Giridiniz");
                    }else{
                    MainScreenGUI mainScreenGUI = new MainScreenGUI((kullanıcı) u);
                    dispose();
                    }
                }
            }
        });
        btn_cıkıs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }




    public static void main(String[] args){
        helper.setLayout();
        LoginGUI login = new LoginGUI();

    }

}
