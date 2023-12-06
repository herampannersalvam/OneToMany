package com.mall.Bill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.Bill.entity.Bill;
import com.mall.Bill.entity.CreditNote;
import com.mall.Bill.entity.dto.BillDto;
import com.mall.Bill.entity.dto.CreditNoteBillResponseDto;
import com.mall.Bill.entity.dto.CreditNoteDto;
import com.mall.Bill.repository.BillRepository;
import com.mall.Bill.repository.CreditNoteRepository;

@Service
public class CreditNoteService {
	
	@Autowired
	CreditNoteRepository creditNoteRepository;
	@Autowired
	BillRepository billRepository;

	public String create(CreditNoteDto creditNoteDto) {
		// TODO Auto-generated method stub
		CreditNote credit =new CreditNote();
		credit.setId(creditNoteDto.getId());
		credit.setProductName(creditNoteDto.getProductName());
		credit.setNoteDate(creditNoteDto.getNoteDate());
		credit.setCompanyName(creditNoteDto.getCompanyName());
		credit.setBillStatus(creditNoteDto.getBillStatus());
		credit.setProductName(creditNoteDto.getProductName());
		credit.setTotalGrossAmount(creditNoteDto.getTotalGrossAmount());
		List<Bill>bill=new ArrayList<>();
		for(BillDto billDto:creditNoteDto.getBill()) {
			Bill bills=new Bill();
			bills.setId(billDto.getId());
			bills.setProductName(billDto.getProductName());
			bills.setBillNumber(billDto.getBillNumber());
			bills.setBillDate(billDto.getBillDate());
			bill.add(bills);
		}
		credit.setBill(bill);
		creditNoteRepository.save(credit);
		return "saved successfully"; 
		
	}

	public String listpost(List<CreditNoteDto> creditNoteDto) {
		// TODO Auto-generated method stub
			List<CreditNote> creditNote =new ArrayList<>();
		for(CreditNoteDto credit:creditNoteDto) {
			CreditNote cNote=new CreditNote();
			cNote.setCompanyName(credit.getCompanyName());
			cNote.setNoteDate(credit.getNoteDate());
			cNote.setCompanyName(credit.getCompanyName());
			cNote.setBillStatus(credit.getBillStatus());
			cNote.setProductName(credit.getProductName());
			cNote.setTotalGrossAmount(credit.getTotalGrossAmount());
			List<Bill> bills=new ArrayList<>();
			for(BillDto billDto : credit.getBill()) {
				Bill bill=new Bill();
				bill.setProductName(billDto.getProductName());
				bill.setBillNumber(billDto.getBillNumber());
				bill.setBillDate(billDto.getBillDate());
				bills.add(bill);
			}
			cNote.setBill(bills);
			creditNote.add(cNote);
		}
		creditNoteRepository.saveAll(creditNote);
		return "successfully saved";
	
	}

	public Bill filterCrditNote(String billNumber) {
		// TODO Auto-generated method stub
		System.out.println("billNumber"+billNumber);
		return billRepository.findBillNumber(billNumber);
	}

	
		
	

}
