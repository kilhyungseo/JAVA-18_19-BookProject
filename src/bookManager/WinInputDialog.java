package bookManager;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinInputDialog extends JDialog {
	private JTextField tfUrl;
	private String sUrl;
	
	public String getImageUrl() {
		
		return sUrl;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinInputDialog dialog = new WinInputDialog();
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
	public WinInputDialog() {
		setTitle("\uCC45 \uD45C\uC9C0 URL(Uniform Resource Locator)");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WinInputDialog.class.getResource("/images/[\uD06C\uAE30\uBCC0\uD658]\uAE40\uCC44\uC6D0_1.jpg")));
		lblNewLabel.setBounds(12, 10, 150, 200);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD45C\uC9C0\uC758 \uC774\uBBF8\uC9C0 \uACBD\uB85C\uB97C \uC785\uB825\uD558\uC2DC\uC624.");
		lblNewLabel_1.setBounds(174, 32, 248, 27);
		getContentPane().add(lblNewLabel_1);
		
		tfUrl = new JTextField();
		tfUrl.setBounds(174, 69, 248, 21);
		getContentPane().add(tfUrl);
		tfUrl.setColumns(10);
		
		JButton btnAdd = new JButton("\uC785\uB825 : ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sUrl = tfUrl.getText();
				dispose();
			}
		});
		btnAdd.setBounds(174, 112, 97, 23);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C : ");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCancel.setBounds(325, 112, 97, 23);
		getContentPane().add(btnCancel);

	}

}
