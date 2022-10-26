package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ConectDatabase;
import dao.NhanVienDao;
import dto.NhanVien;
import dto.TaiKhoan;


public class NhanVienImpl implements NhanVienDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	
	public List<NhanVien> getTatCaNhanVien() {
		List<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
		NhanVien nhanVien = null; 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Nhan_Vien";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			danhSachNhanVien = new ArrayList<NhanVien>();	
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				nhanVien = new NhanVien(maNV, email, ngaySinh, tenNhanVien, gioiTinh, chucVu, trangThai);
				danhSachNhanVien.add(nhanVien);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}
	
	public boolean themNhanVien(NhanVien nhanVien) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "insert into Nhan_Vien values(?,?,?,?,?,?,?)";
			
			preStm = con.prepareStatement(sql);
			
			preStm.setString(1, nhanVien.getMaNhanVien());
			preStm.setString(2, nhanVien.getTenNhanVien());
			preStm.setBoolean(3, nhanVien.isGioiTinh());
			preStm.setDate(4, nhanVien.getNgaySinh());
			preStm.setString(5, nhanVien.getEmail());
			preStm.setString(6, nhanVien.getChucVu());
			preStm.setBoolean(7, nhanVien.isTrangThai());
			
			n = preStm.executeUpdate() > 0;
			
		} catch (Exception e) {
		}
		return n;
	}

	@Override
	public boolean capNhatThongTinNhanVien(NhanVien nhanVien) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Update Nhan_Vien set tenNhanVien = ?, gioiTinh = ?, ngaySinh = ?, email = ?, chucVu = ?, trangThai = ? where maNhanVien = ?";
			
			preStm = con.prepareStatement(sql);
			preStm.setString(1, nhanVien.getTenNhanVien());
			preStm.setBoolean(2, nhanVien.isGioiTinh());
			preStm.setDate(3, nhanVien.getNgaySinh());
			preStm.setString(4, nhanVien.getEmail());
			preStm.setString(5, nhanVien.getChucVu());
			preStm.setBoolean(6, nhanVien.isTrangThai());
			preStm.setString(7, nhanVien.getMaNhanVien()); 
			
			n = preStm.executeUpdate() > 0;
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return n;
	}

	@Override
	public boolean xoaNhanVien(String maNhanVien) {
		boolean check = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "delete Nhan_Vien where maNhanVien = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhanVien);
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return check;
	}

	@Override
	public List<NhanVien> timKiemNhanVien(String noiDungTim) {
		List<NhanVien> nhanViens = null;
		NhanVien nhanVien;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Nhan_Vien where maNhanVien like ? or tenNhanVien like ? or email like ?";
			preStm = con.prepareStatement(sql);
			
			preStm.setString(1, "%" + noiDungTim + "%");
			preStm.setString(2, "%" + noiDungTim + "%");
			preStm.setString(3, "%" + noiDungTim + "%");
			rs = preStm.executeQuery();
			
			nhanViens = new ArrayList<NhanVien>();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				nhanVien = new NhanVien(maNV, email, ngaySinh, tenNhanVien, gioiTinh, chucVu, trangThai);
				nhanViens.add(nhanVien);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return nhanViens;
	}

	@Override
	public NhanVien layThongTinNhanVienTheoMaNhanVien(String maNhanVien) {
		NhanVien nhanVien = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Select * from Nhan_Vien where maNhanVien = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhanVien);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String tenNhanVien = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				nhanVien = new NhanVien(maNhanVien, email, ngaySinh, tenNhanVien, gioiTinh, chucVu, trangThai);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

//	@Override
//	public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
//		try {
//			NhanVien nhanVien = null;
//			TaiKhoan taiKhoan = null;
//			con = ConectDatabase.getInstance().getConnection();
//			String sql = "SELECT  tk.[maNhanVien], [matKhau], [chucVu]      \r\n"
//					+ "FROM            Nhan_Vien nv INNER JOIN\r\n"
//					+ "                         Tai_Khoan tk ON nv.maNhanVien = tk.maNhanVien\r\n"
//					+ "						 where tk.[maNhanVien] = ? and [matKhau] = ?\r\n"
//					+ "group by tk.[maNhanVien], [matKhau], [chucVu]\r\n"
//					+ "";
//			preStm = con.prepareStatement(sql);
//			preStm.setString(1, tenDangNhap);
//			preStm.setString(2, matKhau);
//			rs = preStm.executeQuery();
//			while (rs.next()) {
//				String tenTaiKhoan = rs.getString(1).trim();
//				String matKhauNV = rs.getString(2).trim();
//				String chucVu = rs.getString(3).trim();
//				nhanVien = layThongTinNhanVienTheoMaNhanVien(tenDangNhap);
//				taiKhoan.setNhanVien(nhanVien);
//				taiKhoan = new TaiKhoan(matKhauNV);
//				nhanVien.setChucVu(chucVu);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}
