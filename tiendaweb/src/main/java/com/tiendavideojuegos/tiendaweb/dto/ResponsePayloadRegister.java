package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class ResponsePayloadRegister {
    private String Idtoken;
    private String email;
    private String refreshtoken;
    private String expiresIn;
    private String localId;
}