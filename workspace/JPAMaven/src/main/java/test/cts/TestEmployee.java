package test.cts;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cts.entity.Employee;
import com.cts.repo.EmployeeRepo;

public class TestEmployee {
	
	private EmployeeRepo repo;
	@Before
	public void setup(){
		repo = new EmployeeRepo();
	}
	
//	@Test
	public void testEmployeeFetch(){
		List<Employee> employees = repo.fetchEmployees();
		System.out.println(employees);
		assertEquals(3, employees.size());
	}
	
//	@Test
	public void testEmployeeFetchLessThan50kSalary(){
		List<Employee> employees = repo.fetchEmployeesBySalaryLessThan(50000);
		System.out.println(employees);
		assertEquals(2, employees.size());
	}
	
	@Test
	public void testEmployeeInsert(){
		Employee emp = new Employee("CTS35335", "Janvi", "Delhi", 51000);
		repo.insertEmp(emp);
		assertTrue(true);
	}
//	@Test
	public void testFindEmployee(){
		Employee emp = repo.fetchEmp(2);
		assertEquals(emp.getName(), "Arun");
	}

}
