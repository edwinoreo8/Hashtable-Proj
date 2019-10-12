package proj2;
/**
 * 
 * @author Edwin Orellana N00854104
 *
 * 
 */

public class Person {
	
	
	// will need instance vars for first name, last name, email
	String fName;
	PersonInfo info;
	String email;
	// gets and sets for all, param constructor methods as well
	public Person(String firstName, String lName, String info, String mail)
	{
		this.fName = firstName;
		this.info = new PersonInfo(lName,info);
		this.email= mail;
	}
	public void setInfo(PersonInfo info) {
		this.info = info;
	}
	public PersonInfo getInfo() {
		return info;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "ID[" +info.getId()+ "]:[" + fName + "," + info.getlName()+ "," + email + "]"; 
		
	}
	

}
