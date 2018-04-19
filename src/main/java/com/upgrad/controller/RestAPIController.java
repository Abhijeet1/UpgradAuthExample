package com.upgrad.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.model.Movie;
import com.upgrad.repository.MovieRepository;


@RestController
public class RestAPIController {
	@Autowired
	MovieRepository repository;

	@RequestMapping("/save")
	public String process() {
		// save a single Movie
		repository.save(new Movie("Titanic", "A fictionalized account of the sinking of the RMS Titanic."));

		// save a list of Movies
		repository.saveAll(Arrays.asList(
				new Movie("Gladiator", "When a Roman General is betrayed, and his family murdered by an emperor's corrupt son, he comes to Rome as a gladiator to seek revenge."), 
				new Movie("A Beautiful Mind", "A Beautiful Mind is a 2001 American biographical drama film based on the life of John Nash, a Nobel Laureate in Economics"),
				new Movie("The Dark Knight", "The Dark Knight is a 2008 superhero film directed, produced, and co-written by Christopher Nolan. Featuring the DC Comics character Batman."), 
				new Movie("Transformers", "Transformers is a 2007 American science fiction action film based on the toy line of the same name created by Hasbro. ")));

		return "Movies Saved";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";

		for (Movie movie : repository.findAll()) {
			result += movie.toString() + "<br>";
		}

		return result;
	}

	//http://localhost:9000/findbyid?id=5
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";					
		result = repository.findById(id).toString();
		return result;
	}

	@RequestMapping("/findbydescription")
	public String fetchDataByLastName(@RequestParam("description") String description) {
		String result = "";

		for (Movie movie : repository.findByDescription(description)) {
			result += movie.toString() + "<br>";
		}

		return result;
	}
}
