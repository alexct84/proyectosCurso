package com.tutorial.jsf2.web.jsf.converter;

import java.util.Collections;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase utiliza la lista de elementos fijada en el <code>value</code> del <code>f:selectItems</code> para hacer la
 * conversión de los valores. En vez de sacar la lista de valores del <code>f:selectItems</code> se podría, por ejemplo,
 * hacer un binding del converter y fijar la lista de objetos en el código del backbean, esto tiene el problema de que
 * no se podría hacer el backbean con scope view (<code>@ViewScoped</code>), ya que actualmente exite una limitación: <a
 * href="https://javaserverfaces.dev.java.net/issues/show_bug.cgi?id=1492">https://javaserverfaces.dev.java.net/issues/
 * show_bug.cgi?id=1492</a>
 * <p>
 * Este converter presupone que la lista del <code>f:selectItems</code> no varia entre que se pinta el html y luego se
 * recoge el valor seleccionado.
 */
@FacesConverter("selectItemsConverter")
public class SelectItemsConverter implements Converter {

	private static final Logger logger = LoggerFactory.getLogger(SelectItemsConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.warn("String value: {}", value);
		final int index = Integer.parseInt(value);
		if (index == -1) {
			return null;
		}

		final List<?> objects = getObjectsFromUISelectItemsComponent(component);
		logger.warn("String as Object: {}", objects.get(index));
		return objects.get(index);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		final List<?> objects = getObjectsFromUISelectItemsComponent(component);
		logger.warn("Object value: {}", value);
		logger.warn("Object as string: {}", objects.indexOf(value));
		return String.valueOf(objects.indexOf(value));
	}

	private List<?> getObjectsFromUISelectItemsComponent(UIComponent component) {
		List<?> objects = Collections.emptyList();
		for (UIComponent child : component.getChildren()) {
			if (child.getClass() == UISelectItems.class) {
				objects = (List<?>)((UISelectItems)child).getValue();
			}
		}
		logger.warn("Objects: {}", objects);
		return objects;
	}

}
