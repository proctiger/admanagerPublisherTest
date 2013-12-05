package testSandbox;

import http.PublisherHttpRequest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import uol.simple.httpclient.SimpleHttpResponse;
import util.Serializer;
import entity.Advertisement;
import entity.Field;
import entity.Slot;
import entity.xml.FactoryAdvertisement;
import entity.xml.FactoryField;
import entity.xml.FactoryMetatemplateExport;
import entity.xml.FactoryModules;
import entity.xml.FactorySlots;
import entity.xml.Metatemplate;

public class test3 {
	static int idtSlot = 41;

	public static void main(String[] args) throws Exception {
		//cria Fields
		ArrayList<Field> fields = new ArrayList<>();
		fields.add(FactoryField.createField("idtAdvertisement", "Identificador do anúncio", "47688"));
		fields.add(FactoryField.createField("title", "Título do anúncio",  "wteste222222222"));
		fields.add(FactoryField.createField("description", "Descrição do anúncio", "wteste222222222"));
		fields.add(FactoryField.createField("highlight", "Destaque", "$ad.highlight"));
		fields.add(FactoryField.createField("url", "Link", "http://click.publicidade.uol.com.br/click?ty=2&ch=1&s=P01&ad=xxxx" +
												"&c=169&sa=19627&dt=25112013&redir=http://www.uol.com.br"));
		fields.add(FactoryField.createField("urlOptional", "Contador de Impressao do Cliente", ""));
		fields.add(FactoryField.createField("urlImg", "Imagem", "http://imguol.com/admanager/1309/ads/35/47490.gif'"));
		fields.add(FactoryField.createField("idtSale", "Venda", "19627"));
		
		//cria Advertisements		
		ArrayList<Advertisement> advList = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			advList.add(FactoryAdvertisement.createAdv(i, fields));
		}
		

		//cria Slots
		int idtSlot = 42;
		ArrayList<Slot> slots = new ArrayList<Slot>();
		for (int i = 1; i <= 13; i++) {
   		    idtSlot++;
   		    slots.add(FactorySlots.createSlot(String.format("P%02d", i), idtSlot+"", fields));
		}
		
		FactoryMetatemplateExport.getMetatemplateExportList();
		
//		MetatemplateExport export1 = getMetatemplateExport1();
//		MetatemplateExport export2 = getMetatemplateExport2();
//		
//		ArrayList<MetatemplateExport> exports = new ArrayList<>();
//		exports.add(export1);
//		exports.add(export2);

		
		
		Metatemplate metatemplate = new Metatemplate();
		metatemplate.setBase("/br/com/uol/admanager");
		metatemplate.setMedia("webpage");
		metatemplate.setSlots(slots);
		
		
		metatemplate.setExports(FactoryMetatemplateExport.getMetatemplateExportList());
		
//		ArrayList<Modules> modules = new ArrayList<>();
//		modules.add(new Modules("schedule", "Agendamento", "schedule"));
//		modules.add(new Modules("information", "Informações", "information"));		
//		
		metatemplate.setModules(FactoryModules.getModules());
		
		System.out.println(Serializer.toXml(metatemplate, "iso-8859-1"));
		
		createLocalFile(Serializer.toXml(metatemplate, "iso-8859-1"));
		
		SimpleHttpResponse publishXml = PublisherHttpRequest.publishXml(Serializer.toXml(metatemplate, "iso-8859-1"));
		
		System.out.println(publishXml.getBodyAsString());
		System.out.println(publishXml.getStatusCode());
	}

//
//	private static MetatemplateExport getMetatemplateExport2() {
//		MetatemplateExport export2 = new MetatemplateExport();
//		export2.setTitle("Home UOL Intranet");
//		export2.setUrl("http://home2013.uol.intranet");
//		export2.setTemplate("/br/com/uol/admanager/PROD/tpl/barra-uol.tpl");
//		export2.setPath("/br/com/uol/intranet/home2013.uol.intranet/2013/corpo-esquerda-ecommerce.inc");
//		export2.setMedia("webpage"); 
//		export2.setEncoding("utf-8");
//		return export2;
//	}


