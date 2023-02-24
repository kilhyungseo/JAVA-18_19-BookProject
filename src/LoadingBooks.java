import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.thehowtotutorial.splashscreen.JSplash;

public class LoadingBooks {

	public static void main(String[] args) throws InterruptedException {
	JSplash splash = new JSplash(LoadingBooks.class.getResource("/images/cafe.jpg"),
	true, true, false, "cafe", null, Color.RED, Color.blue);
	splash.splashOn();
		//======================================================

		String[] header = {"ISBN", "제목", "작가", "출판사", "출판일", "가격", "수량"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
			
			
			String sql = "SELECT count(*) FROM bookTbl";
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery(sql);
			int total = 0;
			if(rs.next())
				total = rs.getInt(1);
			sql = "SELECT * FROM bookTbl";
			rs = stmt.executeQuery(sql);
			int count = 0;
			while(rs.next()) {
				splash.setProgress(++count*100/total, "도서 레코드 로딩중");
				Thread.sleep(10);
				Vector <String> vec = new Vector<>();				
					for(int i=1;i<=9;i++) {
						if(i != 6 && i != 8)
							vec.add(rs.getString(i));
					}
							dtm.addRow(vec);
				}
				
			rs.close();
			stmt.close();
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("DB 연결 오류");
			
		}	
	//======================================================
	splash.splashOff();
	
	WinMain winMain = new WinMain(dtm);
	winMain.setModal(true);
	winMain.setVisible(true);
	}
	
}