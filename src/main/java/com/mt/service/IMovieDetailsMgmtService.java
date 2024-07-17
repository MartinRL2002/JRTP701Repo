package com.mt.service;

import java.util.List;
import java.util.Map;

import com.mt.entity.MovieDetails;

public interface IMovieDetailsMgmtService {
	
	//saving the Movie details 
	public String registerMovieDetails(MovieDetails movieDetails);
	
	//retrieving the Movie details with Id and Movie name
	public Map<Integer, String> getMovieDetails();
	
	//Retrieving all movie Details
	public List<MovieDetails> showAllMovieDetails();
	
	//updating the details
	public String updateMovieDetailsById(MovieDetails movieId);
	
	//Retrieving the details by Id Value
	public MovieDetails getMovieDetailsById(Integer movieId);
	
	//Deleting by Id value(Hard Deletion)
	public String deleteMovieDetailsById(Integer movieId);
	
	//Changing the movie Details
	public String changeMovieStatusById(Integer movieId, String status);
	
	
	
	
	
	
	
	
	
}
