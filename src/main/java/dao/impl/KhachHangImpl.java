package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ConectDatabase;
import dao.KhachHangDao;
import dto.KhachHang;


public class KhachHangImpl implements KhachHangDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	
	public List<KhachHang> getTatCaKhachHang() {
		List<KhachHang> danhSachKhachHang = new ArrayList<KhachHang>();
		KhachHang khachHang = null; 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Khach_Hang";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			danhSachKhachHang = new ArrayList<KhachHang>();	
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String soDienThoai = rs.getString(3);
				Boolean gioiTinh = rs.getBoolean(4);
				khachHang = new KhachHang(maKH, tenKhachHang, soDienThoai, gioiTinh);
				danhSachKhachHang.add(khachHang);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachKhachHang;
	}
	
	public boolean themKhachHang(KhachHang khachHang) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "insert into Khach_Hang values(?,?,?,?)";
			
			preStm = con.prepareStatement(sql);
			
			preStm.setString(1, khachHang.getMaKhachHang());
			preStm.setString(2, khachHang.getTenKhachHang());
			preStm.setString(3, khachHang.getSoDienThoai());
			preStm.setBoolean(4, khachHang.isGioiTinh());
			
			n = preStm.executeUpdate() > 0;
			
		} catch (Exception e) {
		}
		return n;
	}

	@Override
	public boolean capNhatThongTinKhachHang(KhachHang khachHang) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Update Khach_Hang set tenKhachHang = ?, soDienThoai = ?, gioiTinh = ? where maKhachHang = ?";
			
			preStm = con.prepareStatement(sql);
			preStm.setString(1, khachHang.getTenKhachHang());
			preStm.setString(2, khachHang.getSoDienThoai());
			preStm.setBoolean(3, khachHang.isGioiTinh());
			preStm.setString(4, khachHang.getMaKhachHang()); 
			
			n = preStm.executeUpdate() > 0;
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return n;
	}

	@Override
	public boolean xoaKhachHang(String maKhachHang) {
		boolean check = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "delete Khach_Hang where maKhachHang = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maKhachHang);
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return check;
	}

	@Override
	public List<KhachHang> timKiemKhachHang(String noiDungTim) {
		List<KhachHang> khachHangs = null;
		KhachHang khachHang;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Khach_Hang where maKhachHang like ? or tenKhachHang like ? or soDienThoai like ?";
			preStm = con.prepareStatement(sql);
			
			preStm.setString(1, "%" + noiDungTim + "%");
			preStm.setString(2, "%" + noiDungTim + "%");
			preStm.setString(3, "%" + noiDungTim + "%");
			rs = preStm.executeQuery();
			
			khachHangs = new ArrayList<KhachHang>();
			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDienThoai = rs.getString("soDienThoai");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				khachHang = new KhachHang(maKH, tenKH, soDienThoai, gioiTinh);
				khachHangs.add(khachHang);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return khachHangs;
	}

	@Override
	public KhachHang layThongTinKhachHangTheoMaKhachHang(String maKhachHang) {
		KhachHang khachHang = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Select * from Khach_Hang where maKhachHang = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maKhachHang);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String tenKH = rs.getString("tenKhachHang");
				String soDienThoai = rs.getString("soDienThoai");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				khachHang = new KhachHang(maKhachHang, tenKH, soDienThoai, gioiTinh);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khachHang;
	}

}
