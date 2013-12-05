package entity.xml;

import java.util.ArrayList;

import entity.Advertisement;
import entity.Field;
import entity.Slot;

public class FactorySlots {

	public static Slot createSlot(String id, String idtSlot, ArrayList<Field> fields) {
		Slot slot = new Slot(idtSlot);
		slot.setId(id);
		slot.setTitle("Anuncios do slot "+ id);

		ArrayList<Advertisement> advList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			advList.add(FactoryAdvertisement.createAdv(i, fields));
		}
		advList.add(FactoryAdvertisement.createSlotGroup(idtSlot));
		slot.setAdvertisements(advList);

		return slot;
	}

//	public static Slot createSlot(String id, String idtSlot, ArrayList<Field> fields, ArrayList<Advertisement> advList) {
//		Slot slot = new Slot(idtSlot);
//		slot.setId(id);
//		slot.setTitle("Anuncios do slot "+ id);
//		slot.setAdvertisements(advList);
//
//		return slot;
//	}

}
