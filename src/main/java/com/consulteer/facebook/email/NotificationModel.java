/*
package com.consulteer.facebook.email;

import com.consulteer.facebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Objects;

*/
/**
 * Created by Milos Stambolija on 16.9.2019.
 **//*

@Service
public class NotificationModel {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    public void sendNotification(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("digitals@consulteer.tk");
        simpleMailMessage.setText("This is another email testing");
        simpleMailMessage.setSubject("This is test email subject");

        javaMailSender.send(simpleMailMessage);
    }

    public void mimeMail(User user) throws MessagingException, IOException {

        FileSystemResource file = new FileSystemResource("C://Users//Milos Stambolija//Desktop//DigitalSignage-frontend//frontend//src//assets//television.png");

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(user.getEmail());
        messageHelper.setFrom("digitals@consulteer.tk");
        messageHelper.setSubject("subject");
        messageHelper.setText("Email content.");
        messageHelper.addAttachment(Objects.requireNonNull(file.getFilename()), file);

        javaMailSender.send(messageHelper.getMimeMessage());
    }

}
*/
