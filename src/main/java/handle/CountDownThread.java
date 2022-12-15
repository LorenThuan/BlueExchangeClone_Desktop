package handle;

import dao.ConectDatabase;
import gui.Form_Dang_Nhap;



public class CountDownThread extends Thread {
	public void run() {
		int count = 2;
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(1000);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ConectDatabase.getInstance().connect();
		Form_Dang_Nhap form_Dang_Nhap = new Form_Dang_Nhap();
		form_Dang_Nhap.setVisible(true);
		form_Dang_Nhap.setLocationRelativeTo(null);
		

	}
}
