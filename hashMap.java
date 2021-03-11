
public class hashMap<K, V> {

	private int capacity = 20; // Default capacity of Map is 20

	private Entry<K, V>[] table;

	public hashMap() {
		table = new Entry[capacity];
	}

	public hashMap(int capacity) { 
		this.capacity = capacity;
		table = new Entry[capacity];
	}

	public void put(K key, V value) { // Put method
		int index = index(key);
		Entry newEntry = new Entry(key, value, null);
		if (table[index] == null) {
			table[index] = newEntry;
		} else {
			Entry<K, V> previousNode = null;
			Entry<K, V> currentNode = table[index];
			while (currentNode != null) {
				if (currentNode.getKey().equals(key)) {
					currentNode.setValue(value);
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if (previousNode != null)
				previousNode.setNext(newEntry);
		}
	}

	public V get(K key) { // Get method
		V value = null;
		int index = index(key);
		Entry<K, V> entry = table[index];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				break;
			}
			entry = entry.getNext();
		}
		return value;
	}

	public void remove(K key) { // Remove method
		int index = index(key);
		Entry previous = null;
		Entry entry = table[index];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				if (previous == null) {
					entry = entry.getNext();
					table[index] = entry;
					return;
				} else {
					previous.setNext(entry.getNext());
					return;
				}
			}
			previous = entry;
			entry = entry.getNext();
		}
	}

	public void display() { // Display method is to print all keys and values one by one
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> currentNode = table[i];
				while (currentNode != null) {
					System.out.println(String.format("Student ID: %s Student name: %s", currentNode.getKey(),
							currentNode.getValue()));
					currentNode = currentNode.getNext();
				}
			}
		}
	}
	public V contain(K key) { // Contain method
		V value = null;
		int index = index(key);
		Entry<K, V> entry = table[index];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				System.out.println("Student found in Hash Map!");
				break;
			}
			entry = entry.getNext();
		}
		return value;
	}

	private int index(K key) { // Index method 
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode() % capacity);
	}
}