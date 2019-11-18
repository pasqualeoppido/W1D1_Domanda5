/**
 * Package contenente i file .Java relativi all'esercitazione Eser2_JavaII_Pasquale_Oppido.
 */
package it.uiip.esercitazione2.pasquale_oppido;

/**
 * @author pasop
 * Classe che estende la classe BanckAccount, sovrascrivendo i metodi deposit() e withdraw() al fine di 
 * decurtare un ammontare pari al numero di transazioni effettuate sul conto che eccedono 
 * il numero di transazioni gratuite consentite.
 */
public class CheckingAccount extends BankAccount{

	public static final double T_FEE = 5;
	public static final int NUM_T_FREE = 5;
	
	private int tCount;
	
	public CheckingAccount(double initialBalance) {
		/**
		 * Costruttore che inizializza la superclasse con il valore initialBalance
		 * @param initialBalance rappresenta il saldo iniziale del conto
		 * (POST: il conto corrente ha un saldo pari a initialAmount)
		 */
		super(initialBalance);
		this.tCount = 0;
		
	}
	
	/**
	 * Metodo che deposita una quantità di denaro nel conto corrente, sovrascrive deposit() di BankAccount.
	 * (PRE: la quantità da depositare deve essere maggiore di zero)
	 * @param amount rappresenta la quantità che viene aggiunta al saldo.
	 * (POST: invocando getBalance() dopo che è stato effettuato un deposito restituisce il valore del saldo +
	 * il valore di amount che è stato depositato. Viene incrementato il contatore di operazioni tCount.)
	 */
	public void deposit(double amount) {
		super.deposit(amount);
		tCount++;
	}
	
	/**
	 * Metodo che preleva una quantità di denaro dal conto corrente, sovrascrive withdraw() di BankAccount.
	 * (PRE: la quantità da prelevare deve essere maggiore di zero oppure minore del saldo corrente)
	 * @param amount quantità che viene sottratta al saldo.
	 * (POST: invocando getBalance() dopo che è stato effettuato un deposito restituisce il valore del saldo -
	 * il valore di amount che è stato prelevato. Viene incrementato il contatore di operazioni tCount.)
	 */
	public void withdraw(double amount) {
		super.withdraw(amount);
		tCount++;
	}
	
	/**
	 * Metodo che preleva tasse dovute al numero di transazioni che supera il numero di transazioni gratuite.
	 * (POST: invocando getBalance() dopo che è stato effettuato un deposito restituisce il valore del saldo -
	 * il valore delle tasse che è direttamente proporzionale all'eccesso di numero di transazioni effettuate in un mese. 
	 * Il contatore tCount viene resettato a zero.)
	 */
	public void deductFees() {
		
		if(tCount > NUM_T_FREE) {
			
			super.withdraw(T_FEE*(tCount - NUM_T_FREE));
			
		}
		
		tCount = 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Override del motodo toString() della superclasse BankAccount aggiungendo il campo tCount.
	 */
	@Override
	public String toString() {
		return super.toString() + "[tCount=" + tCount + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 17 * hash + this.tCount;
		return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		CheckingAccount other = (CheckingAccount) obj;
		return this.tCount == other.tCount;
	}
	
	
	
	
	
}
