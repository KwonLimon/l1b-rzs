package com.mitit.l1b.service;

import com.mitit.l1b.dto.MovieCardDto;
import com.mitit.l1b.dto.MovieDetailDto;

import java.util.List;

public interface MovieService {
    List<MovieCardDto> findAll();

    MovieDetailDto findById(Long id);
}
