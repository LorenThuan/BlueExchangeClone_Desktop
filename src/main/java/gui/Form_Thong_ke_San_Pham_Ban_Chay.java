package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ConectDatabase;
import handle.RoundJTextField;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;

public class Form_Thong_ke_San_Pham_Ban_Chay extends JFrame {

	public static JPanel contentPane;
	private JTextField txtNam;
	private JTable table;
	private static DefaultTableModel tablemodel ;
//	private ThongKeBaoCaoTQ tktq;
	private JComboBox comboBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Thong_ke_San_Pham_Ban_Chay frame = new Form_Thong_ke_San_Pham_Ban_Chay();
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
	public Form_Thong_ke_San_Pham_Ban_Chay() {
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 56);
		panel.setBackground(Color.CYAN);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ SẢN PHẨM BÁN CHẠY THEO THÁNG");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(467, 15, 586, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(57, 67, 1241, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(257, 29, 88, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Năm:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(600, 29, 88, 25);
		panel_1.add(lblNewLabel_2);

		txtNam = new JTextField();
		txtNam.setBounds(700, 29, 307, 23);
		panel_1.add(txtNam);
		txtNam.setColumns(10);

		JButton btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					
//					xoaAllDuLieuTable();
//					TK_doanhThu_DAO ds = new TK_doanhThu_DAO();
//				//	System.out.println(ds.baoCaoTQs(11, 2021));
//					//System.out.println(ds.tinhTongTienBanDuocTheoThang(11, 2021));
//					int thang = Integer.parseInt(comboBox.getSelectedItem().toString());
//					String nam1=txtNam.getText();
//					
//					if(nam1.equalsIgnoreCase("")) {
//						JOptionPane.showMessageDialog(btnNewButton, "Chưa nhập năm");
//						return;
//						
//					}
//					
//					int nam = Integer.parseInt(nam1);
//					
//					DecimalFormat tien = new DecimalFormat("###,###,### VND");
//					double tienBan = 0;
//					double tienNhap = 0;
//					double tienLai = 0;
//					double tienBanSetText = 0;
//					for (ThongKeBaoCaoTQ baoCaoTQ : ds.baoCaoTQs(thang, nam)) {
//						tienBanSetText += baoCaoTQ.getDonGia() * baoCaoTQ.getSoLuongBan();
//					}
//					int cheknull = 0;
//					
//					TKSanPhamBanChayDAO a= new TKSanPhamBanChayDAO();
//					double tt=a.tinhTongTienTatCaSP(thang, nam);
//					txtTienBanDuoc.setText(tien.format(tt));
//				//	txtTienNhap.setText(tien.format(ds.tinhTongTienThuocDaNhapTheoThang(thang, nam)));
//					tienBan = tienBanSetText;
//		//			tienNhap += ds.tinhTongTienThuocDaNhapTheoThang(thang, nam);
//					tienLai = tienBan - tienNhap;
//			//		txtLoiNhuan.setText(tien.format(tienLai));
//					int i = 1;
//					int check = 0;
//					List<ThongKeBaoCaoTQ> tkq =ds.baoCaoTQs(thang, nam);
//					System.out.println(tkq);
//					double tienBanDuoc = 0;
//					tablemodel=(DefaultTableModel) table.getModel();
//					for (ThongKeBaoCaoTQ tk : tkq) {
//						tienBanDuoc = tk.getDonGia() * tk.getSoLuongBan();
//						
//						tablemodel.addRow(new Object[] {
//								i++, tk.getMaSach(), tk.getTenSach(),
//								tien.format(tk.getDonGiaNhap()), tien.format(tk.getDonGia()),
//								tk.getSoLuongBan(), tien.format(tienBanDuoc) });
//						
//						
//					}
//					check++;
//					if  (check == 0) {
//						JOptionPane.showMessageDialog(null, "khong co du lieu cua thang:" + thang + "/" + nam + "");
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					
//					e1.printStackTrace();
//				}
//			}
//		});
		btnLoc.setForeground(new Color(255, 255, 255));
		btnLoc.setBackground(Color.CYAN);
		btnLoc.setBounds(1057, 26, 114, 33);
		panel_1.add(btnLoc);

		 comboBox = new JComboBox();
	
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.setMaximumRowCount(12);
		comboBox.setBounds(394, 29, 133, 25);
		panel_1.add(comboBox);
		
				JLabel lblNewLabel_3 = new JLabel("Tổng sản phẩm bán được:");
				lblNewLabel_3.setBounds(394, 85, 226, 20);
				panel_1.add(lblNewLabel_3);
				lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
				JLabel lblTongTien = new JLabel("100.000");
				lblTongTien.setBounds(643, 85, 174, 20);
				panel_1.add(lblTongTien);
				lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
				textField = new RoundJTextField(15);
				textField.setBounds(434, 136, 156, 20);
				panel_1.add(textField);
				textField.setColumns(10);
				
				JButton btnTimKiem = new JButton("Tìm kiếm");
				btnTimKiem.setBounds(600, 135, 89, 23);
				panel_1.add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 286, 1314, 314);
		contentPane.add(scrollPane);

		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"STT", "Ma san pham", "Ten san pham", "Don gia nhap", "Don gia ban", "So luong nhap", "So luong ban", "Tien nhap", "Tien ban"
//			}
//		));
//		table.getColumnModel().getColumn(2).setPreferredWidth(79);
//		table.getColumnModel().getColumn(5).setPreferredWidth(79);
	//	table.setModel(tablemodel);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng" }));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(377, 245, 582, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Top 10 sản phẩm bán chạy theo tháng");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(122, 0, 393, 25);
		panel_2.add(lblNewLabel_4);
	}
	public void xoaAllDuLieuTable() {
		tablemodel=(DefaultTableModel) table.getModel();
		for (int i = tablemodel.getRowCount(); i>0; i--) {
			tablemodel.removeRow(0);
		}
	}
	}
