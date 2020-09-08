package NBA_Player_Project;

public class PlayerClass1 {
//declaring primitive data type variables
	private String name;
	private String year_start;
	private String year_end;
	private String weight;
	private String birth_date;

	
//constructor
	public PlayerClass1(String name, String year_start, String year_end, String weight, String birth_date) {
		this.name =name;
		this.year_start = year_start;
		this.year_end = year_end;
		this.weight = weight;
		this.birth_date = birth_date;
	}

	
//getters
	public String getname() {
		return name;
	}
	
	public String getyear_start() {
		return year_start;
	}

	
	public String getyear_end() {
		return year_end;
	}

	
	public String getweight() {
		return weight;
	}

	
	public String getbirth_date() {
		return birth_date;
	}
	


	
//setters
	public void setname(String name) {
		this.name = name;
	}
	
	public void setyear_start(String year_start) {
		this.year_start = year_start;
	}
	
	public void setyear_end(String year_end) {
		this.year_end = year_end;
	}
	
	public void setweight(String weight) {
		this.weight = weight;
	}
	
	public void setbirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
}
