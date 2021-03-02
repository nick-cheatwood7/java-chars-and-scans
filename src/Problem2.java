
import java.util.Scanner;

public class Problem2 {
	
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
		
		// break word into array
		char[] stringArr = convertStringToCharArray(wordToConvert);
		
		// init vowel and consonant array
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
		
		// grab the first character of the word
		char firstChar = stringArr[0];
		
			
		if (contains(firstChar, vowels)) {
			// begins with vowel
			
			// TODO: exact word, only add "way" to the end
			suffix = "way";
			
			// store word array as a String
			pigWord = new String(wordToConvert + suffix);
			
		} else if (contains(firstChar, consonants)) {
			// begins with consonant
			
			// all letters in word up to first vowel
			// then "ay" and rest of word
			suffix = "ay";
			
			// TODO: How many characters until first vowel?
			
			boolean isReadingStart = false;
			String end = "";
			String start = "";
			
			// loop through word and determine what to do
			for(int i = 0; i < stringArr.length; i++) {
				
				// specify which char is being operated on
				char target = stringArr[i];
				
				if(contains(target, vowels) && !isReadingStart) {
					// flag here
					isReadingStart = true;
					// continue to end of word
					start += String.valueOf(target);
					
				} else if(isReadingStart) {
					// continue to end of word
					start += String.valueOf(target);
					
				} else if(!isReadingStart) {
					// append to "end string"
					end += String.valueOf(target);
					
				}
				
				// add suffix to both parts
				pigWord = start + end + suffix;
				
			};
			
		}
	
		
		return pigWord;
	};

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO: Read in user input and cast as lowercase
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter English word: ");
		
		String word = scan.next().toLowerCase();
		scan.close();
		
		// TODO: Convert English word to Pig Latin
		String pigWord = convertToPigLatin(word);
		// Print to console
		System.out.println(word + " in Pig Latin is " + pigWord);
		

	}

}
