package com.mt.ms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.entity.MovieDetails;
import com.mt.service.IMovieDetailsMgmtService;

@RestController
@RequestMapping("/movieDetails/api")
public class MovieDetailsOperationController {
	
	@Autowired
	private IMovieDetailsMgmtService movieService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerMovieDeatils( @RequestBody MovieDetails details){
		try {
			String msg=movieService.registerMovieDetails(details);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/movieDetailsInfo")
	public ResponseEntity<?> showMovieDetailsInformation(){
		try {
			Map<Integer,String> info=movieService.getMovieDetails();
			return new ResponseEntity<Map<Integer,String>>(info,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> showAllMovieDetailsInfo(){
		try {
		List<MovieDetails> list=movieService.showAllMovieDetails();
		return new ResponseEntity<List<MovieDetails>>(list,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{movieId}")
	public ResponseEntity<?> findMovieDetailsbyId(@PathVariable Integer movieId){
		try {
			MovieDetails find=movieService.getMovieDetailsById(movieId);
			return new ResponseEntity<MovieDetails>(find,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<String> updateMovieDetailsById(@RequestBody MovieDetails movieId){
		try {
		String update=movieService.updateMovieDetailsById(movieId);
		return new ResponseEntity<String>(update,HttpStatus.OK);
		
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<String> deleteMovieDetailsById(@PathVariable Integer movieId){
		try {
			String delete=movieService.deleteMovieDetailsById(movieId);
			return new ResponseEntity<String>(delete,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/status-change/{movieId}/{status}")
	public ResponseEntity<?> changeMovieStatusById(@PathVariable Integer movieId, String status){
		try {
			String changeStatus=movieService.changeMovieStatusById(movieId, status);
			return new ResponseEntity<String>(changeStatus,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
}	
