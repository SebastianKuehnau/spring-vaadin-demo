package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ExampleView.VIEW_NAME)
public class ExampleView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "example";
	
	@Autowired
    EventBus.UIEventBus eventBus;
	
	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new Label("Example"));
		
		eventBus.publish(EventScope.UI, this, new MyEvent("This is an example event"));
	}

}
