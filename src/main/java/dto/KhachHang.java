package dto;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class KhachHang {

	private String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private boolean gioiTinh;

	public KhachHang(){

	}


	/**
	 * 
	 * @param maKhachHang
	 * @param tenKhachHang
	 * @param soDienThoai
	 * @param gioiTinh
	 */
	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, boolean gioiTinh){

	}


	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}


	public String getMaKhachHang() {
		return maKhachHang;
	}


	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}


	public String getTenKhachHang() {
		return tenKhachHang;
	}


	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", gioiTinh=" + gioiTinh + "]";
	}

	
	

	

	

}