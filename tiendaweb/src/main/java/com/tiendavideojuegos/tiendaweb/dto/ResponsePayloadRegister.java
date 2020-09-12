package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class ResponsePayloadRegister {
    private String idtoken;
    private String email;
    private String refreshtoken;
    private String expiresIn;
    private String localid;
}