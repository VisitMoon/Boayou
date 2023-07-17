package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class user_tbDTO {

	private String user_id;		// varchar2(30)
	private String pwd;			// varchar2(30)
	private String name;		// varchar2(30)
	private int age;			// number
	private String jumin;		// varchar2(14)
	private int number;			// number
}