package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.EmployeeDetails;
import com.example.demo.Repository.EmpRepository;

@Service
public class EmpServices {
	
	@Autowired
	private EmpRepository empRepo;
	
	//save Single employee
	public EmployeeDetails saveEmp(EmployeeDetails empdel)
	{
		return empRepo.save(empdel);
	}
	//save list of employee
	public List<EmployeeDetails> saveEmps(List<EmployeeDetails> empdel)
	{
		return empRepo.saveAll(empdel);
	}
	//get list of employee
	public List<EmployeeDetails> findEmp()
	{
		return empRepo.findAll();
	}
	
	//get employees based on Department name
	public List<EmployeeDetails> findEmpdepname(String departmentName)
	{
		return empRepo.getByDepatName(departmentName);
	} 
	//get Single employee by id
	public EmployeeDetails findEmpByID(int id)
	{
		return empRepo.findById(id).orElse(null);
	}
	//delete employee by id
	public String deleteEmp(int id)
	{
		empRepo.deleteById(id);
		return "Delete Successfull !!!!"  + id;
	}
	//update employee
	public EmployeeDetails updatEmp(EmployeeDetails empdel)
	{
	EmployeeDetails ex = empRepo.findById(empdel.getId()).orElse(null);
	ex.setEmpName(empdel.getEmpName());
	ex.setEmpEmail(empdel.getEmpEmail());
	ex.setDepartmentName(empdel.getDepartmentName());
	return empRepo.save(ex);
	}
	}
