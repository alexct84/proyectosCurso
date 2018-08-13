package trilcejf.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.sql.DataSource;

import trilcejf.delegate.ICiudadDelegate;
import trilcejf.delegate.ILugarDelegate;
import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;

public class BeanCiudad{
	private String nombreCiudad;

	// Realiza automaticamente la conversion automatica de String a Long, a la hora de capturar el parametro
	private Long idCiudad;
	private Ciudad ciudad = new Ciudad();
	private List ciudades = new ArrayList();
	private List ciudadesLista = new ArrayList();

	private ICiudadDelegate ciu =(ICiudadDelegate) ServiceFinder.findBean("ciudadDelegate");

	public String findCiudades(){
		String admin="adminCiudades";
		ciudades=ciu.findByExample(new Ciudad());
		return admin;
	}

	public void updateoTabla(){
		Iterator iter = ciudades.iterator();
		while (iter.hasNext()){
			Ciudad ciudadUpdate = (Ciudad) iter.next();
			ciu.update(ciudadUpdate);
		}
		findCiudades();
	}

	public String paramEditar(){
		// Informar la ciudad asociada al link con su id
		System.out.println("paramEditar");
		ciudad.setIdCiudad(idCiudad);
		// Obtener ciudad con todas sus props informadas
		ciudad = ciu.loadById(ciudad);

		return "editarCiudad";
	}

	public String paramBorrar(){

		// Informar la ciudad asociada al link con su id
		ciudad.setIdCiudad(idCiudad);

		// Obtener ciudad con todas sus props informadas
		ciudad = ciu.loadById(ciudad);

		return "borrarCiudad";
	}


	// Tras la ejec d este metodo, ciudad esta informada con los lugares
	public String lugaresByCiudad(){
		String status="buscarLugares";

		ciudad.setIdCiudad(idCiudad);
		ciudad = ciu.loadById(ciudad);

		return status;
	}

	public List getListaCiudades() {

		ciudades= ciu.findByExample(new Ciudad());
		System.out.println("Numero ciudades: " + ciudades.size());
		for (int i = 0; i < ciudades.size(); i++) {
			ciudadesLista.add(new SelectItem(((Ciudad)(ciudades.get(i))).getIdCiudad(),
											((Ciudad)ciudades.get(i)).getNombreCiudad().toUpperCase()));
		}
		return ciudadesLista;
	}

	public String create(){
		String status = "failure";

		try {
			ciudad = ciu.create(ciudad);
		} catch (Exception e) {
			// TODO Bloque catch auto-generado
			e.printStackTrace();
		}

		status = "success";
		return status;
	}

	public String update(){
		String status = "failure";

		ciudad = ciu.update(ciudad);

		status = "success";
		return status;
	}

	// La ciudad debe estar informada con todas sus props
	public String delete(){
		String status = "failure";

		//ciudad.setNombreCiudad(nombreCiudad);
		//Long idCiudadLong = Long.valueOf(idCiudad);
		//ciudad.setIdCiudad(idCiudadLong);
		ciudad = ciu.loadById(ciudad);
		ciu.delete(ciudad);

		status = "success";
		return status;
	}


	/**
	 * @return el nombreCiudad
	 */
	public String getNombreCiudad() {
		System.out.println("getNombreCiudad");
		System.out.println(nombreCiudad);
		return nombreCiudad;
	}

	/**
	 * @param nombreCiudad el nombreCiudad a fijar
	 */
	public void setNombreCiudad(String nombreCiu) {
		System.out.println("setNombreCiudad");
		System.out.println("nombreCiu: " + nombreCiu);
		System.out.println(nombreCiudad);
		nombreCiudad = nombreCiu;
		System.out.println(nombreCiudad);
	}

	/**
	 * @return el ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad el ciudad a fijar
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	/**
	 * @param ciudades el ciudades a fijar
	 */
	public void setCiudades(List ciudades) {
		this.ciudades = ciudades;
	}


	/**
	 * @return el ciudades
	 */
	public List getCiudades() {
		ciudades= ciu.findByExample(new Ciudad());
		return ciudades;
	}

	// Metodo alternativo sin hibernate
	/*public Result getTable() {
	    try {
	      Context context = new InitialContext();
	      DataSource dataSource =
	        (DataSource)context.lookup("jdbc:mysql://10.228.25.10:3306/ciudoteca");
	      Connection connection = dataSource.getConnection();
	      Statement statement = connection.createStatement();
	      String query = "SELECT * from ciudades";
	      ResultSet resultSet = statement.executeQuery(query);
	      return(ResultSupport.toResult(resultSet));
	    } catch(Exception e) { return(null); }
	  }*/


}


