package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import bus.LoaiSanPhamService;
import bus.LoaiSanPhamServiceImpl;
import bus.NhaCungCapSerVice;
import bus.NhaCungCapServiceIml;
import bus.SanPhamService;
import bus.SanPhamServiceImpl;
import dao.ConectDatabase;
import dto.KhachHang;
import dto.LoaiSanPham;
import dto.NhaCungCap;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Form_San_Pham extends JFrame {

	public static JPanel contentPane;
	private JTextField textMaSanPham;
	private JTextField textTenSanPham;
	private JLabel lblMoTa;
	private JTextField textMauSac;
	private JTextField textSoLuong;
	private JTextField textGiamGia;
	private JTextField textDonGiaBan;
	private JTable tableSanPham;
	private DefaultTableModel modelSanPham;
	private JTextField textTimKiem;
	private JLabel lblHinhAnh;

	private SanPhamService sanPhamservice = new SanPhamServiceImpl();
	private JTextArea textMoTa;
	private JTextArea textChatLieu;
	private JComboBox comboLoaiSanPham;
	private JComboBox comboTrangThai;
	private JComboBox comboKichThuoc;
	private JCheckBox chckbxNam;
	private JCheckBox chckbxNu;
	private JComboBox comboNhaCungCap;
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
		setSize(1368, 729);		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinSanPham = new JPanel();
		panelThongTinSanPham.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinSanPham.setBounds(35, 33, 571, 529);
		contentPane.add(panelThongTinSanPham);
		panelThongTinSanPham.setLayout(null);
		
		JLabel lblMaSanPham = new JLabel("Mã Sản phẩm:");
		lblMaSanPham.setBounds(264, 21, 99, 13);
		panelThongTinSanPham.add(lblMaSanPham);
		
		textMaSanPham = new JTextField();
		textMaSanPham.setText("Tự động khi để trống");
		textMaSanPham.setForeground(new Color(153, 153, 153));
		textMaSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaSanPham.getText().equals("Tự động khi để trống")) {
					textMaSanPham.setText("");
					textMaSanPham.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaSanPham.getText().equals("Tự động khi để trống")) {
					textMaSanPham.setText("Tự động khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textMaSanPham.getText().equals("")) {
					textMaSanPham.setText("Tự động khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
				}	
			}
		});
		textMaSanPham.setBounds(382, 18, 155, 19);
		panelThongTinSanPham.add(textMaSanPham);
		textMaSanPham.setColumns(10);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản phẩm:");
		lblTenSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenSanPham.setBounds(264, 50, 99, 13);
		panelThongTinSanPham.add(lblTenSanPham);
		
		textTenSanPham = new JTextField();
		textTenSanPham.setBounds(382, 47, 155, 19);
		panelThongTinSanPham.add(textTenSanPham);
		textTenSanPham.setColumns(10);
		
		lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setBounds(264, 98, 77, 13);
		panelThongTinSanPham.add(lblMoTa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 81, 155, 55);
		panelThongTinSanPham.add(scrollPane);
		
		textMoTa = new JTextArea();
		scrollPane.setViewportView(textMoTa);
		
		JLabel lblChatLieu = new JLabel("Chất liệu:");
		lblChatLieu.setBounds(264, 168, 91, 13);
		panelThongTinSanPham.add(lblChatLieu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(382, 146, 155, 49);
		panelThongTinSanPham.add(scrollPane_1);
		
		textChatLieu = new JTextArea();
		scrollPane_1.setViewportView(textChatLieu);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(24, 261, 77, 13);
		panelThongTinSanPham.add(lblGioiTinh);
		
		chckbxNam = new JCheckBox("Nam");
		chckbxNam.setBounds(110, 257, 69, 21);
		panelThongTinSanPham.add(chckbxNam);
		
		chckbxNu = new JCheckBox("Nữ");
		chckbxNu.setBounds(181, 257, 77, 21);
		panelThongTinSanPham.add(chckbxNu);
		
		JLabel lblKichThuoc = new JLabel("Kích thước:");
		lblKichThuoc.setBounds(24, 304, 77, 13);
		panelThongTinSanPham.add(lblKichThuoc);
		
		comboKichThuoc = new JComboBox();
		comboKichThuoc.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "XXL", "XXXL", "FreeSize"}));
		comboKichThuoc.setBounds(110, 300, 121, 21);
		panelThongTinSanPham.add(comboKichThuoc);
		
		JLabel lblMauSac = new JLabel("Màu sắc:");
		lblMauSac.setBounds(264, 220, 77, 13);
		panelThongTinSanPham.add(lblMauSac);
		
		textMauSac = new JTextField();
		textMauSac.setBounds(382, 217, 155, 19);
		panelThongTinSanPham.add(textMauSac);
		textMauSac.setColumns(10);
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setBounds(24, 21, 207, 185);
		lblHinhAnh.setIcon(ResizeImage("C:/Users/trong/Downloads/Compressed/"
				+ "QuanLyCuaHangQuanAo-master/QuanLyCuaHangQuanAo-master/HinhAnh/icon/iconSanPham.png"));
		System.out.println(lblHinhAnh.getText());
		panelThongTinSanPham.add(lblHinhAnh);
		
		JButton btnHinhAnh = new JButton("Chọn hình");
		
		btnHinhAnh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblHinhAnh.setIcon(ResizeImage(path));
					lblHinhAnh.setText(path);
				}
			}
		});
		btnHinhAnh.setBounds(53, 216, 155, 21);
		panelThongTinSanPham.add(btnHinhAnh);
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setBounds(264, 261, 77, 13);
		panelThongTinSanPham.add(lblSoLuong);
		
		textSoLuong = new JTextField();
		textSoLuong.setBounds(382, 258, 155, 19);
		panelThongTinSanPham.add(textSoLuong);
		textSoLuong.setColumns(10);
		
		JLabel lblGiaNhap = new JLabel("Giảm giá:");
		lblGiaNhap.setBounds(264, 304, 91, 13);
		panelThongTinSanPham.add(lblGiaNhap);
		
		textGiamGia = new JTextField();
		textGiamGia.setBounds(382, 301, 155, 19);
		panelThongTinSanPham.add(textGiamGia);
		textGiamGia.setColumns(10);
		
		JLabel lblDonGiaBan = new JLabel("Đơn giá bán:");
		lblDonGiaBan.setBounds(264, 344, 91, 13);
		panelThongTinSanPham.add(lblDonGiaBan);
		
		textDonGiaBan = new JTextField();
		textDonGiaBan.setBounds(382, 341, 155, 19);
		panelThongTinSanPham.add(textDonGiaBan);
		textDonGiaBan.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái kinh doanh:");
		lblTrangThai.setBounds(24, 392, 137, 13);
		panelThongTinSanPham.add(lblTrangThai);
		
		comboTrangThai = new JComboBox();
		comboTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Đang kinh doanh", "Ngừng kinh doanh"}));
		comboTrangThai.setBounds(182, 388, 230, 21);
		panelThongTinSanPham.add(comboTrangThai);
		
		JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
		lblLoaiSanPham.setBounds(24, 439, 122, 13);
		panelThongTinSanPham.add(lblLoaiSanPham);
		
		comboLoaiSanPham = new JComboBox();
		comboLoaiSanPham.setBounds(182, 435, 230, 21);
		panelThongTinSanPham.add(comboLoaiSanPham);
		
		LoaiSanPhamService loaiSanPhamService = new LoaiSanPhamServiceImpl();
		ArrayList<LoaiSanPham> danhSachMaLoai = loaiSanPhamService.getTatCaLoaiSanPham();
		for (LoaiSanPham loaiSanPham : danhSachMaLoai) {
			comboLoaiSanPham.addItem(loaiSanPham.getMaLoaiSanPham() + " " + loaiSanPham.getTenLoai());
		}
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(24, 488, 108, 13);
		panelThongTinSanPham.add(lblNhaCungCap);
		
		comboNhaCungCap = new JComboBox();
		comboNhaCungCap.setBounds(182, 484, 230, 21);
		panelThongTinSanPham.add(comboNhaCungCap);
		
		NhaCungCapSerVice nhaCungCapService = new NhaCungCapServiceIml();
		ArrayList<NhaCungCap> danhSachMaNhaCungCap = nhaCungCapService.getTatCaNhaCungCap();
		for (NhaCungCap nhaCungCap : danhSachMaNhaCungCap) {
			comboNhaCungCap.addItem(nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap());
		}
		
		JButton btnThemLoaiSanPham = new JButton("+");
		btnThemLoaiSanPham.setBounds(434, 435, 85, 21);
		panelThongTinSanPham.add(btnThemLoaiSanPham);
		
		btnThemLoaiSanPham.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Form_Loai_San_Pham().show();
			}
		});
		
		JButton btnThemNhaCungCap = new JButton("+");
		btnThemNhaCungCap.setBounds(434, 484, 85, 21);
		panelThongTinSanPham.add(btnThemNhaCungCap);
		
		btnThemNhaCungCap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Form_Nha_Cung_Cap().show();
			}
		});
		
		JPanel panelDanhSachSanPam = new JPanel();
		panelDanhSachSanPam.setBorder(new TitledBorder(null, "Danh sách Sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSachSanPam.setBounds(647, 33, 677, 646);
		contentPane.add(panelDanhSachSanPam);
		panelDanhSachSanPam.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelDanhSachSanPam.add(scrollPane_2);
		
		String[] colHeader = {"STT", "Mã sản phẩm", "Tên sản phẩm","Loại sản phẩm", "Đơn giá bán", "Trạng thái kinh doanh",
								"Số lượng", "Mô tả", "Màu sắc", "Kích thước", "Giới tính", "Hình ảnh", "Chất liệu", "Nhà cung cấp", "Giảm giá"};
		modelSanPham = new DefaultTableModel(colHeader, 0);
		tableSanPham = new JTable(modelSanPham);
		scrollPane_2.setViewportView(tableSanPham);
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(50); 
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(200); 
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(6).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(7).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(8).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(9).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(10).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(11).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(12).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(13).setPreferredWidth(100); 
		tableSanPham.getColumnModel().getColumn(14).setPreferredWidth(100);
		tableSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tableSanPham.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableSanPham.getSelectedRow();
				textMaSanPham.setText(modelSanPham.getValueAt(row, 1).toString());
				textTenSanPham.setText(modelSanPham.getValueAt(row, 2).toString());
				comboLoaiSanPham.setSelectedItem(modelSanPham.getValueAt(row, 3).toString());
				textDonGiaBan.setText(modelSanPham.getValueAt(row, 4).toString());
				comboTrangThai.setSelectedItem(modelSanPham.getValueAt(row, 5).toString());
				textSoLuong.setText(modelSanPham.getValueAt(row, 6).toString());
				textMoTa.setText(modelSanPham.getValueAt(row, 7).toString());
				textMauSac.setText(modelSanPham.getValueAt(row, 8).toString());
				comboKichThuoc.setSelectedItem(modelSanPham.getValueAt(row, 9).toString());
				chckbxNam.setSelected(false);
				chckbxNu.setSelected(false);
				if (modelSanPham.getValueAt(row, 10).toString().equals("Nam")) {
					chckbxNam.setSelected(true);
				}
				else if (modelSanPham.getValueAt(row, 10).toString().equals("Nu")) {
					chckbxNu.setSelected(true);
				}
				else if (modelSanPham.getValueAt(row, 10).toString().equals("")) {
					chckbxNam.setSelected(false);
					chckbxNu.setSelected(false);
				}
				else {
					chckbxNam.setSelected(true);
					chckbxNu.setSelected(true);
				}
				lblHinhAnh.setIcon(ResizeImage(modelSanPham.getValueAt(row, 11).toString()));
				lblHinhAnh.setText(modelSanPham.getValueAt(row, 11).toString());
				textChatLieu.setText(modelSanPham.getValueAt(row, 12).toString());
				comboNhaCungCap.setSelectedItem(modelSanPham.getValueAt(row, 13).toString());
				textGiamGia.setText(modelSanPham.getValueAt(row, 14).toString());
			}
		});
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBounds(35, 572, 571, 107);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSanPham();
			}
		});
		btnXoa.setBounds(351, 10, 100, 30);
		panelChucNang.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(461, 10, 100, 30);
		panelChucNang.add(btnSua);
		
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suaLoaiSanPam();
			}
		});
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBounds(287, 50, 100, 30);
		panelChucNang.add(btnXoaRong);
		
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(btnXoaRong)) {
					xoaRong();
				}
			}
		});
		
		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableSanPham.getSelectedRow();
				hoanTac(row);
			}
		});
		btnHoanTac.setBounds(410, 50, 100, 30);
		panelChucNang.add(btnHoanTac);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(234, 10, 100, 30);
		panelChucNang.add(btnThem);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				themSanPham();
			}
		});
		
		JComboBox comboLocLoaiSanPham = new JComboBox();
		comboLocLoaiSanPham.setBounds(653, 10, 219, 20);
		contentPane.add(comboLocLoaiSanPham);
		comboLocLoaiSanPham.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		
		for (LoaiSanPham loaiSanPham : danhSachMaLoai) {
			comboLocLoaiSanPham.addItem(loaiSanPham.getTenLoai());
		}
		
		comboLocLoaiSanPham.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (comboLocLoaiSanPham.getSelectedItem().toString().equals("Tất cả")) {
					docDuLieu();
				}
				else {
					String tuKhoa = comboLocLoaiSanPham.getSelectedItem().toString();
					docDuLieuTheoLoai(tuKhoa);
				}
			}
		});
	
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(1224, 10, 100, 20);
		contentPane.add(btnTim);
		
		textTimKiem = new JTextField();
		textTimKiem.setBounds(904, 11, 250, 20);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timKiemSanPham();
			}
		});
		
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
		for(SanPham sp : danhSachSanPham) {
			sST++;
			modelSanPham.addRow(new Object[] {
					sST, sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanPham().getMaLoaiSanPham(), sp.getDonGia(), sp.getTrangThai(),
					sp.getSoLuong(), sp.getMota(), sp.getMauSac(), sp.getKichThuoc(), sp.getGioiTinh(),
					sp.getHinhAnh(), sp.getChatLieu(), sp.getNhaCungCap().getMaNhaCungCap(), sp.getGiamGia()
			});
		}
	}
	private void docDuLieuTheoLoai(String tuKhoa) {
		ArrayList<SanPham> danhSachSanPham = sanPhamservice.timKiemSanPhamTheoLoai(tuKhoa);
			modelSanPham.setRowCount(0);
			int sST = 0;
			for(SanPham sp : danhSachSanPham) {
				sST++;
				modelSanPham.addRow(new Object[] {
						sST, sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanPham().getMaLoaiSanPham(), sp.getDonGia(), sp.getTrangThai(),
						sp.getSoLuong(), sp.getMota(), sp.getMauSac(), sp.getKichThuoc(), sp.getGioiTinh(),
						sp.getHinhAnh(), sp.getChatLieu(), sp.getNhaCungCap().getMaNhaCungCap(), sp.getGiamGia()
				});
			}
			
	}
	
	private void themSanPham () {
		if (kiemTraDuLieu()) {
			String maSanPham = textMaSanPham.getText().trim();
			String tenSanPham =  textTenSanPham.getText().trim();
			LoaiSanPham loaiSanPham = new LoaiSanPham(layMa(comboLoaiSanPham.getSelectedItem().toString()));
			double donGia = Double.parseDouble(textDonGiaBan.getText().trim());
			String trangThai = comboTrangThai.getSelectedItem().toString();
			int soLuong = Integer.parseInt(textSoLuong.getText().trim());
			String moTa = textMoTa.getText().trim();
			String mauSac = textMauSac.getText().trim();
			String kichThuoc = comboKichThuoc.getSelectedItem().toString();
			String gioiTinh = "";
			if (chckbxNam.isSelected()) {
				gioiTinh += "Nam";
			}
			if (chckbxNu.isSelected()) {
			gioiTinh += "Nu";
			}
			String hinhAnh = lblHinhAnh.getText().trim();
			String chatLieu = textChatLieu.getText().trim();
			NhaCungCap nhaCungCap = new NhaCungCap(layMa(comboNhaCungCap.getSelectedItem().toString()));
			double giamGia = Double.parseDouble(textGiamGia.getText().trim());
			if (maSanPham.equals("") || maSanPham.equals("Tự động khi để trống")) {
					maSanPham = taoMaTuDong();
				}
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, moTa, donGia, hinhAnh, soLuong, giamGia, mauSac, gioiTinh, kichThuoc, trangThai, chatLieu, loaiSanPham, nhaCungCap); 
				if (!sanPhamservice.getTatCaSanPham().contains(sanPham)) {
					sanPhamservice.themSanPham(sanPham);
					docDuLieu();
					xoaRong();
				} else {
					JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!");
				}
				
		}
	}
	
	private void xoaSanPham () {
		int row = tableSanPham.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maSanPham = tableSanPham.getValueAt(row, 1).toString();
				sanPhamservice.xoaSanPham(maSanPham);	
				xoaRong();
				docDuLieu();
				if (row < sanPhamservice.getTatCaSanPham().size() - 1) {
					selectedRow(row);
				} else if (sanPhamservice.getTatCaSanPham().size() > 0) {
					row = 0;
					selectedRow(row);
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}
	
	private void suaLoaiSanPam () {
		int row = tableSanPham.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Cập nhật!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				if (kiemTraDuLieu()) {
					String maSanPham = textMaSanPham.getText().trim();
					String tenSanPham =  textTenSanPham.getText().trim();
					LoaiSanPham loaiSanPham = new LoaiSanPham(layMa(comboLoaiSanPham.getSelectedItem().toString()));
					double donGia = Double.parseDouble(textDonGiaBan.getText().trim());
					String trangThai = comboTrangThai.getSelectedItem().toString();
					int soLuong = Integer.parseInt(textSoLuong.getText().trim());
					String moTa = textMoTa.getText().trim();
					String mauSac = textMauSac.getText().trim();
					String kichThuoc = comboKichThuoc.getSelectedItem().toString();
					String gioiTinh = "";
					if (chckbxNam.isSelected()) {
						gioiTinh += "Nam";
					}
					if (chckbxNu.isSelected()) {
					gioiTinh += "Nu";
					}					
					String hinhAnh = lblHinhAnh.getText().trim();
					String chatLieu = textChatLieu.getText().trim();
					NhaCungCap nhaCungCap = new NhaCungCap(layMa(comboNhaCungCap.getSelectedItem().toString()));
					double giamGia = Double.parseDouble(textGiamGia.getText().trim());
					SanPham sanPham = new SanPham(maSanPham, tenSanPham, moTa, donGia, hinhAnh, soLuong, giamGia, mauSac, gioiTinh, kichThuoc, trangThai, chatLieu, loaiSanPham, nhaCungCap); 
					sanPhamservice.capNhatSanPham(sanPham);
					System.out.println(sanPham);
					docDuLieu();
					xoaRong();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}
	
	private void timKiemSanPham () {
		String tuKhoa = textTimKiem.getText().trim();
		if (tuKhoa.equals("")) {
			docDuLieu();
		} else {
			ArrayList<SanPham> danhSachSanPham = sanPhamservice.timKiemSanPham(tuKhoa);
			modelSanPham.setRowCount(0);
			int sST = 0;
			for(SanPham sp : danhSachSanPham) {
				sST++;
				modelSanPham.addRow(new Object[] {
						sST, sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanPham().getMaLoaiSanPham(), sp.getDonGia(), sp.getTrangThai(),
						sp.getSoLuong(), sp.getMota(), sp.getMauSac(), sp.getKichThuoc(), sp.getGioiTinh(),
						sp.getHinhAnh(), sp.getChatLieu(), sp.getNhaCungCap().getMaNhaCungCap(), sp.getGiamGia()
				});
			}
		}
	}
	
	private void xoaRong () {
		lblHinhAnh.setIcon(ResizeImage("C:/Users/trong/Downloads/Compressed/"
							+ "QuanLyCuaHangQuanAo-master/QuanLyCuaHangQuanAo-master/HinhAnh/icon/iconSanPham.png"));
					textMaSanPham.setText("Tự động khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
					textTenSanPham.setText("");
					textMoTa.setText("");
					textChatLieu.setText("");
					textMauSac.setText("");
					textSoLuong.setText("");
					textGiamGia.setText("");
					textDonGiaBan.setText("");
					comboTrangThai.setSelectedIndex(0);
					chckbxNam.setSelected(false);
					chckbxNu.setSelected(false);
					comboKichThuoc.setSelectedIndex(0);
					comboLoaiSanPham.setSelectedIndex(0);
					comboNhaCungCap.setSelectedIndex(0);
					textMaSanPham.requestFocus();
	}
	
	private void selectedRow(int row) {
		if (row != -1) {
			tableSanPham.setRowSelectionInterval(row, row);
			tableSanPham.scrollRectToVisible(tableSanPham.getCellRect(row, row, true));
		}
	}
	private void hoanTac(int row) {
		if (row != -1) {
			tableSanPham.setRowSelectionInterval(row, row);
			tableSanPham.scrollRectToVisible(tableSanPham.getCellRect(row, row, true));
			textMaSanPham.setText(modelSanPham.getValueAt(row, 1).toString());
			textTenSanPham.setText(modelSanPham.getValueAt(row, 2).toString());
			comboLoaiSanPham.setSelectedItem(modelSanPham.getValueAt(row, 3).toString());
			textDonGiaBan.setText(modelSanPham.getValueAt(row, 4).toString());
			comboTrangThai.setSelectedItem(modelSanPham.getValueAt(row, 5).toString());
			textSoLuong.setText(modelSanPham.getValueAt(row, 6).toString());
			textMoTa.setText(modelSanPham.getValueAt(row, 7).toString());
			textMauSac.setText(modelSanPham.getValueAt(row, 8).toString());
			comboKichThuoc.setSelectedItem(modelSanPham.getValueAt(row, 9).toString());
			chckbxNam.setSelected(false);
			chckbxNu.setSelected(false);
			if (modelSanPham.getValueAt(row, 10).toString().equals("Nam")) {
				chckbxNam.setSelected(true);
			}
			else if (modelSanPham.getValueAt(row, 10).toString().equals("Nu")) {
				chckbxNu.setSelected(true);
			}
			else if (modelSanPham.getValueAt(row, 10).toString().equals("")) {
				chckbxNam.setSelected(false);
				chckbxNu.setSelected(false);
			}
			else {
				chckbxNam.setSelected(true);
				chckbxNu.setSelected(true);
			}
			lblHinhAnh.setIcon(ResizeImage(modelSanPham.getValueAt(row, 11).toString()));
			textChatLieu.setText(modelSanPham.getValueAt(row, 12).toString());
			comboNhaCungCap.setSelectedItem(modelSanPham.getValueAt(row, 13).toString());
			textGiamGia.setText(modelSanPham.getValueAt(row, 14).toString());
		}
	}
	private String taoMaTuDong () {        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ngayNhap = LocalDateTime.now();
        String res = "SP" + formatter.format(ngayNhap);
        return res;
	}
	private static String layMa (String ma) {
        String[] tu = ma.split(" ");       
        return tu[0];
	}
	
	private boolean kiemTraDuLieu () {
		String maSanPham = textMaSanPham.getText().trim();
		String tenSanPham = textTenSanPham.getText().trim();
		String moTa = textMoTa.getText().trim();
		String chatLieu = textChatLieu.getText().trim();
		String mauSac = textMauSac.getText().trim();
		String soLuong = textSoLuong.getText().trim();
		String giamGia = textGiamGia.getText().trim();
		String donGia = textDonGiaBan.getText().trim();
		
		if (!maSanPham.equals("Tự động khi để trống")) {
			if (!(maSanPham.length() > 0 && maSanPham.length() < 50
					&& maSanPham.matches("SP[\\d]{1,14}"))) {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm! 'SP[\\d]{1,14}'");
				return false;
			}
		}
		if (!(tenSanPham.length() > 0 && tenSanPham.length() < 50
				&& tenSanPham.matches("[\\W\\w\\s]+"))) {
			JOptionPane.showMessageDialog(this, "Tên sản phẩm! Không chứ ký tự đặc biệt");
			return false;
		}
		if (!(moTa.length() > 0 && moTa.length() < 50
				&& moTa.matches("[\\W\\w\\s]+"))) {
			JOptionPane.showMessageDialog(this, "Mô tả! Không chứ ký tự đặc biệt");
			return false;
		}
		if (!(chatLieu.length() > 0 && chatLieu.length() < 50
				&& chatLieu.matches("[\\W\\w\\s]+"))) {
			JOptionPane.showMessageDialog(this, "Chất liệu! Không chứ ký tự đặc biệt");
			return false;
		}
		if (!(mauSac.length() > 0 && mauSac.length() < 50
				&& mauSac.matches("[\\W\\w\\s]+"))) {
			JOptionPane.showMessageDialog(this, "Màu sắc! Không chứ ký tự đặc biệt");
			return false;
		}
		if (!(soLuong.length() > 0 && soLuong.length() < 50
				&& soLuong.matches("[\\d]+"))) {
			JOptionPane.showMessageDialog(this, "Số lượng! Chỉ nhập số");
			return false;
		}
		if (!(giamGia.length() > 0 && giamGia.length() < 50
				&& giamGia.matches("[\\d.]+"))) {
			JOptionPane.showMessageDialog(this, "Giảm giá! Chỉ nhập số");
			return false;
		}
		if (!(donGia.length() > 0 && donGia.length() < 50
				&& donGia.matches("[\\d.]+"))) {
			JOptionPane.showMessageDialog(this, "Đơn giá bán! Chỉ nhập số");
			return false;
		}
		if (lblHinhAnh.equals("") || lblHinhAnh == null) {
			JOptionPane.showMessageDialog(this, "Chọn hình!");
			return false;
		}
		if (chckbxNam.isSelected() == false && chckbxNu.isSelected() == false) {
			JOptionPane.showMessageDialog(this, "Chọn giới tính!");
			return false;
		}
		return true;
	}
}

