package com.employeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeeManagementSystem.Domain.Employee;
import com.employeeManagementSystem.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("listEmployees",empService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/addNewEmployeeForm")
	public String newEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empService.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value ="id") long id,Model model){
		Employee employee=empService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value ="id") long id) {
		this.empService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
}
