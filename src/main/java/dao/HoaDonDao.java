package dao;

import java.util.List;

import dto.ChiTietHoaDon;
import dto.HoaDon;
import dto.KhachHang;
import dto.SanPham;

public interface HoaDonDao {
	public List<SanPham> getSanPhamTim(String noidung);
	public List<SanPham> getTatCaSanPham();
	public SanPham laySanPhamTheoMa(String ma);
	public List<ChiTietHoaDon> getCT_HoadonTheoHoaDon(String mahoadon);
	public List<HoaDon> getAllDSHoadon(String maNhanVien);
	public boolean themHoaDon(HoaDon hoadon);
	public boolean themCT_HoaDon(HoaDon hd, SanPham sp, int soLuong);
	public KhachHang timKiemKhachHangtheoSDT(String noiDungTim);
	public HoaDon getHoaDon(String mahoadon);
	public boolean xoaHD(String maHoaDon);
	public boolean capNhatSLSanPham(String maSP, int soluong);
	public List<ChiTietHoaDon> getAllDSCT_Hoadon();
	public boolean capNhatTrangThai(String maHoaDon);
	public boolean capNhatSLCT_HoaDon(String maHD, String maSP, int soluong);
	public boolean xoaCT_HD(String mahoadon, String maSP);
	public KhachHang timKiemKhachHangtheoMa(String maKH);
	public ChiTietHoaDon get_TungCT_HoaDon(String mahoadon, String maSP);
}
