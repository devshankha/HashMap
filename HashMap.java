import java.util.Iterator;

public class HashMap <K,V> {
	private Entry<K,V> table[];
	private int capacity=500;
	@SuppressWarnings("unchecked")
	public HashMap() {
		table = new Entry[capacity];
	}

	
	int getHash(Object k) {
		return k.hashCode();
		
	}
	
	public void display(){
	       
	       for(int i=0;i<capacity;i++){
	           if(table[i]!=null){
	                  Entry<K, V> entry=table[i];
	                  while(entry!=null){
	                        System.out.print("{"+" "+entry.value+" "+"}" +" ");
	                        entry=entry.next;
	                  }
	           }
	       }             
	    
	    }
	
	public boolean remove (K key) {
		int val = getHash(key);
		if (table[val]== null)
			return false;
		if (table[val].next == null && table[val].key.equals(key)) {
			table[val] = null;
			return true;
		}
		Entry<K,V> temp = table[val];
		Entry<K,V> index = null;
		while(temp != null) {
			if (temp.key.equals(key)) {
				index.next = temp.next;
				temp.next = null;
				return true;
				
			}
			index = temp;
			temp = temp.next;
		}
		
		return false;
		
	}

	public void put(K key, V value) {
		if(key == null)
			throw new IllegalArgumentException();
		int val = getHash(key);
		System.out.println("In put , the hashcode " + val);
		if (table[val] == null) {
			table[val] = new Entry(key, value);
			return;
		} else {
			Entry<K,V> last = null;
			Entry<K,V> temp = table[val];
			while (temp != null) {
				if (temp.key.equals(key)) {
					/*Entry<K, V> index = temp.next;
					last.next = new Entry(key, value);
					last.next.next = index*/;
					temp.value = value;
					return;
				}
				last = temp;
				temp = temp.next;
								
			}
			last.next = new Entry(key,value);
			
			
		}

	}
	public V get(K key) {
	
		int val = key.hashCode();
		Entry<K,V> temp = table[val];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.getValue();
			}
			temp = temp.next;
		}
		return null;
		
	}
	Iterator iterator() {
		
		return new MyIterator();
		
	}
	 class MyIterator implements Iterator {
		 int index = 0;

		@Override
		public boolean hasNext() {
			Entry<K,V> temp = table[index];
			int count = index;
			for (count =index; count < capacity;count++) {
				if (table[count] != null)
					return true;				
				
			}
			return false;
			
			
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Entry<K,V> temp = table[index];
			int count = index;
			for (count =index; count < capacity;count++) {
				if (table[count] != null) {
					break;
				}
				
			}
			index = count;
			
			return table[index];
		}
		
	}
	
	
	static class Entry<K,V> {
		 K getKey() {
			return key;
		}
		 V getValue() {
			return value;
		}
		public Entry(K key, V value) {			
			this.key = key;
			this.value = value;
		}
		K key;
		V value;
		Entry<K,V> next;
		
		
		
	}

}
