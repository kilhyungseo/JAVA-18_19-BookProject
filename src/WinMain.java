import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import bookManager.WinBookAllShow;
import bookManager.WinBookDelete;
import bookManager.WinBookInsert;
import bookManager.WinBookUpdate;
import bookManager.WinComboSearch;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class WinMain extends JDialog {
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinMain dialog = new WinMain();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static JLabel lblIsnbP;

	/**
	 * Create the dialog.
	 */
	public WinMain() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				showTable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("\uB3C4\uC11C\uAD00\uB9AC\uD504\uB85C\uADF8\uB7A8");
		setBounds(100, 100, 668, 477);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 652, 42);
		getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("\uD30C\uC77C(F)");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mnExit = new JMenuItem("\uC885\uB8CC");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		mnExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		mnExit.setMnemonic('X');
		mnFile.add(mnExit);
		
		JMenu mnBook = new JMenu("\uB3C4\uC11C(B)");
		mnBook.setMnemonic('B');
		menuBar.add(mnBook);
		
		JMenuItem mnBookAdd = new JMenuItem("\uB3C4\uC11C \uCD94\uAC00(A)...");
		mnBookAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookInsert winBookInsert = new WinBookInsert();
				winBookInsert.setModal(true);
				winBookInsert.setVisible(true);
			}
		});
		mnBookAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnBook.add(mnBookAdd);
		mnBookAdd.setMnemonic('A');
		
		JMenuItem mnBookDelete = new JMenuItem("\uB3C4\uC11C \uC0AD\uC81C(D)...");
		mnBookDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					WinComboSearch winComboSearch = new WinComboSearch(0);
					winComboSearch.setModal(true);
					winComboSearch.setVisible(true);
				}else {
					WinBookDelete winBookDelete = new WinBookDelete(table.getValueAt(table.getSelectedRow(), 0).toString());
					winBookDelete.setModal(true);
					winBookDelete.setVisible(true);
				}
			}
		});
		mnBookDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnBook.add(mnBookDelete);
		
		JMenuItem mnBookUpdate = new JMenuItem("\uB3C4\uC11C \uBCC0\uACBD(U)...");
		mnBookUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					WinComboSearch winComboSearch = new WinComboSearch(1); // 0이면 삭제 1이면 변경
					winComboSearch.setModal(true);
					winComboSearch.setVisible(true);
					
				}else {
					WinBookUpdate bookUpdate = new WinBookUpdate(table.getValueAt(table.getSelectedRow(), 0).toString());
					bookUpdate.setModal(true);
					bookUpdate.setVisible(true);
				}
			}
		});
		mnBookUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnBook.add(mnBookUpdate);
		
		JMenuItem mnBookSearch = new JMenuItem("\uB3C4\uC11C \uC870\uD68C(S)...");
		mnBookSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnBook.add(mnBookSearch);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uC0C1\uC138\uC870\uD68C");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookAllShow winBookAllShow = new WinBookAllShow();
				winBookAllShow.setModal(true);
				winBookAllShow.setVisible(true);
				
				
			}
		});
		
		JSeparator separator = new JSeparator();
		mnBook.add(separator);
		
		JSeparator separator_4 = new JSeparator();
		mnBook.add(separator_4);
		
		JSeparator separator_1 = new JSeparator();
		mnBook.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		mnBook.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		mnBook.add(separator_3);
		mnBook.add(mntmNewMenuItem);
		
		mnBook.addSeparator();
		
		JMenu mnuHelp = new JMenu("\uB3C4\uC6C0\uB9D0(H)");
		mnuHelp.setMnemonic('H');
		menuBar.add(mnuHelp);
		
		JMenuItem mnHelp = new JMenuItem("Help...");
		mnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WinHelp winHelp = new WinHelp();
				winHelp.setModal(true);
				winHelp.setVisible(true);
			}
		});
		mnHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnuHelp.add(mnHelp);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 39, 652, 49);
		getContentPane().add(toolBar);
		
		JButton btnBookAdd = new JButton("");
		btnBookAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookInsert winBookInsert = new WinBookInsert();
				winBookInsert.setModal(true);
				winBookInsert.setVisible(true);
			}
		});
		btnBookAdd.setIcon(new ImageIcon(WinMain.class.getResource("/images/bookAdd.PNG")));
		toolBar.add(btnBookAdd);
		
		JButton btnBookDelete = new JButton("");
		btnBookDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					WinComboSearch winComboSearch = new WinComboSearch(0);
					winComboSearch.setModal(true);
					winComboSearch.setVisible(true);
				}else {
					int rowIndex[] = table.getSelectedRows();
					
					if(rowIndex.length > 1) {
					for(int i=0; i<rowIndex.length; i++) {
						WinBookDelete winBookDelete = new WinBookDelete(table.getValueAt(rowIndex[i], 0).toString());
						winBookDelete.setModal(true);
						winBookDelete.setVisible(true);
						}
					}else {
						WinBookDelete winBookDelete = new WinBookDelete(table.getValueAt(table.getSelectedRow(), 0).toString());
						winBookDelete.setModal(true);
						winBookDelete.setVisible(true);	
					}
				}
			}
		});
		btnBookDelete.setIcon(new ImageIcon(WinMain.class.getResource("/images/bookDelete.PNG")));
		toolBar.add(btnBookDelete);
		
		JButton btnBookUpdate = new JButton("");
		btnBookUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					WinComboSearch winComboSearch = new WinComboSearch(1); // 0이면 삭제 1이면 변경
					winComboSearch.setModal(true);
					winComboSearch.setVisible(true);
					
				}else {
					WinBookUpdate bookUpdate = new WinBookUpdate(table.getValueAt(table.getSelectedRow(), 0).toString());
					bookUpdate.setModal(true);
					bookUpdate.setVisible(true);
				}
				
			}
		});
		btnBookUpdate.setIcon(new ImageIcon(WinMain.class.getResource("/images/bookUpdate.PNG")));
		toolBar.add(btnBookUpdate);
		
		JButton btnBookSearch = new JButton("");
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookAllShow winBookAllShow = new WinBookAllShow();
				winBookAllShow.setModal(true);
				winBookAllShow.setVisible(true);
				
			}
		});
		btnBookSearch.setIcon(new ImageIcon(WinMain.class.getResource("/images/bookSearch.PNG")));
		toolBar.add(btnBookSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 87, 652, 329);
		getContentPane().add(scrollPane);
		
		String[] header = {"ISBN", "제목", "작가", "출판사", "출판일", "가격", "수량"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		
		table = new JTable(dtm);	
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mnInsert = new JMenuItem("\uCD94\uAC00");
		mnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinBookInsert winBookInsert = new WinBookInsert();
				winBookInsert.setModal(true);
				winBookInsert.setVisible(true);
			}
		});
		popupMenu.add(mnInsert);
		
		JMenuItem mnDelete = new JMenuItem("\uC0AD\uC81C");
		mnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowIndex[] = table.getSelectedRows();
				
				if(rowIndex.length > 1) {
				for(int i=0; i<rowIndex.length; i++) {
					WinBookDelete winBookDelete = new WinBookDelete(table.getValueAt(rowIndex[i], 0).toString());
					winBookDelete.setModal(true);
					winBookDelete.setVisible(true);
					}
				}else {
					WinBookDelete winBookDelete = new WinBookDelete(table.getValueAt(table.getSelectedRow(), 0).toString());
					winBookDelete.setModal(true);
					winBookDelete.setVisible(true);	
				}
				
			}
		});
		popupMenu.add(mnDelete);
		
		JMenuItem mnUpdate = new JMenuItem("\uBCC0\uACBD");
		mnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				WinBookUpdate winBookUpdate = new WinBookUpdate(table.getValueAt(row, 0).toString());
				winBookUpdate.setModal(true);
				winBookUpdate.setVisible(true);
			}
		});
		popupMenu.add(mnUpdate);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 412, 652, 26);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIsbn = new JLabel("\uD604\uC7AC \uC120\uD0DD\uD55C \uB3C4\uC11C\uC640 \uC800\uC790 : ");
		lblIsbn.setBounds(1, 5, 152, 21);
		panel.add(lblIsbn);
		
		lblIsnbP = new JLabel("");
		lblIsnbP.setBounds(148, 8, 504, 15);
		panel.add(lblIsnbP);
		table.getColumn("제목").setPreferredWidth(200);
		table.getColumn("수량").setPreferredWidth(50);
		
		
		showTable();

	}


	protected void showTable() {
		
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDB", "root","1234");
			
			//=============================================
			String sql = "SELECT * FROM bookTbl";
			
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			dtm.setRowCount(0);

			while(rs.next()) {
				Vector <String> vec = new Vector<>();				
				for(int i=1;i<=9;i++) {
					if(i != 6 && i != 8) {
						if(i == 7) {
							vec.add(rs.getString(7).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","));
							
						}else {
							vec.add(rs.getString(i));
						}
						
					}
				}
				dtm.addRow(vec);
			}
			rs.close();
			pstmt.close();
			//==============================================
			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("DB 연결 오류");
			
		}	
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					JTable source = (JTable)e.getSource();
					int row = source.rowAtPoint(e.getPoint());
					int col = source.columnAtPoint(e.getPoint());
					if(!source.isRowSelected(row)) {
						source.changeSelection(row, col, false, false);
						
					}
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					WinBookUpdate winBookUpdate = new WinBookUpdate(table.getValueAt(table.getSelectedRow(), 0).toString());
					winBookUpdate.setModal(true);
					winBookUpdate.setVisible(true);
				}else {
					lblIsnbP.setText(table.getValueAt(table.getSelectedRow(), 1).toString() + " -- " + table.getValueAt(table.getSelectedRow(), 2).toString());
				}
					
			}
		});
	}
}
