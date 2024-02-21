package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        //Identificador del contenido incrustado
        String cid = UUID.randomUUID().toString();
        //Mensaje en formato HTML
        String htmlMessage = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Mini Lesson</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>Hello everyone!</p>\n" +
                "    <p>Today, we have another mini lesson about suffixes that talk about people. As you may know, 'suffixes' are little groups of letters that we put on the end of other words.</p>\n" +
                "\n"+"<img src=\"cid:"+cid+"\"/>"     +
                "    <h2>Professionals</h2>\n" +
                "    <p>We can use the suffix '-er' to talk about a person who does something.</p>\n" +
                "    <ul>\n" +
                "        <li>teach - teacher</li>\n" +
                "        <li>learn - learner</li>\n" +
                "        <li>work - worker</li>\n" +
                "        <li>bank - banker</li>\n" +
                "        <li>dance - dancer</li>\n" +
                "    </ul>\n" +
                "    <p>We can also use '-ist' with the same meaning.</p>\n" +
                "    <ul>\n" +
                "        <li>cycle - cyclist</li>\n" +
                "        <li>psychology - psychologist</li>\n" +
                "        <li>piano - pianist</li>\n" +
                "        <li>guitar - guitarist</li>\n" +
                "        <li>art - artist</li>\n" +
                "    </ul>\n" +
                "    <p>Unfortunately, there's no easy way to know which ending to use with each word. We just need to learn the forms.</p>\n" +
                "\n" +
                "    <p>I hope that helps, and really good luck with your English!</p>\n" +
                "    <p>Edwin</p>\n" +
                "</body>\n" +
                "</html>\n";

        //Receptor del correo
        String reciever= "parrofer16@gmail.com";

        //Ruta del archivo adjunto
        String attachmentPath= "src/main/resources/professionals.jpg";


        try (InputStream input = new FileInputStream("src/main/resources/smtp.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("elplatanoeslomejor@hotmail.com", "Platanoplatano1");
                }
            };
            Session session = Session.getDefaultInstance(prop, auth);

            try{
                Message message= new MimeMessage(session);

                message.setFrom(new InternetAddress("elplatanoeslomejor@hotmail.com"));

                message.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));

                message.setSubject("Hello everyone!");

                // Mensaje HTML con imagen incrustada
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(htmlMessage, "text/html");

                // Crear una parte de datos adjuntos para el archivo
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.attachFile(attachmentPath); // Adjuntar el archivo
                imagePart.setContentID("<"+cid+">"); // Establecer el ID de contenido incrustado
                imagePart.setDisposition(MimeBodyPart.INLINE); // Establecer la disposición en línea

                // Componer el contenido multipart
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart); // Agregar el cuerpo del mensaje
                multipart.addBodyPart(imagePart); // Agregar el archivo adjunto

                // Establecer el contenido del mensaje
                message.setContent(multipart);

                // Enviar el mensaje
                Transport.send(message);
                System.out.println("Correo enviado a: "+reciever);
            } catch (MessagingException e) {
                System.err.println("Error al enviar el correo "+e.getMessage());
            }


        } catch (IOException ex) {
            System.err.println("Error en el programa: "+ ex.getMessage());
        }
    }
}