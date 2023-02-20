package bookManager;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class WinComboSearch extends JDialog {
	private JTextField tfSearchWord;
	private int type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinComboSearch dialog = new WinComboSearch();
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
	public WinComboSearch() {
		setBounds(100, 100, 450, 123);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox cbSearch = new JComboBox();
		cbSearch.setBounds(48, 22, 81, 26);
		cbSearch.setModel(new DefaultComboBoxModel(new String[] {"ISBN", "Title", "Author", "Publisher"}));
		panel.add(cbSearch);
		
		tfSearchWord = new JTextField();
		tfSearchWord.setBounds(174, 21, 198, 28);
		tfSearchWord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//전달할 내용을 추출
				if(e.getKeyCode() == 10) {
					dispose();
					DefaultTableModel dtm;
					dtm = extractRecords(cbSearch.getSelectedItem().toString(), tfSearchWord.getText());
					
					WinResultSearch winResultSearch = new WinResultSearch(dtm, type);
					winResultSearch.setModal(true);
					winResultSearch.setVisible(true);
				
				}
			}
		});
		panel.add(tfSearchWord);
		tfSearchWord.setColumns(10);

	}

	public WinComboSearch(int type) {
		this();
		if(type == 0) {
			setTitle("콤보에서 선택하여 검색(삭제)");
		}else {
			setTitle("콤보에서 선택하여 검색(변경)");
		}
		this.type = type;
		
	}

	protected DefaultTableModel extractRecords(String searchColumn, String SearchWord) {
		String colmns[] = {"ISBN", "제목", "저자", "출판사"};
		DefaultTableModel dtm = new DefaultTableModel(colmns, 0);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");			
			//=============================================		
			String sql = "select isbn, title, author, publisher from bookTBL ";
			sql = sql + "where " + searchColumn + "='" + SearchWord + "'";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				Vector<String> vec = new Vector<>();
				for(int i=1; i<=colmns.length; i++) {
					vec.add(rs.getString(i));
					
				}
				dtm.addRow(vec);
			}
			rs.close();
			stmt.close(); //return dtm;
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("DB 연결 오류");
		} 
		return dtm;
	}

}
