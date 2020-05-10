package oppgave32019;

public class Student {

	private String navn;
	private int fdato;
	private int fmnd;
	private double iq;
	
	public Student(String n, int d, int m, double iq) {
		this.navn = n;
		this.fdato = d;
		this.fmnd = m;
		this.iq = iq;
	}
	
	public void setIq(double i) {
		this.iq = i;
	}
	public double getIq() {
		return this.iq;
	}
	
	
	
	
	
	
	
}
