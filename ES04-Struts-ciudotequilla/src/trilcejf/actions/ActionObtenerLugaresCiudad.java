package trilcejf.actions;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.*;
import javax.sql.DataSource;

import org.apache.struts.action.*;

import trilcejf.forms.*;
import trilcejf.pojos.*;
import trilcejf.tos.*;

public class ActionObtenerLugaresCiudad extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    	String vista = "null";
    	
    	// Capturar parámetros de request, a través de CiudadForm
        CiudadForm ciudadForm = (CiudadForm) form;
        
    	Ciudad ciudad = new Ciudad();
        ciudad.setIdCiudad(ciudadForm.getIdCiudad());
        ciudad.setNombreCiudad(ciudadForm.getNombreCiudad());
        
        // Proviene de borrar un lugar. Obtengo la ciudad como atrib de request
        if(ciudad.getNombreCiudad() == null)
        	ciudad = (Ciudad)request.getAttribute("ciudad");
        
        // Obtener el DataSource del contexto
        DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
        InformacionCiudades ic = new InformacionCiudades(ds);
        try{
	        List listaLugaresCiudad = ic.getVisitasObligadas(ciudad);
        	request.setAttribute("ciudad", ciudad);
	        request.setAttribute("listaLugaresCiudad", listaLugaresCiudad);
	        vista="exito"; // mostrarResultados.jsp
	        
	        // La action actual puede ser invocada desde index.jsp o desde listaCiudades.jsp
	        // al pulsar el enlace Editar lugares.
	        // Si no es invocada desde el index
	        if(request.getParameter("procedeIndex")== null){
				vista = "exito_bis";//listaLugaresCiudad.jsp
			}
        } catch (SQLException e) {
        	e.printStackTrace();
	    	ic.cerrarConexion();
	    	vista = "fracaso";//error.jsp
	    	request.setAttribute("mensaje", "PROBLEMAS EN LA BASE DE DATOS. CONSULTE CON EL ADMINISTRADOR");
		}
        return (mapping.findForward(vista));
    }
}
