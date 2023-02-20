package bookManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Book extends JPanel {
	private JTextField tfIsbn;
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPubdate;
	private JTextField tfPrice;
	private JLabel lblImage;
	private JTextArea taDescription;
	private JSpinner spinner;
	private String Pic;
	public Book() {
		setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String image = "<html><img src='" + Pic + "'></html>";
					JOptionPane.showMessageDialog(lblImage, image, "사진확대", JOptionPane.DEFAULT_OPTION);
					
				}
			}
		});
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
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(263, 193, 179, 21);
		add(tfPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 274, 551, 165);
		add(scrollPane);
		
		taDescription = new JTextArea();
		scrollPane.setViewportView(taDescription);
		
		spinner = new JSpinner();
		spinner.setBounds(263, 232, 64, 22);
		add(spinner);
		
		JButton btnPubdate = new JButton("\uB2EC\uB825...");
		btnPubdate.setBounds(454, 157, 97, 23);
		add(btnPubdate);
		
		JLabel lblDescription = new JLabel("\uCC45 \uC18C\uAC1C : ");
		lblDescription.setBounds(12, 249, 57, 15);
		add(lblDescription);
		
		JComboBox cbPublisher = new JComboBox();
		cbPublisher.setBounds(454, 120, 97, 23);
		add(cbPublisher);
	}
//	public Book(String sISBN, String title, String author, String publisher, String pubdate, String image, String price, String description, int amount) {
//		this();
//		tfIsbn.setText(sISBN);
//		tfTitle.setText(title);
//		tfAuthor.setText(author);
//		tfPublisher.setText(publisher);
//		tfPubdate.setText(pubdate);
//		image = "<html><img src='" + image + "' width=150 height=200></html>";
//		lblImage.setText(image);
//		price = price.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
//		tfPrice.setText(price + "원");
//		
//		taDescription.setText(description);
//		spinner.setValue(amount);
//		
//	}

	public Book(Vector<String> vec) {
		this();
		tfIsbn.setText(vec.get(0));
		tfTitle.setText(vec.get(1));
		tfAuthor.setText(vec.get(2));
		tfPublisher.setText(vec.get(3));
		tfPubdate.setText(vec.get(4));
		String image = "<html><img src='" + vec.get(5) + "' width=150 height=200></html>";
		Pic = vec.get(5);
		lblImage.setText(image);
		String price = vec.get(6).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		tfPrice.setText(price + "원");
		
		taDescription.setText(vec.get(7));
		spinner.setValue(Integer.parseInt(vec.get(8)));
	}
}
