package read.plusUltra.getLesson;

public class Word {
	
	private int id;
	private String text;
	private String type;

	public Word() {
		
	}

	public Word(int id, String text, String type) {
		this.id = id;
		this.text = text;
		this.type = type;
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
	
	
}
