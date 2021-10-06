/* Dunking Ducks (Humans: Daniel, Jason, Julia; Ducks: Ralph, Tiggy, Flopsy)
APCS
HW<10> -- <On Elder Individuality and the Elimination of Radio Fuzz>
<2021>-<10>-<05>
DISCOVERIES
Our goal is to make a method called greet that will intake the string and instead of printing it, 
it will rather return it so that we can print it in the main function
We use a different beginning of the method, specifiying the type of data it is outputting 
UNRESOLVED QUESTIONS
*/

public class BigSib {
	String msg;
	public static String setHelloMsg(String phrase) {
		msg = phrase;
	}
	public static String greet(String name) {
		return msg + " " + name; 
	}
}
