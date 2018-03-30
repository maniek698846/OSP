package projektOSP;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;


import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class start extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
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
	public start() {
		setTitle("Witamy w aplikacji OSP Lekowo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Przejdz do aplikacji");
		btnNewButton.setBounds(0, 398, 206, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OSP.main(null);
				setVisible(false);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Informacje o aplikacji");
		btnNewButton_1.setBounds(393, 398, 182, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				info inf = new info();
				inf.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Wczytaj baz\u0119 danych");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser wybBaze = new JFileChooser();
				 wybBaze.showOpenDialog(null);
				 File f = wybBaze.getSelectedFile();
				 String nazwa = f.getAbsolutePath();
				 sqliteConnection.sciezka = nazwa ;
			}
		});
		btnNewButton_2.setBounds(203, 398, 193, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 589, 454);
		label.setIcon(new ImageIcon(start.class.getResource("/zdjecia/ekranstartowy.gif")));
		contentPane.add(label);
	}
}
