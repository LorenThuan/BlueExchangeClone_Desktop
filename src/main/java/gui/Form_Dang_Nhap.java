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
import javax.swing.event.AncestorEvent;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class Form_Dang_Nhap extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField pwdMatkhau;
	private JButton btnDangNhap;
	private JButton btnXoaRong;
	
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	public static String usernameToGetNhanVien = "";
	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						FrmDangNhap frame = new FrmDangNhap();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
	public static void main(String[] args) {
		Form_Dang_Nhap a= new Form_Dang_Nhap();
		a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Form_Dang_Nhap() {
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

		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setIcon(new ImageIcon("Hinh\\iconReset.png"));
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaRong.setBounds(504, 256, 97, 30);
		contentPane.add(btnXoaRong);
		
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
		btnXoaRong.addActionListener(this);
		btnDangNhap.addActionListener(this);
		txtTaiKhoan.requestFocus();
		this.addKeyListener(this);
	}

	public boolean KiemTraDuLieu() {
		String tenUser = txtTaiKhoan.getText();
		
		// Tên đăng nhập phải là chữ hoặc số và không có kí tự đặc biệt, yêu cầu từ 3
		// đến 20 kí tự
		boolean match = tenUser.matches("[a-zA-z0-9 ]{3,20}");
		if (match != true) {
			JOptionPane.showMessageDialog(this, "Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
//			lblMessLoiUser.setText("Lỗi: Tên đăng Nhập (Không Chứa Ký Tự đặt Biệt,Tối Thiểu 3-20 Ký Tự)");
			return false;
		} else
			return true;
	}

	public void loadTaiKhoan(String tenDangNhap, String matKhau) {
		try {
//			Connection con = ConectDatabase.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "select t.tenTaiKhoan, t.matKhau, n.loaiNhanVien\r\n"
					+ "from dbo.TaiKhoan t join dbo.NhanVien n on t.tenTaiKhoan = n.tenTaiKhoan \r\n"
					+ "where t.tenTaiKhoan=? and t.matKhau=?";

//			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			stmt.setString(2, matKhau);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ten = rs.getString(1).trim();
				String mk = rs.getString(2).trim();
				String loaiTk = rs.getString(3).trim();
//				taiKhoan = new TaiKhoan(ten, mk, loaiTk);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//	public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
//		if (tenDangNhap.equalsIgnoreCase(tenTaiKhoanAdmin) && matKhau.equalsIgnoreCase(matKhauAdmin)) {
//			TrangThaiDangNhapNhanVien = true;
//			TrangThaiDangNhapQuanLy = true;
//			return true;
//		} else if (taiKhoan.getTenTaiKhoan().equalsIgnoreCase(tenDangNhap)
//				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
//				&& taiKhoan.getLoaiTaiKhoan().equalsIgnoreCase("NV")) {
//			TrangThaiDangNhapNhanVien = true;
//			return true;
//		} else if (taiKhoan.getTenTaiKhoan().equalsIgnoreCase(tenDangNhap)
//				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
//				&& taiKhoan.getLoaiTaiKhoan().equalsIgnoreCase("QL")) {
//			TrangThaiDangNhapQuanLy = true;
//			return true;
//		}
//
//		return false;
//	}

//	public boolean kiemTraDangNhapAdmin(String tenDangNhap, String matKhau) {
//		if (tenDangNhap.equalsIgnoreCase(tenTaiKhoanAdmin) && matKhau.equalsIgnoreCase(matKhauAdmin)) {
//			TrangThaiDangNhapNhanVien = true;
//			TrangThaiDangNhapQuanLy = true;
//			return true;
//		}
//		return false;
//	}

//	public void logIn() {
//		try {
//			if (KiemTraDuLieu()) {
//				String tenDN = txtTaiKhoan.getText().trim();
//				@SuppressWarnings("deprecation")
//				String matKhau = pwdMatkhau.getText().trim();
//				loadTaiKhoan(tenDN, matKhau);
//				if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapNhanVien == true
//						&& TrangThaiDangNhapQuanLy == true) {
//					usernameToGetNhanVien = txtTaiKhoan.getText();
//					System.out.println("1 " + usernameToGetNhanVien);
//					FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh();
//					frmManHinhChinh.setVisible(true);
//					this.setVisible(false);
//				} else if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapNhanVien == true) {
//					usernameToGetNhanVien = txtTaiKhoan.getText();
//					System.out.println("2 " + usernameToGetNhanVien);
//					FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh();
//					frmManHinhChinh.mntmQuanLySP.setEnabled(false);
//					frmManHinhChinh.mnNhanVien.setEnabled(false);
//					frmManHinhChinh.mntmThongKeTinhTrangSP.setEnabled(false);
//					frmManHinhChinh.mntmThongKeDoanhThu.setEnabled(false);
//					frmManHinhChinh.setVisible(true);
//					this.setVisible(false);
//				} else if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapQuanLy == true) {
//					usernameToGetNhanVien = txtTaiKhoan.getText();
//					System.out.println("3 " + usernameToGetNhanVien);
//					FrmManHinhChinh frmManHinhChinh = new FrmManHinhChinh();
////					frmManHinhChinh.mnLapHoaDon.setEnabled(false);
//					frmManHinhChinh.setVisible(true);

//					this.setVisible(false);
//				}
//
//				else
//					JOptionPane.showMessageDialog(this, "Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
//			}
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(this, "Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
//		}
//	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnXoaRong)) {
			txtTaiKhoan.setText("");
			pwdMatkhau.setText("");
			txtTaiKhoan.requestFocus();
		} else if (obj.equals(btnDangNhap)) {
			if(txtTaiKhoan.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Tài khoản không được  để trống");
			return;
			}
			if( pwdMatkhau.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Mật khẩu không được  để trống");
				return;
			}
				
//			logIn();
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
