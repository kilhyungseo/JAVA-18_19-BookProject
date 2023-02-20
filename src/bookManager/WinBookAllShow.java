package bookManager;

import java.awt.EventQueue;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class WinBookAllShow extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBookAllShow dialog = new WinBookAllShow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTabbedPane tabbedPane;

	/**
	 * Create the dialog.
	 */
	public WinBookAllShow() {
		setTitle("\uBAA8\uB4E0 \uB3C4\uC11C \uBCF4\uAE30");
		setBounds(100, 100, 598, 555);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		showAllbooks();
		
	}
	
	private void showAllbooks() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");			
			//=============================================		
			String sql = "select * from bookTBL ";
			
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				Vector<String> vec = new Vector<>();
				for(int i=1; i<=9; i++) {
					vec.add(rs.getString(i));
					
				}
				tabbedPane.add(rs.getString("title"), new Book(vec));
//				tabbedPane.add(rs.getString("title"), new Book(rs.getString("ISBN"), rs.getString("title"), rs.getString("author"),
//								rs.getString("publisher"), rs.getString("pubdate"), rs.getString("image"),
//								rs.getString("price"), rs.getString("description"), rs.getInt("amount")));
				
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
		
	}
}


