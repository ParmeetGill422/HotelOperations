public class Room {
    private int roomNumber;
    private boolean occupied;
    private boolean dirty;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.occupied = false;
        this.dirty = false;
    }

    public void checkIn() {
        if (!occupied && !dirty) {
            occupied = true;
            dirty = true;
        }
    }

    public void checkOut() {
        occupied = false;
    }

    public void cleanRoom() {
        if (!occupied) {
            dirty = false;
        }
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
