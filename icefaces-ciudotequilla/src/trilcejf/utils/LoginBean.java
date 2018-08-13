package trilcejf.utils;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.ui.AbstractProcessingFilter;
import org.springframework.stereotype.Component;


public class LoginBean {

	private String username = "";
	private String password = "";
	private boolean rememberMe = false;
	private boolean loggedIn = false;

	public String doLogin() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
		.getRequestDispatcher("/j_spring_security_check?j_username=" + getUsername() + "&j_password=" + getPassword());

		dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());

		// Mas info en JSF in action, pag 436
		// TODO Pendiente de eliminar el escuchador de fases, una vez que se autentique el usuario
		LifecycleFactory factory = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle lifecycle = factory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		lifecycle.addPhaseListener(
				new PhaseListener()
				{
					public void beforePhase(PhaseEvent event){handleErrorMessage();}
					public void afterPhase(PhaseEvent event){}
					public PhaseId getPhaseId(){return PhaseId.RESTORE_VIEW;}
				});
		FacesContext.getCurrentInstance().responseComplete();

		return null;
	}


	private void handleErrorMessage() {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get(
						AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

		if (e instanceof BadCredentialsException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,null);
			// el segundo argumento es el mensaje de error, el tercero, los detalles.
			// en login.jsp h:messages showdetails=true para que se vean ambos
			FacesContext.getCurrentInstance().addMessage(null,
														 new FacesMessage(FacesMessage.SEVERITY_ERROR,
														 "ERROR DE AUTENTICACIÓN: ","Usuario o nombre de contraseña incorrectos."));
		}
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return this.rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public boolean isLoggedIn() {
		return this.loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
