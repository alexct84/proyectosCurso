package com.tutorial.jsf2.web.jsf.view;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tutorial.jsf2.Category;
import com.tutorial.jsf2.Tutorial;
import com.tutorial.jsf2.services.LibraryOfAlexandria;



@ManagedBean
@ViewScoped
public class ListTutorialsView implements Serializable {

	private static final long serialVersionUID = 4530828263503902611L;

	private static final Logger logger = LoggerFactory.getLogger(ListTutorialsView.class);

	private Category category;

	@ManagedProperty("#{libraryOfAlexandria}")
	private LibraryOfAlexandria libraryOfAlexandria;

	private Date publicationDate;

	private Category subCategory;

	private Category subsubCategory;

	private String title;

	public ListTutorialsView() {
		logger.debug("Just to show when {} is created. It depens on the bean scope.", getClass().getSimpleName());

	}

	public String add() {
		libraryOfAlexandria.addTutorial(new Tutorial(title, publicationDate, subsubCategory));
		return null;
	}

	public List<Category> getSubCategories() {
		if (category == null) {
			return Collections.emptyList();
		}
		return category.getChildren();
	}

	public List<Category> getSubsubCategories() {
		if (subCategory == null) {
			return Collections.emptyList();
		}
		return subCategory.getChildren();
	}

	public List<Category> getCategories() {
		return libraryOfAlexandria.getCategories();
	}

	public Category getCategory() {
		return category;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public Category getSubCategory() {
		return subCategory;
	}

	public Category getSubsubCategory() {
		return subsubCategory;
	}

	public String getTitle() {
		return title;
	}

	public List<Tutorial> getTutorials() {
		return libraryOfAlexandria.getTutorials();
	}

	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		logger.warn("Entering");
		setCategory(libraryOfAlexandria.getCategories().get(0));
		logger.warn("Exiting");
	}

	public void setCategory(Category category) {
		logger.debug("set category: {}", category.getName());
		this.category = category;
		setSubCategory(category.getChildren().get(0));
	}

	public void setLibraryOfAlexandria(LibraryOfAlexandria libraryOfAlexandria) {
		this.libraryOfAlexandria = libraryOfAlexandria;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void setSubCategory(Category subCategory) {
		logger.debug("set sub-category: {}", subCategory.getName());
		this.subCategory = subCategory;
		setSubsubCategory(subCategory.getChildren().get(0));
	}

	public void setSubsubCategory(Category subsubCategory) {
		logger.debug("set sub-category: {}", subsubCategory.getName());
		this.subsubCategory = subsubCategory;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
