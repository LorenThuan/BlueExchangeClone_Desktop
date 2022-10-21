package dto;

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
			double giamGia, String mauSac, String gioiTinh, String kichThuoc, String trangThai, String chatLieu) {
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
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", mota=" + mota + ", donGia="
				+ donGia + ", hinhAnh=" + hinhAnh + ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", mauSac="
				+ mauSac + ", gioiTinh=" + gioiTinh + ", kichThuoc=" + kichThuoc + ", trangThai=" + trangThai
				+ ", chatLieu=" + chatLieu + "]";
	}
	
	

}