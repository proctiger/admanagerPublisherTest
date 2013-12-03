package entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author cin_wrodrigues
 *
 */

@XmlRootElement(name="group")
public class Advertisement {
	
	private String groupId;
	private String titleAd;
	private List<Field> fields = new ArrayList<>();
	
	@XmlAttribute(name="id")
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@XmlAttribute(name="title")
	public String getTitleAd() {
		return titleAd;
	}
	public void setTitleAd(String titleAd) {
		this.titleAd = titleAd;
	}

	@XmlElement(name="field")
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}