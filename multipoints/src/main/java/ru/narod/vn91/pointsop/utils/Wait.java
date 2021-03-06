package ru.narod.vn91.pointsop.utils;

import java.util.Date;

public class Wait {

	public static void waitExactly(long milliseconds) {
		long timeout = new Date().getTime() + milliseconds;
		long remaining = milliseconds;
		while (remaining > 0) {

			Object o = new Object();
			synchronized (o) {
				try {
					o.wait(remaining);
					remaining = timeout - new Date().getTime();
				} catch (InterruptedException e) {
//					e.printStackTrace();
					// exit the loop
					remaining = 0;
				}
			}

		}
	}

}
