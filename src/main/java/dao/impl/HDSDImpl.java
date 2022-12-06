package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import dao.ConectDatabaseHDSD;
import dao.HDSDDao;
import dto.HDSD;

public class HDSDImpl implements HDSDDao{
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;
	
	
	
	@Override
	public ArrayList<HDSD> getTatCaHuongDan() {
		ArrayList<String> noiDungHD = new ArrayList<String>();
		noiDungHD.add("1. Sau khi bạn nhập thông tin tìm kiếm theo tên hoặc theo mã sản phẩm hoặc chọn size ấn nút tìm kiếm sẽ hiện thông tin được tìm thấy lên bảng danh sách sản phẩm \r\n"
				+ "2. Sau khi ấn nút làm mới bảng danh sách sản phẩm sẽ hiển thị tất cả sản phẩm của cửa hàng \r\n"
				+ "3. Danh sách sản phẩm đang kinh doanh của cửa hàng \r\n"
				+ "4. Sau khi nhập số lượng ở ô bên trên ấn nút + ứng dụng sẽ thêm sản phẩm khách hàng muốn mua vào bảng chi tiết hóa đơn tạm nằm ở bên phải \r\n"
				+ "5. Ô nhập thông tin tìm kiếm khách hàng cũ đã mua hàng của cửa hàng trước đó theo tên hoặc số điện thoại khách hàng khi ấn nút tìm kiếm bên phải sẽ hiển thị danh sách khách hàng thả xuống để từ đó có thể lựa chọn tên khách hàng sẽ hiển thị thông tin số điện thoại theo tên khách hàng \r\n"
				+ "6. Nút thêm khách hàng lần đầu mua hàng tại cửa hàng ứng dụng sẽ chuyển màn hình qua màn hình khách hàng để tiến hành thêm khách hàng vào cơ sở dữ liệu \r\n"
				+ "7. Danh sách chi tiết hóa đơn tạm \r\n"
				+ "8. Khi ấn nút lưu tạm ứng dụng sẽ tiến hành lưu thông tin ở bảng chi tiết hóa đơn vào bảng hóa đơn ở trạng thái \"Chưa thanh toán\" \r\n"
				+ "9. Khi ấn nút thanh toán ứng dụng sẽ kiểm tra tiền khách đưa có lớn hơn hoặc bằng thành tiền hay không? nếu đúng thì hệ thống sẽ lưu thông tin chi tiết hóa đơn tạm vào bảng hóa đơn ở trạng thái \"Đã thanh toán\" \r\n"
				+ "10.Danh sách hóa đơn, nếu có đơn hàng ở trạng thái \"Chưa thanh toán\", có thể chọn hóa đơn chưa thanh toán và tiến hành thanh toán thì bảng danh sách hóa đơn sẽ được cập nhật trạng thái của hóa đơn đó thành \"Đã thanh toán\" \r\n"
				+ "11.Danh sách lọc thả xuống, có thể chọn lọc Đã thanh toán hoặc Chưa thanh toán thì danh sách hóa đơn sẽ lọc hóa đơn theo một trong hai trạng thái đó  \r\n"
				+ "12.Ô nhập thông tin tìm kiếm hóa đơn theo số điện thoại khách hàng, ấn nút tìm kiếm bên phải sẽ hiển thị thông tin hóa đơn theo số điện thoại khách hàng \r\n"
				+ "13.Khi chọn ô bất kì bên danh sách hóa đơn ứng dụng sẽ thực hiện xóa hóa đơn ở trạng thái \"Chưa thanh toán\" nếu người dùng ấn đồng ý \r\n"
				+ "14.Khi ấn nút in hóa đơn ứng dụng sẽ hiện bảng danh sách hóa đơn đã bán trong ngày, người dùng có thể chọn lưu dưới dạng .pdf \r\n"
				+ "");
		noiDungHD.add("1. Khi ấn nút Chọn hình người dùng có thể chọn hình tồn tại trên máy tính \r\n"
				+ "2. Các chức năng thêm, xóa, sửa, xóa rỗng, hoàn tác tương tác trên ứng dụng \r\n"
				+ "3. Danh sách lọc tìm kiếm thả xuống, người dùng có thể lọc để hiển thị danh sách sản phẩm theo tên cần tìm, mặc định tất cả nghĩa là hiển thị tất cả danh sách sản phẩm \r\n"
				+ "4. Ô tìm kiếm giúp tìm sản phẩm theo mã sản phẩm \r\n"
				+ "5. Danh sách sản phẩm đang kinh doanh của cửa hàng \r\n"
				+ "6.Thông tin sản phẩm, nhân viên có thể thực hiện thao tác với các chức năng của ứng dụng");
		noiDungHD.add("1. Thông tin nhân viên, nhân viên quản lý thực hiện thao tác với các chức năng của ứng dụng \r\n"
				+ "2. Các chức năng thêm, xóa, sửa, xóa rỗng, hoàn tác tương tác trên ứng dụng \r\n"
				+ "3. Ô nhập giúp tìm kiếm thông tin nhân viên theo mã nhân viên, tên nhân viên hoặc email, khi ấn nút tìm kiếm bên phải sẽ hiển thị thông tin nhân viên tìm được hiển thị lên danh sách nhân viên \r\n"
				+ "4. Danh sách nhân viên đang làm việc của cửa hàng");
		HDSD hdsd = new HDSD();	
	
		ArrayList<HDSD> danhSachHdsds = new ArrayList<HDSD>();	
				try {
					con = ConectDatabaseHDSD.getInstance().getConnection();
					
					String sql="SELECT * FROM hdsd";
					preStm = con.prepareStatement(sql);
					rs = preStm.executeQuery();
					String temp = null;
					while (rs.next()) {					
						String hinhAnh = rs.getString(1);
						for (String noiDung : noiDungHD) {
							temp = noiDung;
							
						}
						hdsd = new HDSD(hinhAnh, temp);
						danhSachHdsds.add(hdsd);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return danhSachHdsds;
	}

}
