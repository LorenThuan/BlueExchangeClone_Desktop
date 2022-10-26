package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;



import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import bus.TaiKhoanService;
import bus.TaiKhoanServiceImpl;
import dao.ConectDatabase;
import dto.NhanVien;
import dto.TaiKhoan;

import javax.swing.event.AncestorEvent;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class Form_Dang_Nhap extends JFrame implements ActionListener, KeyListener {

	public static JPanel contentPane;
	public static JTextField txtTaiKhoan;
	public static JPasswordField pwdMatkhau;
	private JButton btnDangNhap;
	private JButton btnThoat;
	
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	public static String usernameToGetNhanVien = "";
	
	public static TaiKhoan taiKhoan = new TaiKhoan();
	public static NhanVien nhanVien = new NhanVien();
	
	private NhanVienService nhanVienService = new NhanVienServiceImpl();

	public static void main(String[] args) {
		Form_Dang_Nhap a = new Form_Dang_Nhap();
		a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Form_Dang_Nhap() {
//		DAO
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Hinh\\iconBook.png"));
		JLabel lblIconTaiKhoan = new JLabel();
		lblIconTaiKhoan.setIcon(new ImageIcon("Hinh\\iconUser.png"));
		lblIconTaiKhoan.setBounds(345, 105, 30, 30);
		contentPane.add(lblIconTaiKhoan);

		JLabel lblImgNhaNam = new JLabel();
		lblImgNhaNam.setIcon(new ImageIcon("D:\\Student\\IUH\\PhatTrienUngDung\\QuanLyCuaHangQuanAo\\HinhAnh\\background\\BLUEEXCHANGE.jpg"));
		lblImgNhaNam.setBounds(0, 0, 330, 333);
		contentPane.add(lblImgNhaNam);

		JLabel lblIconMatKhau = new JLabel();
		lblIconMatKhau.setIcon(new ImageIcon("Hinh\\iconPassword.png"));
		lblIconMatKhau.setBounds(345, 188, 30, 30);
		contentPane.add(lblIconMatKhau);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTaiKhoan.setBounds(371, 105, 230, 30);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.requestFocus();

		pwdMatkhau = new JPasswordField();
		pwdMatkhau.setBounds(371, 167, 230, 30);
		contentPane.add(pwdMatkhau);
		pwdMatkhau.setColumns(10);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 13));
		btnDangNhap.setIcon(new ImageIcon("Hinh\\iconLogin.png"));
		btnDangNhap.setBounds(371, 256, 123, 30);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Hinh\\iconReset.png"));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 13));
		btnThoat.setBounds(504, 256, 97, 30);
		contentPane.add(btnThoat);
		
		JLabel lblQuenMatKhau = new JLabel("Bạn quên mật khẩu ?");
		lblQuenMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblQuenMatKhau.setForeground(new Color(30, 144, 255));
		lblQuenMatKhau.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblQuenMatKhau.setBounds(371, 297, 181, 23);
		contentPane.add(lblQuenMatKhau);
		
				JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
				lblNewLabel.setBounds(429, 11, 123, 30);
				contentPane.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
				
				JCheckBox chckbxHienMatKhau = new JCheckBox("Hiện mật khẩu");
				chckbxHienMatKhau.setFont(new Font("Arial", Font.PLAIN, 13));
				chckbxHienMatKhau.setBackground(Color.WHITE);
				chckbxHienMatKhau.setBounds(370, 204, 231, 23);
				contentPane.add(chckbxHienMatKhau);
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);
		txtTaiKhoan.requestFocus();
		this.addKeyListener(this);
		
	}

	
	public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
		try {
			PreparedStatement preStm = null;
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT  tk.[maNhanVien], [matKhau], [chucVu]      \r\n"
					+ "FROM            Nhan_Vien nv INNER JOIN\r\n"
					+ "                         Tai_Khoan tk ON nv.maNhanVien = tk.maNhanVien\r\n"
					+ "						 where tk.[maNhanVien] = ? and [matKhau] = ?\r\n"
					+ "group by tk.[maNhanVien], [matKhau], [chucVu]\r\n"
					+ "";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, tenDangNhap );
			preStm.setString(2, matKhau);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				String tenTaiKhoan = rs.getString(1).trim();
				String matKhauNV = rs.getString(2).trim();
				String chucVu = rs.getString(3).trim();
				nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(tenTaiKhoan);
				taiKhoan.setNhanVien(nhanVien);
				taiKhoan.setMatKhau(matKhauNV);
				nhanVien.setChucVu(chucVu);
				System.out.println(taiKhoan);
				System.out.println(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
		 if (taiKhoan.getNhanVien().getMaNhanVien().equalsIgnoreCase(tenDangNhap)
				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
				&& nhanVien.getChucVu().equalsIgnoreCase("NVBH")) {
			TrangThaiDangNhapNhanVien = true;
			return true;
		} else if (taiKhoan.getNhanVien().getMaNhanVien().equalsIgnoreCase(tenDangNhap)
				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
				&& nhanVien.getChucVu().equalsIgnoreCase("NVQL")) {
			TrangThaiDangNhapQuanLy = true;
			return true;
		}

		return false;
	}
	
	public void logIn() {
		try {
			
				String tenDN = txtTaiKhoan.getText().trim();
				String matKhau = pwdMatkhau.getText().trim();
				phanQuyenDangNhap(tenDN, matKhau);
				if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapNhanVien == true) {
					usernameToGetNhanVien = txtTaiKhoan.getText();
					System.out.println("1 " + usernameToGetNhanVien);
					Form_Man_Hinh_Chinh formManHinhChinh = new Form_Man_Hinh_Chinh();
					formManHinhChinh.mnNhanVien.setEnabled(false);
					formManHinhChinh.mntmThongKeDoanhThu.setEnabled(false);
					formManHinhChinh.mntmThongKeKhachHang.setEnabled(false);
					formManHinhChinh.mntmThongKeSanPhamBanChay.setEnabled(false);
					formManHinhChinh.setVisible(true);
					this.setVisible(false);
				} else if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapQuanLy == true) {
					usernameToGetNhanVien = txtTaiKhoan.getText();
					System.out.println("2 " + usernameToGetNhanVien);
					Form_Man_Hinh_Chinh formManHinhChinh = new Form_Man_Hinh_Chinh();
					formManHinhChinh.setVisible(true);
					this.setVisible(false);
				}
					
			}
	
		catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
	}
}


	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			System.exit(0);
		} else if (obj.equals(btnDangNhap)) {
			if(txtTaiKhoan.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Tài khoản không được  để trống");
			return;
			}
			if( pwdMatkhau.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Mật khẩu không được  để trống");
				return;
			}
				
			logIn();
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
