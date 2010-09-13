package coreclasses;

public class Player {
	
	private String password;
	private String name;
	private String description;
	
	public void setInfo(String p, String n, String d) {
		password = p;
		name = n;
		description = d;
	}
	
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	/*public String password;
	
	public void setPassword(String p) {
		password = p;
	}

	public String getPassword() {
	
		return password;
	}*/

}
