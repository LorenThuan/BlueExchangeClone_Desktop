package dto;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class NhanVien implements Serializable{

	private String maNhanVien;
	private String email;
	private Date ngaySinh;
	private String tenNhanVien;
	private boolean gioiTinh;
	private String chucVu;
	private boolean trangThai;
	public NhanVien(){

	}
	
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}


	public NhanVien(String maNhanVien, String email, Date ngaySinh, String tenNhanVien, boolean gioiTinh, String chucVu,
			boolean trangThai) {
		super();
		this.maNhanVien = maNhanVien;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", email=" + email + ", ngaySinh=" + ngaySinh + ", tenNhanVien="
				+ tenNhanVien + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu + ", trangThai=" + trangThai + "]";
	}

	

}