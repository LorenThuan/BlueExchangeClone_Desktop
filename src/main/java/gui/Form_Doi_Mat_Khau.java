package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import bus.TaiKhoanService;
import bus.TaiKhoanServiceImpl;
import dao.ConectDatabase;
import dto.NhanVien;
import dto.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Form_Doi_Mat_Khau extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
	private static JTextField textMaNhanVien;
	private JPasswordField pwdMatKhau;
	private JButton btnDoiMatKhau;

	private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	private NhanVienService nhanVienService = new NhanVienServiceImpl();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Doi_Mat_Khau frame = new Form_Doi_Mat_Khau();
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
	public Form_Doi_Mat_Khau() {
		//DAO
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 566, 55);
		pnTieuDe.setBackground(Color.LIGHT_GRAY);
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(156, 0, 259, 55);
		pnTieuDe.add(lblNewLabel);

		JPanel pnThemTK = new JPanel();
		pnThemTK.setBounds(10, 75, 566, 318);
		pnThemTK.setBackground(new Color(91,165,156));
		contentPane.add(pnThemTK);
		pnThemTK.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 11, 103, 25);
		pnThemTK.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu cũ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(60, 65, 103, 25);
		pnThemTK.add(lblNewLabel_2);

		textMaNhanVien = new JTextField();
		textMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMaNhanVien.setBounds(200, 11, 300, 25);
		pnThemTK.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);

		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdMatKhau.setBounds(200, 65, 300, 25);
		pnThemTK.add(pwdMatKhau);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDoiMatKhau.setBounds(210, 268, 141, 39);
		pnThemTK.add(btnDoiMatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(200, 119, 300, 25);
		pnThemTK.add(passwordField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu mới:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(60, 119, 103, 25);
		pnThemTK.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nhập lại mật khẩu mới:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 179, 153, 25);
		pnThemTK.add(lblNewLabel_2_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_1.setBounds(200, 179, 300, 25);
		pnThemTK.add(passwordField_1);

		btnDoiMatKhau.addActionListener(this);
		
		themNhanVienAndShowMaNhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDoiMatKhau)) {
			try {
				String password = String.valueOf(pwdMatKhau.getPassword());
				TaiKhoan taiKhoan = new TaiKhoan(password);
				NhanVien nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(Form_Nhan_Vien.textMaNhanVien.getText().trim());
				taiKhoan.setNhanVien(nhanVien);
				Boolean kq = taiKhoanService.themTaiKhoan(taiKhoan);
				Form_Nhan_Vien.xoaRong();
				this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm tài khoản bị lỗi !");
				e2.printStackTrace();
			}
		}
	}

	public void themNhanVienAndShowMaNhanVien() {
		try {
//			Boolean themNV = Form_Nhan_Vien.themMoiNhanVien();
//			Form_Nhan_Vien.docDuLieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
