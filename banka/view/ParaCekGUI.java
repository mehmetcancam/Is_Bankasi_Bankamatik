package com.banka.view;
import com.banka.helper.config;
import com.banka.helper.helper;
import com.banka.model.kullanıcı;
import com.banka.model.users;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.banka.model.users.cekilenPara;

public class ParaCekGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txt_money;
    private JButton btn_çek;
    private JButton ÇIKIŞButton;
    private kullanıcı kullanıcı;

    public ParaCekGUI(kullanıcı kullanıcı){
        this.kullanıcı = kullanıcı;
        add(wrapper);
        setSize(400,280);
        setLocation(helper.screenCenterLoc("x",getSize()),helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        ÇIKIŞButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);
            }
        });


        btn_çek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (helper.isFieldEmpty(txt_money)){
                    helper.showMsg("fill");
                }else {
                    helper.confirm("sure");
                    int cekilen_para = Integer.parseInt(txt_money.getText());
                    cekilenPara(cekilen_para);
                    MainScreenGUI mainScreenGUI = new MainScreenGUI(kullanıcı);
                    dispose();


                }
            }
        });
    }
}
