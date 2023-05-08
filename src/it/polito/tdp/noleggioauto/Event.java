package it.polito.tdp.noleggioauto;

public class Event implements Comparable<Event> {
	
	public enum EventType {
		NUOVO_CLIENTE,
		RESTITUZIONE_AUTO
	}
	
	private int time ; // minuti dell'evento (minuti da inizio giornata)
	private EventType type ; // tipo di evento
	
	public Event(int time, EventType type) {
		super();
		this.time = time;
		this.type = type;
	}
	public int getTime() {
		return time;
	}
	public EventType getType() {
		return type;
	}
	
	
	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + "]";
	}
	@Override
	
	public int compareTo(Event other) {
		return this.time-other.time;
	}
	
	
	

}
