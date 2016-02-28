/**
 * This Class is designed using a holder pattern to hold position and scale value
 * data.
 * 
 * @author Garry
 * @date 04/03/2015
 */
public class DataHolder {
	
	//Instance Variables
	private int pos;
	private double scaleValue;
	
	/**
	 * Constructor
	 */
	public DataHolder(){
		pos = 0;
		scaleValue = .5;
	}//constructor
	
	/**
	 * Method: getPosition
	 * 	Retrieves the position value
	 * @return pos
	 */
	public int getPosition(){
		return pos;
	}//end getPosition
	
	/**
	 * Method: getScaleValue
	 * 	Retrieves the scale value.
	 * @return
	 */
	public double getScaleValue(){
		return scaleValue;
	}//end scaleValue
	
	/**
	 * Method: setPosition
	 * 	Sets the position value 
	 * @param pos
	 * 	Takes an int value and set it as the new position value.
	 */
	public void setPosition(int pos){
		//To cycle around the ArrayList, if the position number reaches 7 or above
		//Set position to 0.  If the position is less than 0, set the position to 6.
		if(pos > 6)
			pos = 0;
		if(pos < 0)
			pos = 6;
		this.pos = pos;
	}//end setPostition
	
	/**
	 * Method: setScaleValue
	 * 	Updates the scale value.
	 * @param scaleValue
	 * 	Takes a double and sets it as the new scale value.
	 */
	public void setScaleValue(double scaleValue){
		//If the scale value is bigger than 1, then the scale value will remain at 1.
		//If it is less than .1, it will remain at 0.1.
		if (scaleValue > 1)
			scaleValue = 1;
		if (scaleValue < .1)
			scaleValue = .1;
		this.scaleValue = scaleValue;
	}//end setScaleValue
}//DataHolder
