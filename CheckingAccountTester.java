/**
 * 
 */
package it.uiip.esercitazione2.pasquale_oppido;

/**
 * @author pasop
 *
 */
public class CheckingAccountTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CheckingAccount check1 = new CheckingAccount(1000);
		CheckingAccount check2 = new CheckingAccount(1000);
		
		/**
		 * Test equals di CheckingAccount
		 */
		if(check1.equals(check2)) {
			System.out.println("Test equals() CheckingAccount: OK");
		} else {
			System.out.println("Test equals() CheckingAccount: KO");
			System.out.println("check1:"+check1.toString() + "; check2:" + check2.toString());
		}
		/**
		 * Test hashcode() di CheckingAccount
		 */
		if(check1.hashCode() == check2.hashCode()) {
			System.out.println("Test hashCode() CheckingAccount: OK");
		} else {
			System.out.println("Test hashCode() CheckingAccount: KO");
			System.out.println("hash1:"+check1.hashCode() + "; hash2:" + check2.hashCode());
		}
		
		int tCount = 0;
		/**
		 * Test deposit(amount) di CheckingAccount
		 */
		check1.deposit(100);
		tCount++;
		double expectedBalance = 1100;
		if(expectedBalance == check1.getBalance()) {
			System.out.println("Test deposit() CheckingAccount: OK");
		} else {
			System.out.println("Test deposit() CheckingAccount: KO");
			System.out.println("expected:"+expectedBalance + "; actual:" + check1.getBalance());
		}
		
		/**
		 * Test withdraw(amount) di CheckingAccount
		 */
		check1.withdraw(100);
		tCount++;
		expectedBalance = 1000;
		if(expectedBalance == check1.getBalance()) {
			System.out.println("Test withdraw() CheckingAccount: OK");
		} else {
			System.out.println("Test withdraw() CheckingAccount: KO");
			System.out.println("expected:"+expectedBalance + "; actual:" + check1.getBalance());
		}
		
		check1.deposit(100);
		tCount++;
		check1.withdraw(100);
		tCount++;
		check1.deposit(100);
		tCount++;
		check1.withdraw(100);
		tCount++;
		check1.deposit(100);
		tCount++;
		
		/**
		 * Test deductFee() di CheckingAccount.
		 */
		check1.deductFees();
		
		expectedBalance = 1100 - ((tCount - CheckingAccount.NUM_T_FREE) * CheckingAccount.T_FEE );
		if(expectedBalance == check1.getBalance()) {
			System.out.println("Test deductFee() CheckingAccount: OK");
		} else {
			System.out.println("Test deductFee() CheckingAccount: KO");
			System.out.println("expected:"+expectedBalance + "; actual:" + check1.getBalance());
		}
		/**
		 * Test toString() CheckingAccount
		 */
		System.out.println(check1.toString());
	}

}
