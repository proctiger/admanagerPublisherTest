package entity.xml;

import java.util.ArrayList;

public class FactoryMetatemplateExport {
	
	public static ArrayList<MetatemplateExport> getMetatemplateExportList() {
		ArrayList<MetatemplateExport> metaTemplateExportList = new ArrayList<MetatemplateExport>();
		
		String title 	=    "Home UOL"											;
		String url      =    "http://www.uol.com.br"							;
		String template =    "/br/com/uol/admanager/PROD/tpl/barra-uol.tpl"		;
		String path     =    "/br/com/uol/www/2013/corpo-esquerda-ecommerce.inc";
		String media    =    "webpage"											;
		String encoding =    "utf-8"											    ;
		metaTemplateExportList.add(new MetatemplateExport(title, url, template, path, media,encoding));
		
		
		title 	=      "Home UOL Intranet";																 
		url      =     "http://home2013.uol.intranet";													
		template =     "/br/com/uol/admanager/PROD/tpl/barra-uol.tpl";									
		path     =     "/br/com/uol/intranet/home2013.uol.intranet/2013/corpo-esquerda-ecommerce.inc";
		media    =     "webpage";																		
		encoding =     "utf-8";																			
		metaTemplateExportList.add(new MetatemplateExport(title, url, template, path, media,encoding));
		
		return metaTemplateExportList;
	}
	
}
