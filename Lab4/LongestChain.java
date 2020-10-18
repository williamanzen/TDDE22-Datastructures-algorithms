

class LongestChain {
    private Queue q; // kö som anänds i breddenförstsökningen
    private String goalWord; // slutord i breddenförstsökningen
    private int wordLength;
    private final char [] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			       'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			       's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å',
			       'ä', 'ö', 'é' };
    private int alphabetLength = alphabet.length;

    public LongestChain(int wordLength) {
	this.wordLength = wordLength;
	q = new Queue();
    }

    // IsGoal kollar om w är slutordet.
    private boolean isGoal(String w) {
	return w.equals(goalWord);
    }

    // makeChildren skapar alla ord som skiljer på en bokstav från x.
    // Om det är första gången i sökningen som ordet skapas så läggs det
    // in i kön q.
    private WordRec makeChildren(WordRec x) {
		char[] originalWord = x.getWord().toCharArray();
		for (int i = 0; i < wordLength; i++) {
			char[] temp = x.getWord().toCharArray();
			for (int c = 0; c < alphabetLength; c++) {
				if (alphabet[c] != originalWord[i]) {
					temp[i] = alphabet[c];
					String res = new String(temp);
					res = WordList.contains(res);
					if ( res != null && WordList.markAsUsedIfUnused(res)) {
						WordRec wr = new WordRec(res, x);
						if (isGoal(res)) {
							return wr;
						} 
					q.put(wr);
					}
				}
			}
		}
	return null;
    }

    // BreadthFirst utför en breddenförstsökning från startWord för att
    // hitta kortaste ägen till endWord. Den kortaste ägen returneras
    // som en kedja av ordposter (WordRec).
    // Om det inte finns något sätt att komma till endWord returneras null.
    public WordRec breadthFirst(String startWord, String endWord) {
	WordList.eraseUsed();

	WordRec start = new WordRec(startWord, null);
	WordList.markAsUsedIfUnused(startWord);
	goalWord = endWord;
	q.empty();
	q.put(start);
	try {
	    while (!q.isEmpty()) {
			// while (true) {
			WordRec temp = (WordRec) q.get();
			WordRec wr = makeChildren(temp);
			if (wr != null) {
		    	return wr;
			} else if ( q.isEmpty() && goalWord == null){
				return temp;
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
	    return null;
	}
	return null;
    }

    // CheckAllStartWords hittar den längsta kortaste ägen från något ord
    // till endWord. Den längsta ägen skrivs ut.
    public void checkAllStartWords(String endWord) {
	// int maxChainLength = 0;
	// WordRec maxChainRec = null;
	// for (int i = 0; i < WordList.size; i++) {
		// WordRec x = breadthFirst(WordList.wordAt(i), endWord);
		WordRec x = breadthFirst(endWord, null); // can not köra null
		int len = 0;
	    if (x != null) {
			len = x.chainLength();
		}
		// if (len > maxChainLength) {
		//     maxChainLength = len;
		//     maxChainRec = x;
		//     // x.PrintChain(); // skriv ut den hittills längsta kedjan
		// }
	    // }
	// }
	// System.out.println(endWord + ": " + maxChainLength + " ord");
	System.out.println(endWord + ": " + len + " ord");
	// if (maxChainRec != null) {
	//     maxChainRec.printChain();
	// }
	if(x != null) {
		x.backWardsPrint();
	}
    }
}
