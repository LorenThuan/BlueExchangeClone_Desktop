package dto;
import java.util.Date;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class HoaDon {

	private String maHoaDon;
	private Date ngayDat;
	private String trangThai;
	public KhachHang khachHang;
	public NhanVien nhanVien;
	public HoaDon(){

	}

	

	

	


	public HoaDon(String maHoaDon, Date ngayDat, String trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}


	





	public String getMaHoaDon() {
		return maHoaDon;
	}








	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}








	public Date getNgayDat() {
		return ngayDat;
	}








	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}








	public String getTrangThai() {
		return trangThai;
	}








	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}








	public KhachHang getKhachHang() {
		return khachHang;
	}








	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}








	public NhanVien getNhanVien() {
		return nhanVien;
	}








	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}



	




	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayDat=" + ngayDat + ", trangThai=" + trangThai + ", khachHang="
				+ khachHang.getMaKhachHang() + ", nhanVien=" + nhanVien.getMaNhanVien() + "]";
	}








	public double tinhThanhTien(){
		return 0;
	}

}