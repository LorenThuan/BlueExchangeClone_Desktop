package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ConectDatabase;
import dao.TaiKhoanDao;
import dto.TaiKhoan;

public class TaiKhoanImpl implements TaiKhoanDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
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

}
