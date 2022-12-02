package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConectDatabase;
import dao.HoaDonDao;
import dto.ChiTietHoaDon;
import dto.HoaDon;
import dto.KhachHang;
import dto.LoaiSanPham;
import dto.NhaCungCap;
import dto.NhanVien;
import dto.SanPham;

public class HoaDonImpl implements HoaDonDao {
	static Connection con;
	static PreparedStatement preStm;
	static ResultSet rs;

	public List<SanPham> getSanPhamTim(String noidung) {
		// TODO Auto-generated method stub
		List<SanPham> danhSachSanPham = new ArrayList<SanPham>(); 
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT maSanPham, tenSanPham, Loai_San_Pham.maLoaiSanPham+ ' ' + tenLoai AS 'loaiSanPham', donGia,\r\n"
					+ "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
					+ "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
					+ "FROM dbo.San_Pham \r\n"
					+ "JOIN dbo.Loai_San_Pham\r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham\r\n"
					+ "JOIN dbo.Nha_Cung_Cap\r\n"
					+ "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n"
					+ "WHERE maSanPham LIKE ? OR tenSanPham LIKE ?\r\n"
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%"+noidung+"%");
			preStm.setString(2, "%"+noidung+"%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String maLoaiSanPham = rs.getString(3);
				Double donGia = rs.getDouble(4);
				String trangThai = rs.getString(5);
				int soLuong = rs.getInt(6);
				String moTa = rs.getString(7);
				String mauSac = rs.getString(8);
				String kichThuoc = rs.getString(9);
				String gioiTinh = rs.getString(10);
				String hinhAnh = rs.getString(11);
				String chatLieu = rs.getString(12);
				String maNhaCungCap = rs.getString(13);
				Double giamGia = rs.getDouble(14);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap);
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, moTa, donGia, hinhAnh, soLuong, giamGia, mauSac, gioiTinh, kichThuoc, trangThai, chatLieu, loaiSanPham, nhaCungCap);
				danhSachSanPham.add(sanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	public List<SanPham> getTatCaSanPham() {

		List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		// TODO Auto-generated method stub
		try {
			con = ConectDatabase.getInstance().getConnection();

			String sql = "SELECT maSanPham, tenSanPham, Loai_San_Pham.maLoaiSanPham + ' ' + tenLoai AS 'loaiSanPham', donGia,\r\n"
					+ "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
					+ "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
					+ "FROM dbo.San_Pham \r\n" + "JOIN dbo.Loai_San_Pham\r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham\r\n" + "JOIN dbo.Nha_Cung_Cap\r\n"
					+ "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n" + "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String maLoaiSanPham = rs.getString(3);
				Double donGia = rs.getDouble(4);
				String trangThai = rs.getString(5);
				int soLuong = rs.getInt(6);
				String moTa = rs.getString(7);
				String mauSac = rs.getString(8);
				String kichThuoc = rs.getString(9);
				String gioiTinh = rs.getString(10);
				String hinhAnh = rs.getString(11);
				String chatLieu = rs.getString(12);
				String maNhaCungCap = rs.getString(13);
				Double giamGia = rs.getDouble(14);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap);
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, moTa, donGia, hinhAnh, soLuong, giamGia, mauSac,
						gioiTinh, kichThuoc, trangThai, chatLieu, loaiSanPham, nhaCungCap);
				danhSachSanPham.add(sanPham);
			}
			return danhSachSanPham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SanPham laySanPhamTheoMa(String ma) {
		// TODO Auto-generated method stub
		SanPham sanPham = null;
		// TODO Auto-generated method stub
		try {
			con = ConectDatabase.getInstance().getConnection();
			
			String sql="SELECT maSanPham, tenSanPham, Loai_San_Pham.maLoaiSanPham + ' ' + tenLoai AS 'loaiSanPham', donGia,\r\n"
					+ "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
					+ "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
					+ "FROM dbo.San_Pham \r\n"
					+ "JOIN dbo.Loai_San_Pham\r\n"
					+ "ON Loai_San_Pham.maLoaiSanPham = San_Pham.maLoaiSanPham\r\n"
					+ "JOIN dbo.Nha_Cung_Cap\r\n"
					+ "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n"
					+ "WHERE maSanPham =?\r\n "
					+ "ORDER BY tenSanPham";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, ma);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String maLoaiSanPham = rs.getString(3);
				Double donGia = rs.getDouble(4);
				String trangThai = rs.getString(5);
				int soLuong = rs.getInt(6);
				String moTa = rs.getString(7);
				String mauSac = rs.getString(8);
				String kichThuoc = rs.getString(9);
				String gioiTinh = rs.getString(10);
				String hinhAnh = rs.getString(11);
				String chatLieu = rs.getString(12);
				String maNhaCungCap = rs.getString(13);
				Double giamGia = rs.getDouble(14);
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSanPham);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap);
				sanPham = new SanPham(maSanPham, tenSanPham, moTa, donGia, hinhAnh, soLuong, giamGia, mauSac, gioiTinh, kichThuoc, trangThai, chatLieu, loaiSanPham, nhaCungCap);
			}
			
			return sanPham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ChiTietHoaDon> getCT_HoadonTheoHoaDon(String mahoadon) {
		List<ChiTietHoaDon> dSCT_HoaDon = new ArrayList<ChiTietHoaDon>();
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Chi_Tiet_Hoa_Don where maHoaDon = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, mahoadon);
			rs = preStm.executeQuery();
			while (rs.next()) {
				ChiTietHoaDon ct = new ChiTietHoaDon();
				String maSP = rs.getString(2);
				int soLuong = rs.getInt(3);

				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(mahoadon);
				SanPham sp = new SanPham();
				sp.setMaSanPham(maSP);
				ct.setHoaDon(hd);
				ct.setSanPham(sp);
				ct.setSoLuong(soLuong);
				dSCT_HoaDon.add(ct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dSCT_HoaDon;
	}

	public ChiTietHoaDon get_TungCT_HoaDon(String mahoadon, String maSP) {
		ChiTietHoaDon ct = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Chi_Tiet_Hoa_Don where maHoaDon = ? and maSanPham = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, mahoadon);
			preStm.setString(2, maSP);
			rs = preStm.executeQuery();
			ct = new ChiTietHoaDon();
			while (rs.next()) {
				int soLuong = rs.getInt(3);
				HoaDon hd = getHoaDon(mahoadon);
				SanPham sp = laySanPhamTheoMa(maSP);
				ct.setHoaDon(hd);
				ct.setSanPham(sp);
				ct.setSoLuong(soLuong);
			}
			return ct;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ChiTietHoaDon> getAllDSCT_Hoadon() {
		List<ChiTietHoaDon> dSCT_HoaDon = new ArrayList<ChiTietHoaDon>();
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Chi_Tiet_Hoa_Don";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				ChiTietHoaDon ct = new ChiTietHoaDon();
				String maHD = rs.getString(1);
				String maSP = rs.getString(2);
				int soLuong = rs.getInt(3);

				HoaDon hd = new HoaDon(maHD);
				SanPham sp = new SanPham();
				sp.setMaSanPham(maSP);
				ct.setHoaDon(hd);
				ct.setSanPham(sp);
				ct.setSoLuong(soLuong);
				dSCT_HoaDon.add(ct);
			}
			return dSCT_HoaDon;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public HoaDon getHoaDon(String mahoadon) {
		HoaDon hd = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Hoa_Don where maHoaDon = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, mahoadon);
			rs = preStm.executeQuery();
			hd = new HoaDon();
			while (rs.next()) {
				String maHD = rs.getString(1);
				Date ngayDat = rs.getDate(2);
				Boolean trangThai = rs.getBoolean(3);
				String maNV = rs.getString(4);
				String maKH = rs.getString(5);

				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);

				hd.setMaHoaDon(maHD);
				hd.setNgayDat(ngayDat);
				hd.setTrangThai(trangThai);
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
			}
			return hd;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HoaDon> getAllDSHoadon(String maNhanVien) {
		List<HoaDon> dSHoaDon = new ArrayList<HoaDon>();
		
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Hoa_Don where maNhanVien = '"+ maNhanVien +"'";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
				String maHD = rs.getString(1);
				Date ngayDat = rs.getDate(2);
				Boolean trangThai = rs.getBoolean(3);
				String maNV = rs.getString(4);
				String maKH = rs.getString(5);

				NhanVien nv = new NhanVien(maNV);
				KhachHang kh = new KhachHang(maKH);

				hd.setMaHoaDon(maHD);
				hd.setNgayDat(ngayDat);
				hd.setTrangThai(trangThai);
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);

				dSHoaDon.add(hd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dSHoaDon;
	}

	public boolean themHoaDon(HoaDon hoadon) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "insert into Hoa_Don values(?,?,?,?,?,?)";

			preStm = con.prepareStatement(sql);

			preStm.setString(1, hoadon.getMaHoaDon());
			preStm.setDate(2, hoadon.getNgayDat());
			preStm.setBoolean(3, hoadon.isTrangThai());
			preStm.setString(4, hoadon.getNhanVien().getMaNhanVien());
			preStm.setString(5, hoadon.getKhachHang().getMaKhachHang());
			preStm.setDouble(6, hoadon.getGiamGia());
			n = preStm.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public boolean themCT_HoaDon(HoaDon hd, SanPham sp, int soLuong) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "insert into Chi_Tiet_Hoa_Don values(?,?,?)";

			preStm = con.prepareStatement(sql);

			preStm.setString(1, hd.getMaHoaDon());
			preStm.setString(2, sp.getMaSanPham());
			preStm.setInt(3, soLuong);

			n = preStm.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public KhachHang timKiemKhachHangtheoSDT(String noiDungTim) {
		KhachHang khachHang = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Khach_Hang where soDienThoai like ?";
			preStm = con.prepareStatement(sql);

			preStm.setString(1, "%" + noiDungTim + "%");
			rs = preStm.executeQuery();
			khachHang = new KhachHang();

			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDienThoai = rs.getString("soDienThoai");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				khachHang = new KhachHang(maKH, tenKH, soDienThoai, gioiTinh);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return khachHang;
	}

	public KhachHang timKiemKhachHangtheoMa(String maKH) {
		KhachHang khachHang = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "select * from Khach_Hang where maKhachHang = ?";
			preStm = con.prepareStatement(sql);

			preStm.setString(1, maKH);
			rs = preStm.executeQuery();
			khachHang = new KhachHang();

			while (rs.next()) {
				String tenKH = rs.getString("tenKhachHang");
				String soDienThoai = rs.getString("soDienThoai");
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				khachHang = new KhachHang(maKH, tenKH, soDienThoai, gioiTinh);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return khachHang;
	}

	public boolean xoaHD(String maHoaDon) {
		boolean check = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "delete Hoa_don where maHoaDon = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maHoaDon);
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return check;
	}

	public boolean xoaCT_HD(String mahoadon, String maSP) {
		boolean check = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "delete Chi_Tiet_Hoa_Don where maHoaDon = ? and maSanPham = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, mahoadon);
			preStm.setString(2, maSP);
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return check;
	}

	public boolean capNhatSLSanPham(String maSP, int soluong) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Update San_Pham set soLuong = ? where maSanPham = ?";

			preStm = con.prepareStatement(sql);
			preStm.setInt(1, soluong);
			preStm.setString(2, maSP);

			n = preStm.executeUpdate() > 0;

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return n;
	}

	public boolean capNhatSLCT_HoaDon(String maHD, String maSP, int soluong) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Update Chi_Tiet_Hoa_Don set soLuong = ? where maHoaDon = ? and maSanPham = ?";

			preStm = con.prepareStatement(sql);
			preStm.setInt(1, soluong);
			preStm.setString(2, maHD);
			preStm.setString(3, maSP);

			n = preStm.executeUpdate() > 0;

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return n;
	}

	public boolean capNhatTrangThai(String maHoaDon) {
		boolean n = false;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Update Hoa_Don set trangThai = 1 where maHoaDon = ?";

			preStm = con.prepareStatement(sql);
			preStm.setString(1, maHoaDon);
			n = preStm.executeUpdate() > 0;

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return n;
	}
}
