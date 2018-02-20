	import java.util.*;
	import java.io.*;
public class GroupProject2_6 {

	public static void main(String[] args) throws FileNotFoundException {
			Scanner input1 = new Scanner(new File("test"));
			readWordsAndSentences(input1);
		}
		
		public static void readWordsAndSentences(Scanner console) {
			int sentences = 0;
			int words = 0;
			boolean isActualWork = false;
			int actualSentences = 0;
			int actualWords = 0;
			
			
			while(console.hasNextLine()) {
				String line = console.nextLine();
				while(line.length() == 0 && console.hasNextLine()) {
					line = console.nextLine();
				}
				Scanner lineScan = new Scanner(line);
				
		         if (isActualWork == false && line.toLowerCase().contains("the war of the worlds")) {
		             isActualWork = true; 
		          }
				
				//Will make sure that if the line ends with a . or ! or ? or ." or ?" 
		         //it will count it as a sentence.
		         //this code will ignore cases like St. or Dr. or Mrs. as well as abbreviations of names
				if(line.length() != 0) {
				int positionInLine = 0;
				if(line.endsWith(".") || line.endsWith("!") || line.endsWith("?") || line.endsWith(". ") || line.endsWith(".\"") ) {
					sentences++;
					if(isActualWork) {
						actualSentences++;
					}
				} 
				//Most sentences in etexts end with two spaces and this part checks it.
				char first = line.charAt(0);
				while (positionInLine < line.length()) {
					char second = line.charAt(positionInLine);
					//will stop at the first period in the line that is not at the end of the line and will check if there are 2 spaces proceeding it.
					if(second == '.' && !(line.endsWith(".") || (line.endsWith(". ")) || line.endsWith(".\"")   )) {
						//the range from period to 2 further down to check if it is either a .  or a ." 
						String sentenceCheck = line.substring(positionInLine, positionInLine+3);
						if(sentenceCheck.equals(".  ") || sentenceCheck.equals(".\" ")) {
							sentences++;
							if(isActualWork) {
								actualSentences++;
							}
						}
					
					}
					//cases where sentences don't end in a period
					 if((first == '?' && second == '\'') || (first == '?' && second == '"') ||
							(first == '!' && second == '"') || (first == '!' && second == ' ')) {
						sentences++;
						if(isActualWork) {
							actualSentences++;
						}
					} 
					first = second;
					positionInLine++;
				}
				
				
				while(lineScan.hasNext()) {
					String words2 = lineScan.next();
					words++;
					if(isActualWork) {
						actualWords++;
					}
				}
				
			}
				lineScan.close();

			}
			System.out.println("words " + words);
			System.out.println("sentences " + sentences);
			System.out.println("actual sentences " + actualSentences);
			System.out.println("actual words " + actualWords);

		}

	
}
	
