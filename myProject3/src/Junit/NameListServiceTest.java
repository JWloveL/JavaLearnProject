package Junit;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service=new NameListService();
		Employee[] employee=service.getAllEmployees();
		for(int i=0;i<employee.length;i++) {
			System.out.println(employee[i]);
		}
	}
	@Test
	public void testEmployee() {
		int id=1;
		id=23;
		NameListService service=new NameListService();
		try {
			Employee employee=service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
