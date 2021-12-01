public class Rational {
	int numerator;
	int denominator;
	
	public Rational() {
		denominator = 1;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public static void main(String[] args) {
		Rational rat = new Rational(); 
		System.out.println(rat.toString());
	}
}
