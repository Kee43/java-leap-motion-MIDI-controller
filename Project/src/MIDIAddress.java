/**
 * Address object for the MIDI commands
 * @author Kieran
 */
public class MIDIAddress {

	private int channel;
	private int ccCommand;
	private int track;

	/**
	 * Creating a MIDI address object
	 * 
	 * @param aTrack - Track
	 * @param aChannel - Channel
	 * @param aCC - CC command
	 */
	public MIDIAddress(int aTrack, int aChannel, int aCC)
	{
		this.channel = aChannel;
		this.track = aTrack;
		this.ccCommand = aCC;	
	}

	public int getChannel() {
		return channel;
	}

	public int getCCCommand() {
		return ccCommand;
	}

	public int getTrack() {
		return track;
	}
}
