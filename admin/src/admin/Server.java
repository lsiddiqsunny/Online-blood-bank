/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;



import com.google.gdata.util.ServiceException;

import java.io.IOException;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

class ProgramThread extends Thread{

    private String name;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private readingdata d;
    private SendMailSSL mail;
  

    ProgramThread(Socket socket, int num) {
        this.socket = socket;
        name = "Programmer" + num;
        d = new readingdata();
        mail = new SendMailSSL();
       
       
    }
 @Override
    public void run() {
        try {
            System.out.println("here");
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                
                String request = (String) ois.readObject();
                System.out.println(request);
                //  oos.flush();
                String[] part = request.split(" ");
                if (part[0].equalsIgnoreCase("Searchuser")) {

                    oos.writeObject((String) search1(part[1]));
                }
                if (part[0].equalsIgnoreCase("searchdata")) {
                   
                    oos.writeObject((String) search2(part[1]));
                }
                if (part[0].equalsIgnoreCase("Searching")) {
                   
                    oos.writeObject((String) search3(part[1]));
                }
                if (part[0].equalsIgnoreCase("wantblood")) {

                    oos.writeObject((String) sendmail(part[1], 2));
                }
                 if (part[0].equalsIgnoreCase("update")) {
                     System.out.println("here");
                    oos.writeObject((String) update(part[1]));
                }
                if (part[0].equalsIgnoreCase("confirm")) {

                    oos.writeObject((String) sendmail(part[1], 1));
                }

            }

        } catch (Exception e) {
            System.out.println("Error1");
        }

        //CreateFolder();
    }

    private String sendmail(String user, int i) {
        String[] part = user.split("/");
        mail.emailsending(part[0], part[1], part[2], part[3], part[4], i);
        return "okay";
    }
     private String update(String user) throws WriteException, IOException, BiffException {
        String[] part = user.split("$");
        
        d.update(part);
        return "okay";
    }

    private String search1(String user) throws IOException, BiffException {
        return d.searching(user);
    }
    private String search3(String user) throws IOException, BiffException {
        return d.searching3(user);
    }

    private String search2(String user) throws ServiceException, IOException, BiffException {

        data s = d.search2(user);
        System.out.println(s.toString());
        return s.toString();

    }
}

public class Server implements Runnable {

    public static ObjectOutputStream os;
    public static ObjectInputStream is;

    public Server() {
        
    }

    @Override
    public void run() {
        try {
            ServerSocket serv = new ServerSocket(12345);

            Socket socket = null;
            int count = 0;
            while (true) {
                  
                socket = serv.accept();
                System.out.println("client connected");
                
                ProgramThread a = new ProgramThread(socket, count);
                a.start();
            }
        } catch (Exception e) {
        }
    }

}
