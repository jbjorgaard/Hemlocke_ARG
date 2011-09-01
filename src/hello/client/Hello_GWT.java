package hello.client;

import java.sql.SQLException;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.TextBox;
import hello.presentation.*;

public class Hello_GWT implements EntryPoint {
	
	public void onModuleLoad() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final DivElement output = DOM.getElementById("output").cast();
		final TextBox input = TextBox.wrap(DOM.getElementById("input"));

		output.setInnerHTML("<br>Please enter username");
		input.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				Game.currentGame.processInput(input.getValue());
				for(String str : Game.currentGame.uComm){
					output.setInnerHTML(output.getInnerHTML() + str);
				}
			}
		});
	}
	public void printHTML() {
		
	}
	public void initialize() throws SQLException {
		Game.currentGame.initializeGame();
	}
}
