package com.tutorial.jsf2;

import java.util.Date;

public class Tutorial {

	private final Category category;

	private final Date publicationDate;

	private final String title;

	public Tutorial(String title, Date publicationDate, Category category) {
		this.title = title;
		this.publicationDate = publicationDate;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public String getTitle() {
		return title;
	}

}
