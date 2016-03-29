/**
 * Saved data used within the application
 * @author Kieran
 */

import java.util.ArrayList;
import java.util.List;

public class Strings {

	static int[] tracks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

	static String[] tracksString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

	static String[] actions = {"0 - Bank Select", "1 - Modulation", "2 - Breath Controller", "3 - Undefined", "4 - Foot Controller",
			"5 - Portamento Time", "6 - Data Entry Most Significant Bit(MSB)", "7 - Volume", "8 - Balance", "9 - Undefined",
			"10 - Pan", "11 - Expression", "12 - Effect Controller 1", "13 - Effect Controller 2", "14 - Tap Tempo", "15 - Master Volume",
			"16 - Undefined", "17 - Undefined", "18 - Undefined", "19 - Undefined", "20 - Undefined", "21 - Undefined", "22 - Undefined",
			"23 - Undefined", "24 - Undefined", "25 - Undefined", "26 - Undefined", "27 - Undefined", "28 - Undefined", "29 - Undefined",
			"30 - Undefined", "31 - Undefined", "32 - Controller 0 Least Significant Bit (LSB)", "33 - Controller 1 Least Significant Bit (LSB)", 
			"34 - Controller 2 Least Significant Bit (LSB)", "35 - Controller 3 Least Significant Bit (LSB)", "36 - Controller 4 Least Significant Bit (LSB)",
			"37 - Controller 5 Least Significant Bit (LSB)", "38 - Controller 6 Least Significant Bit (LSB)", "39 - Controller 7 Least Significant Bit (LSB)", 
			"40 - Controller 8 Least Significant Bit (LSB)", "41 - Controller 9 Least Significant Bit (LSB)", "42 - Controller 10 Least Significant Bit (LSB)", 
			"43 - Controller 11 Least Significant Bit (LSB)", "44 - Controller 12 Least Significant Bit (LSB)", "45 - Controller 13 Least Significant Bit (LSB)", 
			"46 - Controller 14 Least Significant Bit (LSB)", "47 - Controller 15 Least Significant Bit (LSB)", "48 - Controller 16 Least Significant Bit (LSB)", 
			"49 - Controller 17 Least Significant Bit (LSB)", "50 - Controller 18 Least Significant Bit (LSB)", "51 - Controller 19 Least Significant Bit (LSB)", 
			"52 - Controller 20 Least Significant Bit (LSB)", "53 - Controller 21 Least Significant Bit (LSB)", "54 - Controller 22 Least Significant Bit (LSB)", 
			"55 - Controller 23 Least Significant Bit (LSB)", "56 - Controller 24 Least Significant Bit (LSB)", "57 - Controller 25 Least Significant Bit (LSB)",
			"58 - Controller 26 Least Significant Bit (LSB)", "59 - Controller 27 Least Significant Bit (LSB)", "60 - Controller 28 Least Significant Bit (LSB)", 
			"61 - Controller 29 Least Significant Bit (LSB)", "62 - Controller 30 Least Significant Bit (LSB)", "63 - Controller 31 Least Significant Bit (LSB)", 
			"64 - Damper Pedal/Sustain Pedal", "65 - Portamento On/Off Switch", "66 - Sostenuto On/Off Switch", "67 - Soft Pedal On/Off Switch", "68 - Legato FootSwitch", 
			"69 - Hold 2", "70 - Sound Controller 1", "71 - Sound Controller 2", "72 - Sound Controller 3", "73 - Sound Controller 4", "74 - Sound Controller 5", 
			"75 - Sound Controller 6", "76 - Sound Controller 7", "77 - Sound Controller 8", "78 - Sound Controller 9", "79 - Sound Controller 10", 
			"80 - General Purpose MIDI CC Controller", "81 - General Purpose MIDI CC Controller", "82 - General Purpose MIDI CC Controller", 
			"83 - General Purpose MIDI CC Controller", "84 - Portamento CC Control", "85 - Undefined", "86 - Undefined", "87 - Undefined", "88 - Undefined", 
			"89 - Undefined", "90 - Undefined", "91 - Effect 1 Depth", "92 - Effect 2 Depth", "93 - Effect 3 Depth", "94 - Effect 4 Depth", "95 - Effect 5 Depth", 
			"96 - (+1) Data Increment", "97 - (-1) Data Decrement", "98 - Non-Registered Parameter Number LSB (NRPN)", "99 - Non-Registered Parameter Number MSB (NRPN)", 
			"100 - Registered Parameter Number LSB (RPN)", "101 - Registered Parameter Number LSB (RPN)", "102 - Undefined", "103 - Undefined", "104 - Undefined", "105 - Undefined", 
			"106 - Undefined", "107 - Undefined", "108 - Undefined", "109 - Undefined", "110 - Undefined", "111 - Undefined", "112 - Undefined", "113 - Undefined", "114 - Undefined", 
			"115 - Undefined", "116 - Undefined", "117 - Undefined", "118 - Undefined", "119 - Undefined", 	"120 - All Sound Off", "121 - Reset All Controllers", "122 - Local On/Off Switch", 
			"123 - All Notes Off", "124 - Omni Mode Off", "125 - Omni Mode On", "126 - Mono Mode", "127 - Poly Mode"
	};

