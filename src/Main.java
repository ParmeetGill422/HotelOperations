import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static void employeeMenu(Scanner scanner, Map<String, Employee> employeeMap) {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== Employee Menu ===");
            System.out.println("1. Punch In (auto time)");
            System.out.println("2. Punch Out (auto time)");
            System.out.println("3. Manual Punch In/Out");
            System.out.println("4. View Hours & Pay");
            System.out.println("0. Return to Main Menu");
            System.out.print("Select: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                    System.out.print("Enter your employee ID: ");
                    String empId = scanner.nextLine();
                    Employee emp = employeeMap.get(empId);
                    if (emp == null) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter department: ");
                        String dept = scanner.nextLine();
                        System.out.print("Enter hourly rate: ");
                        double rate = Double.parseDouble(scanner.nextLine());
                        emp = new Employee(empId, name, dept, rate);
                        employeeMap.put(empId, emp);
                        System.out.println("New employee added.");
                    }

                    switch (choice) {
                        case "1":
                            emp.punchIn();
                            break;
                        case "2":
                            emp.punchOut();
                            break;
                        case "3":
                            System.out.print("Is this a punch in or out? (in/out): ");
                            String action = scanner.nextLine().toLowerCase();

                            System.out.print("Enter time (e.g., 9.5 for 9:30am): ");
                            double time = Double.parseDouble(scanner.nextLine());

                            if (action.equals("in")) {
                                emp.punchIn(time);
                            } else if (action.equals("out")) {
                                emp.punchOut(time);
                            } else {
                                System.out.println("Invalid input. Please type 'in' or 'out'.");
                            }
                            break;
                        case "4":
                            System.out.println("Employee ID: " + empId);
                            System.out.println("Regular Hours: " + emp.getRegularHours());
                            System.out.println("Overtime Hours: " + emp.getOvertimeHours());
                            System.out.println("Total Pay: $" + String.format("%.2f", emp.getTotalPay()));
                            break;
                    }
                    break;

                case "0":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("TruGait Inn", 3, 5);
        FrontDesk frontDesk = new FrontDesk(hotel);
        Restaurant restaurant = new Restaurant();
        Map<String, Employee> employeeMap = new HashMap<>();
        final String EMPLOYEE_PIN = "5577";

        boolean running = true;
        while (running) {
            System.out.println("\n=== Hotel Menu ===");
            System.out.println("1. Check In");
            System.out.println("2. Add Room Service Charge");
            System.out.println("3. Make Guest Request");
            System.out.println("4. Order Food (Restaurant)");
            System.out.println("5. Check Out");
            System.out.println("6. Show All Requests");
            System.out.println("7. Employee Access (PIN Required)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Room type (king/double): ");
                    String type = scanner.nextLine();
                    System.out.print("Nights: ");
                    int nights = Integer.parseInt(scanner.nextLine());
                    System.out.print("Weekend stay? (true/false): ");
                    boolean weekend = Boolean.parseBoolean(scanner.nextLine());
                    frontDesk.checkInGuest(name, type, nights, weekend);
                    break;

                case "2":
                    System.out.print("Room number: ");
                    int roomCharge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Charge amount: ");
                    double charge = Double.parseDouble(scanner.nextLine());
                    frontDesk.addRoomCharge(roomCharge, charge);
                    break;

                case "3":
                    System.out.print("Room number: ");
                    int roomReq = Integer.parseInt(scanner.nextLine());
                    System.out.print("Request: ");
                    String req = scanner.nextLine();
                    frontDesk.requestService(roomReq, req);
                    break;

                case "4":
                    System.out.print("Room number: ");
                    int mealRoom = Integer.parseInt(scanner.nextLine());
                    System.out.print("Meal name: ");
                    String meal = scanner.nextLine();
                    System.out.print("Meal price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    restaurant.orderMeal(mealRoom, meal, price, frontDesk);
                    break;

                case "5":
                    System.out.print("Room number: ");
                    int checkoutRoom = Integer.parseInt(scanner.nextLine());
                    frontDesk.checkOutGuest(checkoutRoom);
                    break;

                case "6":
                    frontDesk.showServiceRequests();
                    break;

                case "7":
                    System.out.print("Enter employee PIN: ");
                    String pin = scanner.nextLine();
                    if (pin.equals(EMPLOYEE_PIN)) {
                        employeeMenu(scanner, employeeMap);
                    } else {
                        System.out.println("Access Denied: Incorrect PIN.");
                    }
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
