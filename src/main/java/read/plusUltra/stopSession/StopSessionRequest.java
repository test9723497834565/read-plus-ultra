package read.plusUltra.stopSession;

import java.util.Date;

public class StopSessionRequest {
	
	private String sessionType;
	private Date stop;
	
	public StopSessionRequest() {
		// required
	}

	public StopSessionRequest(String sessionType, Date stop) {
		this.sessionType = sessionType;
		this.stop = stop;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public Date getStop() {
		return stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}
	
	
}
