package read.plusUltra.getWorkLoad;

import java.util.List;

public class Dataset {

	private String label;
	private String backgroundColor;
	private String stack;
	private List<Integer> data;
	
	public Dataset() {
		// required
	}
	
	public Dataset(String label, String backgroundColor, String stack, List<Integer> data) {
		this.label = label;
		this.backgroundColor = backgroundColor;
		this.stack = stack;
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}
	
	
}
