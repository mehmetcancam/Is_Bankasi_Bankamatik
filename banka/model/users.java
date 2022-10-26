package com.banka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.banka.helper.DBConnetcor;

public class users {

    users(){};
    private int id;
    private int tc;
    private String first_name;
    private String last_name;

    private int money;
    private int borc;

    public users(int id, int tc, String first_name, String last_name , int money, int borc) {
        this.id = id;
        this.tc = tc;
        this.first_name = first_name;
        this.last_name = last_name;
        this.money = money;
        this.borc = borc;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBorc() {
        return borc;
    }

    public void setBorc(int borc) {
        this.borc = borc;
    }

    static ArrayList<users> user = new ArrayList<>();



    public static users entry(int Tc, String last_name){
        users obj = null;
        String sql = "SELECT * FROM bank_data WHERE tc ="+Tc+" AND last_name ='"+last_name+"';";

        try {
            Statement st = DBConnetcor.getInstance().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                obj = new kullanıcı();
                obj.setId(rs.getInt("id"));
                obj.setTc(rs.getInt("tc"));
                obj.setFirst_name(rs.getString("first_name"));
                obj.setLast_name(rs.getString("last_name"));
                obj.setMoney(rs.getInt("money"));
                obj.setBorc(rs.getInt("borc"));
                user.add(obj);
            }else {

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }



    public static boolean yatırılanPara(int money){
        int toplam =user.get(0).getMoney()+money;
        String money1 =String.valueOf(toplam);
        user.get(0).setMoney(toplam);
        String sql = "UPDATE bank_data SET money ='$"+money1+ "' WHERE first_name='"+user.get(0).first_name+
                "' AND last_name='"+user.get(0).last_name+"'";
        try {
            Statement st = DBConnetcor.getInstance().createStatement();
            int rs = st.executeUpdate(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }


    public static boolean cekilenPara(int money){
        int kalan = user.get(0).getMoney()-money;
        String money1 = String.valueOf(kalan);
        user.get(0).setMoney(Integer.parseInt(money1));
        String sql = "UPDATE bank_data SET money ='$"+money1+ "' WHERE first_name='"+user.get(0).first_name+
                "' AND last_name='"+user.get(0).last_name+"'";

        try {
            Statement st = DBConnetcor.getInstance().createStatement();
            int rs = st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean ödenenBorc(int money){
        int kalan = user.get(0).getBorc()-money;
        String money1 = String.valueOf(kalan);
        user.get(0).setBorc(Integer.parseInt(money1));
        String sql = "UPDATE bank_data SET borc ='$"+money1+ "' WHERE first_name='"+user.get(0).first_name+
                "' AND last_name='"+user.get(0).last_name+"'";

        try {
            Statement st = DBConnetcor.getInstance().createStatement();
            int rs = st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

}
