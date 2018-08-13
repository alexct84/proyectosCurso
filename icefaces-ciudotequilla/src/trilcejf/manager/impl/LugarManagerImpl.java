/**
 *
 */
package trilcejf.manager.impl;

import java.util.List;

import org.apache.log4j.Logger;

import trilcejf.dao.ILugarDAO;
import trilcejf.manager.ILugarManager;
import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;

/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public class LugarManagerImpl implements ILugarManager {
	private static final Logger logger = Logger.getLogger(LugarManagerImpl.class);

	private ILugarDAO lugarDAO;

	// Informar el lugar con la ciudad para dejarlo bonito
	public Lugar create(Ciudad ciudad,Lugar lugar){
		lugar.setCiudad(ciudad);
		return getLugarDAO().create(lugar);
	}

	public void delete(Lugar lugar){
		getLugarDAO().delete(lugar);
	}

	public Lugar update(Lugar lugar){
		return getLugarDAO().update(lugar);
	}

	public List findByExample(Ciudad ciudad, Lugar lugar){
		return getLugarDAO().findByExample(ciudad, lugar);
	}

	public Lugar loadById(Lugar lugar) {
		return getLugarDAO().loadById(lugar);
	}

	public ILugarDAO getLugarDAO() {
		return lugarDAO;
	}

	public void setLugarDAO(ILugarDAO lugarDAO) {
		this.lugarDAO = lugarDAO;
	}
}
