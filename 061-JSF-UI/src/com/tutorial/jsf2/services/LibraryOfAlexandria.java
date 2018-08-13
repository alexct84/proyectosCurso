package com.tutorial.jsf2.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tutorial.jsf2.Category;
import com.tutorial.jsf2.Tutorial;

/**
 * Estamos simulando un servicio que se comparte por todos los usuarios de la
 * aplicación, aunque no es muy apropiado usar @ManagedBean ya que esta
 * anotación está haciendo referencia a un backbean de JSF, y esto no lo es.
 * Además tenemos el inconveniente añadido de que todo lo que esté marcado
 * como @ManagedBean tiene que estar en el WEB-INF/classes, y no lo podemos
 * distribuir en distintos JAR.
 * 
 * @author Autentia Real Business Solutions
 */
@ManagedBean
@SessionScoped
public class LibraryOfAlexandria {

	private static final Logger logger = LoggerFactory
			.getLogger(LibraryOfAlexandria.class);

	private final List<Tutorial> tutorials = new ArrayList<Tutorial>();

	private final List<Category> categories = new ArrayList<Category>();

	private void populateTestData() {
		final Category javaCategory = new Category("Java");
		javaCategory.addChild(new Category("JSF 2"));
		javaCategory.getChildren().get(0).addChild(new Category("Ajax"));
		javaCategory.getChildren().get(0).addChild(new Category("Facelets"));
		javaCategory.getChildren().get(0).addChild(new Category("Componentes"));
		javaCategory.addChild(new Category("Spring"));
		javaCategory.getChildren().get(1).addChild(new Category("IoC"));
		javaCategory.getChildren().get(1).addChild(new Category("Anotaciones"));
		javaCategory.addChild(new Category("Hibernate"));
		javaCategory.getChildren().get(2).addChild(new Category("JPA"));
		javaCategory.getChildren().get(2).addChild(new Category("Anotaciones"));
		javaCategory.getChildren().get(2)
				.addChild(new Category("Validaciones JSR-303"));
		categories.add(javaCategory);

		final Category agileCategory = new Category("Agile");
		agileCategory.addChild(new Category("Scrum"));
		agileCategory.getChildren().get(0)
				.addChild(new Category("Product Owner"));
		agileCategory.getChildren().get(0)
				.addChild(new Category("Scrum Manager"));
		agileCategory.getChildren().get(0).addChild(new Category("Team"));
		agileCategory.addChild(new Category("XP"));
		agileCategory.getChildren().get(1)
				.addChild(new Category("Pair Programming"));
		agileCategory.getChildren().get(1)
				.addChild(new Category("Simple Design"));
		agileCategory.getChildren().get(1).addChild(new Category("TDD"));
		agileCategory.getChildren().get(1)
				.addChild(new Category("Refactoring"));
		agileCategory.addChild(new Category("TDD"));
		agileCategory.getChildren().get(2).addChild(new Category("Red"));
		agileCategory.getChildren().get(2).addChild(new Category("Green"));
		agileCategory.getChildren().get(2).addChild(new Category("Refactor"));
		categories.add(agileCategory);

		try {
			final DateFormat dateFormat = SimpleDateFormat.getDateInstance(
					SimpleDateFormat.SHORT, new Locale("es"));
			tutorials
					.add(new Tutorial(
							"Spring + Hibernate + Anotaciones = Desarrollo Rápido en Java",
							dateFormat.parse("14/10/08"), javaCategory
									.getChildren().get(1)));
			tutorials.add(new Tutorial("JSF 2 ya está aquí !!!", dateFormat
					.parse("23/02/10"), javaCategory.getChildren().get(0)));
			tutorials.add(new Tutorial(
					"Introducción al desarrollo dirigido por ejemplos",
					new Date(), agileCategory.getChildren().get(2)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public LibraryOfAlexandria() {
		logger.debug(
				"Just to show when {} is created. It depens on the bean scope.",
				getClass().getSimpleName());
		populateTestData();
	}

	public void addTutorial(Tutorial Tutorial) {
		tutorials.add(Tutorial);
		logger.debug("Añadido tutorial: {}", Tutorial.getTitle());
	}

	public List<Tutorial> getTutorials() {
		return Collections.unmodifiableList(tutorials);
	}

	public List<Category> getCategories() {
		return Collections.unmodifiableList(categories);
	}

}
