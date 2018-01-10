package projektOSP;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class wyjazdCal extends JFrame {

	private JPanel contentPane;
    private int b_number;
    public void setNumber(int num) { b_number = num; }
    public static JLabel label_1, label_2;
    
    
	/**
	 * 
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					wyjazdCal frame = new wyjazdCal();
//					frame.setVisible(true);
//					wypelLabel();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	static Connection connection = null;


	public static void wypelLabel() {
		try {
			String query=" select * from wyjazdy where ID="+wyjazdy.getNumber()+";";
			PreparedStatement pst=connection.prepareStatement(query);	
			ResultSet rs = pst.executeQuery();			
			label_1.setText(rs.getString(1));
			while(rs.next())
			{
				label_1.setText(rs.getString("samochod"));
				label_2.setText(rs.getString("zdarzenie"));
				
			}

			pst.close();
		}catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null, exc);
			exc.printStackTrace();						 
		}

		
	}	
	/**
	 * Create the frame.
	 */
	public wyjazdCal() {
		setTitle("Wyjazdy");

		wyjazdy.getFrames();

		
		wypelLabel();
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblSamochd = new JLabel("Samoch\u00F3d:");
		lblSamochd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSamochd.setForeground(Color.ORANGE);
		lblSamochd.setBounds(23, 5, 94, 29);
		contentPane.add(lblSamochd);
		
		JLabel Zdarzenie = new JLabel("Zdarzenie:");
		Zdarzenie.setForeground(Color.ORANGE);
		Zdarzenie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Zdarzenie.setBounds(23, 30, 142, 29);
		contentPane.add(Zdarzenie);
		
		JLabel lblMiejscowo = new JLabel("Miejscowo\u015B\u0107:");
		lblMiejscowo.setForeground(Color.ORANGE);
		lblMiejscowo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMiejscowo.setBounds(23, 81, 142, 29);
		contentPane.add(lblMiejscowo);
		
		JLabel lblZdarzenie = new JLabel("Zdarzenie:");
		lblZdarzenie.setForeground(Color.ORANGE);
		lblZdarzenie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZdarzenie.setBounds(23, 136, 142, 29);
		contentPane.add(lblZdarzenie);
		
		JLabel lblIlo = new JLabel("Ilo\u015B\u0107 kilometr\u00F3w:");
		lblIlo.setForeground(Color.ORANGE);
		lblIlo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIlo.setBounds(23, 109, 142, 29);
		contentPane.add(lblIlo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.ORANGE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(23, 56, 142, 29);
		contentPane.add(lblData);
		
		JLabel lblZastp = new JLabel("Zast\u0119p");
		lblZastp.setForeground(Color.ORANGE);
		lblZastp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblZastp.setBounds(90, 208, 142, 29);
		contentPane.add(lblZastp);
		
		JLabel lblKierowca = new JLabel("Kierowca:");
		lblKierowca.setForeground(Color.ORANGE);
		lblKierowca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKierowca.setBounds(23, 235, 142, 29);
		contentPane.add(lblKierowca);
		
		JLabel lblDowdca = new JLabel("Dow\u00F3dca:");
		lblDowdca.setForeground(Color.ORANGE);
		lblDowdca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDowdca.setBounds(23, 260, 142, 29);
		contentPane.add(lblDowdca);
		
		JLabel lblRatownicy = new JLabel("Ratownicy");
		lblRatownicy.setForeground(Color.ORANGE);
		lblRatownicy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRatownicy.setBounds(90, 286, 142, 29);
		contentPane.add(lblRatownicy);
		
		JLabel lblOpisZdarzenia = new JLabel("Opis zdarzenia");
		lblOpisZdarzenia.setForeground(Color.ORANGE);
		lblOpisZdarzenia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOpisZdarzenia.setBounds(361, 4, 142, 29);
		contentPane.add(lblOpisZdarzenia);
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		btnWr.addActionListener(e -> {
			
			setVisible(false);
			wyjazdy wyj = new wyjazdy();
			wyj.setVisible(true);
			
		});
		btnWr.setBounds(350, 376, 183, 34);
		contentPane.add(btnWr);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(155, 5, 148, 29);
		contentPane.add(label_1);
		
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(155, 30, 148, 29);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(155, 56, 148, 29);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(155, 81, 148, 29);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(155, 109, 148, 29);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(155, 136, 148, 29);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(103, 235, 200, 29);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(103, 260, 200, 29);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(79, 310, 200, 24);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(79, 329, 200, 24);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(79, 350, 200, 18);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(79, 372, 200, 18);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(335, 32, 198, 78);
		contentPane.add(label_13);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		JButton btnNewButton = new JButton("Wyœwietl");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						String query=" select * from wyjazdy where ID="+wyjazdy.getNumber()+";";
						PreparedStatement pst=connection.prepareStatement(query);	
						ResultSet rs = pst.executeQuery();			
						label_1.setText(rs.getString(1));
						while(rs.next())
						{
							label_1.setText(rs.getString("samochod"));
							label_2.setText(rs.getString("zdarzenie"));
							label_3.setText(rs.getString("data"));
							label_4.setText(rs.getString("miejscowosc"));
							label_5.setText(rs.getString("ilosc_km"));
							label_6.setText(rs.getString("zdarzenie"));
							label_7.setText(rs.getString("kierowca"));
							label_8.setText(rs.getString("dowodca"));
							label_9.setText(rs.getString("ratownik1"));
							label_10.setText(rs.getString("ratownik2"));
							label_11.setText(rs.getString("ratownik3"));
							label_12.setText(rs.getString("ratownik4"));
							label_13.setText(rs.getString("opis"));
							
						}

						pst.close();
					}catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc);
						exc.printStackTrace();						 
					}
	
			}
		});
		

		btnNewButton.setBounds(346, 331, 187, 34);
		contentPane.add(btnNewButton);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(wyjazdCal.class.getResource("/zdjecia/Bez nazwy-12.png")));
		label.setBounds(0, 0, 556, 436);
		contentPane.add(label);
		

	}
}