//	private static MetatemplateExport getMetatemplateExport1() {
//		MetatemplateExport export1 = new MetatemplateExport();
//		export1.setTitle("Home UOL");
//		export1.setUrl("http://www.uol.com.br");
//		export1.setTemplate("/br/com/uol/admanager/PROD/tpl/barra-uol.tpl");
//		export1.setPath("/br/com/uol/www/2013/corpo-esquerda-ecommerce.inc");
//		export1.setMedia("webpage");
//		export1.setEncoding("utf-8");
//		return export1;
//	}

	
//	public static void createRemoteFile(String content) throws Exception{
//	
//		String filepath = "/tmp/wmonaco.xml";
//		
//		final String echoThanGzipCmd = String.format("echo '%1$s' > %2$s", content, filepath);
//		try {
//       	 RemoteAdminTestHttp.shell(echoThanGzipCmd);
//       } catch (Exception e) {
//           System.err.println("erro ao invocar o comando: " + echoThanGzipCmd);
//           throw e;
//       }
//		
//	}

   public static void createLocalFile(String xml) throws IOException{
	   try{
		   File file = new File("/tmp/wmonaco.xml");
		   FileWriter fstream = new FileWriter(file.toString());
		   BufferedWriter out = new BufferedWriter(fstream);
		   out.write(xml);
		   out.close();
   		}catch (Exception e){
   			System.err.println("Error: " + e.getMessage());
	   }
   }

	
//	private static Slot createSlot(String id, String idtSlot, List<Field> fields, ArrayList<Advertisement> advList) {
//		Slot slot = new Slot(idtSlot);
//		slot.setId(id);
//		slot.setTitle("Anuncios do slot "+ id);
//		slot.setAdvertisements(advList);
//		slot.setGroup(createGroupConfig(idtSlot));
//
//		return slot;
//	}
	
//	private static Advertisement createAdv(int id) {
//		Advertisement adv = new Advertisement();
//
//		adv.setGroupId(String.format("anuncio-"+ "%02d", id));
//		adv.setTitleAd(String.format("Anúncio %02d", id));
//		
//		Field field1 = FactoryField.createField("idtAdvertisement", "Identificador do anúncio", "47688");
//		Field field2 = FactoryField.createField("title", "Título do anúncio",  "wteste222222222");
//		Field field3 = FactoryField.createField("description", "Descrição do anúncio", "wteste222222222");
//		Field field4 = FactoryField.createField("highlight", "Destaque", "$ad.highlight");
//		Field field5 = FactoryField.createField("url", "Link", "http://click.publicidade.uol.com.br/click?ty=2&ch=1&s=P01&ad=xxxx" +
//												"&c=169&sa=19627&dt=25112013&redir=http://www.uol.com.br");
//		Field field6 = FactoryField.createField("urlOptional", "Contador de Impressao do Cliente", "");
//		Field field7 = FactoryField.createField("urlImg", "Imagem", "http://imguol.com/admanager/1309/ads/35/47490.gif'");
//		Field field8 = FactoryField.createField("idtSale", "Venda", "19627");
//		
//		adv.getFields().add(field1);
//		adv.getFields().add(field2);
//	    adv.getFields().add(field3);
//	    adv.getFields().add(field4);
//	    adv.getFields().add(field5);
//	    adv.getFields().add(field6);
//	    adv.getFields().add(field7);
//	    adv.getFields().add(field8);
//	    
//		return adv;
//	}

	private static Advertisement createGroupConfig(String idtSlot) {
		Advertisement adv = new Advertisement();
		adv.setGroupId("config");
		adv.setTitleAd("Configurações");
		
		Field field = FactoryField.createField("idtSlot", "Identificador do slot", idtSlot);
		adv.getFields().add(field);
		return adv;
	}
	

//	private static Group createGroupConfig(String idtSlot) {
//		Group group = new Group();
//		group.setGroupId("config");
//		group.setTitle("Configurações");
//		
//		Field field = FactoryField.createField("idtSlot", "Identificador do slot", idtSlot);
//		group.getFields().add(field);
//		return group;
//	}

	
}
