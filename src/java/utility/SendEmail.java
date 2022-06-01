/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author pv
 */
public class SendEmail {
    public void send(String toEmail, String content, String subject){
        String fromEmail = "fcourse4@gmail.com";
        String password = "123456789a@";
        // Config
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        // Mail info       
        try {
            //set email message details
            Message mess = new MimeMessage(session);
            //set from email address
            mess.setFrom(new InternetAddress(fromEmail));
            //set to email address or destination email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //set email subject
            mess.setSubject(subject);
            //set message text
            mess.setContent(content, "text/html; charset=UTF-8");
            //send the message
            Transport.send(mess);
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    public static void main(String[] args) {
        new SendEmail().send("tuanthanhnghean123@gmail.com", "Test2", "123456777");
    }
}
