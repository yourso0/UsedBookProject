package com.usedbook.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooklistDto {
	private String btitle;
	private String bimg;
	private String bname;
	private int bprice;
	private String bstory;
	private String bgenre;
	private String isbn;
	
}
