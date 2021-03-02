
import java.util.Scanner;

public class Problem3 {
	
	static char[] convertStringToCharArray(String stringToConvert) {
		
		// Create an array the same length of the string
		char[] charArr = new char[stringToConvert.length()];
		
		for(int i = 0; i < stringToConvert.length(); i++) {
			// break string into array
			charArr[i] = stringToConvert.charAt(i);
		}
		
		return charArr;
		
	}
	
	// Source: https://stackoverflow.com/questions/18581531/in-java-how-can-i-determine-if-a-char-array-contains-a-particular-character/18581682
	static boolean contains(char c, char[] array) {
		for(char x : array) {
			if( x == c) {
				return true;
			}
		}
		
		return false;
	}
	
	static String convertToPigLatin(String wordToConvert) {
		
		// init the word to return
		String pigWord = "";
		
		// init suffixes
		String suffix = "";
		
		// init punctuation
		// Source https://stackoverflow.com/questions/18410234/how-does-one-represent-the-empty-char/18410258
		String punct = "";
		
		// break word into array
		char[] stringArr = convertStringToCharArray(wordToConvert);
		
		// init vowel and consonant array
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		char[] consonants = { 
				'b', 'c', 'd', 
				'f', 'g', 'h', 
				'j', 'k', 'l', 
				'm', 'n', 'p', 
				'q', 'r', 's', 
				't', 'v', 'w', 
				'x', 'y', 'z',
				};
		
		char[] punctuation = { ',', '.', '?', '!' };
		
		// grab the first character of the word
		char firstChar = stringArr[0];
		
			
		if (contains(Character.toLowerCase(firstChar), vowels)) {
			// begins with vowel
			
			// TODO: exact word, only add "way" to the end
			suffix = "way";
			
			// TODO: Loop through each character and append punctuation at the end
			for(int i = 0; i < wordToConvert.length(); i++) {
				// Get the current character
				char ch = stringArr[i];
				
				// Determine if punctuation, if so append to punc item
				if(contains(ch, punctuation)) {
					punct += String.valueOf(ch);
				} else {
					pigWord += ch;
				}
			}
			
			// Specify the pig latin word
			pigWord = pigWord + suffix + punct;
			
			
		} else if (contains(Character.toLowerCase(firstChar), consonants)) {
			// begins with consonant
			
			// all letters in word up to first vowel
			// then "ay" and rest of word
			suffix = "ay";
			
			// TODO: How many characters until first vowel?
			boolean isReadingStart = false;
			boolean containsUpper = false;
			String end = "";
			String start = "";
			
			// loop through word and determine what to do
			for(int i = 0; i < stringArr.length; i++) {
				
				// specify which char is being operated on
				char target = stringArr[i];
				
				if(i == 0 && target == Character.toUpperCase(target)) {
					// Dealing with upper-cased word
					containsUpper = true;
				}
				
				// TODO: Determine if vowel, consonant, or punctuation
				// Sub: determine if reading
				
				if(contains(Character.toLowerCase(target), vowels)) {
					
					// Vowel
					if(!isReadingStart) {
						// flag here
						isReadingStart = true;
					}
					
					if(containsUpper && start.length() == 0) {
						// capitalize and continue to end of word
						start += String.valueOf(Character.toUpperCase(target));
					} else {
						// continue to end of word
						start += String.valueOf(Character.toLowerCase(target));
					}
					
					
				} else if(contains(Character.toLowerCase(target), punctuation)) {
					// punctuation
					punct += String.valueOf(target);
					
				} else if(contains(Character.toLowerCase(target), consonants)) {
					// consonant
					if(!isReadingStart) {
						// append to "end string"
						end += String.valueOf(Character.toLowerCase(target));
					} else {
						// continue to end of word
						start += String.valueOf(Character.toLowerCase(target));
					}
					
					
				}
				
				// add suffix and punctuation to both parts
				pigWord = start + end + suffix + punct;
				
				
			};
			
		}
	
		
		return pigWord;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO: Read in user input and cast
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter English word: ");
		
		String word = scan.next();
		scan.close();
		
		// TODO: Convert English word to Pig Latin
		String pigWord = convertToPigLatin(word);
		// Print to console
		System.out.println(word + " in Pig Latin is " + pigWord);

	}

}
