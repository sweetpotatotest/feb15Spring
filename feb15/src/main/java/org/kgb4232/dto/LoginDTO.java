package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	
	private int count, mcount;
	private String id, pw, mname;
}
