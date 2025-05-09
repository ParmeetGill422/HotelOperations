import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double punchInTime = null;

    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // Manual time entry
    public void punchIn(double time) {
        punchInTime = time;
        System.out.printf("%s manually punched in at %.2f\n", name, time);
    }

    public void punchOut(double time) {
        if (punchInTime != null) {
            double worked = time - punchInTime;
            hoursWorked += worked;
            System.out.printf("%s manually punched out at %.2f, worked %.2f hours\n", name, time, worked);
            punchInTime = null;
        } else {
            System.out.println("No punch-in found.");
        }
    }

    // Auto time
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        punchInTime = now.getHour() + now.getMinute() / 60.0;
        System.out.println(name + " auto punched in at " + String.format("%.2f", punchInTime));
    }

    public void punchOut() {
        if (punchInTime != null) {
            LocalDateTime now = LocalDateTime.now();
            double punchOutTime = now.getHour() + now.getMinute() / 60.0;
            double worked = punchOutTime - punchInTime;
            hoursWorked += worked;
            System.out.println(name + " auto punched out at " + String.format("%.2f", punchOutTime)
                    + ", worked " + String.format("%.2f", worked) + " hours.");
            punchInTime = null;
        } else {
            System.out.println("No punch-in found.");
        }
    }

    public void punchTimeCard(double time) {
        if (punchInTime == null) {
            punchIn(time);
        } else {
            punchOut(time);
        }
    }
}
