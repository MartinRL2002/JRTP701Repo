package com.mt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MOVIE_DETAILS")
@Data
public class MovieDetails {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="catagory_seq",initialValue=101,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer movieId;
	
	@Column(name="MOVIE_NAME")
	private String movieName;
	
	@Column(name="ACTOR_NAME")
	private String actorName;
	
	@Column(name="DIRECTOR_NAME")
	private String directorName;
	
	@Column(name="PRODUCER_NAME")
	private String producerName;
	
	@Column(name="PRODUCTION_COMPANY")
	private String productionCompany;
	
	@Column(name="BUDGET")
	private Long budget;
	
	@Column(name="STATUS")
	private String Status;
	

}
