/**
 *
 */
package trilcejf.manager.impl;

import java.util.List;

import org.apache.log4j.Logger;

import trilcejf.dao.ICiudadDAO;
import trilcejf.manager.ICiudadManager;
import trilcejf.vo.Ciudad;


/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public class CiudadManagerImpl implements ICiudadManager {
	private static final Logger logger = Logger.getLogger(CiudadManagerImpl.class);
	private ICiudadDAO ciudadDAO;

	public Ciudad create(Ciudad ciudad) throws Exception{
		return getCiudadDAO().create(ciudad);
	}

	public void delete(Ciudad ciudad){
		getCiudadDAO().delete(ciudad);
	}

	public Ciudad update(Ciudad ciudad) {
		return getCiudadDAO().update(ciudad);
	}

	public List findByExample(Ciudad ciudad) {
		return getCiudadDAO().findByExample(ciudad);
	}

	public Ciudad loadById(Ciudad ciudad) {
		return getCiudadDAO().loadById(ciudad);
	}

	public ICiudadDAO getCiudadDAO() {
		return ciudadDAO;
	}

	public void setCiudadDAO(ICiudadDAO ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}
}
