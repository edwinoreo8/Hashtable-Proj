package proj2;
import java.util.*;
/**
 * 
 * @author Edwin Orellana N00854104
 *
 * 
 */
public class SimpleEntry<K, V> implements Map.Entry<K, V> 
{
	
	// declare two instance vars:
	// key of type K
	// value of type V
	K key;
	V value;
	
	
	// parameterized constructor, you know what to do
	public SimpleEntry(K key, V value) 
	{
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() 
	{
		return key;
	}
	
	@Override
	public V getValue() 
	{
		return value;
	}
	
	// this must set the value to newValue but return the old value
	@Override
	public V setValue(V newValue) 
	{
		V val = value;
		value = newValue;
		return val;
	}
	public String toString() {
		return key.toString() + " " + value.toString();
	} 
	
}
