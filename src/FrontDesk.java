import java.util.*;

public class FrontDesk {
    private Hotel hotel;
    private Map<Integer, Guest> guestMap = new HashMap<>();
    private List<String> serviceLog = new ArrayList<>();

    public FrontDesk(Hotel hotel) {
        this.hotel = hotel;
    }

    public void checkInGuest(String name, String roomType, int nights, boolean isWeekend) {
        Room room = hotel.assignAvailableRoom();
        if (room != null) {
            Reservation reservation = new Reservation(roomType, nights, isWeekend);
            Guest guest = new Guest(name, room, reservation);
            guestMap.put(room.getRoomNumber(), guest);
            System.out.println("Check-in complete. Room: " + room.getRoomNumber());
        } else {
            System.out.println("Sorry, no available rooms.");
        }
    }

    public void addRoomCharge(int roomNumber, double amount) {
        Guest guest = guestMap.get(roomNumber);
        if (guest != null) {
            guest.addCharge(amount);
        } else {
            System.out.println("No guest found in room " + roomNumber);
        }
    }

    public void requestService(int roomNumber, String requestType) {
        if (guestMap.containsKey(roomNumber)) {
            String log = "Room " + roomNumber + ": " + requestType;
            serviceLog.add(log);
            System.out.println("Request logged: " + log);
        } else {
            System.out.println("No guest in room " + roomNumber);
        }
    }

    public void checkOutGuest(int roomNumber) {
        Guest guest = guestMap.remove(roomNumber);
        if (guest != null) {
            System.out.println("Checkout receipt:\n" + guest.getReceipt());
            hotel.notifyRoomCheckout(roomNumber);
        } else {
            System.out.println("Room not found.");
        }
    }

    public void showServiceRequests() {
        System.out.println("\n--- Guest Requests ---");
        for (String log : serviceLog) {
            System.out.println(log);
        }
    }
}
