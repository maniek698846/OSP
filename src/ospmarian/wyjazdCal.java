package ospmarian;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class wyjazdCal extends JFrame {

	private JPanel contentPane;

	Connection connection = null;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wyjazdCal frame = new wyjazdCal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wyjazdCal() {
		setTitle("Wyjazdy");

		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSamochd = new JLabel("Samoch\u00F3d:");
		lblSamochd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSamochd.setForeground(Color.WHITE);
		lblSamochd.setBounds(23, 4, 142, 29);
		contentPane.add(lblSamochd);
		
		JLabel Zdarzenie = new JLabel("Zdarzenie:");
		Zdarzenie.setForeground(Color.WHITE);
		Zdarzenie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Zdarzenie.setBounds(23, 30, 142, 29);
		contentPane.add(Zdarzenie);
		
		JLabel lblMiejscowo = new JLabel("Miejscowo\u015B\u0107:");
		lblMiejscowo.setForeground(Color.WHITE);
		lblMiejscowo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMiejscowo.setBounds(23, 81, 142, 29);
		contentPane.add(lblMiejscowo);
		
		JLabel lblZdarzenie = new JLabel("Zdarzenie:");
		lblZdarzenie.setForeground(Color.WHITE);
		lblZdarzenie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZdarzenie.setBounds(23, 136, 142, 29);
		contentPane.add(lblZdarzenie);
		
		JLabel lblIlo = new JLabel("Ilo\u015B\u0107 kilometr\u00F3w:");
		lblIlo.setForeground(Color.WHITE);
		lblIlo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIlo.setBounds(23, 109, 142, 29);
		contentPane.add(lblIlo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(23, 56, 142, 29);
		contentPane.add(lblData);
		
		JLabel lblZastp = new JLabel("Zast\u0119p");
		lblZastp.setForeground(Color.WHITE);
		lblZastp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblZastp.setBounds(120, 208, 142, 29);
		contentPane.add(lblZastp);
		
		JLabel lblKierowca = new JLabel("Kierowca:");
		lblKierowca.setForeground(Color.WHITE);
		lblKierowca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKierowca.setBounds(23, 235, 142, 29);
		contentPane.add(lblKierowca);
		
		JLabel lblDowdca = new JLabel("Dow\u00F3dca:");
		lblDowdca.setForeground(Color.WHITE);
		lblDowdca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDowdca.setBounds(23, 260, 142, 29);
		contentPane.add(lblDowdca);
		
		JLabel lblRatownicy = new JLabel("Ratownicy");
		lblRatownicy.setForeground(Color.WHITE);
		lblRatownicy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRatownicy.setBounds(103, 285, 142, 29);
		contentPane.add(lblRatownicy);
		
		JLabel lblOpisZdarzenia = new JLabel("Opis zdarzenia");
		lblOpisZdarzenia.setForeground(Color.WHITE);
		lblOpisZdarzenia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOpisZdarzenia.setBounds(297, 4, 142, 29);
		contentPane.add(lblOpisZdarzenia);
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		btnWr.addActionListener(e -> {
			
			setVisible(false);
			wyjazdy wyj = new wyjazdy();
			wyj.setVisible(true);
			
		});
		btnWr.setBounds(350, 376, 183, 34);
		contentPane.add(btnWr);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(wyjazdCal.class.getResource("/zdjecia/Bez nazwy-12.png")));
		label.setBounds(0, 0, 556, 436);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(138, 13, 107, 20);
		contentPane.add(label_1);
	}

}
