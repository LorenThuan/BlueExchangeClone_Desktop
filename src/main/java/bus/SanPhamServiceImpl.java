package bus;

import java.util.ArrayList;

import dao.SanPhamDao;
import dao.impl.SanPhamImpl;
import dto.SanPham;

public class SanPhamServiceImpl implements SanPhamService{

	private SanPhamDao sanPhamDao = new SanPhamImpl();
	
	@Override
	public ArrayList<SanPham> getTatCaSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDao.getTatCaSanPham();
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDao.themSanPham(sanPham);
	}

}
