/**
 * The structure of the Command class
 * @author Kieran
 */

import java.io.Serializable;

public class Command implements Serializable {

	private int track;
	private int cc;
	private String command;
	private String axis;
	private String min;
	private String max;

	/**
	 * Adding a new command object
	 * 
	 * @param aTrack - Track
	 * @param aCommand - Gesture
	 * @param aCC - CC command
	 * @param aAxis - Axis
	 * @param aMin - Minimum value for the command
	 * @param aMax - Maximum value for the command 
	 */
	public Command(int aTrack, String aCommand, int aCC, String aAxis, String aMin, String aMax) {
		this.track = aTrack;
		this.command = aCommand;
		this.axis = aAxis;
		this.min = aMin;
		this.max = aMax;
		this.cc = aCC;
	}

	/**
	 * Displays the full command in string form
	 * 
	 * @param None
	 * @return Command data displayed as a string
	 */
	@Override
	public String toString() {
		return new StringBuffer(" Track : ")
				.append(this.track)
				.append(" CC : ")
				.append(this.command)
				.append(" Axis : ")
				.append(this.axis)
				.append(" Min : ")
				.append(this.min)
				.append(" Max : ")
				.append(this.max).toString();
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String aCommand) {
		this.command = aCommand;
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

	public int getCC() {
		return cc;
	}
	
	public int setCC(int aCC) {
		return this.cc = aCC;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
}
