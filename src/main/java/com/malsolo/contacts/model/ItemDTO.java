package com.malsolo.contacts.model;

import java.io.Serializable;

public class ItemDTO implements Serializable {

    /** serialVersionUID */
	private static final long serialVersionUID = 3447861723180648062L;
	
	private Long id;
    private String name;
    private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
