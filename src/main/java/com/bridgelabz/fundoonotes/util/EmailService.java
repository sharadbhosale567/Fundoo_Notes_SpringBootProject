package com.bridgelabz.fundoonotes.util;

import com.bridgelabz.fundoonotes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

//    public void sendMail(String email, String token) throws MailException {
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setFrom("sharadgb567@gmail.com");
//        mail.setTo("sharadgb567@gmail.com");
//        mail.setSubject("verify user");
//        mail.setText("click here..." + token);
//        javaMailSender.send(mail);
//    }

//    public void sendForgetPasswordMail(String email, String token) throws MailException
//    {
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setFrom("sharadgb567@gmail.com");
//        mail.setTo(email);
//        mail.setSubject("Forget password link");
//        mail.setText("click here..." + token);
//
//        javaMailSender.send(mail);
//    }
    public String getLink(String token) {

        return "http://localhost:8080/verify/" +token;
    }
    public String sendEmail(String token) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("sharadgb567@gmail.com");
            mimeMessageHelper.setTo("sharadgb567@gmail.com");
            mimeMessageHelper.setSubject("Verification....");
            mimeMessageHelper.setText("Click below link....");
            mimeMessageHelper.setText("http://localhost:8080/verify/" + token);
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (Exception e) {
            return "Mail sent failed";
        }
    }
}
