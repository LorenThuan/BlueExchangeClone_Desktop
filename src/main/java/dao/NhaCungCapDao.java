package dao;

import java.util.ArrayList;

import dto.NhaCungCap;

public interface NhaCungCapDao {
	public ArrayList<NhaCungCap> getTatCaNhaCungCap();
	public boolean themNhaCungCap (NhaCungCap nhaCungCap);
	public boolean xoaNhaCungCap (String maNhaCungCap);
	public boolean capNhatNhaCungCap (NhaCungCap nhaCungCap);
	public ArrayList<NhaCungCap> timKiemNhaCungCap(String tuKhoa);
}
