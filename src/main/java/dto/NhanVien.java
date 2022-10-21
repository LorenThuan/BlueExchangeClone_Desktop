package dto;

import java.util.Date;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class NhanVien {

	private String maNhanVien;
	private String email;
	private Date ngaySinh;
	private String tenNhanVien;
	private boolean gioiTinh;
	private String chucVu;

	public NhanVien(){

	}


	/**
	 * 
	 * @param maNhanVien
	 * @param email
	 * @param ngaySinh
	 * @param tenNhanVien
	 * @param gioiTinh
	 * @param chucVu
	 */
	public NhanVien(String maNhanVien, String email, Date ngaySinh, String tenNhanVien, boolean gioiTinh, String chucVu){

	}

	public String toString(){
		return "";
	}

}