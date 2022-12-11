package bus;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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

	@Override
	public boolean xoaSanPham(String maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDao.xoaSanPham(maSanPham);
	}

	@Override
	public boolean capNhatSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDao.capNhatSanPham(sanPham);
	}

	@Override
	public ArrayList<SanPham> timKiemSanPham(String tuKhoa) {
		// TODO Auto-generated method stub
		return sanPhamDao.timKiemSanPham(tuKhoa);
	}

	@Override
	public ArrayList<SanPham> timKiemSanPhamTheoLoai(String tuKhoa) {
		// TODO Auto-generated method stub
		return sanPhamDao.timKiemSanPhamTheoLoai(tuKhoa);
	}

	@Override
	public SanPham timSanPhamTheoMa(String ma) {
		// TODO Auto-generated method stub
		return sanPhamDao.timSanPhamTheoMa(ma);
	}

	@Override
	public boolean themSanPhamTuExcel(File file) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return sanPhamDao.themSanPhamTuExcel(file);
	}

}
