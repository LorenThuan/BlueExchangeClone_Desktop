package dto;

public class HDSD {
	private String hinhAnh;
	private String noiDung;
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public HDSD() {
		super();
	}
	public HDSD(String hinhAnh, String noiDung) {
		super();
		this.hinhAnh = hinhAnh;
		this.noiDung = noiDung;
	}
	@Override
	public String toString() {
		return "HDSD [hinhAnh=" + hinhAnh + ", noiDung=" + noiDung + "]";
	}
	
	
}
