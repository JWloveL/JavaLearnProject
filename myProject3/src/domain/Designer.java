package domain;

public class Designer extends Progammer{
	private double bonus;


	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 * @param equipment
	 */
	public Designer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary,equipment);
	}

	public Designer(int id, String name, int age, double salary, double bonus,Equipment equipment) {
		super(id, name, age, salary,equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t"+equipment.getDescription();
	}
	public String getDetailsForTeam() {
		return getMemberid()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t设计师\t"+getBonus();
	}
	
}
