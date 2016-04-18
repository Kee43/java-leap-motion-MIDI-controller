/**
 * Leap motion listener class for interacting with the Leap Motion Controller
 * @author Kieran
 */
import com.leapmotion.leap.*;

class LeapMotionListener extends Listener {

	public static boolean setUp = false;

	InterfaceHandler GUI = new InterfaceHandler();
	GestureHandler gestures = new GestureHandler();
	static Command data;
	float axisValue;
	private int selectedAction;

	/**
	 * On initialisation of the controller 
	 * 
	 * @param aController - Controller object
	 */
	public void onInit(Controller aController) {
		GUI.Log("Initialized");

		if (aController.isServiceConnected()){
			GUI.Log("Service running");
			setUp = true;
		} else {
			GUI.Log("Service not running");   
		}

		if (aController.isConnected() == true){
			GUI.Log("Controller connected"); 
			setUp = true;
		} else {
			GUI.Log("Controller not connected"); 
		}
	}

	/**
	 * Called when the controller is connected
	 * 
	 * @param aController - Controller object
	 */
	public void onConnect(Controller aController) {
		GUI.Log("Leap connected");
		aController.enableGesture(Gesture.Type.TYPE_SWIPE);
		aController.enableGesture(Gesture.Type.TYPE_CIRCLE);
		aController.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		aController.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		setUp = true;

		MainGUI.setLeapConnected();
	}

	/**
	 * On the controller being disconnected
	 * 
	 * @param aController - Controller object
	 */
	public void onDisconnect(Controller aController) {
		//Note: not dispatched when running in a debugger.
		GUI.Log("Disconnected");
		setUp = false;
		MainGUI.setLeapDisconnected();
	}

	/**
	 * On exit of the controller
	 * 
	 * @param aController - Controller object
	 */
	public void onExit(Controller aController) {
		GUI.Log("Exited");
	}

