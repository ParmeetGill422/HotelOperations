public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double punchInTime = null;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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

    public void punchTimeCard(double time) {
        if (punchInTime == null) {
            punchInTime = time;
            System.out.printf("%s punched in at %.2f\n", name, time);
        } else {
            double worked = time - punchInTime;
            hoursWorked += worked;
            System.out.printf("%s punched out at %.2f, worked %.2f hours.\n", name, time, worked);
            punchInTime = null;
        }
    }
}
