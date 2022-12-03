package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConectDatabase;
import dao.LoaiSanPhamDao;
import dto.LoaiSanPham;

public class LoaiSanPhamIml implements LoaiSanPhamDao {

	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	@Override
	public ArrayList<LoaiSanPham> getTatCaLoaiSanPham() {
		// TODO Auto-generated method stub
		ArrayList<LoaiSanPham> danhSachLoaiSanPham = new ArrayList<LoaiSanPham>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
						+ "FROM Loai_San_Pham \r\n"
						+ "ORDER BY tenLoai";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maLoaiSanPham = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoai);
				danhSachLoaiSanPham.add(loaiSanPham);			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachLoaiSanPham;
	}
	@Override
	public boolean themLoaiSanPham(LoaiSanPham loaiSanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "INSERT Loai_San_Pham\r\n"
						+ "VALUES (?, ?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, loaiSanPham.getMaLoaiSanPham());
			preStm.setString(2, loaiSanPham.getTenLoai());		
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}
	@Override
	public boolean xoaLoaiSanPham(String maLoaiSanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "DELETE FROM Loai_San_Pham \r\n"
						+ "WHERE maLoaiSanPham = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maLoaiSanPham);	
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}
	@Override
	public boolean capNhatLoaiSanPham(LoaiSanPham loaiSanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "UPDATE dbo.Loai_San_Pham \r\n"
						+ "SET tenLoai = ? \r\n"
						+ "WHERE maLoaiSanPham = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(2, loaiSanPham.getMaLoaiSanPham());	
			preStm.setString(1, loaiSanPham.getTenLoai());
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}
	@Override
	public ArrayList<LoaiSanPham> timKiemLoaiSanPham(String tuKhoa) {
		// TODO Auto-generated method stub
		ArrayList<LoaiSanPham> danhSachLoaiSanPham = new ArrayList<LoaiSanPham>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
						+ "FROM Loai_San_Pham\r\n"
						+ "WHERE maLoaiSanPham LIKE ? \r\n"
						+ "OR tenLoai LIKE ?"
						+ "ORDER BY tenLoai";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%"+tuKhoa+"%");
			preStm.setString(2, "%"+tuKhoa+"%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maLoaiSanPham = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoai);
				danhSachLoaiSanPham.add(loaiSanPham);			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachLoaiSanPham;
	}
	
}
