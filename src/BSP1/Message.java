package BSP1;

import java.time.LocalDateTime;

public abstract class Message {
	
	private String text;
	private LocalDateTime datetime;

	public Message(String text) {
		this.text = text;
		this.datetime = LocalDateTime.now();
	}

	public String getText() {
		return text;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}
}
