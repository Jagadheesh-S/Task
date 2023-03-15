package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.EmployeeDetails;

public interface EmpRepository extends JpaRepository <EmployeeDetails , Integer>{
	
	/*
	JPQL(Java Presistance Query Language)
	@Query("SELECT ed FROM employeedetails ed WHERE departmentName = ?1")
	*/
	
	
	/*Native Query
		Native Query is a raw SQL Query,
		To write Custom Query in repository and Entity level also but best way is to define Custom Query in Repository
	*/
	@Query(value="SELECT*FROM employeedetails WHERE department_name = ?1",nativeQuery =true)	
	public List<EmployeeDetails> getByDepatName(String departmentName);

}
