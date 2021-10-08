public class BigSib {

	private String msg;

	public BigSib() {
		msg = "Good morning and sun salutations";
	}

	public BigSib(String phrase) {
		msg = phrase;
	}

	public String greet(String name) {
		return msg + " " + name; 
	}
}