	static String[] channels = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	static String[] minMax = {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", 
			"55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};

	static String[] axis = {"X axis", "Y axis", "Z axis", "X axis (inverted)", "Y axis (inverted)", "Z axis (inverted)"};

	static String[] axisShort = {"X", "Y", "Z", "X (i)", "Y (i)", "Z (i)"};

	public static List<Command> getSetupTable() {
		Command track1a = new Command(tracks[0], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track1b = new Command(tracks[0], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track1c = new Command(tracks[0], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track1d = new Command(tracks[0], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track1e = new Command(tracks[0], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track1f = new Command(tracks[0], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track1g = new Command(tracks[0], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track2a = new Command(tracks[1], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track2b = new Command(tracks[1], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track2c = new Command(tracks[1], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track2d = new Command(tracks[1], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track2e = new Command(tracks[1], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track2f = new Command(tracks[1], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track2g = new Command(tracks[1], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track3a = new Command(tracks[2], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track3b = new Command(tracks[2], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track3c = new Command(tracks[2], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track3d = new Command(tracks[2], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track3e = new Command(tracks[2], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track3f = new Command(tracks[2], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track3g = new Command(tracks[2], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track4a = new Command(tracks[3], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track4b = new Command(tracks[3], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track4c = new Command(tracks[3], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track4d = new Command(tracks[3], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track4e = new Command(tracks[3], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track4f = new Command(tracks[3], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track4g = new Command(tracks[3], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track5a = new Command(tracks[4], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track5b = new Command(tracks[4], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track5c = new Command(tracks[4], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track5d = new Command(tracks[4], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track5e = new Command(tracks[4], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track5f = new Command(tracks[4], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track5g = new Command(tracks[4], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track6a = new Command(tracks[5], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track6b = new Command(tracks[5], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track6c = new Command(tracks[5], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track6d = new Command(tracks[5], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track6e = new Command(tracks[5], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track6f = new Command(tracks[5], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track6g = new Command(tracks[5], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track7a = new Command(tracks[6], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track7b = new Command(tracks[6], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track7c = new Command(tracks[6], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track7d = new Command(tracks[6], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track7e = new Command(tracks[6], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track7f = new Command(tracks[6], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track7g = new Command(tracks[6], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track8a = new Command(tracks[7], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track8b = new Command(tracks[7], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track8c = new Command(tracks[7], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track8d = new Command(tracks[7], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track8e = new Command(tracks[7], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track8f = new Command(tracks[7], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track8g = new Command(tracks[7], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track9a = new Command(tracks[8], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track9b = new Command(tracks[8], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track9c = new Command(tracks[8], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track9d = new Command(tracks[8], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track9e = new Command(tracks[8], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track9f = new Command(tracks[8], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track9g = new Command(tracks[8], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track10a = new Command(tracks[9], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track10b = new Command(tracks[9], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track10c = new Command(tracks[9], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track10d = new Command(tracks[9], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track10e = new Command(tracks[9], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track10f = new Command(tracks[9], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track10g = new Command(tracks[9], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track11a = new Command(tracks[10], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track11b = new Command(tracks[10], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track11c = new Command(tracks[10], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track11d = new Command(tracks[10], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track11e = new Command(tracks[10], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track11f = new Command(tracks[10], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track11g = new Command(tracks[10], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track12a = new Command(tracks[11], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track12b = new Command(tracks[11], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track12c = new Command(tracks[11], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track12d = new Command(tracks[11], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track12e = new Command(tracks[11], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track12f = new Command(tracks[11], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track12g = new Command(tracks[11], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track13a = new Command(tracks[12], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track13b = new Command(tracks[12], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track13c = new Command(tracks[12], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track13d = new Command(tracks[12], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track13e = new Command(tracks[12], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track13f = new Command(tracks[12], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track13g = new Command(tracks[12], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track14a = new Command(tracks[13], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track14b = new Command(tracks[13], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track14c = new Command(tracks[13], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track14d = new Command(tracks[13], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track14e = new Command(tracks[13], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track14f = new Command(tracks[13], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track14g = new Command(tracks[13], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track15a = new Command(tracks[14], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track15b = new Command(tracks[14], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track15c = new Command(tracks[14], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track15d = new Command(tracks[14], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track15e = new Command(tracks[14], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track15f = new Command(tracks[14], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track15g = new Command(tracks[14], actions[12], 12, axis[1], minMax[0], minMax[20]);

		Command track16a = new Command(tracks[15], actions[7], 7, axis[1], minMax[0], minMax[20]);
		Command track16b = new Command(tracks[15], actions[1], 1, axis[1], minMax[0], minMax[20]);
		Command track16c = new Command(tracks[15], actions[10], 10, axis[1], minMax[0], minMax[20]);
		Command track16d = new Command(tracks[15], actions[2], 2, axis[1], minMax[0], minMax[20]);
		Command track16e = new Command(tracks[15], actions[11], 11, axis[1], minMax[0], minMax[20]);
		Command track16f = new Command(tracks[15], actions[4], 4, axis[1], minMax[0], minMax[20]);
		Command track16g = new Command(tracks[15], actions[12], 12, axis[1], minMax[0], minMax[20]);

		List<Command> newTable = new ArrayList<Command>();

		newTable.add(track1a);
		newTable.add(track1b);
		newTable.add(track1c);
		newTable.add(track1d);
		newTable.add(track1e);
		newTable.add(track1f);
		newTable.add(track1g);

		newTable.add(track2a);
		newTable.add(track2b);
		newTable.add(track2c);
		newTable.add(track2d);
		newTable.add(track2e);
		newTable.add(track2f);
		newTable.add(track2g);

		newTable.add(track3a);
		newTable.add(track3b);
		newTable.add(track3c);
		newTable.add(track3d);
		newTable.add(track3e);
		newTable.add(track3f);
		newTable.add(track3g);

		newTable.add(track4a);
		newTable.add(track4b);
		newTable.add(track4c);
		newTable.add(track4d);
		newTable.add(track4e);
		newTable.add(track4f);
		newTable.add(track4g);

		newTable.add(track5a);
		newTable.add(track5b);
		newTable.add(track5c);
		newTable.add(track5d);
		newTable.add(track5e);
		newTable.add(track5f);
		newTable.add(track5g);

		newTable.add(track6a);
		newTable.add(track6b);
		newTable.add(track6c);
		newTable.add(track6d);
		newTable.add(track6e);
		newTable.add(track6f);
		newTable.add(track6g);

		newTable.add(track7a);
		newTable.add(track7b);
		newTable.add(track7c);
		newTable.add(track7d);
		newTable.add(track7e);
		newTable.add(track7f);
		newTable.add(track7g);

		newTable.add(track8a);
		newTable.add(track8b);
		newTable.add(track8c);
		newTable.add(track8d);
		newTable.add(track8e);
		newTable.add(track8f);
		newTable.add(track8g);

		newTable.add(track9a);
		newTable.add(track9b);
		newTable.add(track9c);
		newTable.add(track9d);
		newTable.add(track9e);
		newTable.add(track9f);
		newTable.add(track9g);

		newTable.add(track10a);
		newTable.add(track10b);
		newTable.add(track10c);
		newTable.add(track10d);
		newTable.add(track10e);
		newTable.add(track10f);
		newTable.add(track10g);

		newTable.add(track11a);
		newTable.add(track11b);
		newTable.add(track11c);
		newTable.add(track11d);
		newTable.add(track11e);
		newTable.add(track11f);
		newTable.add(track11g);

		newTable.add(track12a);
		newTable.add(track12b);
		newTable.add(track12c);
		newTable.add(track12d);
		newTable.add(track12e);
		newTable.add(track12f);
		newTable.add(track12g);

		newTable.add(track13a);
		newTable.add(track13b);
		newTable.add(track13c);
		newTable.add(track13d);
		newTable.add(track13e);
		newTable.add(track13f);
		newTable.add(track13g);

		newTable.add(track14a);
		newTable.add(track14b);
		newTable.add(track14c);
		newTable.add(track14d);
		newTable.add(track14e);
		newTable.add(track14f);
		newTable.add(track14g);

		newTable.add(track15a);
		newTable.add(track15b);
		newTable.add(track15c);
		newTable.add(track15d);
		newTable.add(track15e);
		newTable.add(track15f);
		newTable.add(track15g);

		newTable.add(track16a);
		newTable.add(track16b);
		newTable.add(track16c);
		newTable.add(track16d);
		newTable.add(track16e);
		newTable.add(track16f);
		newTable.add(track16g);

		return newTable;
	}

	/**
	 * Getting the Command object based on its position within the track and action positions
	 * 
	 * @param aTrack - Track
	 * @param aAction - Action
	 * @return Command object
	 */
	public static Command getConfigSettings(int aTrack, int aAction){

		int base = 0;
		if (aTrack == 1){
			base = 0;
		} else if (aTrack == 2){
			base = 7;
		} else if (aTrack == 3){
			base = 13;
		} else if (aTrack == 4){
			base = 19;
		} else if (aTrack == 5){
			base = 25;
		} else if (aTrack == 6){
			base = 31;
		} else if (aTrack == 7){
			base = 37;
		} else if (aTrack == 8){
			base = 43;
		} else if (aTrack == 9){
			base = 49;
		} else if (aTrack == 10){
			base = 55;
		} else if (aTrack == 11){
			base = 61;
		} else if (aTrack == 12){
			base = 67;
		} else if (aTrack == 13){
			base = 73;
		} else if (aTrack == 14){
			base = 79;
		} else if (aTrack == 15){
			base = 85;
		} else if (aTrack == 16){
			base = 91;
		}
		int selection = base + aAction;

		return Settings.mainTableData.get(selection);
	}

	/**
	 * Getting the Command index based on its position within the track and action positions
	 * 
	 * @param aTrack - Track
	 * @param aAction - Action
	 * @return Slot of the selected command
	 */
	public static int getConfigTableSlot(int aTrack, int aAction){

		int base = 0;
		if (aTrack == 1){
			base = 0;
		} else if (aTrack == 2){
			base = 7;
		} else if (aTrack == 3){
			base = 13;
		} else if (aTrack == 4){
			base = 19;
		} else if (aTrack == 5){
			base = 25;
		} else if (aTrack == 6){
			base = 31;
		} else if (aTrack == 7){
			base = 37;
		} else if (aTrack == 8){
			base = 43;
		} else if (aTrack == 9){
			base = 49;
		} else if (aTrack == 10){
			base = 55;
		} else if (aTrack == 11){
			base = 61;
		} else if (aTrack == 12){
			base = 67;
		} else if (aTrack == 13){
			base = 73;
		} else if (aTrack == 14){
			base = 79;
		} else if (aTrack == 15){
			base = 85;
		} else if (aTrack == 16){
			base = 91;
		}
		int slot = base + aAction;

		return slot;
	}

	public static List<Command> getSetupTableMain() {
		return getSetupTable();
	}

	public static String[] getValidMinMaxValues() {
		return minMax;
	}

	public static String[] getValidAxis() {
		return axis;
	}

	public static int[] getTracks(){
		return tracks;
	}

	public static String[] getTracksString(){
		return tracksString;
	}

	public static String[] getChannels(){
		return channels;
	}

	public static String[] getActions(){
		return actions;
	}

	public static String[] getMinMax(){
		return minMax;
	}

	public static String[] getAxis(){
		return axis;
	}

	public static String[] getAxisShort(){
		return axisShort;
	}
}
