package com.spring.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.service.Movie_ListService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Movie_ListTest {

	@Setter(onMethod_ = @Autowired)
	private Movie_ListService service;
	
	@Test
	public void movie_ListTest() {
		log.info(service);
		assertNotNull(service.selectMovieList());
		log.info(service.selectMovieList());
		
	}

}
