package com.tiendavideojuegos.tiendaweb.service;

import com.tiendavideojuegos.tiendaweb.dao.UsuarioDaoImpl;
import com.tiendavideojuegos.tiendaweb.dto.UserDto;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.exception.ApiException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    
    private JavaMailSender javaMailSender;
    
    @Autowired
    UsuarioDaoImpl usuariodao;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(UsuarioRequest user) throws MailException {

		UsuarioRequest usuario = new UsuarioRequest();
        usuario = usuariodao.ForgetPassword(user);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usuario.getEmail());
		mail.setSubject("Recupera tu contraseña");
		mail.setText("Buenas tardes señor(a), aquí tiene su contraseña: "+ usuario.getPassword());
		javaMailSender.send(mail);
	}

}
