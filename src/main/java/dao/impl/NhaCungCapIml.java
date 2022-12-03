package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConectDatabase;
import dao.NhaCungCapDao;
import dto.NhaCungCap;

public class NhaCungCapIml implements NhaCungCapDao{

	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	@Override
	public ArrayList<NhaCungCap> getTatCaNhaCungCap() {
		// TODO Auto-generated method stub
		ArrayList<NhaCungCap> danhSachNhacungCap = new ArrayList<NhaCungCap>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
						+ "FROM Nha_Cung_Cap\r\n"
						+ "ORDER BY tenNhaCungCap";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString(1);
				String tenNhaCungCap = rs.getString(2);
				Date ngayHopTac = rs.getDate(3);
				String diaChi = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap, tenNhaCungCap, ngayHopTac, diaChi, soDienThoai, email);
				danhSachNhacungCap.add(nhaCungCap);			
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhacungCap;
	}

	@Override
	public boolean themNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "INSERT dbo.Nha_Cung_Cap\r\n"
						+ "VALUES (?, ?, ?, ?, ?, ?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, nhaCungCap.getMaNhaCungCap());
			preStm.setString(2, nhaCungCap.getTenNhaCungCap());		
			preStm.setDate(3, nhaCungCap.getNgayHopTac());
			preStm.setString(4, nhaCungCap.getDiaChi());	
			preStm.setString(5, nhaCungCap.getSoDienThoai());
			preStm.setString(6, nhaCungCap.getEmail());	
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
	public boolean xoaNhaCungCap(String maNhaCungCap) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "DELETE FROM dbo.Nha_Cung_Cap\r\n"
						+ "WHERE maNhaCungCap = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhaCungCap);	
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
	public boolean capNhatNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "UPDATE dbo.Nha_Cung_Cap\r\n"
						+ "SET \r\n"
						+ "tenNhaCungCap = ?,\r\n"
						+ "ngayHopTac = ?,\r\n"
						+ "diaChi = ?,\r\n"
						+ "soDienThoai = ?,\r\n"
						+ "email = ?\r\n"
						+ "WHERE maNhaCungCap = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, nhaCungCap.getTenNhaCungCap());	
			preStm.setDate(2, nhaCungCap.getNgayHopTac());
			preStm.setString(3, nhaCungCap.getDiaChi());	
			preStm.setString(4, nhaCungCap.getSoDienThoai());
			preStm.setString(5, nhaCungCap.getEmail());	
			preStm.setString(6, nhaCungCap.getMaNhaCungCap());
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
	public ArrayList<NhaCungCap> timKiemNhaCungCap(String tuKhoa) {
		// TODO Auto-generated method stub
		ArrayList<NhaCungCap> danhSachNhacungCap = new ArrayList<NhaCungCap>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
						+ "FROM Nha_Cung_Cap\r\n"
						+ "WHERE maNhaCungCap LIKE ? OR tenNhaCungCap LIKE ?\r\n"
						+ "ORDER BY tenNhaCungCap";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%"+tuKhoa+"%");
			preStm.setString(2, "%"+tuKhoa+"%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString(1);
				String tenNhaCungCap = rs.getString(2);
				Date ngayHopTac = rs.getDate(3);
				String diaChi = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap, tenNhaCungCap, ngayHopTac, diaChi, soDienThoai, email);
				danhSachNhacungCap.add(nhaCungCap);			
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhacungCap;
	}
}
