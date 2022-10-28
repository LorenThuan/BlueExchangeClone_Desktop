package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConectDatabase;
import dao.SanPhamDao;
import dto.KhachHang;
import dto.LoaiSanPham;
import dto.SanPham;

public class SanPhamImpl implements SanPhamDao{
	
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	
	@Override
	public ArrayList<SanPham> getTatCaSanPham() {
		
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();	
		// TODO Auto-generated method stub
		try {
			con = ConectDatabase.getInstance().getConnection();
			
			String sql="SELECT maSanPham, tenSanPham, Loai_San_Pham.maLoaiSanPham, Loai_San_Pham.tenLoai,donGia, trangThai\r\n"
					+ "FROM San_Pham JOIN dbo.Loai_San_Pham \r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String maLoaiSanPham = rs.getString(3);
				String tenLoaiSanPham = rs.getString(4);
				Double donGia = rs.getDouble(5);
				String trangThai = rs.getString(6);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
				SanPham sp = new SanPham(maSanPham, tenSanPham, donGia, trangThai);
				sp.setLoaiSanPham(loaiSanPham);
				danhSachSanPham.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return false;
	}

}
