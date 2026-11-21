package com.mitit.l1b.dto;

import java.math.BigDecimal;

public record MovieCardDto(Long id, String title, String director,
                           BigDecimal price, String posterUrl) {
}
