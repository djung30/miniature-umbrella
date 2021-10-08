public class BigSib {

	private String msg;

	public BigSib(String phrase) {
		setMsg(phrase);
	}

	public void setMsg(String phrase) {
		msg = phrase;
	}

	public String greet(String name) {
		return msg + " " + name; 
	}
}
