/*package com.iecisa.ciudoteca.business.delegate;

import java.util.List;
*//**
 *
 *//*

import com.iecisa.ciudoteca.business.vo.CiudadVO;

*//**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 *//*
public interface ICiudadDelegate {

	List findAllOrderedByNombre();

	void processCiudades(List list);

	List findByExample(CiudadVO ciudadVO);



}
*/

package trilcejf.delegate;

import java.util.List;

import trilcejf.listeners.CiudadListener;
import trilcejf.vo.Ciudad;


/**
 * <prescripcion + responsabilidad>
 * @author 	Jesús Fernández Ortega
 * @version:	1.0
 */
public interface ICiudadDelegate {

	/**
	 * Crea un nuevo registro en la fuente de datos
	 *
	 * @param ciudadVO VO con los datos a insertar
	 * @return VO con los datos del nuevo registro
	 */
	Ciudad create(Ciudad ciudad) throws Exception;

	/**
	 * Elimina un registro de la fuente de datos
	 *
	 * @param ciudad VO con el id setteado
	 */
	void delete(Ciudad ciudad);

	/**
	 * Actualiza un registro de la fuente de datos
	 *
	 * @param ciudad VO con el id setteado
	 * @return VO con los datos actualizados
	 */
	Ciudad update(Ciudad ciudad);

	/**
	 * Carga de la fuente de datos un registro determinado
	 *
	 * @param ciudad VO con el id setteado
	 * @return VO con los datos del registo recuperado
	 */
	Ciudad loadById(Ciudad ciudad);

	/**
	 * Carga todos los registros de la fuente de datos que se
	 * correspondan con los parametros implicitos en el VO
	 * que se pasa como parametro
	 *
	 * @param ciudad VO con uno o varios campos setteados
	 * @return List de VO
	 */
	List findByExample(Ciudad ciudad);

	void addCiudadListener(CiudadListener ml);

}
