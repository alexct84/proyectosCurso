package trilcejf.pojos;

import java.util.*;
import java.sql.*;

import javax.sql.DataSource;

import trilcejf.tos.*;


/**
 * POJO con métodos de negocio para gestionar operaciones de listado en BD.
 * 
 * @author Javatos Monzoneros
 */
public class InformacionCiudades{

	/**
	 * Un solo objeto DataSource compartido por todos los hilos asoc
	 * a todas las peticiones. Es de hilo seguro, por construcción.
	 * Creado al levantar el server como consecuencia
	 * del evento inicializar el contexto de la aplicación.
	 * Definido como atributo de contexto para que sea accesible a
	 * todos los componentes web
	 */
	private DataSource ds;
	
	/**
	 * Una conexión por cada usuario
	 * Definida como var de instancia pues nunca van a darse problemas de
	 * concurrencia en la ejecución de los métodos del POJO
	 */
	private Connection con;
	
	public InformacionCiudades(DataSource ds){
		this.ds = ds; 
	}
	
	/**
     * Obtiene la lista de lugares de visita obligada para una ciudad
     * @param ciudad informado con el nombre de la ciudad
     * @return List lista con los lugares de visita obligada
     * @throws SQLException
     */
	public List getVisitasObligadas(Ciudad ciudad)throws SQLException {
		List visitasOblig = new ArrayList();
			
		// Obtener una conexión del pool mediante el datasource
		con = ds.getConnection();
		
		// En SQL de MySQL (no compatible con el estándar SQL ANSI 92)
		String sentenciaSQL = "SELECT id_lugar , nombre_lugar, ciudad_id FROM lugares AS lug JOIN ciudades AS ciu " +
								"ON ciu.id_ciudad = lug.ciudad_id WHERE ciu.nombre_ciudad = ?";
				
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1,ciudad.getNombreCiudad());
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Lugar lugar = new Lugar();
			lugar.setIdLugar(new Long(rs.getInt("id_lugar")));
			lugar.setNombreLugar(rs.getString("nombre_lugar"));
			lugar.setCiudadId(new Long(rs.getInt("ciudad_id")));
			visitasOblig.add(lugar);
		}
		cerrarConexion();
		return visitasOblig;
	}
	
	/**
     * Obtiene la lista de ciudades
     * @return List lista con objetos Ciudad
     * @throws SQLException
     */
	public List getCiudades()throws SQLException {
		
		List ciudades = new ArrayList();
		
		con = ds.getConnection();
		String sentenciaSQL = "SELECT id_ciudad,nombre_ciudad FROM ciudades";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Ciudad ciudad = new Ciudad();
			ciudad.setIdCiudad(new Long(rs.getInt("id_ciudad")));
			ciudad.setNombreCiudad(rs.getString("nombre_ciudad"));
			ciudades.add(ciudad);
		}
		cerrarConexion();
		return ciudades;
	}
	
	/**
	 * Recibe el objeto Ciudad informado con el id y lo dev informado con todas sus props.
	 * @param ciudad Objeto ciudad informado solo con idCiudad
	 * @return objeto Ciudad informado con el id y el nombre de la ciudad
	 * @throws SQLException
	 */
	public Ciudad getCiudad(Long id)throws SQLException{
		
		con = ds.getConnection();
		
		Ciudad ciudad=new Ciudad();
		
		String sentenciaSQL="SELECT * FROM ciudades WHERE id_ciudad=?;";
		PreparedStatement pstmt = con.prepareStatement(sentenciaSQL);
		pstmt.setLong(1, id);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			ciudad.setIdCiudad(rs.getLong("id_ciudad"));
			ciudad.setNombreCiudad(rs.getString("nombre_ciudad"));
		}
		
		cerrarConexion();

		return ciudad;
	}
	
	/**
	 * Crea una ciudad insertando en la Base de Datos el nombre de la ciudad
	 * @param ciudad, objeto Ciudad informado con el nombre de la ciudad
	 * @throws SQLException
	 */
	public void crear(Ciudad ciudad)throws SQLException {
		
		
		// Obtener una conexión del pool mediante el datasource
		con = ds.getConnection();
			
		//Ejecución de la sentencia SQL y obtención de resultados en un objeto ResultSet
		String sentenciaSQL="INSERT INTO ciudades(nombre_ciudad) VALUES (?);";
		PreparedStatement ps=con.prepareStatement(sentenciaSQL);
		ps.setString(1, ciudad.getNombreCiudad());
		ps.executeUpdate();
		cerrarConexion();
	}
	
	/**
	 * Usado para comprobar si una ciudad ya existe en los casos de uso crear y modificar ciudad.
	 * @param ciudad Objeto ciudad informado solo con idCiudad
	 * @return boolean true si no existe la ciudad; false en caso contrario
	 * @throws SQLException
	 */
	public boolean validar(Ciudad ciudad)throws SQLException {
		boolean ciudadExiste=false;
		con = ds.getConnection();
		
		// Con esta consulta detecto si la ciudad q quiero crear ya existe.
		// No la puedo gestionar como se hace en crearCuenta porque nombre_ciudad no es PrimaryKey
		// asi q no me comprueba si se repite o no
		String sentenciaSQL = "SELECT nombre_ciudad FROM ciudades WHERE nombre_ciudad=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1, ciudad.getNombreCiudad());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ciudadExiste=true;
		}
		cerrarConexion();
		return ciudadExiste;
	}
	
	/**
	 * Permite modificar la ciudad que se le pasa en el objeto Ciudad
	 * @param ciudad, objeto ciudad informado con nombreCiudad y idCiudad
	 * @throws SQLException
	 */
	public void modificar(Ciudad ciudad)throws SQLException {
		
		// Obtener una conexión del pool mediante el datasource
		con = ds.getConnection();

		// Ejecución de la sentencia SQL y obtención de resultados en un objeto ResultSet
		String sentenciaSQL="UPDATE ciudades SET nombre_ciudad=? WHERE id_ciudad=?";
		PreparedStatement ps=con.prepareStatement(sentenciaSQL);
	
		// Valores de las sentencias precompiladas
		ps.setString(1, ciudad.getNombreCiudad());
		ps.setLong(2, ciudad.getIdCiudad());
		ps.executeUpdate();
		
		cerrarConexion();
	}

	/**
	 * Permite borrar una ciudad que exista en la BD.
	 * En la BD al borrar una ciudad se ha hecho que se borren todos sus lugares asociados mediante
	 * ON DELETE CASCADE
	 * @param ciudad, objeto informado con el nombre y el id de la ciudad.
	 * @throws SQLException
	 */
	
	public void borrar(Ciudad ciudad) throws SQLException{
		con = ds.getConnection();
		String sentenciaSQL = "DELETE FROM ciudades WHERE id_ciudad=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps = con.prepareStatement(sentenciaSQL);
		ps.setLong(1,ciudad.getIdCiudad());
		ps.executeUpdate();
		cerrarConexion();		
	}

	/**
     * Permite cerrar las conexiones 
     */
	public void cerrarConexion(){
		try {
			if(con != null && !con.isClosed()){
					con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}