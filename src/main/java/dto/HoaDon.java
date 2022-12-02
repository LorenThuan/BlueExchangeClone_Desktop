package dto;

import java.sql.Date;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class HoaDon {

	private String maHoaDon;
	private Date ngayDat;
	private boolean trangThai;
	public KhachHang khachHang;
	public NhanVien nhanVien;
	private double tongTien;
	private double giamGia;
	public HoaDon(){

	}


	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	


	





	public HoaDon(String maHoaDon, Date ngayDat, boolean trangThai, KhachHang khachHang, NhanVien nhanVien,
			double tongTien, double giamGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.tongTien = tongTien;
		this.giamGia = giamGia;
	}


	public HoaDon(String maHoaDon, Date ngayDat, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}





	public HoaDon(String maHoaDon, Date ngayDat, boolean trangThai, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
		this.tongTien = tongTien;
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



	public boolean isTrangThai() {
		return trangThai;
	}



	public void setTrangThai(boolean trangThai) {
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



	



	public double getTongTien() {
		return tongTien;
	}



	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}


	
	





	public double getGiamGia() {
		return giamGia;
	}


	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}


	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayDat=" + ngayDat + ", trangThai=" + trangThai + ", khachHang="
				+ khachHang.getMaKhachHang() + ", nhanVien=" + nhanVien.getMaNhanVien() + ", tongTien=" + tongTien + ", giamGia=" + giamGia + "]";
	}


	



}