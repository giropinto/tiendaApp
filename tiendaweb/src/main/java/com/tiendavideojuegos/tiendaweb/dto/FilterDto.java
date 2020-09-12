package com.tiendavideojuegos.tiendaweb.dto;

import lombok.Data;

@Data
public class FilterDto {
        private String genre;
        private String language;
        private String page;
        private String searchAs;
}
