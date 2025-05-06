import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testManualPunchInOut() {
        Employee emp = new Employee("E001", "Parmeet", "Front Desk", 20.0, 0);
        emp.punchIn(10.0);
        emp.punchOut(14.0); // 4 hours
        assertEquals(4.0, emp.getRegularHours(), 0.01);
        assertEquals(80.0, emp.getTotalPay(), 0.01);
    }

    @Test
    public void testOvertimePayCalculation() {
        Employee emp = new Employee("E002", "Alex", "Housekeeping", 15.0, 38);
        emp.punchIn(9.0);
        emp.punchOut(13.0); // 4 hours, now 42 total
        assertEquals(40.0, emp.getRegularHours(), 0.01);
        assertEquals(2.0, emp.getOvertimeHours(), 0.01);
        assertEquals(40 * 15 + 2 * 15 * 1.5, emp.getTotalPay(), 0.01);
    }
}
