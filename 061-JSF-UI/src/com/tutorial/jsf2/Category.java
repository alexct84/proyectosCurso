package com.tutorial.jsf2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category implements Serializable {

	private static final long serialVersionUID = 3530928578572545830L;

	private final List<Category> children = new ArrayList<Category>();

	private final String name;

	public Category(String name) {
		this.name = name;
	}

	public void addChild(Category child) {
		children.add(child);
	}

	public List<Category> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return new org.apache.commons.lang3.builder.HashCodeBuilder(31, 1).append(name).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Category other = (Category)obj;
		return new org.apache.commons.lang3.builder.EqualsBuilder().appendSuper(super.equals(other)).append(name, other.name).isEquals();
	}

	@Override
	public String toString() {
		return name;
	}

}
