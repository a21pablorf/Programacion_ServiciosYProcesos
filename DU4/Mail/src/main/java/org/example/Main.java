package org.example;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String sender = "pabloromerofdez@gmail.com";
        String receiver="a21pablorf@iessanclemente.net";
        Properties properties = new Properties();
        properties.put("mail.smtp.host","aspmx.l.google.com");
        properties.put("mail.smtp.port", "25");
        Session session=Session.getDefaultInstance(properties);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new
                    InternetAddress(receiver));
            message.setSubject("Hola buenos dias");
            message.setText("me estoy haciendo pasar por un hacker, no me denuncies por favor.");
            Transport.send(message);
            System.out.println("Email sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending mail.");
        }

    }
}