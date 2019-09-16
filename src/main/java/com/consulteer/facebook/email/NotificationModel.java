package com.consulteer.facebook.email;

import com.consulteer.facebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Milos Stambolija on 16.9.2019.
 **/
@Service
public class NotificationModel {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendNotification(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("digitals@consulteer.tk");
        simpleMailMessage.setText("This is another email testing");
        simpleMailMessage.setSubject("This is test email subject");

        javaMailSender.send(simpleMailMessage);
    }

}
