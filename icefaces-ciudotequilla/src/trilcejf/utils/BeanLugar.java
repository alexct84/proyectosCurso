package trilcejf.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import trilcejf.delegate.ICiudadDelegate;
import trilcejf.delegate.ILugarDelegate;
import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;

public class BeanLugar {
	private String nombreLugar;
	private Long idLugar;
	private Lugar lugar = new Lugar();
	private Ciudad ciudad = new Ciudad();
	private Long idCiudad;

	private List lugares = new ArrayList();

	ILugarDelegate lug =(ILugarDelegate) ServiceFinder.findBean("lugarDelegate");
	ICiudadDelegate ciu =(ICiudadDelegate) ServiceFinder.findBean("ciudadDelegate");


	/**
	 * @return el lugares
	 */
	public List getLugares() {
		return lug.findByExample(ciudad, lugar);
	}

	/**
	 * @param lugares el lugares a fijar
	 */
	public void setLugares(List lugares) {
		this.lugares = lugares;
	}

	public String paramCrear(){

		ciudad.setIdCiudad(idCiudad);
		return "crearLugar";
	}

	public String paramEditar(){
		// Informar la ciudad asociada al link con su id
		lugar.setIdLugar(idLugar);
		// Obtener ciudad con todas sus props informadas
		lugar = lug.loadById(lugar);

		return "editarLugar";
	}

	public String paramBorrar(){

		// Informar la ciudad asociada al link con su id
		lugar.setIdLugar(idLugar);

		// Obtener ciudad con todas sus props informadas
		lugar = lug.loadById(lugar);

		return "borrarLugar";
	}

	public String volver(){
		// Si ciudad esta informada con el id obtener todas sus propiedades informadas
		if(ciudad.getIdCiudad() != null){
			ciudad = ciu.loadById(ciudad);
		}
		else{
			// Obtener lugar con todas sus propiedades informadas
			lugar = lug.loadById(lugar);
			// Obtener el id de la ciudad asociada al lugar
			ciudad.setIdCiudad(lugar.getCiudad().getIdCiudad());
			// Obtener ciudad con todas sus propiedades informadas
			ciudad = ciu.loadById(ciudad);
		}

		// Obtener la lista de lugares de la ciudad
		lugares = ciudad.getLugares();
		return "volver";
	}

	// Tras la ejec d este metodo, ciudad esta informada con los lugares
	public String lugaresByCiudad(){
		String status="adminLugares";

		ciudad.setIdCiudad(idCiudad);
		ciudad = ciu.loadById(ciudad);

		return status;
	}

	public String create(){
		String status = "failure";
		ciudad = ciu.loadById(ciudad);

		lugar = lug.create(ciudad, lugar);
		System.out.println("-------------------------------------------------------");
		System.out.println(ciudad.getIdCiudad());
		System.out.println("-------------------------------------------------------");

		ciudad = ciu.loadById(ciudad);
		status = "success";
		return status;
	}

	public String update(){

		Lugar lugarNew=new Lugar();
		String status = "failure";
		lugarNew = lug.loadById(lugar);
		lugarNew.setCiudadId(lugarNew.getCiudad().getIdCiudad());
		lugarNew.setNombreLugar(lugar.getNombreLugar());
		lugar = lug.update(lugarNew);
		ciudad.setIdCiudad(lugar.getCiudad().getIdCiudad());
		ciudad = ciu.loadById(ciudad);
		status = "success";
		return status;
	}

	// La ciudad debe estar informada con todas sus props
	public String delete(){
		String status = "failure";

		lugar = lug.loadById(lugar);
		ciudad.setIdCiudad(lugar.getCiudad().getIdCiudad());
		lug.delete(lugar);
		ciudad = ciu.loadById(ciudad);
		status = "success";
		return status;
	}
	public String getNombreLugar() {
		return nombreLugar;
	}


	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}


	public Long getIdLugar() {
		return idLugar;
	}


	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	public Long getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}


	public ILugarDelegate getLug() {
		return lug;
	}


	public void setLug(ILugarDelegate lug) {
		this.lug = lug;
	}


	public ICiudadDelegate getCiu() {
		return ciu;
	}


	public void setCiu(ICiudadDelegate ciu) {
		this.ciu = ciu;
	}



}
