/**
 *
 *//*
package com.iecisa.ciudoteca.business.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import com.iecisa.ciudoteca.business.delegate.ICiudadDelegate;
import com.iecisa.ciudoteca.business.vo.CiudadVO;

*//**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 *//*
public class CiudadDelegateImpl implements ICiudadDelegate {

	*//**
	 * {@inheritDoc}
	 *
	 * @see com.iecisa.ciudoteca.business.delegate.ICiudadDelegate#findAllOrderedByNombre()
	 *//*
	public List findAllOrderedByNombre() {
		List list = new ArrayList();

		list.add(createCiudad(new Integer(1), "GIJON"));
		list.add(createCiudad(new Integer(2), "MONZON"));
		list.add(createCiudad(new Integer(3), "JESUS"));

		return list;
	}

	private CiudadVO createCiudad(Integer integer, String string) {
		CiudadVO ciudadVO = new CiudadVO();
		ciudadVO.setId(integer);
		ciudadVO.setNombre(string);
		return ciudadVO;
	}

	*//**
	 * {@inheritDoc}
	 *
	 * @see com.iecisa.ciudoteca.business.delegate.ICiudadDelegate#processCiudades(java.util.List)
	 *//*
	public void processCiudades(List list) {
		// TODO Plantilla de metodo auto-generado

	}

	public List findByExample(CiudadVO ciudadVO) {
		// TODO Plantilla de metodo auto-generado
		return null;
	}

}
*/

package trilcejf.delegate.impl;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import trilcejf.delegate.ICiudadDelegate;
import trilcejf.listeners.CiudadEvent;
import trilcejf.listeners.CiudadListener;
import trilcejf.manager.ICiudadManager;
import trilcejf.vo.Ciudad;



public class CiudadDelegateImpl implements ICiudadDelegate {

	private Vector ciudadListeners = new Vector();

	private static final Logger logger = Logger.getLogger(CiudadDelegateImpl.class);

	private ICiudadManager ciudadManager;

	public Ciudad create(Ciudad ciudad) throws Exception{
		Ciudad ciu=getCiudadManager().create(ciudad);

		  CiudadEvent ce = new CiudadEvent (this, ciu, null);
		  Vector vtemp = (Vector)ciudadListeners.clone();
		  for (int x = 0; x < vtemp.size(); x++){
		   CiudadListener target = null;
		   target = (CiudadListener)vtemp.elementAt(x);
		   target.nuevo(ce);
		  }

		return ciu;
	}

	public void delete(Ciudad ciudad){
		getCiudadManager().delete(ciudad);
		 CiudadEvent ce = new CiudadEvent (this, ciudad, null);
		  Vector vtemp = (Vector)ciudadListeners.clone();
		  for (int x = 0; x < vtemp.size(); x++){
		   CiudadListener target = null;
		   target = (CiudadListener)vtemp.elementAt(x);
		   target.eliminar(ce);
		  }

	}

	public Ciudad update(Ciudad ciudad) {
		Ciudad ciu = getCiudadManager().update(ciudad);
		CiudadEvent ce = new CiudadEvent (this, ciu, null);
		  Vector vtemp = (Vector)ciudadListeners.clone();
		  for (int x = 0; x < vtemp.size(); x++){
		   CiudadListener target = null;
		   target = (CiudadListener)vtemp.elementAt(x);
		   target.editar(ce);
		  }
		  return ciu;

	}

	public List findByExample(Ciudad ciudad) {
		return getCiudadManager().findByExample(ciudad);
	}

	public Ciudad loadById(Ciudad ciudad) {
		return getCiudadManager().loadById(ciudad);
	}

	public ICiudadManager getCiudadManager() {
		return ciudadManager;
	}

	public void setCiudadManager(ICiudadManager ciudadManager) {
		this.ciudadManager = ciudadManager;
	}

	public void addCiudadListener(CiudadListener ml){
		 //add main frame to vector of listeners
		 if (ciudadListeners.contains(ml))
		  return;
		 ciudadListeners.addElement(ml);
		}


}