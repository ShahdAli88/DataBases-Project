package application;

public class Tenant {
	
	String Tid;
	String Tname;
	String Accruedpayments;
	String Tphone;
	String PartnerPhone;
	String workPlace;
	String workType;
	String sId ;
    String deptsID;
    int age;
	
	
	
	public Tenant(String tid, String tname,String accruedpayments, String tphone, String workPlace,
			String workType, String sID,String deptsID, int age) {
		super();
		Tid = tid;
		Tname = tname;
		Accruedpayments = accruedpayments;
		Tphone = tphone;
		this.workPlace = workPlace;
		this.workType = workType;
		this.sId = sID;
		this.deptsID = deptsID;
		this.age = age;
	}
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getAccruedpayments() {
		return Accruedpayments;
	}
	public void setAccruedpayments(String accruedpayments) {
		Accruedpayments = accruedpayments;
	}
	public String getTphone() {
		return Tphone;
	}
	public void setTphone(String tphone) {
		Tphone = tphone;
	}
	public String getPartnerPhone() {
		return PartnerPhone;
	}
	public void setPartnerPhone(String partnerPhone) {
		PartnerPhone = partnerPhone;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getSId() {
		return sId;
	}
	public void setSId(String sId) {
		this.sId = sId;
	}
	public String getDeptsID() {
		return deptsID;
	}
	public void setDeptsID(String deptsID) {
		this.deptsID = deptsID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
