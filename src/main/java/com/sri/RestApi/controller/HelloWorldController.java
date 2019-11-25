package com.sri.RestApi.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sri.RestApi.dao.UserDaoService;
import com.sri.RestApi.model.Usertwo;

@Controller
public class HelloWorldController {

	@Autowired
	UserDaoService userDaoService;

//	@InitBinder("Usertwo")
//	public void dataBinding(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
//	}

	@InitBinder("Usertwo")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));
	}

	@GetMapping("test")
	@ResponseBody
	public String test() {
		return "Yo Mama";
	}

	@GetMapping("test2")
	@ResponseBody
	public List<Usertwo> test2() {
		return userDaoService.getAllUsers();
	}

	@GetMapping("test3/{id}")
	@ResponseBody
	public Usertwo test3(@PathVariable("id") int id) {
		if(userDaoService.getbyId(id)==null) {
			throw new NoSuchMessageFoundException("no such message"+id);
		}
		
		return userDaoService.getbyId(id);
	}

	@PostMapping("test4")
	public ResponseEntity<Object> test4(@RequestBody Usertwo us) {
		// return new Usertwo(id, "Sri", "Ram");
		System.out.println(us);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(us.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@GetMapping("test5")
	public String test5(Model model) {
		// return new Usertwo(id, "Sri", "Ram");

		model.addAttribute("usertwo", new Usertwo());

		return "test";
	}

	@PostMapping("formresponse")
	public ResponseEntity<Object> test6(@ModelAttribute Usertwo us) {
		// return new Usertwo(id, "Sri", "Ram");
		System.out.println(us);

		userDaoService.addUser(us);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

}