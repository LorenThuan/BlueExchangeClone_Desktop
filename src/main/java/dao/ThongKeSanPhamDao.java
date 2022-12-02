package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ChiTietHoaDon;
import dto.SanPham;


public interface ThongKeSanPhamDao {
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam);
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam);
	public ArrayList<SanPham> get10SanPhamBanChay();
}
