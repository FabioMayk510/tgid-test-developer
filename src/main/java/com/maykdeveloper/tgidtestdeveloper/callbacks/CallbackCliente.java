package com.maykdeveloper.tgidtestdeveloper.callbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class CallbackCliente {

    @Autowired
    private JavaMailSender mailSender;


    public void callback(String endEmail, String tipo, double valor) {
        /*var email = new SimpleMailMessage();
        email.setFrom("fabiomayk510@gmail.com");
        email.setTo(endEmail);
        email.setSubject(tipo + " concluido!");
        email.setText(tipo + " realizado com sucesso no valor de: " + valor);
        System.out.println(email);
        mailSender.send(email);*/
    }
}
