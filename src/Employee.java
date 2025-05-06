public class Employee {
    private String employeeID;
    private String name;
    private String department;
    private double payrate;
    private double hoursWorked;

    Employee(String employeeID, String name, String department, double payrate, double hoursWorked){
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payrate = payrate;
        this.hoursWorked = hoursWorked;
    }
    public double getRegularhours(){
        return Math.min(hoursWorked, 40);
    }
    private double getOverTimeHours(){
        return Math.min(hoursWorked, 40);
    }
    double getTotalPay(){
        return (getRegularhours() * payrate) + (getOverTimeHours() * payrate * 1.5);
    }
}
