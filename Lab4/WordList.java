
import java.util.HashSet;
import java.util.Set;
import java.io.*;

// Klassen WordList innehåller en ordlista och en datastruktur som håller
// reda på använda ord.

class WordList {
    static private Set<String> list; // ordlista
    static private Set<String> used; // databas med använda ord
    static int wordLength;
    static int size; // antal ord i ordlistan

    // Read läser in en ordlista från strömmen input. Alla ord ska ha
    // wordLength bokstäver.
    static public void read(int wordLength_, BufferedReader input) throws IOException {
	wordLength = wordLength_;
	size = 0;
	list = new HashSet<String>();
	while (true) {
		String s = input.readLine();
		// char[] s = new char[wordLength];
		// input.read(s);
	    if (s.equals("#")) {
		break;
	    }
	    if (s.length() != wordLength) {
		System.out.println("Rad " + size +
				   " i filen innehåller inte " +
				   wordLength + " tecken.");
		}
	    list.add(s);
	    size++;
	}
	used = new HashSet<String>(size);
    }

    // Contains slår upp w i ordlistan och returnerar ordet om det finns med.
    // Annars returneras null.
    static public String contains(String w) {
	if (list.contains(w)) {
	    return w;
	}
	return null;
    }

    // MarkAsUsedIfUnused kollar om w är använt tidigare och returneras i så
    // fall false. Annars markeras w som använt och true returneras.
    static public boolean markAsUsedIfUnused(String w) {
		if (used.contains(w)) {
			return false;
		}
	used.add(w);
	return true;
    }

    // EraseUsed gör så att inga ord anses använda längre.
    static public void eraseUsed() {
	used.clear();
    }

}
