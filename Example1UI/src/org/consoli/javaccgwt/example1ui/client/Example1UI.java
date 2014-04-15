package org.consoli.javaccgwt.example1ui.client;

import org.consoli.javaccgwt.example1.parse.Parser;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;

public class Example1UI implements EntryPoint {

	public void onModuleLoad() {
		 //SimplePanel  contentPanel = new SimplePanel ();
		 final TextArea input        = new TextArea();
		 final TextArea parseResults = new TextArea();
	     KeyUpHandler handler = new KeyUpHandler() {
	    	 @Override public void onKeyUp(KeyUpEvent event) { 
	    			try {
	    				Parser p = new Parser(input.getText());
	    				// For the purposes of this demonstration, we don't build an AST, but typically
	    				// a parse would return the root element of an AST.
	    				p.parse();
	    				parseResults.setText("Parsed Following Input OK :: \n\n" + input.getText());
	    			} catch (Exception e) {
	    				parseResults.setText("ERROR IN PARSE:: \n\n" + e.getMessage());
	    			}
	    	 }
	     };
	     // Adds a handler so that we parse every time a key up event is received from the left panel
	     input.addKeyUpHandler(handler);
	     SplitLayoutPanel splitPanel = new SplitLayoutPanel();
	     splitPanel.addWest(input, 600);
	     splitPanel.add    (parseResults);
 	     RootLayoutPanel rp = RootLayoutPanel.get();
	     rp.add(splitPanel);
	}
}
