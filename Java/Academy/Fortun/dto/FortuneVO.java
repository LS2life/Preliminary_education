package dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//+
public class FortuneVO implements Serializable{
	//+
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String fortuneStr;
	private LocalDateTime localDateTime;
	private String localDateFormat;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFortuneStr() {
		return fortuneStr;
	}
	public void setFortuneStr(String fortuneStr) {
		this.fortuneStr = fortuneStr;
	}
	
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
		setLocalDateFormat();
	}
	public String getLocalDateFormat() {
		return localDateFormat;
	}
	public void setLocalDateFormat() {
		this.localDateFormat = 
				this.localDateTime.format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	@Override
	public String toString() {
		return "FortuneVO [id=" + id + ", name=" 
				+ name + ", fortuneStr=" + fortuneStr + ", localDateTime="
				+ localDateTime + ", localDateFormat=" + localDateFormat + "]";
	}
	public String getEmptyName() {
		return "FortuneVO [id=" + id + ", name=" + name 
				+ ", fortuneStr=" + fortuneStr + ", localDateTime="
				+ localDateTime + ", localDateFormat=" + localDateFormat + "]";
	}

}
