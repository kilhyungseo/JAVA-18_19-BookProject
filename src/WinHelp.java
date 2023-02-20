import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class WinHelp extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinHelp dialog = new WinHelp();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public WinHelp() {
		setType(Type.UTILITY);
		setTitle("\uB3C4\uC6C0\uB9D0");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WinHelp.class.getResource("/images/[\uD06C\uAE30\uBCC0\uD658]\uAE40\uCC44\uC6D0_1.jpg")));
		lblNewLabel.setBounds(12, 32, 150, 200);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB9CC\uB4E0\uC0AC\uB78C : \uAE38\uD615\uC11C");
		lblNewLabel_1.setBounds(215, 38, 105, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC5F0\uB77D\uCC98 : 032-456-7892");
		lblNewLabel_1_1.setBounds(215, 91, 138, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email : 123456@gmail.com");
		lblNewLabel_1_1_1.setBounds(215, 144, 162, 15);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(215, 197, 97, 23);
		getContentPane().add(btnNewButton);

	}
}
