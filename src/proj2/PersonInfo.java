package proj2;
/**
 * 
 * @author Edwin Orellana N00854104
 *
 * 
 */

public class PersonInfo {
	String lName;
	String id;

	public PersonInfo(String lName, String id) {
		this.lName = lName;
		this.id=id;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*
	 * DJB2 Made By Daniel J Bernstein. The way this hash code works is it uses a large Prime number. The reason for why we use prime
	 * number is so the number of buckets being used isn't divisible by it. Also the specific number 5381 was found to have fewest collisions 
	 * its also the 709th prime. Prime 33 was found to be better but I wanted to be able to see how my linked list worked with collisions.
	 *  We grab the prime number and bit shift it left 5 times. We then add the prime back to it and then the ASCII value of the character
	 *  that is in position I so it results in a unique number a good percentage of the time. 
	 *  http://www.cse.yorku.ca/~oz/hash.html
	 *  https://stackoverflow.com/questions/10696223/reason-for-5381-number-in-djb-hash-function/13809282#13809282
	 */
	@Override
	public int hashCode() {
		int len = this.lName.length() + this.id.length();
		String combine = this.lName + this.id;
		int result = 5381;
		for(int i =0; i < len; i++) {
			result += Math.abs((result << 5) + result) + combine.charAt(i);
		}
		return result;
	}
	/*
	 * XOR Hashing Algorithm, This hashing method isn't the best out there since it is very simple as it is only XORing the 
	 * string once. It is basically byte folding the string into a hashcode using the XOR method.XOring is when two bits equal 
	 * each other they will zero out changing the value of the String. 
	 * http://www.eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx 
	 */
	/*public int hashCode() {
		int len = this.lName.length() + this.id.length();
		String combine = this.lName + this.id;
		int result = 0;
		for(int i = 0; i < len; i++) {
			result += result ^ combine.charAt(i);
		}
		return result;
	}*/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		PersonInfo other = (PersonInfo)obj;
		if(this.id.equals(other.getId())) {
			return true;
		}

		return false;
	}
	public String toString() {
		return new String();
	}
}
