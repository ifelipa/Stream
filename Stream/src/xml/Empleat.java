package xml;
import javax.xml.bind.annotation.*;

//Con esto decimo que la clase no solo será un objeto xml sino parte de muchos objetos xml
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Treballador") // punto de la raiz
@XmlType (propOrder = {"id","nom", "carrec", "edat", "sexe", "password"}) //orden en el que se generara el xml
/*
 * <treballador>
 * 	<nom> --- </nom>
 * <carrec> --- </carrec>
 * <edat> --- </edat>
 * </treballador>
 */

public class Empleat {
	private int id;
	private String sexe;
	private int edat;
	private String nom;
	private String carrec;
	private String password;
	
	
	
	public Empleat(int id, String sexe, int edat, String nom, String carrec, String password) {
		super();
		this.id = id;
		this.sexe = sexe;
		this.edat = edat;
		this.nom = nom;
		this.carrec = carrec;
		this.password = password;
	}

	public Empleat() {
		super();
	}

	//@XmlAttribute
	public int getId() {
		return id;
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	//@XmlElement(name="genere")
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCarrec() {
		return carrec;
	}
	public void setCarrec(String carrec) {
		this.carrec = carrec;
	}
	@XmlTransient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrec == null) ? 0 : carrec.hashCode());
		result = prime * result + edat;
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Empleat [id=" + id + ", sexe=" + sexe + ", edat=" + edat + ", nom=" + nom + ", carrec=" + carrec
				+ ", password=" + password + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleat other = (Empleat) obj;
		if (carrec == null) {
			if (other.carrec != null)
				return false;
		} else if (!carrec.equals(other.carrec))
			return false;
		if (edat != other.edat)
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		return true;
	}
	
}
