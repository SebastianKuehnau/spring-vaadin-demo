package com.example;

import com.vaadin.navigator.View;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = HelloWorldView.VIEW_NAME)
public class HelloWorldView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "";

	
	
	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new Label("Hello World"));

	}

}
