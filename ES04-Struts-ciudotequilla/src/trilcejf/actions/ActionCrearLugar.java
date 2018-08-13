package trilcejf.actions;

import java.sql.SQLException;

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


public class ActionCrearLugar extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String vista=null;
		
		// Used para controlar si el user, una vez creado un lugar, pulsa el botón Actualizar de su navegador
		boolean vieneActualizarLugar = false;
		
		// Incluir la jsp que contine los encabezados para evitar el acceso a cache
		request.getRequestDispatcher("nocache.jsp").include(request, response);
		
		LugarForm lugarForm= (LugarForm) form;
		Lugar lugar = new Lugar();
		lugar.setNombreLugar(lugarForm.getNombreLugar());
						
		Ciudad ciudad = new Ciudad();
		ciudad.setIdCiudad(Long.parseLong(request.getParameter("idCiudad")));
		ciudad.setNombreCiudad(request.getParameter("nombreCiudad"));
		
		String sCrearLugarForm = request.getParameter("crear");
		if(sCrearLugarForm != null){
			request.setAttribute("ciudad", ciudad);
			vista = "crearFormuCrear";		
			
			// Poner en Session vieneActualizarLugar para que cuando se intente introducir un lugar que ya
			// existe reenvie a crearLugar.jsp mostrando el mensaje
			request.getSession().setAttribute("vieneActualizarLugar", vieneActualizarLugar);
			request.getSession().setMaxInactiveInterval(1800);
		}
		else{
			DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
			InformacionLugares il = new InformacionLugares(ds);
			vista = "exito";
	        try{
	        	// Obtener de Session la variable para saber si viene de actualizar
	        	vieneActualizarLugar = (Boolean) request.getSession().getAttribute("vieneActualizarLugar");
	        	
	        	// Método que verifica si el lugar existe en la BD
	        	boolean lugarExiste = il.validar(ciudad,lugar);
	
	        	// Si el lugar no existe
	        	if (!lugarExiste){ 							
					il.crearLugar(ciudad, lugar);
					
					// Poner en Session vieneActualizarLugar para que cuando actualice no reenvie a crearLugar.jsp
					vieneActualizarLugar = true;
					request.getSession().setAttribute("vieneActualizarLugar", vieneActualizarLugar);
					vista = "exito"; //obtenerLugaresCiudad.do
	        	}
	        	else{
	        		if (vieneActualizarLugar){
	        			// Si viene de actualizar reenvia a obtenerLugaresCiudad
	        			vista = "exito"; //obtenerLugaresCiudad
	        		}
	        		else{
	        			ActionMessages errors = new ActionMessages();
		        		errors.add("mensajeLugarRepetido", new ActionMessage("error.lugar.existe"));
		        		saveErrors(request,errors);
		        		request.setAttribute("ciudad", ciudad);
						vista = "lugarYaExiste"; //crearLugar.jsp
	        		}
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
				il.cerrarConexion();
				ActionMessages errors = new ActionMessages();
				errors.add("mensajeBD", new ActionMessage("error.bd"));
				saveErrors(request,errors);
				vista = "fracaso";
			}
		}
		return (mapping.findForward(vista));
	}
}