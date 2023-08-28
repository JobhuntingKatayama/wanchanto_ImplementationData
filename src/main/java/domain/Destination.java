package domain;

public class Destination {

	private Integer genreId;
	private String name;
	private Integer evaluation;
	
	public Destination() {
		
	}
	
	public Destination(Integer genreId, String name, Integer evaluation) {
		this.genreId = genreId;
		this.name = name;
		this.evaluation = evaluation;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	
	
	
}
