/**
 *
 */
package trilcejf.manager;

import java.util.List;

import trilcejf.vo.Ciudad;
import trilcejf.vo.Lugar;


/**
 * @author 66499351
 * @version $Revision$ ($Author$)
 *
 */
public interface ILugarManager {

	Lugar create(Ciudad ciudad,Lugar lugar);

	void delete(Lugar lugar);

	Lugar update(Lugar lugar);

	List findByExample(Ciudad ciudad, Lugar lugar);

	Lugar loadById(Lugar lugar);

}
