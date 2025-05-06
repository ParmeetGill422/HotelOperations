import java.util.Scanner;

public class Main {
    private static final String EMPLOYEE_PIN = "5577";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Hotel Operations Menu ===");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Employee Access (PIN Required)");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleReservation(scanner);
                    break;
                case "2":
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    if (pin.equals(EMPLOYEE_PIN)) {
                        employeeMenu(scanner);
                    } else {
                        System.out.println("Access Denied. Incorrect PIN.");
                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void employeeMenu(Scanner scanner) {
        boolean inEmployeeMenu = true;
        while (inEmployeeMenu) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Create Room and Check Availability");
            System.out.println("2. Calculate Employee Pay");
            System.out.println("0. Return to Main Menu");
            System.out.print("Select an option: ");
            String empChoice = scanner.nextLine();

            switch (empChoice) {
                case "1":
                    handleCreateRoom(scanner);
                    break;
                case "2":
                    handleEmployeePay(scanner);
                    break;
                case "0":
                    inEmployeeMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void handleReservation(Scanner scanner) {
        System.out.print("Enter room type (king/double): ");
        String type = scanner.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = Integer.parseInt(scanner.nextLine());

        System.out.print("Is it a weekend stay? (true/false): ");
        boolean weekend = Boolean.parseBoolean(scanner.nextLine());

        Reservation res = new Reservation(type, nights, weekend);
        System.out.printf("Reservation total: $%.2f\n", res.getReservationtotal());
    }

    private static void handleCreateRoom(Scanner scanner) {
        System.out.print("Enter number of beds: ");
        int beds = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Is the room occupied? (true/false): ");
        boolean occupied = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Is the room dirty? (true/false): ");
        boolean dirty = Boolean.parseBoolean(scanner.nextLine());

        Room room = new Room(beds, price, occupied, dirty);
        System.out.println("Room Available: " + room.isAvailable());
    }

    private static void handleEmployeePay(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter hourly pay rate: ");
        double payRate = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter total hours worked: ");
        double hours = Double.parseDouble(scanner.nextLine());

        Employee emp = new Employee(id, name, dept, payRate, hours);
        System.out.printf("Total pay for %s: $%.2f\n", name, emp.getTotalPay());
    }
}