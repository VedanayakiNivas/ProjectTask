package com.te.implementCache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private String name;
	private String category;
	private String author;
	private String publisher;
	private String edition;
}
