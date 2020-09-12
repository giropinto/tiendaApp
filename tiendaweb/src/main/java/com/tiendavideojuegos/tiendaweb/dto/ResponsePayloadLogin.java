package com.tiendavideojuegos.tiendaweb.dto;


import lombok.Data;

@Data
public class ResponsePayloadLogin{
    private String idtoken;
    private String email;
    private String refreshtoken;
    private String expiresIn;
    private String localid;
    private Boolean registered;
}
