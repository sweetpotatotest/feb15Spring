package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {

	private int nno, ndel, nread, nlike;
	private String ntitle, ncontent, ndate, checkDate;
}
