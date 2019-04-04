package application;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TestXMLFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String xml = "<command><type>EODPositionExtraction</type><property>cob_dt</property><value>20190409</value></command>";
		xml = prettyFormat(xml, "2");
		System.out.println(xml);
	}

	public static String prettyFormat(String input, String indent) {
		Source xmlInput = new StreamSource(new StringReader(input));
		StringWriter stringWriter = new StringWriter();
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "no");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
			transformer.transform(xmlInput, new StreamResult(stringWriter));

			return stringWriter.toString().trim();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
