package com.banka.model;

public class kullanıcı extends users{

    public kullanıcı() {
    }

    public kullanıcı(int id, int tc, String first_name, String last_name, int money, int borc) {
        super(id, tc, first_name, last_name, money, borc);
    }

}
