public class Greet {
 	public static void main (String [] args) {
		greet("Jones");
		greet("Mack");
		greet("Kevin");
	}
  	public static void greet (String name) {
  		System.out.println("Good morning "+name+", it is my pleasure to see you on this scrumptious day!");
  	}
}
/* 
	DISCOVERIES
		You can create functions outside of the main code block and call upon them in mid
		Method to allow a string input into the function that was then used as a name 

	UNRESOLVED QUESTIONS
		Why does activating javac not create a class file in the github repo?
			Possibly because we are not pushing the class file to git? 
*/
