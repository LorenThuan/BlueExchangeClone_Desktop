package bus;

import java.util.ArrayList;

import dao.HDSDDao;
import dao.impl.HDSDImpl;
import dto.HDSD;

public class HDSDServiceImpl implements HDSDService{
	private HDSDDao hdsdDao = new HDSDImpl();
	@Override
	public ArrayList<HDSD> getTatCaHuongDan() {
		// TODO Auto-generated method stub
		return hdsdDao.getTatCaHuongDan();
	}

}
