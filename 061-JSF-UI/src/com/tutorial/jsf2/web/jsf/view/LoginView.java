package com.tutorial.jsf2.web.jsf.view;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
public class LoginView {

	private static final Logger logger = LoggerFactory.getLogger(LoginView.class);

	public LoginView() {
		logger.debug("Just to show when {} is created. It depens on the bean scope.", getClass().getSimpleName());
	}

	@NotNull
	@Size(min = 6, max = 128)
	private String name;

	@NotNull
	@Size(min = 6, max = 128)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
