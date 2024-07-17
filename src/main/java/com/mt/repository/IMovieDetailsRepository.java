package com.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.entity.MovieDetails;

public interface IMovieDetailsRepository extends JpaRepository<MovieDetails, Integer> {

}
