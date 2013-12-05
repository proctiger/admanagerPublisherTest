package entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="module")
@XmlType(propOrder={"advertisements", "group"})
public class Slot {
	String id;
	String title;
	String idtSlot;
	private List<Advertisement> advertisements = new ArrayList<>();
	Group group;
	
	public Slot(){
		
	}
	
	public Slot(String idtSlot){
		this.idtSlot = idtSlot;
	}
	
	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name="group")
	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}
	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	
	@XmlElement(name="groupConfigSlot")
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
