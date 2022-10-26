package dao;

import java.util.ArrayList;

import dto.SanPham;

public interface SanPhamDao {
	public ArrayList<SanPham> getTatCaSanPham();
	public boolean themSanPham(SanPham sanPham);
}
