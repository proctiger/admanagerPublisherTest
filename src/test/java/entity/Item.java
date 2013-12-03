package entity;

import javax.xml.bind.annotation.XmlAttribute;

public class Item {

	private String type;

	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
