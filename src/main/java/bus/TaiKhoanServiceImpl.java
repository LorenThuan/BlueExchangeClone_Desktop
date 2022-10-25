package bus;

import dao.TaiKhoanDao;
import dao.impl.TaiKhoanImpl;
import dto.TaiKhoan;

public class TaiKhoanServiceImpl implements TaiKhoanService{
	private TaiKhoanDao taiKhoanDao = new TaiKhoanImpl();
	@Override
	public boolean themTaiKhoan(TaiKhoan taiKhoan) {
		return taiKhoanDao.themTaiKhoan(taiKhoan);
	}

}
