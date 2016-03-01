package interview;
public class WePay<K, V> {

    /**
     * Main data structure that will hold all the key value pairs
     */
    private MapEntry<K, V>[] data_structure;
    /**
     * Fixing the capacity to 4 Ideally this capacity should be increased by
     * powers of 2
     */
    private int capacity = 4;

    /**
     * Maintaining a linked list of entries
     * 
     * @author Ankit
     *
     * @param <K>
     * @param <V>
     */
    static class MapEntry<K, V> {
	K key;
	V value;
	MapEntry<K, V> next;

	public MapEntry(K key, V value, MapEntry<K, V> next) {
	    this.key = key;
	    this.value = value;
	    this.next = next;
	}
    }

    public WePay() {
	data_structure = new MapEntry[capacity];
    }

    /**
     * Simple hash function
     * 
     * @param key
     * @return
     */
    private int hash(K key) {
	return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * put a new entry
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value) {
	if (key == null)
	    return;
	int hash = hash(key);
	MapEntry<K, V> newEntry = new MapEntry<K, V>(key, value, null);

	/**
	 * if the tables entry at index hash position is empty then we can
	 * directly put there
	 */
	if (data_structure[hash] == null) {
	    data_structure[hash] = newEntry;
	} else {
	    /**
	     * otherwise we traverse the linked list and put it at the next null
	     * position
	     */
	    MapEntry<K, V> prev = null;
	    MapEntry<K, V> curr = data_structure[hash];

	    while (curr != null) {
		if (curr.key.equals(key)) {
		    if (prev == null) {
			newEntry.next = curr.next;
			data_structure[hash] = newEntry;
			return;
		    } else {
			newEntry.next = curr.next;
			prev.next = newEntry;
			return;
		    }
		}
		prev = curr;
		curr = curr.next;
	    }
	    prev.next = newEntry;
	}
    }

    /**
     * @param key
     */
    public V get(K key) {
	
	int hash = hash(key);
	if (data_structure[hash] == null) {
	    return null;
	} else {
	    MapEntry<K, V> temp = data_structure[hash];
	    while (temp != null) {
		if (temp.key.equals(key))
		    return temp.value;
		temp = temp.next;
	    }
	    return null;
	}
    }

}