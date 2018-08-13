/**
 *
 */
package trilcejf.manager;

import java.util.List;

import trilcejf.vo.Ciudad;



/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public interface ICiudadManager {

	/*List findAllOrderedByNombre();

	void processCiudades(List list);*/

	Ciudad create(Ciudad ciudad) throws Exception;

	void delete(Ciudad ciudad);

	Ciudad update(Ciudad ciudad);

	List findByExample(Ciudad ciudadVO);

	Ciudad loadById(Ciudad ciudad);



}
