/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;


import java.io.File;
import java.util.Vector;


public class data {

    String name, email, phone, address, bgroup,age,date,fp;

    data(String a, String b, String c, String d, String e,String ag,String date) {
        this.name = a;
        this.email = b;
        this.phone = c;
        this.address = d;
        this.bgroup = e;
        this.age = ag;
        this.date = date;

    }

    data() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   

    public String getblood() {
        return bgroup;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String address() {
        return address;
    }

    public String phone() {
        return phone;
    }
public String age() {
        return age;
    }

    public String date() {
        return date;
    }
   

    @Override
    public String toString() {
        return name + " " + email + " " + "0" + phone + " " + address + " " + bgroup+" "+date+" "+age;
    }
}
