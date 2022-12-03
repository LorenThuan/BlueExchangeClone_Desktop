package bus;

import java.util.ArrayList;

import dto.SanPham;


public interface SanPhamService {
	public ArrayList<SanPham> getTatCaSanPham();
	public boolean themSanPham(SanPham sanPham);
	public boolean xoaSanPham (String maSanPham);
	public boolean capNhatSanPham (SanPham sanPham);
	public ArrayList<SanPham> timKiemSanPham(String tuKhoa);
	public ArrayList<SanPham> timKiemSanPhamTheoLoai(String tuKhoa);
	public SanPham timSanPhamTheoMa (String ma);
}
