/* Tom & Jerry & Jason (Humans: Daniel, Justin, Jason; Ducks: Ralph, Alfred, Tiggy)
APCS
HW 14 -- Customize Your Creation
2021 10 07
DISCO
	
QCC
	
*/
public class BigSib {

	private String msg;

	public BigSib(String phrase) {
		msg = phrase;
	}

	public String greet(String name) {
		return msg + " " + name; 
	}
}
