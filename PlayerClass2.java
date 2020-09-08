package NBA_Player_Project;

//creating this class to show inheritance

public class PlayerClass2 extends PlayerClass1{

	private String college;
	
	public PlayerClass2(String name, String year_start, String year_end, String weight, String birth_date, String college) {
		super(name, year_start, year_end, weight, birth_date);
		this.college = college;
	}

	
//getter


	public String getcollege() {
		return college;
	}
	
//setter
	public void setcollege(String college) {
		this.college = college;
	}
}
