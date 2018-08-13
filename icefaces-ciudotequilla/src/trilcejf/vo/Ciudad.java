package trilcejf.vo;

import java.util.*;

public class Ciudad {

	private static final long serialVersionUID = 1L;
	private Long idCiudad;
	private String nombreCiudad;
	private List lugares;

	/**
	 * @return el lugares
	 */
	public List getLugares() {
		return lugares;
	}

	/**
	 * @param lugares el lugares a fijar
	 */
	public void setLugares(List lugares) {
		this.lugares = lugares;
	}

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

	public String toString() {
		return "[id=" + getIdCiudad() + ",nombre=" + getNombreCiudad() + "]";
	}
}
