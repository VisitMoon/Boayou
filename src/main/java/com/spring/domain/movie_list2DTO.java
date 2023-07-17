package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class movie_list2DTO {

	private String docid;			// varchar2(1000)
	private String title;			// varchar2(1000)
	private String directornm;		// varchar2(1000)
	private String actornm;			// varchar2(1000)
	private String nation;			// varchar2(1000)
	private String company;			// varchar2(1000)
	private long plot;				// long
	private String runtime;			// varchar2(1000)
	private String rating;			// varchar2(1000)
	private String reprlsdate;		// varchar2(1000)
	private String posters;			// varchar2(4000)
	private String flocation;		// varchar2(2000)
	private String genre;			// varchar2(1000)
}