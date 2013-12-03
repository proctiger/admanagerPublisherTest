package util;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Serializer {

    public static <T> String toXml(T arg) throws JAXBException {
        Marshaller marshaller = JAXBContext.newInstance(arg.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, System.getProperty("file.encoding"));
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        StringWriter writer = new StringWriter();
        marshaller.marshal(arg, writer);
        return writer.toString();
    }

    public static <T> String toXml(T arg, String encoding) throws JAXBException {
        Marshaller marshaller = JAXBContext.newInstance(arg.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        StringWriter writer = new StringWriter();
        marshaller.marshal(arg, writer);
        return writer.toString();
    }

    public static <T> T fromXml(String xml, Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
        StringReader reader = new StringReader(xml);

        @SuppressWarnings("unchecked")
        T entity = (T) unmarshaller.unmarshal(reader);
        return entity;
    }

    public static <T> T fromXml(InputStream is, Class<T> clazz) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
        @SuppressWarnings("unchecked")
        T entity = (T) unmarshaller.unmarshal(is);
        return entity;
    }
}
