package com.samplepatterns.demo.controller;

import java.sql.SQLException;

import com.samplepatterns.demo.model.DataModel;
import com.samplepatterns.demo.model.Person;
import com.samplepatterns.demo.model.PersonDAO;
import com.samplepatterns.demo.view.LoginFormEvent;
import com.samplepatterns.demo.view.LoginListener;
import com.samplepatterns.demo.view.MainFrame;

public class Controller implements LoginListener{
	private MainFrame view;
	private DataModel model;
	private PersonDAO personDAO = new PersonDAO();
	
	public Controller(MainFrame view, DataModel model) {
		this.view = view;
		this.model = model;		
	}

	@Override
	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Login event recieved " + event.getName() + ": " + event.getPassword());
		
		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
