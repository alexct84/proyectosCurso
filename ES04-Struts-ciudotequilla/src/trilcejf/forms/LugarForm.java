package trilcejf.forms;

import org.apache.struts.action.ActionForm;

public class LugarForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private Long idLugar;
	private String nombreLugar;
	private Long ciudadId;

	public Long getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	
	public Long getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
	}
	
	public String toString() {
		return "[idLugar=" + getIdLugar() + ",nombreLugar=" + getNombreLugar() + ",ciudadId=" + getCiudadId() + "]";
	}
}
