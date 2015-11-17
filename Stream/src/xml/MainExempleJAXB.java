package xml;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.*;

public class MainExempleJAXB {

	private static final String NOM_FIXTER = "exemple.xml";

	public static void main(String[] args) {
		/*
		 * EXPLICACION
		 * 
		 * JAXB usaremos las ANNOTATIONS (overraide, @suppress.warning)
		 * 
		 * @ xml root element
		 * 
		 * @ xml type lo que hace es de tipo a esquema
		 * 
		 * @ xml Transient (no se escribe en xml)
		 * 
		 * @ xml attribute
		 * 
		 * @ xml element (name="xxx") documentacion https://jaxb.java.net/
		 * 
		 * 
		 * marshall es de objecto java a xml unmarshall es xml a objeto java
		 */

		Empleat currito = new Empleat(133, "home", 40, "Xavi", "Big Boss", "P@ssWord");

		try {
			ObjecteXML(currito);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ObjecteXML(Empleat currante) {
		
		//context clase que acaba conviertiendo en xml
		
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);			
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(currante, new File(NOM_FIXTER));
			
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
