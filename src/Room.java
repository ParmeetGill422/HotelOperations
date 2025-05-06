public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public void checkIn() {
        if (isAvailable()) {
            occupied = true;
            dirty = true;
            System.out.println("Guest checked in.");
        } else {
            System.out.println("Room not available for check-in.");
        }
    }

    public void checkOut() {
        if (occupied) {
            occupied = false;
            System.out.println("Guest checked out. Room needs cleaning.");
        } else {
            System.out.println("Room is not occupied.");
        }
    }

    public void cleanRoom() {
        if (!occupied && dirty) {
            dirty = false;
            System.out.println("Room cleaned.");
        } else if (occupied) {
            System.out.println("Room is occupied. Cannot clean now.");
        } else {
            System.out.println("Room is already clean.");
        }
    }
}
