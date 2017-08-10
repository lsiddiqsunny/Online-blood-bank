/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
    SendMailSSL(){
        
    }
   void emailsending(String To,String Name,String hospital,String group,String number,int i) {
     
      String to = To;

   
      String from = "onlinebloodb@gmail.com";
      final String username = "onlinebloodb";
      final String password = "bloodbank12345";


      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
      
         Message message = new MimeMessage(session);

   
         message.setFrom(new InternetAddress(from));

    
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

         if(i==2){
         message.setSubject("Asking For Blood");

         message.setText("You're " + Name+ ",asking for blood group "+group+"."+"\n"+"Hope you will get your desired Blood.");
         }
         else if(i==1){
             
         message.setSubject("Data submitted");

         message.setText("You're " + Name+ ",submitted data for donating blood."+group+"."+"\n"+"Your information has been accepted"+"\n"+"Thank you.");
         }
           else if(i==3){
             
         message.setSubject("Can you donate blood?");

       
         message.setText("Can you donate blood at "+hospital+"."+"\n"+"Please contact with "+Name+"."+"\n"+"Phone number: "+number+"\n"+"Thank you.");
         }
       
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }

   
  
}