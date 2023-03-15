package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.EmployeeDetails;
import com.example.demo.Repository.EmpRepository;
import com.example.demo.Service.EmpServices;

@RestController
public class EmpController {
	
	@Autowired
	private EmpServices empser;
	
	
	//ADD Employee
	@PostMapping("/addEmpDel")
	public EmployeeDetails addEmployeeDetails(@RequestBody EmployeeDetails empdel) {
		return empser.saveEmp(empdel);
	}
	
	//ADD List of Employee
	@PostMapping("/addEmpDels")
	public List<EmployeeDetails> addEmployeeDetailss(@RequestBody List<EmployeeDetails> empdel)
	{
		return empser.saveEmps(empdel);
	}
	
	
	//Get all Employees
	@GetMapping("/getEmpDel")
	public List<EmployeeDetails> findEmployeeDetails()
	{
		return empser.findEmp();
	}
	
	//Get Employee by his/her departmant name
	@GetMapping("/getEmpDel/depname/{departmentName}")
	public List<EmployeeDetails> findEmployeeDepartmentName(@PathVariable String departmentName )
	{
		return empser.findEmpdepname(departmentName);
	}
	
	//Get Employee by id
	@GetMapping("/getEmpDel/{id}")
	public EmployeeDetails findById(@PathVariable int id)
	{
		return empser.findEmpByID(id);
	}
	
	//Delete Employee
	@DeleteMapping("/Empdelete/{id}")
	public String deleteEmployeeDetails(@PathVariable int id)
	{
		return empser.deleteEmp(id);
	}
	
	//Update Employee
	@PutMapping("/Empupdate")
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails empdel)
	{
		return empser.updatEmp(empdel);
	}
}


