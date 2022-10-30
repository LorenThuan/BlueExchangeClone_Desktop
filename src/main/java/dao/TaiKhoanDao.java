package dao;


import dto.TaiKhoan;

public interface TaiKhoanDao {
	public boolean themTaiKhoan(TaiKhoan taiKhoan);
	public TaiKhoan layThongTinTaKhoanTheoMaTaiKhoan(String maTaiKhoan);
	public String layMaNhanVienTheoEmail(String email);
	public boolean doiMatKhau(TaiKhoan taiKhoan);
}
