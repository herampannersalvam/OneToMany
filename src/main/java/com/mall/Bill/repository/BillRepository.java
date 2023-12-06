package com.mall.Bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mall.Bill.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	//@Query(value="SELECT b FROM Bill b WHERE b.billNumber = :billNumber")
	@Query(value="SELECT * FROM bills b WHERE b.bill_number = :billNumber",nativeQuery=true)

	Bill findBillNumber(@Param("billNumber") String billNumber);

}
