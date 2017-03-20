package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventBusListener;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI(path = "")
public class VaadinUI extends UI implements EventBusListener<MyEvent> {

	Panel viewPanel = new Panel() ;
	
	HorizontalLayout menuLayout = new HorizontalLayout() ;
	
	@Autowired
	SpringViewProvider viewProvider ;
	
	@Autowired
    EventBus.UIEventBus eventBus;
	
    @Override
    protected void init(VaadinRequest request) {
    	
    	eventBus.subscribe(this);
    	
    	HorizontalSplitPanel rootPanel = new HorizontalSplitPanel() ;
    	
    	Navigator navigator = new Navigator(this, viewPanel);
    	navigator.addProvider(viewProvider);
    	
    	menuLayout.addComponent(new Button("default", event -> navigator.navigateTo(HelloWorldView.VIEW_NAME)));
    	menuLayout.addComponent(new Button("example", event -> navigator.navigateTo(ExampleView.VIEW_NAME)));
    	
    	rootPanel.setFirstComponent(menuLayout);
    	rootPanel.setSecondComponent(viewPanel);
    	
    	this.setContent(rootPanel);
    }

	@Override
	public void onEvent(org.vaadin.spring.events.Event<MyEvent> event) {
		MyEvent currentEvent = event.getPayload() ;
		
		getUI().access(() -> Notification.show(currentEvent.getContentText())) ;
		
	}	
}

	

