package entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="header")
@XmlType(propOrder={"portal", "station", "channel", "title", "keywords", "priority", "author", "sourcepath", "externalId"})
public class MetatemplateHeader {
	String portal 		= 	"UOL";
	String station 		=	"Home";
	String channel		= 	"Admanager";
	String title		=	"Barra UOL";	
	String keywords 	= 	"";
	String priority		= 	"0.9";
	String author		=	"";
	String sourcepath	= 	"/br/com/uol/admanager/PROD/xml/barra-uol.xml";
	String externalId	=	"trancoso-1-2-102591";
	
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSourcepath() {
		return sourcepath;
	}
	public void setSourcepath(String sourcepath) {
		this.sourcepath = sourcepath;
	}
	
	@XmlElement(name="external-id")
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
}
