package bus;

import java.util.List;
import java.util.Map;

import dto.HoaDon;

public interface ThongKeDoanhThuService {
	public double tinhTongTienBanDuocTheoThang(int thang, int nam);
	public Map<HoaDon, Double> layTatCaHoaDonTheoThangNam(int thang, int nam);
}
