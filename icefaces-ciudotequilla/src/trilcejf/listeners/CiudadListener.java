package trilcejf.listeners;

import java.util.EventListener;

public interface CiudadListener {
	public void	nuevo(CiudadEvent	se);
	public void	editar(CiudadEvent	se);
	public void	eliminar(CiudadEvent se);

}
