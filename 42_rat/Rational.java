/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW42 -- Be More Rational
 * 2021-12-05
 * time spent: 0.2hrs
 * QCC:
 * Disco:
    - You don't have to reduce to add two Rationals, just find a common denominator that is guaranteed to work.
 ***/

public class Rational {
	private int numerator;
	private int denominator;

	public Rational() {
		denominator = 1;
	}

	public Rational(int n, int d){
		numerator = n;
		denominator = d;
		divZero();
	}

	void divZero(){
		if(denominator == 0){
			denominator = 1;
			numerator = 0;
			System.out.println("Division by zero occured! Resetting rational to default");
		}
	}
	public double floatValue(){
		return ((double) numerator)/((double) denominator);
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

	public void multiply(Rational r) {
		numerator *= r.numerator;
		denominator *= r.denominator;
	}

	public void divide(Rational r) {
		numerator *= r.denominator;
		denominator *= r.numerator;
		divZero();
	}

	public int gcd() {
		int a = this.numerator;
		int b = this.denominator;
		int c;
		while (a*b != 0) { //Are either a or b zero?
			c = a%b;
			a = b;
			b = c;
		}
		return a+b; //Return the nonzero one
	}

	public void reduce(){
		int g = this.gcd();
		this.numerator /= g;
		this.denominator /= g;
	}

	public int compareTo(Rational r) {
		if(this.floatValue() == r.floatValue()){
			return 0;
		}
		else if (this.floatValue() > r.floatValue()) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public void add(Rational r) {
		this.numerator = this.numerator*r.denominator+ this.denominator*r.numerator;
		this.denominator = this.denominator*r.denominator;
	}
	public void subtract(Rational r) {
		this.numerator = this.numerator*r.denominator - this.denominator*r.numerator;
		this.denominator = this.denominator*r.denominator;
	}
	public static void main(String[] args) {
		Rational r = new Rational(2,3); //Stores the rational number 2/3
		Rational s = new Rational(1,2); //Stores the rational number 1/2
		Rational t = new Rational(4,18); //Stores the rational number 4/18
		r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
		t.reduce(); //Changes t to 2/9
		System.out.println(r);
		System.out.println(s);
		System.out.println(t);
		System.out.println(r.compareTo(s));
		System.out.println(r.compareTo(r));
		System.out.println(s.compareTo(r));
	}
}
