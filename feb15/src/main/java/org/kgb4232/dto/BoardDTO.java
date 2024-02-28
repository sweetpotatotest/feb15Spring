package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int board_no, board_count, comment, mno, board_del;
	private String board_title, mname, mid, board_date, board_ip, board_content;
}
