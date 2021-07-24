package service;

import static service.Data.*;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Progammer;
public class NameListService {
	private Employee[] employees;
	
	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
		employees=new Employee[EMPLOYEES.length];
		for(int i=0;i<employees.length;i++) {
			int type=Integer.parseInt(EMPLOYEES[i][0]);
			int id=Integer.parseInt(EMPLOYEES[i][1]);
			String name=EMPLOYEES[i][2];
			int age=Integer.parseInt(EMPLOYEES[i][3]);
			double salary=Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			switch(type) {
				case EMPLOYEE:
					employees[i]=new Employee(id, name, age, salary);
					break;
				case PROGRAMMER:
					equipment=createNewEquipment(i);
					employees[i]=new Progammer(id, name, age, salary, equipment);
					break;
				case DESIGNER:
					equipment=createNewEquipment(i);
					bonus=Double.parseDouble(EMPLOYEES[i][5]);
					employees[i]=new Designer(id, name, age, salary, bonus, equipment);
					break;
				case ARCHITECT:
					equipment=createNewEquipment(i);
					bonus=Double.parseDouble(EMPLOYEES[i][5]);
					stock=Integer.parseInt(EMPLOYEES[i][6]);
					employees[i]=new Architect(id, name, age, salary, equipment, bonus,stock);
					break;	
			}
		}
	}
	/**
	 * 获取指定index上员工的设备
	 * @param index
	 * @return
	 */
	private Equipment createNewEquipment(int index) {
		// TODO Auto-generated method stub
		int key=Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrName=EQUIPMENTS[index][1];
		switch(key) {
			case PC:
				return new PC(modelOrName, EQUIPMENTS[index][2]);
			case NOTEBOOK:
				return new NoteBook(modelOrName, Double.parseDouble(EQUIPMENTS[index][2]));
			case PRINTER:
				return new Printer(modelOrName, EQUIPMENTS[index][2]);
		}
		return null;
	}
	public Employee[] getAllEmployees() {
		return employees;
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId()==id)
				return employees[i];
		}
		throw new TeamException("找不到指定员工");
	}
}
