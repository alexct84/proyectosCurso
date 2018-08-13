package trilcejf.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import trilcejf.forms.*;
import trilcejf.pojos.*;
import trilcejf.tos.*;

public class ActionModificarLugar extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// Used para controlar si el user, una vez modificado el nombre de un lugar, pulsa el botón Actualizar de su navegador
		boolean vieneActualizarLugar = false;
		
		// Incluir la jsp que contine los encabezados para evitar el acceso a cache
		request.getRequestDispatcher("nocache.jsp").include(request, response);

		String vista=null;
	
		String sCrearFormEditar = request.getParameter("mostrarNotificacionEditar");
		LugarForm lugarForm = (LugarForm)form;
		Lugar lugar = new Lugar();
		lugar.setIdLugar(lugarForm.getIdLugar());
		lugar.setNombreLugar(lugarForm.getNombreLugar());
		lugar.setCiudadId(lugarForm.getCiudadId()); // used por getCiudadByLugar
        
		// Crear formulario para editar un lugar
		if(sCrearFormEditar != null){
			try {
				request.setAttribute("lugar", lugar);
				
				// Poner en Session vieneActualizarLugar para que cuando se intente introducir un lugar que ya
				// existe reenvie a editarLugar.jsp mostrando el mensaje
				request.getSession().setAttribute("vieneActualizarLugar", vieneActualizarLugar);
				request.getSession().setMaxInactiveInterval(1800);
				
				vista="crearFormuEditar"; //editarLugar.jsp
			} catch (Exception e) {
				e.printStackTrace();
		    	vista = "fracaso";
		    	request.setAttribute("mensaje", "PROBLEMAS EN LA BASE DE DATOS. CONSULTE CON EL ADMINISTRADOR");
			}
		}
		else{
			DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
			InformacionLugares il = new InformacionLugares(ds);
			Lugar lugarNuevo=new Lugar();
			lugarNuevo.setNombreLugar(lugarForm.getNombreLugar());
			try {
	        	
	        	// Obtener de Session la variable para saber si viene de actualizar
        		vieneActualizarLugar = (Boolean) request.getSession().getAttribute("vieneActualizarLugar");
        		
        		// La action a la que se delega en cq de los casos analizados abajo es obtenerLugaresCiudad.do
        		// Necesita un objeto Ciudad informado con idCiudad y nombreCiudad
				// Da lo mismo pasarle lugar que lugarNuevo pq ambos tienen el mismo ciudadId. Ver met getCiudadByLugar
				Ciudad ciudad = il.getCiudadByLugar(lugar);
				request.setAttribute("ciudad", ciudad);
				
				// Verifica si el lugar que se ha modificado ya existe
	        	boolean lugarExiste = il.validar(ciudad,lugar);
	        	
	        	// Si se modifica el lugar y el nuevo nombre de lugar todavía no existe (caso normal)
	        	if (!lugarExiste){
					il.modificarLugar(lugarNuevo, lugar);					
					
					// Poner en Session vieneActualizarLugar para que cuando actualice no reenvie a editarLugar.jsp
					vieneActualizarLugar = true;
					request.getSession().setAttribute("vieneActualizarLugar", vieneActualizarLugar);
					vista="exito"; //obtenerLugaresCiudad.do
	        	}
	        	
	        	// Si se modifica el lugar y el nuevo nombre resulta que ya existe. Dos posibles causas:
	        	// 1.- El user ha modificado correctamente un lugar, se encuentra en la pantalla de los lugares asoc a la ciudad y no se le ocurre
	        	//	   otra cosa que pulsar el botón Actualizar del navegador. En la barra de direcciones se tiene http://localhost:8080/hb-ciudotequilla/editarLugar.do
	        	// 2.- El user se ha colado y ha escrito un nombre de lugar que ya existe y esta asoc a un lugar ya existente
	        	else{
	        		if (vieneActualizarLugar){
	        			vista = "exito"; //obtenerLugaresCiudad.do
	        		}
	        		else{
	        			ActionMessages errors = new ActionMessages();
		        		errors.add("mensajeLugarRepetido", new ActionMessage("error.lugar.existe"));
		        		saveErrors(request,errors);
		        		request.setAttribute("lugar", lugar);
						vista = "lugarYaExiste"; //editarLugar.jsp
	        		}
	        	}
			} catch (Exception e) {
	        	e.printStackTrace();
	        	ActionMessages errors = new ActionMessages();
				errors.add("mensajeBD", new ActionMessage("error.bd"));
				saveErrors(request,errors);
		    	vista = "fracaso";
			}
		}
		return (mapping.findForward(vista));
	 }
}
