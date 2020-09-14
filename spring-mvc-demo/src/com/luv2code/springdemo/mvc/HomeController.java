package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* PASOS PARA CREAR UN CONTROLLER
 *  2 - Agregar la anotación @Controller a la clase
 *  3 - Crear el método
 *  4 - Agregar la anotacion @RequestMapping al método
 *  5 - Retornar el nombre de la view-page
 *  6 - Crear la view-page
 * */

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showMyPage() {
		return "main-menu";
	}
	
}
