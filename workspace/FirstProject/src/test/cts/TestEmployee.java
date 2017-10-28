package test.cts;

import static org.junit.Assert.assertTrue;

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
	public void testEmployeeInsert(){
		Employee emp = new Employee("CTS3533", "Ravi", "Pune", 34233);
		repo.insertEmp(emp);
		assertTrue(true);
	}
	@Test
	public void testFindEmployee(){
		Employee emp = repo.fetchEmp(2);
		assertEquals(emp.getName(), "Ravi");
	}

}
