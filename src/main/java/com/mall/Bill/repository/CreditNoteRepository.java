package com.mall.Bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mall.Bill.entity.Bill;
import com.mall.Bill.entity.CreditNote;

@Repository
public interface CreditNoteRepository extends JpaRepository<CreditNote, Integer>{

	
	//@Query(value ="select c.id as creditNoteId,b.bill_date as billDate,b.bill_number as billNumber,c.total_gross_amount as totalGrossAmount,c.bill_status as billStatus,c.company_name as companyName,c.product_name as creditProductName,c.note_date as noteDate,b.product_name as productsName,b.id from credit_note as c inner join bills as b on c.id=b.credit_note_id where b.bill_number=9345525261",nativeQuery = true)
	/*
	 * @Query("SELECT c.id as creditNoteId, b.billDate as billDate, b.billNumber as billNumber, "
	 * + "c.totalGrossAmount as totalGrossAmount, c.billStatus as billStatus, " +
	 * "c.companyName as companyName, c.productName as creditProductName, " +
	 * "c.noteDate as noteDate, b.productName as productsName, b.id " +
	 * "FROM CreditNote c " + "JOIN c.bills b " +
	 * "WHERE b.billNumber = :billNumber")
	 */
	@Query(value="SELECT * FROM bills WHERE bill_number = :billNumber",nativeQuery=true)
	Bill findBillNumber(@Param("billNumber") String billNumber);

	

}
