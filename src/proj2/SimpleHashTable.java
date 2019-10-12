package proj2;
import java.util.*;
import java.util.NoSuchElementException;
/**
 * 
 * @author Edwin Orellana N00854104
 *
 * 
 */
public class SimpleHashTable<K, V> 
{

	// instance vars:
	// create an array of SimpleEntry called hashtable
	LinkedList<SimpleEntry<K,V>>[] hashTable;
	// counter for collisions
	int collisions;
	// counter for how many times you expanded capacity
	int numOfExpand;
	// will need get methods for those counters
	int size;


	// default constructor, instantiate the array to size 5
	public SimpleHashTable() 
	{
		// the syntax is simillar to the one used in the Set lab
		hashTable =new LinkedList[5]; 
		collisions = 0;
		numOfExpand = 0;
		size = 0;




	}

	// call hashcode method of key, compress it, then store key, value at that position
	// count how many collisions you had, up to you if you want to overwrite or not
	// need to expandcapacity if needed
	public void put(K key, V value) 
	{
		//int code = Math.abs(key.hashCode());
		int pos = (Math.abs(key.hashCode())% hashTable.length);
		if((size/hashTable.length) >= .75){
			reshash();
			numOfExpand++;
		}
		if(hashTable[pos] == null){
			hashTable[pos] = new LinkedList<SimpleEntry<K,V>>();
			hashTable[pos].add(new SimpleEntry<K,V>(key,value));
			size++;
		}
		else{
			hashTable[pos].add(new SimpleEntry<K,V>(key,value));
			collisions++;

		}

	}

	// return Value based on key or throw NoSuchElementException if it doesn't exist 
	public V get(K key) 
	{
		int index = (Math.abs(key.hashCode() % hashTable.length));

		if(hashTable[index] == null){
			throw new NoSuchElementException();
		}else {
			for(int i = 0; i < hashTable[i].size(); i++) {
				if(hashTable[index].get(i).key.equals(key)) {
					return hashTable[index].get(index).value;
				}
			}
		}

		return hashTable[index].get(index).value;


	}

	public int getCollison()
	{
		return collisions;
	}
	public int getExpandAmount()
	{
		return numOfExpand;
	}
	public int getSize() {
		return size;
	}

	// this is the expandcapacity method
	// expand array and recompress the values to find new position
	private void reshash()
	{
		LinkedList<SimpleEntry<K,V>>[] newHash = new LinkedList[(hashTable.length*2)];
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null){
				for(int g = 0; g < hashTable[i].size(); g++) {
					if(hashTable[i].get(g) == null) {
						break;
					}
					else {

						int pos = Math.abs(hashTable[i].get(g).getKey().hashCode()% newHash.length);
						//System.out.println(hashTable[i].get(g));
						newHash[pos] = new LinkedList();
						newHash[pos].add(hashTable[i].get(g));
						size++;
					}
				}
			}
		}
		hashTable = newHash;

	}
	public String toString(){
		StringBuilder str = new StringBuilder();
		String temp = " ";
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] == null) {
				temp +=" " + i + ": null";
			}else {
				for(int g = 0; g < hashTable[i].size(); g++)
					if(g == hashTable[i].size() - 1) {
						temp += " " +i+ ":" +hashTable[i].get(g).toString();

					}else {
						temp += " " +i+ ":" + hashTable[i].get(g).toString() + ",";
					}
			}
			temp += "\n";

		}
		return "Number Of Collisions: " + collisions + " Number Of Buckets Used: " + size + " Number Of Expansions: " + numOfExpand + "\n" +  temp;
	}

}