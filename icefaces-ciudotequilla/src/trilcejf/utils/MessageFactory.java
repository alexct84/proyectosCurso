package trilcejf.utils;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageFactory {
	ResourceBundle bundle;
	Locale locale;

	public MessageFactory() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	bundle = ResourceBundle.getBundle("mensajes", locale);
	}
	public String getMessage(String key) {
		return bundle.getString(key);
	}

}