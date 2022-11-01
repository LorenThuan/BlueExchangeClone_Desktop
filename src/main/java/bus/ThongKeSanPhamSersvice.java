package bus;

import java.util.List;

import dto.ChiTietHoaDon;

public interface ThongKeSanPhamSersvice {
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam);
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam);
}
