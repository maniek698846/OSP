package projektOSP;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import java.io.File;


import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;

import javax.swing.event.ChangeEvent;

public class czlonkowie extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JTextField tfImie;
	private JTextField tfNazwisko;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					czlonkowie frame = new czlonkowie();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	Connection connection = null;
	private JTable tabela1;
	private JTextField tfDU;
	private JTextField tfPESEL;
	private JTextField tfNR;
	private JTextField tfAdres;

	public czlonkowie() {
		connection=sqliteConnection.dbConnector();
		setIconImage(Toolkit.getDefaultToolkit().getImage(czlonkowie.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 460);
		setLocationRelativeTo(null);
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
		
		new JTable();
		
		JPanel tabAct = new JPanel();
		tabAct.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Cz\u0142onkowie aktywni", null, tabAct, "Cz\u0142onkowie aktywnia bior\u0105cy udzia\u0142 w akcjach ratowniczych");
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		JButton btnNewButton = new JButton("Wyœwietl");
		btnNewButton.setBounds(0, 307, 506, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query=" select distinct Imie, Nazwisko from zaloga where podstawowe='Tak' ORDER BY Nazwisko, Imie ASC;";
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
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(52, 102, 147, 24);
		tabNie.add(label_2);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int wartosc = slider.getValue();
				label_2.setText("Wartoœæ wynosi: "+wartosc);
			}
		});
		slider.setValue(0);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(5);
		slider.setSnapToTicks(true);
		slider.setBounds(52, 58, 238, 45);
		tabNie.add(slider);
		

		
		label_2.setText("Wartoœæ wynosi: 0");
//		
//		final String DEST = "C:\\Users\\User\\eclipse\\ospmarian\\helloworld.pdf";
//		JButton btnRaportPdf = new JButton("RAPORT PDF");
//		btnRaportPdf.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				File file = new File(DEST);
//				
//		        PdfWriter writer = new PdfWriter(DEST);
//		        
//		        //Initialize PDF document
//		        PdfDocument pdf = new PdfDocument(writer);
//		 
//		        // Initialize document
//		        Document document = new Document(pdf);
//		 
//		        //Add paragraph to the document
//		        document.add(new Paragraph("Hello World!"));
//		 
//		        //Close document
//		        document.close();
//
//			}
////		});
//		btnRaportPdf.setBounds(52, 165, 427, 23);
//		tabNie.add(btnRaportPdf);
		
