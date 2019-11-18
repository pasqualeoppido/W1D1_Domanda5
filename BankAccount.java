/**
 * Package contenente i file .Java relativi all'esercitazione Eser1_JavaII_Gruppo_Capri.
 */
package it.uiip.esercitazione2.esercizio1;

/**
 * @author pasop
 * Classe che modella un conto corrente bancario.
 */
public class BankAccount implements Measurable {
	
	private double balance;
	
	/**
	 * Costruttore che inizializza il valore del saldo a zero.
	 */
	public BankAccount() {
		this(0);
	}
	
	/**
	 * Costruttore che inizializza il valore del saldo ad un valore iniziale.
	 * @param initialAmount valore che viene imposto come saldo.
	 * (POST: il conto corrente ha un saldo pari a initialAmount)
	 */
	public BankAccount(double initialAmount) {
		this.balance = initialAmount;
	}
	
	/**
	 * Metodo che deposita una quantità di denaro nel conto corrente.
	 * (PRE: la quantità da depositare deve essere maggiore di zero)
	 * @param amount quantità che viene aggiunta al saldo.
	 * (POST: invocando getBalance() dopo che è stato effettuato un deposito restituisce il valore del saldo +
	 * il valore di amount che è stato depositato.)
	 */
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Il valore da depositare è minore o uguale di zero.");
		}
		balance += amount;
	}
	
	
	/**
	 * Metodo che preleva una quantità di denaro dal conto corrente.
	 * (PRE: la quantità da prelevare deve essere maggiore di zero)
	 * @param amount quantità che viene sottratta al saldo.
	 * (POST: invocando getBalance() dopo che è stato effettuato un deposito restituisce il valore del saldo -
	 * il valore di amount che è stato prelevato.)
	 */
	public void withdraw(double amount) {
		if(amount < 0 || amount > balance) {
			throw new IllegalArgumentException("Il valore da prelevare non è consentito.");
		}
		balance -= amount;
	}
	
	/**
	 * Metodo che restituisce il valore del saldo.
	 * @return restituisce il valore del saldo.
	 * (POST: il valore del saldo del conto corrente rimane inalterato.)
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Metodo che restituisce il valore del saldo.
	 * @return restituisce il valore del saldo.
	 * (POST: il valore del saldo del conto corrente rimane inalterato.)
	 */
	public double getMeasure() {
		return balance;
	}
	
}
