package hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.TextBox;
import hello.presentation.*;

public class Hello_GWT implements EntryPoint {
	public static Game g;
	
	public void onModuleLoad() {
		final DivElement output = DOM.getElementById("output").cast();
		final TextBox input = TextBox.wrap(DOM.getElementById("input"));

		output.setInnerHTML("<br>Please enter username");
		input.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				g.processInput(input.getValue());
				for(String str : g.uComm){
					output.setInnerHTML(output.getInnerHTML() + str);
				}
			}
		});
	}
	public void printHTML() {
		
	}
	public void initialize() {
		g = new Game();
		g.initializeGame();
	}
}
