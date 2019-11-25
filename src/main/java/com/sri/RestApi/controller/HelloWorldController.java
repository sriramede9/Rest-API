package com.sri.RestApi.controller;

import java.net.URI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import org.springframework.hateoas.*;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Controller
public class HelloWorldController {

	@Autowired
	UserDaoService userDaoService;

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

	@GetMapping("user")
	@ResponseBody
	public List<Usertwo> getAllUsers() {
		return userDaoService.getAllUsers();
	}

	@GetMapping("user/{id}")
	@ResponseBody
	public Resource<Usertwo> test3(@PathVariable("id") int id) {
		if (userDaoService.getbyId(id) == null) {
			throw new NoSuchMessageFoundException("no such message" + id);
		}

		// adding HATEOAS
		Usertwo us = userDaoService.getbyId(id);

		Resource<Usertwo> resource = new Resource<>(us);

		ControllerLinkBuilder linkTo = ControllerLinkBuilder.
				linkTo(methodOn(this.getClass()). getAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping("user")
	public ResponseEntity<Object> addUserbyPostMantoseestatus(@Valid @RequestBody Usertwo us) {
		// return new Usertwo(id, "Sri", "Ram");
		System.out.println(us);
		int id = userDaoService.getAllUsers().size() + 1;// auto incrementing the id

		us.setId(id);
		userDaoService.addUser(us);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@PostMapping("formresponse")
	public ResponseEntity<Object> addUserUsingJspForm(@ModelAttribute Usertwo us) {
		// return new Usertwo(id, "Sri", "Ram");
		System.out.println(us);

		int id = userDaoService.getAllUsers().size() + 1;// auto incrementing the id

		us.setId(id);

		userDaoService.addUser(us);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping("user/{id}")
	public Usertwo delete(@PathVariable("id") int id) {

		Usertwo removeUserById = userDaoService.removeUserById(id);

//		if (removeUserById == null) {
//			throw new NoSuchMessageFoundException("no such User" + id);
//		}

		// ResponseEntity.

		System.out.println(removeUserById);

		return removeUserById;
	}

}
