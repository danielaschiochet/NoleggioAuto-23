package it.polito.tdp.noleggioauto;

import java.util.PriorityQueue;

import it.polito.tdp.noleggioauto.Event.EventType;

public class Simulatore {
	
	// Modello del mondo
	private int nAuto ; // auto disponibili in questo momento
	
	// Parametri di ingresso
	private int NC ; // numero di auto totali acquistate
	private int T_IN ; // numero di minuti tra 2 arrivi di clienti (10 min)
	private int T_TRAVEL ; // durata minima del noleggio (60 min)
	private int MULT_TRAVEL ; // quanti T_TRAVEL al max posso avere (3) - moltiplicatore
	
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
		
		//inizializzo lo stato del mondo
		this.nAuto = this.NC ;
		
		this.TOT_CLIENTI = 0 ;
		this.TOT_INSODDISFATTI = 0 ;
		
		//inizializzo la coda degli eventi (vuota)
		this.queue = new PriorityQueue<Event>() ;
	} 
	
	public void run() { //metodo x eseguire la simulazione
		
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll();
			int time = e.getTime();
			EventType type = e.getType();
			System.out.println(e.getType()+" al tempo "+time);
			
			switch(type) {
			case NUOVO_CLIENTE:
				//cosa fare quando arriva un nuovo cliente:
				if(nAuto>0) {
					//caso 1: posso affittare
					this.TOT_CLIENTI++;
					this.nAuto--;
					
					int durata = this.T_TRAVEL*(int)(1+Math.random()*this.MULT_TRAVEL);
					this.queue.add(new Event(time+durata, EventType.RESTITUZIONE_AUTO));
				}else {	
					//caso2: devo mandarlo via
					this.TOT_CLIENTI++;
					this.TOT_INSODDISFATTI++;
				}
				break;
				
			case RESTITUZIONE_AUTO:
				this.nAuto++;
				break;
			}
		}
	}
	
	public void initialize() { //metodo x inizializzare la coda
		// simula l'arrivo dei clienti, uno ogni T_IN
		for(int time=0; time<8*60; time=time+T_IN) {
			this.queue.add(new Event(time, EventType.NUOVO_CLIENTE)); //lo aggiungo nella coda
		}
	}

	//metodi x estrarre i clienti e gli insoddisfatti (i valori di interesse)
	public int getTOT_CLIENTI() {
		return TOT_CLIENTI;
	}

	public int getTOT_INSODDISFATTI() {
		return TOT_INSODDISFATTI;
	}
	
		

}
