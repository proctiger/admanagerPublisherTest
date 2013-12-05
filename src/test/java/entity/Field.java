package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"content", "validationItems", "helpers"})
public class Field {

	private String id; 
	private String title;
	private Content content;
	private ArrayList<Item> validationItems = new ArrayList<>();
	private ArrayList<Item> helpers = new ArrayList<>();
	
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
	
	@XmlElement
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	
	@XmlElementWrapper(name="validations")
	@XmlElement(name="item")
	public ArrayList<Item> getValidationItems() {
		return validationItems;
	}
	public void setValidationItems(ArrayList<Item> validationItems) {
		this.validationItems = validationItems;
	}
	
	@XmlElementWrapper(name="helpers")
	@XmlElement(name="item")
	public ArrayList<Item> getHelpers() {
		return helpers;
	}
	public void setHelpers(ArrayList<Item> helpers) {
		this.helpers = helpers;
	}
	
	
}
