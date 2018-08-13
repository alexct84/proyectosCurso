package trilcejf.tos;

import java.util.HashMap;
import java.util.Map;


public class Lugar {

	private static final long serialVersionUID = 1L;
	private Long idLugar;
	private String nombreLugar;
	private Long ciudadId; // Como es FK de tabla lugares respecto a tabla ciudades
						  // se usara para obtener la ciudad, dado un lugar. Ver met getCiudadByLugar de InformacionLugares
	
	public Lugar() {}
	
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

	public Map getParametrosUrl(){
		Map parametros = new HashMap();
		parametros.put("idLugar", this.idLugar.toString());
		parametros.put("nombreLugar", this.nombreLugar);
		parametros.put("ciudadId", this.ciudadId.toString());
		return parametros;
	}

	public String toString() {
		return "[id=" + getIdLugar() + ",nombre=" + getNombreLugar() + ",ciudadId=" + getCiudadId() + "]";
	}
}
