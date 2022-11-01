package bus;

import java.util.Map;

import dao.ThongKeDoanhThuDao;
import dao.impl.ThongKeDoanhThuImpl;
import dto.HoaDon;

public class ThongKeDoanhThuServiceImpl implements ThongKeDoanhThuService{
	private ThongKeDoanhThuDao thongKeDoanhThuDao = new ThongKeDoanhThuImpl();
	@Override
	public double tinhTongTienBanDuocTheoThang(int thang, int nam) {
		return thongKeDoanhThuDao.tinhTongTienBanDuocTheoThang(thang, nam);
	}
	@Override
	public Map<HoaDon, Double> layTatCaHoaDonTheoThangNam(int thang, int nam) {
		return thongKeDoanhThuDao.layTatCaHoaDonTheoThangNam(thang, nam);
	}
	

}
