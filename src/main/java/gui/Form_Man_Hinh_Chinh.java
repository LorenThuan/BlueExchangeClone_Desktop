package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dao.ConectDatabase;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JTextField;


public class Form_Man_Hinh_Chinh extends JFrame implements ActionListener, MenuListener{
	public static JPanel contentPane;
	private Form_Khach_Hang form_Khach_Hang = new Form_Khach_Hang();
	public Form_Nhan_Vien form_Nhan_Vien = new Form_Nhan_Vien();
	private Form_Quan_Ly_Tai_Khoan form_Quan_Ly_Tai_Khoan = new Form_Quan_Ly_Tai_Khoan();
	private Form_Dang_Nhap form_Dang_Nhap = new Form_Dang_Nhap();
	private Form_San_Pham form_San_Pham = new Form_San_Pham();
	public Form_Thong_Ke_Doanh_Thu form_Thong_Ke_Doanh_Thu = new Form_Thong_Ke_Doanh_Thu();
	public Form_Thong_ke_San_Pham_Ban_Chay form_Thong_ke_San_Pham_Ban_Chay = new Form_Thong_ke_San_Pham_Ban_Chay();
	private Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien = new Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien();
	private Form_Trang_Chu form_Trang_Chu = new Form_Trang_Chu();
	private Form_HoaDon form_HoaDon = new Form_HoaDon();
	public static JTabbedPane tabbedPane;
	public static JMenuItem mntmQuanLyTaiKhoan;
	private JMenuItem mntmDangXuat;
	public static JMenu mnKhachHang;
	public static JMenu mnNhanVien;
	public static JMenuItem mntmThongKeDoanhThu;
	public static JMenuItem mntmThongKeSanPhamBanChay;
	public static JMenuItem mntmThongKeKhachHang;
	public static JMenuItem mntmThongKeHoaDonLapTheoNhanVien;
	public static JMenu mnSanPham;
	public static JMenu mnBanHang;
	public static JMenu mnTrangChu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Man_Hinh_Chinh frame = new Form_Man_Hinh_Chinh();
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
	public Form_Man_Hinh_Chinh() {
		//DAO
//		try {
//			ConectDatabase.getInstance().connect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		setBackground(Color.WHITE);
//		getContentPane().setForeground(Color.GREEN);
//		getContentPane().setBackground(Color.WHITE);
//		getContentPane().setLayout(null);
		setTitle("THE SKY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		setSize(869, 427);
		setBounds(100, 100, 450, 300);
		setSize(1380, 780);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.setLayout(null);
		
		

		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(0, 0, 1364, 50);
		toolBar.setBackground(new Color(255, 255, 255));
		toolBar.setFont(new Font("Arial", Font.PLAIN, 16));
		toolBar.setFloatable(false);
		contentPane.add(toolBar);
		
		JMenuBar menuBarTrangChu = new JMenuBar();
		toolBar.add(menuBarTrangChu);
		
		mnTrangChu = new JMenu("<html><p style='text-align:center; width: 160;height: 26'>THE SKY</p></html>");
//		mnTrangChu.setPreferredSize(new Dimension(160, mnTrangChu.getPreferredSize().height));
		mnTrangChu.setForeground(new Color(0, 0, 255));
		mnTrangChu.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarTrangChu.add(mnTrangChu);
		
		
		
		JMenuBar menuBarBanHang = new JMenuBar();
		toolBar.add(menuBarBanHang);
		
		mnBanHang = new JMenu("Bán Hàng");
		mnBanHang.setPreferredSize(new Dimension(160, mnBanHang.getPreferredSize().height));
		Icon iconBanHang =  new ImageIcon("./HinhAnh/icon/iconBanHang.png");
		mnBanHang.setFont(new Font("Arial", Font.BOLD, 16));
		mnBanHang.setIcon(new ImageIcon("./HinhAnh/icon/iconBanHang-removebg-preview.png"));
		menuBarBanHang.add(mnBanHang);
		
		JMenuBar menuBarSanPham = new JMenuBar();
		toolBar.add(menuBarSanPham);
		
		mnSanPham = new JMenu("Sản Phẩm");
		mnSanPham.setPreferredSize(new Dimension(160, mnSanPham.getPreferredSize().height));
		mnSanPham.setIcon(new ImageIcon("./HinhAnh/icon/iconSanPham.png"));
		mnSanPham.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarSanPham.add(mnSanPham);
		
		JMenuBar menuBarThongKe = new JMenuBar();
		toolBar.add(menuBarThongKe);
		
		JMenu mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setPreferredSize(new Dimension(160, mnThongKe.getPreferredSize().height));
		mnThongKe.setIcon(new ImageIcon("./HinhAnh/icon/iconThongKe.png"));
		mnThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarThongKe.add(mnThongKe);
		
		mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
		mntmThongKeDoanhThu.setIcon(new ImageIcon("./HinhAnh/icon/growth.png"));
		mntmThongKeDoanhThu.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeDoanhThu);
		
		mntmThongKeSanPhamBanChay = new JMenuItem("Thống kê sản phẩm bán chạy");
		mntmThongKeSanPhamBanChay.setIcon(new ImageIcon("./HinhAnh/icon/sell.png"));
		mntmThongKeSanPhamBanChay.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeSanPhamBanChay);
		
//		mntmThongKeKhachHang = new JMenuItem("Thống kê khách hàng");
//		mntmThongKeKhachHang.setIcon(new ImageIcon("./HinhAnh/icon/diagram.png"));
//		mntmThongKeKhachHang.setBackground(new Color(240, 240, 240));
//		mntmThongKeKhachHang.setForeground(new Color(0, 0, 0));
//		mntmThongKeKhachHang.setSelected(false);
//		mntmThongKeKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
//		mntmThongKeKhachHang.setEnabled(true);
//		mnThongKe.add(mntmThongKeKhachHang);
		
