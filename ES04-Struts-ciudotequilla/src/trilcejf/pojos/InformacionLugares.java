package trilcejf.pojos;

import java.sql.*;

import javax.sql.DataSource;

import trilcejf.tos.*;

/**
 * Permite gestionar los lugares asociados a las ciudades
 *
 * @author Javatos Monzoneros
 */
public class InformacionLugares{
	/**
	 * Variables de istancia del dataSource y Connection que necesitaremos en todos los
	 * los metodos del POJO
	 */
	private DataSource ds;
	private Connection con;
	/**
	 * Constructor del objeto InformacionLugares
	 */
	public InformacionLugares(DataSource ds){
		this.ds = ds;
	}
	
	/**
     * Permite la creacion de los lugares asociados las ciudades.
     * @param ciudad es un objeto Ciudad informado con id_ciudad.
     * @param lugar es un objeto Lugar informado con el nombre del lugar
     * @throws SQLException
     */
	public void crearLugar (Ciudad ciudad, Lugar lugar)throws SQLException{
		
		con=ds.getConnection();
		String sentenciaPrecompiladaSQL = "INSERT INTO ciudoteca.lugares (nombre_lugar, ciudad_id) VALUES (?,?);";
		PreparedStatement ps = con.prepareStatement(sentenciaPrecompiladaSQL); 		
		ps.setString(1, lugar.getNombreLugar());
		ps.setLong(2, ciudad.getIdCiudad());
		ps.executeUpdate();
		cerrarConexion();
	}
	/**
     * Permite borrar los lugares.
     * @param lugar es un objeto Lugar informado con el id_lugar
     * @throws SQLException
     */
	public void borrarLugar (Lugar lugar)throws SQLException{
		
		con=ds.getConnection();
		
		String sentenciaPrecompiladaSQL = "DELETE FROM ciudoteca.lugares WHERE lugares.id_lugar=?";
		PreparedStatement ps = con.prepareStatement(sentenciaPrecompiladaSQL);
		ps.setLong(1, lugar.getIdLugar());
		
		ps.executeUpdate();													
	
		cerrarConexion();
	}
	
	/**
     * Devuelve la vista de un lugar en funcion de su id.
     * @param lugar es un objeto Lugar informado con el id_lugar
     * @return res es un String con el nombre del lugar
     * @throws SQLException
     */
	public Lugar getLugar (Lugar lugar)throws SQLException{
		con=ds.getConnection();
		Lugar lugarInformado=new Lugar();
		System.out.println("id lugar===== " + lugar.getIdLugar());
		String sentenciaPrecompiladaSQL = "SELECT * FROM lugares WHERE lugares.id_lugar=?";				
		PreparedStatement ps = con.prepareStatement(sentenciaPrecompiladaSQL);
		ps.setLong(1, lugar.getIdLugar());		
		ResultSet rs =ps.executeQuery();
		if(rs.next()){	
			lugarInformado.setNombreLugar(rs.getString("nombre_lugar"));
			lugarInformado.setIdLugar(rs.getLong("id_lugar"));
			lugarInformado.setCiudadId(rs.getLong("ciudad_id"));
		}
		cerrarConexion();
		return lugarInformado;
	}
	
	public Ciudad getCiudadByLugar(Lugar lugar)throws SQLException{
		Ciudad ciudad = null;
		con=ds.getConnection();
		String sentenciaPrecompiladaSQL = "SELECT id_ciudad, nombre_ciudad FROM ciudades WHERE id_ciudad = ?";		
		PreparedStatement ps = con.prepareStatement(sentenciaPrecompiladaSQL);
		
		ps.setLong(1, lugar.getCiudadId());		
		ResultSet rs =ps.executeQuery();
		if(rs.next()){
			ciudad = new Ciudad();
			ciudad.setIdCiudad(rs.getLong(("id_ciudad")));
			ciudad.setNombreCiudad(rs.getString("nombre_ciudad"));
		}
		cerrarConexion();
		return ciudad;
	}
	
	/**
     * Permite modificar un lugar ya existente.
     * @param lugarNuevo es un objeto Lugar informado con el nombre del nuevo lugar
     * @param lugarViejo es un objeto Lugar informado con el id_lugar del lugar a modificar
     * @throws SQLException
     */
	
	public void modificarLugar (Lugar lugarNuevo, Lugar lugarViejo)throws SQLException{
		
		con=ds.getConnection();
		
		String sentenciaPrecompiladaSQL = "UPDATE ciudoteca.lugares SET lugares.nombre_lugar=? WHERE lugares.id_lugar=?";
		PreparedStatement ps = con.prepareStatement(sentenciaPrecompiladaSQL);
		ps.setString(1, lugarNuevo.getNombreLugar());
		ps.setLong(2, lugarViejo.getIdLugar());
		
		ps.executeUpdate();													
		cerrarConexion();
	}
	
	/**
	 * Detecta si el lugar que se quiere crear, existe para la ciudad asoc al lugar.
	 * Ojo, permite que varias ciudades tengan el mismo nombre de lugar.
	 * @param ciudad informada con idCiudad y nombreCiudad
	 * @param lugar informado con nombreLugar
	 * @return boolean que nos indica si el lugar existe o no
	 * @throws SQLException
	 */
	public boolean validar(Ciudad ciudad, Lugar lugar)throws SQLException {
		boolean lugarExiste=false;
		con = ds.getConnection();
		
		// Con esta consulta detecto si el lugar q quiero crear ya existe.
		// No la puedo gestionar como se hace en crearCuenta porque nombre_lugar no es PrimaryKey
		// asi q no me comprueba si se repite o no
		String sentenciaSQL = "SELECT nombre_lugar FROM lugares WHERE nombre_lugar=? AND ciudad_id=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1, lugar.getNombreLugar());
		ps.setLong(2, ciudad.getIdCiudad());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			lugarExiste=true;
		}
		cerrarConexion();
		return lugarExiste;
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