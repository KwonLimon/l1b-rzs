package com.mitit.l1b.service;

import com.mitit.l1b.dto.MovieCardDto;
import com.mitit.l1b.dto.MovieDetailDto;
import com.mitit.l1b.dto.MovieRequest;

import java.util.List;

public interface MovieService {
    List<MovieCardDto> findAll(String genre);

    MovieDetailDto findById(Long id);

    MovieDetailDto create(MovieRequest request);

    MovieDetailDto update(Long id, MovieRequest request);

    void delete(Long id);
}
