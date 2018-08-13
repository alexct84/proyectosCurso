/**
 *
 */
package trilcejf.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import trilcejf.dao.ICiudadDAO;
import trilcejf.vo.Ciudad;


/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public class CiudadDAOHibernateImpl extends HibernateDaoSupport implements ICiudadDAO {
	private static final Logger logger = Logger.getLogger(CiudadDAOHibernateImpl.class);

	public Ciudad create(Ciudad ciudad) throws Exception{
		Long id =(Long) getHibernateTemplate().save(ciudad);
		ciudad.setIdCiudad(id);
		return ciudad;
	}

	public void delete(Ciudad ciudad){
		getHibernateTemplate().delete(ciudad);
	}

	public Ciudad update(Ciudad ciudad) {
		HibernateTemplate hiberbateTemplate = getHibernateTemplate();
		hiberbateTemplate.update(ciudad);
		return ciudad;
	}

	public List findByExample(Ciudad ciudad) {
		logger.debug(ciudad);
		DetachedCriteria criteria = DetachedCriteria.forClass(Ciudad.class);
		if(ciudad.getNombreCiudad()!=null){
			criteria.add(Expression.eq("nombreCiudad", ciudad.getNombreCiudad()));
		}else{
			criteria.addOrder(Order.desc("idCiudad"));
		}
		List objs = getHibernateTemplate().findByCriteria(criteria);


		return objs;
	}
	public Ciudad loadById(Ciudad ciudad) {
		return (Ciudad)getHibernateTemplate().load(Ciudad.class, ciudad.getIdCiudad());
	}
}
