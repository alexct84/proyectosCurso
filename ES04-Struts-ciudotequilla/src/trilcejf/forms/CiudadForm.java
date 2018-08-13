package trilcejf.forms;

import org.apache.struts.action.ActionForm;

public class CiudadForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private Long idCiudad;
	private String nombreCiudad;

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	public String toString() {
		return "[idCiudad=" + getIdCiudad() + ",nombreCiudad=" + getNombreCiudad() + "]";
	}
}
