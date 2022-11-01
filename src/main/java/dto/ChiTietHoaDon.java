package dto;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class ChiTietHoaDon {

	private int soLuong;
	private HoaDon hoaDon;
	private SanPham sanPham;
	
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public ChiTietHoaDon(){
			
	}
	
	public ChiTietHoaDon(int soLuong) { 
		super();
		this.soLuong = soLuong;
	}

	public double tinhTongTien(){
		return (sanPham.getDonGia() * soLuong) * (1 - sanPham.getGiamGia());
	}

}