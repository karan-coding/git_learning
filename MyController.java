package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.DTO.EmployeeDto;

@Controller
public class MyController {
	@GetMapping(path={"insert"})
	public String insertView() {
		System.out.println("hello");
		return "insert";
		
	}

	@PostMapping(path={"insert"})
	public String insertData( @ModelAttribute EmployeeDto employeeDto , Model model, RedirectAttributes redirectAttributes) {
		 System.out.println("*********");
		System.out.println(employeeDto.getId() +" " +employeeDto.getName());
//		model.addAttribute("key","Success");
		redirectAttributes.addFlashAttribute("key", "success");
		return "redirect:/insert";
		
	}

}
