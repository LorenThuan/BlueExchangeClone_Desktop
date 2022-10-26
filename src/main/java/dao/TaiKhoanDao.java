package dao;


import dto.TaiKhoan;

public interface TaiKhoanDao {
	public boolean themTaiKhoan(TaiKhoan taiKhoan);
	public TaiKhoan layThongTinTaKhoanTheoMaTaiKhoan(String maTaiKhoan);
}
