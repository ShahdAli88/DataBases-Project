package application;

import java.sql.Date;
import java.util.Objects;

public class Contract {
	
	String Cid;
	String Pid;
	String Eid;
	String Tid;
	
	String Curreny;
	
	String C_Date;
	String exp_Date;
	String dueDate;
	
	String settiementAgreement;
	String paymentnethode;
	
	public Contract(String cid, String pid, String eid, String tid, String curreny, String c_Date, String exp_Date,String dueData, String settiementAgreement, String paymentnethode) {
		super();
		Cid = cid;
		Pid = pid;
		Eid = eid;
		Tid = tid;
		Curreny = curreny;
		C_Date = c_Date;
		this.exp_Date = exp_Date;
		this.dueDate = dueData;
		this.settiementAgreement = settiementAgreement;
		this.paymentnethode = paymentnethode;
	}
	
	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		Pid = pid;
	}

	public String getEid() {
		return Eid;
	}

	public void setEid(String eid) {
		Eid = eid;
	}

	public String getTid() {
		return Tid;
	}

	public void setTid(String tid) {
		Tid = tid;
	}

	public String getCurreny() {
		return Curreny;
	}

	public void setCurreny(String curreny) {
		Curreny = curreny;
	}

	public String getC_Date() {
		return C_Date;
	}

	public void setC_Date(String c_Date) {
		C_Date = c_Date;
	}

	public String getExp_Date() {
		return exp_Date;
	}

	public void setExp_Date(String exp_Date) {
		this.exp_Date = exp_Date;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
	    this.dueDate = dueDate;
	}
	
	public String getSettiementAgreement() {
		return settiementAgreement;
	}

	public void setSettiementAgreement(String settiementAgreement) {
		this.settiementAgreement = settiementAgreement;
	}

	public String getPaymentnethode() {
		return paymentnethode;
	}

	public void setPaymentnethode(String paymentnethode) {
		this.paymentnethode = paymentnethode;
	}

	@Override
	
	public String toString() {
		return "Contract [Cid=" + Cid + ", Pid=" + Pid + ", Eid=" + Eid + ", Tid=" + Tid + ", Curreny=" + Curreny
				+ ", C_Date=" + C_Date + ", exp_Date=" + exp_Date + ", dueData=" + dueDate + ", settiementAgreement="
				+ settiementAgreement + ", paymentnethode=" + paymentnethode + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}