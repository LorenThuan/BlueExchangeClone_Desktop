package bus;

import java.util.ArrayList;

import dto.SanPham;


public interface SanPhamService {
	public ArrayList<SanPham> getTatCaSanPham();
	public boolean themSanPham(SanPham sanPham);
}
