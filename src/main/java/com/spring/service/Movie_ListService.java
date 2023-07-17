package com.spring.service;

import java.util.List;

import com.spring.domain.Movie_ListDTO;

public interface Movie_ListService {

	List<Movie_ListDTO> selectMovieList();

}
