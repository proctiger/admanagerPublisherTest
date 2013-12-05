package entity.xml;

import java.util.List;

import entity.Advertisement;
import entity.Field;

public class FactoryAdvertisement {

	public static Advertisement createAdv(int id , List<Field> fields) {
		Advertisement adv = new Advertisement();

		adv.setGroupId(String.format("anuncio-"+ "%02d", id));
		adv.setTitleAd(String.format("Anúncio %02d", id));
		adv.setFields(fields);

		return adv;
	}

	public static Advertisement createSlotGroup(String idtSlot) {
		Advertisement adv = new Advertisement();
		adv.setGroupId("config");
		adv.setTitleAd("Configurações");

		Field field = FactoryField.createField("idtSlot", "Identificador do slot", idtSlot);
		adv.getFields().add(field);
		return adv;
	}

}
