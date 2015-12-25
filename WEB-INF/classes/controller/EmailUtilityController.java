package controller;

import com.Application.Application_Bean;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SendMail", urlPatterns = {"/SendMail"})
public class EmailUtilityController extends BaseController {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws AddressException
     * @throws MessagingException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            final String emailID = "Universityofmecklenburg@gmail.com";
            String admitStatus = (String) request.getParameter("admitStatus");
            String mailSubject = "";
            String mailBody = "";
            String applicantName =  "";
            String pgmName = "";
            String toMail = "";
            Application_Bean bean = (Application_Bean)request.getSession().getAttribute("bean");
            applicantName =  bean.getFirst_Name();
            pgmName = bean.getProgram();
            toMail = bean.getEmail();
            
            mailBody = "Hi " + applicantName + ",\n";
            if("admitted".equalsIgnoreCase(admitStatus))
            {
                mailSubject = "Congratulation" + applicantName + ", You have been admitted for the Mecklenburg University.";
                mailBody = mailBody + " Congratulations, You have been admitted for the Mecklenburg University for the program " + pgmName + ". Further instructions will be sent in another mail to you. Please dont miss to complete those steps mentioned in the instructions. \n";
                mailBody = mailBody + "Regards,\n Mecklenberg University";
            } else {
                mailSubject = "Sorry " + applicantName + ", You have not been admitted for the Mecklenburg University.";
                mailBody = mailBody + " Sorry to inform you that you application is not accepted and you are not admitted for the Mecklenburg University for the program " + pgmName + ".Please apply for the next term if you are planning so, it was tough to admit your application with the current status. \n";
                mailBody = mailBody + "Regards,\n Mecklenberg University";
            }
            
            Properties props = System.getProperties();

            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailID, "UMC@2015");
                }
            };

            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@umc.com", "NoReply-JD"));
            msg.setSubject(mailSubject, "UTF-8");
            msg.setText(mailBody, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));

            System.out.println("Message is ready");
            
            Transport.send(msg);
            
            pageForward("/FacultyHome.jsp", request, response);
        } catch (MessagingException me) {
            pageForward("/FacultyHome.jsp", request, response);
            Logger.getLogger(EmailUtilityController.class.getName()).log(Level.SEVERE, null, me);
        }

    }

}
