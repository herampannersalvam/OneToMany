package com.mall.Bill.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "credit_note")
public class CreditNote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "product_name")
	private String productName;
	
	
	@Column(name = "note_date")
	private Date noteDate;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "bill_Status")
	private String billStatus;
	
	@Column(name = "total_gross_amount")
	private int  totalGrossAmount;
	
	
	@OneToMany(targetEntity = Bill.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_note_id",referencedColumnName = "id")
	private List<Bill>bill;
	
	

}
