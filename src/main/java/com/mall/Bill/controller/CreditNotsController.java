package com.mall.Bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.Bill.entity.Bill;
import com.mall.Bill.entity.dto.CreditNoteBillResponseDto;
import com.mall.Bill.entity.dto.CreditNoteDto;
import com.mall.Bill.service.CreditNoteService;

@RestController
@RequestMapping("/api/bills")
public class CreditNotsController {
	
	@Autowired
	CreditNoteService creditNoteService;
	
	@PostMapping("/post")
	public String create(@RequestBody CreditNoteDto creditNoteDto) {
		creditNoteService.create(creditNoteDto);
		return "Successfully Saved";
	}
	@PostMapping("/listpost")
	public String listpost(@RequestBody List<CreditNoteDto> creditNoteDto) {
		creditNoteService.listpost(creditNoteDto);
		return "List Post Successfully Complited";
	}
	@GetMapping("/filterCreditNote/{billNumber}")
	public Bill filterCrditNote(@PathVariable(name = "billNumber") String billNumber){
		return creditNoteService.filterCrditNote(billNumber);
	}
	

}
