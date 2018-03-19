package ca.sheridancollege.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void sendEmailTo(String to, String messageToBeSend) {    
      // Recipient's email ID needs to be mentioned.
      //String to = "inderpreetsingh294@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "javamailij@gmail.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication()
                  {
                      return new PasswordAuthentication("javamailij@gmail.com","javajava");
                  }
}
              
              );

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText(messageToBeSend);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}