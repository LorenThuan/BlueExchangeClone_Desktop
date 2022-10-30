package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.toedter.calendar.JDateChooserBeanInfo;

import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import bus.TaiKhoanService;
import bus.TaiKhoanServiceImpl;
import dao.ConectDatabase;
import dto.NhanVien;
import dto.TaiKhoan;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class Form_Quan_Ly_Tai_Khoan extends JFrame implements ActionListener{

	public static JPanel contentPane;
	public static JTextField textMaNhanVien;
	private JTextField textTenNhanVien;
	private JPasswordField passwordNhanVien;
	private JTextField textEmail;
	private JComboBox<String> comboBox;
	private JLabel lbHienMatKhau;
	private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	private NhanVienService nhanVienService = new NhanVienServiceImpl();
	private JButton btnDoiMatKhau;
	private JButton btnThoat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Quan_Ly_Tai_Khoan frame = new Form_Quan_Ly_Tai_Khoan();
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
	public Form_Quan_Ly_Tai_Khoan() {
		//DAO
				try {
					ConectDatabase.getInstance().connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinTaiKhoan = new JPanel();
		panelThongTinTaiKhoan.setBorder(new TitledBorder(null, "Thông tin tài khoản", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinTaiKhoan.setBounds(141, 91, 1154, 130);
		contentPane.add(panelThongTinTaiKhoan);
		panelThongTinTaiKhoan.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên:");
		lblMaNhanVien.setBounds(24, 35, 126, 14);
		panelThongTinTaiKhoan.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên:");
		lblTenNhanVien.setBounds(24, 91, 126, 14);
		panelThongTinTaiKhoan.add(lblTenNhanVien);
		
		
		textMaNhanVien = new JTextField();
		textMaNhanVien.setEditable(false);
		textMaNhanVien.setBounds(177, 32, 197, 20);
		panelThongTinTaiKhoan.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);
		
		textTenNhanVien = new JTextField();
		textTenNhanVien.setEditable(false);
		textTenNhanVien.setColumns(10);
		textTenNhanVien.setBounds(177, 88, 197, 20);
		panelThongTinTaiKhoan.add(textTenNhanVien);
		
		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setBounds(466, 91, 83, 14);
		panelThongTinTaiKhoan.add(lblChucVu);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setBounds(466, 35, 83, 14);
		panelThongTinTaiKhoan.add(lblMatKhau);
		
		passwordNhanVien = new JPasswordField();
		passwordNhanVien.setEchoChar('•');
		passwordNhanVien.setEditable(false);
		passwordNhanVien.setBounds(555, 32, 197, 20);
		panelThongTinTaiKhoan.add(passwordNhanVien);
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nhân Viên Quản Lý", "Nhân Viên Bán Hàng"}));
		comboBox.addItem("Nhân Viên Quản Lý");
		comboBox.addItem("Nhân Viên Bán Hàng");
		comboBox.setBounds(555, 87, 197, 22);
		panelThongTinTaiKhoan.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(822, 35, 126, 14);
		panelThongTinTaiKhoan.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(947, 32, 197, 20);
		panelThongTinTaiKhoan.add(textEmail);
		
		JCheckBox chckbxHienMatKhau = new JCheckBox();
		chckbxHienMatKhau.setBounds(555, 57, 21, 23);
		chckbxHienMatKhau.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    if(chckbxHienMatKhau.isSelected()){
			    	lbHienMatKhau.setText("Ẩn mật khẩu");
			     passwordNhanVien.setEchoChar((char)0);
			    }else{
			    	lbHienMatKhau.setText("Hiện mật khẩu");
			    passwordNhanVien.setEchoChar('•');
			    }
			   }
			  });
		
		panelThongTinTaiKhoan.add(chckbxHienMatKhau);
		
		lbHienMatKhau = new JLabel("Hiện mật khẩu");
		lbHienMatKhau.setBounds(591, 57, 161, 23);
		panelThongTinTaiKhoan.add(lbHienMatKhau);
		
		JPanel panel = new JPanel();
		panel.setBounds(457, 232, 401, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(40, 11, 159, 23);
		panel.add(btnDoiMatKhau);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(233, 11, 121, 23);
		panel.add(btnThoat);
		
		btnDoiMatKhau.addActionListener(this);
		btnThoat.addActionListener(this);
		
		loadDuLieu();
	}

	
	public void loadDuLieu() {
		TaiKhoan taiKhoan = taiKhoanService.layThongTinTaKhoanTheoMaTaiKhoan(Form_Dang_Nhap.txtTaiKhoan.getText().trim());
		NhanVien nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(taiKhoan.getNhanVien().getMaNhanVien());
		textMaNhanVien.setText(taiKhoan.getNhanVien().getMaNhanVien());
		passwordNhanVien.setText(taiKhoan.getMatKhau().trim());
		textEmail.setText(nhanVien.getEmail());
		comboBox.getModel().setSelectedItem(nhanVien.getChucVu());
		textTenNhanVien.setText(nhanVien.getTenNhanVien());
	}

@Override
public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o.equals(btnDoiMatKhau)) {
		new Form_Doi_Mat_Khau().setVisible(true);
	} else if (o.equals(btnThoat)) {
		System.exit(0);
	}
	
}
}
