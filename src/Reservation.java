public class Reservation {
    private String roomType; // king or double
    private int nights;
    private boolean isWeekend;

    public Reservation(String roomType, int nights, boolean isWeekend) {
        this.roomType = roomType.toLowerCase();
        this.nights = nights;
        this.isWeekend = isWeekend;
    }

    public double getPricePerNight() {
        double base = roomType.equals("king") ? 139.0 : 124.0;
        return isWeekend ? base * 1.10 : base;
    }

    public double getTotal() {
        return getPricePerNight() * nights;
    }
}
