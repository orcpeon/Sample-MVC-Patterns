package com.samplepatterns.demo;

import javax.swing.SwingUtilities;

import com.samplepatterns.demo.controller.Controller;
import com.samplepatterns.demo.model.DataModel;
import com.samplepatterns.demo.view.MainFrame;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				runApp();
			}
		});
	}
	
	public static void runApp() {
		
		DataModel model = new DataModel();
		MainFrame view = new MainFrame(model);
		Controller controller = new Controller(view, model);
		
		view.setLoginListener(controller);
	}
	
}
