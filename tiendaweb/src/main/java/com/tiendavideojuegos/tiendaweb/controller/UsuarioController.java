package com.tiendavideojuegos.tiendaweb.controller;

import java.util.HashMap;
import java.util.Map;

import com.culqi.Culqi;
import com.culqi.util.CurrencyCode;
import com.tiendavideojuegos.tiendaweb.dto.CulquiPago;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadLogin;
import com.tiendavideojuegos.tiendaweb.dto.ResponsePayloadRegister;
import com.tiendavideojuegos.tiendaweb.dto.UserDto;
import com.tiendavideojuegos.tiendaweb.dto.UsuarioRequest;
import com.tiendavideojuegos.tiendaweb.service.MailService;
import com.tiendavideojuegos.tiendaweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponsePayloadLogin loginUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.loginUsuario(usuarioRequest);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponsePayloadRegister registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.registrarUsuario(usuarioRequest);
    }



    @RequestMapping(value= "/charges", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> charges(@RequestBody CulquiPago culquiPago) throws Exception {

        Culqi culqi = new Culqi();
        culqi.public_key = "pk_test_1f34f9d5710278fe";
        culqi.secret_key = "sk_test_b6ec0d25ce95a87f";

        Map<String, Object> charge = new HashMap<String, Object>();

        
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("oder_id", "124");

        charge.put("amount",culquiPago.getAmount());
        charge.put("currency_code", CurrencyCode.USD);
        charge.put("description","A2B Selected Games");
        charge.put("email",culquiPago.getEmail());
        charge.put("metadata", metadata);
        charge.put("source_id", culquiPago.getSource_id());

        return culqi.charge.create(charge);
    }

        @Autowired
        private MailService notificationService;

    
        @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
        public String send(@RequestBody UsuarioRequest user){
            

            try {
                notificationService.sendEmail(user);
            } catch (MailException mailException) {
                System.out.println(mailException);
            }
            return "Email Send";
        }
}