package ospmarian;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class czlonkowie extends JFrame  {

	private JPanel contentPane;
	private JTextField tFimie;
	private JTextField tFNazwisko;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					czlonkowie frame = new czlonkowie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTable table;
	private JTable tabela1;

	public czlonkowie() {
		connection=sqliteConnection.dbConnector();
		setIconImage(Toolkit.getDefaultToolkit().getImage(czlonkowie.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWrc = new JButton("Wróæ");
		btnWrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OSP OSP1 = new OSP();
				OSP1.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnWrc.setBounds(24, 374, 511, 36);
		contentPane.add(btnWrc);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 10, 511, 360);
		contentPane.add(tabbedPane);
		
		JTable tabela = new JTable();
//		scrollPane.setViewportView(tabela);
		
		JPanel tabAct = new JPanel();
		tabAct.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Cz\u0142onkowie aktywni", null, tabAct, "Cz\u0142onkowie aktywnia bior\u0105cy udzia\u0142 w akcjach ratowniczych");
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		JButton btnNewButton = new JButton("Wyœwietl");
		btnNewButton.setBounds(0, 307, 506, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query=" select distinct Imie, Nazwisko from zaloga ORDER BY Nazwisko, Imie ASC;";
					PreparedStatement pst=connection.prepareStatement(query);	
					ResultSet rs = pst.executeQuery();
					tabela1.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
					exc.printStackTrace();						 
				}
			}
		});
		tabAct.setLayout(null);
		tabAct.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 506, 307);
		tabAct.add(scrollPane);
		
		tabela1 = new JTable();
		scrollPane.setViewportView(tabela1);
		
		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		

		
		JPanel tabNie = new JPanel();
		tabbedPane.addTab("Cz\u0142onkowie nieaktywni", null, tabNie, null);
		tabNie.setLayout(null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dodaj cz\u0142onka", null, panel, null);
		panel.setLayout(null);
		
		tFNazwisko = new JTextField();
		tFNazwisko.setBounds(199, 48, 115, 20);
		panel.add(tFNazwisko);
		tFNazwisko.setColumns(10);
		
		tFimie = new JTextField();
		tFimie.setBounds(199, 12, 115, 20);
		panel.add(tFimie);
		tFimie.setColumns(10);
		
		/** Dodawanie cz³onka do bazy danych
		 * 
		 */
		
		JButton btnDodajCzlonka = new JButton("Dodaj cz\u0142onka");					
		btnDodajCzlonka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into zaloga (imie, nazwisko) values (?1, ?2);";
					
					PreparedStatement pst=connection.prepareStatement(query);

					pst.setString(1, tFimie.getText());	//Samochód
					pst.setString(2, tFNazwisko.getText());  //Zdarzenie

					
					JOptionPane.showMessageDialog(null, "Doda³eœ nowego cz³onka OSP Dziêkujemy");

					
					pst.executeUpdate();
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
					exc.printStackTrace();
		
					 
				}
			}
		
		});
		btnDodajCzlonka.setBounds(199, 298, 115, 23);
		panel.add(btnDodajCzlonka);
		
		JLabel lblImie = new JLabel("Imie:");
		lblImie.setBounds(108, 15, 46, 14);
		panel.add(lblImie);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(108, 50, 66, 17);
		panel.add(lblNazwisko);
		
		JLabel lblCzyKierowca = new JLabel("Czy kierowca:");
		lblCzyKierowca.setBounds(108, 90, 81, 14);
		panel.add(lblCzyKierowca);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tak");
		rdbtnNewRadioButton.setBounds(200, 88, 58, 18);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNie = new JRadioButton("Nie");
		rdbtnNie.setBounds(265, 88, 46, 20);
		panel.add(rdbtnNie);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(czlonkowie.class.getResource("/zdjecia/pINemlU.jpg")));
		label.setBounds(0, 0, 506, 332);
		panel.add(label);
		
		JLabel lblTlo = new JLabel("");
		lblTlo.setIcon(new ImageIcon(wyjazdy.class.getResource("/zdjecia/Bez nazwy-1.png")));
		lblTlo.setBounds(5, 5, 565, 499);
		contentPane.add(lblTlo);
	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
