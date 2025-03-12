package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAll());
		return "employee-list";
	}

	@GetMapping("/new")
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.getById(id));
		return "employee-edit";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		employeeService.update(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.delete(id);
		return "redirect:/employee/list";
	}
}
