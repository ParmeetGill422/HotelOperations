public class Reservation {
    public String roomType;
    public int numberOfnights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfnights, boolean isWeekend){
        this.roomType = roomType;
        this.numberOfnights = numberOfnights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfnights() {
        return numberOfnights;
    }

    public void setNumberOfnights(int numberOfnights) {
        this.numberOfnights = numberOfnights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
    public double getPrice(){
        double basePrice = 0;
        if (roomType.equals("king")){
            basePrice = 139.00;
        }else if (roomType.equals("double")){
            basePrice = 124.00;
        }
        if (isWeekend){
            basePrice *= 1.10;
        }
        return basePrice;
    }
    public double getReservationtotal(){
        return getPrice() * numberOfnights;
    }
}
