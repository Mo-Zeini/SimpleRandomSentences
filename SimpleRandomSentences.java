package SimpleRandomSentences;
/**
 * This class has arrays of strings to produce random sentences in three syntax rules every three seconds.
 */


public class SimpleRandomSentences {
	
	// Arrays of strings.
	static final String[] conjunction = {"and", "or", "but", "because"};
	
	static final String[] proper_noun = {"Mido", "Maiada", "Johnny Depp", "Miss America"};
	
	static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};
	
	static final String[] determiner = {"a", "the", "every", "some"};
	
	static final String[] adjective = {"big", "tiny", "pretty", "bald"};
	
	static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};
	
	static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};
	
	public static void main(String[] args) {
		
		// This loop prints out each random sentence every 3 seconds.
		while (true) {
	         randomSentence(); // call the method randomSentence().
		     System.out.println(".\n\n");
	         try {
	             Thread.sleep(3000); // Hold 3 seconds.
	         }
	         catch (InterruptedException e) {
	         }
	      }
	}
	// This method calls two other methods that produce sentences in two different syntax rules.
	static void randomSentence() {
		randomNounPhrase(); // Call the method randomNounPhrase().
		randomVerbPhrase(); // Call the method randomVerbPhrase().
		if (Math.random() > 0.75) {
			System.out.print(" ");
			System.out.print(randomItem(conjunction)); // Call the method randomItem().
			randomSentence(); // Call the method to itself recursively.
		}
	}
	// This method produces random sentences in a noun syntax rule.
	static void randomNounPhrase() {
		if (Math.random() > 0.75) {
			System.out.print(" ");
			System.out.print(randomItem(proper_noun));
		}
		else {
			System.out.print(" " + randomItem(determiner));
			if (Math.random() > 0.5) {
				System.out.print(" ");
				System.out.print(randomItem(adjective));
			}
			System.out.print(" ");
			System.out.print(randomItem(common_noun));
			
			if (Math.random() > 0.5) {
				System.out.print(" ");
				System.out.print("who");
				randomVerbPhrase(); // Call the other method randomVerbPhrase().
			}
		}
	}
	// This method produces random sentences in a verb syntax rule.
	static void randomVerbPhrase() {
		if (Math.random() > 0.75) {
			System.out.print(" ");
			System.out.print(randomItem(intransitive_verb));
		}
		else if (Math.random() > 0.50) {
			System.out.print(" ");
			System.out.print(randomItem(transitive_verb));
			randomNounPhrase(); // Call the first method randomNounPhrase().
		}
		else if (Math.random() > 0.25) {
			System.out.print(" ");
			System.out.print("is");
			System.out.print(" ");
			System.out.print(randomItem(adjective));
		}
		else {
			System.out.print(" ");
			System.out.print("believes that");
			randomNounPhrase(); // Call the first method randomNounPhrase().
			randomVerbPhrase(); // Call the method to itself recursively.
		}
	}
	// This method takes random items to connect words with each other.
	static String randomItem(String[] listOfStrings) {
		return listOfStrings[(int)(Math.random()*listOfStrings.length)];
	}
}
