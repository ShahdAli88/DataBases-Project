package application;

public class Rent {
	
	String RId;
	int montlyRent;
    int yearlyRent;
    String Tax;
    String pID;
      
	public Rent(String rId, int montlyRent, int yearlyRent, String tax, String pID) {
		super();
		RId = rId;
		this.montlyRent = montlyRent;
		this.yearlyRent = yearlyRent;
		Tax = tax;
		this.pID = pID;
	}
	public String getRId() {
		return RId;
	}
	public void setRId(String rId) {
		RId = rId;
	}
	public int getMontlyRent() {
		return montlyRent;
	}
	public void setMontlyRent(int montlyRent) {
		this.montlyRent = montlyRent;
	}
	public int getYearlyRent() {
		return yearlyRent;
	}
	public void setYearlyRent(int yearlyRent) {
		this.yearlyRent = yearlyRent;
	}
	public String getTax() {
		return Tax;
	}
	public void setTax(String tax) {
		Tax = tax;
	}
	public String getPID() {
		return pID;
	}
	public void setPID(String pID) {
		this.pID = pID;
	}
    
    

}
