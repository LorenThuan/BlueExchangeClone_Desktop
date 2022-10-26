package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import dao.ConectDatabase;
import dao.TaiKhoanDao;
import dto.NhanVien;
import dto.TaiKhoan;

public class TaiKhoanImpl implements TaiKhoanDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	private NhanVienService nhanVienService = new NhanVienServiceImpl();
	@Override
	public boolean themTaiKhoan(TaiKhoan taiKhoan) {
		con = ConectDatabase.getInstance().getConnection();
		boolean n = false;
		try {
			preStm = con.prepareStatement("insert into Tai_Khoan values\r\n" + "(?,?)");
			preStm.setString(1, taiKhoan.getNhanVien().getMaNhanVien());
			preStm.setString(2, taiKhoan.getMatKhau());
			n = preStm.executeUpdate() > 0;
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return n;
	}
	@Override
	public TaiKhoan layThongTinTaKhoanTheoMaTaiKhoan(String maNhanVien) {
		TaiKhoan taiKhoan = null;
		NhanVien nhanVien = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Select * from Tai_Khoan where maNhanVien = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhanVien);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String matKhau = rs.getString(2);
				taiKhoan = new TaiKhoan(matKhau);
				nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
				taiKhoan.setNhanVien(nhanVien);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taiKhoan;
	}

}
