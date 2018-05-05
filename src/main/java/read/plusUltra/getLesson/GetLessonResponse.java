package read.plusUltra.getLesson;

import java.util.List;

public class GetLessonResponse {
	
	private List<Word> words;
	

	public GetLessonResponse() {
	}


	public GetLessonResponse(List<Word> words) {
		this.words = words;
	}


	public List<Word> getWords() {
		return words;
	}


	public void setWords(List<Word> words) {
		this.words = words;
	}
	
	
	
}
