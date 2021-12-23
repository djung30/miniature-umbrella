public class Driver{
	public static void main(String[] args) {
		Rational r = new Rational(2,3);
		Rational s = new Rational(1,2);
		Rational t = new Rational(4,6);
		System.out.println(r.equals(t));
		System.out.println(r.equals(s));
		System.out.println(r.equals("Hello!"));
		System.out.println(r.compareTo(t));
		System.out.println(r.compareTo(s));
		System.out.println(s.compareTo(r));
		System.out.println(r.compareTo("Hello World"));		
	}
}
