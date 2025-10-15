package entities;

import java.util.Date;


public class Film {
	
	private String title;
	private String genre;
	private double duration;
	private double rating;
	private Date releaseDate;
	
	public Film() {
	}

	
	

	public Film(String title, String genre, double duration, double rating, Date releaseDate) {
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.releaseDate = releaseDate;
	}




	public Film(String title, String genre) {

		this.title = title;
		this.genre = genre;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setName(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	
}
