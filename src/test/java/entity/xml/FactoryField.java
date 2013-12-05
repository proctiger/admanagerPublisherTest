package entity.xml;

import entity.Content;
import entity.Field;
import entity.Item;

public class FactoryField {
	public static Field createField(String id, String title, String contentValue) {
		Item item = new Item();
		item.setType("required");
		
		Content content = new Content();
		content.setType("text");
		content.setContent(contentValue);
		
		
		Field field = new Field();
		field.setContent(content);
		field.setId(id);
		field.setTitle(title);
		field.getValidationItems().add(item);
		
		if (id.toLowerCase().indexOf("url")>=0){
		    Item itemUrl = new Item();
		    itemUrl.setType("url");
		    field.getValidationItems().add(itemUrl);
		}
		
		if (id.toLowerCase().indexOf("urlimg")>=0){
		    Item itemHelper = new Item();
		    itemHelper.setType("view");
		    field.getHelpers().add(itemHelper);
		}
		
		return field;
	}
}
