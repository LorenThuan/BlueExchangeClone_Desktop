package bus;

import java.util.List;

import dto.NhanVien;

public interface NhanVienService{
	public List<NhanVien> getTatCaNhanVien();
	public boolean themNhanVien(NhanVien nhanVien);
	public boolean capNhatThongTinNhanVien(NhanVien nhanVien);
	public boolean xoaNhanVien(String maNhanVien);
	public List<NhanVien> timKiemNhanVien(String noiDungTim);
	public NhanVien layThongTinNhanVienTheoMaNhanVien(String maNhanVien);
}
