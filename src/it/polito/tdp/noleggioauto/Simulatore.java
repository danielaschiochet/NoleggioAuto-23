package it.polito.tdp.noleggioauto;

import java.util.PriorityQueue;

public class Simulatore {
	
	// Modello del mondo
	private int nAuto ; // auto disponibili in questo momento
	
	// Parametri di ingresso
	private int NC ; // numero di auto totali acquistate
	private int T_IN ; // numero di minuti tra 2 arrivi di clienti (10 min)
	private int T_TRAVEL ; // durata minima del noleggio (60 min)
	private int MULT_TRAVEL ; // quanti T_TRAVEL al max posso avere (3)
	
	// Indicatori in uscita
	private int TOT_CLIENTI ; // clienti totali arrivati
	private int TOT_INSODDISFATTI ; // clienti a cui non avevo auto da affittare
	
	// Tipi di eventi (e coda degli eventi)
	private PriorityQueue<Event> queue ;

	public Simulatore(int nC, int t_IN, int t_TRAVEL, int mULT_TRAVEL) {
		super();
		NC = nC;
		T_IN = t_IN;
		T_TRAVEL = t_TRAVEL;
		MULT_TRAVEL = mULT_TRAVEL;
		
		this.nAuto = this.NC ;
		
		this.TOT_CLIENTI = 0 ;
		this.TOT_INSODDISFATTI = 0 ;
		
		this.queue = new PriorityQueue<Event>() ;
	} 
	
	public void run() {
		
	}
	
	public void initialize() {
		// simula l'arrivo dei clienti, uno ogni T_IN
	}

	public int getTOT_CLIENTI() {
		return TOT_CLIENTI;
	}

	public int getTOT_INSODDISFATTI() {
		return TOT_INSODDISFATTI;
	}
	
		

}
