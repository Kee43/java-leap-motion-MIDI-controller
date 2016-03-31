/**
 * Processing data from the gestures
 * @author Kieran
 */

public class GestureHandler {

	private MIDIInterface midiInterface = new MIDIInterface();
	private InterfaceHandler interfaceHandler = new InterfaceHandler();
	int previousValue;
	int firstCommand;
	boolean isSending;

	/**
	 * Preparing data to send across the MIDI interface pipeline
	 * 
	 * @param aTrack - Track of the command
	 * @param aAction - Action associated with the command
	 * @param aCC - CC command
	 * @param aAxisIndex - Axis index value
	 * @param aVectorValue - Vector value of the axis
	 * @param aMin - Minimum value for the command
	 * @param aMax - Maximum value for the command 
	 */
	public void sendData(int aTrack, int aAction, int aCC, int aAxisIndex, float aVectorValue, int aMin, int aMax) {

		int value = 0;

		if (aAxisIndex == 1){
			value = xAxisSmoother(aVectorValue, aMin, aMax);
		} else if (aAxisIndex == 2){
			value = yAxisSmoother(aVectorValue, aMin, aMax);
		} else if (aAxisIndex == 3){
			value = zAxisSmoother(aVectorValue, aMin, aMax);
		} else if (aAxisIndex == 4){
			value = xAxisInvertedSmoother(aVectorValue, aMin, aMax);
		} else if (aAxisIndex == 5){
			value = yAxisInvertedSmoother(aVectorValue, aMin, aMax);
		} else if (aAxisIndex == 6){
			value = zAxisInvertedSmoother(aVectorValue, aMin, aMax);
		} 

		interfaceHandler.setSliderData(aTrack, aAction, value, aAxisIndex);

		if (aTrack == 17 && aAction == 2){
			MIDIAddress midiAddress = new MIDIAddress(aTrack, 1, aCC);
			midiInterface.sendMessage(midiAddress, value);
		} 
		else if (aTrack == 17 && aAction == 3){
			if (value == 0){
				if (previousValue == 0){
					if (firstCommand == 1){
						firstCommand = 0;
						MainGUI.logMessage("Tap tempo command");
						MIDIAddress midiAddress = new MIDIAddress(MainGUI.getSelectedTrack(), 1, 15);
						midiInterface.sendMessage(midiAddress, 50);
					}
				}
			} else {
				firstCommand = 1;
			}
			previousValue = value;

		} else {
			MIDIAddress midiAddress = new MIDIAddress(MainGUI.getSelectedTrack(), MainGUI.getSelectedTrackChannel(), aCC);
			midiInterface.sendMessage(midiAddress, value);
			previousValue = value;
		}
	}
	
	/**
	 * Generating the new vector value based on the set minimum and maximum values (x axis)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int xAxisSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int xValue = Math.round(aVectorValue);

		if (xValue > 0){
			xValue = 0;
		} else if (xValue < -200){
			xValue = -200;
		}

		// x is between -200 and 0
		// Converting x into a value between 0 and 100
		xValue = (xValue + 200) / 2;

		return xValue;
	}

	/**
	 * Generating the new vector value based on the set minimum and maximum values (x axis - inverted)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int xAxisInvertedSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int xValue = Math.round(aVectorValue);

		if (xValue > 0){
			xValue = 0;
		} else if (xValue < -200){
			xValue = -200;
		}

		// x is between -200 and 0
		// Converting x into a value between 0 and 100
		xValue = (xValue + 200) / 2;

		// Inverted X value
		xValue = 1 - xValue;

		return xValue;
	}

	/**
	 * Generating the new vector value based on the set minimum and maximum values (y axis)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int yAxisSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int yValue = Math.round(aVectorValue);

		if (yValue < 100){
			yValue = 100;
		} else if (yValue > 300){
			yValue = 300;
		}

		// Converting x into a value between 0 and 100
		yValue = (yValue - 100) / 2;

		return yValue;
	}

	/**
	 * Generating the new vector value based on the set minimum and maximum values (y axis inverted)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int yAxisInvertedSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int yValue = Math.round(aVectorValue);

		if (yValue < 100){
			yValue = 100;
		} else if (yValue > 300){
			yValue = 300;
		}

		// Converting y into a value between 0 and 100
		yValue = (yValue - 100) / 2;

		// Y is inverted
		yValue = 100 - yValue;

		return yValue;
	}

	/**
	 * Generating the new vector value based on the set minimum and maximum values (z axis)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int zAxisSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int zValue = Math.round(aVectorValue);

		if (zValue > 100){
			zValue = 100;
		} else if (zValue < -100){
			zValue = -100;
		}

		// z is between 100 and -100
		// Converting z into a value between 0 and 100
		zValue = (zValue + 100) / 2;

		return zValue;
	}

	/**
	 * Generating the new vector value based on the set minimum and maximum values (z axis inverted)
	 * 
	 * @param aVectorValue - Original vector value
	 * @param aMinimum - Minimum value of the vector 
	 * @param aMaximum - Maximum value of the vector  
	 * @return Value between 0 and 100
	 */
	public int zAxisInvertedSmoother(float aVectorValue, int aMinimum, int aMaximum){

		int zValue = Math.round(aVectorValue);

		if (zValue > 100){
			zValue = 100;
		} else if (zValue < -100){
			zValue = -100;
		}

		// z is between 100 and -100
		// Converting z into a value between 0 and 100
		zValue = (zValue + 100) / 2;

		// Inverted z value
		zValue = 100 - zValue;

		return zValue;
	}
}