	/**
	 * Each frame that the controller is detecting
	 * 
	 * @param aController - Controller object
	 */
	public void onFrame(Controller aController) {

		// Get the most recent frame and report some basic information
		Frame frame = aController.frame();

		int fingersLeftExtended = 0;
		int fingersRightExtended = 0;

		//Get hands
		for (Hand hand : frame.hands()) {

			Finger index = null;
			Finger middle = null;
			Finger ring = null;
			Finger pinky = null;
			Finger thumb = null;

			// Get fingers
			for (Finger finger : hand.fingers()) {

				if (finger.isExtended()){
					if (finger.type() == Finger.Type.TYPE_INDEX){
						index = finger;
					} else if (finger.type() == Finger.Type.TYPE_MIDDLE){
						middle = finger;
					} else if (finger.type() == Finger.Type.TYPE_RING){
						ring = finger;
					} else if (finger.type() == Finger.Type.TYPE_PINKY){
						pinky = finger;
					} else if (finger.type() == Finger.Type.TYPE_THUMB){
						thumb = finger;
					}
					if (hand.isLeft()){
						fingersLeftExtended ++;
					} else if (hand.isRight()){
						fingersRightExtended ++;
					}
				}
			}

			// Update GUI
			if (hand.isLeft() && hand.confidence() > .2){
				int appWidth = 800;
				int appHeight = 800;

				InteractionBox iBox = aController.frame().interactionBox();
				Pointable pointable = aController.frame().pointables().frontmost();

				Vector leapPoint = pointable.stabilizedTipPosition();
				Vector normalizedPoint = iBox.normalizePoint(leapPoint, true);

				float appX = normalizedPoint.getX() * appWidth;
				float appY = (1 - normalizedPoint.getY()) * appHeight;

				MainGUI.setLeftHandData(fingersLeftExtended, hand.palmPosition().getX(), hand.palmPosition().getY(), hand.palmPosition().getZ());

				if (index != null && fingersLeftExtended == 1){
					GUI.Log("Selecting Track");
					GUI.selectTrackFromGrid(appX, appY);
					selectedAction = 1;
				}
//				System.out.println("CC = " + data.getCC());
//				System.out.println("Action = " + data.getCommand());
//				System.out.println("-------------------------------");
				if (selectedAction == 0){
					// None
				} else if (selectedAction == 1){
					// Selecting track
				} else if (selectedAction == 2){
					if (MainGUI.getSelectedTrack() == 17){
						GUI.setSelectedAction(17, 0);
						MainGUI.logMessage("Global Volume");
						axisValue = getShortAxisValue(MainGUI.getGlobalAction1Axis(), hand.palmPosition());
						
						
						
						gestures.sendData(17, selectedAction, 14, axisNumber, axisValue, MainGUI.getGlobalAction1Min(), MainGUI.getGlobalAction1Max());
					} else {
						axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
						gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
					}
				} else if (selectedAction == 3){
					if (MainGUI.getSelectedTrack() == 17){
						GUI.setSelectedAction(17, 1);
						axisValue = getShortAxisValue(MainGUI.getGlobalAction2Axis(), hand.palmPosition());
						gestures.sendData(17, selectedAction, 15, axisNumber, axisValue, MainGUI.getGlobalAction2Min(), MainGUI.getGlobalAction2Max());
					} else {
						axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
						gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
					}
				} else if (selectedAction == 4){
					axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
					gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
				} else if (selectedAction == 5){
					axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
					gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
				} else if (selectedAction == 6){
					axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
					gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
				} else if (selectedAction == 7){
					axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
					gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
				} else if (selectedAction == 8){
					axisValue = getAxisValue(data.getAxis(), hand.palmPosition());
					gestures.sendData(MainGUI.getSelectedTrack(), selectedAction, data.getCC(), axisNumber, axisValue, Integer.valueOf(data.getMin()), Integer.valueOf(data.getMax()));
				} else {
					gestures.sendData(MainGUI.getSelectedTrack(), 1, 0, 0, 0, 0, 0);
				}
			} else if (hand.isRight() && hand.confidence() > .2){
				MainGUI.setRightHandData(fingersRightExtended, hand.palmPosition().getX(), hand.palmPosition().getY(), hand.palmPosition().getZ());

				if (thumb == null && index == null && middle == null && ring == null && pinky == null && fingersRightExtended == 0){
					GUI.Log("No action");
					selectedAction = 0;
				}
				if (thumb == null && index != null && middle != null && ring == null && pinky == null && fingersRightExtended == 2){
					if (MainGUI.getSelectedTrack() != 17){
						GUI.setSelectedAction(MainGUI.getSelectedTrack(), 0);
						GUI.Log("Action 1");
					} 
					selectedAction = 2;
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 0);
				}
				if (thumb == null && index != null && middle != null && ring != null && pinky == null && fingersRightExtended == 3){
					selectedAction = 3;
					if (MainGUI.getSelectedTrack() != 17){
						GUI.setSelectedAction(MainGUI.getSelectedTrack(), 1);
						GUI.Log("Action 2");
					} 
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 1);
				}
				if (thumb == null && index != null && middle != null && ring != null && pinky != null && fingersRightExtended == 4){
					selectedAction = 4;
					GUI.Log("Action 3");
					GUI.setSelectedAction(MainGUI.getSelectedTrack(), 2);
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 2);
					
				}
				if (thumb != null && index != null && middle != null && ring != null && pinky != null && fingersRightExtended == 5){
					selectedAction = 5;
					GUI.Log("Action 4");
					GUI.setSelectedAction(MainGUI.getSelectedTrack(), 3);
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 3);
				}
				if (thumb == null && index != null && middle == null && ring == null && pinky != null && fingersRightExtended == 2){
					selectedAction = 6;
					GUI.Log("Action 5");
					GUI.setSelectedAction(MainGUI.getSelectedTrack(), 4);
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 4);
				}
				if (thumb != null && index != null && middle == null && ring == null && pinky == null && fingersRightExtended == 2){
					selectedAction = 7;
					GUI.Log("Action 6");
					GUI.setSelectedAction(MainGUI.getSelectedTrack(), 5);
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 5);
				}
				if (thumb != null && index == null && middle == null && ring == null && pinky == null && fingersRightExtended == 1){
					selectedAction = 8;
					GUI.Log("Action 7");
					GUI.setSelectedAction(MainGUI.getSelectedTrack(), 6);
					data = Strings.getConfigSettings(MainGUI.getSelectedTrack(), 6);
				}
			} 
		}
	}

	int axisNumber;

	/**
	 * Getting the index of the selected axis
	 * 
	 * @param aAxis - Axis value
	 * @param aVector - Vector object
	 * @return Vector value
	 */
	public float getAxisValue(String aAxis, Vector aVector){
		if (aAxis.equals(Strings.axis[0])){

			axisNumber = 1;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axis[1])){
			axisNumber = 2;

			return aVector.getY();
		} else if (aAxis.equals(Strings.axis[2])){
			axisNumber = 3;

			return aVector.getZ();
		} else if (aAxis.equals(Strings.axis[3])){

			axisNumber = 4;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axis[4])){

			axisNumber = 5;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axis[5])){
			axisNumber = 6;

			return aVector.getX();
		}
		return aVector.getX();
	}

	/**
	 * Getting the vector value of the selected axis (short value)
	 * 
	 * @param aAxis - Axis value
	 * @param aVector - Vector object
	 * @return Vector value
	 */
	public float getShortAxisValue(String aAxis, Vector aVector){
		if (aAxis.equals(Strings.axisShort[0])){

			axisNumber = 1;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axisShort[1])){
			axisNumber = 2;

			return aVector.getY();
		} else if (aAxis.equals(Strings.axisShort[2])){
			axisNumber = 3;

			return aVector.getZ();
		} else if (aAxis.equals(Strings.axisShort[3])){

			axisNumber = 4;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axisShort[4])){

			axisNumber = 5;
			return aVector.getX();
		} else if (aAxis.equals(Strings.axisShort[5])){
			axisNumber = 6;

			return aVector.getX();
		}
		return aVector.getX();
	}

	/**
	 * Setting the data based on the command object
	 * 
	 * @param aCommand - Command object
	 */
	public static void setData(Command aCommand){
		data = aCommand;
		
	
	}
}




