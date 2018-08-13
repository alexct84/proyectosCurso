package trilcejf.delegate;

import java.util.List;

import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;



/**
 * <prescripcion + responsabilidad>
 * @author 	Jesús Fernández Ortega
 * @version:	1.0
 */
public interface ILugarDelegate {

	/**
	 * Crea un nuevo registro en la fuente de datos
	 *
	 * @param ciudadVO VO con los datos a insertar
	 * @return VO con los datos del nuevo registro
	 */
	Lugar create(Ciudad ciudad, Lugar lugar);

	/**
	 * Elimina un registro de la fuente de datos
	 *
	 * @param ciudad VO con el id setteado
	 */
	void delete(Lugar lugar);

	/**
	 * Actualiza un registro de la fuente de datos
	 *
	 * @param ciudad VO con el id setteado
	 * @return VO con los datos actualizados
	 */
	Lugar update(Lugar lugar);

	/**
	 * Carga de la fuente de datos un registro determinado
	 *
	 * @param ciudad VO con el id setteado
	 * @return VO con los datos del registo recuperado
	 */
	Lugar loadById(Lugar lugar);

	/**
	 * Carga todos los registros de la fuente de datos que se
	 * correspondan con los parametros implicitos en el VO
	 * que se pasa como parametro
	 *
	 * @param ciudad VO con uno o varios campos setteados
	 * @return List de VO
	 */
	//TODO incluir Lugar para búsquedas como las hechas para las ciudades
	List findByExample(Ciudad ciudad, Lugar lugar);

}
