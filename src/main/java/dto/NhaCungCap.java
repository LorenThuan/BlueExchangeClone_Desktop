package dto;

import java.sql.Date;
import java.util.Objects;

/**
 * @author Loren Thuan
 * @version 1.0
 * @created 23-Thg9-2022 8:28:40 CH
 */
public class NhaCungCap {

	private String maNhaCungCap;
	private String tenNhaCungCap;
	private Date ngayHopTac;
	private String diaChi;
	private String soDienThoai;
	private String email;


	public void finalize() throws Throwable {

	}

	

	public NhaCungCap() {
		super();
	}



	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, Date ngayHopTac, String diaChi, String soDienThoai,
			String email) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.ngayHopTac = ngayHopTac;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	

	public NhaCungCap(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}



	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public Date getNgayHopTac() {
		return ngayHopTac;
	}

	public void setNgayHopTac(Date ngayHopTac) {
		this.ngayHopTac = ngayHopTac;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", ngayHopTac="
				+ ngayHopTac + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(maNhaCungCap);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNhaCungCap, other.maNhaCungCap);
	}

	
	
}