package util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil 
{

    private static final String SMTP_HOST = "mail.smtp2go.com";
    private static final String SMTP_PORT = "2525";
    private static final String USERNAME = "bumbu";
    private static final String PASSWORD = "exgCR9gMn";
 // provide sender's email ID
 	private static String from = "beyazsap@yandex.com.tr";

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Authenticator authenticator = new Authenticator()
        {            
            protected PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };
        
        Session session = Session.getInstance(props, authenticator);

        try 
        {
        		Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

           Transport.send(message);
           System.out.println("email successfully sent");
            
		} catch (MessagingException e) {throw new RuntimeException(e);	}
    }
}
