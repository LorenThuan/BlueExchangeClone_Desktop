package bus;

import java.util.ArrayList;
import java.util.List;

import dao.ThongKeSanPhamDao;
import dao.impl.ThongKeSanPhamImpl;
import dto.ChiTietHoaDon;
import dto.SanPham;

public class ThongKeSanPhamServiceImpl implements ThongKeSanPhamSersvice{
	private ThongKeSanPhamDao thongKeSanPhamDao = new ThongKeSanPhamImpl();
	@Override
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return thongKeSanPhamDao.tinhTongSanPhamBanDuocTheoThang(thang, nam);
	}
	@Override
	public List<ChiTietHoaDon> lay10SanPhamBanChayTheoThangNam(int thang, int nam) {
		// TODO Auto-generated method stub
		return thongKeSanPhamDao.lay10SanPhamBanChayTheoThangNam(thang, nam);
	}
	@Override
	public ArrayList<SanPham> get10SanPhamBanChay() {
		return thongKeSanPhamDao.get10SanPhamBanChay();
	}

}
