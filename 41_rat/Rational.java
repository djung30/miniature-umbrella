/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW41 -- Be Rational
 * 2021-12-01
 * time spent: 0.4hrs
 * QCC:
 * Disco:
    - You can use an object of the class you're defining as a parameter in a method of that class.
		- For instance, Rational methods can take other Rationals as input.
 ***/

public class Rational {
	public int numerator;
	public int denominator;

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

	public static void main(String[] args) {
		//Test for default constructor
		Rational rat = new Rational();
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		//Test for paramaterized constructor
		rat = new Rational(1,2);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		//Test for divZero handling
		rat = new Rational(4,0);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		//Test for multiplication
		rat = new Rational(1,2);
		Rational mouse = new Rational(2,3);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		rat.multiply(mouse);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		//Test for division
		rat = new Rational(4,1);
		mouse = new Rational(2,3);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		rat.divide(mouse);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		//Test for division by zero
		rat = new Rational(1,2);
		mouse = new Rational(0,1);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
		rat.divide(mouse);
		System.out.println("Fraction: " + rat.toString());
		System.out.println("Decimal: " + rat.floatValue());
	}
}
