package bus;

import java.util.List;

import dao.ThongKeSanPhamDao;
import dao.impl.ThongKeSanPhamImpl;
import dto.ChiTietHoaDon;

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

}
