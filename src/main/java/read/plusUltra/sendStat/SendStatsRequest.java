package read.plusUltra.sendStat;

import java.util.Date;

public class SendStatsRequest {

	private int id;
	private String text;
	private String type;
	private Date started;
	private Date ended;
	private boolean readSuccessfully;
	
	public SendStatsRequest(int id, String text, String type, Date started, Date ended, boolean readSuccessfully) {
		this.id = id;
		this.text = text;
		this.type = type;
		this.started = started;
		this.ended = ended;
		this.readSuccessfully = readSuccessfully;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public boolean isReadSuccessfully() {
		return readSuccessfully;
	}

	public void setReadSuccessfully(boolean readSuccessfully) {
		this.readSuccessfully = readSuccessfully;
	}
	
	
}
