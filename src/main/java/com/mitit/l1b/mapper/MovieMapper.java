package com.mitit.l1b.mapper;

import com.mitit.l1b.dto.MovieCardDto;
import com.mitit.l1b.dto.MovieDetailDto;
import com.mitit.l1b.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieCardDto toCard(Movie movie);

    List<MovieCardDto> toCards(List<Movie> movies);

    MovieDetailDto toDetail(Movie movie);
}
