package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import bus.SanPhamService;
import bus.SanPhamServiceImpl;
import dao.ConectDatabase;
import dto.KhachHang;
import dto.SanPham;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form_San_Pham extends JFrame {

	public static JPanel contentPane;
	private JTextField textMaSanPham;
	private JTextField textTenSanPham;
	private JLabel lblMoTa;
	private JTextField textMauSac;
	private JTextField textSoLuong;
	private JTextField textGiaNhap;
	private JTextField textDonGiaBan;
	private JTable tableSanPham;
	private DefaultTableModel modelSanPham;
	private JTextField textTimKiem;
	private JLabel lblHinhAnh;

	private SanPhamService sanPhamservice = new SanPhamServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_San_Pham frame = new Form_San_Pham();
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
	public Form_San_Pham() {
		
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 498);
		setSize(1380, 780);		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinSanPham = new JPanel();
		panelThongTinSanPham.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinSanPham.setBounds(10, 29, 1346, 222);
		contentPane.add(panelThongTinSanPham);
		panelThongTinSanPham.setLayout(null);
		
		JLabel lblMaSanPham = new JLabel("Mã Sản phẩm:");
		lblMaSanPham.setBounds(189, 21, 128, 13);
		panelThongTinSanPham.add(lblMaSanPham);
		
		textMaSanPham = new JTextField();
		textMaSanPham.setText("Tự dộng tăng khi để trống");
		textMaSanPham.setForeground(new Color(153, 153, 153));
		textMaSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaSanPham.getText().equals("Tự dộng tăng khi để trống")) {
					textMaSanPham.setText("");
					textMaSanPham.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaSanPham.getText().equals("Tự dộng tăng khi để trống")) {
					textMaSanPham.setText("Tự dộng tăng khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textMaSanPham.getText().equals("")) {
					textMaSanPham.setText("Tự dộng tăng khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
				}	
			}
		});
		textMaSanPham.setBounds(347, 18, 218, 19);
		panelThongTinSanPham.add(textMaSanPham);
		textMaSanPham.setColumns(10);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản phẩm:");
		lblTenSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenSanPham.setBounds(189, 50, 128, 13);
		panelThongTinSanPham.add(lblTenSanPham);
		
		textTenSanPham = new JTextField();
		textTenSanPham.setBounds(347, 47, 218, 19);
		panelThongTinSanPham.add(textTenSanPham);
		textTenSanPham.setColumns(10);
		
		lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setBounds(189, 99, 122, 13);
		panelThongTinSanPham.add(lblMoTa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 79, 218, 55);
		panelThongTinSanPham.add(scrollPane);
		
		JTextArea textMoTa = new JTextArea();
		scrollPane.setViewportView(textMoTa);
		
		JLabel lblChatLieu = new JLabel("Chất liệu:");
		lblChatLieu.setBounds(189, 151, 122, 13);
		panelThongTinSanPham.add(lblChatLieu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(346, 144, 218, 49);
		panelThongTinSanPham.add(scrollPane_1);
		
		JTextArea textChatLieu = new JTextArea();
		scrollPane_1.setViewportView(textChatLieu);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(625, 21, 77, 13);
		panelThongTinSanPham.add(lblGioiTinh);
		
		JCheckBox chckbxNam = new JCheckBox("Nam");
		chckbxNam.setBounds(735, 17, 69, 21);
		panelThongTinSanPham.add(chckbxNam);
		
		JCheckBox chckbxNu = new JCheckBox("Nữ");
		chckbxNu.setBounds(827, 17, 77, 21);
		panelThongTinSanPham.add(chckbxNu);
		
		JLabel lblKichThuoc = new JLabel("Kích thước:");
		lblKichThuoc.setBounds(625, 53, 77, 13);
		panelThongTinSanPham.add(lblKichThuoc);
		
		JComboBox comboKichThuoc = new JComboBox();
		comboKichThuoc.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "XXL", "XXXL", "FreeSize"}));
		comboKichThuoc.setBounds(735, 49, 169, 21);
		panelThongTinSanPham.add(comboKichThuoc);
		
		JLabel lblMauSac = new JLabel("Màu sắc:");
		lblMauSac.setBounds(625, 99, 77, 13);
		panelThongTinSanPham.add(lblMauSac);
		
		textMauSac = new JTextField();
		textMauSac.setBounds(736, 93, 168, 19);
		panelThongTinSanPham.add(textMauSac);
		textMauSac.setColumns(10);
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setBounds(24, 21, 155, 160);
		lblHinhAnh.setIcon(ResizeImage("C:/Users/trong/Downloads/Compressed/"
				+ "QuanLyCuaHangQuanAo-master/QuanLyCuaHangQuanAo-master/HinhAnh/icon/iconSanPham.png"));
		panelThongTinSanPham.add(lblHinhAnh);
		
		JButton btnHinhAnh = new JButton("Chọn hình");
		JFileChooser chooser = new JFileChooser();
		
		btnHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()== btnHinhAnh)
                {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblHinhAnh.setIcon(ResizeImage(path));
				}
                }
			}
		});
		btnHinhAnh.setBounds(24, 191, 155, 21);
		panelThongTinSanPham.add(btnHinhAnh);
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setBounds(625, 135, 77, 13);
		panelThongTinSanPham.add(lblSoLuong);
		
		textSoLuong = new JTextField();
		textSoLuong.setBounds(735, 132, 169, 19);
		panelThongTinSanPham.add(textSoLuong);
		textSoLuong.setColumns(10);
		
		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setBounds(950, 21, 91, 13);
		panelThongTinSanPham.add(lblGiaNhap);
		
		textGiaNhap = new JTextField();
		textGiaNhap.setBounds(1097, 18, 218, 19);
		panelThongTinSanPham.add(textGiaNhap);
		textGiaNhap.setColumns(10);
		
		JLabel lblDonGiaBan = new JLabel("Đơn giá bán:");
		lblDonGiaBan.setBounds(950, 53, 91, 13);
		panelThongTinSanPham.add(lblDonGiaBan);
		
		textDonGiaBan = new JTextField();
		textDonGiaBan.setBounds(1097, 53, 218, 19);
		panelThongTinSanPham.add(textDonGiaBan);
		textDonGiaBan.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái kinh doanh:");
		lblTrangThai.setBounds(950, 99, 137, 13);
		panelThongTinSanPham.add(lblTrangThai);
		
		JComboBox comboTrangThai = new JComboBox();
		comboTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Đang kinh doanh", "Ngừng kinh doanh"}));
		comboTrangThai.setBounds(1097, 95, 218, 21);
		panelThongTinSanPham.add(comboTrangThai);
		
		JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
		lblLoaiSanPham.setBounds(950, 135, 122, 13);
		panelThongTinSanPham.add(lblLoaiSanPham);
		
		JComboBox comboLoaiSanPham = new JComboBox();
		comboLoaiSanPham.setBounds(1097, 131, 151, 21);
		panelThongTinSanPham.add(comboLoaiSanPham);
		
		JButton btnThemLoaiSanPham = new JButton("+");
		btnThemLoaiSanPham.setBounds(1258, 131, 57, 21);
		panelThongTinSanPham.add(btnThemLoaiSanPham);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(950, 171, 108, 13);
		panelThongTinSanPham.add(lblNhaCungCap);
		
		JComboBox comboNhaCungCap = new JComboBox();
		comboNhaCungCap.setBounds(1097, 167, 151, 21);
		panelThongTinSanPham.add(comboNhaCungCap);
		
		JButton btnThemNhaCungCap = new JButton("+");
		btnThemNhaCungCap.setBounds(1258, 167, 57, 21);
		panelThongTinSanPham.add(btnThemNhaCungCap);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBounds(10, 261, 1346, 63);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(710, 10, 100, 30);
		panelChucNang.add(btnThem);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(btnThem)) {
					
				}
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(820, 10, 100, 30);
		panelChucNang.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(930, 10, 100, 30);
		panelChucNang.add(btnSua);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(245, 10, 100, 30);
		panelChucNang.add(btnTim);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBounds(1113, 10, 100, 30);
		panelChucNang.add(btnXoaRong);
		
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(btnXoaRong)) {
					lblHinhAnh.setIcon(ResizeImage("C:/Users/trong/Downloads/Compressed/"
							+ "QuanLyCuaHangQuanAo-master/QuanLyCuaHangQuanAo-master/HinhAnh/icon/iconSanPham.png"));
					textMaSanPham.setText("Tự dộng tăng khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
					textTenSanPham.setText("");
					textMoTa.setText("");
					textChatLieu.setText("");
					textMauSac.setText("");
					textSoLuong.setText("");
					textGiaNhap.setText("");
					textDonGiaBan.setText("");
					comboTrangThai.setSelectedIndex(0);
					chckbxNam.setSelected(false);
					chckbxNu.setSelected(false);
					comboKichThuoc.setSelectedIndex(0);
				}
			}
		});
		
		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.setBounds(1223, 10, 100, 30);
		panelChucNang.add(btnHoanTac);
		
		textTimKiem = new JTextField();
		textTimKiem.setBounds(20, 16, 199, 19);
		panelChucNang.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JComboBox comboLocLoaiSanPham = new JComboBox();
		comboLocLoaiSanPham.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		comboLocLoaiSanPham.setBounds(427, 10, 219, 30);
		panelChucNang.add(comboLocLoaiSanPham);
		
		JPanel panelDanhSachSanPam = new JPanel();
		panelDanhSachSanPam.setBounds(10, 350, 1346, 383);
		contentPane.add(panelDanhSachSanPam);
		panelDanhSachSanPam.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelDanhSachSanPam.add(scrollPane_2);
		
		tableSanPham = new JTable();
		
		String[] colHeader = { "", "STT", "Mã sản phẩm", "Tên sản phẩm","Loại sản phẩm", "Đơn giá bán", "Trạng thái kinh doanh"};
		modelSanPham = new DefaultTableModel(colHeader, 0);
		tableSanPham = new JTable(modelSanPham);
		
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableSanPham.getColumnModel().getColumn(0).setMaxWidth(30);
		tableSanPham.getColumnModel().getColumn(1).setMaxWidth(75);
		scrollPane_2.setViewportView(tableSanPham);
		
		docDuLieu();
			
	}
	
	private ImageIcon  ResizeImage (String ImagePath){
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;		 
	 }
	
	private void docDuLieu() {
		ArrayList<SanPham> danhSachSanPham = sanPhamservice.getTatCaSanPham();
		modelSanPham.setRowCount(0);
		int sST = 0;
		JCheckBox chonSP = new JCheckBox();
		for(SanPham sp : danhSachSanPham) {
			sST++;
			modelSanPham.addRow(new Object[] {
					chonSP, sST, sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanPham().getTenLoai(), sp.getDonGia(), sp.getTrangThai()
			});
		}
	}
}

