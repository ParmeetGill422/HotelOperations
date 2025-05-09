public class Guest {
    private String name;
    private Room room;
    private double otherCharges = 0.0;
    private Reservation reservation;

    public Guest(String name, Room room, Reservation reservation) {
        this.name = name;
        this.room = room;
        this.reservation = reservation;
    }

    public void addCharge(double amount) {
        otherCharges += amount;
    }

    public double getTotalBill() {
        return reservation.getTotal() + otherCharges;
    }

    public String getReceipt() {
        return "Guest: " + name +
                "\nRoom: " + room.getRoomNumber() +
                "\nRoom Charges: $" + String.format("%.2f", reservation.getTotal()) +
                "\nOther Charges: $" + String.format("%.2f", otherCharges) +
                "\nTotal: $" + String.format("%.2f", getTotalBill());
    }

    public int getRoomNumber() {
        return room.getRoomNumber();
    }
}
