package com.tiendavideojuegos.tiendaweb.dto;


import lombok.Data;

@Data
public class ResponsePayloadLogin{
    private String idToken;
    private String email;
    private String refreshtoken;
    private String expiresIn;
    private String localId;
    private Boolean registered;
}
