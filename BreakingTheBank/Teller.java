public class Teller{
	public static void main( String[] args ) {
	BankAccount test = new BankAccount();
	test.setName("Tater Tots");
	test.setPasswd("Taters123456");
	test.setPin((short) 12345);
	test.AcctNum(123456789);
	test.setBalance(600000000000000000000000000000000000000000000.00);
	test.deposit(400000000000000000000000000000);
	test.withdraw(10000000000000000000000000000000);
	System.out.println(test.toString());
	}
}
