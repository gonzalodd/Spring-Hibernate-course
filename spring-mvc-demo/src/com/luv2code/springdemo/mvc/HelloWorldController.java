package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // Parent maping, con esto todo lo que este dentro de esta clase va a ser relativo
						  // a hello, algo parecido a subcarpetas de hello
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm") // complete path = hello/showForm
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm") // complete path = hello/processform
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShouetDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		/* Esto ya no es necesario, spring lo va a hacer automáticamente "behaind the scenes" gracias a la
		 * anotación agregada en los parámetros de este método
		String theName = request.getParameter("studentName");
		*/
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend from v3! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
