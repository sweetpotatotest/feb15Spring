package org.kgb4232.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchDTO {
	private int pageNo, recordCountPerPage;
	private String search, searchTitle;
}
