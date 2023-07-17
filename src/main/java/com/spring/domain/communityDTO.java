package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class communityDTO {

	private int community_no;			// number
	private String user_id;				// varchar2(30)
	private String docid;				// varchar2(1000)
	private long community_content;		// long
}