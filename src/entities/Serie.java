package entities;

public class Serie {
	
		private String title;
		private String genre;
		private int seasons;
		private double duration;
		private int episode;
		private double rating;
	
		public Serie() {
		}
	
		

		public Serie(String title, String genre, int seasons, double duration, int episode, double rating) {
			this.title = title;
			this.genre = genre;
			this.seasons = seasons;
			this.duration = duration;
			this.episode = episode;
			this.rating = rating;
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

		public double getDuration() {
			return duration;
		}

		public void setDuration(double duration) {
			this.duration = duration;
		}

		public int getEpisode() {
			return episode;
		}

		public void setEpisode(int episode) {
			this.episode = episode;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		
		

	}



