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

import trilcejf.forms.CiudadForm;
import trilcejf.pojos.*;
import trilcejf.tos.*;


public class ActionModificarCiudad extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String vista = null;
		CiudadForm ciudadForm = (CiudadForm) form;
		Ciudad ciudad = new Ciudad();
		ciudad.setIdCiudad(ciudadForm.getIdCiudad());//idCiudad = new Long(request.getParameter("idCiudad"));
		ciudad.setNombreCiudad(ciudadForm.getNombreCiudad());
		
		String mostrarNotificacionEditar = request.getParameter("mostrarNotificacionEditar");
		
		// Crear formulario para editar ciudad
		if(mostrarNotificacionEditar != null){
			request.setAttribute("ciudad",ciudad);
			vista = "crearFormuEditar";
		}
		
		// Actualizar la ciudad en la BD
		else{
			request.setAttribute("ciudad",ciudad);
			DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
			InformacionCiudades ic = new InformacionCiudades(ds);
			try{
				boolean ciudadExiste=ic.validar(ciudad);
				if(!ciudadExiste){
					ic.modificar(ciudad);
	        		vista="exito";
	        	}
				else{
					ActionMessages errors = new ActionMessages();
	        		errors.add("mensajeCiudadRepetida", new ActionMessage("error.ciudad.existe"));
	        		saveErrors(request,errors);
					vista = "ciudadyaexistente";
				}
			}catch(SQLException e){
				e.printStackTrace();
				ic.cerrarConexion();
				ActionMessages errors = new ActionMessages();
				errors.add("mensajeBD", new ActionMessage("error.bd"));
				saveErrors(request,errors);
				vista = "fracaso";
			}
		}
		 // Delegar a la vista adecuada en base al nombre lógico que se le pasa (consultar struts-config.xml)
        return (mapping.findForward(vista));
	  }
}
