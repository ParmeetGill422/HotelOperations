public class Room {
    private int numberOfbeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfbeds, double price, boolean occupied, boolean dirty){
        this.numberOfbeds = numberOfbeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }
    public int getNumberOfbeds() {
        return numberOfbeds;
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
    public boolean isAvailable(){
        return !occupied && !dirty;
    }
}
