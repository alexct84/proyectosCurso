package trilcejf.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import trilcejf.pojos.*;


import java.sql.SQLException;
import java.util.*;

public class ActionObtenerCiudades extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String vista = "exito";
		DataSource ds = (DataSource)getServlet().getServletContext().getAttribute("ds");
	    InformacionCiudades ic = new InformacionCiudades(ds);
	    try{
	    	List listaCiudades = ic.getCiudades();
	    	request.setAttribute("listaCiudades",listaCiudades);
	    }catch(SQLException e){
	    	e.printStackTrace();
	    	ic.cerrarConexion();
	    	vista = "fracaso";
	    	request.setAttribute("mensaje", "PROBLEMAS EN LA BASE DE DATOS. CONSULTE CON EL ADMINISTRADOR");
	    }
		return mapping.findForward(vista);
	}
}
