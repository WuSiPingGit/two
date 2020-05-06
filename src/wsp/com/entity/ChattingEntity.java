package wsp.com.entity;

public class ChattingEntity {
	private String from;
	private String to;
	private String text;
	private boolean hasRead;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean getHasRead() {
		return hasRead;
	}
	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}
	
}
