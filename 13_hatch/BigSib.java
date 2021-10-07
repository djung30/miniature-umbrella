/* Tom & Jerry (Humans: Daniel, Justin; Ducks: Ralph, Alfred)
APCS
HW 13 -- Where do BigSibs Come From?
2021 10 06
DISCO
	
QCC
	 Still cannot exaclty wrap my head around exact details about constructors
*/
public class BigSib {
	private String msg;
	public setHelloMsg(String phrase) {
		setMsg(phrase);
	}
	public void setMsg(String phrase) {
		msg = phrase;
	}
	public String greet(String name) {
		return msg + " " + name; 
	}
}
