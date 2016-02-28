/**
 * This class displays the pictures in a slideshow.
 * 
 * @author Garry Dominique
 * @date 04/03/2015
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel {

	//Instance Variables
	private Image picture;
	private ArrayList<Image> picList;
	private String prefix = "/pictures/Pic";
	private String suffix = ".jpg";
	private DataHolder hPointer;
	
	public DisplayPanel(DataHolder holder){
		super();
		this.setPreferredSize(new java.awt.Dimension(400, 400));
		this.setSize(new java.awt.Dimension(400,400));
		//Initiate the holder pointer for methods outside the constructor and the
		//ArrayList.
		hPointer = holder;
		picList = new ArrayList<Image>();
		
		//Add the pictures into the ArrayList
		for(int i = 1; i < 8; i++){
			String filename = prefix + i + suffix;
			picList.add(create(filename));
		}//end for
		
		//Retrieve the holder's position for the picture displayed and repaint.
		picture = picList.get(holder.getPosition());
		repaint();
	}//Constructor
	
	/**
	 * Method: repainter
	 * 	Retrieves the new position from the holder and repaints the 
	 * picture displayed
	 */
	public void repainter(){
		picture = picList.get(hPointer.getPosition());
		repaint();
	}//end rePainter
	
	/**
	 * Reads and input picture files
	 * @param path
	 * @return
	 * 	A ImageIcon that is type Image.
	 */
	private Image create(String path) { 
		java.net.URL imgURL = getClass().getResource(path); 
		if (imgURL != null) { 
			return (new ImageIcon(imgURL)).getImage(); 
		} else { 
		      System.err.println("Couldn't find file: " + path); 
		    return null; 
		    } 
		  } 
	
	/**
	 * Method: paintComponent
	 * 	Paints the picture displayed and scales the picture according to the scalevalue
	 * 	that was currently in the holder.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		double spareWidth = 
				getWidth() - hPointer.getScaleValue() * picture.getWidth(null);
	    double spareHeight = 
	            getHeight() - hPointer.getScaleValue() * picture.getHeight(null);

		brush.drawImage(picture, (int)(spareWidth/2),(int)(spareHeight/2),
				(int)( picture.getWidth(null)*(hPointer.getScaleValue())), 
				(int)( picture.getHeight(null) * hPointer.getScaleValue()),this);
	}//end paintComponent()
}//DisplayPanel
