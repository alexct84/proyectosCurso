package trilcejf.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.*;
import trilcejf.forms.CiudadForm;
import trilcejf.pojos.*;
import trilcejf.tos.*;


public class ActionCrearCiudad extends Action {
	 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String vista = null;
		
    	// Capturar parámetros procedente de la petición HTTP, a través de CiudadForm
        CiudadForm ciudadForm = (CiudadForm) form;
        Ciudad ciudad = new Ciudad();
        ciudad.setIdCiudad(ciudadForm.getIdCiudad());
        ciudad.setNombreCiudad(ciudadForm.getNombreCiudad());
        
        String sCrearCiudadForm = request.getParameter("crear");
        if(sCrearCiudadForm != null){
			vista = "crearFormuCrear";				
		}
        else{
	       
	        // Obtener el DataSource del contexto
	        DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
	        InformacionCiudades ic = new InformacionCiudades(ds);
	        try{
	        	boolean ciudadExiste=ic.validar(ciudad);
	        	if(!ciudadExiste){
	        		ic.crear(ciudad);
	        		request.setAttribute("ciudad", ciudad);
	        		vista="exito";
	        	}
	        	else{
	        		ActionMessages errors = new ActionMessages();
	        		errors.add("mensajeCiudadRepetida", new ActionMessage("error.ciudad.existe"));
	        		saveErrors(request,errors);
					vista = "ciudadyaexistente";
				}
			} catch (SQLException e) {
		    	vista = "fracaso";
				e.printStackTrace();
				ic.cerrarConexion();
				ActionMessages errors = new ActionMessages();
				errors.add("mensajeBD", new ActionMessage("error.bd"));
				saveErrors(request,errors);
			}
        }
		return (mapping.findForward(vista));
	}
}
