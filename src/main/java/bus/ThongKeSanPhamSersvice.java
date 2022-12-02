package bus;

import java.util.ArrayList;
import java.util.List;

import dto.ChiTietHoaDon;
import dto.SanPham;

public interface ThongKeSanPhamSersvice {
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam);
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam);
	public ArrayList<SanPham> get10SanPhamBanChay();
}
