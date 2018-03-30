package projektOSP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					info frame = new info();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public info() {
		setTitle("Informacje o projekcie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(info.class.getResource("/zdjecia/zdjeciePro.png")));
		label_1.setBounds(153, 11, 101, 114);
		contentPane.add(label_1);
		
		JLabel lblProjektZostaWykonany = new JLabel("<html>Projekt zosta\u0142 wykonany przez Mariusza Siennickiego <br></br> studenta Informatyki w Pa\u0144stwowej Wy\u017Cszej Szkole Zawodowej w Ciechanowie dzi\u0119ki wskaz\u00F3wkom dr Wac\u0142awa Frydrychowicza</html>");
		lblProjektZostaWykonany.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProjektZostaWykonany.setBounds(22, 136, 391, 103);
		contentPane.add(lblProjektZostaWykonany);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(info.class.getResource("/zdjecia/Obraz1Szko.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
