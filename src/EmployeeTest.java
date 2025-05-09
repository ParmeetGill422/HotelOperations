import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testPunchInAndOutCalculatesTimeCorrectly() {
        Employee emp = new Employee("E001", "Parmeet", "Front Desk", 20.0);

        emp.punchIn(10.0);
        emp.punchOut(14.5); // 4.5 hours

        assertEquals(4.5, emp.getRegularHours(), 0.01);
        assertEquals(0.0, emp.getOvertimeHours(), 0.01);
        assertEquals(90.0, emp.getTotalPay(), 0.01);
    }

    @Test
    public void testOvertimePayCalculation() {
        Employee emp = new Employee("E002", "Alex", "Housekeeping", 15.0);
        // simulate 38 hours
        emp.punchIn(9.0); emp.punchOut(19.0); // 10
        emp.punchIn(8.0); emp.punchOut(16.0); // 8
        emp.punchIn(10.0); emp.punchOut(16.0); // 6
        emp.punchIn(7.0); emp.punchOut(11.0); // 4
        emp.punchIn(8.0); emp.punchOut(10.0); // 2

        // 30 total so far
        emp.punchIn(10.0); emp.punchOut(20.0); // +10 => 40 total

        assertEquals(40.0, emp.getRegularHours(), 0.01);
        assertEquals(0.0, emp.getOvertimeHours(), 0.01);
        assertEquals(600.0, emp.getTotalPay(), 0.01);
    }

    @Test
    public void testOvertimeIncluded() {
        Employee emp = new Employee("E003", "Sam", "Kitchen", 18.0);

        emp.punchIn(8.0);
        emp.punchOut(22.0); // 14 hours
        emp.punchIn(8.0);
        emp.punchOut(20.0); // 12 hours
        emp.punchIn(10.0);
        emp.punchOut(18.0); // 8 hours
        emp.punchIn(10.0);
        emp.punchOut(18.0); // 8 hours => total: 42 hours

        assertEquals(40.0, emp.getRegularHours(), 0.01);
        assertEquals(2.0, emp.getOvertimeHours(), 0.01);
        assertEquals((40 * 18) + (2 * 18 * 1.5), emp.getTotalPay(), 0.01);
    }
}
