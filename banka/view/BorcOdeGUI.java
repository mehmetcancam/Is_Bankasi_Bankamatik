package com.banka.view;

import com.banka.helper.config;
import com.banka.helper.helper;
import com.banka.model.kullanıcı;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.banka.model.users.ödenenBorc;

public class BorcOdeGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_money;
    private JButton btn_öde;
    private JButton ÇIKIŞButton;
    private JLabel txt_borc;
    private kullanıcı kullanıcı;

    public BorcOdeGUI(kullanıcı kullanıcı){
        this.kullanıcı = kullanıcı;
        add(wrapper);
        setSize(400,280);
        setLocation(helper.screenCenterLoc("x",getSize()),helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        txt_borc.setText("Borcunuz: $"+ kullanıcı.getBorc());

        btn_öde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (helper.isFieldEmpty(txt_money)){
                    helper.showMsg("fill");
                }else {
                    helper.confirm("sure");
                    int odenenBorc = Integer.parseInt(txt_money.getText());
                    ödenenBorc(odenenBorc);
                    dispose();
                    MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);

                }
            }
        });
        ÇIKIŞButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);
            }
        });
    }


}
