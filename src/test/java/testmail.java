import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class testmail {
    public static void main(String[] args)
    {
        // change below lines accordingly
        String to = "got@gmail.com";
        String from = "akash@gmail.com";
        String host = "localhost"; // or IP address

        // Get the session object
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object
        Session session = Session.getDefaultInstance(properties);

        // compose the message
        try {

            // javax.mail.internet.MimeMessage class
            // is mostly used for abstraction.
            MimeMessage message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("subject");
            message.setText("Hello, aas is sending email ");

            // Send message
            Transport.send(message);
            System.out.println("Yo it has been sent..");
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
