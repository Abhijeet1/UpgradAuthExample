package com.upgrad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "moviename")
	private String movieName;

	@Column(name = "description")
	private String description;

	protected Movie() {
	}

	public Movie(String movieName, String description) {
		this.movieName = movieName;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Movie[id=%d, movieName='%s', description='%s']", id, movieName, description);
	}
}
