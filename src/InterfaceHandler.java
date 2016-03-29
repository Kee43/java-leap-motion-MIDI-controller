/**
 * Processing data from the gestures to interact with the interface components
 * @author Kieran
 */

public class InterfaceHandler {

	/**
	 * Selecting which track from the grid is to be selected
	 * 
	 * @param xValue - x Coordinate
	 * @param yValue - y Coordinate
	 */
	public void selectTrackFromGrid(float xValue, float yValue) {

		int track = 0;

		if (0 < xValue && xValue < 100 && 0 < yValue && yValue < 200){
			track = 1;
		} else if (100 < xValue && xValue < 200 && 0 < yValue && yValue < 200){
			track = 2;
		} else if (200 < xValue && xValue < 300 && 0 < yValue && yValue < 200){
			track = 3;
		} else if (300 < xValue && xValue < 400 && 0 < yValue && yValue < 200){
			track = 4;
		} else if (0 < xValue && xValue < 100 && 200 < yValue && yValue < 400){
			track = 5;
		} else if (100 < xValue && xValue < 200 && 200 < yValue && yValue < 400){
			track = 6;
		} else if (200 < xValue && xValue < 300 && 200 < yValue && yValue < 400){
			track = 7;
		} else if (300 < xValue && xValue < 400 && 200 < yValue && yValue < 400){
			track = 8;
		} else if (0 < xValue && xValue < 100 && 400 < yValue && yValue < 600){
			track = 9;
		} else if (100 < xValue && xValue < 200 && 400 < yValue && yValue < 600){
			track = 10;
		} else if (200 < xValue && xValue < 300 && 400 < yValue && yValue < 600){
			track = 11;
		} else if (300 < xValue && xValue < 400 && 400 < yValue && yValue < 600){
			track = 12;
		} else if (0 < xValue && xValue < 100 && 600 < yValue && yValue < 800){
			track = 13;
		} else if (100 < xValue && xValue < 200 && 600 < yValue && yValue < 800){
			track = 14;
		} else if (200 < xValue && xValue < 300 && 600 < yValue && yValue < 800){
			track = 15;
		} else if (300 < xValue && xValue < 400 && 600 < yValue && yValue < 800){
			track = 16;
		} else if (xValue > 400){
			track = 17;
		}

		if (track != 0){
			MainGUI.selectTrack(track);
		}
	}

	/**
	 * Set the slider position 
	 * 
	 * @param aTrack - Track
	 * @param aAction - Gesture
	 * @param aValue - CC command
	 * @param aAxis - Axis
	 */
	public void setSliderData(int aTrack, int aAction, int aValue, int aAxis){
		MainGUI.setSliderValue(aTrack, aAction, aValue, aAxis);
	}

	/**
	 * Logging the message
	 * 
	 * @param aMessage - Message
	 */
	void Log(String aMessage){
		MainGUI.logMessage(aMessage);
	}
}
