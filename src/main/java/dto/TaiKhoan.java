package dto;

import java.io.Serializable;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class TaiKhoan implements Serializable{

	private String matKhau;
	private NhanVien nhanVien;
	
	public TaiKhoan(){
	}
	
	public TaiKhoan(String matKhau) {
		super();
		this.matKhau = matKhau;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [matKhau=" + matKhau + ", nhanVien=" + nhanVien.getMaNhanVien() + "]";
	}
	
	
	

	

	

}