package hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hello_GWT implements EntryPoint {
	public void onModuleLoad() {
		final DivElement output = DOM.getElementById("output").cast();
		final TextBox input = TextBox.wrap(DOM.getElementById("input"));
		final ListBox list = ListBox.wrap(DOM.getElementById("sel"));

		input.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				output.setInnerHTML("INPUT: " + input.getValue());
			}
		});
		list.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				output.setInnerHTML("BEEP: " + list.getValue(list.getSelectedIndex()));
			}
		});
	}
}
