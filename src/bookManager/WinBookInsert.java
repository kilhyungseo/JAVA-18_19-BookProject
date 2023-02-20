package bookManager;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class WinBookInsert extends JDialog {
	private JTextField tfIsbn;
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JTextField tfPublisher;
	private JTextField tfPubdate;
	private JTextField tfPrice;
	private JButton btnDup;
	private JSpinner spinner;
	private JLabel lblImage;
	private JTextArea taDescription;
	private String sUrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBookInsert dialog = new WinBookInsert();
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
	public WinBookInsert() {
		setTitle("\uB3C4\uC11C \uC785\uB825\uCC3D");
		setBounds(100, 100, 591, 505);
		getContentPane().setLayout(null);
		
		String imgUrl = "https://shopping-phinf.pstatic.net/main_3246352/32463527641.20230207163644.jpg";
		sUrl = imgUrl;
		imgUrl = "<html><img src='" + imgUrl + "' width=150 height=200></html>";
		lblImage = new JLabel(imgUrl);
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					WinInputDialog winInputDialog = new WinInputDialog();
					winInputDialog.setModal(true);
					winInputDialog.setVisible(true);
					String imgUrl = winInputDialog.getImageUrl();
					imgUrl = "<html><img src='" + imgUrl + "' width=150 height=200></html>";
					lblImage.setText(imgUrl);
				}
			}
		});
		
		lblImage.setToolTipText("\uB354\uBE14\uD074\uB9AD\uD558\uC5EC \uC0AC\uC9C4\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		lblImage.setOpaque(true);
		lblImage.setBackground(Color.YELLOW);
		lblImage.setBounds(12, 27, 150, 200);
		getContentPane().add(lblImage);

		
		JLabel lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setBounds(193, 36, 57, 15);
		getContentPane().add(lblIsbn);
		
		tfIsbn = new JTextField();

		tfIsbn.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String temp = tfIsbn.getText();
				if(isDigit(temp)) {
					if(temp.length() == 13) 
						btnDup.requestFocus();
					
				}else {
					if(tfIsbn.getText().length() >= 1) {
						tfIsbn.setText(temp.substring(0, temp.length()-1));
						JOptionPane.showMessageDialog(tfIsbn, "숫자만 입력하세요");
					}
						
				}
			}
		});
		
		tfIsbn.setColumns(10);
		tfIsbn.setBounds(263, 30, 179, 21);
		getContentPane().add(tfIsbn);
		
		JLabel lblTitle = new JLabel("\uC81C\uBAA9 : ");
		lblTitle.setBounds(193, 72, 57, 15);
		getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("\uC800\uC790 : ");
		lblAuthor.setBounds(193, 108, 57, 15);
		getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("\uCD9C\uD310\uC0AC : ");
		lblPublisher.setBounds(193, 144, 57, 15);
		getContentPane().add(lblPublisher);
		
		JLabel lblPubdate = new JLabel("\uCD9C\uD310\uC77C : ");
		lblPubdate.setBounds(193, 180, 57, 15);
		getContentPane().add(lblPubdate);
		
		JLabel lblPrice = new JLabel("\uAC00\uACA9 : ");
		lblPrice.setBounds(193, 216, 57, 15);
		getContentPane().add(lblPrice);
		
		JLabel lblAmount = new JLabel("\uC218\uB7C9 : ");
		lblAmount.setBounds(193, 252, 57, 15);
		getContentPane().add(lblAmount);
		
		tfTitle = new JTextField();
		tfTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfAuthor.requestFocus();
				}
			}
		});
		tfTitle.setColumns(10);
		tfTitle.setBounds(263, 66, 288, 21);
		getContentPane().add(tfTitle);
		
		tfAuthor = new JTextField();
		tfAuthor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfPublisher.requestFocus();
				}
			}
		});
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(263, 102, 179, 21);
		getContentPane().add(tfAuthor);
		
		tfPublisher = new JTextField();
		tfPublisher.setColumns(10);
		tfPublisher.setBounds(263, 138, 179, 21);
		getContentPane().add(tfPublisher);
		
		tfPubdate = new JTextField();

		tfPubdate.setColumns(10);
		tfPubdate.setBounds(263, 174, 179, 21);
		getContentPane().add(tfPubdate);
		
		tfPrice = new JTextField();
		tfPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
					
					String temp = tfPrice.getText();
					if(isDigit(temp)) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER)
							spinner.requestFocus();
					}else {
						if(tfPrice.getText().length() >= 1) {
							tfPrice.setText(temp.substring(0, temp.length()-1));
							JOptionPane.showMessageDialog(tfPrice, "숫자만 입력하세요");
						}else {
							
						}
							
					}
			}
		});
		tfPrice.setColumns(10);
		tfPrice.setBounds(263, 210, 179, 21);
		getContentPane().add(tfPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 291, 551, 165);
		getContentPane().add(scrollPane);
		
		taDescription = new JTextArea();
		taDescription.setLineWrap(true);
		taDescription.setRows(10);
		scrollPane.setViewportView(taDescription);
		
		btnDup = new JButton("\uC911\uBCF5\uD655\uC778");
		
		btnDup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String sIsdn = tfIsbn.getText();
					isDup(sIsdn);
				}
			}
		});
		btnDup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sIsdn = tfIsbn.getText();
				isDup(sIsdn);
			}
		});
		btnDup.setBounds(454, 29, 97, 23);
		getContentPane().add(btnDup);
		
		spinner = new JSpinner();
		 JFormattedTextField field = new JFormattedTextField();
		 spinner.add(field);
	      
	      DefaultEditor editor = (DefaultEditor) spinner.getEditor();
	      editor.getTextField().addKeyListener(new KeyAdapter() {

	         @Override
	         public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	               taDescription.requestFocus();
	            }
	         }
	      });

		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner.setBounds(263, 249, 64, 22);
		getContentPane().add(spinner);
		
		JButton btnPubdate = new JButton("\uB2EC\uB825...");
		btnPubdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinCalendar winCalender = new WinCalendar();
				winCalender.setModal(true);
				winCalender.setVisible(true);
				tfPubdate.setText(winCalender.getDate());
				
			}
		});
		btnPubdate.setBounds(454, 174, 97, 23);
		getContentPane().add(btnPubdate);
		
		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAdd();
				dispose();
			}
		});
		btnAdd.setBounds(454, 233, 97, 48);
		getContentPane().add(btnAdd);
		
		JLabel lblDescription = new JLabel("\uCC45 \uC18C\uAC1C : ");
		lblDescription.setBounds(12, 266, 57, 15);
		getContentPane().add(lblDescription);
		
		JComboBox cbPublisher = new JComboBox();
		cbPublisher.setBounds(454, 137, 97, 23);
		getContentPane().add(cbPublisher);

	}

	protected void bookAdd() {
		 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
             System.out.println("DB 연결 완료");               
             Statement statement=conn.createStatement();
             //=============================================
             String sql = "INSERT INTO bookTbl VALUES(?,?,?,?,?,?,?,?,?)";
             
             PreparedStatement pstmt = conn.prepareStatement(sql);
             
             pstmt.setString(1, tfIsbn.getText());
             pstmt.setString(2, tfTitle.getText());
             pstmt.setString(3, tfAuthor.getText());
             pstmt.setString(4, tfPublisher.getText());
             pstmt.setString(5, tfPubdate.getText());
             pstmt.setString(6, sUrl);
             pstmt.setString(7, tfPrice.getText());
             pstmt.setString(8, taDescription.getText());
             pstmt.setString(9, spinner.getValue().toString());
             
             int result = pstmt.executeUpdate();
             
             
             if(result == 1){//중복
            	 JOptionPane.showMessageDialog(getContentPane(), "입력되었습니다");
             }else {
            	 System.out.println("입력실패");
             }
             
             pstmt.close();
             conn.close();
             //==============================================
         } catch (ClassNotFoundException e1) {
            System.out.println("JDBC 드라이버 로드 에러");
         } catch (SQLException e1) {
        	 e1.printStackTrace();
            System.out.println("DB 연결 오류");
         }
		
	}

	protected void isDup(String sIsdn) {
		 try {
			 
			 
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
             System.out.println("DB 연결 완료");               
             Statement statement=conn.createStatement();
             //=============================================
             String sql = "select * from bookTbl where ISBN= ?";
             
             PreparedStatement pstmt = conn.prepareStatement(sql);
             
             pstmt.setString(1, sIsdn);
             
             ResultSet rs = pstmt.executeQuery();
             
             
             if(rs.next()){//중복
            	 JOptionPane.showMessageDialog(getContentPane(), "아이디가 중복되었습니다. 다시 확인해 주세요", "message", JOptionPane.ERROR_MESSAGE);
            	 
            
             }else {
            	 System.out.println("회원가입이 가능한 아이디 입니다.");
            	 tfTitle.requestFocus();
             }
             rs.close();
             pstmt.close();
             conn.close();
             //==============================================
         } catch (ClassNotFoundException e1) {
            System.out.println("JDBC 드라이버 로드 에러");
         } catch (SQLException e1) {
            System.out.println("DB 연결 오류");
         }
		
	}

	protected boolean isDigit(String temp) {
	    	if(!temp.equals("") && temp.matches("\\d+"))
	    		return true;
	    	else
	    		return false;
	    
	   }
}
