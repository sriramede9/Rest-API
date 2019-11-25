package com.sri.RestApi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.sri.RestApi.model.Usertwo;

@Component
public class UserDaoService {

	private static List<Usertwo> uslist = new ArrayList();

	static {
		uslist.add(new Usertwo(1, "sri", new Date()));
		uslist.add(new Usertwo(2, "sri Ede", new Date()));
		uslist.add(new Usertwo(3, "sri Ram", new Date()));
		uslist.add(new Usertwo(4, "sri Sri", new Date()));
	}

	public List<Usertwo> getAllUsers() {
		return uslist;
	}

	public Usertwo getbyId(int id) {

		for (Usertwo u : uslist) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public void addUser(Usertwo us) {
		uslist.add(us);
	}
}
