public class SymbolTable {
	private static final int INIT_CAPACITY = 7;

	/* Number of key-value pairs in the symbol table */
	private int N;
	/* Size of linear probing table */
	private int M;
	/* The keys */
	private String[] keys;
	/* The values */
	private Character[] vals;

	/**
	 * Create an empty hash table - use 7 as default size
	 */
	public SymbolTable() {
		this(INIT_CAPACITY);
	}

	/**
	 * Create linear probing hash table of given capacity
	 */
	public SymbolTable(int capacity) {
		N = 0;
		M = capacity;
		keys = new String[M];
		vals = new Character[M];
	}

	/**
	 * Return the number of key-value pairs in the symbol table
	 */
	public int size() {
		return N;
	}

	/**
	 * Is the symbol table empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Does a key-value pair with the given key exist in the symbol table?
	 */
	public boolean contains(String key) {
		return get(key) != null;
	}

	/**
	 * Hash function for keys - returns value between 0 and M-1
	 */
	public int hash(String key) {
		int i;
		int v = 0;
		for (i = 0; i < key.length(); i++) {
			v += key.charAt(i);
		}
		return v % M;
	}

	/**
	 * Insert the key-value pair into the symbol table
	 */
	public void put(String key, Character val) {
		if (key == null) {
			return;
		} else if (val == null) {
			delete(key);
			return;
		}
		int index = hash(key);
		for (int i=index;i<index+M;i++) {
			if (keys[i % M] == null) {
				keys[i % M]=key;
				vals[i % M]=val;
				N+=1;
				return;
			} else if (keys[i % M].equals(key)) {
				vals[i % M]=val;
				return;
			}
		}
		return;
	} // dummy code

	/**
	 * Return the value associated with the given key, null if no such value
	 */
	public Character get(String key) {
		int index = hash(key);
		for (int i=index;i<index+M;i++) {
			if (keys[i % M] != null && keys[i % M].equals(key)) {
				return vals[i % M];
			}
		}
		return null;
	} // dummy code

	/**
	 * Delete the key (and associated value) from the symbol table
	 */
	public void delete(String key) {
		if (!contains(key)) {
			return;
		}
		boolean deleted = false;
		int index = hash(key);
		for (int i=index;i<index+M;i++) {
			if(!deleted){
				if (keys[i % M].equals(key)) {
					keys[i % M]=null;
					vals[i % M]=null;
					N-=1;
					deleted = true;
				}
			} else {
				if (keys[i%M] != null && hash(keys[i % M]) != i % M) {
					String tempKey = keys[i % M];
					Character tempVal = vals[i % M];
					keys[i % M]=null;
					vals[i % M]=null;
					N-=1;
					put(tempKey, tempVal);
				}
			}
		}
		return;
	} // dummy code

	/**
	 * Print the contents of the symbol table
	 */
	public void dump() {
		String str = "";

		for (int i = 0; i < M; i++) {
			str = str + i + ". " + vals[i];
			if (keys[i] != null) {
				str = str + " " + keys[i] + " (";
				str = str + hash(keys[i]) + ")";
			} else {
				str = str + " -";
			}
			System.out.println(str);
			str = "";
		}
	}
}
