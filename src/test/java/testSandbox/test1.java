package testSandbox;

import http.RemoteAdminTestHttp;

import java.util.ArrayList;

import util.Serializer;
import entity.Advertisement;
import entity.Content;
import entity.Field;
import entity.Item;
import entity.Modules;
import entity.Slot;
import entity.xml.Metatemplate;
import entity.xml.MetatemplateExport;

public class test1 {
	public static int idtSlot = 42;

	public static void main(String[] args) throws Exception {
		
		ArrayList<Slot> slots = new ArrayList<Slot>();
		
		
		for (int i = 1; i <= 3; i++) {
   		    String slotId = String.format("P%02d", i);
   		    idtSlot++;
   		    slots.add(createSlot(slotId, idtSlot+""));
		}
		
		MetatemplateExport export1 = new MetatemplateExport();
		export1.setTitle("Home UOL");
		export1.setUrl("http://www.uol.com.br");
		export1.setTemplate("/br/com/uol/admanager/PROD/tpl/barra-uol.tpl");
		export1.setPath("/br/com/uol/www/2013/corpo-esquerda-ecommerce.inc");
		export1.setMedia("webpage");
		export1.setEncoding("utf-8");

		MetatemplateExport export2 = new MetatemplateExport();
		export2.setTitle("Home UOL Intranet");
		export2.setUrl("http://home2013.uol.intranet");
		export2.setTemplate("/br/com/uol/admanager/PROD/tpl/barra-uol.tpl");
		export2.setPath("/br/com/uol/intranet/home2013.uol.intranet/2013/corpo-esquerda-ecommerce.inc");
		export2.setMedia("webpage"); 
		export2.setEncoding("utf-8");
		
		ArrayList<MetatemplateExport> exports = new ArrayList<>();
		exports.add(export1);
		exports.add(export2);
		
		Metatemplate metatemplate = new Metatemplate();
		metatemplate.setBase("/br/com/uol/admanager");
		metatemplate.setMedia("webpage");
		metatemplate.setSlots(slots);
		metatemplate.setExports(exports);
		
		ArrayList<Modules> modules = new ArrayList<>();
		Modules modules1 = new Modules();
		modules1.setId("schedule");
		modules1.setTitle("Agendamento");
		modules1.setType("schedule");
		
		Modules modules2 = new Modules();
		modules2.setId("information");
		modules2.setTitle("Informações");
		modules2.setType("information");
		
		modules.add(modules1);
		modules.add(modules2);
		
		metatemplate.setModules(modules);
		
		System.out.println(Serializer.toXml(metatemplate, "iso-8859-1"));
		
		createRemoteFile(Serializer.toXml(metatemplate, "iso-8859-1"));
		
	}

	
	public static void createRemoteFile(String content) throws Exception{
	
		String filepath = "/tmp/wmonaco.xml";
		
		final String echoThanGzipCmd = String.format("echo '%1$s' > %2$s", content, filepath);
		try {
       	 RemoteAdminTestHttp.shell(echoThanGzipCmd);
       } catch (Exception e) {
           System.err.println("erro ao invocar o comando: " + echoThanGzipCmd);
           throw e;
       }
		
	}



	
	private static Slot createSlot(String id, String idtSlot) {
		Slot slot = new Slot(idtSlot);
		slot.setId(id);
		slot.setTitle("Anuncios do slot "+ id);
		
		ArrayList<Advertisement> advList = new ArrayList<>();
		
		for (int i = 1; i < 6; i++) {
			advList.add(createAdv(i+""));
		}
		advList.add(createGroupConfig(idtSlot));
		slot.setAdvertisements(advList);

		return slot;
	}
	
	
	
	private static Advertisement createAdv(String id) {
		Advertisement adv = new Advertisement();
		adv.setGroupId("anuncio-"+id);
		adv.setTitleAd("Anuncio-"+id);
		
		Field field1 = createField("idtAdvertisement", "Identificador do anúncio", "47688");
		adv.getFields().add(field1);

		Field field2 = createField("title", "Título do anúncio",  "wteste222222222");
		adv.getFields().add(field2);
		
	    Field field3 = createField("description", "Descrição do anúncio", "wteste222222222");
	    adv.getFields().add(field3);
	    
	    Field field4 = createField("highlight", "Destaque", "$ad.highlight");
	    adv.getFields().add(field4);

	    Field field5 = createField("url", "Link", "http://click.publicidade.uol.com.br/click?ty=2&ch=1&s=P01&ad=47688" +
												"&c=169&sa=19627&dt=25112013&redir=http://www.uol.com.br");
	    
	    adv.getFields().add(field5);

	    Field field6 = createField("urlOptional", "Contador de Impressao do Cliente", "");
	    adv.getFields().add(field6);

	    Field field7 = createField("urlImg", "Imagem", "http://imguol.com/admanager/1311/ads/169/47688.gif");
	    adv.getFields().add(field7);

	    Field field8 = createField("idtSale", "Venda", "19627");
	    adv.getFields().add(field8);
		return adv;
	}

	private static Advertisement createGroupConfig(String idtSlot) {
		Advertisement adv = new Advertisement();
		adv.setGroupId("config");
		adv.setTitleAd("Configurações");
		
		Field field = createField("idtSlot", "Identificador do slot", idtSlot);
		adv.getFields().add(field);
		return adv;
	}
	
	private static Field createField(String id, String title, String contentValue) {
		Item item = new Item();
		item.setType("required");
		
		Content content = new Content();
		content.setType("text");
		content.setContent(contentValue);
		
		
		Field field1 = new Field();
		field1.setContent(content);
		field1.setId(id);
		field1.setTitle(title);
		field1.getValidationItems().add(item);
		
		if (id.toLowerCase().indexOf("url")>=0){
		    Item itemUrl = new Item();
		    itemUrl.setType("url");
		    field1.getValidationItems().add(itemUrl);
		}
		
		if (id.toLowerCase().indexOf("urlimg")>=0){
		    Item itemHelper = new Item();
		    itemHelper.setType("view");
		    field1.getHelpers().add(itemHelper);
		}
		
		return field1;
	}

}
