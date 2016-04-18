/**
 * Saved user settings and other user preferences
 * @author Kieran
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class Settings {

	private Preferences prefs;

	public Settings(){
		prefs = Preferences.userNodeForPackage(Settings.class);
	}

	/**
	 * Setting the track channel preference
	 * 
	 * @param aTrack - Track
	 * @param aChannel - Channel
	 */
	public void setTrackChannel(int aTrack, int aChannel){
		switch (aTrack){
		case 1:
			prefs.putInt("Track1Channel", aChannel);
			break;
		case 2:
			prefs.putInt("Track2Channel", aChannel);
			break;
		case 3:
			prefs.putInt("Track3Channel", aChannel);
			break;
		case 4:
			prefs.putInt("Track4Channel", aChannel);
			break;
		case 5:
			prefs.putInt("Track5Channel", aChannel);
			break;
		case 6:
			prefs.putInt("Track6Channel", aChannel);
			break;
		case 7:
			prefs.putInt("Track7Channel", aChannel);
			break;
		case 8:
			prefs.putInt("Track8Channel", aChannel);
			break;
		case 9:
			prefs.putInt("Track9Channel", aChannel);
			break;
		case 10:
			prefs.putInt("Track10Channel", aChannel);
			break;
		case 11:
			prefs.putInt("Track11Channel", aChannel);
			break;
		case 12:
			prefs.putInt("Track12Channel", aChannel);
			break;
		case 13:
			prefs.putInt("Track13Channel", aChannel);
			break;
		case 14:
			prefs.putInt("Track14Channel", aChannel);
			break;
		case 15:
			prefs.putInt("Track15Channel", aChannel);
			break;
		case 16:
			prefs.putInt("Track16Channel", aChannel);
			break;
		}
	}

	/**
	 * Set the tap tempo preference
	 * 
	 * @param aValue - Track
	 */
	public void setTapTapValue(int aValue){
		prefs.putInt("TapTap", aValue);
	}

	/**
	 * Set the global action selected index value preference
	 * 
	 * @param aSelectedIndex - Selected index of the relevant combo box
	 * @param aActionIndex - Selected index of the global actions panel
	 * @param isMax - If the action is maximum or minimum
	 */
	public void setGlobalActionValue(int aSelectedIndex, int aActionIndex, boolean isMax) {
		if (aActionIndex == 1){
			if (isMax){
				prefs.putInt("Action1Max", aSelectedIndex);
			} else {
				prefs.putInt("Action1Min", aSelectedIndex);
			}
		} else if (aActionIndex == 2){
			if (isMax){
				prefs.putInt("Action2Max", aSelectedIndex);
			} else {
				prefs.putInt("Action2Min", aSelectedIndex);
			}
		}
	}

	/**
	 * Set the global action axis value preference
	 * 
	 * @param aSelectedIndex - Selected index of the axis combo box
	 * @param aActionIndex - Selected index of the global actions panel
	 */
	public void setGlobalAxisValue(int aSelectedIndex, int aActionIndex) {
		if (aActionIndex == 1){
			prefs.putInt("Action1Axis", aSelectedIndex);
		} else if (aActionIndex == 2){
			prefs.putInt("Action2Axis", aSelectedIndex);
		}
	}

	/**
	 * Getting the global action value preference
	 * 
	 * @param aAxisIndex - Axis index
	 * @return Selected index
	 */
	public int getGlobalAxisValue(int aAxisIndex) {
		if (aAxisIndex == 1){
			return prefs.getInt("Action1Axis", 1);
		} else if (aAxisIndex == 2){
			return prefs.getInt("Action2Axis", 1);
		}
		return 1;
	}

	/**
	 * Set the global action value preference
	 * 
	 * @param aActionIndex - Selected index of the global actions panel
	 * @param isMax - If the action is maximum or minimum
	 * @return Selected index
	 */
	public int getGlobalActionValue(int aActionIndex, boolean isMax){
		if (aActionIndex == 1){
			if (isMax){
				return prefs.getInt("Action1Max", 20);
			} else {
				return prefs.getInt("Action1Min", 0);
			}
		} else if (aActionIndex == 2){
			if (isMax){
				return prefs.getInt("Action2Max", 20);
			} else {
				return prefs.getInt("Action2Min", 0);
			}
		}
		return 0;
	}

	/**
	 * Get the index of the tap tempo combo box
	 * 
	 * @return Saved index
	 */		
	public int getTapTapValue(){
		return prefs.getInt("TapTap", 10);
	}

	/**
	 * Get the saved track channel
	 * 
	 * @param aTrack - Selected track
	 * @return Selected index
	 */
	public int getTrackChannel(int aTrack){
		switch (aTrack){
		case 1:
			System.out.println("Channel 1 " + prefs.getInt("Track1Channel", 0));
			return prefs.getInt("Track1Channel", 0);
		case 2:
			return prefs.getInt("Track2Channel", 0);
		case 3:
			return prefs.getInt("Track3Channel", 0);
		case 4:
			return prefs.getInt("Track4Channel", 0);
		case 5:
			return prefs.getInt("Track5Channel", 0);
		case 6:
			return prefs.getInt("Track6Channel", 0);
		case 7:
			return prefs.getInt("Track7Channel", 0);
		case 8:
			return prefs.getInt("Track8Channel", 0);
		case 9:
			return prefs.getInt("Track9Channel", 0);
		case 10:
			return prefs.getInt("Track10Channel", 0);
		case 11:
			return prefs.getInt("Track11Channel", 0);
		case 12:
			return prefs.getInt("Track12Channel", 0);
		case 13:
			return prefs.getInt("Track13Channel", 0);
		case 14:
			return prefs.getInt("Track14Channel", 0);
		case 15:
			return prefs.getInt("Track15Channel", 0);
		case 16:
			return prefs.getInt("Track16Channel", 0);
		}
		return -1;
	}

	/**
	 * Get the main configuration table
	 * 
	 * @return Table configuration
	 */
	public List<Command> loadConfigurationTable() throws IOException{
		loadTable();
		if (mainTableData.size() == 0){
			mainTableData = Strings.getSetupTable();
			saveTable(mainTableData);
		} 
		return mainTableData;
	}

	/**
	 * Save the main table to a file
	 * 
	 * @param Command table - table to be saved
	 */
	public static void saveTable(List<Command> aCommands) {
		ObjectOutputStream objectOutputStream = null;
		FileOutputStream fileOutputStream;

		try{ 
			fileOutputStream = new FileOutputStream("settings-main.txt", false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(aCommands);
			objectOutputStream .close();
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
		System.out.println("Table saved");

	}

	static List<Command> mainTableData = new ArrayList<Command>();

	/**
	 * Load the main table configuration from file
	 * 
	 * @return Commands table
	 */
	public static List<Command> loadTable() throws IOException {

		try { 
			FileInputStream fileInputStream = new FileInputStream("settings-main.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			mainTableData.clear();
			mainTableData = (ArrayList<Command>) objectInputStream.readObject();
			objectInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("Table data loaded");
		return mainTableData;
	}

	/**
	 * Replace a command settings in the configuration table 
	 * 
	 * @param aTrack - Selected track
	 * @param aAction - Selected action
	 * @param aCommand - Selected command
	 * @throws IOException 
	 */
	public void replaceCommand(int aTrack, int aAction, Command aCommand) throws IOException{

		System.out.println("Track = " + aTrack);
		System.out.println("aAction = " + aAction);
		System.out.println("getCC = " + aCommand.getCC());
		System.out.println("getCommand = " + aCommand.getCommand());
		
		int oldCommandSlot = Strings.getConfigTableSlot(aTrack, aAction);

		List<Command> mainTableData2 = mainTableData;
		
		mainTableData2.get(oldCommandSlot).setTrack(aCommand.getTrack());
		mainTableData2.get(oldCommandSlot).setCC(aCommand.getCC());
		mainTableData2.get(oldCommandSlot).setCommand(aCommand.getCommand());
		mainTableData2.get(oldCommandSlot).setMin(aCommand.getMin());
		mainTableData2.get(oldCommandSlot).setMax(aCommand.getMax());
		mainTableData2.get(oldCommandSlot).setAxis(aCommand.getAxis());
		saveTable(mainTableData2);
		
	}

	/**
	 * Get the commands table
	 * 
	 * @return Commands table
	 */
	public static List<Command> getTable(){
		return mainTableData;
	}




}




