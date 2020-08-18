package com.api.memory.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    private JavaMailSender emailSender;

    public ApplicationUser signUpUser(ApplicationUser user) {
        sendEmail(user);
        return repository.save(user);
    }

    public void sendEmail(ApplicationUser user){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());

        msg.setSubject("Bienvenue sur Memory " + user.getUsername() + " !");
        msg.setText("Salut à toi " + user.getUsername() +" !" +"\n" + "\n" + "Bienvenue sur Memory, le site qui te permettra de ne plus jamais perdre une petite pétite sur Youtube ! "
                + "\n" + "\n" +
                "Merci à toi de nous avoir rejoint ! Commence tout de suite ta collection de musique sur www.memory.netlify.app " + "\n" + "\n" +
                "À bientôt !");

        emailSender.send(msg);

    }
}
