package entity.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import entity.Modules;
import entity.Slot;


@XmlRootElement(name="meta-template")
@XmlType(propOrder={"header","exports", "slots", "modules"})
public class Metatemplate {
	
	String base;
	String media;
	MetatemplateHeader header =  new MetatemplateHeader();
	private ArrayList<MetatemplateExport> exports = new ArrayList<>();
	private ArrayList<Slot> slots = new ArrayList<>();
	private ArrayList<Modules> modules = new ArrayList<>();
	
	@XmlAttribute
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	@XmlAttribute
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	@XmlElementWrapper(name="modules")
	@XmlElement(name="module")
	public ArrayList<Slot> getSlots() {
		return slots;
	}
	public void setSlots(ArrayList<Slot> slots) {
		this.slots = slots;
	}
	
	@XmlElement(name="header")
	public MetatemplateHeader getHeader() {
		return header;
	}
	public void setHeader(MetatemplateHeader header) {
		this.header = header;
	}
	
	@XmlElementWrapper(name="exports")
	@XmlElement(name="export")
	public ArrayList<MetatemplateExport> getExports() {
		return exports;
	}
	public void setExports(ArrayList<MetatemplateExport> exports) {
		this.exports = exports;
	}

	@XmlElement(name="module")
	public ArrayList<Modules> getModules() {
		return modules;
	}
	public void setModules(ArrayList<Modules> modules) {
		this.modules = modules;
	}

		
	
}
