import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BloodMain extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField bgroup;
	private JTextField addres;
	private JTextField phon;
	private JTextField ref;
	private JTextField willing;
	JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodMain frame = new BloodMain();
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
	Connection con=null;
	private JTextField blodgroup;
	private JTable searchtable;
	private JTextField na;
	private JTextField bg;
	private JTextField ad;
	private JTextField ph;
	private JTextField re;
	private JTextField wi;
	private JTable updatetable;
	
	public BloodMain() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		con = DriverManager.getConnection("jdbc:mysql://localhost/blooddatabase","root","");
		JOptionPane.showMessageDialog(null, "Connection Successfully made by MANISH KUMAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew_1 = new JMenuItem("New");
		mntmNew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(0);
								
			}
		});
		mnFile.add(mntmNew_1);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnFile.add(mntmDelete);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		mnFile.add(mntmExit);
		
		JLabel lblBloodDonation = new JLabel("Blood Donation");
		lblBloodDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodDonation.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblBloodDonation.setBounds(0, 39, 1020, 76);
		contentPane.add(lblBloodDonation);
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(310, 110, 5, 5);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		tabbedPane_1.setBounds(10, 128, 1022, 496);
		contentPane.add(tabbedPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		tabbedPane_1.addTab("ADD DONER", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAddDonationPerson = new JLabel("ADD DONATION PERSON INFORMATION");
		lblAddDonationPerson.setForeground(Color.WHITE);
		lblAddDonationPerson.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddDonationPerson.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDonationPerson.setBounds(0, 71, 851, 91);
		panel.add(lblAddDonationPerson);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(12, 175, 162, 40);
		panel.add(lblName);
		
		name = new JTextField();
		name.setBackground(Color.YELLOW);
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(188, 175, 271, 40);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setForeground(Color.BLUE);
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodGroup.setBounds(12, 228, 162, 40);
		panel.add(lblBloodGroup);
		
		bgroup = new JTextField();
		bgroup.setBackground(Color.YELLOW);
		bgroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bgroup.setColumns(10);
		bgroup.setBounds(188, 228, 271, 40);
		panel.add(bgroup);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(12, 281, 162, 40);
		panel.add(lblAddress);
		
		addres = new JTextField();
		addres.setBackground(Color.YELLOW);
		addres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addres.setColumns(10);
		addres.setBounds(188, 281, 271, 40);
		panel.add(addres);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(Color.BLUE);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(12, 334, 162, 40);
		panel.add(lblPhone);
		
		phon = new JTextField();
		phon.setBackground(Color.YELLOW);
		phon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phon.setColumns(10);
		phon.setBounds(188, 334, 271, 40);
		panel.add(phon);
		
		JLabel lblReference = new JLabel("REFERENCE");
		lblReference.setForeground(Color.BLUE);
		lblReference.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReference.setBounds(12, 387, 162, 40);
		panel.add(lblReference);
		
		ref = new JTextField();
		ref.setBackground(Color.YELLOW);
		ref.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ref.setColumns(10);
		ref.setBounds(188, 387, 271, 40);
		panel.add(ref);
		
		JLabel lblWilling = new JLabel("WILLING");
		lblWilling.setForeground(Color.BLUE);
		lblWilling.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWilling.setBounds(12, 440, 162, 40);
		panel.add(lblWilling);
		
		willing = new JTextField();
		willing.setBackground(Color.YELLOW);
		willing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		willing.setColumns(10);
		willing.setBounds(188, 440, 271, 40);
		panel.add(willing);
		
		JButton AddDoner = new JButton("ADD DONER");
		AddDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			String nam =name.getText();
			String Bgroup =bgroup.getText();
			String address =addres.getText();
			String phone =phon.getText();
			String reference =ref.getText();
			String Willing =willing.getText();
			
			String query="insert into bloodtable(name,bgroup,address,phone,reference,willing)" 
			+ "values('"+nam+"','"+Bgroup+"','"+address+"','"+phone+"','"+reference+"','"+Willing+"')";
			try {
				Statement st=con.createStatement();
				st.execute(query);
				JOptionPane.showMessageDialog(null, "DONER ADDED");				
			    }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			}
		});
		AddDoner.setForeground(Color.WHITE);
		AddDoner.setBackground(Color.GREEN);
		AddDoner.setBounds(692, 417, 134, 33);
		panel.add(AddDoner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		panel_1.setBackground(Color.RED);
		tabbedPane_1.addTab("SEARCH", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("BLOOD GROUP");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(25, 78, 162, 40);
		panel_1.add(label);
		
		blodgroup = new JTextField();
		blodgroup.setBackground(Color.YELLOW);
		blodgroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blodgroup.setColumns(10);
		blodgroup.setBounds(201, 78, 271, 40);
		panel_1.add(blodgroup);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.BLUE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				String Bgroup =blodgroup.getText();
				
				String query1="select * from bloodtable where bgroup='"+Bgroup+"'";
						try {
							Statement st1=con.createStatement();
														
							ResultSet rs=st1.executeQuery(query1);
							searchtable.setModel(DbUtils.resultSetToTableModel(rs));
							
						    }
						catch(SQLException e)
						{
							e.printStackTrace();
						}
				
				
			}
		});
		btnSearch.setBounds(588, 77, 126, 41);
		panel_1.add(btnSearch);
		
		JScrollPane controlpane = new JScrollPane();
		controlpane.setBounds(0, 153, 851, 338);
		panel_1.add(controlpane);
		
		searchtable = new JTable();
		controlpane.setViewportView(searchtable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		tabbedPane_1.addTab("UPDATE", null, panel_2, null);
		panel_2.setLayout(null);
		
		na = new JTextField();
		na.setBackground(Color.YELLOW);
		na.setEditable(false);
		na.setFont(new Font("Tahoma", Font.PLAIN, 20));
		na.setColumns(10);
		na.setBounds(188, 13, 271, 40);
		panel_2.add(na);
		
		JLabel label_1 = new JLabel("NAME");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(12, 13, 162, 40);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("BLOOD GROUP");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(12, 66, 162, 40);
		panel_2.add(label_2);
		
		bg = new JTextField();
		bg.setBackground(Color.GREEN);
		bg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bg.setColumns(10);
		bg.setBounds(188, 66, 271, 40);
		panel_2.add(bg);
		
		JLabel label_3 = new JLabel("ADDRESS");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(12, 119, 162, 40);
		panel_2.add(label_3);
		
		ad = new JTextField();
		ad.setBackground(Color.GREEN);
		ad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ad.setColumns(10);
		ad.setBounds(188, 119, 271, 40);
		panel_2.add(ad);
		
		JLabel label_4 = new JLabel("PHONE");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(12, 172, 162, 40);
		panel_2.add(label_4);
		
		ph = new JTextField();
		ph.setBackground(Color.GREEN);
		ph.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ph.setColumns(10);
		ph.setBounds(188, 172, 271, 40);
		panel_2.add(ph);
		
		JLabel label_5 = new JLabel("REFERENCE");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(12, 225, 162, 40);
		panel_2.add(label_5);
		
		re = new JTextField();
		re.setBackground(Color.GREEN);
		re.setFont(new Font("Tahoma", Font.PLAIN, 20));
		re.setColumns(10);
		re.setBounds(188, 225, 271, 40);
		panel_2.add(re);
		
		JLabel label_6 = new JLabel("WILLING");
		label_6.setForeground(Color.BLUE);
		label_6.setBackground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setBounds(12, 278, 162, 40);
		panel_2.add(label_6);
		
		wi = new JTextField();
		wi.setBackground(Color.GREEN);
		wi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		wi.setColumns(10);
		wi.setBounds(188, 278, 271, 40);
		panel_2.add(wi);
		
		JButton btnUpdateDoner = new JButton("UPDATE DONER");
		btnUpdateDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nam1 =na.getText();
				String Bgroup1 =bg.getText();
				String address1 =ad.getText();
				String phone1 =ph.getText();
				String reference1 =re.getText();
				String Willing1 =wi.getText();
				
				String query5="update bloodtable set name='"+nam1+"',bgroup='"+Bgroup1+"',address='"+address1+"',phone='"+phone1+"',reference='"+reference1+"',willing='"+Willing1+"'";
				try {
					Statement st5=con.createStatement();
					st5.execute(query5);
					JOptionPane.showMessageDialog(null, "DONER UPDATED");				
				    }
				catch(SQLException e2)
				{
					e2.printStackTrace();
				}
				
				
				
			}
		});
		btnUpdateDoner.setForeground(Color.WHITE);
		btnUpdateDoner.setBackground(Color.BLUE);
		btnUpdateDoner.setBounds(690, 206, 136, 33);
		panel_2.add(btnUpdateDoner);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 331, 851, 160);
		panel_2.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row = updatetable.getSelectedRow();
				String n=updatetable.getModel().getValueAt(row, 0).toString();
				String query4="select * from bloodtable where name='"+n+"'";
				
				try {
					
					Statement st4 = con.createStatement();
					ResultSet rs4 = st4.executeQuery(query4);
					
					while(rs4.next()) {
						na.setText(rs4.getString("name"));
						bg.setText(rs4.getString("bgroup"));
						ad.setText(rs4.getString("address"));
						ph.setText(rs4.getString("phone"));
						re.setText(rs4.getString("reference"));
						wi.setText(rs4.getString("willing"));
						
						
					}
				}catch(SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				
			}
		});
		scrollPane_1.setViewportView(updatetable);
		
		JButton btnshow = new JButton("SHOW");
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				try {
					String query2 ="select * from bloodtable";
					Statement st2=con.createStatement();										
					ResultSet rs2=st2.executeQuery(query2);
					updatetable.setModel(DbUtils.resultSetToTableModel(rs2));
					
				    }
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
		
				
			}
		});
		btnshow.setForeground(Color.WHITE);
		btnshow.setBackground(Color.BLUE);
		btnshow.setBounds(690, 263, 136, 33);
		panel_2.add(btnshow);
	}
}



