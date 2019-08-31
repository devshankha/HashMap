/**
 * 
 * @author devshankhasharm
 *
 * @param <K>
 * @param <V>
 * This is a better implementation of a HashMap, 
 * the signatures of put and remove are as per the actual HashMap definations,
 * which returns a value rather than void
 */
public class MyHashMap<K,V> {
	private Entry[] entries;
	private int size;
	public MyHashMap(int s) {
		size = s;
		entries = new Entry[size];
	}
	public V put(K key, V value) {
		int h = key.hashCode();
		if (entries[h] == null) {
			entries[h]=new Entry(key,value);
			return null;
			
		}
		Entry temp = entries[h];
		Entry previous = null;
		while (temp != null) {			
			if (temp.key.equals(key)) {
				V val = (V) temp.getValue();				
				temp.value = value;
				return val;
			}
			previous = temp;
			temp = temp.next;
				
		}
		temp.next = new Entry(key,value);
		return null;
	}
	
	public V get(K key) {
		int h = key.hashCode();
		Entry temp = entries[h];
		if (temp != null && temp.key.equals(key)) {
			return (V) temp.value;
		}
		while (temp != null) {			
			if (temp.key.equals(key)) {
				return (V) temp.value;
			}
			temp = temp.next;
		}
		return null;
		
	}
	
	public V remove(K key) {
		int h = key.hashCode();
		if (entries[h] == null)
			return null;
		Entry temp = entries[h];
		Entry previous = null;
		while (temp != null) {
			if (temp.key.equals(key)) {
				V val =(V) entries[h].getValue();
				if (previous == null) {					
					entries[h] = entries[h].next;					
				} else {
					previous.next = temp.next;
					temp.next = null;				
					
				}
				return (V) temp.getValue();
			}
			previous = temp;
			temp = temp.next;
			
		}
		return null;
	}
	static class Entry<K,V> {
		K key;
		V value;
		Entry next;
		private Entry(K key, V value) {			
			super();
			this.key = key;
			this.value = value;
		}
		private K getKey() {
			return key;
		}
		
		private V getValue() {
			return value;
		}
		
		
	}
	public static void main(String[] args) {
		
	}
	

}
