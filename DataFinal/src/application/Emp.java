package application;

public class Emp {
	
	String eid ;
	String eName ;
	String pID ;
	

	String phoneE ;
	
	public Emp(String eid, String eName,String pID, String phoneE) {
		super();
		eid = this.eid;
		eName = this.eName;
		pID = this.pID ;
		phoneE = this.phoneE;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getPhoneE() {
		return phoneE;
	}

	public void setPhoneE(String phoneE) {
		this.phoneE = phoneE;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", eName=" + eName + ", pID=" + pID + ", phoneE=" + phoneE + "]";
	}
}

