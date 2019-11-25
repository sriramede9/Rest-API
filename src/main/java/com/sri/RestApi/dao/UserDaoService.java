package com.sri.RestApi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

	public Usertwo removeUserById(int id) {
		Iterator<Usertwo> iterator = uslist.iterator();
		Usertwo us1 = null;
		while (iterator.hasNext()) {
			Usertwo us = iterator.next();

			// System.out.println(us);
			if (us.getId() == id) {
				us1 = us;
				System.out.println(us1 + "is the user I am going to delete");
				boolean remove = uslist.remove(us);
				return us1;
			}
		}

		// TODO Auto-generated method stub
		// Usertwo remove = uslist.remove(id);

		System.out.println("is the one I am returning" + us1);

		return us1;

	}
}
