package com.mitit.l1b.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private String director;
    private BigDecimal price;
    private Integer releaseYear;
    private Integer durationMinutes;
    private String posterUrl;
    private List<String> stills;
    private String description;
    private String genre;
    private String ageRating;
}
