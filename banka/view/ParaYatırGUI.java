package com.banka.view;
import com.banka.helper.config;
import com.banka.helper.helper;
import com.banka.model.kullanıcı;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.banka.model.users.yatırılanPara;

public class ParaYatırGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_money;
    private JButton btn_yatır;
    private JButton ÇIKIŞButton;
    private kullanıcı kullanıcı;

    public ParaYatırGUI(kullanıcı kullanıcı){
        this.kullanıcı = kullanıcı;
        add(wrapper);
        setSize(400,280);
        setLocation(helper.screenCenterLoc("x",getSize()),helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);



        btn_yatır.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (helper.isFieldEmpty(txt_money)) {
                    helper.showMsg("fill");

                } else {
                    helper.confirm("sure");
                    int yatırılan_para =Integer.parseInt(txt_money.getText());
                    yatırılanPara(yatırılan_para);
                    MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);
                    dispose();
                }


            }
        });
        ÇIKIŞButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);
                dispose();
            }
        });
    }







}
