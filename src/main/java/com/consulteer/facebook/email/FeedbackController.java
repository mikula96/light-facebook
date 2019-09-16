package com.consulteer.facebook.email;

import com.consulteer.facebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Milos Stambolija on 16.9.2019.
 **/
@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {

    @Autowired
    private NotificationModel notificationModel;

    @PostMapping(value = "/contact-us")
    public ResponseEntity<?> contact() {
        User user = new User();

        user.setEmail("webprogramming201496@gmail.com");
        user.setId(1L);
        user.setName("Mikica");
        user.setLastName("Mikica2");

        notificationModel.sendNotification(user);
        return ResponseEntity.ok().build();

    }

}
