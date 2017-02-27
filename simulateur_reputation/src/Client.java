
public class Client {
	private int cap;
	private int duree;
	
	Client() {
		setCap(1000);
		setDuree(10);
	}
	
	Client(int c, int d) {
		setCap(c);
		setDuree(d);
	}
	
	public int getCap() {
		return cap;
	}
	
	public void setCap(int cap) {
		if(cap >= 0)
			this.cap = cap;
	}
	
	public int getDuree() {
		return duree;
	}
	
	public void setDuree(int duree) {
		if(duree >= 0)
			this.duree = duree;
	}

}
