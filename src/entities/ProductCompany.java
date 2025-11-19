package entities;

import java.util.Date;

public class ProductCompany {

	private String directorName;
	private String name;
	private String plot;
	private Date releaseDate;
	private String cnpj;
	private String mediaType;

	public  ProductCompany() {
	}
	
	
	
	public ProductCompany(String directorName, String name, String plot, Date releaseDate, String cnpj,String mediaType) {
		this.directorName = directorName;
		this.name = name;
		this.plot = plot;
		this.releaseDate = releaseDate;
		this.cnpj = cnpj;
		this.mediaType = mediaType;
	}

	


	public ProductCompany(String directorName, String name) {
		this.directorName = directorName;
		this.name = name;
	}



	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}


	


}
