package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMaile(String from,String to,String sub,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(sub);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }
}
