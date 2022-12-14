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
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelThongTinKhachHang = new JPanel();
		panelThongTinKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinKhachHang.setBounds(306, 87, 784, 130);
		contentPane.add(panelThongTinKhachHang);
		panelThongTinKhachHang.setLayout(null);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setBounds(24, 35, 126, 14);
		panelThongTinKhachHang.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setBounds(24, 91, 126, 14);
		panelThongTinKhachHang.add(lblTenKhachHang);
		
		
		textMaKhachHang = new JTextField();
		textMaKhachHang.setBounds(177, 32, 197, 20);
		panelThongTinKhachHang.add(textMaKhachHang);
		textMaKhachHang.setColumns(10);
		
		textTenKhachHang = new JTextField();
		textTenKhachHang.setColumns(10);
		textTenKhachHang.setBounds(177, 88, 197, 20);
		panelThongTinKhachHang.add(textTenKhachHang);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(466, 35, 83, 14);
		panelThongTinKhachHang.add(lblGioiTinh);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinKhachHang.add(rdbtnNam);
		rdbtnNam.setSelected(true);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinKhachHang.add(rdbtnNu);
		
		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setBounds(466, 91, 83, 14);
		panelThongTinKhachHang.add(lblSoDienThoai);
		
		textSoDienThoai = new JTextField();
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(555, 88, 197, 20);
		panelThongTinKhachHang.add(textSoDienThoai);
		
		JPanel panel = new JPanel();
		panel.setBounds(157, 235, 1037, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(58, 11, 89, 23);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(186, 11, 89, 23);
		panel.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(321, 11, 89, 23);
		panel.add(btnSua);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(451, 11, 89, 23);
		panel.add(btnXoaRong);
		
		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBounds(579, 11, 89, 23);
		panel.add(btnHoanTac);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(880, 11, 89, 23);
		panel.add(btnTimKiem);
		
		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBounds(716, 12, 154, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JPanel panelDanhSachKhachHang = new JPanel();
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
		textMaKhachHang.setText("");
		textTenKhachHang.setText("");
		textSoDienThoai.setText("");
		rdbtnNam.setSelected(true);
		textTimKiem.setText("");
		textMaKhachHang.setEditable(true);
	}
	
	public boolean themMoiKhachHang() {
		KhachHang khachHang = null;
		String maKhachHang = textMaKhachHang.getText().trim();
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
			Boolean kq = themMoiKhachHang();
			docDuLieu();
			xoaRong();
		} else if (o.equals(btnXoa)) {
			if (tableKhachHang.getSelectedRow() != -1) {
				int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
				if (ask == JOptionPane.YES_OPTION) {
					 Boolean kq = xoaKhachHang();
					 docDuLieu();
					 xoaRong();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn nhân viên!");
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
			Boolean kq = capNhatKhachHang();
			xoaRong();
			
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
			textMaKhachHang.setEditable(true);

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
}
