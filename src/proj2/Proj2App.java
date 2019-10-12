package proj2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Edwin Orellana N00854104
 *
 * 
 */
public class Proj2App {
	public static void main(String[] args) throws IOException{
		SimpleHashTable<PersonInfo,Person> table = new SimpleHashTable<PersonInfo,Person>();
		/*String lName = "DOG";
		int len = lName.length();
		int prime = 31;
		int result = 0;
		int j = 1;
		for(int i = 0; i < len; i++){
			System.out.println(i);
			System.out.println(lName.charAt(i));
			result += (lName.charAt(i)*Math.pow(prime, (len - j)));
			System.out.println(result);
			j++;
			
		}
		result += lName.charAt(2);
		//result += lName.charAt(j);
		System.out.println(len);
		System.out.println(result);
		THIS WAS ME TESTING THE HASHCODE 
	*/
		BufferedReader reader;
		String splitter = ",";
		String line; 
		
		
			reader = new BufferedReader(new FileReader("proj2data.csv"));
			line = reader.readLine();
			line = reader.readLine();
			while(line != null){
				String[] collecting = line.split(splitter);
				Person temp = new Person(collecting[1], collecting[2], collecting[0], collecting[3]);
				PersonInfo temp2= new PersonInfo(collecting[0], collecting[2]);
			   // System.out.println(table.getSize());
				//System.out.println(table.getCollison());
				//System.out.println(collecting[1]);
				table.put(temp2, temp);	

				line = reader.readLine();
			}
			reader.close();
			System.out.println(table.toString());
			}
		}
	

