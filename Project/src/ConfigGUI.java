/**
 * GUI for the configuration page where the commands can be customised
 * @author Kieran
 */

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ConfigGUI {

	JFrame frame;
	static JTable tableDisplay;
	JComboBox<String> cbGestures, cbMinMax, cbCommands;
	static List<Command> tableData;

	/**
	 * Create the configuration page
	 * 
	 * @param aSettings - Settings object
	 */
	public ConfigGUI(Settings aSettings) {
		tableData = aSettings.getTable();
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Configuration");
		frame.setBounds(100, 100, 546, 655);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(0, 0, 527, 608);
		frame.getContentPane().add(panel);

		JLabel lblMainActions = new JLabel("Main Actions");
		lblMainActions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMainActions.setBounds(22, 13, 183, 31);
		panel.add(lblMainActions);

		JScrollPane scrollPaneMain = new JScrollPane();
		scrollPaneMain.setBounds(12, 53, 503, 542);
		panel.add(scrollPaneMain);

		TableDataModel mainTableDataModel = new TableDataModel(tableData);
		tableDisplay = new JTable(mainTableDataModel);

		// Reference for table:
		// https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
		cbCommands = new JComboBox(Strings.getActions());
		cbCommands.setEditable(true);

		cbGestures = new JComboBox(Strings.getValidAxis());
		cbGestures.setEditable(true);

		cbMinMax = new JComboBox(Strings.getValidMinMaxValues());
		cbMinMax.setEditable(true);

		TableColumnModel mainTableColumnModel = tableDisplay.getColumnModel();
		mainTableColumnModel.getColumn(1).setCellEditor(new DefaultCellEditor(cbCommands));
		mainTableColumnModel.getColumn(2).setCellEditor(new DefaultCellEditor(cbGestures));
		mainTableColumnModel.getColumn(3).setCellEditor(new DefaultCellEditor(cbMinMax));
		mainTableColumnModel.getColumn(4).setCellEditor(new DefaultCellEditor(cbMinMax));

		mainTableColumnModel.getColumn(0).setPreferredWidth(40);
		mainTableColumnModel.getColumn(1).setPreferredWidth(120);
		mainTableColumnModel.getColumn(2).setPreferredWidth(60);
		mainTableColumnModel.getColumn(3).setPreferredWidth(40);
		mainTableColumnModel.getColumn(4).setPreferredWidth(40);

		tableDisplay.setAutoCreateRowSorter(true);
		tableDisplay.setPreferredScrollableViewportSize(tableDisplay.getPreferredSize()); 
		scrollPaneMain.setViewportView(tableDisplay);
	}

	// Reference for sub-class:
	// http://www.java2s.com/Code/Java/Swing-Components/ComboBoxTable.htm
	/**
	 * Data model for the main table
	 */
	public static class TableDataModel extends AbstractTableModel {

		String[] validMinMaxValues = Strings.getValidMinMaxValues();
		String[] validGestureValues = Strings.getValidAxis();
		String[] validCommandValues = Strings.getActions();
		String[] columnNames = {"Track", "CC Command - Action", "Axis", "Min", "Max"};

		public TableDataModel(List<Command> aCommandsList) {
			aCommandsList = new ArrayList<Command>(aCommandsList);
		}

		@Override
		public int getRowCount() {
			return tableData.size();
		}

		public int getColumnCount() {
			return 5;
		}

		/**
		 * Getting the command object value at the current position
		 * 
		 * @param aRowIndex - Row index
		 * @param aColumnIndex - Column index
		 * @return Object - The Command at the selection
		 */
		@Override
		public Object getValueAt(int aRowIndex, int aColumnIndex) {

			Object value = "??";
			Command command = tableData.get(aRowIndex);
			switch (aColumnIndex) {
			case 0:
				value = command.getTrack();
				break;
			case 1:
				value = command.getCommand();
				break;
			case 2:
				value = command.getAxis();
				break;
			case 3:
				value = command.getMin();
				break;
			case 4:
				value = command.getMax();
				break;

			}
			return value;
		}

		public Class getColumnClass(int aColumn) {
			return Command.class;
		}

		public String getColumnName(int aColumn) {
			return columnNames[aColumn];
		}

		/**
		 * Checking if the cell is editable
		 * 
		 * @param aRow - Row index
		 * @param aColumn - Column index
		 * @return boolean - If the cell is editable
		 */
		public boolean isCellEditable(int aRow, int aColumn) {
			return aColumn == 1 || aColumn == 2 || aColumn == 3 || aColumn == 4;
		}

		/**
		 * Setting the properties of a Command object
		 * 
		 * @param aCommand - Command object
		 * @param aRow - Row index
		 * @param aColumn - Column index
		 */
		public void setValueAt(Object aCommand, int aRow, int aColumn) {

			if ( aColumn == 1){
				if (isValidCommandValue(aCommand)) {
					tableData.get(aRow).setCommand((String)aCommand);
					fireTableRowsUpdated(aRow, aRow);
				}
			} else if ( aColumn == 2){
				if (isValidControlValue(aCommand)) {
					tableData.get(aRow).setAxis((String)aCommand);
					fireTableRowsUpdated(aRow, aRow);
				}
			} else if (aColumn == 3 ){
				if (isValidMinMax(aCommand)) {
					tableData.get(aRow).setMin((String) aCommand);
					fireTableRowsUpdated(aRow, aRow);
				}  
			} else if (aColumn == 4){
				if (isValidMinMax(aCommand)) {
					tableData.get(aRow).setMax((String)aCommand);
					fireTableRowsUpdated(aRow, aRow);
				}  
			} 
			tableDisplay.repaint();
			Settings.saveTable(tableData);
			MainGUI.setUpTableData(tableData);
		}

		public String[] getValidGestures() {
			return validGestureValues;
		}

		public String[] getValidMinMax() {
			return validMinMaxValues;
		}

		protected boolean isValidMinMax(Object aValue) {
			if (aValue instanceof String) {
				String minMaxValue = (String)aValue;
				for (int i = 0; i < validMinMaxValues.length; i++) {
					if (minMaxValue.equals(validMinMaxValues[i])) {
						return true;
					}
				}
			}
			return false;
		}

		protected boolean isValidControlValue(Object aValue) {
			if (aValue instanceof String) {
				String controlValue = (String)aValue;
				for (int i = 0; i < validGestureValues.length; i++) {
					if (controlValue.equals(validGestureValues[i])) {
						return true;
					}
				}
			}
			return false;
		}

		protected boolean isValidCommandValue(Object aValue) {
			if (aValue instanceof String) {
				String commandValue = (String)aValue;
				for (int i = 0; i < validCommandValues.length; i++) {
					if (commandValue.equals(validCommandValues[i])) {
						return true;
					}
				}
			}
			return false;
		}
	}
}
