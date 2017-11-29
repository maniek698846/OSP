package ospmarian;

import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

public class wyjazdy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
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
		
		JButton btnNewButton = new JButton("Zobacz wszystkie akcje");
		btnNewButton.setBounds(9, 7, 172, 70);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Select id, data, miejscowosc, zdarzenie from wyjazdy ORDER BY ID DESC";
					PreparedStatement pst=connection.prepareStatement(query);	
					ResultSet rs = pst.executeQuery();
					tabela.setModel(DbUtils.resultSetToTableModel(rs));
					tabela.getColumnModel().getColumn(0).setMaxWidth(40);
					
					pst.close();
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, exc);
					exc.printStackTrace();						 
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblImie = new JLabel("Imi\u0119 \r\ni \r\nnazwisko");
		lblImie.setBounds(217, 47, 123, 30);
		lblImie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblImie.setForeground(Color.WHITE);
		contentPane.add(lblImie);
		
		JLabel lblZobaczSwojeAkcje = new JLabel("Zobacz swoje akcje");
		lblZobaczSwojeAkcje.setBounds(217, 7, 136, 22);
		lblZobaczSwojeAkcje.setForeground(Color.WHITE);
		contentPane.add(lblZobaczSwojeAkcje);
		
		textFieldImie = new JTextField();
		textFieldImie.setBounds(206, 32, 123, 20);
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
		contentPane.add(textFieldImie);
		textFieldImie.setColumns(10);
		
		JButton bWrc = new JButton("Wr\u00F3\u0107");
		bWrc.setBounds(10, 380, 264, 30);
		bWrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OSP OSP1 = new OSP();
				OSP1.frame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(bWrc);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(445, 32, 87, 20);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(9, 84, 537, 292);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int nrWierszu = tabela.getSelectedRow();
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Czy chcesz zobaczyc ca³y raport z wyjazdu");
				if (YesOrNo == 0)
				{
					wyjazdCal wyjKon = new wyjazdCal();
					wyjKon.setVisible(true);
					setVisible(false);
				}
			}
		});
		scrollPane.setViewportView(tabela);
		
		JButton btnWykres = new JButton("Wykres");
		btnWykres.setBounds(282, 380, 264, 30);
		btnWykres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultPieDataset wykresWyjazd = new DefaultPieDataset();
				wykresWyjazd.setValue("One", new Integer(10));
				wykresWyjazd.setValue("Two", new Integer(20));
				wykresWyjazd.setValue("Three", new Integer(30));
				wykresWyjazd.setValue("Four", new Integer(40));
				JFreeChart wykres = ChartFactory.createPieChart("Wyjazdy", wykresWyjazd, true, true, true);
				wykres.getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart", wykres);
				frame.setVisible(true);
				frame.setSize(450,500);
				
			}
		});
		contentPane.add(btnWykres);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(349, 32, 87, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblZakresCzasowyAkcji = new JLabel("Zakres czasowy akcji");
		lblZakresCzasowyAkcji.setBounds(371, 50, 145, 24);
		lblZakresCzasowyAkcji.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblZakresCzasowyAkcji.setForeground(Color.WHITE);
		contentPane.add(lblZakresCzasowyAkcji);
		
		JLabel lblTlo = new JLabel("");
		lblTlo.setBounds(-14, -13, 581, 459);
		lblTlo.setIcon(new ImageIcon(wyjazdy.class.getResource("/zdjecia/Bez nazwy-1.png")));
		contentPane.add(lblTlo);
	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