		mntmThongKeHoaDonLapTheoNhanVien = new JMenuItem("Thống kê hóa đơn lập theo nhân viên");
		mntmThongKeHoaDonLapTheoNhanVien.setIcon(new ImageIcon("./HinhAnh/icon/bill.png"));
		mntmThongKeHoaDonLapTheoNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeHoaDonLapTheoNhanVien);
		
		JMenuBar menuBarNhanVien = new JMenuBar();
		toolBar.add(menuBarNhanVien);
		
		mnNhanVien = new JMenu("Nhân Viên");
		mnNhanVien.setPreferredSize(new Dimension(160, mnNhanVien.getPreferredSize().height));
		mnNhanVien.setIcon(new ImageIcon("./HinhAnh/icon/iconNhanVien.png"));
		mnNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarNhanVien.add(mnNhanVien);
		
		
		
		JMenuBar menuBarKhachHang = new JMenuBar();
		toolBar.add(menuBarKhachHang);
		
		mnKhachHang = new JMenu("Khách hàng");
		mnKhachHang.setPreferredSize(new Dimension(160, mnKhachHang.getPreferredSize().height));
		mnKhachHang.setIcon(new ImageIcon("./HinhAnh/icon/customer.png"));
		mnKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarKhachHang.add(mnKhachHang);
		
		
		
		JMenuBar menuBarTaiKhoan = new JMenuBar();
		toolBar.add(menuBarTaiKhoan);
		
		JMenu mnTaiKhoan = new JMenu("Tài Khoản");
		mnTaiKhoan.setPreferredSize(new Dimension(160, mnTaiKhoan.getPreferredSize().height));
		mnTaiKhoan.setIcon(new ImageIcon("./HinhAnh/icon/account-removebg-preview.png"));
		mnTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarTaiKhoan.add(mnTaiKhoan);
		
		mntmQuanLyTaiKhoan = new JMenuItem("Quản lý tài khoản");
		mntmQuanLyTaiKhoan.setIcon(new ImageIcon("./HinhAnh/icon/account-manager.png"));
		mntmQuanLyTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));
		mnTaiKhoan.add(mntmQuanLyTaiKhoan);
		
		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setIcon(new ImageIcon("./HinhAnh/icon/logout.png"));
		mntmDangXuat.setFont(new Font("Arial", Font.BOLD, 14));
		mnTaiKhoan.add(mntmDangXuat);
		
		JMenuBar menuHuongDanSuDung = new JMenuBar();
		toolBar.add(menuHuongDanSuDung);
		
		JMenu mnHuongDanSuDung = new JMenu("Hướng dẫn sử dụng");
		mnHuongDanSuDung.setPreferredSize(new Dimension(240, mnHuongDanSuDung.getPreferredSize().height));
		mnHuongDanSuDung.setIcon(new ImageIcon("./HinhAnh/icon/information.png"));
		mnHuongDanSuDung.setFont(new Font("Arial", Font.BOLD, 16));
		menuHuongDanSuDung.add(mnHuongDanSuDung);
		
		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 50, 1364, 691);
		contentPane.add(tabbedPane);
		tabbedPane.setVisible(false);
