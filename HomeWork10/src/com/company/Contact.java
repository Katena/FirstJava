package com.company;

/**
 * Created by Katrin on 30.11.2014.
 */
public class Contact implements Comparable{
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

    @Override
    public boolean equals(Object o)
    {
        Contact c = (Contact) o;
        if (this.name.equals(c.name) && this.phone.equals(c.phone) && this.email.equals(c.email)){return true;}
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Contact c = (Contact) o;
        char[] thisSymb = this.name.toCharArray();
        char[] cSymb = c.name.toCharArray();
        int length = thisSymb.length < cSymb.length ? thisSymb.length : cSymb.length;
        for (int i = 0; i < length; i++) {


            if (thisSymb[i] < cSymb[i]) {
                return -1;
            } else if (thisSymb[i] > cSymb[i]) {
                return 1;
            }
        }
        if (thisSymb.length == cSymb.length) return 0;
        else if (thisSymb.length <cSymb.length) return -1;
        else return 1;
    }
}
