package bus;

import java.sql.Date;
import java.util.List;
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
	public HoaDon layHoaDonTheoMa(String maHoaDon) {
		return thongKeDoanhThuDao.layHoaDonTheoMa(maHoaDon);
	}

	@Override
	public List<HoaDon> layTatCaHoaDonTheoThangNam(int thang, int nam) {
		// TODO Auto-generated method stub
		return thongKeDoanhThuDao.layTatCaHoaDonTheoThangNam(thang, nam);
	}

	@Override
	public double tinhTongTienBanDuocTheoNgay(Date ngayHienTai, String maNhanVien) {
		return thongKeDoanhThuDao.tinhTongTienBanDuocTheoNgay(ngayHienTai, maNhanVien);
	}
	

}
