package com.mitit.l1b.service;

import com.mitit.l1b.dto.MovieCardDto;
import com.mitit.l1b.dto.MovieDetailDto;
import com.mitit.l1b.dto.MovieRequest;
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
    public List<MovieCardDto> findAll(String genre) {
        List<Movie> movies = (genre == null || genre.isBlank())
                ? repository.findAll()
                : repository.findByGenre(genre);
        return mapper.toCards(movies);
    }

    @Override
    public MovieDetailDto findById(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return mapper.toDetail(movie);
    }

    @Override
    public MovieDetailDto create(MovieRequest request) {
        Movie movie = mapper.toEntity(request);
        return mapper.toDetail(repository.save(movie));
    }

    @Override
    public MovieDetailDto update(Long id, MovieRequest request) {
        repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        Movie movie = mapper.toEntity(request);
        movie.setId(id);
        return mapper.toDetail(repository.save(movie));
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new MovieNotFoundException(id);
        }
    }
}
