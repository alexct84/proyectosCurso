

package trilcejf.utils;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import trilcejf.delegate.ICiudadDelegate;
import trilcejf.listeners.CiudadEvent;
import trilcejf.listeners.CiudadListener;
import trilcejf.vo.Ciudad;

import com.icesoft.faces.async.render.IntervalRenderer;
import com.icesoft.faces.async.render.OnDemandRenderer;
import com.icesoft.faces.async.render.RenderManager;
import com.icesoft.faces.async.render.Renderable;
import com.icesoft.faces.component.dragdrop.DndEvent;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.context.DisposableBean;
import com.icesoft.faces.webapp.xmlhttp.FatalRenderingException;
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesState;
import com.icesoft.faces.webapp.xmlhttp.RenderingException;



public class CiudadAsyncBean implements Renderable, DisposableBean, CiudadListener
{
	 private static Log log = LogFactory.getLog(CiudadAsyncBean.class);

	 	private OnDemandRenderer mensajeRenderer;
	    private IntervalRenderer clock;
	    private final int renderInterval = 1000;
	    private PersistentFacesState state;


		private String hora;
		private Ciudad ciudad = new Ciudad();
		private List ciudades = new ArrayList();
		private List ciudadesLista = new ArrayList();
		private List logCiudades = new ArrayList();

		private ICiudadDelegate ciu =(ICiudadDelegate) ServiceFinder.findBean("ciudadDelegate");

	    /**
	     * Constructor initializes time zones.
	     */
	    public CiudadAsyncBean() {
	    	state = PersistentFacesState.getInstance();
	    	if (mensajeRenderer==null){

	    	}
	    	ciu.addCiudadListener(this);
	    	cargarLista();
	    }



	public PersistentFacesState getState() {
		return state;
	}

	public void renderingException(RenderingException renderingException) {
		 if (log.isDebugEnabled()) {
	            log.debug("Rendering exception: ", renderingException);
	        }

	        if (renderingException instanceof FatalRenderingException)  {
	            performCleanup();
	        }

	}

	public void dispose() throws Exception {
		if (log.isDebugEnabled()) {
            log.debug("Dispose TimeZoneBean for a user - cleaning up");
        }
        performCleanup();

	}

	 /**
     * Used to create, setup, and start an IntervalRenderer from the passed
     * renderManager This is used in conjunction with faces-config.xml to allow
     * the same single render manager to be set in all TimeZoneBeans
     *
     * @param renderManager RenderManager to get the IntervalRenderer from
     */
    public void setRenderManager(RenderManager renderManager) {
    	mensajeRenderer = renderManager.getOnDemandRenderer("mensajes");
    	mensajeRenderer.add(this);
    	mensajeRenderer.requestRender();
        clock = renderManager.getIntervalRenderer("clock");
        clock.setInterval(renderInterval);
    	clock.add(this);
    	clock.requestRender();
    }

    /**
     * Gets RenderManager
     *
     * @return RenderManager null
     */
    public RenderManager getRenderManager() {
        return null;
    }


	public String getHora() {
		return (new Date().toString());
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	public String create(){
		String status = "failure";
		System.out.println("crea");
		try {
			ciudad = ciu.create(ciudad);
			status = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}


	public int getRenderInterval() {
		return renderInterval;
	}

	public void setState(PersistentFacesState state) {
		this.state = state;
	}

	protected boolean performCleanup() {
        try {
            if (mensajeRenderer != null) {
            	mensajeRenderer.remove(this);
                // whether or not this is necessary depends on how 'shutdown'
                // you want an empty renderer. If it's emptied often, the cost
                // of shutdown+startup is too great
                /*if (mensajeRenderer.isEmpty() ) {
                	mensajeRenderer.dispose();
                }
                mensajeRenderer = null;*/
            }
            if (clock != null) {
            	clock.remove(this);
                // whether or not this is necessary depends on how 'shutdown'
                // you want an empty renderer. If it's emptied often, the cost
                // of shutdown+startup is too great
                if (clock.isEmpty() ) {
                	clock.dispose();
                }
                clock = null;
            }
            return true;
        } catch (Exception failedCleanup) {
            if (log.isErrorEnabled()) {
                log.error("Failed to cleanup a clock bean", failedCleanup);
            }

        }
        return false;
    }



	public List getCiudadesLista() {
		return ciudadesLista;
	}



	public void setCiudadesLista(List ciudadesLista) {
		this.ciudadesLista = ciudadesLista;
	}



	public Ciudad getCiudad() {
		return ciudad;
	}



	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}



	public void nuevo(CiudadEvent se) {
		Ciudad ciu= new Ciudad();
		ciu.setIdCiudad(se.getCiudad().getIdCiudad());
		ciu.setNombreCiudad(se.getCiudad().getNombreCiudad());
		ciudades.add(ciu);
		logCiudades.add(getHora() + ":Ciudad: " + ciu.getNombreCiudad() + " creada");
		mensajeRenderer.requestRender();
	}

	public void eliminar(CiudadEvent se) {
		System.out.println(ciudades.indexOf(se.getCiudad()));
		Iterator iter = ciudades.iterator();
		while(iter.hasNext()){
			Ciudad ciu = (Ciudad)iter.next();
			if(se.getCiudad().getIdCiudad().longValue()==ciu.getIdCiudad().longValue()){
				ciudades.remove(ciu);
				logCiudades.add(getHora() + ":Ciudad: " + ciu.getNombreCiudad() + " eliminada");
				return;
			}

			}


	}


	public void cargarLista(){
		ciudades= ciu.findByExample(new Ciudad());
		System.out.println("Numero ciudades: " + ciudades.size());
		for (int i = 0; i < ciudades.size(); i++) {
			ciudadesLista.add(new SelectItem(((Ciudad)(ciudades.get(i))).getIdCiudad(),
											((Ciudad)ciudades.get(i)).getNombreCiudad().toUpperCase()));
		}
	}



	public List getCiudades() {
		return ciudades;
	}



	public void setCiudades(List ciudades) {
		this.ciudades = ciudades;
	}

	public void delCiudad(DragEvent event) {
        // we are only concerned with the drop event

   if (event.getEventType() == DndEvent.DROPPED) {
       String targetId = event.getTargetClientId();
       if ((targetId != null)) {
    	   String strIdCiudad =((HtmlPanelGroup) event.getComponent()).getDropValue().toString();
    	   ciudad.setIdCiudad(new Long(strIdCiudad));
    	   //ciudad=(Ciudad)ciu.findByExample(ciudad).iterator().next();
    	   ciudad=ciu.loadById(ciudad);
    	   ciu.delete(ciudad);
       }
       }

	}



	public void editar(CiudadEvent se) {
		cargarLista();
		logCiudades.add(getHora() + ":Ciudad: " + se.getCiudad().getIdCiudad() + " modificada");
		mensajeRenderer.requestRender();

	}



	public List getLogCiudades() {
		return logCiudades;
	}



	public void setLogCiudades(List logCiudades) {
		this.logCiudades = logCiudades;
	}










}