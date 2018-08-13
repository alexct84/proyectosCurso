/**
 *
 */
package trilcejf.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import trilcejf.dao.ILugarDAO;
import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;


/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public class LugarDAOHibernateImpl extends HibernateDaoSupport implements ILugarDAO {
	private static final Logger logger = Logger.getLogger(LugarDAOHibernateImpl.class);

	public Lugar create(Lugar lugar){
		Long id =(Long) getHibernateTemplate().save(lugar);
		lugar.setIdLugar(id);
		return lugar;
	}

	public void delete(Lugar lugar){
		getHibernateTemplate().delete(lugar);
	}

	public Lugar update(Lugar lugar) {
		HibernateTemplate hiberbateTemplate = getHibernateTemplate();
		hiberbateTemplate.update(lugar);
		/*Lugar lugarAux = (Lugar)hiberbateTemplate.load(Lugar.class, lugarOld.getIdLugar());
		lugarAux.setNombreLugar(lugar.getNombreLugar());
		hiberbateTemplate.update(lugarAux);*/
		return lugar;
	}

	public List findByExample(Ciudad ciudad, Lugar lugar) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Lugar.class);
/*		if(lugar.getNombreLugar()!=null)
			criteria.add(Expression.eq("nombreLugar", lugar.getNombreLugar()));*/
		if(ciudad.getNombreCiudad()!=null)
			criteria.createCriteria("ciudad").add(Restrictions.eq("nombreCiudad", ciudad.getNombreCiudad()));
		List objs = getHibernateTemplate().findByCriteria(criteria);
		return objs;
	}

	public Lugar loadById(Lugar lugar) {
		return (Lugar)getHibernateTemplate().load(Lugar.class, lugar.getIdLugar());
	}
}
