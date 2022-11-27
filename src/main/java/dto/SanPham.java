package dto;

import java.util.Objects;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class SanPham {

	private String maSanPham;
	private String tenSanPham;
	private String mota;
	private double donGia;
	private String hinhAnh;
	private int soLuong;
	private double giamGia;
	private double giaNhap;
	private String mauSac;
	private String gioiTinh;
	private String kichThuoc;
	private String trangThai;
	private String chatLieu;
	public LoaiSanPham loaiSanPham;
	public NhaCungCap nhaCungCap;

	public SanPham(){

	}	

	
	
	public SanPham(String maSanPham, String tenSanPham, String mota, double donGia, String hinhAnh, int soLuong,
			double giamGia, String mauSac, String gioiTinh, String kichThuoc, String trangThai, String chatLieu,
			LoaiSanPham loaiSanPham, NhaCungCap nhaCungCap) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.mota = mota;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.mauSac = mauSac;
		this.gioiTinh = gioiTinh;
		this.kichThuoc = kichThuoc;
		this.trangThai = trangThai;
		this.chatLieu = chatLieu;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
	}



	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mota=" + mota + ", donGia="
				+ donGia + ", hinhAnh=" + hinhAnh + ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", mauSac="
				+ mauSac + ", gioiTinh=" + gioiTinh + ", kichThuoc=" + kichThuoc + ", trangThai=" + trangThai
				+ ", chatLieu=" + chatLieu + "]";
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}



	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	
	

}