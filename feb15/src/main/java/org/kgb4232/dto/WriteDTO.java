package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriteDTO {
	private int board_no;
	private String title, content, mid, ip;
}
