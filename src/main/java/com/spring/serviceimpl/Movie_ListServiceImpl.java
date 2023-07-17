package com.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Movie_ListDTO;
import com.spring.mapper.Movie_ListMapper;
import com.spring.service.Movie_ListService;


@Service
public class Movie_ListServiceImpl implements Movie_ListService {
	
	@Autowired
	private Movie_ListMapper mapper;
	
	@Override
	public List<Movie_ListDTO> selectMovieList() {
		// TODO Auto-generated method stub
		return  mapper.selectMovieList();
	}
}
