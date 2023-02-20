import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Book extends JPanel {
	private JTextField tfIsbn;
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPubdate;
	private JTextField tfAmount;
	public Book() {
		setLayout(null);
		
		JLabel lblImage = new JLabel("\uC0AC\uC9C4 \uCD94\uAC00");
		lblImage.setToolTipText("\uB354\uBE14\uD074\uB9AD\uD558\uC5EC \uC0AC\uC9C4\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		lblImage.setOpaque(true);
		lblImage.setBackground(Color.YELLOW);
		lblImage.setBounds(12, 10, 150, 200);
		add(lblImage);
		
		JLabel lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setBounds(193, 19, 57, 15);
		add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(263, 13, 179, 21);
		add(tfIsbn);
		
		JLabel lblTitle = new JLabel("\uC81C\uBAA9 : ");
		lblTitle.setBounds(193, 55, 57, 15);
		add(lblTitle);
		
		JLabel lblAuthor = new JLabel("\uC800\uC790 : ");
		lblAuthor.setBounds(193, 91, 57, 15);
		add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("\uCD9C\uD310\uC0AC : ");
		lblPublisher.setBounds(193, 127, 57, 15);
		add(lblPublisher);
		
		JLabel lblPubdate = new JLabel("\uCD9C\uD310\uC77C : ");
		lblPubdate.setBounds(193, 163, 57, 15);
		add(lblPubdate);
		
		JLabel lblPrice = new JLabel("\uAC00\uACA9 : ");
		lblPrice.setBounds(193, 199, 57, 15);
		add(lblPrice);
		
		JLabel lblAmount = new JLabel("\uC218\uB7C9 : ");
		lblAmount.setBounds(193, 235, 57, 15);
		add(lblAmount);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(263, 49, 288, 21);
		add(tfTitle);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(263, 85, 179, 21);
		add(tfAuthor);
		
		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(263, 121, 179, 21);
		add(tfPublisher);
		
		tfPubdate = new JTextField();
		tfPubdate.setColumns(10);
		tfPubdate.setBounds(263, 157, 179, 21);
		add(tfPubdate);
		
		tfAmount = new JTextField();
		tfAmount.setColumns(10);
		tfAmount.setBounds(263, 193, 179, 21);
		add(tfAmount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 274, 551, 165);
		add(scrollPane);
		
		JTextArea taDescription = new JTextArea();
		scrollPane.setViewportView(taDescription);
		
		JButton btnDup = new JButton("\uC911\uBCF5\uD655\uC778");
		btnDup.setBounds(454, 12, 97, 23);
		add(btnDup);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(263, 232, 64, 22);
		add(spinner);
		
		JButton btnPubdate = new JButton("\uB2EC\uB825...");
		btnPubdate.setBounds(454, 157, 97, 23);
		add(btnPubdate);
		
		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.setBounds(454, 216, 97, 48);
		add(btnAdd);
		
		JLabel lblDescription = new JLabel("\uCC45 \uC18C\uAC1C : ");
		lblDescription.setBounds(12, 249, 57, 15);
		add(lblDescription);
		
		JComboBox cbPublisher = new JComboBox();
		cbPublisher.setBounds(454, 120, 97, 23);
		add(cbPublisher);
	}
}
