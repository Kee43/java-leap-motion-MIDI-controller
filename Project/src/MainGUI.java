/**
 * Main class for the user interface
 * @author Kieran
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import com.leapmotion.leap.*;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Dimension;
import java.awt.Insets;

public class MainGUI extends JFrame implements ActionListener {

	private static JFrame frmGestureControlledMusical;

	private static JTextField tfLeftFingers, tfLeftX, tfLeftY, tfLeftZ, tfRightFingers, tfRightX, tfRightY, tfRightZ, tfLeapStatus, tfSelectedTrackDigit1, tfAxisTrack1, 
	tfAxisTrack2, tfAxisTrack3, tfAxisTrack4, tfAxisTrack5, tfAxisTrack6, tfAxisTrack7, tfAxisTrack8, tfAxisTrack9, tfAxisTrack10, tfAxisTrack11, tfAxisTrack12, tfAxisTrack13,
	tfAxisTrack14, tfAxisTrack15, tfAxisTrack16;

	private static JComboBox<String> midiComboBox, cbChannelTrack1, cbChannelTrack2, cbChannelTrack3, cbChannelTrack4, cbChannelTrack5, cbChannelTrack6, cbChannelTrack7, 
	cbChannelTrack8, cbChannelTrack9, cbChannelTrack10, cbChannelTrack11, cbChannelTrack12, cbChannelTrack13, cbChannelTrack14, cbChannelTrack15, cbChannelTrack16,
	cbTapTempoTap;

	private static JButton btnConfiguration;

	private static JButton btnOpenTrack1Action1, btnOpenTrack1Action2, btnOpenTrack1Action3, btnOpenTrack1Action4, btnOpenTrack1Action5, btnOpenTrack1Action6, btnOpenTrack1Action7;
	private static JLabel lblTrack1Action1, lblTrack1Action2, lblTrack1Action3, lblTrack1Action4, lblTrack1Action5, lblTrack1Action6, lblTrack1Action7;
	private static JSlider sliderTrack1Action1, sliderTrack1Action2, sliderTrack1Action3, sliderTrack1Action4, sliderTrack1Action5, sliderTrack1Action6, sliderTrack1Action7;

	private static JButton btnOpenTrack2Action1, btnOpenTrack2Action2, btnOpenTrack2Action3, btnOpenTrack2Action4, btnOpenTrack2Action5, btnOpenTrack2Action6, btnOpenTrack2Action7;
	private static JLabel lblTrack2Action1, lblTrack2Action2, lblTrack2Action3, lblTrack2Action4, lblTrack2Action5, lblTrack2Action6, lblTrack2Action7;
	private static JSlider sliderTrack2Action1, sliderTrack2Action2, sliderTrack2Action3, sliderTrack2Action4, sliderTrack2Action5, sliderTrack2Action6, sliderTrack2Action7;

	private static JButton btnOpenTrack3Action1, btnOpenTrack3Action2, btnOpenTrack3Action3, btnOpenTrack3Action4, btnOpenTrack3Action5, btnOpenTrack3Action6, btnOpenTrack3Action7;
	private static JLabel lblTrack3Action1, lblTrack3Action2, lblTrack3Action3, lblTrack3Action4, lblTrack3Action5, lblTrack3Action6, lblTrack3Action7;
	private static JSlider sliderTrack3Action1, sliderTrack3Action2, sliderTrack3Action3, sliderTrack3Action4, sliderTrack3Action5, sliderTrack3Action6, sliderTrack3Action7;

	private static JButton btnOpenTrack4Action1, btnOpenTrack4Action2, btnOpenTrack4Action3, btnOpenTrack4Action4, btnOpenTrack4Action5, btnOpenTrack4Action6, btnOpenTrack4Action7;
	private static JLabel lblTrack4Action1, lblTrack4Action2, lblTrack4Action3, lblTrack4Action4, lblTrack4Action5, lblTrack4Action6, lblTrack4Action7;
	private static JSlider sliderTrack4Action1, sliderTrack4Action2, sliderTrack4Action3, sliderTrack4Action4, sliderTrack4Action5, sliderTrack4Action6, sliderTrack4Action7;

	private static JButton btnOpenTrack5Action1, btnOpenTrack5Action2, btnOpenTrack5Action3, btnOpenTrack5Action4, btnOpenTrack5Action5, btnOpenTrack5Action6, btnOpenTrack5Action7;
	private static JLabel lblTrack5Action1, lblTrack5Action2, lblTrack5Action3, lblTrack5Action4, lblTrack5Action5, lblTrack5Action6, lblTrack5Action7;
	private static JSlider sliderTrack5Action1, sliderTrack5Action2, sliderTrack5Action3, sliderTrack5Action4, sliderTrack5Action5, sliderTrack5Action6, sliderTrack5Action7;

	private static JButton btnOpenTrack6Action1, btnOpenTrack6Action2, btnOpenTrack6Action3, btnOpenTrack6Action4, btnOpenTrack6Action5, btnOpenTrack6Action6, btnOpenTrack6Action7;
	private static JLabel lblTrack6Action1, lblTrack6Action2, lblTrack6Action3, lblTrack6Action4, lblTrack6Action5, lblTrack6Action6, lblTrack6Action7;
	private static JSlider sliderTrack6Action1, sliderTrack6Action2, sliderTrack6Action3, sliderTrack6Action4, sliderTrack6Action5, sliderTrack6Action6, sliderTrack6Action7;

	private static JButton btnOpenTrack7Action1, btnOpenTrack7Action2, btnOpenTrack7Action3, btnOpenTrack7Action4, btnOpenTrack7Action5, btnOpenTrack7Action6, btnOpenTrack7Action7;
	private static JLabel lblTrack7Action1, lblTrack7Action2, lblTrack7Action3, lblTrack7Action4, lblTrack7Action5, lblTrack7Action6, lblTrack7Action7;
	private static JSlider sliderTrack7Action1, sliderTrack7Action2, sliderTrack7Action3, sliderTrack7Action4, sliderTrack7Action5, sliderTrack7Action6, sliderTrack7Action7;

	private static JButton btnOpenTrack8Action1, btnOpenTrack8Action2, btnOpenTrack8Action3, btnOpenTrack8Action4, btnOpenTrack8Action5, btnOpenTrack8Action6, btnOpenTrack8Action7;
	private static JLabel lblTrack8Action1, lblTrack8Action2, lblTrack8Action3, lblTrack8Action4, lblTrack8Action5, lblTrack8Action6, lblTrack8Action7;
	private static JSlider sliderTrack8Action1, sliderTrack8Action2, sliderTrack8Action3, sliderTrack8Action4, sliderTrack8Action5, sliderTrack8Action6, sliderTrack8Action7;

	private static JButton btnOpenTrack9Action1, btnOpenTrack9Action2, btnOpenTrack9Action3, btnOpenTrack9Action4, btnOpenTrack9Action5, btnOpenTrack9Action6, btnOpenTrack9Action7;
	private static JLabel lblTrack9Action1, lblTrack9Action2, lblTrack9Action3, lblTrack9Action4, lblTrack9Action5, lblTrack9Action6, lblTrack9Action7;
	private static JSlider sliderTrack9Action1, sliderTrack9Action2, sliderTrack9Action3, sliderTrack9Action4, sliderTrack9Action5, sliderTrack9Action6, sliderTrack9Action7;

	private static JButton btnOpenTrack10Action1, btnOpenTrack10Action2, btnOpenTrack10Action3, btnOpenTrack10Action4, btnOpenTrack10Action5, btnOpenTrack10Action6, btnOpenTrack10Action7;
	private static JLabel lblTrack10Action1, lblTrack10Action2, lblTrack10Action3, lblTrack10Action4, lblTrack10Action5, lblTrack10Action6, lblTrack10Action7;
	private static JSlider sliderTrack10Action1, sliderTrack10Action2, sliderTrack10Action3, sliderTrack10Action4, sliderTrack10Action5, sliderTrack10Action6, sliderTrack10Action7;

	private static JButton btnOpenTrack11Action1, btnOpenTrack11Action2, btnOpenTrack11Action3, btnOpenTrack11Action4, btnOpenTrack11Action5, btnOpenTrack11Action6, btnOpenTrack11Action7;
	private static JLabel lblTrack11Action1, lblTrack11Action2, lblTrack11Action3, lblTrack11Action4, lblTrack11Action5, lblTrack11Action6, lblTrack11Action7;
	private static JSlider sliderTrack11Action1, sliderTrack11Action2, sliderTrack11Action3, sliderTrack11Action4, sliderTrack11Action5, sliderTrack11Action6, sliderTrack11Action7;

	private static JButton btnOpenTrack12Action1, btnOpenTrack12Action2, btnOpenTrack12Action3, btnOpenTrack12Action4, btnOpenTrack12Action5, btnOpenTrack12Action6, btnOpenTrack12Action7;
	private static JLabel lblTrack12Action1, lblTrack12Action2, lblTrack12Action3, lblTrack12Action4, lblTrack12Action5, lblTrack12Action6, lblTrack12Action7;
	private static JSlider sliderTrack12Action1, sliderTrack12Action2, sliderTrack12Action3, sliderTrack12Action4, sliderTrack12Action5, sliderTrack12Action6, sliderTrack12Action7;

	private static JButton btnOpenTrack13Action1, btnOpenTrack13Action2, btnOpenTrack13Action3, btnOpenTrack13Action4, btnOpenTrack13Action5, btnOpenTrack13Action6, btnOpenTrack13Action7;
	private static JLabel lblTrack13Action1, lblTrack13Action2, lblTrack13Action3, lblTrack13Action4, lblTrack13Action5, lblTrack13Action6, lblTrack13Action7;
	private static JSlider sliderTrack13Action1, sliderTrack13Action2, sliderTrack13Action3, sliderTrack13Action4, sliderTrack13Action5, sliderTrack13Action6, sliderTrack13Action7;

	private static JButton btnOpenTrack14Action1, btnOpenTrack14Action2, btnOpenTrack14Action3, btnOpenTrack14Action4, btnOpenTrack14Action5, btnOpenTrack14Action6, btnOpenTrack14Action7;
	private static JLabel lblTrack14Action1, lblTrack14Action2, lblTrack14Action3, lblTrack14Action4, lblTrack14Action5, lblTrack14Action6, lblTrack14Action7;
	private static JSlider sliderTrack14Action1, sliderTrack14Action2, sliderTrack14Action3, sliderTrack14Action4, sliderTrack14Action5, sliderTrack14Action6, sliderTrack14Action7;

	private static JButton btnOpenTrack15Action1, btnOpenTrack15Action2, btnOpenTrack15Action3, btnOpenTrack15Action4, btnOpenTrack15Action5, btnOpenTrack15Action6, btnOpenTrack15Action7;
	private static JLabel lblTrack15Action1, lblTrack15Action2, lblTrack15Action3, lblTrack15Action4, lblTrack15Action5, lblTrack15Action6, lblTrack15Action7;
	private static JSlider sliderTrack15Action1, sliderTrack15Action2, sliderTrack15Action3, sliderTrack15Action4, sliderTrack15Action5, sliderTrack15Action6, sliderTrack15Action7;

	private static JButton btnOpenTrack16Action1, btnOpenTrack16Action2, btnOpenTrack16Action3, btnOpenTrack16Action4, btnOpenTrack16Action5, btnOpenTrack16Action6, btnOpenTrack16Action7;
	private static JLabel lblTrack16Action1, lblTrack16Action2, lblTrack16Action3, lblTrack16Action4, lblTrack16Action5, lblTrack16Action6, lblTrack16Action7;
	private static JSlider sliderTrack16Action1, sliderTrack16Action2, sliderTrack16Action3, sliderTrack16Action4, sliderTrack16Action5, sliderTrack16Action6, sliderTrack16Action7;

	private static JSlider sliderGlobalAction1, sliderGlobalAction2;
	private static JLabel lblTapTempo, lblTapTempoTap, lblGlobal, lblGlobalAction2Min, lblGlobalAction2Max, lblMasterVolume, lblGlobalAction1Min, lblGlobalAction1Max, lblGlobalAction1Axis, 
	lblGlobalAction2Axis;

	private static JComboBox cbGlobalAction1Min, cbGlobalAction1Max, cbGlobalAction2Max, cbGlobalAction2Min, cbGlobalAction1Axis, cbGlobalAction2Axis;

	private static JPanel panelTrack1 = new JPanel();
	private static JPanel panelTrack2 = new JPanel();
	private static JPanel panelTrack3 = new JPanel();
	private static JPanel panelTrack4 = new JPanel();
	private static JPanel panelTrack5 = new JPanel();
	private static JPanel panelTrack6 = new JPanel();
	private static JPanel panelTrack7 = new JPanel();
	private static JPanel panelTrack8 = new JPanel();
	private static JPanel panelTrack9 = new JPanel();
	private static JPanel panelTrack10 = new JPanel();
	private static JPanel panelTrack11 = new JPanel();
	private static JPanel panelTrack12 = new JPanel();
	private static JPanel panelTrack13 = new JPanel();
	private static JPanel panelTrack14 = new JPanel();
	private static JPanel panelTrack15 = new JPanel();
	private static JPanel panelTrack16 = new JPanel();
	private static JPanel panelGlobal = new JPanel();

	private MIDIInterface midiInterface = new MIDIInterface();
	private JPanel windowPanel = new JPanel();
	private static JTextArea textArea = new JTextArea();
	static MainGUI window;

	private static Color COLOR_BACKGROUND = new Color(240, 240, 240);
	private static Color COLOUR_SELECTED = new Color(179, 224, 255);

	static Settings settings;

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initializeWindow();
		getMidiDevices();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settings = new Settings();
					window = new MainGUI();
					MainGUI.frmGestureControlledMusical.setVisible(true);
					setUpTableData(settings.loadConfigurationTable());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Create a listener and controller
		LeapMotionListener listener = new LeapMotionListener();
		Controller controller = new Controller();

		// Have the listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		System.out.println("Press Enter to quit...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Remove the sample listener when done
		controller.removeListener(listener);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initializeWindow(){

		frmGestureControlledMusical = new JFrame();
		frmGestureControlledMusical.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		frmGestureControlledMusical.setBackground(new Color(0, 0, 128));
		frmGestureControlledMusical.getContentPane().setBackground(Color.BLACK);
		frmGestureControlledMusical.setTitle("Gesture Controlled Musical Conducting");
		frmGestureControlledMusical.setBounds(100, 100, 1190, 965);
		frmGestureControlledMusical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestureControlledMusical.getContentPane().setLayout(null);

		JPanel panelDisplay = new JPanel();
		panelDisplay.setBackground(Color.LIGHT_GRAY);
		panelDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDisplay.setBounds(0, 0, 1185, 44);
		frmGestureControlledMusical.getContentPane().add(panelDisplay);
		panelDisplay.setLayout(null);

		JLabel lblMidiBridge = new JLabel("MIDI Bridge");
		lblMidiBridge.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblMidiBridge.setForeground(Color.BLACK);
		lblMidiBridge.setBounds(24, 13, 76, 16);
		panelDisplay.add(lblMidiBridge);

		midiComboBox = new JComboBox();
		midiComboBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		midiComboBox.setBounds(108, 10, 130, 24);
		panelDisplay.add(midiComboBox);

		JLabel lblLeapMotion = new JLabel("Leap Motion");
		lblLeapMotion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblLeapMotion.setForeground(Color.BLACK);
		lblLeapMotion.setBounds(269, 13, 76, 16);
		panelDisplay.add(lblLeapMotion);

		tfLeapStatus = new JTextField();
		tfLeapStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		tfLeapStatus.setEnabled(false);
		tfLeapStatus.setEditable(false);
		tfLeapStatus.setColumns(10);
		tfLeapStatus.setBounds(352, 10, 87, 22);
		panelDisplay.add(tfLeapStatus);

		JLabel lblSelectedTrack = new JLabel("Selected Track");
		lblSelectedTrack.setForeground(Color.BLACK);
		lblSelectedTrack.setBounds(470, 13, 98, 16);
		panelDisplay.add(lblSelectedTrack);
		lblSelectedTrack.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));

		tfSelectedTrackDigit1 = new JTextField();
		tfSelectedTrackDigit1.setBounds(575, 10, 36, 22);
		panelDisplay.add(tfSelectedTrackDigit1);
		tfSelectedTrackDigit1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		tfSelectedTrackDigit1.setEnabled(true);
		tfSelectedTrackDigit1.setEditable(false);
		tfSelectedTrackDigit1.setColumns(10);

		btnConfiguration = new JButton("Configuration");
		btnConfiguration.setBackground(Color.WHITE);
		btnConfiguration.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnConfiguration.setBounds(1019, 9, 138, 25);
		btnConfiguration.addActionListener(this);
		panelDisplay.add(btnConfiguration);

		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(167, 42, 894, 876);
		frmGestureControlledMusical.getContentPane().add(panelMain);
		panelMain.setLayout(new GridLayout(4, 4, 0, 0)); 

		// Track 1 ---------------------------

		panelMain.add(panelTrack1);
		panelTrack1.setLayout(null);
		panelTrack1.setBorder(new LineBorder(new Color(0, 0, 0)));

		lblTrack1Action7 = new JLabel("");
		lblTrack1Action7.setForeground(Color.BLACK);
		lblTrack1Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action7.setBounds(12, 189, 156, 12);
		panelTrack1.add(lblTrack1Action7);

		JLabel lblTrack1 = new JLabel("---- Track 1 ----");
		lblTrack1.setBackground(Color.WHITE);
		lblTrack1.setForeground(Color.BLACK);
		lblTrack1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack1.setBounds(12, 10, 199, 12);
		panelTrack1.add(lblTrack1);

		lblTrack1Action1 = new JLabel("");
		lblTrack1Action1.setBackground(COLOR_BACKGROUND);
		lblTrack1Action1.setForeground(Color.BLACK);
		lblTrack1Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action1.setBounds(12, 57, 156, 12);
		panelTrack1.add(lblTrack1Action1);

		lblTrack1Action2 = new JLabel("");
		lblTrack1Action2.setForeground(Color.BLACK);
		lblTrack1Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action2.setBounds(12, 79, 156, 12);
		panelTrack1.add(lblTrack1Action2);

		sliderTrack1Action2 = new JSlider();
		sliderTrack1Action2.setForeground(Color.WHITE);
		sliderTrack1Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action2.setBounds(12, 89, 187, 15);
		panelTrack1.add(sliderTrack1Action2);

		lblTrack1Action3 = new JLabel("");
		lblTrack1Action3.setForeground(Color.BLACK);
		lblTrack1Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action3.setBounds(12, 101, 156, 12);
		panelTrack1.add(lblTrack1Action3);

		sliderTrack1Action3 = new JSlider();
		sliderTrack1Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action3.setBounds(12, 111, 187, 15);
		panelTrack1.add(sliderTrack1Action3);

		sliderTrack1Action4 = new JSlider();
		sliderTrack1Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action4.setBounds(12, 133, 187, 15);
		panelTrack1.add(sliderTrack1Action4);

		sliderTrack1Action5 = new JSlider();
		sliderTrack1Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action5.setBounds(12, 155, 187, 15);
		panelTrack1.add(sliderTrack1Action5);

		lblTrack1Action4 = new JLabel("");
		lblTrack1Action4.setForeground(Color.BLACK);
		lblTrack1Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action4.setBounds(12, 123, 156, 12);
		panelTrack1.add(lblTrack1Action4);

		lblTrack1Action6 = new JLabel("");
		lblTrack1Action6.setForeground(Color.BLACK);
		lblTrack1Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action6.setBounds(12, 167, 156, 12);
		panelTrack1.add(lblTrack1Action6);

		lblTrack1Action5 = new JLabel("");
		lblTrack1Action5.setForeground(Color.BLACK);
		lblTrack1Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack1Action5.setBounds(12, 145, 156, 12);
		panelTrack1.add(lblTrack1Action5);

		JLabel lblChannelTrack1 = new JLabel("Channel");
		lblChannelTrack1.setForeground(Color.BLACK);
		lblChannelTrack1.setBounds(109, 33, 59, 20);
		panelTrack1.add(lblChannelTrack1);
		lblChannelTrack1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack1 = new JComboBox(Strings.getChannels());
		cbChannelTrack1.setBounds(158, 33, 40, 20);
		panelTrack1.add(cbChannelTrack1);
		cbChannelTrack1.setSelectedIndex(settings.getTrackChannel(1));
		cbChannelTrack1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack1.addActionListener(this);

		tfAxisTrack1 = new JTextField();
		tfAxisTrack1.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack1.setEnabled(true);
		tfAxisTrack1.setEditable(false);
		tfAxisTrack1.setColumns(10);
		tfAxisTrack1.setBounds(60, 33, 30, 20);
		panelTrack1.add(tfAxisTrack1);

		JLabel lblChannelaxisTrack1 = new JLabel("Axis");
		lblChannelaxisTrack1.setForeground(Color.BLACK);
		lblChannelaxisTrack1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack1.setBounds(30, 33, 29, 20);
		panelTrack1.add(lblChannelaxisTrack1);

		sliderTrack1Action1 = new JSlider();
		sliderTrack1Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action1.setBounds(12, 67, 187, 15);
		panelTrack1.add(sliderTrack1Action1);

		btnOpenTrack1Action7 = new JButton("-");
		btnOpenTrack1Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack1Action7.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action7);

		btnOpenTrack1Action6 = new JButton("-");
		btnOpenTrack1Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack1Action6.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action6);

		btnOpenTrack1Action5 = new JButton("-");
		btnOpenTrack1Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack1Action5.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action5);

		btnOpenTrack1Action4 = new JButton("-");
		btnOpenTrack1Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack1Action4.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action4);

		btnOpenTrack1Action3 = new JButton("-");
		btnOpenTrack1Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack1Action3.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action3);

		btnOpenTrack1Action2 = new JButton("-");
		btnOpenTrack1Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack1Action2.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action2);

		btnOpenTrack1Action1 = new JButton("-");
		btnOpenTrack1Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack1Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack1Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack1Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack1Action1.addActionListener(this);
		panelTrack1.add(btnOpenTrack1Action1);

		sliderTrack1Action7 = new JSlider();
		sliderTrack1Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action7.setBounds(12, 199, 187, 15);
		panelTrack1.add(sliderTrack1Action7);

		sliderTrack1Action6 = new JSlider();
		sliderTrack1Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack1Action6.setBounds(12, 178, 187, 15);
		panelTrack1.add(sliderTrack1Action6);

		// Track 2 ---------------------------

		panelTrack2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMain.add(panelTrack2);
		panelTrack2.setLayout(null);

		JLabel lblTrack2 = new JLabel("---- Track 2 ----");
		lblTrack2.setBackground(Color.WHITE);
		lblTrack2.setForeground(Color.BLACK);
		lblTrack2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack2.setBounds(12, 10, 199, 12);
		panelTrack2.add(lblTrack2);

		lblTrack2Action1 = new JLabel("");
		lblTrack2Action1.setBackground(COLOR_BACKGROUND);
		lblTrack2Action1.setForeground(Color.BLACK);
		lblTrack2Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action1.setBounds(12, 57, 156, 12);
		panelTrack2.add(lblTrack2Action1);

		lblTrack2Action7 = new JLabel("");
		lblTrack2Action7.setForeground(Color.BLACK);
		lblTrack2Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action7.setBounds(12, 189, 156, 12);
		panelTrack2.add(lblTrack2Action7);

		lblTrack2Action2 = new JLabel("");
		lblTrack2Action2.setForeground(Color.BLACK);
		lblTrack2Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action2.setBounds(12, 79, 156, 12);
		panelTrack2.add(lblTrack2Action2);

		sliderTrack2Action2 = new JSlider();
		sliderTrack2Action2.setForeground(Color.WHITE);
		sliderTrack2Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action2.setBounds(12, 89, 187, 15);
		panelTrack2.add(sliderTrack2Action2);

		lblTrack2Action3 = new JLabel("");
		lblTrack2Action3.setForeground(Color.BLACK);
		lblTrack2Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action3.setBounds(12, 101, 156, 12);
		panelTrack2.add(lblTrack2Action3);

		sliderTrack2Action3 = new JSlider();
		sliderTrack2Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action3.setBounds(12, 111, 187, 15);
		panelTrack2.add(sliderTrack2Action3);

		sliderTrack2Action4 = new JSlider();
		sliderTrack2Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action4.setBounds(12, 133, 187, 15);
		panelTrack2.add(sliderTrack2Action4);

		sliderTrack2Action5 = new JSlider();
		sliderTrack2Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action5.setBounds(12, 155, 187, 15);
		panelTrack2.add(sliderTrack2Action5);

		sliderTrack2Action6 = new JSlider();
		sliderTrack2Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action6.setBounds(12, 178, 187, 15);
		panelTrack2.add(sliderTrack2Action6);

		sliderTrack2Action7 = new JSlider();
		sliderTrack2Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action7.setBounds(12, 199, 187, 15);
		panelTrack2.add(sliderTrack2Action7);

		lblTrack2Action4 = new JLabel("");
		lblTrack2Action4.setForeground(Color.BLACK);
		lblTrack2Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action4.setBounds(12, 123, 156, 12);
		panelTrack2.add(lblTrack2Action4);

		lblTrack2Action6 = new JLabel("");
		lblTrack2Action6.setForeground(Color.BLACK);
		lblTrack2Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action6.setBounds(12, 167, 156, 12);
		panelTrack2.add(lblTrack2Action6);

		lblTrack2Action5 = new JLabel("");
		lblTrack2Action5.setForeground(Color.BLACK);
		lblTrack2Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack2Action5.setBounds(12, 145, 156, 12);
		panelTrack2.add(lblTrack2Action5);

		JLabel lblChannelTrack2 = new JLabel("Channel");
		lblChannelTrack2.setForeground(Color.BLACK);
		lblChannelTrack2.setBounds(109, 33, 59, 20);
		panelTrack2.add(lblChannelTrack2);
		lblChannelTrack2.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack2 = new JComboBox(Strings.getChannels());
		cbChannelTrack2.setBounds(158, 33, 40, 20);
		panelTrack2.add(cbChannelTrack2);
		cbChannelTrack2.setSelectedIndex(settings.getTrackChannel(2));
		cbChannelTrack2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack2.addActionListener(this);

		tfAxisTrack2 = new JTextField();
		tfAxisTrack2.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack2.setEnabled(true);
		tfAxisTrack2.setEditable(false);
		tfAxisTrack2.setColumns(10);
		tfAxisTrack2.setBounds(60, 33, 30, 20);
		panelTrack2.add(tfAxisTrack2);

		JLabel lblChannelaxisTrack2 = new JLabel("Axis");
		lblChannelaxisTrack2.setForeground(Color.BLACK);
		lblChannelaxisTrack2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack2.setBounds(30, 33, 29, 20);
		panelTrack2.add(lblChannelaxisTrack2);

		sliderTrack2Action1 = new JSlider();
		sliderTrack2Action1.setForeground(Color.WHITE);
		sliderTrack2Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack2Action1.setBounds(12, 67, 187, 15);
		panelTrack2.add(sliderTrack2Action1);

		btnOpenTrack2Action7 = new JButton("-");
		btnOpenTrack2Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack2Action7.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action7);

		btnOpenTrack2Action6 = new JButton("-");
		btnOpenTrack2Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack2Action6.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action6);

		btnOpenTrack2Action5 = new JButton("-");
		btnOpenTrack2Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack2Action5.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action5);

		btnOpenTrack2Action4 = new JButton("-");
		btnOpenTrack2Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack2Action4.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action4);

		btnOpenTrack2Action3 = new JButton("-");
		btnOpenTrack2Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack2Action3.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action3);

		btnOpenTrack2Action2 = new JButton("-");
		btnOpenTrack2Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack2Action2.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action2);

		btnOpenTrack2Action1 = new JButton("-");
		btnOpenTrack2Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack2Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack2Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack2Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack2Action1.addActionListener(this);
		panelTrack2.add(btnOpenTrack2Action1);

		// Track 3 ---------------------------

		panelTrack3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMain.add(panelTrack3);
		panelTrack3.setLayout(null);

		JLabel lblTrack3 = new JLabel("---- Track 3 ----");
		lblTrack3.setBackground(Color.WHITE);
		lblTrack3.setForeground(Color.BLACK);
		lblTrack3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack3.setBounds(12, 10, 199, 12);
		panelTrack3.add(lblTrack3);

		lblTrack3Action1 = new JLabel("");
		lblTrack3Action1.setBackground(COLOR_BACKGROUND);
		lblTrack3Action1.setForeground(Color.BLACK);
		lblTrack3Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action1.setBounds(12, 57, 156, 12);
		panelTrack3.add(lblTrack3Action1);

		lblTrack3Action7 = new JLabel("");
		lblTrack3Action7.setForeground(Color.BLACK);
		lblTrack3Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action7.setBounds(12, 189, 156, 12);
		panelTrack3.add(lblTrack3Action7);

		lblTrack3Action2 = new JLabel("");
		lblTrack3Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action2.setForeground(Color.BLACK);
		lblTrack3Action2.setBounds(12, 79, 156, 12);
		panelTrack3.add(lblTrack3Action2);

		sliderTrack3Action2 = new JSlider();
		sliderTrack3Action2.setForeground(Color.WHITE);
		sliderTrack3Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action2.setBounds(12, 89, 187, 15);
		panelTrack3.add(sliderTrack3Action2);

		lblTrack3Action3 = new JLabel("");
		lblTrack3Action3.setForeground(Color.BLACK);
		lblTrack3Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action3.setBounds(12, 101, 156, 12);
		panelTrack3.add(lblTrack3Action3);

		sliderTrack3Action3 = new JSlider();
		sliderTrack3Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action3.setBounds(12, 111, 187, 15);
		panelTrack3.add(sliderTrack3Action3);

		sliderTrack3Action4 = new JSlider();
		sliderTrack3Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action4.setBounds(12, 133, 187, 15);
		panelTrack3.add(sliderTrack3Action4);

		sliderTrack3Action5 = new JSlider();
		sliderTrack3Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action5.setBounds(12, 155, 187, 15);
		panelTrack3.add(sliderTrack3Action5);

		sliderTrack3Action6 = new JSlider();
		sliderTrack3Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action6.setBounds(12, 178, 187, 15);
		panelTrack3.add(sliderTrack3Action6);

		sliderTrack3Action7 = new JSlider();
		sliderTrack3Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action7.setBounds(12, 199, 187, 15);
		panelTrack3.add(sliderTrack3Action7);

		lblTrack3Action4 = new JLabel("");
		lblTrack3Action4.setForeground(Color.BLACK);
		lblTrack3Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action4.setBounds(12, 123, 156, 12);
		panelTrack3.add(lblTrack3Action4);

		lblTrack3Action6 = new JLabel("");
		lblTrack3Action6.setForeground(Color.BLACK);
		lblTrack3Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action6.setBounds(12, 167, 156, 12);
		panelTrack3.add(lblTrack3Action6);

		lblTrack3Action5 = new JLabel("");
		lblTrack3Action5.setForeground(Color.BLACK);
		lblTrack3Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack3Action5.setBounds(12, 145, 156, 12);
		panelTrack3.add(lblTrack3Action5);

		JLabel lblChannelTrack3 = new JLabel("Channel");
		lblChannelTrack3.setForeground(Color.BLACK);
		lblChannelTrack3.setBounds(109, 33, 59, 20);
		panelTrack3.add(lblChannelTrack3);
		lblChannelTrack3.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack3 = new JComboBox(Strings.getChannels());
		cbChannelTrack3.setBounds(158, 33, 40, 20);
		panelTrack3.add(cbChannelTrack3);
		cbChannelTrack3.setSelectedIndex(settings.getTrackChannel(3));
		cbChannelTrack3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack3.addActionListener(this);

		tfAxisTrack3 = new JTextField();
		tfAxisTrack3.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack3.setEnabled(true);
		tfAxisTrack3.setEditable(false);
		tfAxisTrack3.setColumns(10);
		tfAxisTrack3.setBounds(60, 33, 30, 20);
		panelTrack3.add(tfAxisTrack3);

		JLabel lblChannelaxisTrack3 = new JLabel("Axis");
		lblChannelaxisTrack3.setForeground(Color.BLACK);
		lblChannelaxisTrack3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack3.setBounds(30, 33, 29, 20);
		panelTrack3.add(lblChannelaxisTrack3);

		sliderTrack3Action1 = new JSlider();
		sliderTrack3Action1.setForeground(Color.WHITE);
		sliderTrack3Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack3Action1.setBounds(12, 67, 187, 15);
		panelTrack3.add(sliderTrack3Action1);

		btnOpenTrack3Action7 = new JButton("-");
		btnOpenTrack3Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack3Action7.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action7);

		btnOpenTrack3Action6 = new JButton("-");
		btnOpenTrack3Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack3Action6.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action6);

		btnOpenTrack3Action5 = new JButton("-");
		btnOpenTrack3Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack3Action5.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action5);

		btnOpenTrack3Action4 = new JButton("-");
		btnOpenTrack3Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack3Action4.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action4);

		btnOpenTrack3Action3 = new JButton("-");
		btnOpenTrack3Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack3Action3.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action3);

		btnOpenTrack3Action2 = new JButton("-");
		btnOpenTrack3Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack3Action2.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action2);

		btnOpenTrack3Action1 = new JButton("-");
		btnOpenTrack3Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack3Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack3Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack3Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack3Action1.addActionListener(this);
		panelTrack3.add(btnOpenTrack3Action1);


		// Track 4 ---------------------------

		panelMain.add(panelTrack4);
		panelTrack4.setLayout(null);
		panelTrack4.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack4 = new JLabel("---- Track 4 ----");
		lblTrack4.setBackground(Color.WHITE);
		lblTrack4.setForeground(Color.BLACK);
		lblTrack4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack4.setBounds(12, 10, 199, 12);
		panelTrack4.add(lblTrack4);

		lblTrack4Action1 = new JLabel("");
		lblTrack4Action1.setBackground(COLOR_BACKGROUND);
		lblTrack4Action1.setForeground(Color.BLACK);
		lblTrack4Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action1.setBounds(12, 57, 156, 12);
		panelTrack4.add(lblTrack4Action1);

		lblTrack4Action7 = new JLabel("");
		lblTrack4Action7.setForeground(Color.BLACK);
		lblTrack4Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action7.setBounds(12, 189, 156, 12);
		panelTrack4.add(lblTrack4Action7);

		lblTrack4Action2 = new JLabel("");
		lblTrack4Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action2.setForeground(Color.BLACK);
		lblTrack4Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action2.setBounds(12, 79, 156, 12);
		panelTrack4.add(lblTrack4Action2);

		sliderTrack4Action2 = new JSlider();
		sliderTrack4Action2.setForeground(Color.WHITE);
		sliderTrack4Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action2.setBounds(12, 89, 187, 15);
		panelTrack4.add(sliderTrack4Action2);

		lblTrack4Action3 = new JLabel("");
		lblTrack4Action3.setForeground(Color.BLACK);
		lblTrack4Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action3.setBounds(12, 101, 156, 12);
		panelTrack4.add(lblTrack4Action3);

		sliderTrack4Action3 = new JSlider();
		sliderTrack4Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action3.setBounds(12, 111, 187, 15);
		panelTrack4.add(sliderTrack4Action3);

		sliderTrack4Action4 = new JSlider();
		sliderTrack4Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action4.setBounds(12, 133, 187, 15);
		panelTrack4.add(sliderTrack4Action4);

		sliderTrack4Action5 = new JSlider();
		sliderTrack4Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action5.setBounds(12, 155, 187, 15);
		panelTrack4.add(sliderTrack4Action5);

		sliderTrack4Action6 = new JSlider();
		sliderTrack4Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action6.setBounds(12, 178, 187, 15);
		panelTrack4.add(sliderTrack4Action6);

		sliderTrack4Action7 = new JSlider();
		sliderTrack4Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action7.setBounds(12, 199, 187, 15);
		panelTrack4.add(sliderTrack4Action7);

		lblTrack4Action4 = new JLabel("");
		lblTrack4Action4.setForeground(Color.BLACK);
		lblTrack4Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action4.setBounds(12, 123, 156, 12);
		panelTrack4.add(lblTrack4Action4);

		lblTrack4Action6 = new JLabel("");
		lblTrack4Action6.setForeground(Color.BLACK);
		lblTrack4Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action6.setBounds(12, 167, 156, 12);
		panelTrack4.add(lblTrack4Action6);

		lblTrack4Action5 = new JLabel("");
		lblTrack4Action5.setForeground(Color.BLACK);
		lblTrack4Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack4Action5.setBounds(12, 145, 156, 12);
		panelTrack4.add(lblTrack4Action5);

		JLabel lblChannelTrack4 = new JLabel("Channel");
		lblChannelTrack4.setForeground(Color.BLACK);
		lblChannelTrack4.setBounds(109, 33, 59, 20);
		panelTrack4.add(lblChannelTrack4);
		lblChannelTrack4.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack4 = new JComboBox(Strings.getChannels());
		cbChannelTrack4.setBounds(158, 33, 40, 20);
		panelTrack4.add(cbChannelTrack4);
		cbChannelTrack4.setSelectedIndex(settings.getTrackChannel(4));
		cbChannelTrack4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack4.addActionListener(this);

		tfAxisTrack4 = new JTextField();
		tfAxisTrack4.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack4.setEnabled(true);
		tfAxisTrack4.setEditable(false);
		tfAxisTrack4.setColumns(10);
		tfAxisTrack4.setBounds(60, 33, 30, 20);
		panelTrack4.add(tfAxisTrack4);

		JLabel lblChannelaxisTrack4 = new JLabel("Axis");
		lblChannelaxisTrack4.setForeground(Color.BLACK);
		lblChannelaxisTrack4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack4.setBounds(30, 33, 29, 20);
		panelTrack4.add(lblChannelaxisTrack4);

		sliderTrack4Action1 = new JSlider();
		sliderTrack4Action1.setForeground(Color.WHITE);
		sliderTrack4Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack4Action1.setBounds(12, 67, 187, 15);
		panelTrack4.add(sliderTrack4Action1);

		btnOpenTrack4Action7 = new JButton("-");
		btnOpenTrack4Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack4Action7.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action7);

		btnOpenTrack4Action6 = new JButton("-");
		btnOpenTrack4Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack4Action6.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action6);

		btnOpenTrack4Action5 = new JButton("-");
		btnOpenTrack4Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack4Action5.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action5);

		btnOpenTrack4Action4 = new JButton("-");
		btnOpenTrack4Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack4Action4.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action4);

		btnOpenTrack4Action3 = new JButton("-");
		btnOpenTrack4Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack4Action3.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action3);

		btnOpenTrack4Action2 = new JButton("-");
		btnOpenTrack4Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack4Action2.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action2);

		btnOpenTrack4Action1 = new JButton("-");
		btnOpenTrack4Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack4Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack4Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack4Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack4Action1.addActionListener(this);
		panelTrack4.add(btnOpenTrack4Action1);

		// Track 5 ---------------------------

		panelMain.add(panelTrack5);
		panelTrack5.setLayout(null);
		panelTrack5.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack5 = new JLabel("---- Track 5 ----");
		lblTrack5.setBackground(Color.WHITE);
		lblTrack5.setForeground(Color.BLACK);
		lblTrack5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack5.setBounds(12, 10, 199, 12);
		panelTrack5.add(lblTrack5);

		lblTrack5Action1 = new JLabel("");
		lblTrack5Action1.setBackground(COLOR_BACKGROUND);
		lblTrack5Action1.setForeground(Color.BLACK);
		lblTrack5Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action1.setBounds(12, 57, 156, 12);
		panelTrack5.add(lblTrack5Action1);

		lblTrack5Action7 = new JLabel("");
		lblTrack5Action7.setForeground(Color.BLACK);
		lblTrack5Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action7.setBounds(12, 189, 156, 12);
		panelTrack5.add(lblTrack5Action7);

		lblTrack5Action2 = new JLabel("");
		lblTrack5Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action2.setForeground(Color.BLACK);
		lblTrack5Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action2.setBounds(12, 79, 156, 12);
		panelTrack5.add(lblTrack5Action2);

		sliderTrack5Action2 = new JSlider();
		sliderTrack5Action2.setForeground(Color.WHITE);
		sliderTrack5Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action2.setBounds(12, 89, 187, 15);
		panelTrack5.add(sliderTrack5Action2);

		lblTrack5Action3 = new JLabel("");
		lblTrack5Action3.setForeground(Color.BLACK);
		lblTrack5Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action3.setBounds(12, 101, 156, 12);
		panelTrack5.add(lblTrack5Action3);

		sliderTrack5Action3 = new JSlider();
		sliderTrack5Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action3.setBounds(12, 111, 187, 15);
		panelTrack5.add(sliderTrack5Action3);

		sliderTrack5Action4 = new JSlider();
		sliderTrack5Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action4.setBounds(12, 133, 187, 15);
		panelTrack5.add(sliderTrack5Action4);

		sliderTrack5Action5 = new JSlider();
		sliderTrack5Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action5.setBounds(12, 155, 187, 15);
		panelTrack5.add(sliderTrack5Action5);

		sliderTrack5Action6 = new JSlider();
		sliderTrack5Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action6.setBounds(12, 178, 187, 15);
		panelTrack5.add(sliderTrack5Action6);

		sliderTrack5Action7 = new JSlider();
		sliderTrack5Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action7.setBounds(12, 199, 187, 15);
		panelTrack5.add(sliderTrack5Action7);

		lblTrack5Action4 = new JLabel("");
		lblTrack5Action4.setForeground(Color.BLACK);
		lblTrack5Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action4.setBounds(12, 123, 156, 12);
		panelTrack5.add(lblTrack5Action4);

		lblTrack5Action6 = new JLabel("");
		lblTrack5Action6.setForeground(Color.BLACK);
		lblTrack5Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action6.setBounds(12, 167, 156, 12);
		panelTrack5.add(lblTrack5Action6);

		lblTrack5Action5 = new JLabel("");
		lblTrack5Action5.setForeground(Color.BLACK);
		lblTrack5Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack5Action5.setBounds(12, 145, 156, 12);
		panelTrack5.add(lblTrack5Action5);

		JLabel lblChannelTrack5 = new JLabel("Channel");
		lblChannelTrack5.setForeground(Color.BLACK);
		lblChannelTrack5.setBounds(109, 33, 59, 20);
		panelTrack5.add(lblChannelTrack5);
		lblChannelTrack5.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack5 = new JComboBox(Strings.getChannels());
		cbChannelTrack5.setBounds(158, 33, 40, 20);
		panelTrack5.add(cbChannelTrack5);
		cbChannelTrack5.setSelectedIndex(settings.getTrackChannel(5));
		cbChannelTrack5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack5.addActionListener(this);

		tfAxisTrack5 = new JTextField();
		tfAxisTrack5.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack5.setEnabled(true);
		tfAxisTrack5.setEditable(false);
		tfAxisTrack5.setColumns(10);
		tfAxisTrack5.setBounds(60, 33, 30, 20);
		panelTrack5.add(tfAxisTrack5);

		JLabel lblChannelaxisTrack5 = new JLabel("Axis");
		lblChannelaxisTrack5.setForeground(Color.BLACK);
		lblChannelaxisTrack5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack5.setBounds(30, 33, 29, 20);
		panelTrack5.add(lblChannelaxisTrack5);

		sliderTrack5Action1 = new JSlider();
		sliderTrack5Action1.setForeground(Color.WHITE);
		sliderTrack5Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack5Action1.setBounds(12, 67, 187, 15);
		panelTrack5.add(sliderTrack5Action1);

		btnOpenTrack5Action7 = new JButton("-");
		btnOpenTrack5Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack5Action7.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action7);

		btnOpenTrack5Action6 = new JButton("-");
		btnOpenTrack5Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack5Action6.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action6);

		btnOpenTrack5Action5 = new JButton("-");
		btnOpenTrack5Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack5Action5.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action5);

		btnOpenTrack5Action4 = new JButton("-");
		btnOpenTrack5Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack5Action4.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action4);

		btnOpenTrack5Action3 = new JButton("-");
		btnOpenTrack5Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack5Action3.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action3);

		btnOpenTrack5Action2 = new JButton("-");
		btnOpenTrack5Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack5Action2.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action2);

		btnOpenTrack5Action1 = new JButton("-");
		btnOpenTrack5Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack5Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack5Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack5Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack5Action1.addActionListener(this);
		panelTrack5.add(btnOpenTrack5Action1);

		// Track 6 ---------------------------

		panelMain.add(panelTrack6);
		panelTrack6.setLayout(null);
		panelTrack6.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack6 = new JLabel("---- Track 6 ----");
		lblTrack6.setBackground(Color.WHITE);
		lblTrack6.setForeground(Color.BLACK);
		lblTrack6.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack6.setBounds(12, 10, 199, 12);
		panelTrack6.add(lblTrack6);

		lblTrack6Action1 = new JLabel("");
		lblTrack6Action1.setBackground(COLOR_BACKGROUND);
		lblTrack6Action1.setForeground(Color.BLACK);
		lblTrack6Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action1.setBounds(12, 57, 156, 12);
		panelTrack6.add(lblTrack6Action1);

		lblTrack6Action7 = new JLabel("");
		lblTrack6Action7.setForeground(Color.BLACK);
		lblTrack6Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action7.setBounds(12, 189, 156, 12);
		panelTrack6.add(lblTrack6Action7);

		lblTrack6Action2 = new JLabel("");
		lblTrack6Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action2.setForeground(Color.BLACK);
		lblTrack6Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action2.setBounds(12, 79, 156, 12);
		panelTrack6.add(lblTrack6Action2);

		sliderTrack6Action2 = new JSlider();
		sliderTrack6Action2.setForeground(Color.WHITE);
		sliderTrack6Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action2.setBounds(12, 89, 187, 15);
		panelTrack6.add(sliderTrack6Action2);

		lblTrack6Action3 = new JLabel("");
		lblTrack6Action3.setForeground(Color.BLACK);
		lblTrack6Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action3.setBounds(12, 101, 156, 12);
		panelTrack6.add(lblTrack6Action3);

		sliderTrack6Action3 = new JSlider();
		sliderTrack6Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action3.setBounds(12, 111, 187, 15);
		panelTrack6.add(sliderTrack6Action3);

		sliderTrack6Action4 = new JSlider();
		sliderTrack6Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action4.setBounds(12, 133, 187, 15);
		panelTrack6.add(sliderTrack6Action4);

		sliderTrack6Action5 = new JSlider();
		sliderTrack6Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action5.setBounds(12, 155, 187, 15);
		panelTrack6.add(sliderTrack6Action5);

		sliderTrack6Action6 = new JSlider();
		sliderTrack6Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action6.setBounds(12, 178, 187, 15);
		panelTrack6.add(sliderTrack6Action6);

		sliderTrack6Action7 = new JSlider();
		sliderTrack6Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action7.setBounds(12, 199, 187, 15);
		panelTrack6.add(sliderTrack6Action7);

		lblTrack6Action4 = new JLabel("");
		lblTrack6Action4.setForeground(Color.BLACK);
		lblTrack6Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action4.setBounds(12, 123, 156, 12);
		panelTrack6.add(lblTrack6Action4);

		lblTrack6Action6 = new JLabel("");
		lblTrack6Action6.setForeground(Color.BLACK);
		lblTrack6Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action6.setBounds(12, 167, 156, 12);
		panelTrack6.add(lblTrack6Action6);

		lblTrack6Action5 = new JLabel("");
		lblTrack6Action5.setForeground(Color.BLACK);
		lblTrack6Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack6Action5.setBounds(12, 145, 156, 12);
		panelTrack6.add(lblTrack6Action5);

		JLabel lblChannelTrack6 = new JLabel("Channel");
		lblChannelTrack6.setForeground(Color.BLACK);
		lblChannelTrack6.setBounds(109, 33, 59, 20);
		panelTrack6.add(lblChannelTrack6);
		lblChannelTrack6.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack6 = new JComboBox(Strings.getChannels());
		cbChannelTrack6.setBounds(158, 33, 40, 20);
		panelTrack6.add(cbChannelTrack6);
		cbChannelTrack6.setSelectedIndex(settings.getTrackChannel(6));
		cbChannelTrack6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack6.addActionListener(this);

		tfAxisTrack6 = new JTextField();
		tfAxisTrack6.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack6.setEnabled(true);
		tfAxisTrack6.setEditable(false);
		tfAxisTrack6.setColumns(10);
		tfAxisTrack6.setBounds(60, 33, 30, 20);
		panelTrack6.add(tfAxisTrack6);

		JLabel lblChannelaxisTrack6 = new JLabel("Axis");
		lblChannelaxisTrack6.setForeground(Color.BLACK);
		lblChannelaxisTrack6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack6.setBounds(30, 33, 29, 20);
		panelTrack6.add(lblChannelaxisTrack6);

		sliderTrack6Action1 = new JSlider();
		sliderTrack6Action1.setForeground(Color.WHITE);
		sliderTrack6Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack6Action1.setBounds(12, 67, 187, 15);
		panelTrack6.add(sliderTrack6Action1);

		btnOpenTrack6Action7 = new JButton("-");
		btnOpenTrack6Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack6Action7.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action7);

		btnOpenTrack6Action6 = new JButton("-");
		btnOpenTrack6Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack6Action6.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action6);

		btnOpenTrack6Action5 = new JButton("-");
		btnOpenTrack6Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack6Action5.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action5);


		btnOpenTrack6Action4 = new JButton("-");
		btnOpenTrack6Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack6Action4.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action4);

		btnOpenTrack6Action3 = new JButton("-");
		btnOpenTrack6Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack6Action3.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action3);

		btnOpenTrack6Action2 = new JButton("-");
		btnOpenTrack6Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack6Action2.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action2);

		btnOpenTrack6Action1 = new JButton("-");
		btnOpenTrack6Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack6Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack6Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack6Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack6Action1.addActionListener(this);
		panelTrack6.add(btnOpenTrack6Action1);

		// Track 7 ---------------------------

		panelMain.add(panelTrack7);
		panelTrack7.setLayout(null);
		panelTrack7.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack7 = new JLabel("---- Track 7 ----");
		lblTrack7.setBackground(Color.WHITE);
		lblTrack7.setForeground(Color.BLACK);
		lblTrack7.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack7.setBounds(12, 10, 199, 12);
		panelTrack7.add(lblTrack7);

		lblTrack7Action1 = new JLabel("");
		lblTrack7Action1.setBackground(COLOR_BACKGROUND);
		lblTrack7Action1.setForeground(Color.BLACK);
		lblTrack7Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action1.setBounds(12, 57, 156, 12);
		panelTrack7.add(lblTrack7Action1);

		lblTrack7Action7 = new JLabel("");
		lblTrack7Action7.setForeground(Color.BLACK);
		lblTrack7Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action7.setBounds(12, 189, 156, 12);
		panelTrack7.add(lblTrack7Action7);

		lblTrack7Action2 = new JLabel("");
		lblTrack7Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action2.setForeground(Color.BLACK);
		lblTrack7Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action2.setBounds(12, 79, 156, 12);
		panelTrack7.add(lblTrack7Action2);

		sliderTrack7Action2 = new JSlider();
		sliderTrack7Action2.setForeground(Color.WHITE);
		sliderTrack7Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action2.setBounds(12, 89, 187, 15);
		panelTrack7.add(sliderTrack7Action2);

		lblTrack7Action3 = new JLabel("");
		lblTrack7Action3.setForeground(Color.BLACK);
		lblTrack7Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action3.setBounds(12, 101, 156, 12);
		panelTrack7.add(lblTrack7Action3);

		sliderTrack7Action3 = new JSlider();
		sliderTrack7Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action3.setBounds(12, 111, 187, 15);
		panelTrack7.add(sliderTrack7Action3);

		sliderTrack7Action4 = new JSlider();
		sliderTrack7Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action4.setBounds(12, 133, 187, 15);
		panelTrack7.add(sliderTrack7Action4);

		sliderTrack7Action5 = new JSlider();
		sliderTrack7Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action5.setBounds(12, 155, 187, 15);
		panelTrack7.add(sliderTrack7Action5);

		sliderTrack7Action6 = new JSlider();
		sliderTrack7Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action6.setBounds(12, 178, 187, 15);
		panelTrack7.add(sliderTrack7Action6);

		sliderTrack7Action7 = new JSlider();
		sliderTrack7Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action7.setBounds(12, 199, 187, 15);
		panelTrack7.add(sliderTrack7Action7);

		lblTrack7Action4 = new JLabel("");
		lblTrack7Action4.setForeground(Color.BLACK);
		lblTrack7Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action4.setBounds(12, 123, 156, 12);
		panelTrack7.add(lblTrack7Action4);

		lblTrack7Action6 = new JLabel("");
		lblTrack7Action6.setForeground(Color.BLACK);
		lblTrack7Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action6.setBounds(12, 167, 156, 12);
		panelTrack7.add(lblTrack7Action6);

		lblTrack7Action5 = new JLabel("");
		lblTrack7Action5.setForeground(Color.BLACK);
		lblTrack7Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack7Action5.setBounds(12, 145, 156, 12);
		panelTrack7.add(lblTrack7Action5);

		JLabel lblChannelTrack7 = new JLabel("Channel");
		lblChannelTrack7.setForeground(Color.BLACK);
		lblChannelTrack7.setBounds(109, 33, 59, 20);
		panelTrack7.add(lblChannelTrack7);
		lblChannelTrack7.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack7 = new JComboBox(Strings.getChannels());
		cbChannelTrack7.setBounds(158, 33, 40, 20);
		panelTrack7.add(cbChannelTrack7);
		cbChannelTrack7.setSelectedIndex(settings.getTrackChannel(7));
		cbChannelTrack7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack7.addActionListener(this);

		tfAxisTrack7 = new JTextField();
		tfAxisTrack7.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack7.setEnabled(true);
		tfAxisTrack7.setEditable(false);
		tfAxisTrack7.setColumns(10);
		tfAxisTrack7.setBounds(60, 33, 30, 20);
		panelTrack7.add(tfAxisTrack7);

		JLabel lblChannelaxisTrack7 = new JLabel("Axis");
		lblChannelaxisTrack7.setForeground(Color.BLACK);
		lblChannelaxisTrack7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack7.setBounds(30, 33, 29, 20);
		panelTrack7.add(lblChannelaxisTrack7);

		sliderTrack7Action1 = new JSlider();
		sliderTrack7Action1.setForeground(Color.WHITE);
		sliderTrack7Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack7Action1.setBounds(12, 67, 187, 15);
		panelTrack7.add(sliderTrack7Action1);

		btnOpenTrack7Action7 = new JButton("-");
		btnOpenTrack7Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack7Action7.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action7);

		btnOpenTrack7Action6 = new JButton("-");
		btnOpenTrack7Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack7Action6.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action6);

		btnOpenTrack7Action5 = new JButton("-");
		btnOpenTrack7Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack7Action5.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action5);

		btnOpenTrack7Action4 = new JButton("-");
		btnOpenTrack7Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack7Action4.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action4);

		btnOpenTrack7Action3 = new JButton("-");
		btnOpenTrack7Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack7Action3.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action3);

		btnOpenTrack7Action2 = new JButton("-");
		btnOpenTrack7Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack7Action2.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action2);

		btnOpenTrack7Action1 = new JButton("-");
		btnOpenTrack7Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack7Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack7Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack7Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack7Action1.addActionListener(this);
		panelTrack7.add(btnOpenTrack7Action1);

		// Track 8 ---------------------------

		panelMain.add(panelTrack8);
		panelTrack8.setLayout(null);
		panelTrack8.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack8 = new JLabel("---- Track 8 ----");
		lblTrack8.setBackground(Color.WHITE);
		lblTrack8.setForeground(Color.BLACK);
		lblTrack8.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack8.setBounds(12, 10, 199, 12);
		panelTrack8.add(lblTrack8);

		lblTrack8Action1 = new JLabel("");
		lblTrack8Action1.setBackground(COLOR_BACKGROUND);
		lblTrack8Action1.setForeground(Color.BLACK);
		lblTrack8Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action1.setBounds(12, 57, 156, 12);
		panelTrack8.add(lblTrack8Action1);

		lblTrack8Action7 = new JLabel("");
		lblTrack8Action7.setForeground(Color.BLACK);
		lblTrack8Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action7.setBounds(12, 189, 156, 12);
		panelTrack8.add(lblTrack8Action7);

		lblTrack8Action2 = new JLabel("");
		lblTrack8Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action2.setForeground(Color.BLACK);
		lblTrack8Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action2.setBounds(12, 79, 156, 12);
		panelTrack8.add(lblTrack8Action2);

		sliderTrack8Action2 = new JSlider();
		sliderTrack8Action2.setForeground(Color.WHITE);
		sliderTrack8Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action2.setBounds(12, 89, 187, 15);
		panelTrack8.add(sliderTrack8Action2);

		lblTrack8Action3 = new JLabel("");
		lblTrack8Action3.setForeground(Color.BLACK);
		lblTrack8Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action3.setBounds(12, 101, 156, 12);
		panelTrack8.add(lblTrack8Action3);

		sliderTrack8Action3 = new JSlider();
		sliderTrack8Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action3.setBounds(12, 111, 187, 15);
		panelTrack8.add(sliderTrack8Action3);

		sliderTrack8Action4 = new JSlider();
		sliderTrack8Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action4.setBounds(12, 133, 187, 15);
		panelTrack8.add(sliderTrack8Action4);

		sliderTrack8Action5 = new JSlider();
		sliderTrack8Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action5.setBounds(12, 155, 187, 15);
		panelTrack8.add(sliderTrack8Action5);

		sliderTrack8Action6 = new JSlider();
		sliderTrack8Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action6.setBounds(12, 178, 187, 15);
		panelTrack8.add(sliderTrack8Action6);

		sliderTrack8Action7 = new JSlider();
		sliderTrack8Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action7.setBounds(12, 199, 187, 15);
		panelTrack8.add(sliderTrack8Action7);

		lblTrack8Action4 = new JLabel("");
		lblTrack8Action4.setForeground(Color.BLACK);
		lblTrack8Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action4.setBounds(12, 123, 156, 12);
		panelTrack8.add(lblTrack8Action4);

		lblTrack8Action6 = new JLabel("");
		lblTrack8Action6.setForeground(Color.BLACK);
		lblTrack8Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action6.setBounds(12, 167, 156, 12);
		panelTrack8.add(lblTrack8Action6);

		lblTrack8Action5 = new JLabel("");
		lblTrack8Action5.setForeground(Color.BLACK);
		lblTrack8Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack8Action5.setBounds(12, 145, 156, 12);
		panelTrack8.add(lblTrack8Action5);

		JLabel lblChannelTrack8 = new JLabel("Channel");
		lblChannelTrack8.setForeground(Color.BLACK);
		lblChannelTrack8.setBounds(109, 33, 59, 20);
		panelTrack8.add(lblChannelTrack8);
		lblChannelTrack8.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack8 = new JComboBox(Strings.getChannels());
		cbChannelTrack8.setBounds(158, 33, 40, 20);
		panelTrack8.add(cbChannelTrack8);
		cbChannelTrack8.setSelectedIndex(settings.getTrackChannel(8));
		cbChannelTrack8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack8.addActionListener(this);

		tfAxisTrack8 = new JTextField();
		tfAxisTrack8.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack8.setEnabled(true);
		tfAxisTrack8.setEditable(false);
		tfAxisTrack8.setColumns(10);
		tfAxisTrack8.setBounds(60, 33, 30, 20);
		panelTrack8.add(tfAxisTrack8);

		JLabel lblChannelaxisTrack8 = new JLabel("Axis");
		lblChannelaxisTrack8.setForeground(Color.BLACK);
		lblChannelaxisTrack8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack8.setBounds(30, 33, 29, 20);
		panelTrack8.add(lblChannelaxisTrack8);

		sliderTrack8Action1 = new JSlider();
		sliderTrack8Action1.setForeground(Color.WHITE);
		sliderTrack8Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack8Action1.setBounds(12, 67, 187, 15);
		panelTrack8.add(sliderTrack8Action1);

		btnOpenTrack8Action7 = new JButton("-");
		btnOpenTrack8Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack8Action7.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action7);

		btnOpenTrack8Action6 = new JButton("-");
		btnOpenTrack8Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack8Action6.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action6);

		btnOpenTrack8Action5 = new JButton("-");
		btnOpenTrack8Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack8Action5.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action5);

		btnOpenTrack8Action4 = new JButton("-");
		btnOpenTrack8Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack8Action4.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action4);

		btnOpenTrack8Action3 = new JButton("-");
		btnOpenTrack8Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack8Action3.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action3);

		btnOpenTrack8Action2 = new JButton("-");
		btnOpenTrack8Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack8Action2.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action2);

		btnOpenTrack8Action1 = new JButton("-");
		btnOpenTrack8Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack8Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack8Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack8Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack8Action1.addActionListener(this);
		panelTrack8.add(btnOpenTrack8Action1);

		// Track 9 ---------------------------

		panelMain.add(panelTrack9);
		panelTrack9.setLayout(null);
		panelTrack9.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack9 = new JLabel("---- Track 9 ----");
		lblTrack9.setBackground(Color.WHITE);
		lblTrack9.setForeground(Color.BLACK);
		lblTrack9.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack9.setBounds(12, 10, 199, 12);
		panelTrack9.add(lblTrack9);

		lblTrack9Action1 = new JLabel("");
		lblTrack9Action1.setBackground(COLOR_BACKGROUND);
		lblTrack9Action1.setForeground(Color.BLACK);
		lblTrack9Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action1.setBounds(12, 57, 156, 12);
		panelTrack9.add(lblTrack9Action1);

		lblTrack9Action7 = new JLabel("");
		lblTrack9Action7.setForeground(Color.BLACK);
		lblTrack9Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action7.setBounds(12, 189, 156, 12);
		panelTrack9.add(lblTrack9Action7);

		lblTrack9Action2 = new JLabel("");
		lblTrack9Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action2.setForeground(Color.BLACK);
		lblTrack9Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action2.setBounds(12, 79, 156, 12);
		panelTrack9.add(lblTrack9Action2);

		sliderTrack9Action2 = new JSlider();
		sliderTrack9Action2.setForeground(Color.WHITE);
		sliderTrack9Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action2.setBounds(12, 89, 187, 15);
		panelTrack9.add(sliderTrack9Action2);

		lblTrack9Action3 = new JLabel("");
		lblTrack9Action3.setForeground(Color.BLACK);
		lblTrack9Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action3.setBounds(12, 101, 156, 12);
		panelTrack9.add(lblTrack9Action3);

		sliderTrack9Action3 = new JSlider();
		sliderTrack9Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action3.setBounds(12, 111, 187, 15);
		panelTrack9.add(sliderTrack9Action3);

		sliderTrack9Action4 = new JSlider();
		sliderTrack9Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action4.setBounds(12, 133, 187, 15);
		panelTrack9.add(sliderTrack9Action4);

		sliderTrack9Action5 = new JSlider();
		sliderTrack9Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action5.setBounds(12, 155, 187, 15);
		panelTrack9.add(sliderTrack9Action5);

		sliderTrack9Action6 = new JSlider();
		sliderTrack9Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action6.setBounds(12, 178, 187, 15);
		panelTrack9.add(sliderTrack9Action6);

		sliderTrack9Action7 = new JSlider();
		sliderTrack9Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action7.setBounds(12, 199, 187, 15);
		panelTrack9.add(sliderTrack9Action7);

		lblTrack9Action4 = new JLabel("");
		lblTrack9Action4.setForeground(Color.BLACK);
		lblTrack9Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action4.setBounds(12, 123, 156, 12);
		panelTrack9.add(lblTrack9Action4);

		lblTrack9Action6 = new JLabel("");
		lblTrack9Action6.setForeground(Color.BLACK);
		lblTrack9Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action6.setBounds(12, 167, 156, 12);
		panelTrack9.add(lblTrack9Action6);

		lblTrack9Action5 = new JLabel("");
		lblTrack9Action5.setForeground(Color.BLACK);
		lblTrack9Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack9Action5.setBounds(12, 145, 156, 12);
		panelTrack9.add(lblTrack9Action5);

		JLabel lblChannelTrack9 = new JLabel("Channel");
		lblChannelTrack9.setForeground(Color.BLACK);
		lblChannelTrack9.setBounds(109, 33, 59, 20);
		panelTrack9.add(lblChannelTrack9);
		lblChannelTrack9.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack9 = new JComboBox(Strings.getChannels());
		cbChannelTrack9.setBounds(158, 33, 40, 20);
		panelTrack9.add(cbChannelTrack9);
		cbChannelTrack9.setSelectedIndex(settings.getTrackChannel(9));
		cbChannelTrack9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack9.addActionListener(this);

		tfAxisTrack9 = new JTextField();
		tfAxisTrack9.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack9.setEnabled(true);
		tfAxisTrack9.setEditable(false);
		tfAxisTrack9.setColumns(10);
		tfAxisTrack9.setBounds(60, 33, 30, 20);
		panelTrack9.add(tfAxisTrack9);

		JLabel lblChannelaxisTrack9 = new JLabel("Axis");
		lblChannelaxisTrack9.setForeground(Color.BLACK);
		lblChannelaxisTrack9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack9.setBounds(30, 33, 29, 20);
		panelTrack9.add(lblChannelaxisTrack9);

		sliderTrack9Action1 = new JSlider();
		sliderTrack9Action1.setForeground(Color.WHITE);
		sliderTrack9Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack9Action1.setBounds(12, 67, 187, 15);
		panelTrack9.add(sliderTrack9Action1);

		btnOpenTrack9Action7 = new JButton("-");
		btnOpenTrack9Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack9Action7.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action7);

		btnOpenTrack9Action6 = new JButton("-");
		btnOpenTrack9Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack9Action6.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action6);

		btnOpenTrack9Action5 = new JButton("-");
		btnOpenTrack9Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack9Action5.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action5);

		btnOpenTrack9Action4 = new JButton("-");
		btnOpenTrack9Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack9Action4.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action4);

		btnOpenTrack9Action3 = new JButton("-");
		btnOpenTrack9Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack9Action3.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action3);

		btnOpenTrack9Action2 = new JButton("-");
		btnOpenTrack9Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack9Action2.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action2);

		btnOpenTrack9Action1 = new JButton("-");
		btnOpenTrack9Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack9Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack9Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack9Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack9Action1.addActionListener(this);
		panelTrack9.add(btnOpenTrack9Action1);

		// Track 10 ---------------------------

		panelMain.add(panelTrack10);
		panelTrack10.setLayout(null);
		panelTrack10.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack10 = new JLabel("---- Track 10 ----");
		lblTrack10.setBackground(Color.WHITE);
		lblTrack10.setForeground(Color.BLACK);
		lblTrack10.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack10.setBounds(12, 10, 199, 12);
		panelTrack10.add(lblTrack10);

		lblTrack10Action1 = new JLabel("");
		lblTrack10Action1.setBackground(COLOR_BACKGROUND);
		lblTrack10Action1.setForeground(Color.BLACK);
		lblTrack10Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action1.setBounds(12, 57, 156, 12);
		panelTrack10.add(lblTrack10Action1);

		lblTrack10Action7 = new JLabel("");
		lblTrack10Action7.setForeground(Color.BLACK);
		lblTrack10Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action7.setBounds(12, 189, 156, 12);
		panelTrack10.add(lblTrack10Action7);

		lblTrack10Action2 = new JLabel("");
		lblTrack10Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action2.setForeground(Color.BLACK);
		lblTrack10Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action2.setBounds(12, 79, 156, 12);
		panelTrack10.add(lblTrack10Action2);

		sliderTrack10Action2 = new JSlider();
		sliderTrack10Action2.setForeground(Color.WHITE);
		sliderTrack10Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action2.setBounds(12, 89, 187, 15);
		panelTrack10.add(sliderTrack10Action2);

		lblTrack10Action3 = new JLabel("");
		lblTrack10Action3.setForeground(Color.BLACK);
		lblTrack10Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action3.setBounds(12, 101, 156, 12);
		panelTrack10.add(lblTrack10Action3);

		sliderTrack10Action3 = new JSlider();
		sliderTrack10Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action3.setBounds(12, 111, 187, 15);
		panelTrack10.add(sliderTrack10Action3);

		sliderTrack10Action4 = new JSlider();
		sliderTrack10Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action4.setBounds(12, 133, 187, 15);
		panelTrack10.add(sliderTrack10Action4);

		sliderTrack10Action5 = new JSlider();
		sliderTrack10Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action5.setBounds(12, 155, 187, 15);
		panelTrack10.add(sliderTrack10Action5);

		sliderTrack10Action6 = new JSlider();
		sliderTrack10Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action6.setBounds(12, 178, 187, 15);
		panelTrack10.add(sliderTrack10Action6);

		sliderTrack10Action7 = new JSlider();
		sliderTrack10Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action7.setBounds(12, 199, 187, 15);
		panelTrack10.add(sliderTrack10Action7);

		lblTrack10Action4 = new JLabel("");
		lblTrack10Action4.setForeground(Color.BLACK);
		lblTrack10Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action4.setBounds(12, 123, 156, 12);
		panelTrack10.add(lblTrack10Action4);

		lblTrack10Action6 = new JLabel("");
		lblTrack10Action6.setForeground(Color.BLACK);
		lblTrack10Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action6.setBounds(12, 167, 156, 12);
		panelTrack10.add(lblTrack10Action6);

		lblTrack10Action5 = new JLabel("");
		lblTrack10Action5.setForeground(Color.BLACK);
		lblTrack10Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack10Action5.setBounds(12, 145, 156, 12);
		panelTrack10.add(lblTrack10Action5);

		JLabel lblChannelTrack10 = new JLabel("Channel");
		lblChannelTrack10.setForeground(Color.BLACK);
		lblChannelTrack10.setBounds(109, 33, 59, 20);
		panelTrack10.add(lblChannelTrack10);
		lblChannelTrack10.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack10 = new JComboBox(Strings.getChannels());
		cbChannelTrack10.setBounds(158, 33, 40, 20);
		panelTrack10.add(cbChannelTrack10);
		cbChannelTrack10.setSelectedIndex(settings.getTrackChannel(10));
		cbChannelTrack10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack10.addActionListener(this);

		tfAxisTrack10 = new JTextField();
		tfAxisTrack10.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack10.setEnabled(true);
		tfAxisTrack10.setEditable(false);
		tfAxisTrack10.setColumns(10);
		tfAxisTrack10.setBounds(60, 33, 30, 20);
		panelTrack10.add(tfAxisTrack10);

		JLabel lblChannelaxisTrack10 = new JLabel("Axis");
		lblChannelaxisTrack10.setForeground(Color.BLACK);
		lblChannelaxisTrack10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack10.setBounds(30, 33, 29, 20);
		panelTrack10.add(lblChannelaxisTrack10);

		sliderTrack10Action1 = new JSlider();
		sliderTrack10Action1.setForeground(Color.WHITE);
		sliderTrack10Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack10Action1.setBounds(12, 67, 187, 15);
		panelTrack10.add(sliderTrack10Action1);

		btnOpenTrack10Action7 = new JButton("-");
		btnOpenTrack10Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack10Action7.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action7);

		btnOpenTrack10Action6 = new JButton("-");
		btnOpenTrack10Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack10Action6.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action6);

		btnOpenTrack10Action5 = new JButton("-");
		btnOpenTrack10Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack10Action5.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action5);

		btnOpenTrack10Action4 = new JButton("-");
		btnOpenTrack10Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack10Action4.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action4);

		btnOpenTrack10Action3 = new JButton("-");
		btnOpenTrack10Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack8Action3.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action3);

		btnOpenTrack10Action2 = new JButton("-");
		btnOpenTrack10Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack10Action2.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action2);

		btnOpenTrack10Action1 = new JButton("-");
		btnOpenTrack10Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack10Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack10Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack10Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack10Action1.addActionListener(this);
		panelTrack10.add(btnOpenTrack10Action1);

		// Track 11 ---------------------------

		panelMain.add(panelTrack11);
		panelTrack11.setLayout(null);
		panelTrack11.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack11 = new JLabel("---- Track 11 ----");
		lblTrack11.setBackground(Color.WHITE);
		lblTrack11.setForeground(Color.BLACK);
		lblTrack11.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack11.setBounds(12, 10, 199, 12);
		panelTrack11.add(lblTrack11);

		lblTrack11Action1 = new JLabel("");
		lblTrack11Action1.setBackground(COLOR_BACKGROUND);
		lblTrack11Action1.setForeground(Color.BLACK);
		lblTrack11Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action1.setBounds(12, 57, 156, 12);
		panelTrack11.add(lblTrack11Action1);

		lblTrack11Action7 = new JLabel("");
		lblTrack11Action7.setForeground(Color.BLACK);
		lblTrack11Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action7.setBounds(12, 189, 156, 12);
		panelTrack11.add(lblTrack11Action7);

		lblTrack11Action2 = new JLabel("");
		lblTrack11Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action2.setForeground(Color.BLACK);
		lblTrack11Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action2.setBounds(12, 79, 156, 12);
		panelTrack11.add(lblTrack11Action2);

		sliderTrack11Action2 = new JSlider();
		sliderTrack11Action2.setForeground(Color.WHITE);
		sliderTrack11Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action2.setBounds(12, 89, 187, 15);
		panelTrack11.add(sliderTrack11Action2);

		lblTrack11Action3 = new JLabel("");
		lblTrack11Action3.setForeground(Color.BLACK);
		lblTrack11Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action3.setBounds(12, 101, 156, 12);
		panelTrack11.add(lblTrack11Action3);

		sliderTrack11Action3 = new JSlider();
		sliderTrack11Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action3.setBounds(12, 111, 187, 15);
		panelTrack11.add(sliderTrack11Action3);

		sliderTrack11Action4 = new JSlider();
		sliderTrack11Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action4.setBounds(12, 133, 187, 15);
		panelTrack11.add(sliderTrack11Action4);

		sliderTrack11Action5 = new JSlider();
		sliderTrack11Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action5.setBounds(12, 155, 187, 15);
		panelTrack11.add(sliderTrack11Action5);

		sliderTrack11Action6 = new JSlider();
		sliderTrack11Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action6.setBounds(12, 178, 187, 15);
		panelTrack11.add(sliderTrack11Action6);

		sliderTrack11Action7 = new JSlider();
		sliderTrack11Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action7.setBounds(12, 199, 187, 15);
		panelTrack11.add(sliderTrack11Action7);

		lblTrack11Action4 = new JLabel("");
		lblTrack11Action4.setForeground(Color.BLACK);
		lblTrack11Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action4.setBounds(12, 123, 156, 12);
		panelTrack11.add(lblTrack11Action4);

		lblTrack11Action6 = new JLabel("");
		lblTrack11Action6.setForeground(Color.BLACK);
		lblTrack11Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action6.setBounds(12, 167, 156, 12);
		panelTrack11.add(lblTrack11Action6);

		lblTrack11Action5 = new JLabel("");
		lblTrack11Action5.setForeground(Color.BLACK);
		lblTrack11Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack11Action5.setBounds(12, 145, 156, 12);
		panelTrack11.add(lblTrack11Action5);

		JLabel lblChannelTrack11 = new JLabel("Channel");
		lblChannelTrack11.setForeground(Color.BLACK);
		lblChannelTrack11.setBounds(109, 33, 59, 20);
		panelTrack11.add(lblChannelTrack11);
		lblChannelTrack11.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack11 = new JComboBox(Strings.getChannels());
		cbChannelTrack11.setBounds(158, 33, 40, 20);
		panelTrack11.add(cbChannelTrack11);
		cbChannelTrack11.setSelectedIndex(settings.getTrackChannel(11));
		cbChannelTrack11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack11.addActionListener(this);

		tfAxisTrack11 = new JTextField();
		tfAxisTrack11.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack11.setEnabled(true);
		tfAxisTrack11.setEditable(false);
		tfAxisTrack11.setColumns(10);
		tfAxisTrack11.setBounds(60, 33, 30, 20);
		panelTrack11.add(tfAxisTrack11);

		JLabel lblChannelaxisTrack11 = new JLabel("Axis");
		lblChannelaxisTrack11.setForeground(Color.BLACK);
		lblChannelaxisTrack11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack11.setBounds(30, 33, 29, 20);
		panelTrack11.add(lblChannelaxisTrack11);

		sliderTrack11Action1 = new JSlider();
		sliderTrack11Action1.setForeground(Color.WHITE);
		sliderTrack11Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack11Action1.setBounds(12, 67, 187, 15);
		panelTrack11.add(sliderTrack11Action1);

		btnOpenTrack11Action7 = new JButton("-");
		btnOpenTrack11Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack11Action7.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action7);

		btnOpenTrack11Action6 = new JButton("-");
		btnOpenTrack11Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack11Action6.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action6);

		btnOpenTrack11Action5 = new JButton("-");
		btnOpenTrack11Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack11Action5.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action5);

		btnOpenTrack11Action4 = new JButton("-");
		btnOpenTrack11Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack11Action4.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action4);

		btnOpenTrack11Action3 = new JButton("-");
		btnOpenTrack11Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack11Action3.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action3);

		btnOpenTrack11Action2 = new JButton("-");
		btnOpenTrack11Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack11Action2.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action2);

		btnOpenTrack11Action1 = new JButton("-");
		btnOpenTrack11Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack11Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack11Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack11Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack11Action1.addActionListener(this);
		panelTrack11.add(btnOpenTrack11Action1);

		// Track 12 ---------------------------

		panelMain.add(panelTrack12);
		panelTrack12.setLayout(null);
		panelTrack12.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack12 = new JLabel("---- Track 12 ----");
		lblTrack12.setBackground(Color.WHITE);
		lblTrack12.setForeground(Color.BLACK);
		lblTrack12.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack12.setBounds(12, 10, 199, 12);
		panelTrack12.add(lblTrack12);

		lblTrack12Action1 = new JLabel("");
		lblTrack12Action1.setBackground(COLOR_BACKGROUND);
		lblTrack12Action1.setForeground(Color.BLACK);
		lblTrack12Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action1.setBounds(12, 57, 156, 12);
		panelTrack12.add(lblTrack12Action1);

		lblTrack12Action7 = new JLabel("");
		lblTrack12Action7.setForeground(Color.BLACK);
		lblTrack12Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action7.setBounds(12, 189, 156, 12);
		panelTrack12.add(lblTrack12Action7);

		lblTrack12Action2 = new JLabel("");
		lblTrack12Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action2.setForeground(Color.BLACK);
		lblTrack12Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action2.setBounds(12, 79, 156, 12);
		panelTrack12.add(lblTrack12Action2);

		sliderTrack12Action2 = new JSlider();
		sliderTrack12Action2.setForeground(Color.WHITE);
		sliderTrack12Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action2.setBounds(12, 89, 187, 15);
		panelTrack12.add(sliderTrack12Action2);

		lblTrack12Action3 = new JLabel("");
		lblTrack12Action3.setForeground(Color.BLACK);
		lblTrack12Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action3.setBounds(12, 101, 156, 12);
		panelTrack12.add(lblTrack12Action3);

		sliderTrack12Action3 = new JSlider();
		sliderTrack12Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action3.setBounds(12, 111, 187, 15);
		panelTrack12.add(sliderTrack12Action3);

		sliderTrack12Action4 = new JSlider();
		sliderTrack12Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action4.setBounds(12, 133, 187, 15);
		panelTrack12.add(sliderTrack12Action4);

		sliderTrack12Action5 = new JSlider();
		sliderTrack12Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action5.setBounds(12, 155, 187, 15);
		panelTrack12.add(sliderTrack12Action5);

		sliderTrack12Action6 = new JSlider();
		sliderTrack12Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action6.setBounds(12, 178, 187, 15);
		panelTrack12.add(sliderTrack12Action6);

		sliderTrack12Action7 = new JSlider();
		sliderTrack12Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action7.setBounds(12, 199, 187, 15);
		panelTrack12.add(sliderTrack12Action7);

		lblTrack12Action4 = new JLabel("");
		lblTrack12Action4.setForeground(Color.BLACK);
		lblTrack12Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action4.setBounds(12, 123, 156, 12);
		panelTrack12.add(lblTrack12Action4);

		lblTrack12Action6 = new JLabel("");
		lblTrack12Action6.setForeground(Color.BLACK);
		lblTrack12Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action6.setBounds(12, 167, 156, 12);
		panelTrack12.add(lblTrack12Action6);

		lblTrack12Action5 = new JLabel("");
		lblTrack12Action5.setForeground(Color.BLACK);
		lblTrack12Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack12Action5.setBounds(12, 145, 156, 12);
		panelTrack12.add(lblTrack12Action5);

		JLabel lblChannelTrack12 = new JLabel("Channel");
		lblChannelTrack12.setForeground(Color.BLACK);
		lblChannelTrack12.setBounds(109, 33, 59, 20);
		panelTrack12.add(lblChannelTrack12);
		lblChannelTrack12.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack12 = new JComboBox(Strings.getChannels());
		cbChannelTrack12.setBounds(158, 33, 40, 20);
		panelTrack12.add(cbChannelTrack12);
		cbChannelTrack12.setSelectedIndex(settings.getTrackChannel(12));
		cbChannelTrack12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack12.addActionListener(this);

		tfAxisTrack12 = new JTextField();
		tfAxisTrack12.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack12.setEnabled(true);
		tfAxisTrack12.setEditable(false);
		tfAxisTrack12.setColumns(10);
		tfAxisTrack12.setBounds(60, 33, 30, 20);
		panelTrack12.add(tfAxisTrack12);

		JLabel lblChannelaxisTrack12 = new JLabel("Axis");
		lblChannelaxisTrack12.setForeground(Color.BLACK);
		lblChannelaxisTrack12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack12.setBounds(30, 33, 29, 20);
		panelTrack12.add(lblChannelaxisTrack12);

		sliderTrack12Action1 = new JSlider();
		sliderTrack12Action1.setForeground(Color.WHITE);
		sliderTrack12Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack12Action1.setBounds(12, 67, 187, 15);
		panelTrack12.add(sliderTrack12Action1);

		btnOpenTrack12Action7 = new JButton("-");
		btnOpenTrack12Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack12Action7.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action7);

		btnOpenTrack12Action6 = new JButton("-");
		btnOpenTrack12Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack12Action6.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action6);

		btnOpenTrack12Action5 = new JButton("-");
		btnOpenTrack12Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack12Action5.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action5);

		btnOpenTrack12Action4 = new JButton("-");
		btnOpenTrack12Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack12Action4.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action4);

		btnOpenTrack12Action3 = new JButton("-");
		btnOpenTrack12Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack12Action3.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action3);

		btnOpenTrack12Action2 = new JButton("-");
		btnOpenTrack12Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack12Action2.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action2);

		btnOpenTrack12Action1 = new JButton("-");
		btnOpenTrack12Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack12Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack12Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack12Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack12Action1.addActionListener(this);
		panelTrack12.add(btnOpenTrack12Action1);

		// Track 13 ---------------------------

		panelMain.add(panelTrack13);
		panelTrack13.setLayout(null);
		panelTrack13.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack13 = new JLabel("---- Track 13 ----");
		lblTrack13.setBackground(Color.WHITE);
		lblTrack13.setForeground(Color.BLACK);
		lblTrack13.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack13.setBounds(12, 10, 199, 12);
		panelTrack13.add(lblTrack13);

		lblTrack13Action1 = new JLabel("");
		lblTrack13Action1.setBackground(COLOR_BACKGROUND);
		lblTrack13Action1.setForeground(Color.BLACK);
		lblTrack13Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action1.setBounds(12, 57, 156, 12);
		panelTrack13.add(lblTrack13Action1);

		lblTrack13Action7 = new JLabel("");
		lblTrack13Action7.setForeground(Color.BLACK);
		lblTrack13Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action7.setBounds(12, 189, 156, 12);
		panelTrack13.add(lblTrack13Action7);

		lblTrack13Action2 = new JLabel("");
		lblTrack13Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action2.setForeground(Color.BLACK);
		lblTrack13Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action2.setBounds(12, 79, 156, 12);
		panelTrack13.add(lblTrack13Action2);

		sliderTrack13Action2 = new JSlider();
		sliderTrack13Action2.setForeground(Color.WHITE);
		sliderTrack13Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action2.setBounds(12, 89, 187, 15);
		panelTrack13.add(sliderTrack13Action2);

		lblTrack13Action3 = new JLabel("");
		lblTrack13Action3.setForeground(Color.BLACK);
		lblTrack13Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action3.setBounds(12, 101, 156, 12);
		panelTrack13.add(lblTrack13Action3);

		sliderTrack13Action3 = new JSlider();
		sliderTrack13Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action3.setBounds(12, 111, 187, 15);
		panelTrack13.add(sliderTrack13Action3);

		sliderTrack13Action4 = new JSlider();
		sliderTrack13Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action4.setBounds(12, 133, 187, 15);
		panelTrack13.add(sliderTrack13Action4);

		sliderTrack13Action5 = new JSlider();
		sliderTrack13Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action5.setBounds(12, 155, 187, 15);
		panelTrack13.add(sliderTrack13Action5);

		sliderTrack13Action6 = new JSlider();
		sliderTrack13Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action6.setBounds(12, 178, 187, 15);
		panelTrack13.add(sliderTrack13Action6);

		sliderTrack13Action7 = new JSlider();
		sliderTrack13Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action7.setBounds(12, 199, 187, 15);
		panelTrack13.add(sliderTrack13Action7);

		lblTrack13Action4 = new JLabel("");
		lblTrack13Action4.setForeground(Color.BLACK);
		lblTrack13Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action4.setBounds(12, 123, 156, 12);
		panelTrack13.add(lblTrack13Action4);

		lblTrack13Action6 = new JLabel("");
		lblTrack13Action6.setForeground(Color.BLACK);
		lblTrack13Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action6.setBounds(12, 167, 156, 12);
		panelTrack13.add(lblTrack13Action6);

		lblTrack13Action5 = new JLabel("");
		lblTrack13Action5.setForeground(Color.BLACK);
		lblTrack13Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack13Action5.setBounds(12, 145, 156, 12);
		panelTrack13.add(lblTrack13Action5);

		JLabel lblChannelTrack13 = new JLabel("Channel");
		lblChannelTrack13.setForeground(Color.BLACK);
		lblChannelTrack13.setBounds(109, 33, 59, 20);
		panelTrack13.add(lblChannelTrack13);
		lblChannelTrack13.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack13 = new JComboBox(Strings.getChannels());
		cbChannelTrack13.setBounds(158, 33, 40, 20);
		panelTrack13.add(cbChannelTrack13);
		cbChannelTrack13.setSelectedIndex(settings.getTrackChannel(13));
		cbChannelTrack13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack13.addActionListener(this);

		tfAxisTrack13 = new JTextField();
		tfAxisTrack13.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack13.setEnabled(true);
		tfAxisTrack13.setEditable(false);
		tfAxisTrack13.setColumns(10);
		tfAxisTrack13.setBounds(60, 33, 30, 20);
		panelTrack13.add(tfAxisTrack13);

		JLabel lblChannelaxisTrack13 = new JLabel("Axis");
		lblChannelaxisTrack13.setForeground(Color.BLACK);
		lblChannelaxisTrack13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack13.setBounds(30, 33, 29, 20);
		panelTrack13.add(lblChannelaxisTrack13);

		sliderTrack13Action1 = new JSlider();
		sliderTrack13Action1.setForeground(Color.WHITE);
		sliderTrack13Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack13Action1.setBounds(12, 67, 187, 15);
		panelTrack13.add(sliderTrack13Action1);

		btnOpenTrack13Action7 = new JButton("-");
		btnOpenTrack13Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack13Action7.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action7);

		btnOpenTrack13Action6 = new JButton("-");
		btnOpenTrack13Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack13Action6.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action6);

		btnOpenTrack13Action5 = new JButton("-");
		btnOpenTrack13Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack13Action5.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action5);

		btnOpenTrack13Action4 = new JButton("-");
		btnOpenTrack13Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack13Action4.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action4);

		btnOpenTrack13Action3 = new JButton("-");
		btnOpenTrack13Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack13Action3.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action3);

		btnOpenTrack13Action2 = new JButton("-");
		btnOpenTrack13Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack13Action2.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action2);

		btnOpenTrack13Action1 = new JButton("-");
		btnOpenTrack13Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack13Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack13Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack13Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack13Action1.addActionListener(this);
		panelTrack13.add(btnOpenTrack13Action1);

		// Track 14 ---------------------------

		panelMain.add(panelTrack14);
		panelTrack14.setLayout(null);
		panelTrack14.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack14 = new JLabel("---- Track 14 ----");
		lblTrack14.setBackground(Color.WHITE);
		lblTrack14.setForeground(Color.BLACK);
		lblTrack14.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack14.setBounds(12, 10, 199, 12);
		panelTrack14.add(lblTrack14);

		lblTrack14Action1 = new JLabel("");
		lblTrack14Action1.setBackground(COLOR_BACKGROUND);
		lblTrack14Action1.setForeground(Color.BLACK);
		lblTrack14Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action1.setBounds(12, 57, 156, 12);
		panelTrack14.add(lblTrack14Action1);

		lblTrack14Action7 = new JLabel("");
		lblTrack14Action7.setForeground(Color.BLACK);
		lblTrack14Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action7.setBounds(12, 189, 156, 12);
		panelTrack14.add(lblTrack14Action7);

		lblTrack14Action2 = new JLabel("");
		lblTrack14Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action2.setForeground(Color.BLACK);
		lblTrack14Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action2.setBounds(12, 79, 156, 12);
		panelTrack14.add(lblTrack14Action2);

		sliderTrack14Action2 = new JSlider();
		sliderTrack14Action2.setForeground(Color.WHITE);
		sliderTrack14Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action2.setBounds(12, 89, 187, 15);
		panelTrack14.add(sliderTrack14Action2);

		lblTrack14Action3 = new JLabel("");
		lblTrack14Action3.setForeground(Color.BLACK);
		lblTrack14Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action3.setBounds(12, 101, 156, 12);
		panelTrack14.add(lblTrack14Action3);

		sliderTrack14Action3 = new JSlider();
		sliderTrack14Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action3.setBounds(12, 111, 187, 15);
		panelTrack14.add(sliderTrack14Action3);

		sliderTrack14Action4 = new JSlider();
		sliderTrack14Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action4.setBounds(12, 133, 187, 15);
		panelTrack14.add(sliderTrack14Action4);

		sliderTrack14Action5 = new JSlider();
		sliderTrack14Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action5.setBounds(12, 155, 187, 15);
		panelTrack14.add(sliderTrack14Action5);

		sliderTrack14Action6 = new JSlider();
		sliderTrack14Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action6.setBounds(12, 178, 187, 15);
		panelTrack14.add(sliderTrack14Action6);

		sliderTrack14Action7 = new JSlider();
		sliderTrack14Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action7.setBounds(12, 199, 187, 15);
		panelTrack14.add(sliderTrack14Action7);

		lblTrack14Action4 = new JLabel("");
		lblTrack14Action4.setForeground(Color.BLACK);
		lblTrack14Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action4.setBounds(12, 123, 156, 12);
		panelTrack14.add(lblTrack14Action4);

		lblTrack14Action6 = new JLabel("");
		lblTrack14Action6.setForeground(Color.BLACK);
		lblTrack14Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action6.setBounds(12, 167, 156, 12);
		panelTrack14.add(lblTrack14Action6);

		lblTrack14Action5 = new JLabel("");
		lblTrack14Action5.setForeground(Color.BLACK);
		lblTrack14Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack14Action5.setBounds(12, 145, 156, 12);
		panelTrack14.add(lblTrack14Action5);

		JLabel lblChannelTrack14 = new JLabel("Channel");
		lblChannelTrack14.setForeground(Color.BLACK);
		lblChannelTrack14.setBounds(109, 33, 59, 20);
		panelTrack14.add(lblChannelTrack14);
		lblChannelTrack14.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack14 = new JComboBox(Strings.getChannels());
		cbChannelTrack14.setBounds(158, 33, 40, 20);
		panelTrack14.add(cbChannelTrack14);
		cbChannelTrack14.setSelectedIndex(settings.getTrackChannel(14));
		cbChannelTrack14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack14.addActionListener(this);

		tfAxisTrack14 = new JTextField();
		tfAxisTrack14.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack14.setEnabled(true);
		tfAxisTrack14.setEditable(false);
		tfAxisTrack14.setColumns(10);
		tfAxisTrack14.setBounds(60, 33, 30, 20);
		panelTrack14.add(tfAxisTrack14);

		JLabel lblChannelaxisTrack14 = new JLabel("Axis");
		lblChannelaxisTrack14.setForeground(Color.BLACK);
		lblChannelaxisTrack14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack14.setBounds(30, 33, 29, 20);
		panelTrack14.add(lblChannelaxisTrack14);

		sliderTrack14Action1 = new JSlider();
		sliderTrack14Action1.setForeground(Color.WHITE);
		sliderTrack14Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack14Action1.setBounds(12, 67, 187, 15);
		panelTrack14.add(sliderTrack14Action1);

		btnOpenTrack14Action7 = new JButton("-");
		btnOpenTrack14Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack14Action7.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action7);

		btnOpenTrack14Action6 = new JButton("-");
		btnOpenTrack14Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack14Action6.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action6);

		btnOpenTrack14Action5 = new JButton("-");
		btnOpenTrack14Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack14Action5.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action5);

		btnOpenTrack14Action4 = new JButton("-");
		btnOpenTrack14Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack14Action4.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action4);

		btnOpenTrack14Action3 = new JButton("-");
		btnOpenTrack14Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack14Action3.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action3);

		btnOpenTrack14Action2 = new JButton("-");
		btnOpenTrack14Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack14Action2.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action2);

		btnOpenTrack14Action1 = new JButton("-");
		btnOpenTrack14Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack14Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack14Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack14Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack14Action1.addActionListener(this);
		panelTrack14.add(btnOpenTrack14Action1);

		// Track 15 ---------------------------

		panelMain.add(panelTrack15);
		panelTrack15.setLayout(null);
		panelTrack15.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack15 = new JLabel("---- Track 15 ----");
		lblTrack15.setBackground(Color.WHITE);
		lblTrack15.setForeground(Color.BLACK);
		lblTrack15.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack15.setBounds(12, 10, 199, 12);
		panelTrack15.add(lblTrack15);

		lblTrack15Action1 = new JLabel("");
		lblTrack15Action1.setBackground(COLOR_BACKGROUND);
		lblTrack15Action1.setForeground(Color.BLACK);
		lblTrack15Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action1.setBounds(12, 57, 156, 12);
		panelTrack15.add(lblTrack15Action1);

		lblTrack15Action7 = new JLabel("");
		lblTrack15Action7.setForeground(Color.BLACK);
		lblTrack15Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action7.setBounds(12, 189, 156, 12);
		panelTrack15.add(lblTrack15Action7);

		lblTrack15Action2 = new JLabel("");
		lblTrack15Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action2.setForeground(Color.BLACK);
		lblTrack15Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action2.setBounds(12, 79, 156, 12);
		panelTrack15.add(lblTrack15Action2);

		sliderTrack15Action2 = new JSlider();
		sliderTrack15Action2.setForeground(Color.WHITE);
		sliderTrack15Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action2.setBounds(12, 89, 187, 15);
		panelTrack15.add(sliderTrack15Action2);

		lblTrack15Action3 = new JLabel("");
		lblTrack15Action3.setForeground(Color.BLACK);
		lblTrack15Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action3.setBounds(12, 101, 156, 12);
		panelTrack15.add(lblTrack15Action3);

		sliderTrack15Action3 = new JSlider();
		sliderTrack15Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action3.setBounds(12, 111, 187, 15);
		panelTrack15.add(sliderTrack15Action3);

		sliderTrack15Action4 = new JSlider();
		sliderTrack15Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action4.setBounds(12, 133, 187, 15);
		panelTrack15.add(sliderTrack15Action4);

		sliderTrack15Action5 = new JSlider();
		sliderTrack15Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action5.setBounds(12, 155, 187, 15);
		panelTrack15.add(sliderTrack15Action5);

		sliderTrack15Action6 = new JSlider();
		sliderTrack15Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action6.setBounds(12, 178, 187, 15);
		panelTrack15.add(sliderTrack15Action6);

		sliderTrack15Action7 = new JSlider();
		sliderTrack15Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action7.setBounds(12, 199, 187, 15);
		panelTrack15.add(sliderTrack15Action7);

		lblTrack15Action4 = new JLabel("");
		lblTrack15Action4.setForeground(Color.BLACK);
		lblTrack15Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action4.setBounds(12, 123, 156, 12);
		panelTrack15.add(lblTrack15Action4);

		lblTrack15Action6 = new JLabel("");
		lblTrack15Action6.setForeground(Color.BLACK);
		lblTrack15Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action6.setBounds(12, 167, 156, 12);
		panelTrack15.add(lblTrack15Action6);

		lblTrack15Action5 = new JLabel("");
		lblTrack15Action5.setForeground(Color.BLACK);
		lblTrack15Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack15Action5.setBounds(12, 145, 156, 12);
		panelTrack15.add(lblTrack15Action5);

		JLabel lblChannelTrack15 = new JLabel("Channel");
		lblChannelTrack15.setForeground(Color.BLACK);
		lblChannelTrack15.setBounds(109, 33, 59, 20);
		panelTrack15.add(lblChannelTrack15);
		lblChannelTrack15.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack15 = new JComboBox(Strings.getChannels());
		cbChannelTrack15.setBounds(158, 33, 40, 20);
		panelTrack15.add(cbChannelTrack15);
		cbChannelTrack15.setSelectedIndex(settings.getTrackChannel(15));
		cbChannelTrack15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack15.addActionListener(this);

		tfAxisTrack15 = new JTextField();
		tfAxisTrack15.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack15.setEnabled(true);
		tfAxisTrack15.setEditable(false);
		tfAxisTrack15.setColumns(10);
		tfAxisTrack15.setBounds(60, 33, 30, 20);
		panelTrack15.add(tfAxisTrack15);

		JLabel lblChannelaxisTrack15 = new JLabel("Axis");
		lblChannelaxisTrack15.setForeground(Color.BLACK);
		lblChannelaxisTrack15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack15.setBounds(30, 33, 29, 20);
		panelTrack15.add(lblChannelaxisTrack15);

		sliderTrack15Action1 = new JSlider();
		sliderTrack15Action1.setForeground(Color.WHITE);
		sliderTrack15Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack15Action1.setBounds(12, 67, 187, 15);
		panelTrack15.add(sliderTrack15Action1);

		btnOpenTrack15Action7 = new JButton("-");
		btnOpenTrack15Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack15Action7.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action7);

		btnOpenTrack15Action6 = new JButton("-");
		btnOpenTrack15Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack15Action6.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action6);

		btnOpenTrack15Action5 = new JButton("-");
		btnOpenTrack15Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack15Action5.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action5);

		btnOpenTrack15Action4 = new JButton("-");
		btnOpenTrack15Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack15Action4.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action4);

		btnOpenTrack15Action3 = new JButton("-");
		btnOpenTrack15Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack15Action3.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action3);

		btnOpenTrack15Action2 = new JButton("-");
		btnOpenTrack15Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack15Action2.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action2);

		btnOpenTrack15Action1 = new JButton("-");
		btnOpenTrack15Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack15Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack15Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack15Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack15Action1.addActionListener(this);
		panelTrack15.add(btnOpenTrack15Action1);

		// Track 16 ---------------------------

		panelMain.add(panelTrack16);
		panelTrack16.setLayout(null);;
		panelTrack16.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblTrack16 = new JLabel("---- Track 16 ----");
		lblTrack16.setBackground(Color.WHITE);
		lblTrack16.setForeground(Color.BLACK);
		lblTrack16.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrack16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrack16.setBounds(12, 10, 199, 12);
		panelTrack16.add(lblTrack16);

		lblTrack16Action1 = new JLabel("");
		lblTrack16Action1.setBackground(COLOR_BACKGROUND);
		lblTrack16Action1.setForeground(Color.BLACK);
		lblTrack16Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action1.setBounds(12, 57, 156, 12);
		panelTrack16.add(lblTrack16Action1);

		lblTrack16Action7 = new JLabel("");
		lblTrack16Action7.setForeground(Color.BLACK);
		lblTrack16Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action7.setBounds(12, 189, 156, 12);
		panelTrack16.add(lblTrack16Action7);

		lblTrack16Action2 = new JLabel("");
		lblTrack16Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action2.setForeground(Color.BLACK);
		lblTrack16Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action2.setBounds(12, 79, 156, 12);
		panelTrack16.add(lblTrack16Action2);

		sliderTrack16Action2 = new JSlider();
		sliderTrack16Action2.setForeground(Color.WHITE);
		sliderTrack16Action2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action2.setBounds(12, 89, 187, 15);
		panelTrack16.add(sliderTrack16Action2);

		lblTrack16Action3 = new JLabel("");
		lblTrack16Action3.setForeground(Color.BLACK);
		lblTrack16Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action3.setBounds(12, 101, 156, 12);
		panelTrack16.add(lblTrack16Action3);

		sliderTrack16Action3 = new JSlider();
		sliderTrack16Action3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action3.setBounds(12, 111, 187, 15);
		panelTrack16.add(sliderTrack16Action3);

		sliderTrack16Action4 = new JSlider();
		sliderTrack16Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action4.setBounds(12, 133, 187, 15);
		panelTrack16.add(sliderTrack16Action4);

		sliderTrack16Action5 = new JSlider();
		sliderTrack16Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action5.setBounds(12, 155, 187, 15);
		panelTrack16.add(sliderTrack16Action5);

		sliderTrack16Action6 = new JSlider();
		sliderTrack16Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action6.setBounds(12, 178, 187, 15);
		panelTrack16.add(sliderTrack16Action6);

		sliderTrack16Action7 = new JSlider();
		sliderTrack16Action7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action7.setBounds(12, 199, 187, 15);
		panelTrack16.add(sliderTrack16Action7);

		lblTrack16Action4 = new JLabel("");
		lblTrack16Action4.setForeground(Color.BLACK);
		lblTrack16Action4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action4.setBounds(12, 123, 156, 12);
		panelTrack16.add(lblTrack16Action4);

		lblTrack16Action6 = new JLabel("");
		lblTrack16Action6.setForeground(Color.BLACK);
		lblTrack16Action6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action6.setBounds(12, 167, 156, 12);
		panelTrack16.add(lblTrack16Action6);

		lblTrack16Action5 = new JLabel("");
		lblTrack16Action5.setForeground(Color.BLACK);
		lblTrack16Action5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTrack16Action5.setBounds(12, 145, 156, 12);
		panelTrack16.add(lblTrack16Action5);

		JLabel lblChannelTrack16 = new JLabel("Channel");
		lblChannelTrack16.setForeground(Color.BLACK);
		lblChannelTrack16.setBounds(109, 33, 59, 20);
		panelTrack16.add(lblChannelTrack16);
		lblChannelTrack16.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbChannelTrack16 = new JComboBox(Strings.getChannels());
		cbChannelTrack16.setBounds(158, 33, 40, 20);
		panelTrack16.add(cbChannelTrack16);
		cbChannelTrack16.setSelectedIndex(settings.getTrackChannel(16));
		cbChannelTrack16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbChannelTrack16.addActionListener(this);

		tfAxisTrack16 = new JTextField();
		tfAxisTrack16.setHorizontalAlignment(SwingConstants.CENTER);
		tfAxisTrack16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAxisTrack16.setEnabled(true);
		tfAxisTrack16.setEditable(false);
		tfAxisTrack16.setColumns(10);
		tfAxisTrack16.setBounds(60, 33, 30, 20);
		panelTrack16.add(tfAxisTrack16);

		JLabel lblChannelaxisTrack16 = new JLabel("Axis");
		lblChannelaxisTrack16.setForeground(Color.BLACK);
		lblChannelaxisTrack16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChannelaxisTrack16.setBounds(30, 33, 29, 20);
		panelTrack16.add(lblChannelaxisTrack16);

		sliderTrack16Action1 = new JSlider();
		sliderTrack16Action1.setForeground(Color.WHITE);
		sliderTrack16Action1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderTrack16Action1.setBounds(12, 67, 187, 15);
		panelTrack16.add(sliderTrack16Action1);

		btnOpenTrack16Action7 = new JButton("-");
		btnOpenTrack16Action7.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action7.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action7.setBounds(202, 199, 15, 15);
		btnOpenTrack16Action7.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action7);

		btnOpenTrack16Action6 = new JButton("-");
		btnOpenTrack16Action6.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action6.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action6.setBounds(202, 177, 15, 15);
		btnOpenTrack16Action6.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action6);

		btnOpenTrack16Action5 = new JButton("-");
		btnOpenTrack16Action5.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action5.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action5.setBounds(202, 155, 15, 15);
		btnOpenTrack16Action5.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action5);

		btnOpenTrack16Action4 = new JButton("-");
		btnOpenTrack16Action4.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action4.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action4.setBounds(202, 133, 15, 15);
		btnOpenTrack16Action4.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action4);

		btnOpenTrack16Action3 = new JButton("-");
		btnOpenTrack16Action3.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action3.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action3.setBounds(202, 111, 15, 15);
		btnOpenTrack16Action3.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action3);

		btnOpenTrack16Action2 = new JButton("-");
		btnOpenTrack16Action2.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action2.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action2.setBounds(202, 89, 15, 15);
		btnOpenTrack16Action2.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action2);

		btnOpenTrack16Action1 = new JButton("-");
		btnOpenTrack16Action1.setMaximumSize(new Dimension(0, 0));
		btnOpenTrack16Action1.setMargin(new Insets(0, 0, 0, 0));
		btnOpenTrack16Action1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpenTrack16Action1.setBounds(202, 67, 15, 15);
		btnOpenTrack16Action1.addActionListener(this);
		panelTrack16.add(btnOpenTrack16Action1);

		// ------------------- Left Panel ------------------------------------

		JPanel panelFingers = new JPanel();
		panelFingers.setBackground(Color.LIGHT_GRAY);
		panelFingers.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFingers.setBounds(0, 42, 172, 286);
		frmGestureControlledMusical.getContentPane().add(panelFingers);
		panelFingers.setLayout(null);

		JLabel lblFingersleft = new JLabel("Fingers (Left)");
		lblFingersleft.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblFingersleft.setBackground(Color.LIGHT_GRAY);
		lblFingersleft.setForeground(Color.BLACK);
		lblFingersleft.setBounds(20, 16, 80, 16);
		panelFingers.add(lblFingersleft);

		JLabel lblLeftX = new JLabel("Left X");
		lblLeftX.setBackground(Color.LIGHT_GRAY);
		lblLeftX.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblLeftX.setForeground(Color.BLACK);
		lblLeftX.setBounds(20, 48, 73, 16);
		panelFingers.add(lblLeftX);

		JLabel lblLeftY = new JLabel("Left Y");
		lblLeftY.setBackground(Color.LIGHT_GRAY);
		lblLeftY.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblLeftY.setForeground(Color.BLACK);
		lblLeftY.setBounds(20, 77, 80, 22);
		panelFingers.add(lblLeftY);

		JLabel lblLeftZ = new JLabel("Left Z");
		lblLeftZ.setBackground(Color.LIGHT_GRAY);
		lblLeftZ.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblLeftZ.setForeground(Color.BLACK);
		lblLeftZ.setBounds(20, 112, 96, 22);
		panelFingers.add(lblLeftZ);

		tfLeftFingers = new JTextField();
		tfLeftFingers.setEnabled(true);
		tfLeftFingers.setBounds(120, 13, 32, 22);
		panelFingers.add(tfLeftFingers);
		tfLeftFingers.setEditable(false);
		tfLeftFingers.setColumns(10);

		tfLeftX = new JTextField();
		tfLeftX.setEnabled(true);
		tfLeftX.setBounds(120, 45, 32, 22);
		panelFingers.add(tfLeftX);
		tfLeftX.setEditable(false);
		tfLeftX.setColumns(10);

		tfLeftY = new JTextField();
		tfLeftY.setEnabled(true);
		tfLeftY.setBounds(120, 77, 32, 22);
		panelFingers.add(tfLeftY);
		tfLeftY.setEditable(false);
		tfLeftY.setColumns(10);

		tfLeftZ = new JTextField();
		tfLeftZ.setEnabled(true);
		tfLeftZ.setBounds(120, 112, 32, 22);
		panelFingers.add(tfLeftZ);
		tfLeftZ.setEditable(false);
		tfLeftZ.setColumns(10);

		JLabel lblFingersright = new JLabel("Fingers (Right)");
		lblFingersright.setBackground(Color.LIGHT_GRAY);
		lblFingersright.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblFingersright.setForeground(Color.BLACK);
		lblFingersright.setBounds(20, 150, 115, 16);
		panelFingers.add(lblFingersright);

		tfRightFingers = new JTextField();
		tfRightFingers.setEnabled(true);
		tfRightFingers.setEditable(false);
		tfRightFingers.setColumns(10);
		tfRightFingers.setBounds(120, 147, 32, 22);
		panelFingers.add(tfRightFingers);

		JLabel lblRightX = new JLabel("Right X");
		lblRightX.setBackground(Color.LIGHT_GRAY);
		lblRightX.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblRightX.setForeground(Color.BLACK);
		lblRightX.setBounds(20, 182, 73, 16);
		panelFingers.add(lblRightX);

		tfRightX = new JTextField();
		tfRightX.setEnabled(true);
		tfRightX.setEditable(false);
		tfRightX.setColumns(10);
		tfRightX.setBounds(120, 179, 32, 22);
		panelFingers.add(tfRightX);

		JLabel lblRightY = new JLabel("Right Y");
		lblRightY.setBackground(Color.LIGHT_GRAY);
		lblRightY.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblRightY.setForeground(Color.BLACK);
		lblRightY.setBounds(20, 211, 80, 22);
		panelFingers.add(lblRightY);

		tfRightY = new JTextField();
		tfRightY.setEnabled(true);
		tfRightY.setEditable(false);
		tfRightY.setColumns(10);
		tfRightY.setBounds(120, 211, 32, 22);
		panelFingers.add(tfRightY);

		JLabel lblRightZ = new JLabel("Right Z");
		lblRightZ.setBackground(Color.LIGHT_GRAY);
		lblRightZ.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblRightZ.setForeground(Color.BLACK);
		lblRightZ.setBounds(20, 246, 96, 22);
		panelFingers.add(lblRightZ);

		tfRightZ = new JTextField();
		tfRightZ.setEnabled(true);
		tfRightZ.setEditable(false);
		tfRightZ.setColumns(10);
		tfRightZ.setBounds(120, 246, 32, 22);
		panelFingers.add(tfRightZ);

		// ------------------- Left Text Area ------------------------------------

		JPanel panelLog = new JPanel();
		panelLog.setBackground(Color.WHITE);
		panelLog.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLog.setBounds(0, 328, 172, 590);
		frmGestureControlledMusical.getContentPane().add(panelLog);
		panelLog.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 148, 564);
		panelLog.add(scrollPane);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);
		scrollPane.setBorder(null);

		// ------------------- Global Panel Area ------------------------------------

		panelGlobal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGlobal.setBounds(1060, 42, 112, 876);
		frmGestureControlledMusical.getContentPane().add(panelGlobal);
		panelGlobal.setLayout(null);

		lblTapTempo = new JLabel("Tap Tempo");
		lblTapTempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTapTempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTapTempo.setBounds(10, 245, 93, 12);
		panelGlobal.add(lblTapTempo);

		sliderGlobalAction2 = new JSlider();
		sliderGlobalAction2.setOrientation(SwingConstants.VERTICAL);
		sliderGlobalAction2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderGlobalAction2.setBounds(20, 270, 15, 175);
		panelGlobal.add(sliderGlobalAction2);

		lblTapTempoTap = new JLabel("Tap");
		lblTapTempoTap.setBounds(52, 274, 32, 16);
		panelGlobal.add(lblTapTempoTap);
		lblTapTempoTap.setForeground(Color.BLACK);
		lblTapTempoTap.setFont(new Font("Tahoma", Font.PLAIN, 13));

		cbTapTempoTap = new JComboBox(Strings.getMinMax());
		cbTapTempoTap.setBounds(50, 294, 44, 20);
		panelGlobal.add(cbTapTempoTap);
		cbTapTempoTap.setSelectedIndex(settings.getTapTapValue());
		cbTapTempoTap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbTapTempoTap.setSelectedIndex(settings.getTapTapValue());
		cbTapTempoTap.addActionListener(this);

		lblGlobal = new JLabel("Global");
		lblGlobal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGlobal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGlobal.setBounds(7, 9, 93, 23);
		panelGlobal.add(lblGlobal);

		lblGlobalAction2Min = new JLabel("Min");
		lblGlobalAction2Min.setForeground(Color.BLACK);
		lblGlobalAction2Min.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction2Min.setBounds(52, 324, 32, 16);
		panelGlobal.add(lblGlobalAction2Min);

		cbGlobalAction2Min = new JComboBox(Strings.getMinMax());
		cbGlobalAction2Min.setSelectedIndex(settings.getGlobalActionValue(2, false));
		cbGlobalAction2Min.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction2Min.setBounds(50, 344, 44, 20);
		cbGlobalAction2Min.addActionListener(this);
		panelGlobal.add(cbGlobalAction2Min);

		lblGlobalAction2Max = new JLabel("Max");
		lblGlobalAction2Max.setForeground(Color.BLACK);
		lblGlobalAction2Max.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction2Max.setBounds(52, 374, 32, 16);

		panelGlobal.add(lblGlobalAction2Max);

		cbGlobalAction2Max = new JComboBox(Strings.getMinMax());
		cbGlobalAction2Max.setSelectedIndex(settings.getGlobalActionValue(2, true));
		cbGlobalAction2Max.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction2Max.setBounds(50, 394, 44, 20);
		cbGlobalAction2Max.addActionListener(this);
		panelGlobal.add(cbGlobalAction2Max);

		lblMasterVolume = new JLabel("Master Volume");
		lblMasterVolume.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasterVolume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMasterVolume.setBounds(10, 46, 93, 12);
		panelGlobal.add(lblMasterVolume);

		sliderGlobalAction1 = new JSlider();
		sliderGlobalAction1.setOrientation(SwingConstants.VERTICAL);
		sliderGlobalAction1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderGlobalAction1.setBounds(20, 60, 15, 174);
		panelGlobal.add(sliderGlobalAction1);

		cbGlobalAction1Min = new JComboBox(Strings.getMinMax());
		cbGlobalAction1Min.setSelectedIndex(settings.getGlobalActionValue(1, false));
		cbGlobalAction1Min.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction1Min.setBounds(50, 94, 44, 20);
		cbGlobalAction1Min.addActionListener(this);
		panelGlobal.add(cbGlobalAction1Min);

		lblGlobalAction1Min = new JLabel("Min");
		lblGlobalAction1Min.setForeground(Color.BLACK);
		lblGlobalAction1Min.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction1Min.setBounds(52, 74, 32, 16);
		panelGlobal.add(lblGlobalAction1Min);

		cbGlobalAction1Max = new JComboBox(Strings.getMinMax());
		cbGlobalAction1Max.setSelectedIndex(settings.getGlobalActionValue(1, true));
		cbGlobalAction1Max.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction1Max.setBounds(50, 144, 44, 20);
		cbGlobalAction1Max.addActionListener(this);
		panelGlobal.add(cbGlobalAction1Max);

		lblGlobalAction1Max = new JLabel("Max");
		lblGlobalAction1Max.setForeground(Color.BLACK);
		lblGlobalAction1Max.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction1Max.setBounds(52, 124, 32, 16);
		panelGlobal.add(lblGlobalAction1Max);

		lblGlobalAction1Axis = new JLabel("Axis");
		lblGlobalAction1Axis.setForeground(Color.BLACK);
		lblGlobalAction1Axis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction1Axis.setBounds(52, 174, 32, 16);
		panelGlobal.add(lblGlobalAction1Axis);

		cbGlobalAction1Axis = new JComboBox(Strings.getAxisShort());
		cbGlobalAction1Axis.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction1Axis.setBounds(50, 194, 44, 20);
		cbGlobalAction1Axis.setSelectedIndex(settings.getGlobalAxisValue(1));
		cbGlobalAction1Axis.addActionListener(this);
		panelGlobal.add(cbGlobalAction1Axis);

		cbGlobalAction2Axis = new JComboBox(Strings.getAxisShort());
		cbGlobalAction2Axis.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbGlobalAction2Axis.setBounds(50, 444, 44, 20);
		cbGlobalAction2Axis.setSelectedIndex(settings.getGlobalAxisValue(2));
		cbGlobalAction2Axis.addActionListener(this);
		panelGlobal.add(cbGlobalAction2Axis);

		lblGlobalAction2Axis = new JLabel("Axis");
		lblGlobalAction2Axis.setForeground(Color.BLACK);
		lblGlobalAction2Axis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGlobalAction2Axis.setBounds(52, 424, 32, 16);
		panelGlobal.add(lblGlobalAction2Axis);
		cbTapTempoTap.addActionListener(this);


		if (LeapMotionListener.setUp == true){
			setLeapConnected();
		} else {
			setLeapDisconnected();
		}

		setTrackColour(1, COLOR_BACKGROUND);
		setTrackColour(2, COLOR_BACKGROUND);
		setTrackColour(3, COLOR_BACKGROUND);
		setTrackColour(4, COLOR_BACKGROUND);
		setTrackColour(5, COLOR_BACKGROUND);
		setTrackColour(6, COLOR_BACKGROUND);
		setTrackColour(7, COLOR_BACKGROUND);
		setTrackColour(8, COLOR_BACKGROUND);
		setTrackColour(9, COLOR_BACKGROUND);
		setTrackColour(10, COLOR_BACKGROUND);
		setTrackColour(11, COLOR_BACKGROUND);
		setTrackColour(12, COLOR_BACKGROUND);
		setTrackColour(13, COLOR_BACKGROUND);
		setTrackColour(14, COLOR_BACKGROUND);
		setTrackColour(15, COLOR_BACKGROUND);
		setTrackColour(16, COLOR_BACKGROUND);
		setTrackColour(17, COLOR_BACKGROUND);
	}

	/**
	 * Getting the list of available MIDI Devices
	 */
	private void getMidiDevices(){

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel(midiInterface.getAvailableMIDIDevices());
		midiComboBox.setModel(model);
		midiComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					midiInterface.setMidiOutDevice(midiComboBox.getSelectedItem());
				}
				catch (MidiUnavailableException midiException) {
					JOptionPane.showMessageDialog(windowPanel, midiException.getMessage(),
							"MIDI Unavailable", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Setting the interface to show the leap motion connected
	 */
	public static void setLeapConnected(){
		tfLeapStatus.setText("Connected");
		tfLeapStatus.setBackground(new Color(0,175,17));

	}
	
	 /**
	 * Setting the interface to show the leap motion disconnected
	 */
	public static void setLeapDisconnected(){
		tfLeapStatus.setText("Disonnected");
		tfLeapStatus.setBackground(new Color(165,0,0));
	}
	
	/**
	 * Setting the interface to the data from the left hand
	 * @param aFingers - Number of fingers held out
	 * @param aXValue - X coordinate of the left hand
	 * @param aYValue - Y coordinate of the left hand
	 * @param aZValue - Z coordinate of the left hand
	 */
	public static void setLeftHandData(int aFingers, float aXValue, float aYValue, float aZValue){

		int x, y, z;
		x = (int) aXValue;
		y = (int) aYValue;
		z = (int) aZValue;

		tfLeftFingers.setText(Integer.toString(aFingers));
		tfLeftX.setText(Integer.toString(x));
		tfLeftY.setText(Integer.toString(y));
		tfLeftZ.setText(Integer.toString(z));
	}

	/**
	 * Setting the interface to the data from the right hand
	 * @param aFingers - Number of fingers held out
	 * @param aXValue - X coordinate of the right hand
	 * @param aYValue - Y coordinate of the right hand
	 * @param aZValue - Z coordinate of the right hand
	 */
	public static void setRightHandData(int aFingers, float aXValue, float aYValue, float aZValue){

		int x, y, z;
		x = (int) aXValue;
		y = (int) aYValue;
		z = (int) aZValue;

		tfRightFingers.setText(Integer.toString(aFingers));
		tfRightX.setText(Integer.toString(x));
		tfRightY.setText(Integer.toString(y));
		tfRightZ.setText(Integer.toString(z));
	}

	/**
	 * Logging messages on the GUI
	 * @param aMessage - Message to be logged
	 */
	public static void logMessage(String aMessage){

		textArea.append(aMessage + "\n" ); 
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	@Override
	public void actionPerformed(ActionEvent aEvent) {
		if (aEvent.getSource().equals(btnOpenTrack1Action1)){
			if (btnOpenTrack1Action1.getText() == "-"){
				btnOpenTrack1Action1.setText("+");
				lblTrack1Action1.setVisible(false);
				sliderTrack1Action1.setVisible(false);
			} else if (btnOpenTrack1Action1.getText() == "+"){
				btnOpenTrack1Action1.setText("-");
				lblTrack1Action1.setVisible(true);
				sliderTrack1Action1.setVisible(true);
				openDialog(1, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action2)){
			if (btnOpenTrack1Action2.getText() == "-"){
				btnOpenTrack1Action2.setText("+");
				lblTrack1Action2.setVisible(false);
				sliderTrack1Action2.setVisible(false);
			} else {
				btnOpenTrack1Action2.setText("-");
				lblTrack1Action2.setVisible(true);
				sliderTrack1Action2.setVisible(true);
				openDialog(1, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action3)){
			if (btnOpenTrack1Action3.getText() == "-"){
				btnOpenTrack1Action3.setText("+");
				lblTrack1Action3.setVisible(false);
				sliderTrack1Action3.setVisible(false);
			} else {
				btnOpenTrack1Action3.setText("-");
				lblTrack1Action3.setVisible(true);
				sliderTrack1Action3.setVisible(true);
				openDialog(1, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action4)){
			if (btnOpenTrack1Action4.getText() == "-"){
				btnOpenTrack1Action4.setText("+");
				lblTrack1Action4.setVisible(false);
				sliderTrack1Action4.setVisible(false);
			} else {
				btnOpenTrack1Action4.setText("-");
				lblTrack1Action4.setVisible(true);
				sliderTrack1Action4.setVisible(true);
				openDialog(1, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action5)){
			if (btnOpenTrack1Action5.getText() == "-"){
				btnOpenTrack1Action5.setText("+");
				lblTrack1Action5.setVisible(false);
				sliderTrack1Action5.setVisible(false);
			} else {
				btnOpenTrack1Action5.setText("-");
				lblTrack1Action5.setVisible(true);
				sliderTrack1Action5.setVisible(true);
				openDialog(1, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action6)){
			if (btnOpenTrack1Action6.getText() == "-"){
				btnOpenTrack1Action6.setText("+");
				lblTrack1Action6.setVisible(false);
				sliderTrack1Action6.setVisible(false);
			} else {
				btnOpenTrack1Action6.setText("-");
				lblTrack1Action6.setVisible(true);
				sliderTrack1Action6.setVisible(true);
				openDialog(1, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack1Action7)){
			if (btnOpenTrack1Action7.getText() == "-"){
				btnOpenTrack1Action7.setText("+");
				lblTrack1Action7.setVisible(false);
				sliderTrack1Action7.setVisible(false);
			} else {
				btnOpenTrack1Action7.setText("-");
				lblTrack1Action7.setVisible(true);
				sliderTrack1Action7.setVisible(true);
				openDialog(1, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action1)){
			if (btnOpenTrack2Action1.getText() == "-"){
				btnOpenTrack2Action1.setText("+");
				lblTrack2Action1.setVisible(false);
				sliderTrack2Action1.setVisible(false);
			} else {
				btnOpenTrack2Action1.setText("-");
				lblTrack2Action1.setVisible(true);
				sliderTrack2Action1.setVisible(true);
				openDialog(2, 0);

			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action2)){
			if (btnOpenTrack2Action2.getText() == "-"){
				btnOpenTrack2Action2.setText("+");
				lblTrack2Action2.setVisible(false);
				sliderTrack2Action2.setVisible(false);
			} else {
				btnOpenTrack2Action2.setText("-");
				lblTrack2Action2.setVisible(true);
				sliderTrack2Action2.setVisible(true);
				openDialog(2, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action3)){
			if (btnOpenTrack2Action3.getText() == "-"){
				btnOpenTrack2Action3.setText("+");
				lblTrack2Action3.setVisible(false);
				sliderTrack2Action3.setVisible(false);
			} else {
				btnOpenTrack2Action3.setText("-");
				lblTrack2Action3.setVisible(true);
				sliderTrack2Action3.setVisible(true);
				openDialog(2, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action4)){
			if (btnOpenTrack2Action4.getText() == "-"){
				btnOpenTrack2Action4.setText("+");
				lblTrack2Action4.setVisible(false);
				sliderTrack2Action4.setVisible(false);
			} else {
				btnOpenTrack2Action4.setText("-");
				lblTrack2Action4.setVisible(true);
				sliderTrack2Action4.setVisible(true);
				openDialog(2, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action5)){
			if (btnOpenTrack2Action5.getText() == "-"){
				btnOpenTrack2Action5.setText("+");
				lblTrack2Action5.setVisible(false);
				sliderTrack2Action5.setVisible(false);
			} else {
				btnOpenTrack2Action5.setText("-");
				lblTrack2Action5.setVisible(true);
				sliderTrack2Action5.setVisible(true);
				openDialog(2, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack2Action6)){
			if (btnOpenTrack2Action6.getText() == "-"){
				btnOpenTrack2Action6.setText("+");
				lblTrack2Action6.setVisible(false);
				sliderTrack2Action6.setVisible(false);
			} else {
				btnOpenTrack2Action6.setText("-");
				lblTrack2Action6.setVisible(true);
				sliderTrack2Action6.setVisible(true);
				openDialog(2, 5);
			}
		}
		
		if (aEvent.getSource().equals(btnOpenTrack2Action7)){
			if (btnOpenTrack2Action7.getText() == "-"){
				btnOpenTrack2Action7.setText("+");
				lblTrack2Action7.setVisible(false);
				sliderTrack2Action7.setVisible(false);
			} else {
				btnOpenTrack2Action7.setText("-");
				lblTrack2Action7.setVisible(true);
				sliderTrack2Action7.setVisible(true);
				openDialog(2, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action1)){
			if (btnOpenTrack3Action1.getText() == "-"){
				btnOpenTrack3Action1.setText("+");
				lblTrack3Action1.setVisible(false);
				sliderTrack3Action1.setVisible(false);
			} else {
				btnOpenTrack3Action1.setText("-");
				lblTrack3Action1.setVisible(true);
				sliderTrack3Action1.setVisible(true);
				openDialog(3, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action2)){
			if (btnOpenTrack3Action2.getText() == "-"){
				btnOpenTrack3Action2.setText("+");
				lblTrack3Action2.setVisible(false);
				sliderTrack3Action2.setVisible(false);
			} else {
				btnOpenTrack3Action2.setText("-");
				lblTrack3Action2.setVisible(true);
				sliderTrack3Action2.setVisible(true);
				openDialog(3, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action3)){
			if (btnOpenTrack3Action3.getText() == "-"){
				btnOpenTrack3Action3.setText("+");
				lblTrack3Action3.setVisible(false);
				sliderTrack3Action3.setVisible(false);
			} else {
				btnOpenTrack3Action3.setText("-");
				lblTrack3Action3.setVisible(true);
				sliderTrack3Action3.setVisible(true);
				openDialog(3, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action4)){
			if (btnOpenTrack3Action4.getText() == "-"){
				btnOpenTrack3Action4.setText("+");
				lblTrack3Action4.setVisible(false);
				sliderTrack3Action4.setVisible(false);
			} else {
				btnOpenTrack3Action4.setText("-");
				lblTrack3Action4.setVisible(true);
				sliderTrack3Action4.setVisible(true);
				openDialog(3, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action5)){
			if (btnOpenTrack3Action5.getText() == "-"){
				btnOpenTrack3Action5.setText("+");
				lblTrack3Action5.setVisible(false);
				sliderTrack3Action5.setVisible(false);
			} else {
				btnOpenTrack3Action5.setText("-");
				lblTrack3Action5.setVisible(true);
				sliderTrack3Action5.setVisible(true);
				openDialog(3, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action6)){
			if (btnOpenTrack3Action6.getText() == "-"){
				btnOpenTrack3Action6.setText("+");
				lblTrack3Action6.setVisible(false);
				sliderTrack3Action6.setVisible(false);
			} else {
				btnOpenTrack3Action6.setText("-");
				lblTrack3Action6.setVisible(true);
				sliderTrack3Action6.setVisible(true);
				openDialog(3, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack3Action7)){
			if (btnOpenTrack3Action7.getText() == "-"){
				btnOpenTrack3Action7.setText("+");
				lblTrack3Action7.setVisible(false);
				sliderTrack3Action7.setVisible(false);
			} else {
				btnOpenTrack3Action7.setText("-");
				lblTrack3Action7.setVisible(true);
				sliderTrack3Action7.setVisible(true);
				openDialog(3, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action1)){
			if (btnOpenTrack4Action1.getText() == "-"){
				btnOpenTrack4Action1.setText("+");
				lblTrack4Action1.setVisible(false);
				sliderTrack4Action1.setVisible(false);
			} else {
				btnOpenTrack4Action1.setText("-");
				lblTrack4Action1.setVisible(true);
				sliderTrack4Action1.setVisible(true);
				openDialog(4, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action2)){
			if (btnOpenTrack4Action2.getText() == "-"){
				btnOpenTrack4Action2.setText("+");
				lblTrack4Action2.setVisible(false);
				sliderTrack4Action2.setVisible(false);
			} else {
				btnOpenTrack4Action2.setText("-");
				lblTrack4Action2.setVisible(true);
				sliderTrack4Action2.setVisible(true);
				openDialog(4, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action3)){
			if (btnOpenTrack4Action3.getText() == "-"){
				btnOpenTrack4Action3.setText("+");
				lblTrack4Action3.setVisible(false);
				sliderTrack4Action3.setVisible(false);
			} else {
				btnOpenTrack4Action3.setText("-");
				lblTrack4Action3.setVisible(true);
				sliderTrack4Action3.setVisible(true);
				openDialog(4, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action4)){
			if (btnOpenTrack4Action4.getText() == "-"){
				btnOpenTrack4Action4.setText("+");
				lblTrack4Action4.setVisible(false);
				sliderTrack4Action4.setVisible(false);
			} else {
				btnOpenTrack4Action4.setText("-");
				lblTrack4Action4.setVisible(true);
				sliderTrack4Action4.setVisible(true);
				openDialog(4, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action5)){
			if (btnOpenTrack4Action5.getText() == "-"){
				btnOpenTrack4Action5.setText("+");
				lblTrack4Action5.setVisible(false);
				sliderTrack4Action5.setVisible(false);
			} else {
				btnOpenTrack4Action5.setText("-");
				lblTrack4Action5.setVisible(true);
				sliderTrack4Action5.setVisible(true);
				openDialog(4, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action6)){
			if (btnOpenTrack4Action6.getText() == "-"){
				btnOpenTrack4Action6.setText("+");
				lblTrack4Action6.setVisible(false);
				sliderTrack4Action6.setVisible(false);
			} else {
				btnOpenTrack4Action6.setText("-");
				lblTrack4Action6.setVisible(true);
				sliderTrack4Action6.setVisible(true);
				openDialog(4, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack4Action7)){
			if (btnOpenTrack4Action7.getText() == "-"){
				btnOpenTrack4Action7.setText("+");
				lblTrack4Action7.setVisible(false);
				sliderTrack4Action7.setVisible(false);
			} else {
				btnOpenTrack4Action7.setText("-");
				lblTrack4Action7.setVisible(true);
				sliderTrack4Action7.setVisible(true);
				openDialog(4, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action1)){
			if (btnOpenTrack5Action1.getText() == "-"){
				btnOpenTrack5Action1.setText("+");
				lblTrack5Action1.setVisible(false);
				sliderTrack5Action1.setVisible(false);
			} else {
				btnOpenTrack5Action1.setText("-");
				lblTrack5Action1.setVisible(true);
				sliderTrack5Action1.setVisible(true);
				openDialog(5, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action2)){
			if (btnOpenTrack5Action2.getText() == "-"){
				btnOpenTrack5Action2.setText("+");
				lblTrack5Action2.setVisible(false);
				sliderTrack5Action2.setVisible(false);
			} else {
				btnOpenTrack5Action2.setText("-");
				lblTrack5Action2.setVisible(true);
				sliderTrack5Action2.setVisible(true);
				openDialog(5, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action3)){
			if (btnOpenTrack5Action3.getText() == "-"){
				btnOpenTrack5Action3.setText("+");
				lblTrack5Action3.setVisible(false);
				sliderTrack5Action3.setVisible(false);
			} else {
				btnOpenTrack5Action3.setText("-");
				lblTrack5Action3.setVisible(true);
				sliderTrack5Action3.setVisible(true);
				openDialog(5, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action4)){
			if (btnOpenTrack5Action4.getText() == "-"){
				btnOpenTrack5Action4.setText("+");
				lblTrack5Action4.setVisible(false);
				sliderTrack5Action4.setVisible(false);
			} else {
				btnOpenTrack5Action4.setText("-");
				lblTrack5Action4.setVisible(true);
				sliderTrack5Action4.setVisible(true);
				openDialog(5, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action5)){
			if (btnOpenTrack5Action5.getText() == "-"){
				btnOpenTrack5Action5.setText("+");
				lblTrack5Action5.setVisible(false);
				sliderTrack5Action5.setVisible(false);
			} else {
				btnOpenTrack5Action5.setText("-");
				lblTrack5Action5.setVisible(true);
				sliderTrack5Action5.setVisible(true);
				openDialog(5, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action6)){
			if (btnOpenTrack5Action6.getText() == "-"){
				btnOpenTrack5Action6.setText("+");
				lblTrack5Action6.setVisible(false);
				sliderTrack5Action6.setVisible(false);
			} else {
				btnOpenTrack5Action6.setText("-");
				lblTrack5Action6.setVisible(true);
				sliderTrack5Action6.setVisible(true);
				openDialog(5, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack5Action7)){
			if (btnOpenTrack5Action7.getText() == "-"){
				btnOpenTrack5Action7.setText("+");
				lblTrack5Action7.setVisible(false);
				sliderTrack5Action7.setVisible(false);
			} else {
				btnOpenTrack5Action7.setText("-");
				lblTrack5Action7.setVisible(true);
				sliderTrack5Action7.setVisible(true);
				openDialog(5, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action1)){
			if (btnOpenTrack6Action1.getText() == "-"){
				btnOpenTrack6Action1.setText("+");
				lblTrack6Action1.setVisible(false);
				sliderTrack6Action1.setVisible(false);
			} else {
				btnOpenTrack6Action1.setText("-");
				lblTrack6Action1.setVisible(true);
				sliderTrack6Action1.setVisible(true);
				openDialog(6, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action2)){
			if (btnOpenTrack6Action2.getText() == "-"){
				btnOpenTrack6Action2.setText("+");
				lblTrack6Action2.setVisible(false);
				sliderTrack6Action2.setVisible(false);
			} else {
				btnOpenTrack6Action2.setText("-");
				lblTrack6Action2.setVisible(true);
				sliderTrack6Action2.setVisible(true);
				openDialog(6, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action3)){
			if (btnOpenTrack6Action3.getText() == "-"){
				btnOpenTrack6Action3.setText("+");
				lblTrack6Action3.setVisible(false);
				sliderTrack6Action3.setVisible(false);
			} else {
				btnOpenTrack6Action3.setText("-");
				lblTrack6Action3.setVisible(true);
				sliderTrack6Action3.setVisible(true);
				openDialog(6, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action4)){
			if (btnOpenTrack6Action4.getText() == "-"){
				btnOpenTrack6Action4.setText("+");
				lblTrack6Action4.setVisible(false);
				sliderTrack6Action4.setVisible(false);
			} else {
				btnOpenTrack6Action4.setText("-");
				lblTrack6Action4.setVisible(true);
				sliderTrack6Action4.setVisible(true);
				openDialog(6, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action5)){
			if (btnOpenTrack6Action5.getText() == "-"){
				btnOpenTrack6Action5.setText("+");
				lblTrack6Action5.setVisible(false);
				sliderTrack6Action5.setVisible(false);
			} else {
				btnOpenTrack6Action5.setText("-");
				lblTrack6Action5.setVisible(true);
				sliderTrack6Action5.setVisible(true);
				openDialog(6, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action6)){
			if (btnOpenTrack6Action6.getText() == "-"){
				btnOpenTrack6Action6.setText("+");
				lblTrack6Action6.setVisible(false);
				sliderTrack6Action6.setVisible(false);
			} else {
				btnOpenTrack6Action6.setText("-");
				lblTrack6Action6.setVisible(true);
				sliderTrack6Action6.setVisible(true);
				openDialog(6, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack6Action7)){
			if (btnOpenTrack6Action7.getText() == "-"){
				btnOpenTrack6Action7.setText("+");
				lblTrack6Action7.setVisible(false);
				sliderTrack6Action7.setVisible(false);
			} else {
				btnOpenTrack6Action7.setText("-");
				lblTrack6Action7.setVisible(true);
				sliderTrack6Action7.setVisible(true);
				openDialog(6, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action1)){
			if (btnOpenTrack7Action1.getText() == "-"){
				btnOpenTrack7Action1.setText("+");
				lblTrack7Action1.setVisible(false);
				sliderTrack7Action1.setVisible(false);
			} else {
				btnOpenTrack7Action1.setText("-");
				lblTrack7Action1.setVisible(true);
				sliderTrack7Action1.setVisible(true);
				openDialog(7, 0);

			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action2)){
			if (btnOpenTrack7Action2.getText() == "-"){
				btnOpenTrack7Action2.setText("+");
				lblTrack7Action2.setVisible(false);
				sliderTrack7Action2.setVisible(false);
			} else {
				btnOpenTrack7Action2.setText("-");
				lblTrack7Action2.setVisible(true);
				sliderTrack7Action2.setVisible(true);
				openDialog(7, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action3)){
			if (btnOpenTrack7Action3.getText() == "-"){
				btnOpenTrack7Action3.setText("+");
				lblTrack7Action3.setVisible(false);
				sliderTrack7Action3.setVisible(false);
			} else {
				btnOpenTrack7Action3.setText("-");
				lblTrack7Action3.setVisible(true);
				sliderTrack7Action3.setVisible(true);
				openDialog(7, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action4)){
			if (btnOpenTrack7Action4.getText() == "-"){
				btnOpenTrack7Action4.setText("+");
				lblTrack7Action4.setVisible(false);
				sliderTrack7Action4.setVisible(false);
			} else {
				btnOpenTrack7Action4.setText("-");
				lblTrack7Action4.setVisible(true);
				sliderTrack7Action4.setVisible(true);
				openDialog(7, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action5)){
			if (btnOpenTrack7Action5.getText() == "-"){
				btnOpenTrack7Action5.setText("+");
				lblTrack7Action5.setVisible(false);
				sliderTrack7Action5.setVisible(false);
			} else {
				btnOpenTrack7Action5.setText("-");
				lblTrack7Action5.setVisible(true);
				sliderTrack7Action5.setVisible(true);
				openDialog(7, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action6)){
			if (btnOpenTrack7Action6.getText() == "-"){
				btnOpenTrack7Action6.setText("+");
				lblTrack7Action6.setVisible(false);
				sliderTrack7Action6.setVisible(false);
			} else {
				btnOpenTrack7Action6.setText("-");
				lblTrack7Action6.setVisible(true);
				sliderTrack7Action6.setVisible(true);
				openDialog(7, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack7Action7)){
			if (btnOpenTrack7Action7.getText() == "-"){
				btnOpenTrack7Action7.setText("+");
				lblTrack7Action7.setVisible(false);
				sliderTrack7Action7.setVisible(false);
			} else {
				btnOpenTrack7Action7.setText("-");
				lblTrack7Action7.setVisible(true);
				sliderTrack7Action7.setVisible(true);
				openDialog(7, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action1)){
			if (btnOpenTrack8Action1.getText() == "-"){
				btnOpenTrack8Action1.setText("+");
				lblTrack8Action1.setVisible(false);
				sliderTrack8Action1.setVisible(false);
			} else {
				btnOpenTrack8Action1.setText("-");
				lblTrack8Action1.setVisible(true);
				sliderTrack8Action1.setVisible(true);
				openDialog(8, 0);

			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action2)){
			if (btnOpenTrack8Action2.getText() == "-"){
				btnOpenTrack8Action2.setText("+");
				lblTrack8Action2.setVisible(false);
				sliderTrack8Action2.setVisible(false);
			} else {
				btnOpenTrack8Action2.setText("-");
				lblTrack8Action2.setVisible(true);
				sliderTrack8Action2.setVisible(true);
				openDialog(8, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action3)){
			if (btnOpenTrack8Action3.getText() == "-"){
				btnOpenTrack8Action3.setText("+");
				lblTrack8Action3.setVisible(false);
				sliderTrack8Action3.setVisible(false);
			} else {
				btnOpenTrack8Action3.setText("-");
				lblTrack8Action3.setVisible(true);
				sliderTrack8Action3.setVisible(true);
				openDialog(8, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action4)){
			if (btnOpenTrack8Action4.getText() == "-"){
				btnOpenTrack8Action4.setText("+");
				lblTrack8Action4.setVisible(false);
				sliderTrack8Action4.setVisible(false);
			} else {
				btnOpenTrack8Action4.setText("-");
				lblTrack8Action4.setVisible(true);
				sliderTrack8Action4.setVisible(true);
				openDialog(8, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action5)){
			if (btnOpenTrack8Action5.getText() == "-"){
				btnOpenTrack8Action5.setText("+");
				lblTrack8Action5.setVisible(false);
				sliderTrack8Action5.setVisible(false);
			} else {
				btnOpenTrack8Action5.setText("-");
				lblTrack8Action5.setVisible(true);
				sliderTrack8Action5.setVisible(true);
				openDialog(8, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action6)){
			if (btnOpenTrack8Action6.getText() == "-"){
				btnOpenTrack8Action6.setText("+");
				lblTrack8Action6.setVisible(false);
				sliderTrack8Action6.setVisible(false);
			} else {
				btnOpenTrack8Action6.setText("-");
				lblTrack8Action6.setVisible(true);
				sliderTrack8Action6.setVisible(true);
				openDialog(8, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack8Action7)){
			if (btnOpenTrack8Action7.getText() == "-"){
				btnOpenTrack8Action7.setText("+");
				lblTrack8Action7.setVisible(false);
				sliderTrack8Action7.setVisible(false);
			} else {
				btnOpenTrack8Action7.setText("-");
				lblTrack8Action7.setVisible(true);
				sliderTrack8Action7.setVisible(true);
				openDialog(8, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action1)){
			if (btnOpenTrack9Action1.getText() == "-"){
				btnOpenTrack9Action1.setText("+");
				lblTrack9Action1.setVisible(false);
				sliderTrack9Action1.setVisible(false);
			} else {
				btnOpenTrack9Action1.setText("-");
				lblTrack9Action1.setVisible(true);
				sliderTrack9Action1.setVisible(true);
				openDialog(9, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action2)){
			if (btnOpenTrack9Action2.getText() == "-"){
				btnOpenTrack9Action2.setText("+");
				lblTrack9Action2.setVisible(false);
				sliderTrack9Action2.setVisible(false);
			} else {
				btnOpenTrack9Action2.setText("-");
				lblTrack9Action2.setVisible(true);
				sliderTrack9Action2.setVisible(true);
				openDialog(9, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action3)){
			if (btnOpenTrack9Action3.getText() == "-"){
				btnOpenTrack9Action3.setText("+");
				lblTrack9Action3.setVisible(false);
				sliderTrack9Action3.setVisible(false);
			} else {
				btnOpenTrack9Action3.setText("-");
				lblTrack9Action3.setVisible(true);
				sliderTrack9Action3.setVisible(true);
				openDialog(9, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action4)){
			if (btnOpenTrack9Action4.getText() == "-"){
				btnOpenTrack9Action4.setText("+");
				lblTrack9Action4.setVisible(false);
				sliderTrack9Action4.setVisible(false);
			} else {
				btnOpenTrack9Action4.setText("-");
				lblTrack9Action4.setVisible(true);
				sliderTrack9Action4.setVisible(true);
				openDialog(9, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action5)){
			if (btnOpenTrack9Action5.getText() == "-"){
				btnOpenTrack9Action5.setText("+");
				lblTrack9Action5.setVisible(false);
				sliderTrack9Action5.setVisible(false);
			} else {
				btnOpenTrack9Action5.setText("-");
				lblTrack9Action5.setVisible(true);
				sliderTrack9Action5.setVisible(true);
				openDialog(9, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action6)){
			if (btnOpenTrack9Action6.getText() == "-"){
				btnOpenTrack9Action6.setText("+");
				lblTrack9Action6.setVisible(false);
				sliderTrack9Action6.setVisible(false);
			} else {
				btnOpenTrack9Action6.setText("-");
				lblTrack9Action6.setVisible(true);
				sliderTrack9Action6.setVisible(true);
				openDialog(9, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack9Action7)){
			if (btnOpenTrack9Action7.getText() == "-"){
				btnOpenTrack9Action7.setText("+");
				lblTrack9Action7.setVisible(false);
				sliderTrack9Action7.setVisible(false);
			} else {
				btnOpenTrack9Action7.setText("-");
				lblTrack9Action7.setVisible(true);
				sliderTrack9Action7.setVisible(true);
				openDialog(9, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action1)){
			if (btnOpenTrack10Action1.getText() == "-"){
				btnOpenTrack10Action1.setText("+");
				lblTrack10Action1.setVisible(false);
				sliderTrack10Action1.setVisible(false);
			} else {
				btnOpenTrack10Action1.setText("-");
				lblTrack10Action1.setVisible(true);
				sliderTrack10Action1.setVisible(true);
				openDialog(10, 0);

			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action2)){
			if (btnOpenTrack10Action2.getText() == "-"){
				btnOpenTrack10Action2.setText("+");
				lblTrack10Action2.setVisible(false);
				sliderTrack10Action2.setVisible(false);
			} else {
				btnOpenTrack10Action2.setText("-");
				lblTrack10Action2.setVisible(true);
				sliderTrack10Action2.setVisible(true);
				openDialog(10, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action3)){
			if (btnOpenTrack10Action3.getText() == "-"){
				btnOpenTrack10Action3.setText("+");
				lblTrack10Action3.setVisible(false);
				sliderTrack10Action3.setVisible(false);
			} else {
				btnOpenTrack10Action3.setText("-");
				lblTrack10Action3.setVisible(true);
				sliderTrack10Action3.setVisible(true);
				openDialog(10, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action4)){
			if (btnOpenTrack10Action4.getText() == "-"){
				btnOpenTrack10Action4.setText("+");
				lblTrack10Action4.setVisible(false);
				sliderTrack10Action4.setVisible(false);
			} else {
				btnOpenTrack10Action4.setText("-");
				lblTrack10Action4.setVisible(true);
				sliderTrack10Action4.setVisible(true);
				openDialog(10, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action5)){
			if (btnOpenTrack10Action5.getText() == "-"){
				btnOpenTrack10Action5.setText("+");
				lblTrack10Action5.setVisible(false);
				sliderTrack10Action5.setVisible(false);
			} else {
				btnOpenTrack10Action5.setText("-");
				lblTrack10Action5.setVisible(true);
				sliderTrack10Action5.setVisible(true);
				openDialog(10, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action6)){
			if (btnOpenTrack10Action6.getText() == "-"){
				btnOpenTrack10Action6.setText("+");
				lblTrack10Action6.setVisible(false);
				sliderTrack10Action6.setVisible(false);
			} else {
				btnOpenTrack10Action6.setText("-");
				lblTrack10Action6.setVisible(true);
				sliderTrack10Action6.setVisible(true);
				openDialog(10, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack10Action7)){
			if (btnOpenTrack10Action7.getText() == "-"){
				btnOpenTrack10Action7.setText("+");
				lblTrack10Action7.setVisible(false);
				sliderTrack10Action7.setVisible(false);
			} else {
				btnOpenTrack10Action7.setText("-");
				lblTrack10Action7.setVisible(true);
				sliderTrack10Action7.setVisible(true);
				openDialog(10, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action1)){
			if (btnOpenTrack11Action1.getText() == "-"){
				btnOpenTrack11Action1.setText("+");
				lblTrack11Action1.setVisible(false);
				sliderTrack11Action1.setVisible(false);
			} else {
				btnOpenTrack11Action1.setText("-");
				lblTrack11Action1.setVisible(true);
				sliderTrack11Action1.setVisible(true);
				openDialog(11, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action2)){
			if (btnOpenTrack11Action2.getText() == "-"){
				btnOpenTrack11Action2.setText("+");
				lblTrack11Action2.setVisible(false);
				sliderTrack11Action2.setVisible(false);
			} else {
				btnOpenTrack11Action2.setText("-");
				lblTrack11Action2.setVisible(true);
				sliderTrack11Action2.setVisible(true);
				openDialog(11, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action3)){
			if (btnOpenTrack11Action3.getText() == "-"){
				btnOpenTrack11Action3.setText("+");
				lblTrack11Action3.setVisible(false);
				sliderTrack11Action3.setVisible(false);
			} else {
				btnOpenTrack11Action3.setText("-");
				lblTrack11Action3.setVisible(true);
				sliderTrack11Action3.setVisible(true);
				openDialog(11, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action4)){
			if (btnOpenTrack11Action4.getText() == "-"){
				btnOpenTrack11Action4.setText("+");
				lblTrack11Action4.setVisible(false);
				sliderTrack11Action4.setVisible(false);
			} else {
				btnOpenTrack11Action4.setText("-");
				lblTrack11Action4.setVisible(true);
				sliderTrack11Action4.setVisible(true);
				openDialog(11, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action5)){
			if (btnOpenTrack11Action5.getText() == "-"){
				btnOpenTrack11Action5.setText("+");
				lblTrack11Action5.setVisible(false);
				sliderTrack11Action5.setVisible(false);
			} else {
				btnOpenTrack11Action5.setText("-");
				lblTrack11Action5.setVisible(true);
				sliderTrack11Action5.setVisible(true);
				openDialog(11, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action6)){
			if (btnOpenTrack11Action6.getText() == "-"){
				btnOpenTrack11Action6.setText("+");
				lblTrack11Action6.setVisible(false);
				sliderTrack11Action6.setVisible(false);
			} else {
				btnOpenTrack11Action6.setText("-");
				lblTrack11Action6.setVisible(true);
				sliderTrack11Action6.setVisible(true);
				openDialog(11, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack11Action7)){
			if (btnOpenTrack11Action7.getText() == "-"){
				btnOpenTrack11Action7.setText("+");
				lblTrack11Action7.setVisible(false);
				sliderTrack11Action7.setVisible(false);
			} else {
				btnOpenTrack11Action7.setText("-");
				lblTrack11Action7.setVisible(true);
				sliderTrack11Action7.setVisible(true);
				openDialog(11, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action1)){
			if (btnOpenTrack12Action1.getText() == "-"){
				btnOpenTrack12Action1.setText("+");
				lblTrack12Action1.setVisible(false);
				sliderTrack12Action1.setVisible(false);
			} else {
				btnOpenTrack12Action1.setText("-");
				lblTrack12Action1.setVisible(true);
				sliderTrack12Action1.setVisible(true);
				openDialog(12, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action2)){
			if (btnOpenTrack12Action2.getText() == "-"){
				btnOpenTrack12Action2.setText("+");
				lblTrack12Action2.setVisible(false);
				sliderTrack12Action2.setVisible(false);
			} else {
				btnOpenTrack12Action2.setText("-");
				lblTrack12Action2.setVisible(true);
				sliderTrack12Action2.setVisible(true);
				openDialog(12, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action3)){
			if (btnOpenTrack12Action3.getText() == "-"){
				btnOpenTrack12Action3.setText("+");
				lblTrack12Action3.setVisible(false);
				sliderTrack12Action3.setVisible(false);
			} else {
				btnOpenTrack12Action3.setText("-");
				lblTrack12Action3.setVisible(true);
				sliderTrack12Action3.setVisible(true);
				openDialog(12, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action4)){
			if (btnOpenTrack12Action4.getText() == "-"){
				btnOpenTrack12Action4.setText("+");
				lblTrack12Action4.setVisible(false);
				sliderTrack12Action4.setVisible(false);
			} else {
				btnOpenTrack12Action4.setText("-");
				lblTrack12Action4.setVisible(true);
				sliderTrack12Action4.setVisible(true);
				openDialog(12, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action5)){
			if (btnOpenTrack12Action5.getText() == "-"){
				btnOpenTrack12Action5.setText("+");
				lblTrack12Action5.setVisible(false);
				sliderTrack12Action5.setVisible(false);
			} else {
				btnOpenTrack12Action5.setText("-");
				lblTrack12Action5.setVisible(true);
				sliderTrack12Action5.setVisible(true);
				openDialog(12, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action6)){
			if (btnOpenTrack12Action6.getText() == "-"){
				btnOpenTrack12Action6.setText("+");
				lblTrack12Action6.setVisible(false);
				sliderTrack12Action6.setVisible(false);
			} else {
				btnOpenTrack12Action6.setText("-");
				lblTrack12Action6.setVisible(true);
				sliderTrack12Action6.setVisible(true);
				openDialog(12, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack12Action7)){
			if (btnOpenTrack12Action7.getText() == "-"){
				btnOpenTrack12Action7.setText("+");
				lblTrack12Action7.setVisible(false);
				sliderTrack12Action7.setVisible(false);
			} else {
				btnOpenTrack12Action7.setText("-");
				lblTrack12Action7.setVisible(true);
				sliderTrack12Action7.setVisible(true);
				openDialog(12, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action1)){
			if (btnOpenTrack13Action1.getText() == "-"){
				btnOpenTrack13Action1.setText("+");
				lblTrack13Action1.setVisible(false);
				sliderTrack13Action1.setVisible(false);
			} else {
				btnOpenTrack13Action1.setText("-");
				lblTrack13Action1.setVisible(true);
				sliderTrack13Action1.setVisible(true);
				openDialog(13, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action2)){
			if (btnOpenTrack13Action2.getText() == "-"){
				btnOpenTrack13Action2.setText("+");
				lblTrack13Action2.setVisible(false);
				sliderTrack13Action2.setVisible(false);
			} else {
				btnOpenTrack13Action2.setText("-");
				lblTrack13Action2.setVisible(true);
				sliderTrack13Action2.setVisible(true);
				openDialog(13, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action3)){
			if (btnOpenTrack13Action3.getText() == "-"){
				btnOpenTrack13Action3.setText("+");
				lblTrack13Action3.setVisible(false);
				sliderTrack13Action3.setVisible(false);
			} else {
				btnOpenTrack13Action3.setText("-");
				lblTrack13Action3.setVisible(true);
				sliderTrack13Action3.setVisible(true);
				openDialog(13, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action4)){
			if (btnOpenTrack13Action4.getText() == "-"){
				btnOpenTrack13Action4.setText("+");
				lblTrack13Action4.setVisible(false);
				sliderTrack13Action4.setVisible(false);
			} else {
				btnOpenTrack13Action4.setText("-");
				lblTrack13Action4.setVisible(true);
				sliderTrack13Action4.setVisible(true);
				openDialog(13, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action5)){
			if (btnOpenTrack13Action5.getText() == "-"){
				btnOpenTrack13Action5.setText("+");
				lblTrack13Action5.setVisible(false);
				sliderTrack13Action5.setVisible(false);
			} else {
				btnOpenTrack13Action5.setText("-");
				lblTrack13Action5.setVisible(true);
				sliderTrack13Action5.setVisible(true);
				openDialog(13, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action6)){
			if (btnOpenTrack13Action6.getText() == "-"){
				btnOpenTrack13Action6.setText("+");
				lblTrack13Action6.setVisible(false);
				sliderTrack13Action6.setVisible(false);
			} else {
				btnOpenTrack13Action6.setText("-");
				lblTrack13Action6.setVisible(true);
				sliderTrack13Action6.setVisible(true);
				openDialog(13, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack13Action7)){
			if (btnOpenTrack13Action7.getText() == "-"){
				btnOpenTrack13Action7.setText("+");
				lblTrack13Action7.setVisible(false);
				sliderTrack13Action7.setVisible(false);
			} else {
				btnOpenTrack13Action7.setText("-");
				lblTrack13Action7.setVisible(true);
				sliderTrack13Action7.setVisible(true);
				openDialog(13, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action1)){
			if (btnOpenTrack14Action1.getText() == "-"){
				btnOpenTrack14Action1.setText("+");
				lblTrack14Action1.setVisible(false);
				sliderTrack14Action1.setVisible(false);
			} else {
				btnOpenTrack14Action1.setText("-");
				lblTrack14Action1.setVisible(true);
				sliderTrack14Action1.setVisible(true);
				openDialog(14, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action2)){
			if (btnOpenTrack14Action2.getText() == "-"){
				btnOpenTrack14Action2.setText("+");
				lblTrack14Action2.setVisible(false);
				sliderTrack14Action2.setVisible(false);
			} else {
				btnOpenTrack14Action2.setText("-");
				lblTrack14Action2.setVisible(true);
				sliderTrack14Action2.setVisible(true);
				openDialog(14, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action3)){
			if (btnOpenTrack14Action3.getText() == "-"){
				btnOpenTrack14Action3.setText("+");
				lblTrack14Action3.setVisible(false);
				sliderTrack14Action3.setVisible(false);
			} else {
				btnOpenTrack14Action3.setText("-");
				lblTrack14Action3.setVisible(true);
				sliderTrack14Action3.setVisible(true);
				openDialog(14, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action4)){
			if (btnOpenTrack14Action4.getText() == "-"){
				btnOpenTrack14Action4.setText("+");
				lblTrack14Action4.setVisible(false);
				sliderTrack14Action4.setVisible(false);
			} else {
				btnOpenTrack14Action4.setText("-");
				lblTrack14Action4.setVisible(true);
				sliderTrack14Action4.setVisible(true);
				openDialog(14, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action5)){
			if (btnOpenTrack14Action5.getText() == "-"){
				btnOpenTrack14Action5.setText("+");
				lblTrack14Action5.setVisible(false);
				sliderTrack14Action5.setVisible(false);
			} else {
				btnOpenTrack14Action5.setText("-");
				lblTrack14Action5.setVisible(true);
				sliderTrack14Action5.setVisible(true);
				openDialog(14, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action6)){
			if (btnOpenTrack14Action6.getText() == "-"){
				btnOpenTrack14Action6.setText("+");
				lblTrack14Action6.setVisible(false);
				sliderTrack14Action6.setVisible(false);
			} else {
				btnOpenTrack14Action6.setText("-");
				lblTrack14Action6.setVisible(true);
				sliderTrack14Action6.setVisible(true);
				openDialog(14, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack14Action7)){
			if (btnOpenTrack14Action7.getText() == "-"){
				btnOpenTrack14Action7.setText("+");
				lblTrack14Action7.setVisible(false);
				sliderTrack14Action7.setVisible(false);
			} else {
				btnOpenTrack14Action7.setText("-");
				lblTrack14Action7.setVisible(true);
				sliderTrack14Action7.setVisible(true);
				openDialog(14, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action1)){
			if (btnOpenTrack15Action1.getText() == "-"){
				btnOpenTrack15Action1.setText("+");
				lblTrack15Action1.setVisible(false);
				sliderTrack15Action1.setVisible(false);
			} else {
				btnOpenTrack15Action1.setText("-");
				lblTrack15Action1.setVisible(true);
				sliderTrack15Action1.setVisible(true);
				openDialog(15, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action2)){
			if (btnOpenTrack15Action2.getText() == "-"){
				btnOpenTrack15Action2.setText("+");
				lblTrack15Action2.setVisible(false);
				sliderTrack15Action2.setVisible(false);
			} else {
				btnOpenTrack15Action2.setText("-");
				lblTrack15Action2.setVisible(true);
				sliderTrack15Action2.setVisible(true);
				openDialog(15, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action3)){
			if (btnOpenTrack15Action3.getText() == "-"){
				btnOpenTrack15Action3.setText("+");
				lblTrack15Action3.setVisible(false);
				sliderTrack15Action3.setVisible(false);
			} else {
				btnOpenTrack15Action3.setText("-");
				lblTrack15Action3.setVisible(true);
				sliderTrack15Action3.setVisible(true);
				openDialog(15, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action4)){
			if (btnOpenTrack15Action4.getText() == "-"){
				btnOpenTrack15Action4.setText("+");
				lblTrack15Action4.setVisible(false);
				sliderTrack15Action4.setVisible(false);
			} else {
				btnOpenTrack15Action4.setText("-");
				lblTrack15Action4.setVisible(true);
				sliderTrack15Action4.setVisible(true);
				openDialog(15, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action5)){
			if (btnOpenTrack15Action5.getText() == "-"){
				btnOpenTrack15Action5.setText("+");
				lblTrack15Action5.setVisible(false);
				sliderTrack15Action5.setVisible(false);
			} else {
				btnOpenTrack15Action5.setText("-");
				lblTrack15Action5.setVisible(true);
				sliderTrack15Action5.setVisible(true);
				openDialog(15, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action6)){
			if (btnOpenTrack15Action6.getText() == "-"){
				btnOpenTrack15Action6.setText("+");
				lblTrack15Action6.setVisible(false);
				sliderTrack15Action6.setVisible(false);
			} else {
				btnOpenTrack15Action6.setText("-");
				lblTrack15Action6.setVisible(true);
				sliderTrack15Action6.setVisible(true);
				openDialog(15, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack15Action7)){
			if (btnOpenTrack15Action7.getText() == "-"){
				btnOpenTrack15Action7.setText("+");
				lblTrack15Action7.setVisible(false);
				sliderTrack15Action7.setVisible(false);
			} else {
				btnOpenTrack15Action7.setText("-");
				lblTrack15Action7.setVisible(true);
				sliderTrack15Action7.setVisible(true);
				openDialog(15, 6);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action1)){
			if (btnOpenTrack16Action1.getText() == "-"){
				btnOpenTrack16Action1.setText("+");
				lblTrack16Action1.setVisible(false);
				sliderTrack16Action1.setVisible(false);
			} else {
				btnOpenTrack16Action1.setText("-");
				lblTrack16Action1.setVisible(true);
				sliderTrack16Action1.setVisible(true);
				openDialog(16, 0);
			}	
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action2)){
			if (btnOpenTrack16Action2.getText() == "-"){
				btnOpenTrack16Action2.setText("+");
				lblTrack16Action2.setVisible(false);
				sliderTrack16Action2.setVisible(false);
			} else {
				btnOpenTrack16Action2.setText("-");
				lblTrack16Action2.setVisible(true);
				sliderTrack16Action2.setVisible(true);
				openDialog(16, 1);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action3)){
			if (btnOpenTrack16Action3.getText() == "-"){
				btnOpenTrack16Action3.setText("+");
				lblTrack16Action3.setVisible(false);
				sliderTrack16Action3.setVisible(false);
			} else {
				btnOpenTrack16Action3.setText("-");
				lblTrack16Action3.setVisible(true);
				sliderTrack16Action3.setVisible(true);
				openDialog(16, 2);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action4)){
			if (btnOpenTrack16Action4.getText() == "-"){
				btnOpenTrack16Action4.setText("+");
				lblTrack16Action4.setVisible(false);
				sliderTrack16Action4.setVisible(false);
			} else {
				btnOpenTrack16Action4.setText("-");
				lblTrack16Action4.setVisible(true);
				sliderTrack16Action4.setVisible(true);
				openDialog(16, 3);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action5)){
			if (btnOpenTrack16Action5.getText() == "-"){
				btnOpenTrack16Action5.setText("+");
				lblTrack16Action5.setVisible(false);
				sliderTrack16Action5.setVisible(false);
			} else {
				btnOpenTrack16Action5.setText("-");
				lblTrack16Action5.setVisible(true);
				sliderTrack16Action5.setVisible(true);
				openDialog(16, 4);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action6)){
			if (btnOpenTrack16Action6.getText() == "-"){
				btnOpenTrack16Action6.setText("+");
				lblTrack16Action6.setVisible(false);
				sliderTrack16Action6.setVisible(false);
			} else {
				btnOpenTrack16Action6.setText("-");
				lblTrack16Action6.setVisible(true);
				sliderTrack16Action6.setVisible(true);
				openDialog(16, 5);
			}
		}
		if (aEvent.getSource().equals(btnOpenTrack16Action7)){
			if (btnOpenTrack16Action7.getText() == "-"){
				btnOpenTrack16Action7.setText("+");
				lblTrack16Action7.setVisible(false);
				sliderTrack16Action7.setVisible(false);
			} else {
				btnOpenTrack16Action7.setText("-");
				lblTrack16Action7.setVisible(true);
				sliderTrack16Action7.setVisible(true);
				openDialog(16, 6);
			}
		}

		// Channel Combo Boxes
		if (aEvent.getSource().equals(cbChannelTrack1)){
			settings.setTrackChannel(1, cbChannelTrack1.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack2)){
			settings.setTrackChannel(2, cbChannelTrack2.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack3)){
			settings.setTrackChannel(3, cbChannelTrack3.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack4)){
			settings.setTrackChannel(4, cbChannelTrack4.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack5)){
			settings.setTrackChannel(5, cbChannelTrack5.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack6)){
			settings.setTrackChannel(6, cbChannelTrack6.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack7)){
			settings.setTrackChannel(7, cbChannelTrack7.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack8)){
			settings.setTrackChannel(8, cbChannelTrack8.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack9)){
			settings.setTrackChannel(9, cbChannelTrack9.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack10)){
			settings.setTrackChannel(10, cbChannelTrack10.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack11)){
			settings.setTrackChannel(11, cbChannelTrack11.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack12)){
			settings.setTrackChannel(12, cbChannelTrack12.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack13)){
			settings.setTrackChannel(13, cbChannelTrack13.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack14)){
			settings.setTrackChannel(14, cbChannelTrack14.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack15)){
			settings.setTrackChannel(15, cbChannelTrack15.getSelectedIndex());
		}
		if (aEvent.getSource().equals(cbChannelTrack16)){
			settings.setTrackChannel(16, cbChannelTrack16.getSelectedIndex());
		}

		if (aEvent.getSource().equals(cbTapTempoTap)){
			settings.setTapTapValue(cbTapTempoTap.getSelectedIndex());
		}

		if (aEvent.getSource().equals(cbGlobalAction1Max)){
			settings.setGlobalActionValue(cbGlobalAction1Max.getSelectedIndex(), 1, true);
		}

		if (aEvent.getSource().equals(cbGlobalAction1Min)){
			settings.setGlobalActionValue(cbGlobalAction1Min.getSelectedIndex(), 1, false);
		}

		if (aEvent.getSource().equals(cbGlobalAction2Max)){
			settings.setGlobalActionValue(cbGlobalAction2Max.getSelectedIndex(), 2, true);
		}

		if (aEvent.getSource().equals(cbGlobalAction2Min)){
			settings.setGlobalActionValue(cbGlobalAction2Min.getSelectedIndex(), 2, false);
		}

		if (aEvent.getSource().equals(btnConfiguration)){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ConfigGUI window = new ConfigGUI(settings);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * Getting the set minimum value for action 1 of the global commands
	 * @return Value of the minimum value
	 */
	public static int getGlobalAction1Min() {
		return Integer.valueOf(cbGlobalAction1Min.getSelectedItem().toString());
	}
	
	/**
	 * Getting the set maximum value for action 1 of the global commands
	 * @return Value of the maximum value
	 */
	public static int getGlobalAction1Max() {
		return Integer.valueOf(cbGlobalAction1Max.getSelectedItem().toString());
	}
	
	/**
	 * Getting the set minimum value for action 2 of the global commands
	 * @return Value of the minimum value
	 */
	public static int getGlobalAction2Min() {
		return Integer.valueOf(cbGlobalAction2Min.getSelectedItem().toString());
	}
	
	/**
	 * Getting the set maximum value for action 2 of the global commands
	 * @return Value of the maximum value
	 */
	public static int getGlobalAction2Max() {
		return Integer.valueOf(cbGlobalAction2Max.getSelectedItem().toString());
	}
	
	/**
	 * Getting the set value for the global action 1 axis
	 * @return Value of the axis
	 */
	public static String getGlobalAction1Axis() {
		return cbGlobalAction1Axis.getSelectedItem().toString();
	}
	
	/**
	 * Getting the set value for the global action 2 axis
	 * @return Value of the axis
	 */
	public static String getGlobalAction2Axis() {
		return cbGlobalAction2Axis.getSelectedItem().toString();
	}
	
	/**
	 * Getting number of left fingers
	 * @return Number of fingers
	 */
	public static int getLeftFingers(){
		return Integer.parseInt(tfLeftFingers.getText());
	}
	
	/**
	 * Getting the selected track value
	 * @return Selected track
	 */
	public static int getSelectedTrack(){
		String track = tfSelectedTrackDigit1.getText();
		if (track.equals("")){
			return 0;
		} else {
			return Integer.valueOf(tfSelectedTrackDigit1.getText());
		}
	}
	
	/**
	 * Getting the selected track channel
	 * @return Selected track channel
	 */
	public static int getSelectedTrackChannel(){
		int x = getSelectedTrack();
		switch (x){
		case 0:
			return 0;
		case 1:
			return cbChannelTrack1.getSelectedIndex();
		case 2:
			return cbChannelTrack2.getSelectedIndex();
		case 3:
			return cbChannelTrack3.getSelectedIndex();
		case 4:
			return cbChannelTrack4.getSelectedIndex();
		case 5:
			return cbChannelTrack5.getSelectedIndex();
		case 6:
			return cbChannelTrack6.getSelectedIndex();
		case 7:
			return cbChannelTrack7.getSelectedIndex();
		case 8:
			return cbChannelTrack8.getSelectedIndex();
		case 9:
			return cbChannelTrack9.getSelectedIndex();
		case 10:
			return cbChannelTrack10.getSelectedIndex();
		case 11:
			return cbChannelTrack11.getSelectedIndex();
		case 12:
			return cbChannelTrack12.getSelectedIndex();
		case 13:
			return cbChannelTrack13.getSelectedIndex();
		case 14:
			return cbChannelTrack14.getSelectedIndex();
		case 15:
			return cbChannelTrack15.getSelectedIndex();
		case 16:
			return cbChannelTrack16.getSelectedIndex();
		}
		return -1;
	}

	static int selectedTrack = 0;


	/**
	 * Setting the value for a slider
	 * @param aTrack - Track
	 * @param aAction - Action
	 * @param aValue - Value
	 * @param aAxis - Axis
	 */
	public static void setSliderValue(int aTrack, int aAction, int aValue, int aAxis) {

		String strAxis = "";

		if (aAxis == 1){
			strAxis = "X";
		} else if (aAxis == 2){
			strAxis = "Y";
		} else if (aAxis == 3){
			strAxis = "Z";
		} else if (aAxis == 4){
			strAxis = "X (i)";
		} else if (aAxis == 5){
			strAxis = "Y (i)";
		} else if (aAxis == 6){
			strAxis = "X (i)";
		}

		if (aTrack == 1){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack1Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack1Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack1Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack1Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack1Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack1Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack1Action7.setValue(aValue);
			}
			tfAxisTrack1.setText(strAxis);
		} else if (aTrack == 2){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack2Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack2Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack2Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack2Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack2Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack2Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack2Action7.setValue(aValue);
			}
			tfAxisTrack2.setText(strAxis);
		} else if (aTrack == 3){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack3Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack3Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack3Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack3Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack3Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack3Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack3Action7.setValue(aValue);
			}
			tfAxisTrack3.setText(strAxis);
		} else if (aTrack == 4){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack4Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack4Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack4Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack4Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack4Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack4Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack4Action7.setValue(aValue);
			}
			tfAxisTrack4.setText(strAxis);
		} else if (aTrack == 5){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack5Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack5Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack5Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack5Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack5Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack5Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack5Action7.setValue(aValue);
			}
			tfAxisTrack5.setText(strAxis);
		} else if (aTrack == 6){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack6Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack6Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack6Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack6Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack6Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack6Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack6Action7.setValue(aValue);
			}
			tfAxisTrack6.setText(strAxis);
		} else if (aTrack == 7){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack7Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack7Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack7Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack7Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack7Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack7Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack7Action7.setValue(aValue);
			}
			tfAxisTrack7.setText(strAxis);
		} else if (aTrack == 8){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack8Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack8Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack8Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack8Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack8Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack8Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack8Action7.setValue(aValue);
			}
			tfAxisTrack8.setText(strAxis);
		} else if (aTrack == 9){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack9Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack9Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack9Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack9Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack9Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack9Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack9Action7.setValue(aValue);
			}
			tfAxisTrack9.setText(strAxis);
		} else if (aTrack == 10){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack10Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack10Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack10Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack10Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack10Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack10Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack10Action7.setValue(aValue);
			}
			tfAxisTrack10.setText(strAxis);
		} else if (aTrack == 11){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack11Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack11Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack11Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack11Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack11Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack11Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack11Action7.setValue(aValue);
			}
			tfAxisTrack11.setText(strAxis);
		} else if (aTrack == 12){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack12Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack12Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack12Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack12Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack12Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack12Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack12Action7.setValue(aValue);
			}
			tfAxisTrack12.setText(strAxis);
		} else if (aTrack == 13){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack13Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack13Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack13Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack13Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack13Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack13Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack13Action7.setValue(aValue);
			}
			tfAxisTrack13.setText(strAxis);
		} else if (aTrack == 14){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack14Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack14Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack14Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack14Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack14Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack14Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack14Action7.setValue(aValue);
			}
			tfAxisTrack14.setText(strAxis);
		} else if (aTrack == 15){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack15Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack15Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack15Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack15Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack15Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack15Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack15Action7.setValue(aValue);
			}
			tfAxisTrack15.setText(strAxis);
		} else if (aTrack == 16){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderTrack16Action1.setValue(aValue);
			} else if (aAction == 3){
				sliderTrack16Action2.setValue(aValue);
			} else if (aAction == 4){
				sliderTrack16Action3.setValue(aValue);
			} else if (aAction == 5){
				sliderTrack16Action4.setValue(aValue);
			} else if (aAction == 6){
				sliderTrack16Action5.setValue(aValue);
			} else if (aAction == 7){
				sliderTrack16Action6.setValue(aValue);
			} else if (aAction == 8){
				sliderTrack16Action7.setValue(aValue);
			}
			tfAxisTrack16.setText(strAxis);
		} 

		else if (aTrack == 17){
			if (aAction == 1){
				// Selecting track 1
			} else if (aAction == 2){
				sliderGlobalAction1.setValue(aValue);
			} else if (aAction == 3){
				sliderGlobalAction2.setValue(aValue);
			} 
		} 
	}
	
	/**
	 * Setting the value the track background
	 * @param aTrack - Track
	 */
	public static void selectTrack(int aTrack) {
		tfSelectedTrackDigit1.setText(Integer.toString(aTrack));

		setTrackColour(1, COLOR_BACKGROUND);
		setTrackColour(2, COLOR_BACKGROUND);
		setTrackColour(3, COLOR_BACKGROUND);
		setTrackColour(4, COLOR_BACKGROUND);
		setTrackColour(5, COLOR_BACKGROUND);
		setTrackColour(6, COLOR_BACKGROUND);
		setTrackColour(7, COLOR_BACKGROUND);
		setTrackColour(8, COLOR_BACKGROUND);
		setTrackColour(9, COLOR_BACKGROUND);
		setTrackColour(10, COLOR_BACKGROUND);
		setTrackColour(11, COLOR_BACKGROUND);
		setTrackColour(12, COLOR_BACKGROUND);
		setTrackColour(13, COLOR_BACKGROUND);
		setTrackColour(14, COLOR_BACKGROUND);
		setTrackColour(15, COLOR_BACKGROUND);
		setTrackColour(16, COLOR_BACKGROUND);
		setTrackColour(17, COLOR_BACKGROUND);

		if (aTrack == 1){
			setTrackColour(1, COLOUR_SELECTED);
		} else if (aTrack == 2){
			setTrackColour(2, COLOUR_SELECTED);
		} else if (aTrack == 3){
			setTrackColour(3, COLOUR_SELECTED);
		} else if (aTrack == 4){
			setTrackColour(4, COLOUR_SELECTED);
		} else if (aTrack == 5){
			setTrackColour(5, COLOUR_SELECTED);
		} else if (aTrack == 6){
			setTrackColour(6, COLOUR_SELECTED);
		} else if (aTrack == 7){
			setTrackColour(7, COLOUR_SELECTED);
		} else if (aTrack == 8){
			setTrackColour(8, COLOUR_SELECTED);
		} else if (aTrack == 9){
			setTrackColour(9, COLOUR_SELECTED);
		} else if (aTrack == 10){
			setTrackColour(10, COLOUR_SELECTED);
		} else if (aTrack == 11){
			setTrackColour(11, COLOUR_SELECTED);
		} else if (aTrack == 12){
			setTrackColour(12, COLOUR_SELECTED);
		} else if (aTrack == 13){
			setTrackColour(13, COLOUR_SELECTED);
		} else if (aTrack == 14){
			setTrackColour(14, COLOUR_SELECTED);
		} else if (aTrack == 15){
			setTrackColour(15, COLOUR_SELECTED);
		} else if (aTrack == 16){
			setTrackColour(16, COLOUR_SELECTED);
		} else if (aTrack == 17){
			setTrackColour(17, COLOUR_SELECTED);
		} 
	}
	
	/**
	 * Setting the tracks background colour
	 * @param aTrack - Track
	 * @param aColour - Colour to be the background
	 */
	public static void setTrackColour(int aTrack, Color aColour){
		if (aTrack == 1){
			panelTrack1.setBackground(aColour);
			sliderTrack1Action1.setBackground(aColour);
			sliderTrack1Action2.setBackground(aColour);
			sliderTrack1Action3.setBackground(aColour);
			sliderTrack1Action4.setBackground(aColour);
			sliderTrack1Action5.setBackground(aColour);
			sliderTrack1Action6.setBackground(aColour);
			sliderTrack1Action7.setBackground(aColour);
		} else if (aTrack == 2){
			panelTrack2.setBackground(aColour);
			sliderTrack2Action1.setBackground(aColour);
			sliderTrack2Action2.setBackground(aColour);
			sliderTrack2Action3.setBackground(aColour);
			sliderTrack2Action4.setBackground(aColour);
			sliderTrack2Action5.setBackground(aColour);
			sliderTrack2Action6.setBackground(aColour);
			sliderTrack2Action7.setBackground(aColour);
		} else if (aTrack == 3){
			panelTrack3.setBackground(aColour);
			sliderTrack3Action1.setBackground(aColour);
			sliderTrack3Action2.setBackground(aColour);
			sliderTrack3Action3.setBackground(aColour);
			sliderTrack3Action4.setBackground(aColour);
			sliderTrack3Action5.setBackground(aColour);
			sliderTrack3Action6.setBackground(aColour);
			sliderTrack3Action7.setBackground(aColour);
		} else if (aTrack == 4){
			panelTrack4.setBackground(aColour);
			sliderTrack4Action1.setBackground(aColour);
			sliderTrack4Action2.setBackground(aColour);
			sliderTrack4Action3.setBackground(aColour);
			sliderTrack4Action4.setBackground(aColour);
			sliderTrack4Action5.setBackground(aColour);
			sliderTrack4Action6.setBackground(aColour);
			sliderTrack4Action7.setBackground(aColour);
		} else if (aTrack == 5){
			panelTrack5.setBackground(aColour);
			sliderTrack5Action1.setBackground(aColour);
			sliderTrack5Action2.setBackground(aColour);
			sliderTrack5Action3.setBackground(aColour);
			sliderTrack5Action4.setBackground(aColour);
			sliderTrack5Action5.setBackground(aColour);
			sliderTrack5Action6.setBackground(aColour);
			sliderTrack5Action7.setBackground(aColour);
		} else if (aTrack == 6){
			panelTrack6.setBackground(aColour);
			sliderTrack6Action1.setBackground(aColour);
			sliderTrack6Action2.setBackground(aColour);
			sliderTrack6Action3.setBackground(aColour);
			sliderTrack6Action4.setBackground(aColour);
			sliderTrack6Action5.setBackground(aColour);
			sliderTrack6Action6.setBackground(aColour);
			sliderTrack6Action7.setBackground(aColour);
		} else if (aTrack == 7){
			panelTrack7.setBackground(aColour);
			sliderTrack7Action1.setBackground(aColour);
			sliderTrack7Action2.setBackground(aColour);
			sliderTrack7Action3.setBackground(aColour);
			sliderTrack7Action4.setBackground(aColour);
			sliderTrack7Action5.setBackground(aColour);
			sliderTrack7Action6.setBackground(aColour);
			sliderTrack7Action7.setBackground(aColour);
		} else if (aTrack == 8){
			panelTrack8.setBackground(aColour);
			sliderTrack8Action1.setBackground(aColour);
			sliderTrack8Action2.setBackground(aColour);
			sliderTrack8Action3.setBackground(aColour);
			sliderTrack8Action4.setBackground(aColour);
			sliderTrack8Action5.setBackground(aColour);
			sliderTrack8Action6.setBackground(aColour);
			sliderTrack8Action7.setBackground(aColour);
		} else if (aTrack == 9){
			panelTrack9.setBackground(aColour);
			sliderTrack9Action1.setBackground(aColour);
			sliderTrack9Action2.setBackground(aColour);
			sliderTrack9Action3.setBackground(aColour);
			sliderTrack9Action4.setBackground(aColour);
			sliderTrack9Action5.setBackground(aColour);
			sliderTrack9Action6.setBackground(aColour);
			sliderTrack9Action7.setBackground(aColour);
		} else if (aTrack == 10){
			panelTrack10.setBackground(aColour);
			sliderTrack10Action1.setBackground(aColour);
			sliderTrack10Action2.setBackground(aColour);
			sliderTrack10Action3.setBackground(aColour);
			sliderTrack10Action4.setBackground(aColour);
			sliderTrack10Action5.setBackground(aColour);
			sliderTrack10Action6.setBackground(aColour);
			sliderTrack10Action7.setBackground(aColour);
		} else if (aTrack == 11){
			panelTrack11.setBackground(aColour);
			sliderTrack11Action1.setBackground(aColour);
			sliderTrack11Action2.setBackground(aColour);
			sliderTrack11Action3.setBackground(aColour);
			sliderTrack11Action4.setBackground(aColour);
			sliderTrack11Action5.setBackground(aColour);
			sliderTrack11Action6.setBackground(aColour);
			sliderTrack11Action7.setBackground(aColour);
		} else if (aTrack == 12){
			panelTrack12.setBackground(aColour);
			sliderTrack12Action1.setBackground(aColour);
			sliderTrack12Action2.setBackground(aColour);
			sliderTrack12Action3.setBackground(aColour);
			sliderTrack12Action4.setBackground(aColour);
			sliderTrack12Action5.setBackground(aColour);
			sliderTrack12Action6.setBackground(aColour);
			sliderTrack12Action7.setBackground(aColour);
		} else if (aTrack == 13){
			panelTrack13.setBackground(aColour);
			sliderTrack13Action1.setBackground(aColour);
			sliderTrack13Action2.setBackground(aColour);
			sliderTrack13Action3.setBackground(aColour);
			sliderTrack13Action4.setBackground(aColour);
			sliderTrack13Action5.setBackground(aColour);
			sliderTrack13Action6.setBackground(aColour);
			sliderTrack13Action7.setBackground(aColour);
		} else if (aTrack == 14){
			panelTrack14.setBackground(aColour);
			sliderTrack14Action1.setBackground(aColour);
			sliderTrack14Action2.setBackground(aColour);
			sliderTrack14Action3.setBackground(aColour);
			sliderTrack14Action4.setBackground(aColour);
			sliderTrack14Action5.setBackground(aColour);
			sliderTrack14Action6.setBackground(aColour);
			sliderTrack14Action7.setBackground(aColour);
		} else if (aTrack == 15){
			panelTrack15.setBackground(aColour);
			sliderTrack15Action1.setBackground(aColour);
			sliderTrack15Action2.setBackground(aColour);
			sliderTrack15Action3.setBackground(aColour);
			sliderTrack15Action4.setBackground(aColour);
			sliderTrack15Action5.setBackground(aColour);
			sliderTrack15Action6.setBackground(aColour);
			sliderTrack15Action7.setBackground(aColour);
		} else if (aTrack == 16){
			panelTrack16.setBackground(aColour);
			sliderTrack16Action1.setBackground(aColour);
			sliderTrack16Action2.setBackground(aColour);
			sliderTrack16Action3.setBackground(aColour);
			sliderTrack16Action4.setBackground(aColour);
			sliderTrack16Action5.setBackground(aColour);
			sliderTrack16Action6.setBackground(aColour);
			sliderTrack16Action7.setBackground(aColour); 
		} else if (aTrack == 17){
			panelGlobal.setBackground(aColour);
			lblMasterVolume.setBackground(aColour);
			lblTapTempo.setBackground(aColour);
			lblTapTempoTap.setBackground(aColour);
			sliderGlobalAction1.setBackground(aColour);
			sliderGlobalAction2.setBackground(aColour);


		}
	}
	
	/**
	 * Getting the current tap tempo tap value
	 * @return Get tap tempo value
	 */
	public static int getTapTempoValue() {
		return	Integer.valueOf(cbTapTempoTap.getSelectedItem().toString());
	}
	
	/**
	 * Open the dialog to change the command configuration
	 * @param aTrack - Track
	 * @param aSlot - Slider slot
	 */
	public void openDialog(int aTrack, int aSlot){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputDialog window = new InputDialog(aTrack, aSlot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Setting the action data and replacing the command within the table
	 * @param aTrack - Track
	 * @param aColour - Colour to be the background
	 * @param aCommand - The command to replace the old one
	 * @throws IOException 
	 */
	public static void setActionData(int aTrack, int aAction, Command aCommand) throws IOException{
		if (aTrack == getSelectedTrack()){
			LeapMotionListener.setData(aCommand);
		}
		if (aTrack == 1){
			if (aAction == 0){
				lblTrack1Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack1Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack1Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack1Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack1Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack1Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack1Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 2){
			if (aAction == 0){
				lblTrack2Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack2Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack2Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack2Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack2Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack2Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack2Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 3){
			if (aAction == 0){
				lblTrack3Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack3Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack3Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack3Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack3Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack3Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack3Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 4){
			if (aAction == 0){
				lblTrack4Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack4Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack4Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack4Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack4Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack4Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack4Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 5){
			if (aAction == 0){
				lblTrack5Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack5Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack5Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack5Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack5Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack5Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack5Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 6){
			if (aAction == 0){
				lblTrack6Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack6Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack6Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack6Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack6Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack6Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack6Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 7){
			if (aAction == 0){
				lblTrack7Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack7Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack7Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack7Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack7Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack7Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack7Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 8){
			if (aAction == 0){
				lblTrack8Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack8Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack8Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack8Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack8Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack8Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack8Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 9){
			if (aAction == 0){
				lblTrack9Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack9Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack9Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack9Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack9Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack9Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack9Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 10){
			if (aAction == 0){
				lblTrack10Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack10Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack10Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack10Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack10Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack10Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack10Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 11){
			if (aAction == 0){
				lblTrack11Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack11Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack11Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack11Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack11Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack11Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack11Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 12){
			if (aAction == 0){
				lblTrack12Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack12Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack12Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack12Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack12Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack12Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack12Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 13){
			if (aAction == 0){
				lblTrack13Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack13Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack13Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack13Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack13Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack13Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack13Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 14){
			if (aAction == 0){
				lblTrack14Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack14Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack14Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack14Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack14Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack14Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack14Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 15){
			if (aAction == 0){
				lblTrack15Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack15Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack15Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack15Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack15Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack15Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack15Action7.setText(aCommand.getCommand());
			}
		} else if (aTrack == 16){
			if (aAction == 0){
				lblTrack16Action1.setText(aCommand.getCommand());
			} else if (aAction == 1){
				lblTrack16Action2.setText(aCommand.getCommand());
			} else if (aAction == 2){
				lblTrack16Action3.setText(aCommand.getCommand());
			} else if (aAction == 3){
				lblTrack16Action4.setText(aCommand.getCommand());
			} else if (aAction == 4){
				lblTrack16Action5.setText(aCommand.getCommand());
			} else if (aAction == 5){
				lblTrack16Action6.setText(aCommand.getCommand());
			} else if (aAction == 6){
				lblTrack16Action7.setText(aCommand.getCommand());
			}
		}

		settings.replaceCommand(aTrack, aAction, aCommand);
	}
	
	/**
	 * Setting up the pre-programmed table if there is no previous user settings
	 * @param aMainTable - Table object
	 */
	public static void setUpTableData(List<Command> aMainTable){

		System.out.println("Table size: " + aMainTable.size());

		for (int i = 0; i < aMainTable.size(); i++){

			switch (i) {
			case 0:  lblTrack1Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 1:  lblTrack1Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 2:  lblTrack1Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 3:  lblTrack1Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 4:  lblTrack1Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 5:  lblTrack1Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 6:  lblTrack1Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 7:  lblTrack2Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 8:  lblTrack2Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 9:  lblTrack2Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 10: lblTrack2Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 11: lblTrack2Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 12: lblTrack2Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 13: lblTrack2Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 14:  lblTrack3Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 15:  lblTrack3Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 16:  lblTrack3Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 17:  lblTrack3Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 18:  lblTrack3Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 19:  lblTrack3Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 20:  lblTrack3Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 21:  lblTrack4Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 22:  lblTrack4Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 23:  lblTrack4Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 24: lblTrack4Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 25: lblTrack4Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 26: lblTrack4Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 27: lblTrack4Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 28:  lblTrack5Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 29:  lblTrack5Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 30:  lblTrack5Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 31:  lblTrack5Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 32:  lblTrack5Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 33:  lblTrack5Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 34:  lblTrack5Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 35:  lblTrack6Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 36:  lblTrack6Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 37:  lblTrack6Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 38: lblTrack6Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 39: lblTrack6Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 40: lblTrack6Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 41: lblTrack6Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 42:  lblTrack7Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 43:  lblTrack7Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 44:  lblTrack7Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 45: lblTrack7Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 46: lblTrack7Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 47: lblTrack7Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 48: lblTrack7Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 49:  lblTrack8Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 50:  lblTrack8Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 51:  lblTrack8Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 52: lblTrack8Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 53: lblTrack8Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 54: lblTrack8Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 55: lblTrack8Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 56:  lblTrack9Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 57:  lblTrack9Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 58:  lblTrack9Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 59: lblTrack9Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 60: lblTrack9Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 61: lblTrack9Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 62: lblTrack9Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 63:  lblTrack10Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 64:  lblTrack10Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 65:  lblTrack10Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 66: lblTrack10Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 67: lblTrack10Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 68: lblTrack10Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 69: lblTrack10Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 70:  lblTrack11Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 71:  lblTrack11Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 72:  lblTrack11Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 73: lblTrack11Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 74: lblTrack11Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 75: lblTrack11Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 76: lblTrack11Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 77:  lblTrack12Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 78:  lblTrack12Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 79:  lblTrack12Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 80: lblTrack12Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 81: lblTrack12Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 82: lblTrack12Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 83: lblTrack12Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 84:  lblTrack13Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 85:  lblTrack13Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 86:  lblTrack13Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 87: lblTrack13Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 88: lblTrack13Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 89: lblTrack13Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 90: lblTrack13Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 91:  lblTrack14Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 92:  lblTrack14Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 93:  lblTrack14Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 94: lblTrack14Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 95: lblTrack14Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 96: lblTrack14Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 97: lblTrack14Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 98:  lblTrack15Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 99:  lblTrack15Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 100:  lblTrack15Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 101: lblTrack15Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 102: lblTrack15Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 103: lblTrack15Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 104: lblTrack15Action7.setText(aMainTable.get(i).getCommand());
			break;
			case 105:  lblTrack16Action1.setText(aMainTable.get(i).getCommand());
			break;
			case 106:  lblTrack16Action2.setText(aMainTable.get(i).getCommand());
			break;
			case 107:  lblTrack16Action3.setText(aMainTable.get(i).getCommand());
			break;
			case 108: lblTrack16Action4.setText(aMainTable.get(i).getCommand());
			break;
			case 109: lblTrack16Action5.setText(aMainTable.get(i).getCommand());
			break;
			case 110: lblTrack16Action6.setText(aMainTable.get(i).getCommand());
			break;
			case 111: lblTrack16Action7.setText(aMainTable.get(i).getCommand());
			break;
			default:
				break;
			}
		}
	}

	public static void setSelectedAction(int aTrack, int aAction) {
		
		Color COLOUR_SELECTED2 = new Color(255, 255, 255);
		//Color COLOUR_SELECTED2 = new Color(179, 224, 255);

		if (aTrack == 1){
			sliderTrack1Action1.setBackground(COLOUR_SELECTED);
			sliderTrack1Action2.setBackground(COLOUR_SELECTED);
			sliderTrack1Action3.setBackground(COLOUR_SELECTED);
			sliderTrack1Action4.setBackground(COLOUR_SELECTED);
			sliderTrack1Action5.setBackground(COLOUR_SELECTED);
			sliderTrack1Action6.setBackground(COLOUR_SELECTED);
			sliderTrack1Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack1Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack1Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack1Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack1Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack1Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack1Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack1Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 2){
			sliderTrack2Action1.setBackground(COLOUR_SELECTED);
			sliderTrack2Action2.setBackground(COLOUR_SELECTED);
			sliderTrack2Action3.setBackground(COLOUR_SELECTED);
			sliderTrack2Action4.setBackground(COLOUR_SELECTED);
			sliderTrack2Action5.setBackground(COLOUR_SELECTED);
			sliderTrack2Action6.setBackground(COLOUR_SELECTED);
			sliderTrack2Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack2Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack2Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack2Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack2Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack2Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack2Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack2Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 3){
			sliderTrack3Action1.setBackground(COLOUR_SELECTED);
			sliderTrack3Action2.setBackground(COLOUR_SELECTED);
			sliderTrack3Action3.setBackground(COLOUR_SELECTED);
			sliderTrack3Action4.setBackground(COLOUR_SELECTED);
			sliderTrack3Action5.setBackground(COLOUR_SELECTED);
			sliderTrack3Action6.setBackground(COLOUR_SELECTED);
			sliderTrack3Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack3Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack3Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack3Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack3Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack3Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack3Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack3Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 4){
			sliderTrack4Action1.setBackground(COLOUR_SELECTED);
			sliderTrack4Action2.setBackground(COLOUR_SELECTED);
			sliderTrack4Action3.setBackground(COLOUR_SELECTED);
			sliderTrack4Action4.setBackground(COLOUR_SELECTED);
			sliderTrack4Action5.setBackground(COLOUR_SELECTED);
			sliderTrack4Action6.setBackground(COLOUR_SELECTED);
			sliderTrack4Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack4Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack4Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack4Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack4Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack4Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack4Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack4Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 5){
			sliderTrack5Action1.setBackground(COLOUR_SELECTED);
			sliderTrack5Action2.setBackground(COLOUR_SELECTED);
			sliderTrack5Action3.setBackground(COLOUR_SELECTED);
			sliderTrack5Action4.setBackground(COLOUR_SELECTED);
			sliderTrack5Action5.setBackground(COLOUR_SELECTED);
			sliderTrack5Action6.setBackground(COLOUR_SELECTED);
			sliderTrack5Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack5Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack5Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack5Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack5Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack5Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack5Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack5Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 6){
			sliderTrack6Action1.setBackground(COLOUR_SELECTED);
			sliderTrack6Action2.setBackground(COLOUR_SELECTED);
			sliderTrack6Action3.setBackground(COLOUR_SELECTED);
			sliderTrack6Action4.setBackground(COLOUR_SELECTED);
			sliderTrack6Action5.setBackground(COLOUR_SELECTED);
			sliderTrack6Action6.setBackground(COLOUR_SELECTED);
			sliderTrack6Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack6Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack6Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack6Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack6Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack6Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack6Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack6Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 7){
			sliderTrack7Action1.setBackground(COLOUR_SELECTED);
			sliderTrack7Action2.setBackground(COLOUR_SELECTED);
			sliderTrack7Action3.setBackground(COLOUR_SELECTED);
			sliderTrack7Action4.setBackground(COLOUR_SELECTED);
			sliderTrack7Action5.setBackground(COLOUR_SELECTED);
			sliderTrack7Action6.setBackground(COLOUR_SELECTED);
			sliderTrack7Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack7Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack7Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack7Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack7Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack7Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack7Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack7Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 8){
			sliderTrack8Action1.setBackground(COLOUR_SELECTED);
			sliderTrack8Action2.setBackground(COLOUR_SELECTED);
			sliderTrack8Action3.setBackground(COLOUR_SELECTED);
			sliderTrack8Action4.setBackground(COLOUR_SELECTED);
			sliderTrack8Action5.setBackground(COLOUR_SELECTED);
			sliderTrack8Action6.setBackground(COLOUR_SELECTED);
			sliderTrack8Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack8Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack8Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack8Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack8Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack8Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack8Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack8Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 9){
			sliderTrack9Action1.setBackground(COLOUR_SELECTED);
			sliderTrack9Action2.setBackground(COLOUR_SELECTED);
			sliderTrack9Action3.setBackground(COLOUR_SELECTED);
			sliderTrack9Action4.setBackground(COLOUR_SELECTED);
			sliderTrack9Action5.setBackground(COLOUR_SELECTED);
			sliderTrack9Action6.setBackground(COLOUR_SELECTED);
			sliderTrack9Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack9Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack9Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack9Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack9Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack9Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack9Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack9Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 10){
			sliderTrack10Action1.setBackground(COLOUR_SELECTED);
			sliderTrack10Action2.setBackground(COLOUR_SELECTED);
			sliderTrack10Action3.setBackground(COLOUR_SELECTED);
			sliderTrack10Action4.setBackground(COLOUR_SELECTED);
			sliderTrack10Action5.setBackground(COLOUR_SELECTED);
			sliderTrack10Action6.setBackground(COLOUR_SELECTED);
			sliderTrack10Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack10Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack10Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack10Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack10Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack10Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack10Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack10Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 11){
			sliderTrack11Action1.setBackground(COLOUR_SELECTED);
			sliderTrack11Action2.setBackground(COLOUR_SELECTED);
			sliderTrack11Action3.setBackground(COLOUR_SELECTED);
			sliderTrack11Action4.setBackground(COLOUR_SELECTED);
			sliderTrack11Action5.setBackground(COLOUR_SELECTED);
			sliderTrack11Action6.setBackground(COLOUR_SELECTED);
			sliderTrack11Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack11Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack11Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack11Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack11Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack11Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack11Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack11Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 12){
			sliderTrack12Action1.setBackground(COLOUR_SELECTED);
			sliderTrack12Action2.setBackground(COLOUR_SELECTED);
			sliderTrack12Action3.setBackground(COLOUR_SELECTED);
			sliderTrack12Action4.setBackground(COLOUR_SELECTED);
			sliderTrack12Action5.setBackground(COLOUR_SELECTED);
			sliderTrack12Action6.setBackground(COLOUR_SELECTED);
			sliderTrack12Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack12Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack12Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack12Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack12Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack12Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack12Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack12Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 13){
			sliderTrack13Action1.setBackground(COLOUR_SELECTED);
			sliderTrack13Action2.setBackground(COLOUR_SELECTED);
			sliderTrack13Action3.setBackground(COLOUR_SELECTED);
			sliderTrack13Action4.setBackground(COLOUR_SELECTED);
			sliderTrack13Action5.setBackground(COLOUR_SELECTED);
			sliderTrack13Action6.setBackground(COLOUR_SELECTED);
			sliderTrack13Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack13Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack13Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack13Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack13Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack13Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack13Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack13Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 14){
			sliderTrack14Action1.setBackground(COLOUR_SELECTED);
			sliderTrack14Action2.setBackground(COLOUR_SELECTED);
			sliderTrack14Action3.setBackground(COLOUR_SELECTED);
			sliderTrack14Action4.setBackground(COLOUR_SELECTED);
			sliderTrack14Action5.setBackground(COLOUR_SELECTED);
			sliderTrack14Action6.setBackground(COLOUR_SELECTED);
			sliderTrack14Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack14Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack14Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack14Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack14Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack14Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack14Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack14Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 15){
			sliderTrack15Action1.setBackground(COLOUR_SELECTED);
			sliderTrack15Action2.setBackground(COLOUR_SELECTED);
			sliderTrack15Action3.setBackground(COLOUR_SELECTED);
			sliderTrack15Action4.setBackground(COLOUR_SELECTED);
			sliderTrack15Action5.setBackground(COLOUR_SELECTED);
			sliderTrack15Action6.setBackground(COLOUR_SELECTED);
			sliderTrack15Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack15Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack15Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack15Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack15Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack15Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack15Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack15Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 16){
			sliderTrack16Action1.setBackground(COLOUR_SELECTED);
			sliderTrack16Action2.setBackground(COLOUR_SELECTED);
			sliderTrack16Action3.setBackground(COLOUR_SELECTED);
			sliderTrack16Action4.setBackground(COLOUR_SELECTED);
			sliderTrack16Action5.setBackground(COLOUR_SELECTED);
			sliderTrack16Action6.setBackground(COLOUR_SELECTED);
			sliderTrack16Action7.setBackground(COLOUR_SELECTED);
			if (aAction == 0){
				sliderTrack16Action1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderTrack16Action2.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 2){
				sliderTrack16Action3.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 3){
				sliderTrack16Action4.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 4){
				sliderTrack16Action5.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 5){
				sliderTrack16Action6.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 6){
				sliderTrack16Action7.setBackground(COLOUR_SELECTED2);
			}
		} else if (aTrack == 17){
			sliderGlobalAction1.setBackground(COLOUR_SELECTED);
			sliderGlobalAction2.setBackground(COLOUR_SELECTED);
			
			if (aAction == 0){
				sliderGlobalAction1.setBackground(COLOUR_SELECTED2);
			} else if (aAction == 1){
				sliderGlobalAction2.setBackground(COLOUR_SELECTED2);
			}
		}
	}
}

