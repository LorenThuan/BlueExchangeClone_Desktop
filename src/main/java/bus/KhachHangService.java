package bus;

import java.util.List;

import dto.KhachHang;

public interface KhachHangService{
	public List<KhachHang> getTatCaKhachHang();
	public boolean themKhachHang(KhachHang khachHang);
	public boolean capNhatThongTinKhachHang(KhachHang khachHang);
	public boolean xoaKhachHang(String maKhachHang);
	public List<KhachHang> timKiemKhachHang(String noiDungTim);
	public KhachHang layThongTinKhachHangTheoMaKhachHang(String maKhachHang);
}
