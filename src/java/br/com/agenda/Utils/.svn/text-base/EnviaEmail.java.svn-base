package br.com.agenda.Utils;

import br.com.agenda.Constants.Constants;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail implements Runnable {

    private String remetente = "";
    private String destinatario = "";
    private String assunto = "";
    private String msg = "";

    /**
     * 
     * @param assunto
     * @param msg
     */
    public EnviaEmail(String assunto, String msg) {
        this.assunto = assunto;
        this.msg = msg;
    }

    @Override
    public void run() {
        if ("".equalsIgnoreCase(getRemetente()) && "".equalsIgnoreCase(getDestinatario())) {
            try {
                Properties props = new Properties();
                props.put("mail.smtp.host", Constants.SMTP);
                props.put("mail.smtp.socketFactory.port", Constants.PORT);
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", Constants.AUTH);
                props.put("mail.smtp.port", Constants.PORT);
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constants.EMAIL, Constants.SENHA);
                    }
                });
                session.setDebug(false);
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(Constants.EMAIL_REMETENTE));
                Address[] toUser = InternetAddress.parse(Constants.EMAIL_DESTINATARIO);
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject(assunto);
                message.setContent(msg, "text/html");
                Transport.send(message);
            } catch (Exception e) {
                System.out.println("Erro ao enviar email! \n\n" + e);
            }
        } else {
            try {
                Properties props = new Properties();
                props.put("mail.smtp.host", Constants.SMTP);
                props.put("mail.smtp.socketFactory.port", Constants.PORT);
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", Constants.AUTH);
                props.put("mail.smtp.port", Constants.PORT);
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constants.EMAIL, Constants.SENHA);
                    }
                });
                session.setDebug(false);
                Message message = new MimeMessage(session);
                if (this.destinatario.indexOf(";") > 0) {
                    String dest = "";
                    String[] aux = this.destinatario.split(";");
                    for (int i = 0; i < aux.length; i++) {
                        dest = aux[i];
                        message.setFrom(new InternetAddress(this.remetente));
                        Address[] toUser = InternetAddress.parse(dest);
                        message.setRecipients(Message.RecipientType.TO, toUser);
                        message.setSubject(this.assunto);
                        message.setContent(this.msg, "text/html");
                        Transport.send(message);
                    }
                } else {
                    message.setFrom(new InternetAddress(this.remetente));
                    Address[] toUser = InternetAddress.parse(this.destinatario);
                    message.setRecipients(Message.RecipientType.TO, toUser);
                    message.setSubject(this.assunto);
                    message.setContent(this.msg, "text/html");
                    Transport.send(message);
                }
            } catch (Exception e) {
                System.out.println("Erro ao enviar email! \n\n" + e);
            }
        }
    }

    /**
     * @return the remetente
     */
    public String getRemetente() {
        return remetente;
    }

    /**
     * @param remetente the remetente to set
     */
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
