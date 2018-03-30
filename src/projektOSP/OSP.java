package projektOSP;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;


import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.TextArea;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
public class OSP {
	

	JFrame frame;
	private JTextField tfIleKm;
	private JComboBox<String> comboBox_1;
	private final JLabel lblNewLabel_5 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OSP window = new OSP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	/**
	 * Create the application.
	 */
	public OSP() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		connection=sqliteConnection.dbConnector();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(OSP.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 572, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Wyjazdy OSP Lekowo");
		frame.setLocationRelativeTo(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Kierowca");
		wypelnijcb.wypComboBoxKier(comboBox);
		comboBox.setBounds(36, 107, 200, 23);
		frame.getContentPane().add(comboBox);
		
		
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("Dowódca");
		comboBox_1.setBounds(294, 107, 198, 23);
		frame.getContentPane().add(comboBox_1);
		wypelnijcb.wypComboBoxDow(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Ratownik");
		wypelnijcb.wypComboBox(comboBox_2);		
		comboBox_2.setBounds(36, 141, 200, 23);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.addItem("Ratownik");
		wypelnijcb.wypComboBox(comboBox_3);
		comboBox_3.setBounds(294, 141, 198, 23);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.addItem("Ratownik");
		wypelnijcb.wypComboBox(comboBox_4);
		comboBox_4.setBounds(294, 175, 198, 23);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.addItem("Ratownik");
		wypelnijcb.wypComboBox(comboBox_5);
		comboBox_5.setBounds(36, 176, 200, 22);
		frame.getContentPane().add(comboBox_5);
		
		JButton btnINF = new JButton("?");
		btnINF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					
				info inf = new info();
				inf.setVisible(true);

			}
		});
		btnINF.setBounds(498, 11, 48, 33);
		frame.getContentPane().add(btnINF);
		
		JLabel lblMiejsceZdarzenia = new JLabel("Miejsce zdarzenia:");
		lblMiejsceZdarzenia.setForeground(Color.ORANGE);
		lblMiejsceZdarzenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiejsceZdarzenia.setBounds(10, 311, 123, 23);
		frame.getContentPane().add(lblMiejsceZdarzenia);
		
		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Grzybowo", "Jarluty Du\u017Ce", "Jarluty Ma\u0142e", "Kalisz", "Karniewo", "K\u0105tki", "Klice", "Kliczki", "Kozdroje-W\u0142osty", "Koziczyn", "Lekowo", "Lek\u00F3wiec", "Lipa", "Mo\u015Bcice", "Paw\u0142owo", "Paw\u0142\u00F3wko", "Pniewo-Czeruchy", "Pniewo Wielkie", "Przybyszewo", "Radomka", "Regimin", "Szulmierz", "Targonie", "Trzcianka", "Ze\u0144bok", "Inne"}));
		comboBox_6.addItem("Lekowo");
		comboBox_6.setBounds(139, 312, 105, 23);
		frame.getContentPane().add(comboBox_6);
		
		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.addItem("Po¿ar");
		comboBox_7.addItem("Wypadek");
		comboBox_7.addItem("Szerszenie, osy");
		comboBox_7.addItem("Podtopienie");
		comboBox_7.addItem("Wyjazd gospodarczy");
		comboBox_7.addItem("Miejscowe zagro¿enie");
		comboBox_7.addItem("Inny");
		comboBox_7.setBounds(139, 284, 105, 20);
		frame.getContentPane().add(comboBox_7);
		
		JLabel lblIleKm = new JLabel("Ilo\u015B\u0107 kilometr\u00F3w:");
		lblIleKm.setForeground(Color.ORANGE);
		lblIleKm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIleKm.setBounds(10, 336, 123, 23);
		frame.getContentPane().add(lblIleKm);
		
