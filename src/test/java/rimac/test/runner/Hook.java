package rimac.test.runner;

import io.cucumber.java.After;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import rimac.main.util.BaseDriver;
import rimac.test.util.Constantes;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class Hook extends BaseDriver {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @After
    public void tearDown() throws InvalidKeyException, NoSuchAlgorithmException {

        String v_environment = variables.getProperty("environment");
        System.out.println(v_environment);

        if (!v_environment.contains("local")) {
            TestOutcome outcome = StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome();
            System.out.println("SauceOnDemandSessionID="+appiumDriver().getSessionId().toString()+ " job-name="+outcome.getCompleteName());
            if(outcome.isSuccess()) {
                appiumDriver().executeScript("sauce:job-result=passed");
            }else {
                envioCorreo(outcome);
                appiumDriver().executeScript("sauce:job-result=failed");
            }
        }
    }

    public void envioCorreo(TestOutcome outcome) {
        String to = Constantes.correoDestino;
        String from = Constantes.correoRemitente;
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constantes.correoRemitente, Constantes.passCorreoRemitente);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject("Mensaje de Ejecución de prueba automatizada");

            MimeBodyPart textPart = new MimeBodyPart();
            String htmlText = "<html>"
                    + "<body>"
                    + "<h3 style='color:red' face='Trebuchet MS'>Envio de correo de prueba automatizada</h3>"
                    + "<br>"
                    + "<img src='cid:image'>"
                    + "<br>"
                    + "<br>"
                    + "<p>Se ha presentado un error en la ejecucion de la prueba de Saucelabs, en el flujo: </p>"
                    + "<br>" + "<ul>" + "<li><p><b>Nombre del Test: </b></p>" + outcome.getCompleteName()
                    + "<li><p><b>Hora de Ejecucion: </b></p>" + outcome.getEndTime()
                    + "<li><p><b>Step del Error: </b></p>" + outcome.getFailingStep().get().getDescription()
                    + "<li><p><b>Detalle del Error: </b></p>" + outcome.getFailingStep().get().getErrorMessage()
                    + "</ul>" + "<br>" + "<p><b>Saludos, </b></p>" + "<p>CoE de Automatizacion de Pruebas</p>"
                    + "</body>"
                    + "</html>";
            textPart.setContent(htmlText, "text/html");

            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID", "<image>");
            imagePart.setDisposition(MimeBodyPart.INLINE);
            imagePart.attachFile(new File("src/test/resources/documentos/saucelabs_logo.png"));

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(imagePart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo enviado satisfactoriamente....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
