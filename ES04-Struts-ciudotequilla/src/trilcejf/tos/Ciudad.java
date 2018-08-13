package trilcejf.tos;

import java.util.*;


public class Ciudad {

	private static final long serialVersionUID = 1L;
	private Long idCiudad;
	private String nombreCiudad;
	
	public Ciudad() {}

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

	public Map getParametrosUrl(){
		Map parametros = new HashMap();
		parametros.put("idCiudad", this.idCiudad.toString());
		parametros.put("nombreCiudad", this.nombreCiudad);
		return parametros;
	}

	public String toString() {
		return "[id=" + getIdCiudad() + ",nombre=" + getNombreCiudad() + "]";
	}
}
