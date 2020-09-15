package com.tiendavideojuegos.tiendaweb.dto;

import java.util.List;

import lombok.Data;

@Data
public class FilterDto {
        private List<String> genre;
        private List<String> language;
}
