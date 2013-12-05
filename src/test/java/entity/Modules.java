package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="module")
public class Modules {
	String id;
	String title;
	String type;
	
	public Modules(){
	}
	
	public Modules(String id, String title, String type){
		this.setId(id);
		this.setTitle(title);
		this.setType(type);
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
