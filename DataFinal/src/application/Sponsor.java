package application;

public class Sponsor {
	String Sid;
	String Sname;
	String Sphone;
	public Sponsor(String sid, String sname, String sphone) {
		super();
		Sid = sid;
		Sname = sname;
		Sphone = sphone;
	}
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSphone() {
		return Sphone;
	}
	public void setSphone(String sphone) {
		Sphone = sphone;
	}
	
	

}
