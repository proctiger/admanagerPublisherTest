package entity.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="export")
@XmlType(propOrder={"title", "url", "template", "path", "media", "encoding"})
public class MetatemplateExport {

	String title;
	String url;
	String template;
	String path;
	String media;
	String encoding;
	
	
	public MetatemplateExport() {
	}
	
	public MetatemplateExport(String title, String url, String template, String path, String media, String enconding) {
		this.setTitle(title);
		this.setUrl(url);
		this.setTemplate(template);
		this.setPath(path);
		this.setMedia(media);
		this.setEncoding(enconding);
	}

	
	@XmlAttribute
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlAttribute
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@XmlAttribute
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	
	@XmlAttribute
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@XmlAttribute
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	@XmlAttribute
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
}
