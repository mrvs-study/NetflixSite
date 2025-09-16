package entities;

public class Film {
	
	private String title;
	private String genre;
	private int time;
	
	public Film() {
		
	}

	public Film(String title, String genre, int time) {
		this.title = title;
		this.genre = genre;
		this.time = time;
	}

	public String getTitle() {
		return title;
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	public void showInfo() {
		System.out.println("Titulo: "+ getTitle()+" gênero: "+ getGenre()+" tempo: "+ getTime());
	}
	

}
