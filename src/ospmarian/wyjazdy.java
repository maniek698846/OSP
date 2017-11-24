package ospmarian;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

public class wyjazdy extends JFrame {

	private JPanel contentPane;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wyjazdy frame = new wyjazdy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldImie;
	
	/**
	 * Create the frame.
	 */
	public void wypComboBox(JComboBox<String> comboBoxName2) {
		try {
			String query="select * from zaloga";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();		
			while(rs.next())
			{
				comboBoxName2.addItem(rs.getString("Imie")+" "+rs.getString("Nazwisko"));		
			}
			
		}catch(Exception exc)
		{
			exc.printStackTrace();		 
		}
		
	}
	
	public wyjazdy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(wyjazdy.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Zobacz wszystkie akcje");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Select id, data, miejscowosc, zdarzenie from wyjazdy ORDER BY ID DESC";
					PreparedStatement pst=connection.prepareStatement(query);	
					ResultSet rs = pst.executeQuery();
					tabela.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
					exc.printStackTrace();						 
				}
			}
		});
		btnNewButton.setBounds(9, 7, 172, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblImie = new JLabel("Imi\u0119 \r\ni \r\nnazwisko");
		lblImie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblImie.setForeground(Color.WHITE);
		lblImie.setBounds(217, 47, 123, 30);
		contentPane.add(lblImie);
		
		JLabel lblZobaczSwojeAkcje = new JLabel("Zobacz swoje akcje");
		lblZobaczSwojeAkcje.setForeground(Color.WHITE);
		lblZobaczSwojeAkcje.setBounds(217, 7, 136, 22);
		contentPane.add(lblZobaczSwojeAkcje);
		
		textFieldImie = new JTextField();
		textFieldImie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query="Select  data, miejscowosc, zdarzenie from wyjazdy where dowodca=? OR ratownik1=? OR ratownik2=? OR ratownik3=? OR ratownik4=? OR kierowca=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,  textFieldImie.getText());
					pst.setString(2,  textFieldImie.getText());
					pst.setString(3,  textFieldImie.getText());
					pst.setString(4,  textFieldImie.getText());
					pst.setString(5,  textFieldImie.getText());
					pst.setString(6,  textFieldImie.getText());
					
					ResultSet rs = pst.executeQuery();
					tabela.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
					exc.printStackTrace();						 
				}
			
			}
		});
		textFieldImie.setBounds(206, 32, 123, 20);
		contentPane.add(textFieldImie);
		textFieldImie.setColumns(10);
		
		JButton bWrc = new JButton("Wr\u00F3\u0107");
		bWrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OSP OSP1 = new OSP();
				OSP1.frame.setVisible(true);
				setVisible(false);
			}
		});
		bWrc.setBounds(10, 380, 536, 30);
		contentPane.add(bWrc);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(445, 32, 87, 20);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 84, 537, 292);
		contentPane.add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(349, 32, 87, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblZakresCzasowyAkcji = new JLabel("Zakres czasowy akcji");
		lblZakresCzasowyAkcji.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblZakresCzasowyAkcji.setForeground(Color.WHITE);
		lblZakresCzasowyAkcji.setBounds(371, 50, 145, 24);
		contentPane.add(lblZakresCzasowyAkcji);
		
		JLabel lblTlo = new JLabel("");
		lblTlo.setIcon(new ImageIcon(wyjazdy.class.getResource("/zdjecia/Bez nazwy-1.png")));
		lblTlo.setBounds(-14, -13, 581, 459);
		contentPane.add(lblTlo);
	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
