package com.mitit.l1b.service;

import com.mitit.l1b.dto.MovieCardDto;
import com.mitit.l1b.dto.MovieDetailDto;
import com.mitit.l1b.entity.Movie;
import com.mitit.l1b.exception.MovieNotFoundException;
import com.mitit.l1b.mapper.MovieMapper;
import com.mitit.l1b.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    @Override
    public List<MovieCardDto> findAll() {
        return mapper.toCards(repository.findAll());
    }

    @Override
    public MovieDetailDto findById(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return mapper.toDetail(movie);
    }
}
