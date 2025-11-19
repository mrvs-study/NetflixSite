package entities;

import java.util.Date;

public class Serie {
	
		private String title;
		private String genre;
		private int seasons;
		private Date releaseDate;
		private int episodes;
		private double rating;
	
		public Serie() {
		}
	
		

		public Serie(String title, String genre, int seasons, int episodes, double rating, Date releaseDate) {
			this.title = title;
			this.genre = genre;
			this.seasons = seasons;
			this.episodes = episodes;
			this.rating = rating;
			this.releaseDate = releaseDate;
		}

		public Serie(String title, String genre) {
			this.title = title;
			this.genre = genre;
		}



		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}
		

		public int getSeasons() {
			return seasons;
		}

		public void setSeasons(int seasons) {
			this.seasons = seasons;
		}

		public Date getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}

		public int getEpisodes() {
			return episodes;
		}

		public void setEpisodes(int episodes) {
			this.episodes = episodes;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}



		@Override
		public String toString() {
			return "\nTítulo: " + title +
			       "\nGênero: " + genre +
			       "\nTemporadas: " + seasons +
			       "\nEpisódios: " + episodes +
			       "\nNota: " + rating +
			       "\nLançamento: " + releaseDate +
			       "]"+
			       "\n";
		}

		
		

	}



