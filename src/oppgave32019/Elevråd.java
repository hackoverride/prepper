package oppgave32019;

public class Elevr�d extends Student{

	String klasse =""; 
	
	public Elevr�d(String n, int d, int m, double iq) {
		super(n, d, m, iq);
		setKlasse("A");
	}
	public void setKlasse(String x) {
		this.klasse = x;
	}

}