		tfIleKm = new JTextField();
		tfIleKm.setBackground(UIManager.getColor("ToggleButton.background"));
		tfIleKm.setBounds(139, 338, 38, 19);
		frame.getContentPane().add(tfIleKm);
		tfIleKm.setColumns(10);
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dataString = dateFormat.format(currentDate);
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setForeground(Color.ORANGE);
		lblData.setBounds(10, 237, 46, 14);
		frame.getContentPane().add(lblData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(139, 237, 105, 20);
		frame.getContentPane().add(dateChooser);
		
		TextArea textArea = new TextArea("");
		textArea.setBounds(250, 227, 296, 130);
		frame.getContentPane().add(textArea);
		textArea.setVisible(false); //Tekst area uwagi!
		
		JLabel lblUwagiIOpis = new JLabel("UWAGI I OPIS ZDARZENIA");
		lblUwagiIOpis.setForeground(Color.RED);
		lblUwagiIOpis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUwagiIOpis.setVisible(false);
		lblUwagiIOpis.setBounds(316, 209, 200, 14);
		frame.getContentPane().add(lblUwagiIOpis);
		
		JComboBox<?> comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_8.setBounds(139, 259, 46, 20);
		frame.getContentPane().add(comboBox_8);
		
		JComboBox<?> comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"00" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_9.setBounds(196, 259, 48, 20);
		frame.getContentPane().add(comboBox_9);
		
		JRadioButton rbPeugeot = new JRadioButton("Peugeot");
		rbPeugeot.setSelected(true);
		rbPeugeot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rbPeugeot.setForeground(new Color(255, 255, 255));
		rbPeugeot.setBackground(new Color(0, 0, 0));
		rbPeugeot.setBounds(43, 0, 114, 23);
		frame.getContentPane().add(rbPeugeot);
		
		JRadioButton rbMercedes = new JRadioButton("Mercedes");
			rbMercedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rbMercedes.setForeground(Color.WHITE);
		rbMercedes.setBackground(Color.DARK_GRAY);
		rbMercedes.setBounds(363, 0, 129, 23);
		frame.getContentPane().add(rbMercedes);
//		final String var1 = String.valueOf(comboBox_4);
//		System.out.println(var1);	

//		
		JButton btnNewButton = new JButton("Raport");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query="insert into wyjazdy (samochod,zdarzenie, miejscowosc, data, godzina, ilosc_km, "
							+ "kierowca, dowodca, ratownik1, ratownik2, ratownik3, ratownik4, opis) "
							+ "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13);";
					
					PreparedStatement pst=connection.prepareStatement(query);
					String auto ="";
					if (rbMercedes.isSelected()) {
						auto = "Mercedes";
						
					}
					else if (rbPeugeot.isSelected()) {
						auto = "Peugeot";
					}

					pst.setString(1, auto);	//Samochód
					pst.setString(2, comboBox_7.getSelectedItem().toString());  //Zdarzenie
					pst.setString(3, comboBox_6.getSelectedItem().toString());  //Miejscowosc
					pst.setString(4, dateChooser.getDate().toString());
					pst.setString(5, comboBox_8.getSelectedItem().toString()+":"+comboBox_9.getSelectedItem().toString());		//Data
					pst.setString(6, tfIleKm.getText().toString());					//Ile KM
					pst.setString(7, comboBox.getSelectedItem().toString());	//kierowca
					pst.setString(8, comboBox_1.getSelectedItem().toString());	//Dowodca
					pst.setString(9, comboBox_2.getSelectedItem().toString());	//Ratownik1
					pst.setString(10, comboBox_3.getSelectedItem().toString());	//Ratownik2
					pst.setString(11, comboBox_4.getSelectedItem().toString());	//Ratownik3
					pst.setString(12, comboBox_5.getSelectedItem().toString());	//Ratownik3
					pst.setString(13, textArea.getText().toString());
					
					JOptionPane.showMessageDialog(null, "Doda³eœ raport z wyjazdu do bazy danych \n Dziêkujemy");

					
					pst.executeUpdate();
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Wype³nij wszystkie pola");
					exc.printStackTrace();
		
					 
				}
			}
		});
		btnNewButton.setBounds(139, 387, 140, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(OSP.class.getResource("/zdjecia/Bez nazwy-3.gif")));
		lblNewLabel_1.setBounds(363, 29, 140, 75);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 35, -19, -33);
		frame.getContentPane().add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OSP.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		label.setBounds(36, 29, 140, 75);
		frame.getContentPane().add(label);
		
		JLabel lblRodzajZdarzenia = new JLabel("Rodzaj zdarzenia:");
		lblRodzajZdarzenia.setForeground(Color.ORANGE);
		lblRodzajZdarzenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRodzajZdarzenia.setBounds(10, 286, 123, 14);
		frame.getContentPane().add(lblRodzajZdarzenia);
		

		

		
		JLabel lblNewLabel_2 = new JLabel("Godzina:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(10, 262, 88, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		

		
		JButton btnExit = new JButton("Dodaj Opis");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.isVisible() == false)
					textArea.setVisible(true);
				else if (textArea.isVisible() == true)
					textArea.setVisible(false);
				
					if (lblUwagiIOpis.isVisible() == false)
						lblUwagiIOpis.setVisible(true);
					else if (lblUwagiIOpis.isVisible() == true)
						lblUwagiIOpis.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Zobacz akcje");

		// OPROGRAMUJ AKCJE Z SQLITE
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				wyjazdy wyj = new wyjazdy();
				wyj.setVisible(true);
				frame.setVisible(false);
			}
		});
		

		
		btnNewButton_1.setBounds(10, 387, 124, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnCzonkowie = new JButton("Cz\u0142onkowie");
		btnCzonkowie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				czlonkowie czlonk = new czlonkowie();
				czlonk.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		

		
		

		
		btnCzonkowie.setBounds(289, 387, 124, 23);
		frame.getContentPane().add(btnCzonkowie);
		btnExit.setBounds(423, 387, 123, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_4 = new JLabel(dataString);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBounds(139, 237, 88, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBounds(139, 237, 88, 14);
		frame.getContentPane().add(lblNewLabel_4); 
		


		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(OSP.class.getResource("/zdjecia/Bez nazwy-5.gif")));
		lblNewLabel_3.setBounds(186, 0, 163, 104);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_5.setIcon(new ImageIcon(OSP.class.getResource("/zdjecia/Bez nazwy-12.png")));
		lblNewLabel_5.setBounds(0, -11, 576, 452);
		frame.getContentPane().add(lblNewLabel_5);
		
		
	}
}
