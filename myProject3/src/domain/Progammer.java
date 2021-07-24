package domain;

import service.Status;


public class Progammer extends Employee {
	private int memberid;
	private Status status=Status.FREE;
	public Equipment equipment;
	public Progammer(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}
	public Progammer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return getDetails()+"\t程序员\t"+status+"\t\t\t"+equipment.getDescription();
	}
	public String getDetailsForTeam() {
		return memberid+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员";
	}
}
