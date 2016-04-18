/**
 * Interface to the MIDI transmitters and receivers 
 * @author Kieran
 */

import javax.sound.midi.*;

public class MIDIInterface {

	private static MidiDevice midiOutDevice = null;

	public Object[] getAvailableMIDIDevices() {
		return MidiSystem.getMidiDeviceInfo();
	}

	/**
	 * Set the MIDI transmitter port
	 * 
	 * @param aDevice - Selected index of the relevant combo box
	 */
	public void setMidiOutDevice(Object aDevice) throws MidiUnavailableException {
		midiOutDevice = MidiSystem.getMidiDevice(
				(MidiDevice.Info) aDevice);
		midiOutDevice.open();
		System.out.println("Outputting to " + aDevice.toString());
	}

	/**
	 * Sending the MIDI message through the receiver
	 * 
	 * @param aAddress - MIDIAddress object
	 * @param aValue - Value to be sent between 0 and 100
	 */
	public void sendMessage(MIDIAddress aAddress, int aValue) {

		try {
			int timeStamp = -1;

			// Channel 1 - 9
			// CC 1 - 128
			// Value 1 - 128

			//System.out.println("MIDI CC = " + aAddress.getCCCommand());
			
			ShortMessage sm = new ShortMessage(ShortMessage.CONTROL_CHANGE, aAddress.getChannel(), aAddress.getCCCommand(), aValue);
			midiOutDevice.getReceiver().send(sm, timeStamp);

		} catch (InvalidMidiDataException | MidiUnavailableException e) {
			System.err.println("MIDI interface error: Invalid MIDI data: " +
					e.getLocalizedMessage());
		}
	}
}