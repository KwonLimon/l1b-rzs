package com.mitit.l1b.dto;

import java.math.BigDecimal;
import java.util.List;

public record MovieDetailDto(Long id, String title, String director, BigDecimal price,
                             Integer releaseYear, Integer durationMinutes, String posterUrl,
                             List<String> stills, String description, String genre,
                             String ageRating) {
}
