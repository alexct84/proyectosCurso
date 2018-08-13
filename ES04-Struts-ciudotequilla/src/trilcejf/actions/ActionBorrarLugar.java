package trilcejf.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import trilcejf.forms.*;
import trilcejf.pojos.*;
import trilcejf.tos.*;


public class ActionBorrarLugar extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		String vista = null;
		LugarForm lugarForm = (LugarForm)form;
		Lugar lugar = new Lugar();
		lugar.setIdLugar(lugarForm.getIdLugar());
		lugar.setNombreLugar(lugarForm.getNombreLugar());
		lugar.setCiudadId(lugarForm.getCiudadId());// used por getCiudadByLugar
		
		String mostrarNotificacionBorrar = request.getParameter("mostrarNotificacionBorrar");
		
		// Crear formulario para borrar un lugar
		if(mostrarNotificacionBorrar != null){
			request.setAttribute("lugar", lugar);
			vista = "crearFormuBorrar";//borrarLugar.jsp
		}
		
		// Borrar el lugar de la BD. Se ejecuta cuando se invoca a esta action desde borrarLugar.jsp
		else{
			DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
			InformacionLugares il = new InformacionLugares(ds);
	        try{
	        	Ciudad ciudad = il.getCiudadByLugar(lugar);
	        	il.borrarLugar(lugar);
	        	request.setAttribute("ciudad", ciudad);
	        	vista="exito";//obtenerLugaresCiudad.do
	        }catch (SQLException e) {
	        	e.printStackTrace();
	        	il.cerrarConexion();
		    	vista = "fracaso";
		    	request.setAttribute("mensaje", "PROBLEMAS EN LA BASE DE DATOS. CONSULTE CON EL ADMINISTRADOR");
			}
		}
	    return (mapping.findForward(vista));//obtenerLugaresCiudad.do
	}
}