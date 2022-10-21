package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import dao.ConectDatabase;
import dao.KhachHangDao;
import dto.KhachHang;


public class KhachHangImpl implements KhachHangDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		KhachHang khachHang = null; 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Khach_Hang";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			result = new ArrayList<KhachHang>();	
			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
//				String tenKhachHang = rs.getString("tenKhachHang")
//				String soDienThoai = rs.getString("soDienThoai");
//				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				khachHang = new KhachHang(maKH);
				result.add(khachHang);
			}
			
			for ( KhachHang kh : result ) {
				System.out.println(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
