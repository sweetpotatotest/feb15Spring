package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private int mno, mgrade, mcount;
	private String mid, mpw, mname, mdate, memail, mkey;
}
