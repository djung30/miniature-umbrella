/* The Tator Tots (Humans: Daniel, Justin, Ari; Ducks: Ralph, Alfred, Javier)
APCS
HW20: External Audit
2021 10 19

QCC:
- What does it really mean to break an object? Does it involve run-time errors? 

Disco:

*/

public class Teller{
	public static void main( String[] args ) {
	
	// Test case
	BankAccount test = new BankAccount();
	test.setName("Tater Tots");
	test.setPasswd("Taters123456");
	test.setPin((short) 1234);
	test.setAcctNum(123456789);
	test.setBalance(60000000.00);
	test.deposit(4000.00);
	test.withdraw(1000);
	System.out.println(test.toString());
/*
	// Breaking The Bank
	BankAccount hack = new BankAccount();
	hack.setName("Tater Tots");
	hack.setPasswd("Taters123456");
	hack.setPin((short) 12345);
	hack.setAcctNum(123456789);
	hack.setBalance(1);
	hack.deposit(01000);
	hack.withdraw(80);
	System.out.println(hack.toString());
	}
	*/
	// Breaking The Bank error
	/*
	BankAccount test = new BankAccount();
	test.setName("Tater Tots");
	test.setPasswd("Taters123456");
	test.setPin((short) 12345);
	test.setAcctNum(123456789);
	test.setBalance(600000000000000000000000000000000000000000000.00);
	test.deposit(400000000000000000000000000000);
	test.withdraw(10000000000000000000000000000000);
	System.out.println(test.toString());
	*/
	}
}
