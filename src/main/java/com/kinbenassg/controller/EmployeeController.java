package com.kinbenassg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kinbenassg.model.Employee;
import com.kinbenassg.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeService es;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", es.getAllEmployees());
        return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        es.saveEmployee(employee);
        return "redirect:/";
    }
    
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Integer id, Model model) {
     Employee employee = es.getEmployeeById(id);
     model.addAttribute("employee", employee);
     return "update_employee";
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id, Model model) {
        Employee employee = es.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "delete_employee";
    }

    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployeeConfirm(@PathVariable("id") Integer id) {
        es.deleteEmployeeById(id);
        return "redirect:/";
    }
    
   	
}