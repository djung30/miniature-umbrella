/* Dynamic Duo (Humans: Daniel, Justin; Ducks: Ralph, Alfred)
APCS
HW 12 -- On Elder Individuality and the Elimination of Radio Fuzz
2021 10 05
DISCOVERIES
	We can refrence methods from different files 
	We can store information using methods from different files 
UNRESOLVED QUESTIONS
	What does static do/mean? 
*/

public class BigSib {
	String msg;
	public void setHelloMsg(String phrase) {
		msg = phrase;
	}
	public String greet(String name) {
		return msg + " " + name; 
	}
}
