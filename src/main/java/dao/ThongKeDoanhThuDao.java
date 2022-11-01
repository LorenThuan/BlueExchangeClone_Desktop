package dao;

import java.util.Map;

import dto.HoaDon;

public interface ThongKeDoanhThuDao {
	public double tinhTongTienBanDuocTheoThang(int thang, int nam);
	public Map<HoaDon, Double> layTatCaHoaDonTheoThangNam(int thang, int nam);
}
