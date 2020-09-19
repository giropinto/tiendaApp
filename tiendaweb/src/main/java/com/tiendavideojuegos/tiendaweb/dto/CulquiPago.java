package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class CulquiPago {
    private String amount;
    private String currency_code;
    private String email;
    private String source_id;
}