//		JButton btnRaport = new JButton("Raport");
//		btnRaport.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Document document = new Document();
//				PdfWriter.getInstance(document, new FileOutputStream("raport.pdf"));
//				document.open();
//				document.add(new Paragraph());
//				
//				document.close();
//			}
//		});
//		btnRaport.setBounds(52, 195, 89, 23);
//		tabNie.add(btnRaport);
//		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dodaj cz\u0142onka", null, panel, null);
		panel.setLayout(null);
		
		tfNazwisko = new JTextField();
		tfNazwisko.setBounds(293, 38, 178, 20);
		panel.add(tfNazwisko);
		tfNazwisko.setColumns(10);
		
		tfImie = new JTextField();
		tfImie.setBounds(293, 12, 178, 20);
		panel.add(tfImie);
		tfImie.setColumns(10);
		
		JLabel lblImie = new JLabel("Imie:");
		lblImie.setBounds(139, 15, 46, 14);
		panel.add(lblImie);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(139, 40, 66, 17);
		panel.add(lblNazwisko);
		
		JLabel lblCzyKierowca = new JLabel("Czy kierowca:");
		lblCzyKierowca.setBounds(23, 208, 81, 14);
		panel.add(lblCzyKierowca);
		
		JCheckBox chckbxKier = new JCheckBox("Tak");
		chckbxKier.setBounds(163, 204, 46, 23);
		panel.add(chckbxKier);
		
		JLabel label = new JLabel("Czy dowódca:");
		label.setBounds(275, 208, 81, 14);
		panel.add(label);
		
		JCheckBox checkBoxDow = new JCheckBox("Tak");
		checkBoxDow.setBounds(421, 204, 46, 23);
		panel.add(checkBoxDow);
		
		JLabel lblKursKpp = new JLabel("Kurs KPP:");
		lblKursKpp.setBounds(275, 233, 81, 14);
		panel.add(lblKursKpp);
		
		JCheckBox checkBox_KPP = new JCheckBox("Tak");
		checkBox_KPP.setBounds(421, 229, 46, 23);
		panel.add(checkBox_KPP);
		
		JLabel lblDataUrodzenia = new JLabel("Data urodzenia:");
		lblDataUrodzenia.setBounds(139, 68, 95, 17);
		panel.add(lblDataUrodzenia);
		
		JLabel lblPesel = new JLabel("PESEL:");
		lblPesel.setBounds(139, 97, 95, 17);
		panel.add(lblPesel);
		
		JLabel lblNumerTelefonu = new JLabel("Numer telefonu:");
		lblNumerTelefonu.setBounds(139, 125, 95, 17);
		panel.add(lblNumerTelefonu);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(139, 153, 95, 17);
		panel.add(lblAdres);
		
		tfDU = new JTextField();
		tfDU.setColumns(10);
		tfDU.setBounds(293, 66, 178, 20);
		panel.add(tfDU);
		
		tfPESEL = new JTextField();
		tfPESEL.setColumns(10);
		tfPESEL.setBounds(293, 94, 178, 20);
		panel.add(tfPESEL);
		
		tfNR = new JTextField();
		tfNR.setColumns(10);
		tfNR.setBounds(293, 122, 178, 20);
		panel.add(tfNR);
		
		tfAdres = new JTextField();
		tfAdres.setColumns(10);
		tfAdres.setBounds(293, 150, 178, 20);
		panel.add(tfAdres);
		
		JLabel lblTlo = new JLabel("");
		lblTlo.setIcon(new ImageIcon(wyjazdy.class.getResource("/zdjecia/Bez nazwy-1.png")));
		lblTlo.setBounds(5, 5, 565, 499);
		contentPane.add(lblTlo);
		

		
		JLabel lblKursRatownictwaTechnicznego = new JLabel("Kurs Rat. technicznego:");
		lblKursRatownictwaTechnicznego.setBounds(22, 233, 150, 14);
		panel.add(lblKursRatownictwaTechnicznego);
		
		JCheckBox checkBoxTech = new JCheckBox("Tak");
		checkBoxTech.setBounds(163, 229, 46, 23);
		panel.add(checkBoxTech);
		
		JLabel lblSzkoleniePodstawowe = new JLabel("Szkolenie podstawowe:");
		lblSzkoleniePodstawowe.setBounds(275, 181, 178, 14);
		panel.add(lblSzkoleniePodstawowe);
		
		JCheckBox checkBoxPodst = new JCheckBox("Tak");
		checkBoxPodst.setBounds(421, 177, 46, 23);
		panel.add(checkBoxPodst);
		
		JLabel lblSzkolenieWodne = new JLabel("Szkolenie wodne:");
		lblSzkolenieWodne.setBounds(275, 260, 124, 14);
		panel.add(lblSzkolenieWodne);
		
		JCheckBox checkBoxWod = new JCheckBox("Tak");
		checkBoxWod.setBounds(421, 256, 46, 23);
		panel.add(checkBoxWod);

		
		JButton btnDodajCzlonka = new JButton("Dodaj cz\u0142onka");					
		btnDodajCzlonka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into zaloga (imie, nazwisko, NrTel, "
							+ "Data_ur, PESEL, Adres, kierowca, "
							+ "dowodca, kpp, technik, podstawowe, wodne) values"
							+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12);";
					
					PreparedStatement pst=connection.prepareStatement(query);

					pst.setString(1, tfImie.getText());	//Samochód
					pst.setString(2, tfNazwisko.getText());  //Zdarzenie
					pst.setString(3, tfNR.getText());
					pst.setString(4, tfDU.getText());
					pst.setString(5, tfPESEL.getText());
					pst.setString(6, tfAdres.getText());
					
					if (chckbxKier.isSelected()) {
						pst.setString(7, "tak");	
					}
					else {
						pst.setString(7, "nie");	
					}
					if (checkBoxDow.isSelected()) {
						pst.setString(8, "tak");	
					}
					else {
						pst.setString(8, "nie");	
					}
					if (checkBox_KPP.isSelected()) {
						pst.setString(9, "tak");	
					}
					else {
						pst.setString(9, "nie");	
					}
					if (checkBoxTech.isSelected()) {
						pst.setString(10, "tak");	
					}
					else {
						pst.setString(10, "nie");	
					}
					if (checkBoxPodst.isSelected()) {
						pst.setString(11, "tak");	
					}
					else {
						pst.setString(11, "nie");	
					}
					
					if (checkBoxWod.isSelected()) {
						pst.setString(12, "tak");	
					}
					else {
						pst.setString(12, "nie");	
					}
					

					
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
		btnDodajCzlonka.setBounds(0, 298, 506, 34);
		panel.add(btnDodajCzlonka);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(czlonkowie.class.getResource("/zdjecia/bear-2660939_960_720 kopia.png")));
		label_1.setBounds(10, 12, 124, 185);
		panel.add(label_1);

	}

	protected static void DISPOSE_ON_CLOSE() {
		
	}
}
