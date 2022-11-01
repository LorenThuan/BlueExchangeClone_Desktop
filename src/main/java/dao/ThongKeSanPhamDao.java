package dao;

import java.util.List;

import dto.ChiTietHoaDon;


public interface ThongKeSanPhamDao {
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam);
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam);
}
