import java.util.Arrays;

public class MHashMap<K,V> {

	private Entry[] entries;
	 MHashMap(int c) {
		entries = new Entry[c];
	}
	 int getHash(K k) {
		 return k.hashCode();
	 }
	 private void resize() {
		 entries = Arrays.copyOf(entries, 2*entries.length);
		 
	 }

	public V get(K key) {
		int h = getHash(key);
		if (entries[h] == null)
			return null;
		if (entries[h].getKey().equals(key)) {
			return (V) entries[h].getValue();
		}
		Entry<K, V> temp = entries[h];
		while (temp != null && !temp.getKey().equals(key))
			temp = temp.next;
		if (temp != null)
			return temp.getValue();
		else
			return null;

	}
	public void put (K key,V value) {
		int h = getHash(key);
		if (entries[h] == null) {
			entries[h] = new Entry<K, V>(key, value);
			return;
		}
		Entry<K,V> temp = entries[h];
		while (temp.next != null)
			temp = temp.next;
		temp.next = new Entry<K, V>(key, value);
		
	}
	public boolean remove(K key) {
		int h = getHash(key);
		if (entries[h] == null)
			return false;
		if (entries[h].next == null && entries[h].getKey().equals(key)) {		
			entries[h] = null;			
			return true;
		}
		Entry<K,V> temp = entries[h];
		Entry<K,V> index = null;
		while (temp != null) {
			if (temp.key.equals(key)) {
				if (index == null) {				
					entries[h] = entries[h].next;
					return true;					
					
				} else {
					index.next = temp.next;
					temp.next = null;
					return true;
				}
			}
			index = temp;
			temp = temp.next;
		}
		return false;
		
	}
	public void display() {
		for (int i=0; i < entries.length;i++) {
			if (entries[i] != null) {
				Entry temp = entries[i];
				while (temp !=null) {	
					System.out.print("{ "+temp.key+" "+temp.value+" }");
					 
					temp = temp.next;
				}
			}
		}
		System.out.println();
	}

	
	
	
	static class Entry<K,V> {		
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
			this.next = null;
		}

		K getKey() {
			return key;
		}
		
		V getValue() {
			return value;
		}
		
		
		
	}
	public static void main(String[] args) {
		MHashMap<Integer,Integer> map = new MHashMap<>(500);
		map.put(21,12);
		map.put(25, 121);
		map.put(53,84);
		map.display();
		map.put(21,77);
		map.display();
	
	
	    
	}

}
