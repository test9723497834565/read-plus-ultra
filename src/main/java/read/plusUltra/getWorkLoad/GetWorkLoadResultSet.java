package read.plusUltra.getWorkLoad;

import java.util.Date;

public class GetWorkLoadResultSet {

	private Date day;
	private int minute;
	
	public GetWorkLoadResultSet() {
		// required
	}

	public GetWorkLoadResultSet(Date day, int minute) {
		this.day = day;
		this.minute = minute;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	
}
