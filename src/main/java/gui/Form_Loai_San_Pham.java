package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import bus.LoaiSanPhamService;
import bus.LoaiSanPhamServiceImpl;
import dao.ConectDatabase;
import dto.LoaiSanPham;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Form_Loai_San_Pham extends JFrame {

	private JPanel contentPane;
	private JTextField textMaLoaiSanPham;
	private JTextField textTenLoaiSanPham;
	private JTable tableDanhSachLoaiSanPham;
	private JPanel panelNhaCungCap;
	private JTextField textTimKiem;
	private DefaultTableModel modelLoaiSanPham;

	private LoaiSanPhamService loaiSanPhamService = new LoaiSanPhamServiceImpl();
	private JLabel lblTBMaLoai;
	private JLabel lblTBTenLoai;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Loai_San_Pham frame = new Form_Loai_San_Pham();
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
	public Form_Loai_San_Pham() {		
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, 971, 654);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelNhaCungCap = new JPanel();
		panelNhaCungCap.setBackground(new Color(240, 255, 255));
		panelNhaCungCap.setBorder(new TitledBorder(null, "Loại sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNhaCungCap.setBounds(31, 159, 355, 152);
		contentPane.add(panelNhaCungCap);
		panelNhaCungCap.setLayout(null);
		
		JLabel lblMaLoaiSanPham = new JLabel("Mã Loại sản phẩm:");
		lblMaLoaiSanPham.setBounds(10, 39, 142, 13);
		panelNhaCungCap.add(lblMaLoaiSanPham);
		
		textMaLoaiSanPham = new JTextField();
		textMaLoaiSanPham.setBackground(Color.WHITE);
		textMaLoaiSanPham.setBounds(151, 36, 149, 19);
		textMaLoaiSanPham.setText("Tự động khi để trống");
		textMaLoaiSanPham.setForeground(new Color(153, 153, 153));
		panelNhaCungCap.add(textMaLoaiSanPham);
		textMaLoaiSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaLoaiSanPham.getText().equals("Tự động khi để trống")) {
					textMaLoaiSanPham.setText("");
					textMaLoaiSanPham.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaLoaiSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaLoaiSanPham.getText().equals("Tự động khi để trống")) {
					textMaLoaiSanPham.setText("Tự động khi để trống");
					textMaLoaiSanPham.setForeground(new Color(153, 153, 153));
				} else if (!textMaLoaiSanPham.getText().matches("LSP[\\d]{1,14}")) {
					lblTBMaLoai.setText("* Không hợp lệ! LSP***********!");
					if (textMaLoaiSanPham.getText().equals("Tự động khi để trống")) {
						lblTBMaLoai.setText("");
					} 
				}
				else {					
					lblTBMaLoai.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textMaLoaiSanPham.getText().equals("")) {
					textMaLoaiSanPham.setText("Tự động khi để trống");
					textMaLoaiSanPham.setForeground(new Color(153, 153, 153));
				} else if (!textMaLoaiSanPham.getText().matches("LSP[\\d]{1,14}")) {
					lblTBMaLoai.setText("* Không hợp lệ! LSP***********!");
					if (textMaLoaiSanPham.getText().equals("Tự động khi để trống")) {
						lblTBMaLoai.setText("");
					} 
				}
				else {					
					lblTBMaLoai.setText("");
				}
			}
		});
		textMaLoaiSanPham.setColumns(10);
		
		JLabel lblTenLoaiSanPham = new JLabel("Tên Loại sản phẩm:");
		lblTenLoaiSanPham.setBounds(10, 80, 118, 13);
		panelNhaCungCap.add(lblTenLoaiSanPham);
		
		textTenLoaiSanPham = new JTextField();
		textTenLoaiSanPham.setBackground(Color.WHITE);
		textTenLoaiSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenLoaiSanPham.getText().length() == 0) {
					lblTBTenLoai.setText("* Không để trống!");
				} else if (textTenLoaiSanPham.getText().length() > 50) {
					lblTBTenLoai.setText("* Quá dài!");
				}
				else {					
					lblTBTenLoai.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textTenLoaiSanPham.getText().length() == 0) {
					lblTBTenLoai.setText("* Không để trống!");
				} else if (textTenLoaiSanPham.getText().length() > 50) {
					lblTBTenLoai.setText("* Quá dài!");
				}
				else {					
					lblTBTenLoai.setText("");
				}
			}
		});
		textTenLoaiSanPham.setBounds(151, 77, 149, 19);
		panelNhaCungCap.add(textTenLoaiSanPham);
		textTenLoaiSanPham.setColumns(10);
		
		lblTBMaLoai = new JLabel("");
		lblTBMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaLoai.setForeground(Color.RED);
		lblTBMaLoai.setBounds(151, 54, 149, 19);
		panelNhaCungCap.add(lblTBMaLoai);
		
		lblTBTenLoai = new JLabel("");
		lblTBTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenLoai.setForeground(Color.RED);
		lblTBTenLoai.setBounds(151, 95, 142, 19);
		panelNhaCungCap.add(lblTBTenLoai);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBackground(new Color(240, 255, 255));
		panelChucNang.setBounds(31, 390, 355, 138);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(10, 10, 100, 30);
		panelChucNang.add(btnThem);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				themLoaiSanPham();
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaLoaiSanPham();
			}
		});
		btnXoa.setBounds(120, 10, 100, 30);
		panelChucNang.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(230, 10, 100, 30);
		panelChucNang.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suaLoaiSanPam();
			}
		});
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnXoaRong.setBounds(120, 64, 100, 30);
		panelChucNang.add(btnXoaRong);
		
		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableDanhSachLoaiSanPham.getSelectedRow();
				hoanTac(row);
			}
		});
		btnHoanTac.setBounds(230, 64, 100, 30);
		panelChucNang.add(btnHoanTac);
		
		JPanel panelDanhSach = new JPanel();
		panelDanhSach.setBackground(new Color(240, 255, 255));
		panelDanhSach.setBorder(new TitledBorder(null, "Danh sách Loại sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSach.setBounds(419, 64, 488, 512);
		contentPane.add(panelDanhSach);
		panelDanhSach.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelDanhSach.add(scrollPane);
		
		String[] colHeader = {"STT", "Mã Loại sản phẩm", "Tên Loại"};
		modelLoaiSanPham = new DefaultTableModel(colHeader, 0);
		tableDanhSachLoaiSanPham = new JTable(modelLoaiSanPham);
		tableDanhSachLoaiSanPham.setBackground(new Color(240, 255, 255));
		tableDanhSachLoaiSanPham.addMouseListener(new MouseListener() {
			
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
				int row = tableDanhSachLoaiSanPham.getSelectedRow();
				textMaLoaiSanPham.setText(modelLoaiSanPham.getValueAt(row, 1).toString());
				textTenLoaiSanPham.setText(modelLoaiSanPham.getValueAt(row, 2).toString());
				textMaLoaiSanPham.setEditable(false);
			}
		});
		scrollPane.setViewportView(tableDanhSachLoaiSanPham);
		
		scrollPane.setViewportView(tableDanhSachLoaiSanPham);
		
		textTimKiem = new JTextField();
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(595, 33, 179, 19);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255, 240, 245));
		btnTimKiem.setBounds(803, 32, 104, 21);
		contentPane.add(btnTimKiem);	
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timKiemLoaiSanPham();
			}
		});
		docDuLieu();
	}
	
	private void docDuLieu() {
		ArrayList<LoaiSanPham> danhSachLoaiSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
		modelLoaiSanPham.setRowCount(0);
		int sST = 0;
		for(LoaiSanPham lSP : danhSachLoaiSanPham) {
			sST++;
			modelLoaiSanPham.addRow(new Object[] {
					sST, lSP.getMaLoaiSanPham(), lSP.getTenLoai()
			});
		}
	}
	
	private void themLoaiSanPham () {
		String maLoaiSanPham = textMaLoaiSanPham.getText().trim();
		String tenLoaiSanPham =  textTenLoaiSanPham.getText().trim();
		if (kiemTraDuLieu()) {
			if (maLoaiSanPham.equals("") || maLoaiSanPham.equals("Tự động khi để trống")) {
				maLoaiSanPham = taoMaTuDong();
			}
			LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
			if (!loaiSanPhamService.getTatCaLoaiSanPham().contains(loaiSanPham)) {
				loaiSanPhamService.themLoaiSanPham(loaiSanPham); 
				docDuLieu();
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Mã Loại san phẩm đã tồn tại!");
			}
			
		}
	}
	
	private void xoaLoaiSanPham () {
		int row = tableDanhSachLoaiSanPham.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maLoaiSanPham = tableDanhSachLoaiSanPham.getValueAt(row, 1).toString();
				loaiSanPhamService.xoaLoaiSanPham(maLoaiSanPham);	
				xoaRong();
				docDuLieu();
				if (row < loaiSanPhamService.getTatCaLoaiSanPham().size() - 1) {
					selectedRow(row);
				} else if (loaiSanPhamService.getTatCaLoaiSanPham().size() > 0) {
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
		int row = tableDanhSachLoaiSanPham.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Cập nhật!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maLoaiSanPham = textMaLoaiSanPham.getText();
				String tenLoaiSanPham = textTenLoaiSanPham.getText();
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
				if (kiemTraDuLieu()) {
					loaiSanPhamService.capNhatLoaiSanPham(loaiSanPham);
					xoaRong();
					docDuLieu();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}
	private void timKiemLoaiSanPham () {
		String tuKhoa = textTimKiem.getText().trim();
		if (tuKhoa.equals("")) {
			docDuLieu();
		} else {
			ArrayList<LoaiSanPham> danhSachLoaiSanPham = loaiSanPhamService.timKiemLoaiSanPham(tuKhoa);;
			modelLoaiSanPham.setRowCount(0);
			int sST = 0;
			for(LoaiSanPham lSP : danhSachLoaiSanPham) {
				sST++;
				modelLoaiSanPham.addRow(new Object[] {
						sST, lSP.getMaLoaiSanPham(), lSP.getTenLoai()
				});
			}
		}
	}
	private void xoaRong () {
		textMaLoaiSanPham.setText("Tự động khi để trống");
		textMaLoaiSanPham.setForeground(new Color(153, 153, 153));
		textMaLoaiSanPham.setEditable(true);
		textTenLoaiSanPham.setText("");
		textMaLoaiSanPham.requestFocus();
		lblTBMaLoai.setText("");
		lblTBTenLoai.setText("");
	}
	
	private void selectedRow(int row) {
		if (row != -1) {
			tableDanhSachLoaiSanPham.setRowSelectionInterval(row, row);
			tableDanhSachLoaiSanPham.scrollRectToVisible(tableDanhSachLoaiSanPham.getCellRect(row, row, true));
		}
	}
	private void hoanTac(int row) {
		if (row != -1) {
			tableDanhSachLoaiSanPham.setRowSelectionInterval(row, row);
			tableDanhSachLoaiSanPham.scrollRectToVisible(tableDanhSachLoaiSanPham.getCellRect(row, row, true));
			textMaLoaiSanPham.setText(modelLoaiSanPham.getValueAt(row, 1).toString());
			textTenLoaiSanPham.setText(modelLoaiSanPham.getValueAt(row, 2).toString());
		}
	}
	private String taoMaTuDong () {        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ngayNhap = LocalDateTime.now();
        String res = "LSP" + formatter.format(ngayNhap);
        return res;
	}
	
	private boolean kiemTraDuLieu () {
		String maLoaiSanPham = textMaLoaiSanPham.getText().trim();
		String tenLoaiSanPham = textTenLoaiSanPham.getText().trim();
		
		lblTBMaLoai.setText("");
		lblTBTenLoai.setText("");
		
		if (!maLoaiSanPham.equals("Tự động khi để trống")) {
			if (!(maLoaiSanPham.length() > 0 && maLoaiSanPham.length() < 50
					&& maLoaiSanPham.matches("LSP[\\d]{1,14}"))) {
				lblTBMaLoai.setText("* Không hợp lệ! LSP**************");
				return false;
			}
		}
		
		if (!(tenLoaiSanPham.length() > 0 && tenLoaiSanPham.length() < 50
				&& tenLoaiSanPham.matches("[\\W\\w\\s]+"))) {
			lblTBTenLoai.setText("* Không hợp lệ!");
			return false;
		}
		return true;
	}
}
