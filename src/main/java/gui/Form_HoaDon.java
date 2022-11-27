package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.bouncycastle.util.encoders.UTF8;

import com.toedter.calendar.JDateChooser;

import bus.HoaDonService;
import bus.HoaDonServiceImpl;
import bus.ThongKeDoanhThuService;
import bus.ThongKeDoanhThuServiceImpl;
import dao.ConectDatabase;
import dto.ChiTietHoaDon;
import dto.HoaDon;
import dto.KhachHang;
import dto.NhanVien;
import dto.SanPham;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Form_HoaDon extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private JTextField txtMaSanPham;
	private JTextField txtSoLuong;
	private JTextField txtSDT_KhachHang;
	private JTable tableSanPham;
	private JTable tableDonHang;
	private JTextField txtSoTienKhachDua;
	private JTable tableHoaDon;
	private DefaultTableModel dataModelHoaDon;
	private DefaultTableModel dataModelSanPham;
	private DefaultTableModel dataModelDonHang;
	private JTextField txtSDT;
	private JComboBox cboKichThuoc;
	private JButton btnTimKiemSP;
	private JButton btnLamMoi;
	private JButton btnThemVaoCT_Don;
	private JButton btnTimKH;
	private JButton btnSuaSoLuong;
	private JButton btnXoaCT_Don;
	private JButton btnLuu;
	private JButton btnThemKH;
	private JButton btnThanhToan;
	private JButton btnLocTheoNgay;
	private JButton btnXoaHD;
	private JTextField textNgayLap;
	private JTextField textMaHD;
	private JTextField txtNhanVien;
	private JTextField txtKhachHang;
	private JTextField textTongTien;
	private JTextField textThanhTien;
	private JTextField textTienThua;
	private JTextField textVAT;
	private JButton btnXuatBaoCao;
	private java.util.Date ngayHomNay = new java.util.Date();
	private Date ngayLap = new Date(ngayHomNay.getTime());
	private JScrollPane scrollSanPam;
	private HoaDonService hoaDonService = new HoaDonServiceImpl();
	private static List<HoaDon> allHoaDon = new ArrayList<>();
	private ThongKeDoanhThuService thongKeDoanhThuService = new ThongKeDoanhThuServiceImpl();
	private double tongTienBaoCao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_HoaDon frame = new Form_HoaDon();
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
	public Form_HoaDon() {
		// DAO
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String homNay = sm.format(ngayHomNay);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(new Color(240, 240, 240));
		pnTimKiem.setBorder(new TitledBorder(
				new TitledBorder(
						new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "T\u00ECm ki\u1EBFm",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"T\u00ECm ki\u1EBFm ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnTimKiem.setBounds(6, 6, 533, 172);
		contentPane.add(pnTimKiem);
		pnTimKiem.setLayout(null);

		Font fntText = new Font("Arial", Font.PLAIN, 14);

		JLabel lblMaSanPham = new JLabel("Tên / mã sản phẩm:");
		lblMaSanPham.setFont(fntText);
		lblMaSanPham.setBounds(82, 23, 137, 39);
		pnTimKiem.add(lblMaSanPham);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setFont(fntText);
		txtMaSanPham.setBounds(231, 29, 170, 26);
		pnTimKiem.add(txtMaSanPham);
		txtMaSanPham.setColumns(10);

		JLabel lblKichThuoc = new JLabel("Kích thước:");
		lblKichThuoc.setFont(fntText);
		lblKichThuoc.setBounds(82, 74, 90, 39);
		pnTimKiem.add(lblKichThuoc);

		cboKichThuoc = new JComboBox();
		cboKichThuoc.setModel(
				new DefaultComboBoxModel(new String[] { "Chọn Size", "S", "M", "L", "XL", "XXL", "FreeSize" }));
		cboKichThuoc.setFont(fntText);
		cboKichThuoc.setBounds(231, 81, 170, 27);
		pnTimKiem.add(cboKichThuoc);

		btnTimKiemSP = new JButton("Tìm kiếm");
		btnTimKiemSP.setBounds(140, 118, 117, 29);
		pnTimKiem.add(btnTimKiemSP);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(284, 118, 117, 29);
		pnTimKiem.add(btnLamMoi);

		JPanel pnList_SanPham = new JPanel();
		pnList_SanPham.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnList_SanPham.setBounds(6, 190, 533, 323);
		contentPane.add(pnList_SanPham);
		pnList_SanPham.setLayout(new BorderLayout(0, 0));

		scrollSanPam = new JScrollPane();
		pnList_SanPham.add(scrollSanPam);

		tableSanPham = new JTable();
		tableSanPham.setFont(fntText);
		tableSanPham.setModel(dataModelSanPham = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Kích thước", "Màu sắc", "Đơn giá", "Số lượng" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					Double.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableSanPham.getTableHeader().setFont(fntText);
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(160);
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollSanPam.setViewportView(tableSanPham);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(fntText);
		txtSoLuong.setBackground(new Color(240, 240, 240));
		txtSoLuong.setBounds(551, 281, 62, 26);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		btnThemVaoCT_Don = new JButton("Thêm");
		btnThemVaoCT_Don.setFont(fntText);
		btnThemVaoCT_Don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnThemVaoCT_Don.setBounds(533, 318, 90, 29);
		contentPane.add(btnThemVaoCT_Don);

		JPanel pnDonHang = new JPanel();
		pnDonHang.setBackground(new Color(254, 255, 255));
		pnDonHang.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u01A1n h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnDonHang.setBounds(625, 6, 717, 212);
		contentPane.add(pnDonHang);
		pnDonHang.setLayout(null);

		JLabel lblDonHang = new JLabel("ĐƠN HÀNG");
		lblDonHang.setForeground(new Color(255, 38, 0));
		lblDonHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDonHang.setBounds(285, 24, 111, 39);
		pnDonHang.add(lblDonHang);

		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(fntText);
		lblNgayLap.setBounds(27, 60, 111, 39);
		pnDonHang.add(lblNgayLap);

		JLabel lblMaHoaDon = new JLabel("Mã hoá đơn:");
		lblMaHoaDon.setFont(fntText);
		lblMaHoaDon.setBounds(27, 111, 111, 39);
		pnDonHang.add(lblMaHoaDon);

		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(fntText);
		lblNhanVien.setBounds(27, 162, 111, 39);
		pnDonHang.add(lblNhanVien);

		JLabel lblSDT_KhachHang = new JLabel("SĐT khách hàng:");
		lblSDT_KhachHang.setFont(fntText);
		lblSDT_KhachHang.setBounds(305, 60, 117, 39);
		pnDonHang.add(lblSDT_KhachHang);

		txtSDT_KhachHang = new JTextField();
		txtSDT_KhachHang.setBackground(new Color(241, 241, 246));
		txtSDT_KhachHang.setFont(fntText);
		txtSDT_KhachHang.setText("0990990990");
		txtSDT_KhachHang.setBounds(434, 66, 150, 26);
		pnDonHang.add(txtSDT_KhachHang);
		txtSDT_KhachHang.setColumns(10);

		JLabel lblKhachHang = new JLabel("Khách hàng:");
		lblKhachHang.setFont(fntText);
		lblKhachHang.setBounds(305, 111, 139, 39);
		pnDonHang.add(lblKhachHang);

		btnTimKH = new JButton("Tìm");
		btnTimKH.setFont(fntText);
		btnTimKH.setBounds(598, 66, 73, 29);
		pnDonHang.add(btnTimKH);

		btnSuaSoLuong = new JButton("Sửa SL");
		btnSuaSoLuong.setFont(fntText);
		btnSuaSoLuong.setBounds(341, 168, 91, 29);
		pnDonHang.add(btnSuaSoLuong);

		btnXoaCT_Don = new JButton("Xoá");
		btnXoaCT_Don.setFont(fntText);
		btnXoaCT_Don.setBounds(444, 168, 65, 29);
		pnDonHang.add(btnXoaCT_Don);

		btnLuu = new JButton("Lưu tạm");
		btnLuu.setFont(fntText);
		btnLuu.setBounds(521, 168, 107, 29);
		pnDonHang.add(btnLuu);

		btnThemKH = new JButton("Thêm KH");
		btnThemKH.setFont(fntText);
		btnThemKH.setBounds(489, 24, 139, 29);
		pnDonHang.add(btnThemKH);

		textNgayLap = new JTextField();
		textNgayLap.setText(homNay);
		textNgayLap.setForeground(Color.RED);
		textNgayLap.setEditable(false);
		textNgayLap.setFont(new Font("Arial", Font.ITALIC, 14));
		textNgayLap.setBounds(123, 66, 150, 26);
		pnDonHang.add(textNgayLap);
		textNgayLap.setColumns(10);

		textMaHD = new JTextField();
		textMaHD.setText("");
		textMaHD.setForeground(Color.RED);
		textMaHD.setEditable(true);
		textMaHD.setFont(new Font("Arial", Font.ITALIC, 14));
		textMaHD.setColumns(10);
		textMaHD.setBounds(123, 117, 150, 26);
		pnDonHang.add(textMaHD);

		txtNhanVien = new JTextField();
		txtNhanVien.setText(Form_Quan_Ly_Tai_Khoan.textTenNhanVien.getText().trim());
		txtNhanVien.setForeground(Color.RED);
		txtNhanVien.setFont(new Font("Arial", Font.ITALIC, 14));
		txtNhanVien.setEditable(false);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(123, 168, 150, 26);
		pnDonHang.add(txtNhanVien);

		txtKhachHang = new JTextField();
		txtKhachHang.setText("");
		txtKhachHang.setForeground(Color.RED);
		txtKhachHang.setFont(new Font("Arial", Font.ITALIC, 14));
		txtKhachHang.setEditable(false);
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(434, 117, 150, 26);
		pnDonHang.add(txtKhachHang);

		JPanel pnCT_DonHang = new JPanel();
		pnCT_DonHang.setBounds(625, 230, 717, 132);
		contentPane.add(pnCT_DonHang);
		pnCT_DonHang.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollDonHang = new JScrollPane();
		pnCT_DonHang.add(scrollDonHang);

		tableDonHang = new JTable();
		tableDonHang.setFont(fntText);
		tableDonHang.setModel(dataModelDonHang = new DefaultTableModel(new Object[][] {}, new String[] { "Mã sản phẩm",
				"Tên sản phẩm", "K.Thước", "M.Sắc", "Đơn giá", "Giảm (%)", "SL", "Thành tiền" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Double.class,
					Double.class, Integer.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableDonHang.getTableHeader().setFont(fntText);
		tableDonHang.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableDonHang.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableDonHang.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableDonHang.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableDonHang.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableDonHang.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableDonHang.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableDonHang.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollDonHang.setViewportView(tableDonHang);

		JPanel pnTinhToanTien = new JPanel();
		pnTinhToanTien.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTinhToanTien.setBackground(new Color(254, 255, 255));
		pnTinhToanTien.setBounds(625, 374, 717, 139);
		contentPane.add(pnTinhToanTien);
		pnTinhToanTien.setLayout(null);

		JLabel lblTong = new JLabel("Tổng tiền: ");
		lblTong.setFont(fntText);
		lblTong.setBounds(41, 6, 80, 32);
		pnTinhToanTien.add(lblTong);

		JLabel lblVat = new JLabel("VAT: ");
		lblVat.setFont(fntText);
		lblVat.setBounds(420, 6, 51, 32);
		pnTinhToanTien.add(lblVat);

		JLabel lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setFont(fntText);
		lblThanhTien.setBounds(41, 50, 80, 32);
		pnTinhToanTien.add(lblThanhTien);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa: ");
		lblTienKhachDua.setFont(fntText);
		lblTienKhachDua.setBounds(370, 50, 120, 32);
		pnTinhToanTien.add(lblTienKhachDua);

		txtSoTienKhachDua = new JTextField();
		txtSoTienKhachDua.setFont(fntText);
		txtSoTienKhachDua.setBackground(new Color(241, 241, 246));
		txtSoTienKhachDua.setBounds(502, 53, 182, 26);
		pnTinhToanTien.add(txtSoTienKhachDua);
		txtSoTienKhachDua.setColumns(10);

		JLabel lblTienThua = new JLabel("Tiền thừa: ");
		lblTienThua.setFont(fntText);
		lblTienThua.setBounds(41, 94, 80, 32);
		pnTinhToanTien.add(lblTienThua);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(502, 97, 117, 29);
		pnTinhToanTien.add(btnThanhToan);

		textTongTien = new JTextField();
		textTongTien.setForeground(Color.RED);
		textTongTien.setFont(new Font("Arial", Font.ITALIC, 14));
		textTongTien.setEditable(false);
		textTongTien.setColumns(10);
		textTongTien.setBounds(133, 9, 182, 26);
		pnTinhToanTien.add(textTongTien);

		textThanhTien = new JTextField();
		textThanhTien.setForeground(Color.RED);
		textThanhTien.setFont(new Font("Arial", Font.ITALIC, 14));
		textThanhTien.setEditable(false);
		textThanhTien.setColumns(10);
		textThanhTien.setBounds(133, 53, 182, 26);
		pnTinhToanTien.add(textThanhTien);

		textTienThua = new JTextField();
		textTienThua.setText("");
		textTienThua.setForeground(Color.RED);
		textTienThua.setFont(new Font("Arial", Font.ITALIC, 14));
		textTienThua.setEditable(false);
		textTienThua.setColumns(10);
		textTienThua.setBounds(133, 97, 182, 26);
		pnTinhToanTien.add(textTienThua);

		textVAT = new JTextField();
		textVAT.setForeground(Color.RED);
		textVAT.setFont(new Font("Arial", Font.ITALIC, 14));
		textVAT.setEditable(false);
		textVAT.setColumns(10);
		textVAT.setBounds(502, 9, 182, 26);
		pnTinhToanTien.add(textVAT);

		JPanel pnHoaDonTrongNgay = new JPanel();
		pnHoaDonTrongNgay.setBounds(6, 525, 971, 155);
		contentPane.add(pnHoaDonTrongNgay);
		pnHoaDonTrongNgay.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollHoaDon = new JScrollPane();
		pnHoaDonTrongNgay.add(scrollHoaDon);

		tableHoaDon = new JTable();
		tableHoaDon.setFont(fntText);
		tableHoaDon.setModel(dataModelHoaDon = new DefaultTableModel(new Object[][] {}, new String[] { "Mã hoá đơn",
				"Mã khách hàng", "Số điện thoại", "Ngày lập", "Thành tiền", "Trạng thái" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Double.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableHoaDon.getTableHeader().setFont(fntText);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollHoaDon.setViewportView(tableHoaDon);

		JPanel pnCongCu = new JPanel();
		pnCongCu.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnCongCu.setBackground(new Color(255, 255, 255));
		pnCongCu.setBounds(989, 525, 353, 155);
		contentPane.add(pnCongCu);
		pnCongCu.setLayout(null);

		btnLocTheoNgay = new JButton("Lọc");
		btnLocTheoNgay.setFont(fntText);
		btnLocTheoNgay.setBounds(256, 48, 65, 41);
		pnCongCu.add(btnLocTheoNgay);

		btnXoaHD = new JButton("Xoá");
		btnXoaHD.setEnabled(true);
		btnXoaHD.setFont(fntText);
		btnXoaHD.setBounds(16, 103, 96, 29);
		pnCongCu.add(btnXoaHD);

		JLabel lblSdt = new JLabel("SDT: ");
		lblSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSdt.setBounds(6, 52, 40, 30);
		pnCongCu.add(lblSdt);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBackground(new Color(241, 241, 246));
		txtSDT.setBounds(58, 54, 173, 26);
		pnCongCu.add(txtSDT);
		
		btnXuatBaoCao = new JButton("Xuất báo cáo");
		btnXuatBaoCao.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXuatBaoCao.setEnabled(true);
		btnXuatBaoCao.setBounds(135, 103, 145, 29);
		pnCongCu.add(btnXuatBaoCao);

		addEvent();

		allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		loadTableHoaDon(allHoaDon);
	}

	public void addEvent() {
		btnLamMoi.addActionListener(this);
		btnLocTheoNgay.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSuaSoLuong.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemVaoCT_Don.addActionListener(this);
		btnThemKH.addActionListener(this);
		btnTimKH.addActionListener(this);
		btnTimKiemSP.addActionListener(this);
		btnXoaCT_Don.addActionListener(this);
		btnXoaHD.addActionListener(this);
		btnXuatBaoCao.addActionListener(this);
		tableHoaDon.addMouseListener(this);
		xuLyNhanPhim();
	}

	private List<SanPham> dsSanPham() {
		List<SanPham> lt = new ArrayList<>();
		String noidung = txtMaSanPham.getText().trim();
		lt = hoaDonService.getSanPhamTim(noidung);
		return lt;
	}
	
	  //Tạo hàm xuất hóa đơn
    @SuppressWarnings("deprecation")
	public void XuatHoaDon(Date ngayHomNay, double tongTien, String soHoaDonTuDong){
        try {
            
            Hashtable map = new Hashtable();
            
            map.put("maNhanVien", Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
            map.put("ngayHomNay", ngayHomNay);
            map.put("tongTien", tongTien);
            map.put("soHoaDonTuDong", soHoaDonTuDong);
            
            JasperReport report = JasperCompileManager.compileReport("src/main/java/gui/rptXuatHoaDon.jrxml");
                  
            JasperPrint p = JasperFillManager.fillReport(report,  map, ConectDatabase.getConnection() );
//            JRDesignStyle jrDesignStyle = new JRDesignStyle();
            /*Set the Encoding to UTF-8 for pdf and embed font to arial*/
//            jrDesignStyle.setDefault(true);
            String fontPath = "XuatHoaDon.pdf";
//            jrDesignStyle.setPdfFontName(fontPath);
//            jrDesignStyle.setPdfEncoding("Identity-H");
//            jrDesignStyle.setPdfEmbedded(true);
//            p.addStyle(jrDesignStyle);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, fontPath);
//            JRPdfExporter exporter = new JRPdfExporter();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

//	private List<SanPham> dsSanPham1() {
//		List<SanPham> lt = new ArrayList<>();
//		SanPham sp = new SanPham("maSanPham", "tenSanPham", "mota", 34.4, "hinhAnh", 30, 0.2, "mauSac", "gioiTinh",
//				"kichThuoc", "trangThai", "chatLieu");
//		SanPham sp1 = new SanPham("maSanPham1", "tenSanPham", "mota", 34.4, "hinhAnh", 30, 0.2, "mauSac", "gioiTinh",
//				"kichThuoc", "trangThai", "chatLieu");
//		SanPham sp2 = new SanPham("maSanPham2", "tenSanPham", "mota", 34.4, "hinhAnh", 30, 0.2, "mauSac", "gioiTinh",
//				"kichThuoc", "trangThai", "chatLieu");
//		SanPham sp3 = new SanPham("maSanPham3", "tenSanPham", "mota", 34.4, "hinhAnh", 30, 0.2, "mauSac", "gioiTinh",
//				"kichThuoc", "trangThai", "chatLieu");
//		lt.add(sp);
//		lt.add(sp1);
//		lt.add(sp2);
//		lt.add(sp3);
//		return lt;
//	}

	public void loadDuLieuSanPham(List<SanPham> lt) {
		String kichThuoc = cboKichThuoc.getSelectedItem().toString().trim();
		System.out.println(kichThuoc);
		xoaAllDuLieuTable(dataModelSanPham);
		int i = 0;
		for (SanPham sanPham : lt) {
			System.out.println(sanPham);
			String maSP = sanPham.getMaSanPham();
			String tenSP = sanPham.getTenSanPham();
			String kthuoc = sanPham.getKichThuoc().trim();
			String mauSac = sanPham.getMauSac();
			double donGia = sanPham.getDonGia();
			int soLuong = sanPham.getSoLuong();
			if (cboKichThuoc.getSelectedIndex() == 0 || kichThuoc.equals(kthuoc)) {
				i++;
				dataModelSanPham.addRow(new Object[] { i, maSP, tenSP, kthuoc, mauSac, donGia, soLuong });
			}
		}
	}

	public void loadDuLieuCT_HoaDon(HoaDon hoadon) {
		List<ChiTietHoaDon> lt = new ArrayList<>();
		lt = hoaDonService.getCT_HoadonTheoHoaDon(hoadon.getMaHoaDon());
		xoaAllDuLieuTable(dataModelDonHang);
		for (ChiTietHoaDon ct : lt) {
			String maSP = ct.getSanPham().getMaSanPham();
			SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
			double tongtien = (sp.getDonGia() * ct.getSoLuong()) * (1 - sp.getGiamGia());

			dataModelDonHang.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), sp.getKichThuoc(),
					sp.getMauSac(), sp.getDonGia(), sp.getGiamGia(), ct.getSoLuong(), tongtien });
		}
		tinhToan();
	}

	public void themHDvaoBang(HoaDon hd) {
		KhachHang kh = hoaDonService.timKiemKhachHangtheoMa(hd.getKhachHang().getMaKhachHang());
		String maHD = hd.getMaHoaDon();
		Date ngayDat = hd.getNgayDat();
		List<ChiTietHoaDon> list = hoaDonService.getCT_HoadonTheoHoaDon(hd.getMaHoaDon());
		double thanhTien = 0;
		for (ChiTietHoaDon ct : list) {
			SanPham sp = hoaDonService.laySanPhamTheoMa(ct.getSanPham().getMaSanPham());
			ct.setSanPham(sp);
			thanhTien = thanhTien + ct.tinhTongTien();
			System.out.println(ct.tinhTongTien());
		}
		thanhTien = thanhTien * 1.1;

		String tinhTrang = hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán";
		dataModelHoaDon.addRow(new Object[] { hd.getMaHoaDon(), kh.getMaKhachHang(), kh.getSoDienThoai(), ngayDat,
				thanhTien, tinhTrang });
	}

	public void loadTableHoaDon(List<HoaDon> list) {
		xoaAllDuLieuTable(dataModelHoaDon);
		for (HoaDon hd : list) {
			themHDvaoBang(hd);
			System.out.println(hd);
		}
	}

	public void tinhToan() {
		int index = tableDonHang.getRowCount();
		double tongTien = 0;
		for (int i = 0; i < index; i++) {
			tongTien = tongTien + Double.parseDouble(tableDonHang.getValueAt(i, 7).toString());
		}
		textTongTien.setText(Double.toString(tongTien));
		textVAT.setText(Double.toString(tongTien * 0.1));
		textThanhTien.setText(Double.toString(tongTien * 1.1));
	}

	public void tinhTienThua() {
		if (!txtSoTienKhachDua.getText().equals("")) {
			Double tienKhachDua = Double.parseDouble(txtSoTienKhachDua.getText());
			Double thanhTien = Double.parseDouble(textThanhTien.getText());
			tienKhachDua = (double) Math.round(tienKhachDua * 100) / 100;
			thanhTien = (double) Math.round(thanhTien * 100) / 100;
			if (tienKhachDua < thanhTien) {
				txtSoTienKhachDua.setForeground(Color.RED);
				textTienThua.setText("");
			} else {
				Double tienThua = tienKhachDua - thanhTien;
				txtSoTienKhachDua.setForeground(Color.BLUE);
				textTienThua.setText(Double.toString(tienThua));
			}
		}
	}

	public void xuLyNhanPhim() {
		txtSoTienKhachDua.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() >= 'a' & e.getKeyChar() <= 'z') {
					String s = txtSoTienKhachDua.getText();
					s = s.substring(0, s.length() - 1);
					txtSoTienKhachDua.setText(s);
				}
				tinhTienThua();
			}
		});
	}

	public void xoaAllDuLieuTable(DefaultTableModel model) {
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
	}

	private String maTuDong() {
		String res = "HD";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		res = res.toUpperCase() + formatter.format(ngayNhap);
		return res;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLocTheoNgay)) {

		} else if (o.equals(btnLamMoi)) {
			cboKichThuoc.setSelectedIndex(0);
			List<SanPham> ls = new ArrayList<>();
			ls = hoaDonService.getTatCaSanPham();
			loadDuLieuSanPham(ls);
		} else if (o.equals(btnTimKiemSP)) {
			List<SanPham> ls = new ArrayList<>();
			ls = dsSanPham();
			loadDuLieuSanPham(ls);
		} else if (o.equals(btnThemVaoCT_Don)) {
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			int row = tableSanPham.getSelectedRow();
			String maSP = tableSanPham.getValueAt(row, 1).toString().trim();
			SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
			String maHD = textMaHD.getText();
			HoaDon hd = hoaDonService.getHoaDon(maHD);
			if (soLuong < sp.getSoLuong() & soLuong > 0) {
				boolean flag = hd.getMaHoaDon() != null ? true : false;
				if (flag) {
					ChiTietHoaDon ct = hoaDonService.get_TungCT_HoaDon(maHD, maSP);
					hoaDonService.capNhatSLCT_HoaDon(maHD, maSP, ct.getSoLuong() + soLuong);
					hoaDonService.capNhatSLSanPham(maSP, sp.getSoLuong() - soLuong);
					loadDuLieuCT_HoaDon(hd);
				} else {
					ChiTietHoaDon ct_hd = new ChiTietHoaDon();
					ct_hd.setHoaDon(hd);
					ct_hd.setSanPham(sp);
					ct_hd.setSoLuong(soLuong);

					dataModelDonHang.addRow(new Object[] { ct_hd.getSanPham().getMaSanPham(),
							ct_hd.getSanPham().getTenSanPham(), ct_hd.getSanPham().getKichThuoc(),
							ct_hd.getSanPham().getMauSac(), ct_hd.getSanPham().getDonGia(),
							ct_hd.getSanPham().getGiamGia(), ct_hd.getSoLuong(), ct_hd.tinhTongTien() });
					tableSanPham.setValueAt(sp.getSoLuong() - soLuong, row, 6);
					tinhToan();
				}
			} else {
				JOptionPane.showMessageDialog(btnThemVaoCT_Don,
						"Số lượng mua không vượt quá số lượng tồn hoặc bé hơn bằng không");
			}

//			sp.setMaSanPham(tableSanPham.getValueAt(row, 1).toString());
//			sp.setTenSanPham(tableSanPham.getValueAt(row, 2).toString());
//			sp.setKichThuoc(tableSanPham.getValueAt(row, 3).toString());
//			sp.setMauSac(tableSanPham.getValueAt(row, 4).toString());
//			sp.setDonGia(Double.parseDouble(tableSanPham.getValueAt(row, 5).toString()));
//			sp.setSoLuong(Integer.parseInt(tableSanPham.getValueAt(row, 6).toString()));
////			sp = hoaDonService.getSanPham(sp);
//			if (soLuong < sp.getSoLuong() & soLuong > 0) {
//				ChiTietHoaDon ct_hd = new ChiTietHoaDon(soLuong);
//				ct_hd.setSanPham(sp);
//				dataModelDonHang.addRow(new Object[] { ct_hd.getSanPham().getMaSanPham(),
//						ct_hd.getSanPham().getTenSanPham(), ct_hd.getSanPham().getKichThuoc(),
//						ct_hd.getSanPham().getMauSac(), ct_hd.getSanPham().getDonGia(), ct_hd.getSanPham().getGiamGia(),
//						ct_hd.getSoLuong(), ct_hd.tinhTongTien() });
//				tableSanPham.setValueAt(sp.getSoLuong() - soLuong, row, 6);
////				tinhToan();
//			} else {
//				JOptionPane.showMessageDialog(btnThemVaoCT_Don,
//						"Số lượng mua không vượt quá số lượng tồn hoặc bé hơn bằng không");
//			}
		} else if (o.equals(btnTimKH)) {
			String sdt = txtSDT_KhachHang.getText().trim();
			if (sdt.equals("")) {
				JOptionPane.showMessageDialog(btnTimKH, "Vui lòng nhập dữ liệu");
			} else {
				KhachHang kh = new KhachHang();
				kh = hoaDonService.timKiemKhachHangtheoSDT(sdt);
				if (kh != null) {
					txtKhachHang.setText(kh.getTenKhachHang());
				} else {
					JOptionPane.showMessageDialog(btnTimKH, "Không tìm thấy!");
				}
			}
		} else if (o.equals(btnLuu)) {
			String maHD = textMaHD.getText().trim();
			if (maHD.equals("")) {
				maHD = maTuDong();
				HoaDon hd = taoHoaDon(maHD, false);
				hoaDonService.themHoaDon(hd);
				themCT_HoaDon(hd);
				allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
				loadTableHoaDon(allHoaDon);
			}
			xoaRong();

		} else if (o.equals(btnThanhToan)) {
			HoaDon hd = hoaDonService.getHoaDon(textMaHD.getText().trim());
			if (!textTienThua.getText().equals("")) {
				int input = JOptionPane.showConfirmDialog(btnThanhToan, "Đồng ý thanh toán?");
				if (input == 0) {
					String maHD = textMaHD.getText().trim();
					if (maHD.equals("")) {
						maHD = maTuDong();
						hd = taoHoaDon(maHD, true);
						hoaDonService.themHoaDon(hd);
						themCT_HoaDon(hd);
						JOptionPane.showConfirmDialog(btnThanhToan, "Thanh toán thành công!");
					} else {
						hoaDonService.capNhatTrangThai(maHD);
					}
					allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
					loadTableHoaDon(allHoaDon);
					List<SanPham> ls = new ArrayList<>();
					ls = hoaDonService.getTatCaSanPham();
					loadDuLieuSanPham(ls);
				} else {
					JOptionPane.showConfirmDialog(btnThanhToan, "Thanh toán không thành công!");
				}
			} else {
				JOptionPane.showConfirmDialog(btnThanhToan, "Chưa nhập đủ tiền!");
			}

		} else if (o.equals(btnSuaSoLuong)) {
			int index = tableDonHang.getSelectedRow();
			String m = JOptionPane.showInputDialog("Nhập số lượng mới: ");
			int soluongmoi = Integer.parseInt(m);
			HoaDon hd = hoaDonService.getHoaDon(textMaHD.getText().trim());
			int soluongcu = Integer.parseInt(tableDonHang.getValueAt(index, 6).toString());
			if (hd != null) {
				String maSP = tableDonHang.getValueAt(index, 0).toString();
				SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
				hoaDonService.capNhatSLCT_HoaDon(hd.getMaHoaDon(), maSP, soluongmoi);
				hoaDonService.capNhatSLSanPham(sp.getMaSanPham(), sp.getSoLuong() + soluongcu - soluongmoi);
			} else {
				tableDonHang.setValueAt(soluongmoi, index, 6);
			}
		} else if (o.equals(btnXoaCT_Don)) {
			int index = tableDonHang.getSelectedRow();
			String maHD = textMaHD.getText().trim();
			if (maHD.equals("")) {
				dataModelDonHang.removeRow(index);
			} else {
				HoaDon hd = hoaDonService.getHoaDon(textMaHD.getText().trim());
				int soluongcu = Integer.parseInt(tableDonHang.getValueAt(index, 6).toString());
				if (hd != null) {
					String maSP = tableDonHang.getValueAt(index, 0).toString();
					SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
					hoaDonService.capNhatSLSanPham(sp.getMaSanPham(), sp.getSoLuong() + soluongcu);
					hoaDonService.xoaCT_HD(hd.getMaHoaDon(), maSP);
				} else {
					dataModelDonHang.removeRow(index);
				}
			}

		} else if (o.equals(btnXoaHD)) {
			int index = tableHoaDon.getSelectedRow();
			boolean flag = xoaHoaDon();
			if (!flag) {
				JOptionPane.showConfirmDialog(btnXoaHD, "Hoá đơn đã thanh toán không thể xoá!");
			} else {
				JOptionPane.showConfirmDialog(btnXoaHD, "Xoá thành công!");
			}
		} else if (o.equals(btnXuatBaoCao)) {
			Date homnay = new Date(ngayHomNay.getTime());
			tongTienBaoCao = thongKeDoanhThuService.tinhTongTienBanDuocTheoNgay(homnay, Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
			String soHoaDonTuDong = taoSoHoaDonTuDong();
			XuatHoaDon(homnay, tongTienBaoCao, soHoaDonTuDong);
//			System.out.println(homnay);
//			System.out.println(Double.toString(tongTienBaoCao));
		}
	}

	public void capNhapSanPham(HoaDon hoadon) {
		List<ChiTietHoaDon> lt = new ArrayList<>();
		lt = hoaDonService.getCT_HoadonTheoHoaDon(hoadon.getMaHoaDon());
		for (ChiTietHoaDon ct : lt) {
			int soLuong = ct.getSoLuong();
			SanPham sp = hoaDonService.laySanPhamTheoMa(ct.getSanPham().getMaSanPham());
			hoaDonService.capNhatSLSanPham(sp.getMaSanPham(), sp.getSoLuong() - soLuong);
		}
	}

	public HoaDon taoHoaDon(String maHD, Boolean flag) {
		HoaDon hd = new HoaDon();
		NhanVien nv = new NhanVien(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		Date homnay = new Date(ngayHomNay.getTime());
		hd.setMaHoaDon(maHD);
		hd.setKhachHang(hoaDonService.timKiemKhachHangtheoSDT(txtSDT_KhachHang.getText()));
		hd.setNhanVien(nv);
		hd.setNgayDat(homnay);
		hd.setTrangThai(flag);
		return hd;
	}

	public void xoaRong() {
		textMaHD.setText("");
		txtSDT_KhachHang.setText("0990990990");
		textMaHD.setToolTipText("This is the textfield's tooltip");
	}

	public void themCT_HoaDon(HoaDon hd) {
		int count = tableDonHang.getRowCount();
		for (int i = 0; i < count; i++) {
			SanPham sp = new SanPham();
			sp = hoaDonService.laySanPhamTheoMa(tableDonHang.getValueAt(i, 0).toString());
			int soluong = Integer.parseInt(tableDonHang.getValueAt(i, 6).toString());
			hoaDonService.themCT_HoaDon(hd, sp, soluong);
			hoaDonService.capNhatSLSanPham(sp.getMaSanPham(), sp.getSoLuong() - soluong);
		}
	}

//	public boolean themCT_HD() {
//		Boolean kq = false;
//		int soLuong = Integer.parseInt(txtSoLuong.getText());
//		String maHD = "";
//		String maSP = "";
//		for (int i = 0; i < dataModelDonHang.getRowCount(); i++) {
//			maSP = (String) dataModelDonHang.getValueAt(i, 0);
//			maHD = (String) textMaHD.getText();
//			if(maHD.equals("")) {
//				int row = tableSanPham.getSelectedRow();
//				SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
//				HoaDon hd = hoaDonService.getHoaDon(maHD);
//				ChiTietHoaDon ct_hd = new ChiTietHoaDon();
//				ct_hd.setHoaDon(hd);
//				ct_hd.setSanPham(sp);
//				ct_hd.setSoLuong(soLuong);
//				dataModelDonHang.addRow(new Object[] { ct_hd.getSanPham().getMaSanPham(),
//						ct_hd.getSanPham().getTenSanPham(), ct_hd.getSanPham().getKichThuoc(),
//						ct_hd.getSanPham().getMauSac(), ct_hd.getSanPham().getDonGia(),
//						ct_hd.getSanPham().getGiamGia(), ct_hd.getSoLuong(), ct_hd.tinhTongTien() });
//				tableSanPham.setValueAt(sp.getSoLuong() - soLuong, row, 6);
//			}
//			else {
//				ChiTietHoaDon ct_hd = hoaDonService.get_TungCT_HoaDon(maHD, maSP);
//				kq = hoaDonService.xoaCT_HD(maHD, maSP);
//				kq = hoaDonService.capNhatSLSanPham(maSP, ct_hd.getSanPham().getSoLuong() + ct_hd.getSoLuong());
//				HoaDon hd = hoaDonService.getHoaDon(maHD);
//				SanPham sp = hoaDonService.laySanPhamTheoMa(maSP);
//				kq = hoaDonService.themCT_HoaDon(hd, sp, soLuong);
//				kq = hoaDonService.capNhatSLSanPham(maSP, ct_hd.getSanPham().getSoLuong() - ct_hd.getSoLuong());
//			}
//			
//			i--;
//		}
//
//		return kq;
//	}

	public boolean xoaHoaDon() {
		Boolean kq = false;
		String maHD = "";
		int index = tableHoaDon.getSelectedRow();
		maHD = (String) dataModelHoaDon.getValueAt(index, 0);
		HoaDon hd = hoaDonService.getHoaDon(maHD);
		if (hd.isTrangThai() == false) {
			List<ChiTietHoaDon> list = new ArrayList<>();
			list = hoaDonService.getCT_HoadonTheoHoaDon(maHD);
			for (ChiTietHoaDon ct : list) {
				kq = hoaDonService.xoaCT_HD(maHD, ct.getSanPham().getMaSanPham());
				kq = hoaDonService.capNhatSLSanPham(ct.getSanPham().getMaSanPham(),
						ct.getSanPham().getSoLuong() + ct.getSoLuong());
			}
			kq = hoaDonService.xoaHD(maHD);
			dataModelHoaDon.removeRow(index);
		}
		return kq;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = tableHoaDon.getSelectedRow();
		String maHoaDon = dataModelHoaDon.getValueAt(index, 0).toString();
		try {
			HoaDon hd = hoaDonService.getHoaDon(maHoaDon);
			textMaHD.setText(maHoaDon + "");
			String soDT = dataModelHoaDon.getValueAt(index, 2).toString();
			KhachHang kh = hoaDonService.timKiemKhachHangtheoSDT(soDT);
			String ngayLap = tableHoaDon.getValueAt(index, 3).toString();
			txtKhachHang.setText(kh.getTenKhachHang());
			txtSDT_KhachHang.setText(soDT);
			textNgayLap.setText(ngayLap);
			loadDuLieuCT_HoaDon(hd);
			tinhToan();
		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}

//		loadDuLieuCT_HoaDon(hd);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private String taoSoHoaDonTuDong () {        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ngayNhap = LocalDateTime.now();
        String res = formatter.format(ngayNhap);
        return res;
	}
}
