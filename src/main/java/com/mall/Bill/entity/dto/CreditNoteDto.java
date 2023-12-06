package com.mall.Bill.entity.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CreditNoteDto {
	
	
	private int id;
	private String productName;
	private Date noteDate;
	private String companyName;
	private String billStatus;
	private int  totalGrossAmount;
	private List<BillDto> bill;
	

}
