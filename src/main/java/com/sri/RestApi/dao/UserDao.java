package com.sri.RestApi.dao;

import java.util.List;

import com.sri.RestApi.model.Usertwo;

public interface UserDao {

	public List<Usertwo> getAllUsers();

	public void addUser(Usertwo usertwo);

	public Usertwo getbyId(int id);

	public void removeUserById(int id);

}
