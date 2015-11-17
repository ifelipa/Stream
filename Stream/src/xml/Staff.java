package xml;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Company_Staff") 
public class Staff {
	
	@XmlElement(name="Pencaire",type = Empleat.class)
	private ArrayList<Empleat> currantes = new ArrayList<Empleat>();
	
	public void add(Empleat e) {
		currantes.add(e);
	}
	public ArrayList<Empleat> getCurrantes() {
		return currantes;
	}

	public void setCurrantes(ArrayList<Empleat> currantes) {
		this.currantes = currantes;
	}

	public Staff(ArrayList<Empleat> currantes) {
		super();
		this.currantes = currantes;
	}

	public Staff() {
		super();
	}

}
