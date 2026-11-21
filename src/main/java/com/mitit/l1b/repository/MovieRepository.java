package com.mitit.l1b.repository;

import com.mitit.l1b.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> findAll();

    Optional<Movie> findById(Long id);

    Movie save(Movie movie);
}
