package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooserBeanInfo;

import dao.ConectDatabase;
import dao.KhachHangDao;
import dao.impl.KhachHangImpl;
import dto.KhachHang;
import handle.RoundJTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Form_Khach_Hang extends JFrame {

	public static JPanel contentPane;
	private JTextField textMaKhachHang;
	private JTextField textTenKhachHang;
	private JTextField textSoDienThoai;
	private JTable tableKhachHang;
	private DefaultTableModel dataModelKhachHang;
	private JScrollPane scrollKhachHang;
	private JTextField textTimKiem;
	public KhachHangDao khachHangDao = new KhachHangImpl();

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
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinKhachHang.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinKhachHang.add(rdbtnNu);
		
		ButtonGroup btnGroupGioiTinh = new ButtonGroup();
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
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(58, 11, 89, 23);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(186, 11, 89, 23);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(321, 11, 89, 23);
		panel.add(btnSua);
		
		JButton btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(451, 11, 89, 23);
		panel.add(btnXoaRong);
		
		JButton btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBounds(579, 11, 89, 23);
		panel.add(btnHoanTac);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
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
		dataModelKhachHang = new DefaultTableModel(tieuDe, 0);
		scrollKhachHang = new JScrollPane();
		scrollKhachHang.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollKhachHang.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollKhachHang.setBounds(10, 20, 1309, 355);
		panelDanhSachKhachHang.add(scrollKhachHang);
		tableKhachHang = new JTable(dataModelKhachHang);
		tableKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollKhachHang.setViewportView(tableKhachHang);	
		
		docDuLieu();
		
	}
	
	public void docDuLieu() {
		ArrayList<KhachHang> dsKH = khachHangDao.getAllKhachHang();
		dataModelKhachHang.setRowCount(0);
		for(KhachHang kh : dsKH) {
			System.out.println(kh);
			dataModelKhachHang.addRow(new Object[] {
					kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(), kh.isGioiTinh()
			});
		}
	}
}
