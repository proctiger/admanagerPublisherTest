package entity.xml;

import java.util.ArrayList;

import entity.Advertisement;
import entity.Field;
import entity.Group;
import entity.Slot;

public class FactorySlots {

	public static Slot createSlot(String id, String idtSlot, ArrayList<Field> fields, ArrayList<Advertisement> advList) {
		Slot slot = new Slot(idtSlot);
		slot.setId(id);
		slot.setTitle("Anuncios do slot "+ id);
		slot.setAdvertisements(advList);
		slot.setGroup(createGroupConfig(idtSlot));

		return slot;
	}

	private static Group createGroupConfig(String idtSlot) {
		Group group = new Group();
		group.setGroupId("config");
		group.setTitle("Configurações");

		Field field = FactoryField.createField("idtSlot", "Identificador do slot", idtSlot);
		group.getFields().add(field);
		return group;
	}

}
