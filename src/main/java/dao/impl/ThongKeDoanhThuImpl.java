package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import bus.KhachHangService;
import bus.KhachHangServiceImpl;
import bus.NhanVienService;
import bus.NhanVienServiceImpl;
import dao.ConectDatabase;
import dao.ThongKeDoanhThuDao;
import dto.HoaDon;
import dto.KhachHang;
import dto.NhanVien;

public class ThongKeDoanhThuImpl implements ThongKeDoanhThuDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	private KhachHangService khachHangService = new KhachHangServiceImpl();
	private NhanVienService nhanVienService = new NhanVienServiceImpl();

	@Override
	public double tinhTongTienBanDuocTheoThang(int thang, int nam) {
		double tongTien = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT      sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia])) * 1.1 as TongTien\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "                         San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "where YEAR([ngayDat]) = ?  and MONTH([ngayDat]) = ?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			rs = preStm.executeQuery();
			while (rs.next()) {
				tongTien = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return tongTien;
	}
	
	public double tinhTongTienLaiTheoThang(int thang, int nam) {
		double tongTien = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT      sum(Chi_Tiet_Hoa_Don.[soLuong] * ([donGia]-[giaNhap]) * (1 - San_Pham.[giamGia])) + sum(Chi_Tiet_Hoa_Don.[soLuong] * ([donGia]-[giaNhap]) * (1 - San_Pham.[giamGia]))*0.1 - (sum(Chi_Tiet_Hoa_Don.[soLuong] * ([donGia]-[giaNhap]) * (1 - San_Pham.[giamGia]))*(Hoa_Don.giamGia))/100  as TongTien\r\n"
					+ "					FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "					                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "					                        San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "					where YEAR([ngayDat]) = ?  and MONTH([ngayDat]) = ?\r\n"
					+ "					group by Chi_Tiet_Hoa_Don.[soLuong], [donGia], [giaNhap], San_Pham.[giamGia], Hoa_Don.giamGia";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			rs = preStm.executeQuery();
			while (rs.next()) {
				tongTien = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return tongTien;
	}


	@Override
	public List<HoaDon> layTatCaHoaDonTheoThangNam(int thang, int nam) {
		HoaDon hoaDon = null;
		List<HoaDon> hoaDons = new ArrayList<HoaDon>();
		try {
//			List<Object[]> objects = currentSession.createNativeQuery()
//			List<Ob>
			
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT      Chi_Tiet_Hoa_Don.maHoaDon, Hoa_Don.maNhanVien, Hoa_Don.maKhachHang,ngayDat,sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia])) * 1.1  as ThanhTien\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "                         San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "where YEAR([ngayDat]) = ? and MONTH([ngayDat]) = ?\r\n"
					+ "group by Chi_Tiet_Hoa_Don.maHoaDon, Hoa_Don.maNhanVien, Hoa_Don.maKhachHang, ngayDat";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				NhanVien nv = nhanVienService.layThongTinNhanVienTheoMaNhanVien(rs.getString(2));
				KhachHang kh = khachHangService.layThongTinKhachHangTheoMaKhachHang(rs.getString(3));
				Date ngayDat = rs.getDate(4);
				BigDecimal dfm = rs.getBigDecimal(5);
				Double tongTien = dfm.doubleValue();
				hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(maHoaDon);
				hoaDon.setNhanVien(nv);
				hoaDon.setKhachHang(kh);
				hoaDon.setNgayDat(ngayDat);
				hoaDon.setTongTien(tongTien);
				hoaDons.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoaDons;
	}


	@Override
	public HoaDon layHoaDonTheoMa(String maHoaDon) {
		HoaDon hoaDon = null;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "Select * from Hoa_Don where maHoaDon = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maHoaDon);
			rs = preStm.executeQuery();
			if (rs.next()) {
				Date ngaySinh = rs.getDate(2);
				Boolean trangThai = rs.getBoolean(3);
				String maNhanVien = rs.getString(4);
				String maKhachHang = rs.getString(5);
				Double giamGia = rs.getDouble(6);
				NhanVien nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
				KhachHang khachHang = khachHangService.layThongTinKhachHangTheoMaKhachHang(maKhachHang);
				hoaDon = new HoaDon(maHoaDon, ngaySinh, trangThai);
				hoaDon.setNhanVien(nhanVien);
				hoaDon.setKhachHang(khachHang);
				hoaDon.setGiamGia(giamGia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoaDon;
	}


	@Override
	public double tinhTongTienBanDuocTheoNgay(Date ngayHienTai, String maNhanVien) {
		double tongTien = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia])) + sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia]))*0.1 - (sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia]))*(Hoa_Don.giamGia))/100  as TongTien\r\n"
					+ "										FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "										                        Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "									                        San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham INNER JOIN\r\n"
					+ "								                       Khach_Hang ON Hoa_Don.maKhachHang = Khach_Hang.maKhachHang INNER JOIN\r\n"
					+ "									                       Nhan_Vien ON Hoa_Don.maNhanVien = Nhan_Vien.maNhanVien\r\n"
					+ "										WHERE Nhan_Vien.maNhanVien = ? and ngayDat = ?\r\n"
					+ "									GROUP by  San_Pham.[giamGia], Hoa_Don.giamGia";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhanVien);
			preStm.setDate(2, ngayHienTai);
			rs = preStm.executeQuery();
			while (rs.next()) {
				tongTien += rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return tongTien;
	}
}


