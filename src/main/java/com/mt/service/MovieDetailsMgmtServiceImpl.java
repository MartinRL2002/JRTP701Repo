package com.mt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.config.AppConfigurationProperties;
import com.mt.constants.MovieDetailsConstants;
import com.mt.entity.MovieDetails;
import com.mt.repository.IMovieDetailsRepository;

@Service
public class MovieDetailsMgmtServiceImpl implements IMovieDetailsMgmtService {

	@Autowired
	private IMovieDetailsRepository movieDetailsRepo;
	
	public Map<String,String> messages;

	@Autowired
	public MovieDetailsMgmtServiceImpl(AppConfigurationProperties props) {
		messages=props.getMessages();
	}
	
	@Override
	public String registerMovieDetails(MovieDetails movieDetails) {
		MovieDetails save=movieDetailsRepo.save(movieDetails);
		
		return save.getMovieId()!=null?messages.get(MovieDetailsConstants.SAVE_SUCCESS)+save.getMovieId():messages.get(MovieDetailsConstants.SAVE_FAILURE);
	}

	@Override
	public Map<Integer, String> getMovieDetails() {
		List <MovieDetails> list=movieDetailsRepo.findAll();
		Map<Integer, String> mapDetails=new HashMap<Integer, String>();
		list.forEach(details->{
			mapDetails.put(details.getMovieId(), details.getMovieName());
		});
		return mapDetails;
	}

	@Override
	public List<MovieDetails> showAllMovieDetails() {
		return movieDetailsRepo.findAll();
		
	}

	@Override
	public String updateMovieDetailsById(MovieDetails movieId) {
		Optional<MovieDetails> opt= movieDetailsRepo.findById(movieId.getMovieId());
		if(opt.isPresent()) {
			movieDetailsRepo.save(movieId);
			return movieId.getMovieId()+messages.get(MovieDetailsConstants.UPDATE_SUCCESS);
		}else {
		
		return movieId.getMovieId()+messages.get(MovieDetailsConstants.UPDATE_FAILURE);
		}
	}

	@Override
	public MovieDetails getMovieDetailsById(Integer movieId) {
		
		return movieDetailsRepo.findById(movieId).orElseThrow(()->new IllegalArgumentException(messages.get(MovieDetailsConstants.FINDBYID_FAILURE)) ) ;
	}

	@Override
	public String deleteMovieDetailsById(Integer movieId) {
		Optional<MovieDetails> opt=movieDetailsRepo.findById(movieId);
		if(opt.isPresent()) {
			movieDetailsRepo.deleteById(movieId);
			return movieId+messages.get(MovieDetailsConstants.DELETE_SUCCESS);
		}else
		return movieId+messages.get(MovieDetailsConstants.DELETE_FAILURE);
	}

	@Override
	public String changeMovieStatusById(Integer movieId, String status) {
		Optional<MovieDetails> opt=movieDetailsRepo.findById(movieId);
		if(opt.isPresent()) {
			MovieDetails movieList=opt.get();
			movieList.setStatus(status);
			movieDetailsRepo.save(movieList);
			return movieId+messages.get(MovieDetailsConstants.STATUS_CHANGE_SUCCESS);
		}else {
			return movieId+messages.get(MovieDetailsConstants.STATUS_CHANGE_FAILURE);
		}
		
	}

}
