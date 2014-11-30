package com.company;

/**
 * Created by Katrin on 30.11.2014.
 */
public class Contact {
    String name;
    String phone;
    String email;

    public Contact() {
    }

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }


    public void print() {
        System.out.println(name + " " + phone + " " + email);
    }

    public void init(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
