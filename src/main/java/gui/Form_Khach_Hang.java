package gui;


import java.awt.EventQueue;
import java.awt.Font;
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

import bus.KhachHangService;
import bus.KhachHangServiceImpl;
import dao.ConectDatabase;
import dto.KhachHang;
import handle.RoundJTextField;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;

public class Form_Khach_Hang extends JFrame implements ActionListener, MouseListener{

	public static JPanel contentPane;
	private JTextField textMaKhachHang;
	private JTextField textTenKhachHang;
	private JTextField textSoDienThoai;
	private JTable tableKhachHang;
	private DefaultTableModel dataModelKhachHang;
	private JScrollPane scrollKhachHang;
	private JTextField textTimKiem;
	private KhachHangService khachHangService = new KhachHangServiceImpl();
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JButton btnXoaRong;
	private JButton btnThem;
	private ButtonGroup btnGroupGioiTinh;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnHoanTac;
	private JLabel lblTBTenKhachHang;
	private JLabel lblTBSoDienThoai;
	private JLabel lblTBMaKhachHang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Khach_Hang frame = new Form_Khach_Hang();
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
	public Form_Khach_Hang() {
		//DAO
		try {
			ConectDatabase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinKhachHang = new JPanel();
		panelThongTinKhachHang.setBackground(new Color(240, 255, 255));
		panelThongTinKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinKhachHang.setBounds(306, 87, 784, 130);
		contentPane.add(panelThongTinKhachHang);
		panelThongTinKhachHang.setLayout(null);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setBounds(24, 35, 126, 14);
		panelThongTinKhachHang.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setBounds(24, 79, 126, 14);
		panelThongTinKhachHang.add(lblTenKhachHang);
		
		
		textMaKhachHang = new JTextField();
		textMaKhachHang.setBackground(Color.WHITE);
		textMaKhachHang.setText("Tự động khi để trống");
		textMaKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaKhachHang.getText().equals("Tự động khi để trống")) {
					textMaKhachHang.setText("");
					textMaKhachHang.setForeground(new Color(0, 0, 0));
				}
			}
		});		
		textMaKhachHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaKhachHang.getText().equals("Tự động khi để trống")) {
					//textMaSanPham.setText("Tự động khi để trống");
					textMaKhachHang.setForeground(new Color(153, 153, 153));
					lblTBMaKhachHang.setText("");
				} else if (!textMaKhachHang.getText().matches("KH[\\d]{1,14}")) {
					lblTBMaKhachHang.setText("* Không hợp lệ! KH***********!");
					if (textMaKhachHang.getText().equals("Tự động khi để trống")) {
						lblTBMaKhachHang.setText("");
					} 
				}
				else {					
					lblTBMaKhachHang.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textMaKhachHang.getText().equals("")) {
					textMaKhachHang.setText("Tự động khi để trống");
					textMaKhachHang.setForeground(new Color(153, 153, 153));
				}	
				if (!textMaKhachHang.getText().matches("KH[\\d]{1,14}")) {
					lblTBMaKhachHang.setText("* Không hợp lệ! KH***********!");
					if (textMaKhachHang.getText().equals("Tự động khi để trống")) {
						lblTBMaKhachHang.setText("");
					} 
				}
				else {					
					lblTBMaKhachHang.setText("");
				}
			}
		});
		
		
		textMaKhachHang.setBounds(177, 32, 197, 20);
		panelThongTinKhachHang.add(textMaKhachHang);
		textMaKhachHang.setColumns(10);
		
		textTenKhachHang = new JTextField();
		textTenKhachHang.setBackground(Color.WHITE);
		textTenKhachHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenKhachHang.getText().length() == 0) {
					lblTBTenKhachHang.setText("* Không để trống!");
				} else if (textTenKhachHang.getText().length() > 50) {
					lblTBTenKhachHang.setText("* Quá dài!");
				}
				else {					
					lblTBTenKhachHang.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textTenKhachHang.getText().length() == 0) {
					lblTBTenKhachHang.setText("* Không để trống!");
				} else if (textTenKhachHang.getText().length() > 50) {
					lblTBTenKhachHang.setText("* Quá dài!");
				}
				else {					
					lblTBTenKhachHang.setText("");
				}
			}
		});
		textTenKhachHang.setColumns(10);
		textTenKhachHang.setBounds(177, 77, 197, 20);
		panelThongTinKhachHang.add(textTenKhachHang);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(466, 35, 83, 14);
		panelThongTinKhachHang.add(lblGioiTinh);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(240, 255, 255));
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinKhachHang.add(rdbtnNam);
		rdbtnNam.setSelected(true);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(240, 255, 255));
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinKhachHang.add(rdbtnNu);
		
		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setBounds(466, 79, 83, 14);
		panelThongTinKhachHang.add(lblSoDienThoai);
		
		textSoDienThoai = new JTextField();
		textSoDienThoai.setBackground(Color.WHITE);
		textSoDienThoai.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textSoDienThoai.getText().length() == 0) {
					lblTBSoDienThoai.setText("* Không để trống!");
				} else if (!textSoDienThoai.getText().matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
					lblTBSoDienThoai.setText("* Không hợp lệ!");
				}
				else {					
					lblTBSoDienThoai.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textSoDienThoai.getText().length() == 0) {
					lblTBSoDienThoai.setText("* Không để trống!");
				} else if (!textSoDienThoai.getText().matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
					lblTBSoDienThoai.setText("* Không hợp lệ!");
				}
				else {					
					lblTBSoDienThoai.setText("");
				}
			}
		});
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(555, 77, 197, 20);
		panelThongTinKhachHang.add(textSoDienThoai);
		
		lblTBMaKhachHang = new JLabel("");
		lblTBMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaKhachHang.setForeground(Color.RED);
		lblTBMaKhachHang.setBounds(177, 54, 197, 20);
		panelThongTinKhachHang.add(lblTBMaKhachHang);
		
		lblTBTenKhachHang = new JLabel("");
		lblTBTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenKhachHang.setForeground(Color.RED);
		lblTBTenKhachHang.setBounds(177, 100, 197, 20);
		panelThongTinKhachHang.add(lblTBTenKhachHang);
		
		lblTBSoDienThoai = new JLabel("");
		lblTBSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBSoDienThoai.setForeground(Color.RED);
		lblTBSoDienThoai.setBounds(555, 100, 197, 20);
		panelThongTinKhachHang.add(lblTBSoDienThoai);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(157, 235, 1037, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(58, 11, 89, 23);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.setBounds(186, 11, 89, 23);
		panel.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(321, 11, 89, 23);
		panel.add(btnSua);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setBounds(451, 11, 89, 23);
		panel.add(btnXoaRong);
		
		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.setBounds(579, 11, 89, 23);
		panel.add(btnHoanTac);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255, 240, 245));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(880, 11, 89, 23);
		panel.add(btnTimKiem);
		
		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(716, 12, 154, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JPanel panelDanhSachKhachHang = new JPanel();
		panelDanhSachKhachHang.setBackground(new Color(240, 255, 255));
		panelDanhSachKhachHang.setBounds(10, 309, 1330, 385);
		panelDanhSachKhachHang.setBorder(new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDanhSachKhachHang);
		panelDanhSachKhachHang.setLayout(null);
		
		String[] tieuDe = new String[]  { "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoại" ,"Chọn"};
		dataModelKhachHang = new DefaultTableModel(tieuDe, 0) {
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
                return Boolean.class;
                default:
                  return String.class;
              }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
               /* Set the 11th column as editable and rest non-
                    editable */
                if(column==4){
                    return true;
                }else{
//all other columns to false
               return false;
                }
            }
		};
		scrollKhachHang = new JScrollPane();
		scrollKhachHang.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollKhachHang.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollKhachHang.setBounds(10, 20, 1309, 355);
		panelDanhSachKhachHang.add(scrollKhachHang);
		tableKhachHang = new JTable(dataModelKhachHang);
		tableKhachHang.setBackground(new Color(240, 255, 255));
		tableKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollKhachHang.setViewportView(tableKhachHang);	
		
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnHoanTac.addActionListener(this);
		tableKhachHang.addMouseListener(this);
		
		docDuLieu();
		
	}	
	public void docDuLieu() {
		List<KhachHang> dsKH = khachHangService.getTatCaKhachHang();
		dataModelKhachHang.setRowCount(0);
		for(KhachHang kh : dsKH) {
			dataModelKhachHang.addRow(new Object[] {
					kh.getMaKhachHang(), kh.getTenKhachHang().trim(), kh.isGioiTinh() == true ? "Nam" : "Nữ", kh.getSoDienThoai().trim()
			});
		}
	}
	
	private void xoaRong() {
		textMaKhachHang.setText("Tự động khi để trống");
		textTenKhachHang.setText("");
		textSoDienThoai.setText("");
		rdbtnNam.setSelected(true);
		textTimKiem.setText("");
		lblTBMaKhachHang.setText("");
		lblTBSoDienThoai.setText("");
		lblTBTenKhachHang.setText("");
		textMaKhachHang.setEditable(true);
	}
	
	public boolean themMoiKhachHang() {
		KhachHang khachHang = null;
		String maKhachHang = textMaKhachHang.getText().trim();
		if (maKhachHang.equals("Tự động khi để trống")) {
			maKhachHang = taoMaTuDong();
		}
		String tenKhachHang = textTenKhachHang.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}
		khachHang = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, gioiTinh);
		boolean kq = khachHangService.themKhachHang(khachHang);    
		return kq;
	}
	
	public void timKiemKhachHang(String noidungTim) {
		List<KhachHang> khachHangs = khachHangService.timKiemKhachHang(noidungTim);
		dataModelKhachHang.getDataVector().removeAllElements();
			for (KhachHang kh : khachHangs) {
				dataModelKhachHang.addRow(new Object[] {
						kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() == true ? "Nam" : "Nữ", kh.getSoDienThoai()				
			});
		}
			
		tableKhachHang.setModel(dataModelKhachHang);
	}

	
	public boolean capNhatKhachHang() {
		boolean kq = false;
		int row = tableKhachHang.getSelectedRow();
		KhachHang kh;
		String maKhachHang = textMaKhachHang.getText().trim();
		String tenKhachHang = textTenKhachHang.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}
		
		
		kh = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, gioiTinh);
		kq = khachHangService.capNhatThongTinKhachHang(kh);
		
			if (kq) {
				tableKhachHang.setValueAt(textMaKhachHang.getText(), row, 0);
				tableKhachHang.setValueAt(textTenKhachHang.getText(), row, 1);
				tableKhachHang.setValueAt(textSoDienThoai.getText(), row, 3);
				Xoadata();
				docDuLieu();
				tableKhachHang.clearSelection();
			}

		return kq;
	}
	
	public boolean xoaKhachHang() {
		Boolean kq = false;
		String maKH = "";
		DefaultTableModel model = (DefaultTableModel) tableKhachHang.getModel();
	    for (int i=0;i<model.getRowCount();i++) {
	    	  maKH = (String) model.getValueAt(i, 0);
	          Boolean checked=(Boolean)model.getValueAt(i,4);
	          
	          if (checked!=null && checked) {
	        	   kq = khachHangService.xoaKhachHang(maKH);
	               model.removeRow(i);
	               i--;
	          }
	    }
	    	
	    
		return kq;
	}
	
	private void Xoadata() {
		dataModelKhachHang.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			if (kiemTraDuLieu()) {
				Boolean kq = themMoiKhachHang();
				docDuLieu();
				xoaRong();
			}			
		} else if (o.equals(btnXoa)) {
			if (tableKhachHang.getSelectedRow() != -1) {
				int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
				if (ask == JOptionPane.YES_OPTION) {
					 Boolean kq = xoaKhachHang();
					 docDuLieu();
					 xoaRong();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn khách hàng");
			}
		} else if (o.equals(btnTimKiem)) {
			String noidungTim = textTimKiem.getText().trim();
			if (noidungTim.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("./HinhAnh/IconChucNang/warning.png"));
			} else {
				timKiemKhachHang(noidungTim);
			}	
		} else if (o.equals(btnSua)) {
			if (kiemTraDuLieu()) {
				Boolean kq = capNhatKhachHang();
				xoaRong();
			}			
			
		} else if (o.equals(btnHoanTac)) {
			docDuLieu();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
//		int row = tableKhachHang.getSelectedRow();
//		textMaKhachHang.setText(dataModelKhachHang.getValueAt(row, 0).toString());
//		textTenKhachHang.setText(dataModelKhachHang.getValueAt(row, 1).toString());
//		textSoDienThoai.setText(dataModelKhachHang.getValueAt(row, 3).toString());
//		textMaKhachHang.setEditable(false);
		
		int row = tableKhachHang.getSelectedRow();
		String maKH = dataModelKhachHang.getValueAt(row, 0).toString();
		try {
			KhachHang kh = khachHangService.layThongTinKhachHangTheoMaKhachHang(maKH);
			textMaKhachHang.setText(maKH + "");
			textTenKhachHang.setText(kh.getTenKhachHang());
			textSoDienThoai.setText(kh.getSoDienThoai());
			if (kh.isGioiTinh() == true) {
				rdbtnNam.setSelected(true);
			} else {
				rdbtnNu.setSelected(true);
			}
			textMaKhachHang.setEditable(false);

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
	
	private boolean kiemTraDuLieu () {
		String maKhachHang = textMaKhachHang.getText().trim();
		String tenKhachHang = textTenKhachHang.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		
		lblTBMaKhachHang.setText("");
		lblTBTenKhachHang.setText("");
		lblTBSoDienThoai.setText("");
		

		if (!maKhachHang.equals("Tự động khi để trống")) {
			if (maKhachHang.length() == 0) {
				lblTBMaKhachHang.setText("* Không để trống!");
				return false;
			} else if (!(maKhachHang.matches("KH[\\d]{1,14}") && maKhachHang.length() < 20)) {
				lblTBMaKhachHang.setText("* Không hợp lệ! KH***********");
				return false;
			}
		}
		
		if (tenKhachHang.length() == 0) {
			lblTBTenKhachHang.setText("* Không để trống!");
			return false;
		} else if (!(tenKhachHang.matches("[\\W\\w\\s]+") && tenKhachHang.length() < 50)) {
			lblTBTenKhachHang.setText("* Không hợp lệ!");
			return false;
		}
		
		if (soDienThoai.length() == 0) {
			lblTBSoDienThoai.setText("* Không để trống!");
			return false;
		} else if (!soDienThoai.matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
			lblTBSoDienThoai.setText("* Không hợp lệ!");
			return false;
		}
		
		return true;
	}
	
	private String taoMaTuDong () {        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ngayNhap = LocalDateTime.now();
        String res = "KH" + formatter.format(ngayNhap);
        return res;
	}
}
