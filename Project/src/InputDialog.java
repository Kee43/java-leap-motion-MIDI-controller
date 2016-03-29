/**
 * GUI input dialog for changing a command
 * @author Kieran
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class InputDialog implements ActionListener {

	JFrame frame;
	JComboBox cbActions, cbAxis, cbMin, cbMax;
	JButton btnAdd;
	int selectedTrack, selectedSlot;
	private JTextField tfTrack;

	/**
	 * Setting up the dialog
	 * @param aTrack - Selected track
	 * @param aSlot - Selected slot
	 */
	public InputDialog(int aTrack, int aSlot) {
		selectedTrack = aTrack;
		selectedSlot = aSlot;
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Action Creation");
		frame.setBounds(100, 100, 497, 162);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(0, 0, 479, 114);
		frame.getContentPane().add(panel);

		JLabel lblTrack = new JLabel("Track");
		lblTrack.setBounds(12, 13, 41, 16);
		panel.add(lblTrack);

		JLabel lblAction = new JLabel("CC / Action");
		lblAction.setBounds(104, 13, 68, 16);
		panel.add(lblAction);

		cbActions = new JComboBox(Strings.getActions());
		cbActions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbActions.setBounds(104, 34, 233, 25);
		panel.add(cbActions);

		cbMin = new JComboBox(Strings.getMinMax());
		cbMin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMin.setBounds(349, 34, 51, 25);
		panel.add(cbMin);

		cbMax = new JComboBox(Strings.getMinMax());
		cbMax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbMax.setBounds(412, 35, 51, 25);
		cbMax.setSelectedIndex(20);
		panel.add(cbMax);

		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(349, 13, 51, 16);
		panel.add(lblMin);

		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(412, 13, 51, 16);
		panel.add(lblMax);

		JLabel lblAxis = new JLabel("Axis");
		lblAxis.setBounds(12, 81, 58, 16);
		panel.add(lblAxis);

		cbAxis = new JComboBox(Strings.getAxis());
		cbAxis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAxis.setBounds(53, 77, 137, 25);
		cbAxis.setSelectedIndex(1);
		panel.add(cbAxis);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(342, 77, 121, 25);
		btnAdd.addActionListener(this);
		panel.add(btnAdd);

		tfTrack = new JTextField();
		tfTrack.setEditable(false);
		tfTrack.setBounds(12, 35, 58, 22);
		panel.add(tfTrack);
		tfTrack.setColumns(10);
		tfTrack.setText(Integer.toString(selectedTrack));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(selectedTrack);
		if (event.getSource().equals(btnAdd)){

			Command command = new Command(selectedTrack, cbActions.getSelectedItem().toString(), cbActions.getSelectedIndex(), cbAxis.getSelectedItem().toString(), cbMin.getSelectedItem().toString(), cbMax.getSelectedItem().toString());
			System.out.println(selectedTrack);
			MainGUI.setActionData(selectedTrack, selectedSlot, command);
			frame.dispose();
		}
	}
}
