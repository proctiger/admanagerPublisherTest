package entity.xml;

import java.util.ArrayList;

import entity.Modules;

public class FactoryModules {

	public static Modules createModule(String id, String title, String type){
		return (new Modules(id,title,type));
	}
	
	public static ArrayList<Modules> getModules(){
		ArrayList<Modules> modulesList = new ArrayList<>();
		modulesList.add(new Modules("schedule", "Agendamento", "schedule"));
		modulesList.add(new Modules("information", "Informações", "information"));	
				
		return modulesList;
	}

}
