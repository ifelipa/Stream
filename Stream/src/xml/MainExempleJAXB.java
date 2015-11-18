package xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.xml.bind.*;

public class MainExempleJAXB {

	private static final String NOM_FIXTER = "exemple1.xml";

	private static final String NOM_FIXTER2 = "exemple2.xml";

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
		Empleat currito2 = new Empleat(134, "home", 41, "Chema", "Delegat", "P@ssWord");
		Empleat currito3 = new Empleat(135, "home", 23, "Marta", "Employed", "P@ssWord");
		Empleat currito4 = new Empleat(136, "dona", 21, "Karla", "Employed", "P@ssWord");
		

		try {
			//ObjecteXML(currito);
			
			//De xml a Objeto
//			Empleat curr = XMLObjecte();
//			System.out.println(curr.toString());
			
			// ArrayList<Empleat> myStaff = new ArrayList<Empleat>();
			Staff myStaff = new Staff();
				myStaff.add(currito);
				myStaff.add(currito2);
				myStaff.add(currito3);
				myStaff.add(currito4);

			//marshallLlista(myStaff,  new File("lliistaEmpleat.xml"));
			Staff myStaff2 = new Staff();
			myStaff2=carregaXMLLlista(new File("lliistaEmpleat.xml"));
			
			if (myStaff2 != null){
				for (Empleat e : myStaff2.currantes) {
					System.out.println(e);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	private static Staff carregaXMLLlista(File file) {
		
		try {
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			Unmarshaller um = contexte.createUnmarshaller();
			BufferedReader r = null;
			r = new BufferedReader(new FileReader(file));
			Staff st = (Staff) um.unmarshal(r);
			return st;
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}



	private static void marshallLlista(Staff myStaff, File file) {
		
		try {
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			BufferedWriter w = null;			
			w = new BufferedWriter(new FileWriter(file));

			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);	
			m.marshal(myStaff, w);
			w.close();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static Empleat XMLObjecte() {
		
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			Unmarshaller um = contexte.createUnmarshaller();
			Empleat currante = (Empleat) um.unmarshal(new File(NOM_FIXTER2));
			return currante;
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void ObjecteXML(Empleat currante) {
		
		//context clase que acaba conviertiendo en xml
		
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);			
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//m.marshal(currante, new File(NOM_FIXTER)); //Lo graba en un fichero
			m.marshal(currante,System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
