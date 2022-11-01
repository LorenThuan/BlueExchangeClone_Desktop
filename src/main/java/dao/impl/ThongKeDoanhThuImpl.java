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

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import dao.ConectDatabase;
import dao.ThongKeDoanhThuDao;
import dto.HoaDon;
import dto.HoaDon;

public class ThongKeDoanhThuImpl implements ThongKeDoanhThuDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;


	@Override
	public double tinhTongTienBanDuocTheoThang(int thang, int nam) {
		double tongTien = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT      sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - [giamGia]))  as TongTien\r\n"
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


	@Override
	public Map<HoaDon, Double> layTatCaHoaDonTheoThangNam(int thang, int nam) {
//		Map<TaiKhoan, Double> map = new TreeMap<TaiKhoan, Double>();
//		Double tinhTien = 0.0;
//		Session currentSession = entityManager.unwrap(Session.class);
//		List<Object[]> objects = currentSession.createNativeQuery("SELECT Tai_Khoan.id,ten_tai_khoan, ngay_tao, email, so_dien_thoai, ngay_sinh, gioi_tinh, sum(tong_tien) \r\n"
//				+ "FROM            Hoa_Don INNER JOIN\r\n"
//				+ "                         Tai_Khoan ON Hoa_Don.tai_khoan_id = Tai_Khoan.id\r\n"
//				+ "			where [trang_thai] not like N'%Đang chờ xác nhận%' and trang_thai not like N'%Đang giao hàng%' and role not like N'ADMIN' \r\n"
//				+ "						 group by  Tai_Khoan.id,ten_tai_khoan, ngay_tao, email, so_dien_thoai, ngay_sinh, gioi_tinh").getResultList();
//		for(Object[] o : objects) {
//			Integer idTK = (Integer) o[0];
//			TaiKhoan taiKhoan = currentSession.get(TaiKhoan.class, idTK);
//			BigDecimal tongTien = (BigDecimal) o[7];
//			if(tongTien == null) {
//				tinhTien = 0.0;
//			}
//			tinhTien = tongTien.doubleValue();
//			map.put(taiKhoan, tinhTien);
//		}
//		return map;
		
		
		Map<HoaDon, Double> map = null;
		HoaDon hoaDon = null; 
//		Session currentSession = entityManager.unwrap(Session.class);
		try {
//			List<Object[]> objects = currentSession.createNativeQuery()
//			List<Ob>
			List<Object[]> objectsList = new ArrayList<>();

			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT      Chi_Tiet_Hoa_Don.maHoaDon,Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - [giamGia])  as ThanhTien\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "                         San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "where YEAR([ngayDat]) = ? and MONTH([ngayDat]) = ?\r\n"
					+ "group by Chi_Tiet_Hoa_Don.maHoaDon, Chi_Tiet_Hoa_Don.maSanPham, Chi_Tiet_Hoa_Don.[soLuong], [donGia], [giamGia]";
			preStm = con.prepareStatement(sql);
			preStm.setInt(1, nam);
			preStm.setInt(2, thang);
			 int index = 1;
			 if (null != objectsList && !objectsList.isEmpty()) {
				    for (int i = 0; i < objectsList.size(); i ++) {
				    	preStm.setObject(index++, objectsList.get(i));
				    }
				  }
			rs = preStm.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			 int colsLen = metaData.getColumnCount();
			 String fm = Integer.toString(colsLen);
//			 Double tongTien = Double.parseDouble(fm);
			  while (rs.next()) {
			   map = new HashMap<HoaDon, Double>(colsLen);
			    for (int i = 0; i < colsLen; i ++) {
			      String maHd = metaData.getColumnName(i + 1);
			      hoaDon = (HoaDon) rs.getObject(maHd);
			      if (hoaDon == null) {
			        System.out.println("error");
			      }
			      String tongTienFM = metaData.getColumnName(i + 2);
			      Double tinhTongTien = Double.parseDouble(tongTienFM);
			      BigDecimal tongTien = BigDecimal.valueOf(tinhTongTien);
			      Double thanhTien = tongTien.doubleValue();
			      map.put(hoaDon, thanhTien);
			    }
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}


