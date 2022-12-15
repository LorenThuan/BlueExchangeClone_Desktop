package main;

import dao.ConectDatabase;
import handle.CountDownThread;

public class Main {
	public static void main(String[] args) {
		try {
			ConectDatabase.getInstance().connect();
			CountDownThread countDownThread = new CountDownThread();
			countDownThread.start();
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}

