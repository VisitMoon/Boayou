package com.spring.mapper;

import java.util.List;

import com.spring.domain.Movie_ListDTO;

public interface Movie_ListMapper {
	

	List<Movie_ListDTO> selectMovieList();
}
