package dto;

import java.util.Objects;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class LoaiSanPham {

	private String maLoaiSanPham;
	private String tenLoai;

	public LoaiSanPham(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param maLoaiSanPham
	 * @param tenLoai
	 */
	
		

	public LoaiSanPham(String maLoaiSanPham) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
	}

	public LoaiSanPham(String maLoaiSanPham, String tenLoai) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoai = tenLoai;
	}

	public String toString(){
		return "";
	}

	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}

	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiSanPham other = (LoaiSanPham) obj;
		return Objects.equals(maLoaiSanPham, other.maLoaiSanPham);
	}

	
}