package read.plusUltra.startSession;

import java.util.Date;

public class StartSessionRequest {
	
	private String sessionType;
	private Date start;
	
	
	public StartSessionRequest() {
		// required
	}
	
	public StartSessionRequest(String sessionType, Date start) {
		this.sessionType = sessionType;
		this.start = start;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	
	
	
}
