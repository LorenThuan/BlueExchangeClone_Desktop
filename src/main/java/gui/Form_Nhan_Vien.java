package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;


import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import dao.ConectDatabase;
import dto.KhachHang;
import dto.NhanVien;
import dto.NhanVien;
import handle.RoundJTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Form_Nhan_Vien extends JFrame implements ActionListener, MouseListener{

	public static JPanel contentPane;
	public static JTextField textMaNhanVien;
	private static JTextField textTenNhanVien;
	private static JTextField textEmail;
	private static JTable tableNhanVien;
	private static DefaultTableModel dataModelNhanVien;
	private JScrollPane scrollNhanVien;
	private static JTextField textTimKiem;
	private static NhanVienService nhanVienService = new NhanVienServiceImpl();
	private static JRadioButton rdbtnNam;
	private static JRadioButton rdbtnNu;
	private JButton btnXoaRong;
	public static JButton btnThem;
	private ButtonGroup btnGroupGioiTinh;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnHoanTac;
	private static JComboBox<String> comboBoxTrangThai;
	private static JDateChooser dateChonNgaySinh;
	private static JComboBox<String> comboBoxChucVu;

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
		
		JPanel panelThongTinNhanVien = new JPanel();
		panelThongTinNhanVien.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinNhanVien.setBounds(39, 82, 1249, 130);
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
		lblGioiTinh.setBounds(427, 35, 83, 14);
		panelThongTinNhanVien.add(lblGioiTinh);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(520, 31, 60, 23);
		panelThongTinNhanVien.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(594, 31, 47, 23);
		panelThongTinNhanVien.add(rdbtnNu);
		
		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);
		
		rdbtnNam.setSelected(true);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(769, 35, 83, 14);
		panelThongTinNhanVien.add(lblNgaySinh);
		
		dateChonNgaySinh = new JDateChooser();
		dateChonNgaySinh.setDateFormatString("yyyy-MM-dd");
		dateChonNgaySinh.setBounds(871, 18, 123, 36);
		panelThongTinNhanVien.add(dateChonNgaySinh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(427, 91, 83, 14);
		panelThongTinNhanVien.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(520, 88, 197, 20);
		panelThongTinNhanVien.add(textEmail);
		
		JLabel lbTrangThai = new JLabel("Trạng Thái:");
		lbTrangThai.setBounds(769, 91, 83, 14);
		panelThongTinNhanVien.add(lbTrangThai);
		
		comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setEnabled(false);
		comboBoxTrangThai.addItem("Đang làm việc");
		comboBoxTrangThai.addItem("Thôi việc");
		comboBoxTrangThai.setBounds(871, 83, 123, 30);
		panelThongTinNhanVien.add(comboBoxTrangThai);
		
		comboBoxChucVu = new JComboBox<String>();
		comboBoxChucVu.addItem("NVBH");
		comboBoxChucVu.addItem("NVQL");
		comboBoxChucVu.setEnabled(false);
		comboBoxChucVu.setBounds(1105, 83, 123, 30);
		panelThongTinNhanVien.add(comboBoxChucVu);
		
		JLabel lbChucVu = new JLabel("Chức vụ:");
		lbChucVu.setBounds(1018, 91, 83, 14);
		panelThongTinNhanVien.add(lbChucVu);
		
		JPanel panel = new JPanel();
		panel.setBounds(126, 230, 1098, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(29, 11, 89, 23);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(153, 11, 89, 23);
		panel.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(284, 11, 89, 23);
		panel.add(btnSua);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(418, 11, 89, 23);
		panel.add(btnXoaRong);
		
		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBounds(545, 11, 89, 23);
		panel.add(btnHoanTac);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(999, 11, 89, 23);
		panel.add(btnTimKiem);
		
		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBounds(805, 12, 184, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JPanel panelDanhSachNhanVien = new JPanel();
		panelDanhSachNhanVien.setBounds(10, 309, 1330, 385);
		panelDanhSachNhanVien.setBorder(new TitledBorder(null, "Danh sách nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDanhSachNhanVien);
		panelDanhSachNhanVien.setLayout(null);
		
		String[] tieuDe = new String[]  { "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Email" ,"Ngày Sinh", "Trạng Thái", "Chức Vụ", "Chọn"};
		dataModelNhanVien = new DefaultTableModel(tieuDe, 0) {
			 public Class<?> getColumnClass(int column)
	            {
	              switch(column)
	              {
	              case 0:
	                return String.class;
	              case 1:
	                return String.class;
	              case 2:
	                return String.class;
	              case 3:
	                return String.class;
	              case 4:
	                return String.class;
	              case 5:
		                return String.class;
	              case 6:
		                return String.class;
	              case 7:
		                return Boolean.class;
	                default:
	                  return String.class;
	              }
	            }

	            @Override
	            public boolean isCellEditable(int row, int column) {
	               /* Set the 11th column as editable and rest non-
	                    editable */
	                if(column==7){
	                    return true;
	                }else{
	//all other columns to false
	               return false;
	                }
	            }
		};
		scrollNhanVien = new JScrollPane();
		scrollNhanVien.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setBounds(10, 20, 1309, 355);
		panelDanhSachNhanVien.add(scrollNhanVien);
		tableNhanVien = new JTable(dataModelNhanVien);
		tableNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollNhanVien.setViewportView(tableNhanVien);	
		
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnHoanTac.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		
		docDuLieu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = tableNhanVien.getSelectedRow();
		String maNhanVien = dataModelNhanVien.getValueAt(row, 0).toString();
		try {
			NhanVien nv = nhanVienService.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
			textMaNhanVien.setText(maNhanVien + "");
			textTenNhanVien.setText(nv.getTenNhanVien());
			if (nv.isGioiTinh() == true) {
				rdbtnNam.setSelected(true);
			} else {
				rdbtnNu.setSelected(true);
			}
			textEmail.setText(nv.getEmail());
			
			dateChonNgaySinh.setDate(nv.getNgaySinh());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			Date ngaySinhsql = null;
			try {
				java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
				ngaySinhsql = new Date(ngaySinh.getTime());
				dateChonNgaySinh.setDate(ngaySinhsql);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			comboBoxTrangThai.setEnabled(true);
			comboBoxTrangThai.getModel().setSelectedItem(nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc");
			
			comboBoxChucVu.setEnabled(true);
			comboBoxChucVu.getModel().setSelectedItem(nv.getChucVu());
			
			textMaNhanVien.setEditable(false);

		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			comboBoxTrangThai.setEnabled(false);
			Boolean kq = themMoiNhanVien();
			docDuLieu();
			new Form_Cap_Mat_Khau().setVisible(true);
		} else if (o.equals(btnXoa)) {
			comboBoxTrangThai.setEnabled(false);
			 Boolean kq = xoaNhanVien();
			 docDuLieu();
			 xoaRong();
			
		} else if (o.equals(btnTimKiem)) {
			comboBoxTrangThai.setEnabled(false);
			String noidungTim = textTimKiem.getText().trim();
			if (noidungTim.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("./HinhAnh/IconChucNang/warning.png"));
			} else {
				timKiemNhanVien(noidungTim);
			}	
		} else if (o.equals(btnSua)) {
			Boolean kq = capNhatNhanVien();
			xoaRong();
			
		} else if (o.equals(btnHoanTac)) {
			comboBoxTrangThai.setEnabled(false);
			docDuLieu();
		}
		
	}
	
	public static void docDuLieu() {
		List<NhanVien> dsNV = nhanVienService.getTatCaNhanVien();
		dataModelNhanVien.setRowCount(0);
		for(NhanVien nv : dsNV) {
			dataModelNhanVien.addRow(new Object[] {
					nv.getMaNhanVien(), nv.getTenNhanVien().trim(), nv.isGioiTinh() == true ? "Nam" : "Nữ", nv.getEmail().trim(), nv.getNgaySinh(),
							nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc", nv.getChucVu()
			});
		}
	}
	
	public static void xoaRong() {
		textMaNhanVien.setText("");
		textTenNhanVien.setText("");
		textEmail.setText("");
		rdbtnNam.setSelected(true);
		comboBoxTrangThai.setEnabled(false);
		textTimKiem.setText("");
		dateChonNgaySinh.setDate(null);
		textMaNhanVien.setEditable(true);
	}
	
	public static boolean themMoiNhanVien() {
		NhanVien nhanVien = null;
		String maNhanVien = textMaNhanVien.getText().trim();
		String tenNhanVien = textTenNhanVien.getText().trim();
		String email = textEmail.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}
		
		Date ngaySinhsql = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		boolean trangThai = false;
		if (comboBoxTrangThai.getSelectedItem().equals("Đang làm việc")) {
			trangThai = true;
		}
		String chucVu = comboBoxChucVu.getSelectedItem().toString();
		
		nhanVien = new NhanVien(maNhanVien, email, ngaySinhsql, tenNhanVien, gioiTinh, chucVu, trangThai);
		boolean kq = nhanVienService.themNhanVien(nhanVien);
		return kq;
	}
	
	public void timKiemNhanVien(String noidungTim) {
		List<NhanVien> NhanViens = nhanVienService.timKiemNhanVien(noidungTim);
		dataModelNhanVien.getDataVector().removeAllElements();
			for (NhanVien nv : NhanViens) {
				dataModelNhanVien.addRow(new Object[] {
						nv.getMaNhanVien(), nv.getTenNhanVien().trim(), nv.isGioiTinh() == true ? "Nam" : "Nữ", nv.getEmail().trim(), nv.getNgaySinh(),
								nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc", nv.getChucVu()				
			});
		}
			
		tableNhanVien.setModel(dataModelNhanVien);
	}

	
	public boolean capNhatNhanVien() {
		boolean kq = false;
		int row = tableNhanVien.getSelectedRow();
		NhanVien nhanVien;
		String maNhanVien = textMaNhanVien.getText().trim();
		String tenNhanVien = textTenNhanVien.getText().trim();
		String email = textEmail.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}
		
		Date ngaySinhsql = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		boolean trangThai = false;
		if (comboBoxTrangThai.getSelectedItem().equals("Đang làm việc")) {
			trangThai = true;
		}
		String chucVu = comboBoxChucVu.getSelectedItem().toString();
		
		nhanVien = new NhanVien(maNhanVien, email, ngaySinhsql, tenNhanVien, gioiTinh, chucVu, trangThai);
		kq = nhanVienService.capNhatThongTinNhanVien(nhanVien);
		
			if (kq) {
				tableNhanVien.setValueAt(textMaNhanVien.getText(), row, 0);
				tableNhanVien.setValueAt(textTenNhanVien.getText(), row, 1);
				tableNhanVien.setValueAt(textEmail.getText(), row, 3);
				Xoadata();
				docDuLieu();
				tableNhanVien.clearSelection();
			}

		return kq;
	}
	
	public boolean xoaNhanVien() {
		Boolean kq = false;
		String maNhanVien = "";
		DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
	    for (int i=0;i<model.getRowCount();i++) {
	    	maNhanVien = (String) model.getValueAt(i, 0);
	          Boolean checked=(Boolean)model.getValueAt(i,7);
	          
	          if (checked!=null && checked) {
	        	   kq = nhanVienService.xoaNhanVien(maNhanVien);
	               model.removeRow(i);
	               i--;
	          }
	    }
	    	
	    
		return kq;
	}
	
	public static void Xoadata() {
		dataModelNhanVien = (DefaultTableModel) tableNhanVien.getModel();
		dataModelNhanVien.getDataVector().removeAllElements();
	}
}
