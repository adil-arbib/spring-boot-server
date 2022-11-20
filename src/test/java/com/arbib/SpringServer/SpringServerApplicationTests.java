package com.arbib.SpringServer;

import com.arbib.SpringServer.model.employee.Employee;
import com.arbib.SpringServer.model.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("ali");
		employee.setBranch("info");
		employee.setLocation("building-2");
		employeeDao.save(employee);
	}

	@Test
	void getAllEmployeesTest(){
		List<Employee> employees = employeeDao.getAllEmployees();
		System.out.println(employees);
	}

	@Test
	void getAllEmployeesAndDeleteThemTest(){
		List<Employee> employees = employeeDao.getAllEmployees();
		for(Employee employee : employees){
			employeeDao.delete(employee);
		}
	}

}
