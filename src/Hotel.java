import java.util.*;

public class Hotel {
    private String name;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String name, int suiteCount, int basicCount) {
        int roomNumber = 100;
        for (int i = 0; i < suiteCount; i++) {
            rooms.add(new Room(roomNumber++)); // suites
        }
        for (int i = 0; i < basicCount; i++) {
            rooms.add(new Room(roomNumber++)); // basic
        }
    }

    public Room assignAvailableRoom() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.checkIn();
                return room;
            }
        }
        return null;
    }

    public void notifyRoomCheckout(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.checkOut();
                System.out.println("Housekeeping notified: Room " + roomNumber + " needs cleaning.");
                return;
            }
        }
    }
}