//		tabbedPane.remove(tabbedPane.getSelectedComponent());
//		tabbedPane.add(form_Trang_Chu.contentPane);
//		tabbedPane.setSelectedComponent(form_Trang_Chu.contentPane);
//		tabbedPane.setVisible(true);
		
		mntmQuanLyTaiKhoan.addActionListener(this);
		mntmDangXuat.addActionListener(this);
		mnKhachHang.addMenuListener(this);
		mnNhanVien.addMenuListener(this);
		mnSanPham.addMenuListener(this);
		mntmThongKeDoanhThu.addActionListener(this);
		mntmThongKeSanPhamBanChay.addActionListener(this);
		mnBanHang.addMenuListener(this);
		mntmThongKeHoaDonLapTheoNhanVien.addActionListener(this);
		mnTrangChu.addMenuListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mntmQuanLyTaiKhoan)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Quan_Ly_Tai_Khoan.contentPane);	
			tabbedPane.setVisible(true);
		} else if (o.equals(mntmDangXuat)) {
			this.setVisible(false);
			form_Dang_Nhap.setVisible(true);
		}
		else if (o.equals(mntmThongKeDoanhThu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_Ke_Doanh_Thu.contentPane);	
			tabbedPane.setVisible(true);
		}
		else if (o.equals(mntmThongKeSanPhamBanChay)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_ke_San_Pham_Ban_Chay.contentPane);	
			tabbedPane.setVisible(true);
		}
		else if (o.equals(mntmThongKeHoaDonLapTheoNhanVien)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.contentPane);	
			tabbedPane.setVisible(true);
		}
		
	}

	public void menuSelected(MenuEvent e) {
		Object o = e.getSource();
		if (o.equals(mnKhachHang)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Khach_Hang.contentPane);
			tabbedPane.setSelectedComponent(form_Khach_Hang.contentPane);
			tabbedPane.setVisible(true);	
		} else if (o.equals(mnNhanVien)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Nhan_Vien.contentPane);
			tabbedPane.setSelectedComponent(form_Nhan_Vien.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnSanPham)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_San_Pham.contentPane);
			tabbedPane.setSelectedComponent(form_San_Pham.contentPane);
			tabbedPane.setVisible(true);
		}
		else if (o.equals(mnBanHang)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_HoaDon.contentPane);
			tabbedPane.setSelectedComponent(form_HoaDon.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnTrangChu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Trang_Chu.contentPane);
			tabbedPane.setSelectedComponent(form_Trang_Chu.contentPane);
			tabbedPane.setVisible(true);
		}
		
	}

	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
