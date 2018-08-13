package trilcejf.delegate.impl;

import java.util.List;

import org.apache.log4j.Logger;

import trilcejf.delegate.ILugarDelegate;
import trilcejf.manager.ILugarManager;
import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;


public class LugarDelegateImpl implements ILugarDelegate {

	private static final Logger logger = Logger.getLogger(LugarDelegateImpl.class);

	private ILugarManager lugarManager;

	public Lugar create(Ciudad ciudad, Lugar lugar){
		return getLugarManager().create(ciudad,lugar);
	}

	public void delete(Lugar lugar){
		getLugarManager().delete(lugar);
	}

	public Lugar update(Lugar lugar){
		return getLugarManager().update(lugar);
	}

	public List findByExample(Ciudad ciudad, Lugar lugar) {
		return getLugarManager().findByExample(ciudad,lugar);
	}

	public Lugar loadById(Lugar lugar) {
		return getLugarManager().loadById(lugar);
	}

	public ILugarManager getLugarManager() {
		return lugarManager;
	}

	public void setLugarManager(ILugarManager lugarManager) {
		this.lugarManager = lugarManager;
	}


}