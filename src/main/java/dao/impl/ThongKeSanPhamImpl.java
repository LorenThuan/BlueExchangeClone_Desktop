package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bus.SanPhamService;
import bus.SanPhamServiceImpl;
import bus.ThongKeDoanhThuService;
import bus.ThongKeDoanhThuServiceImpl;
import dao.ConectDatabase;
import dao.ThongKeSanPhamDao;
import dto.ChiTietHoaDon;
import dto.HoaDon;
import dto.SanPham;

public class ThongKeSanPhamImpl implements ThongKeSanPhamDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	private SanPhamService sanPhamService = new SanPhamServiceImpl();
	private ThongKeDoanhThuService thongKeDoanhThuService = new ThongKeDoanhThuServiceImpl();
	@Override
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam) {
		int tongSP = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT     sum(Chi_Tiet_Hoa_Don.soLuong)\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon\r\n"
					+ "where YEAR([ngayDat]) = ?  and MONTH([ngayDat]) = ?";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			rs = preStm.executeQuery();
			while (rs.next()) {
				 tongSP = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return tongSP;
	}

	@Override
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam) {
		ChiTietHoaDon chiTietHoaDon = null;
		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
		try {
//			List<Object[]> objects = currentSession.createNativeQuery()
//			List<Ob>
			
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT top 10 Chi_Tiet_Hoa_Don.maHoaDon, Chi_Tiet_Hoa_Don.maSanPham, Chi_Tiet_Hoa_Don.[soLuong]\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "                         San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "where YEAR([ngayDat]) = ? and MONTH([ngayDat]) = ?\r\n"
					+ "group by Chi_Tiet_Hoa_Don.maHoaDon, Chi_Tiet_Hoa_Don.maSanPham, Chi_Tiet_Hoa_Don.[soLuong]\r\n"
					+ "ORDER BY Chi_Tiet_Hoa_Don.[soLuong] DESC";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				String maSanPham = rs.getString(2);
				int soLuong = rs.getInt(3);
				HoaDon hd = thongKeDoanhThuService.layHoaDonTheoMa(maHoaDon);
				SanPham sanPham = sanPhamService.timSanPhamTheoMa(maSanPham);
				chiTietHoaDon = new ChiTietHoaDon(soLuong);
				chiTietHoaDon.setSanPham(sanPham);
				chiTietHoaDon.setHoaDon(hd);
				chiTietHoaDons.add(chiTietHoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chiTietHoaDons;
	}

}
