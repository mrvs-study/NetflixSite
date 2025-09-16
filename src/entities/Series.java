package entities;

public class Series {
	
		private String title;
		private String genre;
		private int seasons;
	
		
		public Series() {
			
		}

		public Series(String title, String genre,int seasons) {
			this.title = title;
			this.genre = genre;
			this.seasons= seasons;
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

		public void showInfo() {
			System.out.println("Titulo: "+ getTitle()+" gênero: "+ getGenre()+" temporadas: "+getSeasons());
		}
		

	}



