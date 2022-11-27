package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConectDatabase;
import dao.SanPhamDao;
import dto.LoaiSanPham;
import dto.NhaCungCap;
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
			
			String sql="SELECT * FROM dbo.San_Pham\r\n"
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {				
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				Double donGia = rs.getDouble(4);
				String hinhAnh = rs.getString(5);
				int soLuong = rs.getInt(6);
				String kichThuoc = rs.getString(8);
				String mauSac = rs.getString(10);
				SanPham sanPham = new SanPham();
				sanPham.setMaSanPham(maSanPham);
				sanPham.setTenSanPham(tenSanPham);
				sanPham.setDonGia(donGia);
				sanPham.setHinhAnh(hinhAnh);
				sanPham.setSoLuong(soLuong);
				sanPham.setKichThuoc(kichThuoc);
				sanPham.setMauSac(mauSac);
				danhSachSanPham.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "INSERT dbo.San_Pham\r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, sanPham.getMaSanPham());
			preStm.setString(2, sanPham.getTenSanPham());
			preStm.setString(3, sanPham.getMota());
			preStm.setDouble(4, sanPham.getDonGia());
			preStm.setString(5, sanPham.getHinhAnh());
			preStm.setInt(6, sanPham.getSoLuong());
			preStm.setDouble(7, sanPham.getGiamGia());
			preStm.setString(8, sanPham.getKichThuoc());
			preStm.setString(9, sanPham.getChatLieu());
			preStm.setString(10, sanPham.getMauSac());
			preStm.setString(11, sanPham.getGioiTinh());
			preStm.setString(12, sanPham.getTrangThai());
			preStm.setString(13, sanPham.getLoaiSanPham().getMaLoaiSanPham());
			preStm.setString(14, sanPham.getNhaCungCap().getMaNhaCungCap());	
			preStm.setDouble(15, sanPham.getGiaNhap());
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
	public boolean xoaSanPham(String maSanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "DELETE FROM dbo.San_Pham \r\n"
						+ "WHERE maSanPham = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maSanPham);	
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
	public boolean capNhatSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "UPDATE dbo.San_Pham\r\n"
					+ "		SET \r\n"
					+ "			tenSanPham = ?,\r\n"
					+ "			moTa = ?,\r\n"
					+ "			chatLieu = ?,\r\n"
					+ "			mauSac = ?,\r\n"
					+ "			soLuong = ?,\r\n"
					+ "			giamGia = ?,\r\n"
					+ "			donGia = ?,\r\n"
					+ "			gioiTinh = ?,\r\n"
					+ "			kichThuoc = ?,\r\n"
					+ "			trangThai = ?,\r\n"
					+ "			maLoaiSanPham = ?,\r\n"
					+ "			maNhaCungCap = ?,\r\n"
					+ "			hinhAnh = ?\r\n"
					+ "		WHERE maSanPham = ?";
			preStm = con.prepareStatement(sql);	
			preStm.setString(1, sanPham.getTenSanPham());
			preStm.setString(2, sanPham.getMota());
			preStm.setString(3, sanPham.getChatLieu());
			preStm.setString(4, sanPham.getMauSac());
			preStm.setInt(5, sanPham.getSoLuong());
			preStm.setDouble(6, sanPham.getGiamGia());
			preStm.setDouble(7, sanPham.getDonGia());
			preStm.setString(8, sanPham.getGioiTinh());
			preStm.setString(9, sanPham.getKichThuoc());
			preStm.setString(10, sanPham.getTrangThai());
			preStm.setString(11, sanPham.getLoaiSanPham().getMaLoaiSanPham());
			preStm.setString(12, sanPham.getNhaCungCap().getMaNhaCungCap());
			preStm.setString(13, sanPham.getHinhAnh());
			preStm.setString(14, sanPham.getMaSanPham());
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
	public ArrayList<SanPham> timKiemSanPham(String tuKhoa) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT * FROM dbo.San_Pham\r\n"
					+ "WHERE maSanPham LIKE ? OR tenSanPham LIKE ?\r\n"
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%"+tuKhoa+"%");
			preStm.setString(2, "%"+tuKhoa+"%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				Double donGia = rs.getDouble(4);
				String hinhAnh = rs.getString(5);
				int soLuong = rs.getInt(6);
				String kichThuoc = rs.getString(8);
				String mauSac = rs.getString(10);
				SanPham sanPham = new SanPham();
				sanPham.setMaSanPham(maSanPham);
				sanPham.setTenSanPham(tenSanPham);
				sanPham.setDonGia(donGia);
				sanPham.setHinhAnh(hinhAnh);
				sanPham.setSoLuong(soLuong);
				sanPham.setKichThuoc(kichThuoc);
				sanPham.setMauSac(mauSac);
				danhSachSanPham.add(sanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	@Override
	public ArrayList<SanPham> timKiemSanPhamTheoLoai(String tenLoai) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		try {
			con = ConectDatabase.getInstance().getConnection();
			
			String sql="SELECT * FROM dbo.San_Pham\r\n"
					+ "JOIN dbo.Loai_San_Pham \r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham\r\n"
					+ "WHERE tenLoai = ?\r\n"
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, tenLoai);	
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				Double donGia = rs.getDouble(4);
				String hinhAnh = rs.getString(5);
				int soLuong = rs.getInt(6);
				String kichThuoc = rs.getString(8);
				String mauSac = rs.getString(10);
				SanPham sanPham = new SanPham();
				sanPham.setMaSanPham(maSanPham);
				sanPham.setTenSanPham(tenSanPham);
				sanPham.setDonGia(donGia);
				sanPham.setHinhAnh(hinhAnh);
				sanPham.setSoLuong(soLuong);
				sanPham.setKichThuoc(kichThuoc);
				sanPham.setMauSac(mauSac);
				danhSachSanPham.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	@Override
	public SanPham timSanPhamTheoMa(String ma) {
		// TODO Auto-generated method stub
		SanPham sanPham = new SanPham();
		// TODO Auto-generated method stub
		try {
			con = ConectDatabase.getInstance().getConnection();
			
			String sql="SELECT * FROM dbo.San_Pham \r\n"
					+ "JOIN dbo.Loai_San_Pham \r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham\r\n"
					+ "JOIN dbo.Nha_Cung_Cap \r\n"
					+ "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n"
					+ "WHERE maSanPham = ?\r\n"
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, ma);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String moTa = rs.getString(3);
				Double donGia = rs.getDouble(4);
				String hinhAnh = rs.getString(5);
				int soLuong = rs.getInt(6);
				Double giamGia = rs.getDouble(7);
				String kichThuoc = rs.getString(8);
				String chatLieu = rs.getString(9);
				String mauSac = rs.getString(10);
				String gioiTinh = rs.getString(11);
				String trangThai = rs.getString(12);				
				String maLoaiSanPham = rs.getString(16);
				String tenLoai = rs.getString(17);
				String maNhaCungCap = rs.getString(18);
				String tenNhaCungCap = rs.getString(19);
				Double giaNhap = rs.getDouble(15);
				LoaiSanPham loaiSanPham = new LoaiSanPham();
				loaiSanPham.setMaLoaiSanPham(maLoaiSanPham);
				loaiSanPham.setTenLoai(tenLoai);
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setMaNhaCungCap(maNhaCungCap);
				nhaCungCap.setTenNhaCungCap(tenNhaCungCap);
				sanPham.setMaSanPham(maSanPham);
				sanPham.setTenSanPham(tenSanPham);
				sanPham.setLoaiSanPham(loaiSanPham);
				sanPham.setNhaCungCap(nhaCungCap);
				sanPham.setDonGia(donGia);
				sanPham.setTrangThai(trangThai);
				sanPham.setSoLuong(soLuong);
				sanPham.setMota(moTa);
				sanPham.setMauSac(mauSac);
				sanPham.setKichThuoc(kichThuoc);
				sanPham.setGioiTinh(gioiTinh);
				sanPham.setHinhAnh(hinhAnh);
				sanPham.setChatLieu(chatLieu);
				sanPham.setGiamGia(giamGia);
				sanPham.setGiaNhap(giaNhap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPham;
	}

}
