package com.mall.Bill.entity.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BillDto {
	private int id;
	private String productName;
	private Date billDate;
	private String billNumber;

}
