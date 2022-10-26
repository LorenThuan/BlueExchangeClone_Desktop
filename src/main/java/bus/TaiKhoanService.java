package bus;

import dto.TaiKhoan;

public interface TaiKhoanService {
	public boolean themTaiKhoan(TaiKhoan taiKhoan);
	public TaiKhoan layThongTinTaKhoanTheoMaTaiKhoan(String maTaiKhoan);
}
