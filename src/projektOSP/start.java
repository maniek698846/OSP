package ospmarian;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/zdjecia/Bez nazwy-2.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRaportZWyjazdu = new JButton("");
		btnRaportZWyjazdu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OSP OSP1 = new OSP();
				OSP1.frame.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				czlonkowie czlon = new czlonkowie();
				czlon.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(start.class.getResource("/zdjecia/Button2.gif")));
		button.setBounds(356, 61, 195, 105);
		contentPane.add(button);
		btnRaportZWyjazdu.setIcon(new ImageIcon(start.class.getResource("/zdjecia/Button1.gif")));
		btnRaportZWyjazdu.setBackground(Color.ORANGE);
		btnRaportZWyjazdu.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		btnRaportZWyjazdu.setBounds(22, 61, 195, 106);
		contentPane.add(btnRaportZWyjazdu);
		
		JButton btnAkcje = new JButton("AKCJE");
		btnAkcje.setIcon(new ImageIcon(start.class.getResource("/zdjecia/Button3.gif")));
		btnAkcje.setBounds(22, 259, 195, 105);
		contentPane.add(btnAkcje);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(start.class.getResource("/zdjecia/firefighter.jpg")));
		label.setBounds(-14, 0, 589, 435);
		contentPane.add(label);
	}
}
