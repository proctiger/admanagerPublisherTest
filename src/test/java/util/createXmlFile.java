package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createXmlFile {
	public static void createXMLFile(String xml) throws IOException{
		File file = new File("/home/cin_wrodrigues/wxmlTest.xml");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter output = new BufferedWriter(fileWriter);
		output.write(xml.toString());
		output.close();
	}
}
