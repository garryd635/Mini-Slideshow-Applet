/**
 * This class displays the applets and runs the application.
 * 
 * @author Garry Dominique
 * @date 04/03/2015
 */
import java.awt.BorderLayout;

import javax.swing.JApplet;


@SuppressWarnings("serial")
public class SlideshowApp extends JApplet {
	//Instance variables
	private DataHolder holder;
	private ControlPanel cPanel;
	private DisplayPanel dPanel;
	
	/**
	 * Method: init()
	 * 	Initiates the applications.  Serves as a Constructor by resizing the window,
	 * initiates the variables, and adds the panels to the applet.
	 */
	public void init(){		
		this.resize(600,350);
		holder = new DataHolder();
		dPanel = new DisplayPanel(holder);
		cPanel = new ControlPanel(holder,dPanel);
		add(cPanel, BorderLayout.NORTH);
		add(dPanel, BorderLayout.CENTER);
	}//end init()
	
	public static void main(String[] args){
	      SlideshowApp show = new SlideshowApp();
	       show.init();
	     }//main
}//SlideshowApp
