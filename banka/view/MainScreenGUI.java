package com.banka.view;
import com.banka.helper.config;
import com.banka.helper.helper;
import com.banka.model.kullanıcı;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.banka.view.LoginGUI;

public class MainScreenGUI extends JFrame{
    private JPanel wrapper;
    private JButton btn_para_yatır;
    private JButton btn_cıkıs;
    private JButton btn_para_cek;
    private JButton btn_borc_ode;
    private JLabel fld_bakiye;
    private JLabel fld_welcome;
    private JLabel fld_borc;
    private kullanıcı kullanıcı;


    public MainScreenGUI(kullanıcı kullanıcı){
        this.kullanıcı = kullanıcı;
        add(wrapper);
        setSize(400,280);
        setLocation(helper.screenCenterLoc("x",getSize()),helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        fld_welcome.setText("Hoşgeldin "+kullanıcı.getFirst_name());
        fld_bakiye.setText("Bakineyiz: $"+ kullanıcı.getMoney());
        fld_borc.setText("Borcunuz: $"+ kullanıcı.getBorc());


        btn_para_yatır.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ParaYatırGUI paraYatırGUI = new ParaYatırGUI(kullanıcı);
            dispose();
            }
        });

        btn_cıkıs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI = new LoginGUI();
                dispose();
            }
        });
        btn_para_cek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParaCekGUI paraCekGUI = new ParaCekGUI(kullanıcı);
                dispose();
            }
        });
        btn_borc_ode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BorcOdeGUI borcOdeGUI = new BorcOdeGUI(kullanıcı);
            }
        });
    }


}
