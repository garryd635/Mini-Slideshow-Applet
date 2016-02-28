/**
 * This Class defines the contents of the Control Panel
 * 
 * @author Garry Dominique
 * @date 4/3/2015
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel{

	//Instance Variables
	private JButton forward,back;
	private JButton zoomIn,zoomOut;
	private JButton play,pause;
	private int pos;
	private Timer t;
	private double scaleValue;
	
	/**
	 * Constructor
	 * @param holder
	 * 	A class that contains data
	 * @param display
	 * 	A reference to the Display panel to repaint the visuals in the panel
	 */
	public ControlPanel(final DataHolder holder,final DisplayPanel display){
		super();
		//Initiate the buttons
		forward = new JButton(">");
		back = new JButton("<");
		zoomIn = new JButton("+");
		zoomOut = new JButton("-");
		play = new JButton("Play");
		pause = new JButton("Pause");
		
		//Action Listeners for buttons
		/**
		 * Zoom In/Zoom Out: Retrieves the scaleValue from the holder and updates the value by 
		 * 0.1 accordingly to the buttons.  Then repaint the display.
		 */
		zoomIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scaleValue = holder.getScaleValue();
				scaleValue = (scaleValue + .1);
				holder.setScaleValue(scaleValue);
				display.repainter();
			}//end actionPerformed
		});
		
		zoomOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scaleValue = holder.getScaleValue();
				scaleValue = (scaleValue - .1);
				holder.setScaleValue(scaleValue);
				display.repainter();
			}//end actionPerformed
		});
		
		/**
		 * Forward/Back: Retrieves the position number from the holder and 
		 * updates it accordingly (Increase for forward and decrease for backwards).
		 * Then repaint the display panel.
		 */
		forward.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pos = holder.getPosition();
				pos++;
				holder.setPosition(pos);
				display.repainter();
			}//end actionPerformed
		});
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pos = holder.getPosition();
				pos--;
				holder.setPosition(pos);
				display.repainter();
			}//end actionPerformed
		});
		
		/**
		 * Play/Pause: Starts or stops the timer.
		 */
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				t.start();
			}//end actionPerformed
		});
		
		pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				t.stop();
			}//end actionPerformed
		});
		
		/**
		 * For every 3 seconds, retrieve the holder's position and update it by 1.
		 * then repaint the display.
		 */
		t = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pos = holder.getPosition();
				pos++;
				holder.setPosition(pos);
				display.repainter();
			}//end actionPerformed()
		});
		
		//Add the buttons to the panel.
		this.add(back);	
		this.add(forward);
		this.add(zoomIn);
		this.add(zoomOut);
		this.add(play);
		this.add(pause);
	}//Constructor
}//ControlPanel
