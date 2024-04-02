package application;

public class property {
	
	String pid;
	String ptype;
	String pLocation;
	String pSize;
	String Tid;
	int monthlyrent;
	
	
	
	
	
	public property(String pid, String ptype, String pLocation, String pSize, String tid) {
		super();
		this.pid = pid;
		this.ptype = ptype;
		this.pLocation = pLocation;
		this.pSize = pSize;
		Tid = tid;
	}



	public property(String propertyId, String propertyLocation, String size, int monthlyRent2) {
		this.pid = propertyId;
		this.monthlyrent = monthlyRent2;
		this.pLocation = propertyLocation;
		this.pSize = size;
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getPtype() {
		return ptype;
	}



	public void setPtype(String ptype) {
		this.ptype = ptype;
	}



	public String getPLocation() {
		return pLocation;
	}



	public void setPLocation(String pLocation) {
		this.pLocation = pLocation;
	}



	public String getPSize() {
		return pSize;
	}



	public void setPSize(String pSize) {
		this.pSize = pSize;
	}



	public String getTid() {
		return Tid;
	}



	public void setTid(String tid) {
		Tid = tid;
	}



	public int getMonthlyrent() {
		return monthlyrent;
	}



	public void setMonthlyrent(int monthlyrent) {
		this.monthlyrent = monthlyrent;
	}
	
	
}