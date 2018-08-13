package trilcejf.utiles;

import javax.sql.*;
import javax.naming.*;

import javax.servlet.*;

// La interface ServletContextListener declara dos mets que deben ser implementados
public class ListenerEventosContexto implements ServletContextListener{

	// Ejecutado cuando se inicialice el contexto de la aplic
	// Ocurre al levantar el server en que esta hospedada
	public void contextInitialized(ServletContextEvent sce) {
		try{
			System.out.println("Contexto inicializado para la aplicacion " + sce.getServletContext().getServletContextName());
			
			// Obtener el contexto para poder realizar búsquedas JNDI
			// Analogía: conseguir una guía de teléfono
			Context contexto = new InitialContext();
			// Búsqueda JNDI del datasource
			// Analogía: búsqueda del num de tef de una persona en base a su nombre
			DataSource ds = (DataSource)contexto.lookup("java:comp/env/jdbc/ciudades");
			System.out.println("DataSource obtenido para " + sce.getServletContext().getServletContextName() );
			
			// Agregar el datasource como un atributo de contexto
			// Será accesible a todos los componentes de la aplic, previa obtención del contexto
			sce.getServletContext().setAttribute("ds", ds);
		}catch(NamingException ne){
			System.out.println("Error al obtener el DataSource para " + sce.getServletContext().getServletContextName());
		}
	}

	// Ejecutado cuando se destruya el contexto, es decir, cuando se tumbe el server
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Contexto destruido para la aplicacion" + sce.getServletContext().getServletContextName());
	}
}
