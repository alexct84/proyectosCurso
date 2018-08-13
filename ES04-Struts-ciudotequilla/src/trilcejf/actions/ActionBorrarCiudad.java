package trilcejf.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import trilcejf.forms.CiudadForm;
import trilcejf.pojos.*;
import trilcejf.tos.*;


public class ActionBorrarCiudad extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String vista = null;
		CiudadForm ciudadForm = (CiudadForm) form;
		Ciudad ciudad = new Ciudad();
		ciudad.setIdCiudad(ciudadForm.getIdCiudad());//idCiudad = new Long(request.getParameter("idCiudad"));
		ciudad.setNombreCiudad(ciudadForm.getNombreCiudad());
		
		String mostrarNotificacionBorrar = request.getParameter("mostrarNotificacionBorrar");
		
		// Crear formulario para borrar una ciudad
		if(mostrarNotificacionBorrar != null){
			request.setAttribute("ciudad",ciudad);
			vista = "crearFormuBorrar";
		}
		// Borrar la ciudad de la BD
		else{
	        
	        DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
		    InformacionCiudades ic = new InformacionCiudades(ds);
	        try{
	        	ic.borrar(ciudad);
	        	vista = "exito";
	        } catch (SQLException e) {
				vista = "fracaso";
				e.printStackTrace();
				ic.cerrarConexion();
				request.setAttribute("mensaje", "PROBLEMAS EN LA BASE DE DATOS. CONSULTE CON EL ADMINISTRADOR");
			}
		}
        return (mapping.findForward(vista));
	}
}
