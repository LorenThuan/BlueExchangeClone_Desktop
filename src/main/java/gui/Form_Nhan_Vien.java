package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import handle.RoundJTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Form_Nhan_Vien extends JFrame {

	public static JPanel contentPane;
	private JTextField textMaNhanVien;
	private JTextField textTenNhanVien;
	private JTextField textEmail;
	private JTable tableNhanVien;
	private DefaultTableModel dataModelNhanVien;
	private JScrollPane scrollNhanVien;
	private JTextField textTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Nhan_Vien frame = new Form_Nhan_Vien();
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
	public Form_Nhan_Vien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinNhanVien = new JPanel();
		panelThongTinNhanVien.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinNhanVien.setBounds(49, 79, 1249, 130);
		contentPane.add(panelThongTinNhanVien);
		panelThongTinNhanVien.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên:");
		lblMaNhanVien.setBounds(24, 35, 83, 14);
		panelThongTinNhanVien.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên:");
		lblTenNhanVien.setBounds(24, 91, 110, 14);
		panelThongTinNhanVien.add(lblTenNhanVien);
		
		
		textMaNhanVien = new JTextField();
		textMaNhanVien.setBounds(177, 32, 197, 20);
		panelThongTinNhanVien.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);
		
		textTenNhanVien = new JTextField();
		textTenNhanVien.setColumns(10);
		textTenNhanVien.setBounds(177, 88, 197, 20);
		panelThongTinNhanVien.add(textTenNhanVien);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(466, 35, 83, 14);
		panelThongTinNhanVien.add(lblGioiTinh);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinNhanVien.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinNhanVien.add(rdbtnNu);
		
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(870, 32, 83, 14);
		panelThongTinNhanVien.add(lblNgaySinh);
		
		JDateChooser dateChonNgaySinh = new JDateChooser();
		dateChonNgaySinh.setDateFormatString("dd/MM/yyyy\r\n");
		dateChonNgaySinh.setBounds(979, 16, 123, 36);
		panelThongTinNhanVien.add(dateChonNgaySinh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(466, 91, 83, 14);
		panelThongTinNhanVien.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(555, 88, 197, 20);
		panelThongTinNhanVien.add(textEmail);
		
		JLabel lbTrangThai = new JLabel("Trạng Thái:");
		lbTrangThai.setBounds(870, 91, 83, 14);
		panelThongTinNhanVien.add(lbTrangThai);
		
		JComboBox comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setEnabled(false);
		comboBoxTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Đang làm việc", "Thôi việc"}));
		comboBoxTrangThai.setBounds(979, 83, 123, 30);
		panelThongTinNhanVien.add(comboBoxTrangThai);
		
		JPanel panel = new JPanel();
		panel.setBounds(196, 231, 989, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(29, 11, 89, 23);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(153, 11, 89, 23);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(284, 11, 89, 23);
		panel.add(btnSua);
		
		JButton btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(418, 11, 89, 23);
		panel.add(btnXoaRong);
		
		JButton btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBounds(545, 11, 89, 23);
		panel.add(btnHoanTac);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(868, 11, 89, 23);
		panel.add(btnTimKiem);
		
		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBounds(674, 12, 184, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JPanel panelDanhSachNhanVien = new JPanel();
		panelDanhSachNhanVien.setBounds(10, 309, 1330, 385);
		panelDanhSachNhanVien.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDanhSachNhanVien);
		panelDanhSachNhanVien.setLayout(null);
		
		String[] tieuDe = new String[]  { "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Email" ,"Ngày Sinh", "Trạng Thái", "Chức Vụ", "Chọn"};
		dataModelNhanVien = new DefaultTableModel(tieuDe, 0);
		scrollNhanVien = new JScrollPane();
		scrollNhanVien.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setBounds(10, 20, 1309, 355);
		panelDanhSachNhanVien.add(scrollNhanVien);
		tableNhanVien = new JTable(dataModelNhanVien);
		tableNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollNhanVien.setViewportView(tableNhanVien);	
		
	}
}
