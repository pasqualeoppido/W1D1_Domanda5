/**
 * Package contenente i file .Java relativi all'esercitazione Eser2_JavaII_Pasquale_Oppido.
 */
package it.uiip.esercitazione2.pasquale_oppido;

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
	 * (PRE: il saldo iniziale non può essere una quantità minore di zero)
	 * @param initialAmount rappresenta il valore che viene imposto come saldo iniziale.
	 * (POST: il conto corrente ha un saldo pari a initialAmount)
	 */
	public BankAccount(double initialAmount) {
		if(initialAmount > 0 ) {
			this.balance = initialAmount;
		} else {
			throw new IllegalArgumentException("Il valore del saldo iniziale deve essere maggiore di zero.");
		}
		
	}
	
	/**
	 * Metodo che deposita una quantità di denaro nel conto corrente.
	 * (PRE: la quantità da depositare deve essere maggiore di zero)
	 * @param amount rappresenta la quantità che viene aggiunta al saldo.
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
	 * (PRE: la quantità da prelevare deve essere maggiore di zero oppure minore del saldo corrente)
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
	 * @return balance restituisce il valore del saldo.
	 * (POST: il valore del saldo del conto corrente rimane inalterato.)
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Metodo che restituisce il valore del saldo.
	 * @return balance restituisce il valore del saldo.
	 * (POST: il valore del saldo del conto corrente rimane inalterato.)
	 */
	public double getMeasure() {
		return balance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Metodo che sovrascrive il metodo toString della classe Object.
	 * Ritorna il nome della classe corrente e successivamente stampa i campi della classe.
	 */
	@Override
	public String toString() {
		return getClass().getName() + "[balance=" + balance + "]"; // possiamo usare getName() al posto di getSimpleName()
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + (int)this.balance;
		return hash;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return this.balance == other.balance;
	}

	
	
	
	
}
