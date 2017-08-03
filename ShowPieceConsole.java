import java.util.*;
import java.io.*;



public class ShowPieceConsole {

	public static void main(String[] args) throws IOException{
		
Scanner scanny = new Scanner(System.in);	

String now  = new Date().toString();
WriteOutput("\n" + now + "\n");

//int[] Que1Multiple= new int[3];
String[] choiceHappy={"Very unhappy", "Slightly unhappy", "Neutral", "Slightly happy" , "Very happy" };
//multipleChoice("Are you happy with your work environment?", choiceHappy);
//multipleChoice("Are you happy with your workplace?", choiceHappy);
//multipleChoice("Q-1: Are you happy with your manager?", choiceHappy);
//multipleChoice("Q-2: Are you happy with your team?", choiceHappy);

String[] choiceLikely = {"Very unlikely", "Slightly unlikely", "Neither likely nor unlikely", "Slightly likely", "Very Likely"};
multipleChoice("Q-1: How likely are you to recommend this job to a friend?", choiceLikely);
//multipleChoice("How likely are you to be encouraged to come up with new and better ways of doing things?", choiceLikely);

String[] choiceAgree = {"Disagree", "Slightly disagree", "No opinion", "Slightly agree", "Agree"};
multipleChoice("Q-2: I have the tools and resources to do my job well. ", choiceAgree);
//multipleChoice("The company clearly communicates its goals and strategies to me.", choiceAgree);
//multipleChoice("I receive adequate opportunity to interact with other employees on a formal level.", choiceAgree);
//multipleChoice("I have a clear path for career advancement", choiceAgree);
//multipleChoice("My job requirements are clear", choiceAgree);

String[] choiceTime = {"Less than 6 months", "6 months to 1 year", "1-3 years", "3-5 years", "More than 5 years"};
multipleChoice("Q-3: How long have you worked at the company?", choiceTime);

String[] choiceMotivated = {"Unsure", "Not at all motivated", "Not particularly Motivated", "Somewhat Motivated", "Very Motivated"};
multipleChoice("Q-4: Overall, how motivated are you to succeed?", choiceMotivated);

String[] choiceYN = {"Yes", "No"};
//multipleChoice("Have you observed or experienced racial discrimination?", choiceYN);
//multipleChoice("Have you observed or experienced sexual harassment?", choiceYN);
//multipleChoice("Have you observed or experienced gender discrimination?", choiceYN);
multipleChoice("Q-5: Have you observed or experienced sexual orientation discrimination?", choiceYN);



ShortQuestions("Q-6: What would you be doing if you were not at your job now? ");
//ShortQuestions("What is it that helps you to be productive and provide quality service? ");

	}

	public static void WriteOutput(String WriteThis) throws IOException{
		
		File file = new File("C:\\Users\\bhavat\\Desktop\\Feedback_Fin.csv");

		//creates file
		file.createNewFile();

		//creates fileWriter Obj
		FileWriter writer = new FileWriter(file, true); 

		//Writes the content to the file
		writer.write(WriteThis); 
		writer.flush();
		writer.close();

		
	}
	
	public static void ReadFile(String FileName) throws IOException{
		// Creates a FileReader Object
	      FileReader fr = new FileReader(FileName); 
	      char [] a = new char[50];
	      fr.read(a);   // reads the content to the array
	      
	      for(char c : a)
	         System.out.print(c);   // prints the characters one by one
	      fr.close();

	}
	
	
	
	public static void ShortQuestions(String Question) throws IOException{
		System.out.println("Please answer following");
		System.out.println(Question);
		Scanner userAnswer = new Scanner(System.in);
		System.out.println("Enter your answer: ");
		String answer= userAnswer.nextLine();
		WriteOutput(Question);
		WriteOutput("\n");
		WriteOutput(answer);
		WriteOutput("\n");

		
		
	}
public static void multipleChoice (String question, String[] responses) throws IOException {
		
		System.out.println(question);
		Scanner userInput= new Scanner(System.in);
		String answerOutput = "(Possible answer choices are as follows)\n";
		
		//string together possible answers for later printing
		for(int i = 0; i< responses.length; i++ ){
			int j=i+1;
			answerOutput += "\n"+j + ": " + responses[i] + "\n";
		}

		int userInt = -1;
		boolean ran = true;
		do {	
			if (ran){
				System.out.println(answerOutput);
				System.out.println("Enter your answer:");

				ran = false;
			} else {
				System.out.println("Please enter a valid response. ");
			}
			while (!userInput.hasNextInt()) {
				System.out.println("Please enter a valid number response.");
				userInput.next();
			}

			userInt = userInput.nextInt();
		} while (userInt <0 || userInt > responses.length);
		
		userInt -= 1;

		String test=responses[userInt];
		WriteOutput(question);
		WriteOutput("\n");
		WriteOutput(test);
		WriteOutput("\n");

		
	} 
}
	
