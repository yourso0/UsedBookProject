package com.usedbook.home.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyDto {
	private String sid;
	private String sname;
	private String sphone;
	private String saddress;
	private String stitle;
	private String swriter;
	private String sgenre;
	private String sprice;
	private String sisbn;
	private int snum;
}
